package goodcode.cache;

import goodcode.entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * リスト8.3	毎回データベースに問い合わせているコード
 * このコードはサンプルですので、実行はできません。
 * 
 * @author agata
 *
 */
@Controller
public class ListController {
	@Autowired
	public ItemRepository itemRepository;

	public String index() {
		return "index";
	}

	// コード中から何度か呼ばれる可能性があるメソッド
	public List<Item> getItems() {
		// データベースアクセス！
		return itemRepository.findAll();
	}

}
