『良いコードを書く技術』サンプルコード

■書籍について
縣 俊貴 著
『良いコードを書く技術 ── 読みやすく保守しやすいプログラミング作法』
（WEB+DB PRESS plus シリーズ）
技術評論社、2011年

・サポートページ
http://gihyo.jp/book/2011/978-4-7741-4596-9/support

・WEB+DB PRESS plusシリーズ
http://wdpress.gihyo.jp/plus

・公式タグ
goodcode

■サンプルコードのライセンスについて
サンプルコードはパブリックドメインですので、仕事や趣味のプログラムに自由にご利用ください。

■セットアップ
■■Maven2のセットアップ
サンプルコードの実行にはMaven 2が必要です。
Maven 2のサイト（http://maven.apache.org/）からmaven-3.x.x-bin.zipをダウンロードして展開し、maven-3.x.xフォルダを適当な場所に設置します。次に、設置したMaven 2のbinフォルダ（例：C:\maven-3.0.3\bin）を環境変数PATHに追加します。必要な設定は以上です。

ターミナルかコマンドプロンプトから次のコマンド実行してください。 

mvn --version

「--version」はMaven 2のバージョンを表示するオプションです。「Maven version: 3.x.x」と表示されたら問題なくインストールが完了しています。 

■サンプルコードの構成
■■プロジェクト
サンプルコードは、次のディレクトリごとに、Maven 2のプロジェクトとして格納されています。

[goodcode05] 5章 コードの分割
[goodcode06] 6章 コードの集約
[goodcode07] 7章 パフォーマンス
[goodcode08] 8章 ユニットテスト
[goodcode09] 9章 抽象化
[goodcode10] 10章 メタプログラミング
[goodcode11-step1] 11章 フレームワークを作ろう ステップ1
[goodcode11-step2] 11章 フレームワークを作ろう ステップ2
[goodcode11-step3] 11章 フレームワークを作ろう ステップ3
[goodcode11-step4] 11章 フレームワークを作ろう ステップ4
[goodcode11-packaging-framework] 11章 フレームワークを作ろう ステップ5 フレームワーク
[goodcode11-packaging-application] 11章 フレームワークを作ろう ステップ5 アプリケーション

■■各プロジェクトの構成
各プロジェクトの構成はMaven 2の標準ディレクトリ構成に従っています。
基本的に次のディレクトリにそれぞれのファイルが配置されています。

[src]
  [main]
    [java]       メインのソースファイル
    [resources]  メインのリソースファイル
    [webapp]     Webアプリケーションのリソース(JSP、CSS、JavaScript、web.xmlなど)
  [test]
    [java]       テストのJavaソースファイル
    [resources]  テストのリソースファイル
pom.xml          Maven2の設定ファイル

■コードの実行
■■第5章  コードの分割
1.コマンドプロンプト（Windows）かターミナル（Linux/Mac OS X）で、「goodcode05」ディレクトリに移動します。

2.次のコマンドを実行します。

mvn clean package tomcat:run

3.「http://localhost:8080/goodcode05/」にブラウザでアクセスします。

■■第6章  コードの集約
本章のコードは説明用のサンプルです。動作させることはできません。

■■第7章　コードのパフォーマンス
1.コマンドプロンプト（Windows）かターミナル（Linux/Mac OS X）で、「goodcode07」ディレクトリに移動します。

2.次のコマンドを実行します。

・リスト7.1	国別の出現数をカウントするコード（breakなし）の実行
mvn exec:java -Dexec.mainClass="goodcode.country.Main"

・リスト7.1	国別の出現数をカウントするコード（breakあり）の実行
mvn exec:java -Dexec.mainClass="goodcode.country.MainAfter"

・リスト7.2	ArrayListとLinkedListの実行
mvn exec:java -Dexec.mainClass="goodcode.list.Main"

■■第8章　ユニットテスト
1.コマンドプロンプト（Windows）かターミナル（Linux/Mac OS X）で、「goodcode08」ディレクトリに移動します。

2.次のコマンドを実行します。

・ユニットテストを使わないテストコードの実行
mvn exec:java -Dexec.mainClass="goodcode.calc.Main"

・ユニットテストを使ったテストコードの実行
mvn test -Dtest="goodcode.calc.CalcTest"

・お題　Webアプリケーションのセキュリティテストのテストコードの実行
mvn test -Dtest="goodcode.action.TodoActionTest"

・お題　Webアプリケーションのセキュリティテストのアプリケーションの実行
mvn clean package tomcat:run
その後「http://localhost:8080/goodcode08/」にブラウザでアクセスします。

・考察　テストしにくい部分はどうする？　モックオブジェクト
mvn test -Dtest="goodcode.action.TimelineActionTest"

■■第9章　抽象化
1.コマンドプロンプト（Windows）かターミナル（Linux/Mac OS X）で、「goodcode09」ディレクトリに移動します。

2.次のコマンドを実行します。

mvn clean package tomcat:run

■■第10章　メタプログラミング
1.コマンドプロンプト（Windows）かターミナル（Linux/Mac OS X）で、「goodcode10」ディレクトリに移動します。

2.次のコマンドを実行します。

・ステップ1　ベタなコードで書いてみる
mvn exec:java -Dexec.mainClass="goodcode.step1.Main"

・ステップ2　メタデータをExcelに移動する
mvn exec:java -Dexec.mainClass="goodcode.step2.Main"

・ステップ3　リフレクションAPIで変換ルールを動的に適用する
mvn exec:java -Dexec.mainClass="goodcode.step3.Main"

・考察 変換ルールに引数を追加したい場合は？
　式言語やスクリプト言語を利用する(JavaScriptを利用したサンプル)
mvn exec:java -Dexec.mainClass="goodcode.script.Main"

・考察 DSLの構文を改善するには？
　変換ルールに短い別名を付ける
mvn exec:java -Dexec.mainClass="goodcode.mapping.Main"

■■第11章　フレームワークを作ろう
■■■ステップ1〜ステップ4までを実行
1.コマンドプロンプト（Windows）かターミナル（Linux/Mac OS X）で、「goodcode11-step1」〜「Goodcode11-step4」ディレクトリに移動します。

2.次のコマンドを実行します。

mvn clean package tomcat:run

3.「http://localhost:8080/goodcode11/」にブラウザでアクセスします。

■■■ステップ5 フレームワークをパッケージングする
1.コマンドプロンプト（Windows）かターミナル（Linux/Mac OS X）で、「goodcode11-packaging-framework」ディレクトリに移動します。

2.次のコマンドを実行します。

mvn clean install

フレームワークのJARファイルがMavenのローカルリポジトリにインストールされます。

3.コマンドプロンプト（Windows）かターミナル（Linux/Mac OS X）で、「goodcode11-packaging-application」ディレクトリに移動します。

4.次のコマンドを実行します。

mvn clean package tomcat:run

5.「http://localhost:8080/goodcode11/」にブラウザでアクセスします。
