package goodcode.controllers.step3;

import goodcode.entity.Division;
import goodcode.entity.User;
import goodcode.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.util.List;

@Controller
public class XmlApiController {
    @Autowired
    public UserService userService;

    @RequestMapping("/api/3")
    public void index(HttpServletResponse response) throws Exception {
        var divs = userService.getDivisions();
        var users = userService.getUsers();
        var doc = buildDocument(divs, users);
        writeDocument(response, doc);
    }

    private Document buildDocument(List<Division> divs, List<User> users)
    		throws ParserConfigurationException {
        var rowIndex = 1;

        // (1)XMLを作成するためにDocumentオブジェクトを準備
        var doc = newDocument();

        // (2)ルート要素の追加
        var rootNode = doc.createElement("data");
        doc.appendChild(rootNode);

        // (3)組織要素の追加
        var divisionsNode = doc.createElement("divisions");
        for (var div: divs) {
            var node = doc.createElement("division");
            node.setAttribute("index", String.valueOf(rowIndex++));
            node.appendChild(createElement(doc, "id", div.getId()));
            node.appendChild(createElement(doc, "name", div.getName()));
            divisionsNode.appendChild(node);
        }
        rootNode.appendChild(divisionsNode);

        // (5)ユーザ要素の追加
        var usersNode = doc.createElement("users");
        for (var user : users) {
            var node = doc.createElement("user");
            node.setAttribute("index", String.valueOf(rowIndex++));
            node.appendChild(createElement(doc, "name", user.getName()));
            usersNode.appendChild(node);
        }
        rootNode.appendChild(usersNode);
        return doc;
    }

    private void writeDocument(HttpServletResponse response, Document doc) throws Exception {
	    // (6)DocumentオブジェクトをXML文字列へ変換
	    var transFactory = TransformerFactory.newInstance();
	    var transformer = transFactory.newTransformer();
	    var source = new DOMSource(doc);

	    // (7)レスポンスとしてXMLを出力
	    var result = new StreamResult(response.getOutputStream());
	    transformer.transform(source, result);
    }
    
    private Document newDocument() throws ParserConfigurationException {
        var factory = DocumentBuilderFactory.newInstance();
        var builder = factory.newDocumentBuilder();
        return builder.newDocument();
    }

    // 引数に特定の情報が含まれていないので汎用的！
    private Element createElement(
            Document doc, String nodeName, String textContent) {
        var node = doc.createElement(nodeName);
        node.setTextContent(textContent);
        return node;
    }
}
