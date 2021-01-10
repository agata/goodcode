package goodcode.controllers.step1;

import goodcode.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

@Controller
public class XmlApiController {
    @Autowired
    public UserService userService;

    @RequestMapping("/api/1")
    public void index(HttpServletResponse response) throws Exception {
        var divs = userService.getDivisions();
        var users = userService.getUsers();

        // (1)XMLを作成するためにDocumentオブジェクトを準備
        var factory = DocumentBuilderFactory.newInstance();
        var builder = factory.newDocumentBuilder();
        var doc = builder.newDocument();

        // (2)ルート要素の追加
        var rootNode = doc.createElement("data");
        doc.appendChild(rootNode);

        // (3)組織要素の追加
        var divisionsNode = doc.createElement("divisions");
        var rowIndex = 1;
        for (var div: divs) {
            var node = doc.createElement("division");
            node.setAttribute("index", String.valueOf(rowIndex++));

            var idNode = doc.createElement("id");
            idNode.setTextContent(div.getId());
            node.appendChild(idNode);

            var nameNode = doc.createElement("name");
            nameNode.setTextContent(div.getName());
            node.appendChild(nameNode);
            divisionsNode.appendChild(node);
        }
        rootNode.appendChild(divisionsNode);

        // (5)ユーザ要素の追加
        var usersNode = doc.createElement("users");
        for (var user : users) {
            var node = doc.createElement("user");
            node.setAttribute("index", String.valueOf(rowIndex++));

           var nameNode = doc.createElement("name");
           nameNode.setTextContent(user.getName());
           node.appendChild(nameNode);
           usersNode.appendChild(node);
        }
        rootNode.appendChild(usersNode);

        // (6)DocumentオブジェクトをXML文字列へ変換
        var transFactory = TransformerFactory.newInstance();
        var transformer = transFactory.newTransformer();
        var source = new DOMSource(doc);

        // (7)レスポンスとしてXMLを出力
        var result = new StreamResult(response.getOutputStream());
        transformer.transform(source, result);
    }
}
