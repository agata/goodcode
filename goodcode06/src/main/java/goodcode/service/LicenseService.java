package goodcode.service;

import org.springframework.stereotype.Service;

@Service
public class LicenseService {
    // 指定されたユーザがItemを生成できるか？
    public boolean canCreateItem(Integer accountId) {
        // データベースアクセスを行ったりして判定する処理が入る
    	// ...
    	return true;
    }
}
