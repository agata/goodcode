# 『良いコードを書く技術』サンプルコード

## 本書籍について

縣 俊貴 著<br>
『［増補改訂］良いコードを書く技術 ── 読みやすく保守しやすいプログラミング作法』<br>
（WEB+DB PRESS plus シリーズ）<br>
技術評論社、2021年

* サポートページ<br>
  https://gihyo.jp/book/2021/978-4-297-12048-1

* WEB+DB PRESS plusシリーズ<br>
  https://wdpress.gihyo.jp/plus

## 初版のサンプルコード

このサンプルコードは増補改訂のものです。
初版のサンプルコードは以下にあります。

https://github.com/agata/goodcode/tree/v1

## サンプルコードのライセンス

サンプルコードはパブリックドメインですので、仕事や趣味のプログラムに自由にご利用ください。

## セットアップ

### Java 15のセットアップ

サンプルコードの実行にはJava 15が必要です。
[AdoptOpenJDK](https://adoptopenjdk.net/archive.html?variant=openjdk15&jvmVariant=hotspot) のページよりJava 15 JDKをダウンロードしてインストールしてください。

インストール後、以下のコマンドでJavaのバージョンが15と表示されればインストール成功です。

```bash
$ java --version
```

### nodeのセットアップ

第7章のサンプルコードの実行のみnodeの環境が必要です。
https://nodejs.org/ja/download/ よりnodeのバージョン14系をダウンロードしてインストールしてください。

インストール後、以下のコマンドでnodeのバージョンが表示されればインストール成功です。

```bash
$ node -v
```

## サンプルコードの構成

### プロジェクト

サンプルコードは、次のディレクトリごとに、Gradleのプロジェクトとして格納されています。
Gradleの実行ファイルは各ディレクトリに配置されているためインストールは不要です。

* `goodcode05` 第5章 コードの分割
* `goodcode06` 第6章 コードの集約
* `goodcode07` 第7章 データ構造
* `goodcode08` 第8章 パフォーマンス
* `goodcode09` 第9章 ユニットテスト
* `goodcode10` 第10章 抽象化
* `goodcode11` 第11章 メタプログラミング
* `goodcode12-step1` 第12章 フレームワークを作ろう ステップ1
* `goodcode12-step2` 第12章 フレームワークを作ろう ステップ2
* `goodcode12-step3` 第12章 フレームワークを作ろう ステップ3
* `goodcode12-step4` 第12章 フレームワークを作ろう ステップ4
* `goodcode12-packaging-framework` 第12章 フレームワークを作ろう ステップ5 フレームワーク
* `goodcode12-packaging-application` 第12章 フレームワークを作ろう ステップ5 アプリケーション
* `goodcode12-refrect-api` 第12章 Column：JavaのリフレクションAPI

### 各プロジェクトの構成

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
* `build.gradle`   Gradleの設定ファイル

## コードの実行

### 第5章  コードの分割

コマンドプロンプト（Windows）かターミナル（Linux/Mac OS X）で `goodcode05` ディレクトリに移動し、次のコマンドを実行します。

```bash
$ ./gradlew bootRun
```

http://localhost:8080/ にブラウザでアクセスします。

### 第6章  コードの集約

本章のコードは説明用のサンプルです。動作させることはできません。

### 第7章  データ構造

コマンドプロンプト（Windows）かターミナル（Linux/Mac OS X）で `goodcode07` ディレクトリに移動し、次のコマンドを実行します。

**ステップ1　データベースのデータ構造をそのまま利用する**

```bash
$ npm run step1
```

**ステップ3　最適なデータ構造に変換して利用する**

```bash
$ npm run step3
```

### 第8章　コードのパフォーマンス

コマンドプロンプト（Windows）かターミナル（Linux/Mac OS X）で `goodcode08` ディレクトリに移動し、次のコマンドを実行します。

**リスト8.1　国別の出現数をカウントするコード（breakなし）の実行**

```bash
$ ./gradlew country
```

**リスト8.1　国別の出現数をカウントするコード（breakあり）の実行**

```bash
$ ./gradlew countryAfter
```

**リスト8.2　ArrayListとLinkedListの実行**

```bash
$ ./gradlew list
```

### 第9章　ユニットテスト

コマンドプロンプト（Windows）かターミナル（Linux/Mac OS X）で `goodcode09` ディレクトリに移動し、次のコマンドを実行します。

**ユニットテストを使わないテストコードの実行**

```bash
$ ./gradlew calc
```

**ユニットテストを使ったテストコードの実行**

```bash
$ ./gradlew test --tests goodcode.calc.CalcTest
```

**お題　Webアプリケーションのセキュリティテストのテストコードの実行**

```bash
$ ./gradlew test --tests goodcode.controllers.TodoControllerTest
```

**お題　Webアプリケーションのセキュリティテストのアプリケーションの実行**

```bash
$ ./gradlew bootRun
```

その後、 http://localhost:8080/ にブラウザでアクセスします。

**考察　テストしにくい部分はどうする？　モックオブジェクト**

```bash
$ ./gradlew test --tests goodcode.controllers.TimelineControllerTest
```

### 第10章　抽象化

コマンドプロンプト（Windows）かターミナル（Linux/Mac OS X）で `goodcode10` ディレクトリに移動し、次のコマンドを実行します。

```bash
$ ./gradlew bootRun
```

http://localhost:8080/ にブラウザでアクセスします。

### 第11章　メタプログラミング

コマンドプロンプト（Windows）かターミナル（Linux/Mac OS X）で `goodcode11` ディレクトリに移動し、次のコマンドを実行します。

**ステップ1　ベタなコードで書いてみる**

```bash
$ ./gradlew step1
```

**ステップ2　メタデータを内部DSLに移動する**

```bash
$ ./gradlew step2
```

**ステップ3　変換ルールに対応する**

```bash
$ ./gradlew step3
```

**考察 DSLの構文を改善するには？もっとDSLっぽくする**

```bash
$ ./gradlew advanced
```

### 第12章　フレームワークを作ろう

#### ステップ1〜ステップ4までを実行

コマンドプロンプト（Windows）かターミナル（Linux/Mac OS X）で `goodcode12-step1` 〜 `goodcode12-step4` ディレクトリに移動し、次のコマンドを実行します。

```bash
$ ./gradlew appRun
```

http://localhost:8080/goodcode12/ にブラウザでアクセスします。

#### ステップ5を実行

##### 1. フレームワークのJARファイルを生成

コマンドプロンプト（Windows）かターミナル（Linux/Mac OS X）で `goodcode12-packaging-framework` ディレクトリに移動し、次のコマンドを実行します。

```bash
$ ./gradlew clean jar
```

`buid/libs/goodcode12-0.0.1-SNAPSHOT.jar` にJARファイルが生成されます。

##### 2. 生成したJARファイルを使ってアプリケーションコードを実行

JARファイルが生成できたら、次のようにアプリケーションコードの`goodcode12-packaging-application`ディレクトリに移動して実行します。
アプリケーションコード側の`build.gradle`には、先ほど生成したJARファイルに対して依存が追加されています。

```bash
$ cd ../goodcode12-packaging-application/
$ ./gradlew appRun
```

http://localhost:8080/goodcode12/ にブラウザでアクセスします。

#### Column：JavaのリフレクションAPI

コマンドプロンプト（Windows）かターミナル（Linux/Mac OS X）で `goodcode12-refrect-api` ディレクトリに移動し、次のコマンドを実行します。

```bash
$ ./gradlew refrect
```
