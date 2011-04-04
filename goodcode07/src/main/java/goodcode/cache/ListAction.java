package goodcode.cache;

import goodcode.entity.Item;

import java.util.List;

import org.seasar.cubby.action.ActionResult;
import org.seasar.cubby.action.Forward;
import org.seasar.extension.jdbc.JdbcManager;

/**
 * リスト7.3	毎回データベースに問い合わせているコード
 * このコードはサンプルですので、実行はできません。
 * 
 * @author agata
 *
 */
public class ListAction extends Action {
	public JdbcManager jdbcManager;

	public ActionResult index() {
		return new Forward("index.jsp");
	}

	// JSP中から何度か呼ばれる可能性があるメソッド
	public List<Item> getItems() {
		// データベースアクセス！
		return jdbcManager.from(Item.class).getResultList();
	}

}
