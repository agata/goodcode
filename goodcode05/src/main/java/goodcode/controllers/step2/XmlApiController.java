package goodcode.controllers.step2;

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

    @RequestMapping("/api/2")
    public void index(HttpServletResponse response) throws Exception {
        List<Division> divs = userService.getDivisions();
        List<User> users = userService.getUsers();
        int rowIndex = 1;
        // (1)XMLを作成するためにDocumentオブジェクトを準備
        Document doc = newDocument();
        // (2)ルート要素の追加
        Element rootNode = doc.createElement("data");
        doc.appendChild(rootNode);
        // (3)組織要素の追加
        Element divisionsNode = doc.createElement("divisions");
        for (Division div: divs) {
            Element node = doc.createElement("division");
            node.setAttribute("index", String.valueOf(rowIndex++));
            node.appendChild(createElement(doc, "id", div.getId()));
            node.appendChild(createElement(doc, "name", div.getName()));
            divisionsNode.appendChild(node);
        }
        rootNode.appendChild(divisionsNode);
        // (5)ユーザ要素の追加
        Element usersNode = doc.createElement("users");
        for (User user : users) {
            Element node = doc.createElement("user");
            node.setAttribute("index", String.valueOf(rowIndex++));
            node.appendChild(createElement(doc, "name", user.getName()));
            usersNode.appendChild(node);
        }
        rootNode.appendChild(usersNode);
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

    private Document newDocument() throws ParserConfigurationException {
        DocumentBuilderFactory factory = 
            DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        return builder.newDocument();
    }
    // 引数に特定の情報が含まれていないので汎用的！
    private Element createElement(
            Document doc, String nodeName, String textContent) {
        Element node = doc.createElement(nodeName);
        node.setTextContent(textContent);
        return node;
    }
}
