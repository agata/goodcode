package goodcode.controllers.etc;

import goodcode.entity.Division;
import goodcode.entity.User;
import goodcode.service.UserService;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

@Controller
public class XmlApiController {
    @Autowired
    public UserService userService;

    @RequestMapping("/api/etc")
    public void index(HttpServletResponse response) throws Exception {
        List<Division> divs = userService.getDivisions();
        List<User> users = userService.getUsers();
        // XmlBuilderをnewして使用する
        XmlBuilder builder = new XmlBuilder(divs, users);
        Document doc = builder.buildDocument();
        writeDocument(response, doc);
    }

    private void writeDocument(HttpServletResponse response, Document doc) throws Exception {
	    // (6)DocumentオブジェクトをXML文字列へ変換
	    TransformerFactory transFactory =
	        TransformerFactory.newInstance();
	    Transformer transformer = transFactory.newTransformer();
	    DOMSource source = new DOMSource(doc);
	    // (7)レスポンスとしてXMLを出力
	    StreamResult result =
	        new StreamResult(response.getOutputStream());
	    transformer.transform(source, result);
    }
    
    // インナークラスで宣言！
    private static class XmlBuilder {
        private final List<Division> divs;
        private final List<User> users;
        private Document doc;
        private int rowIndex = 1;
        public XmlBuilder(List<Division> divs, List<User> users) {
            this.divs = divs;
            this.users = users;
        }
        private Document buildDocument() throws Exception {
            doc = newDocument();
            Element rootNode = doc.createElement("data");
            doc.appendChild(rootNode);
            rootNode.appendChild(createDivisionsNode());
            rootNode.appendChild(createUsersNode());
            return doc;
        }
        private Element createDivisionsNode() {
            Element divisionsNode = doc.createElement("divisions");
            for (Division div : divs) {
                Element node = doc.createElement("division");
                node.setAttribute("index", String.valueOf(rowIndex++));
                node.appendChild(createElement("id", div.getId()));
                node.appendChild(createElement("name", div.getName()));
                divisionsNode.appendChild(node);
            }
            return divisionsNode;
        } 
        private Element createUsersNode() {
            Element usersNode = doc.createElement("users");
            for (User user : users) {
                Element node = doc.createElement("user");
                node.setAttribute("index", String.valueOf(rowIndex++));
                node.appendChild(createElement("name", user.getName()));
                usersNode.appendChild(node);
            }
            return usersNode;
        }
        private Document newDocument() throws ParserConfigurationException {
            DocumentBuilderFactory factory = 
                DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            return builder.newDocument();
        }
        // 引数に特定の情報が含まれていないので汎用的！
        private Element createElement(
                String nodeName, String textContent) {
            Element node = doc.createElement(nodeName);
            node.setTextContent(textContent);
            return node;
        }
    }
}
