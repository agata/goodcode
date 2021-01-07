package goodcode.cache;

import goodcode.entity.Item;

import java.util.List;

import org.seasar.cubby.action.ActionResult;
import org.seasar.cubby.action.Forward;
import org.seasar.extension.jdbc.JdbcManager;

/**
 * リスト7.4 結果をキャッシュして2回目以降のデータベースアクセスを抑制
 * このコードはサンプルですので、実行はできません。
 * 
 * @author agata
 *
 */
public class ListActionAfter extends Action {
    public JdbcManager jdbcManager;
    private List<Item> items;
    public ActionResult index() {
        return new Forward("index.jsp");
    }

    // itemsがnullの場合のみデータベースから取得
    // それ以外なら取得済みのitemsを返却
    public List<Item> getItems() {
        if (items == null) {
            // 初回のみデータベースアクセス！
            items = jdbcManager.from(Item.class).getResultList();
        }
        return items;
    }

}
