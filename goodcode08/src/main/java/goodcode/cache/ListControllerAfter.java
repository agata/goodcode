package goodcode.cache;

import goodcode.entity.Item;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * リスト8.4 結果をキャッシュして2回目以降のデータベースアクセスを抑制
 * このコードはサンプルですので、実行はできません。
 * 
 * @author agata
 *
 */
@Controller
public class ListControllerAfter {
    @Autowired
    public ItemRepository itemRepository;

    private List<Item> items;

    public String index() {
        return "index";
    }

    // itemsがnullの場合のみデータベースから取得
    // それ以外なら取得済みのitemsを返却
    public List<Item> getItems() {
        if (items == null) {
            // 初回のみデータベースアクセス！
            items = itemRepository.findAll();
        }
        return items;
    }
}
