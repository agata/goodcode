package goodcode.refrect;

import java.lang.reflect.Method;

/**
 * Column：JavaのリフレクションAPI
 */
public class Main {
	public static void main(String[] args) throws Exception {
		var emp = new Employee(1, "田中一郎");
		String[] propNames = {"id", "name"};
		for (var propName : propNames) {
		    // プロパティ名をメソッド名に変換（name -> getName）
		    var methodName = "get" +
		        propName.substring(0, 1).toUpperCase() +
		        propName.substring(1);
		    // メソッド名からメソッドオブジェクトを取得
		    var m = emp.getClass().getMethod(methodName);
		    // メソッドを実行
		    var result = m.invoke(emp);
		    // 戻り値の値を出力
		    System.out.println(propName + "=" + result);
		}
	}
}
