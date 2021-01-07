package goodcode.twitter;

import org.springframework.stereotype.Component;

// (2)Twitter APIへアクセスする実装コード
@Component
public class TwitterAPIImpl implements TwitterAPI {
    //...（実際のTwitterへアクセスするコード）
	@Override
	public Tweet[] getTimeline() {
		return null;
	}
}
