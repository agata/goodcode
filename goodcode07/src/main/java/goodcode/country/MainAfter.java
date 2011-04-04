package goodcode.country;
/**
 * リスト7.1	国別の出現数をカウントするコード
 */
public class MainAfter {
    public static void main(String[] args) {
        // 国の一覧（5ヵ国）
        Country[] countries = new Country[] {
            new Country("JP", "日本"),
            new Country("US", "アメリカ"),
            new Country("FR", "フランス"),
            new Country("DE", "ドイツ"),
            new Country("UK", "イギリス"),
        };
        // 入力値（7件）
        String[] inputs = new String[] {
            "JP", "FR", "US", "FR", "UK", "DE", "US"};
        long t1 = System.currentTimeMillis();
        // breakなし
        for (int i = 0; i < 100000; i++) {
            for (String input : inputs) {
                for (Country country : countries) {
                    if (country.getCode().equals(input)) {
                        country.increment();
                        break;
                    }
                }
            }
        }
        long t2 = System.currentTimeMillis();
        System.out.println("time=" + (t2 - t1));
    }
    // 国ごとの集計
    static class Country {
        private final String code;
        private final String name;
        private int counter = 0;
        public Country(String code, String name) {
            this.code = code;
            this.name = name;
        }
        public String getCode() {
            return code;
        }
        public String getName() {
            return name;
        }
        public void increment() {
            counter++;
        }
        public int getCounter() {
            return counter;
        }
    }
}
