package goodcode.action.service;

import goodcode.service.LicenseService;


public class ItemAction extends BaseAction {
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
