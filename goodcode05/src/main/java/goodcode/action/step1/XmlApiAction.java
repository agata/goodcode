package goodcode.action.step1;

import goodcode.entity.Division;
import goodcode.entity.User;
import goodcode.service.UserService;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.seasar.cubby.action.Action;
import org.seasar.cubby.action.ActionResult;
import org.seasar.cubby.action.Direct;
import org.seasar.cubby.action.Path;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

@Path("api")
public class XmlApiAction extends Action {
    public HttpServletResponse response;
    public UserService userService;
    public ActionResult index() throws Exception {
        List<Division> divs = userService.getDivisions();
        List<User> users = userService.getUsers();
        // (1)XMLを作成するためにDocumentオブジェクトを準備
        DocumentBuilderFactory factory =
            DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.newDocument();
        // (2)ルート要素の追加
        Element rootNode = doc.createElement("data");
        doc.appendChild(rootNode);
        // (3)組織要素の追加
        Element divisionsNode = doc.createElement("divisions");
        int rowIndex = 1;
        for (Division div: divs) {
            Element node = doc.createElement("division");
            node.setAttribute("index", String.valueOf(rowIndex++));
            Element idNode = doc.createElement("id");
            idNode.setTextContent(div.getId());
            node.appendChild(idNode);
            Element nameNode = doc.createElement("name");
            nameNode.setTextContent(div.getName());
            node.appendChild(nameNode);
            divisionsNode.appendChild(node);
        }
        rootNode.appendChild(divisionsNode);
        // (5)ユーザ要素の追加
        Element usersNode = doc.createElement("users");
        for (User user : users) {
            Element node = doc.createElement("user");
            node.setAttribute("index", String.valueOf(rowIndex++));
           Element nameNode = doc.createElement("name");
           nameNode.setTextContent(user.getName());
            node.appendChild(nameNode);
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
        return new Direct();
    }
}
