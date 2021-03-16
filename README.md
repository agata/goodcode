『良いコードを書く技術』サンプルコード

# 書籍について

縣 俊貴 著<br>
『［増補改訂］良いコードを書く技術 ── 読みやすく保守しやすいプログラミング作法』<br>
（WEB+DB PRESS plus シリーズ）<br>
技術評論社、2021年

* サポートページ<br>
  http://gihyo.jp/book/2011/978-4-7741-4596-9/support

* WEB+DB PRESS plusシリーズ<br>
  http://wdpress.gihyo.jp/plus

* 公式タグ<br>
  goodcode

# 初版のサンプルコードについて

このサンプルコードは増補改訂版のものです。初版のサンプルコードは以下にあります。

https://github.com/agata/goodcode/tree/v1

# サンプルコードのライセンスについて

サンプルコードはパブリックドメインですので、仕事や趣味のプログラムに自由にご利用ください。

# セットアップ

## Java 15のセットアップ

サンプルコードの実行にはJava 15が必要です。https://jdk.java.net/15/ よりJava 15をダウンロードしてインストールをしてください。

インストール後以下のコマンドでJavaのバージョンが15と表示されればインストール成功です。

```
java --version
```

## nodeのセットアップ

7章のサンプルコードの実行のみnodeの環境が必要です。https://nodejs.org/ja/download/ よりnodeのバージョン14系をダウンロードしてインストールをしてください。

インストール後以下のコマンドでnodeのバージョンが表示されればインストール成功です。

```
node -v
```

# サンプルコードの構成

## プロジェクト

サンプルコードは、次のディレクトリごとに、Gradleのプロジェクトとして格納されています。Gradleの実行ファイルは各ディレクトリに配置されているためインストールは不要です。

* `goodcode05` 5章 コードの分割
* `goodcode06` 6章 コードの集約
* `goodcode07` 7章 データ構造
* `goodcode08` 8章 パフォーマンス
* `goodcode09` 9章 ユニットテスト
* `goodcode10` 10章 抽象化
* `goodcode11` 11章 メタプログラミング
* `goodcode12-step1` 12章 フレームワークを作ろう ステップ1
* `goodcode12-step2` 12章 フレームワークを作ろう ステップ2
* `goodcode12-step3` 12章 フレームワークを作ろう ステップ3
* `goodcode12-step4` 12章 フレームワークを作ろう ステップ4
* `goodcode12-packaging-framework` 12章 フレームワークを作ろう ステップ5 フレームワーク
* `goodcode12-packaging-application` 12章 フレームワークを作ろう ステップ5 アプリケーション
* `goodcode12-refrect-api` 12章 Column：JavaのリフレクションAPI

## 各プロジェクトの構成

各プロジェクトの構成はGradleの標準ディレクトリ構成に従っています。
基本的に次のディレクトリにそれぞれのファイルが配置されています。

* `src`
  * `main`
    * `java`       メインのソースファイル
    * `resources`  メインのリソースファイル
    * `webapp`     Webアプリケーションのリソース(JSP、CSS、JavaScript、web.xmlなど)
  * `test`
    * `java`       テストのJavaソースファイル
    * `resources`  テストのリソースファイル
* `build.gradle`     Gradleの設定ファイル

# コードの実行

## 第5章  コードの分割

1. コマンドプロンプト（Windows）かターミナル（Linux/Mac OS X）で、`goodcode05` ディレクトリに移動します。
2. 次のコマンドを実行します。

```
./gradlew bootRun
```

3. http://localhost:8080/goodcode05/ にブラウザでアクセスします。

## 第6章  コードの集約

本章のコードは説明用のサンプルです。動作させることはできません。

## 第7章  データ構造

1.コマンドプロンプト（Windows）かターミナル（Linux/Mac OS X）で、`goodcode07` ディレクトリに移動します。

2. 次のコマンドを実行します。

**ステップ1　データベースのデータ構造をそのまま利用する**

```
npm run step1
```

**ステップ3　最適なデータ構造に変換して利用する**

```
npm run step3
```

## 第8章　コードのパフォーマンス

1. コマンドプロンプト（Windows）かターミナル（Linux/Mac OS X）で、`goodcode08`ディレクトリに移動します。

2.次のコマンドを実行します。

**リスト8.1	国別の出現数をカウントするコード（breakなし）の実行**

```
./gradlew country
```

**リスト8.1	国別の出現数をカウントするコード（breakあり）の実行**

```
./gradlew countryAfter
```

**リスト8.2	ArrayListとLinkedListの実行**

```
./gradlew list
```

## 第9章　ユニットテスト

1.コマンドプロンプト（Windows）かターミナル（Linux/Mac OS X）で、`goodcode09` ディレクトリに移動します。

2.次のコマンドを実行します。

**ユニットテストを使わないテストコードの実行**

```
./gradlew calc
```

**ユニットテストを使ったテストコードの実行**

```
./gradlew test --tests goodcode.calc.CalcTest
```

**お題　Webアプリケーションのセキュリティテストのテストコードの実行**

```
./gradlew test --tests goodcode.controllers.TodoControllerTest
```

**お題　Webアプリケーションのセキュリティテストのアプリケーションの実行**

```
./gradlew bootRun
```

その後 http://localhost:8080/goodcode09/ にブラウザでアクセスします。

**考察　テストしにくい部分はどうする？　モックオブジェクト**

```
./gradlew test --tests goodcode.controllers.TimelineControllerTest
```

## 第10章　抽象化

1. コマンドプロンプト（Windows）かターミナル（Linux/Mac OS X）で、`goodcode10`ディレクトリに移動します。

2. 次のコマンドを実行します。

```
./gradlew bootRun
```

3. http://localhost:8080/ にブラウザでアクセスします。

## 第11章　メタプログラミング

1.コマンドプロンプト（Windows）かターミナル（Linux/Mac OS X）で、`goodcode11` ディレクトリに移動します。

2. 次のコマンドを実行します。

**ステップ1　ベタなコードで書いてみる**

```
./gradlew step1
```

**ステップ2　メタデータをExcelに移動する**

```
./gradlew step2
```

**ステップ3　リフレクションAPIで変換ルールを動的に適用する**

```
./gradlew step3
```

**考察 DSLの構文を改善するには？もっとDSLっぽくする**

```
./gradlew advanced
```

## 第12章　フレームワークを作ろう

### ステップ1〜ステップ4までを実行

1. コマンドプロンプト（Windows）かターミナル（Linux/Mac OS X）で、`goodcode11-step1` 〜 `goodcode11-step4` ディレクトリに移動します。

2. 次のコマンドを実行します。

```
./gradlew appRun
```

3. http://localhost:8080/goodcode12/ にブラウザでアクセスします。

### ステップ5 フレームワークをパッケージングする

#### 1. フレームワークのJARファイルを生成

```
./gradlew clean jar
```

`buid/libs/goodcode12-0.0.1-SNAPSHOT.jar` にJARファイルが生成されます。

#### 2. 生成したJARファイルを使ってアプリケーションコードを実行

JARファイルが生成できたら以下のようにアプリケーションコードのディレクトリに移動して実行します。アプリケーションコード側の`build.gradle`にはさきほど生成したJARファイルに対して依存が追加されています。

```
cd ../goodcode12-packaging-application/
./gradlew appRun
```

その後 http://localhost:8080/goodcode12/ をブラウザで開きます。

### Column：JavaのリフレクションAPI

1. コマンドプロンプト（Windows）かターミナル（Linux/Mac OS X）で、`goodcode12-refrect-api`ディレクトリに移動します。

2. 次のコマンドを実行します。

```
./gradlew refrect
```
