package goodcode.controllers.service;

import goodcode.service.LicenseService;
import org.springframework.stereotype.Controller;

@Controller
public class ItemController extends BaseController {
	private LicenseService licenseService = new LicenseService();

	public void createItem() {
		// ライセンスチェックをサービスで行う
		if (!licenseService.canCreateItem(getAccountId())) {
			return;
		}
		// Itemを作成する処理
		// ...
	}

	private Integer getAccountId() {
		// 実際はログインしているユーザーのIDを返す
		return 1;
	}
}
