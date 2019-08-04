# ToDoList
for Team Lab intern

- 使用した技術要素
framework:  springframework.boot

Initializr: Spring Initializr

PullDown:   Gradle

JPA:        'org.springframework.boot:spring-boot-starter-data-jpa'

Thymeleaf:	'org.springframework.boot:spring-boot-starter-thymeleaf'

Web:        'org.springframework.boot:spring-boot-starter-web'

Devtool:    'org.springframework.boot:spring-boot-devtools'

SQL:        'mysql:mysql-connector-java'

View:       HTML5

PullDown:   Gradle


- 全体の設計・構成についての説明
構成要素は、主にApplication, Entity, Repository, Form, Controller, View(HTML)の５つ。
Entityでタスクを定義して、Repositoryでタスクを管理している。
Controllerでは、FormとViewとMySQLの間でタスクのデータを連携させて、タスクの作成、編集を行なっている。

このプロジェクトの中にpushしてあるようなMySQLのtableを"todolist"という名前のデータベースに作成してから、
コマンドプロンプト上でMySQLを立ち上げた後、ブラウザ上で、http://localhost:8080 にアクセスすることで動作を確認できる。
(Safari上で動作確認済み)

与えられた仕様に加えて、未完了のタスクを抽出しやすいように、
完了しているタスクの一覧と、未完了のタスクの一覧を分けて表示できるようにした。(上部ラベル)

1からやり始めたため、大学の学業の都合上、時間不足で満たせなかった仕様は以下である。

・ToDoタスクの編集(編集画面に遷移するとことまではいったが、実際にデータを更新することがうまくいかなかった。)

・ToDoタスクの検索機能

・ToDoタスクの編集画面でデフォルトで変更前のタスク名と締め切り日を表示する機能

・ToDoタスクがリストに存在しない時にリストが空であることを表示させる機能

上記した点に関しては、大学の試験が終わったら改良する見込みである。


- 開発環境のセットアップ手順
1. 開発環境として、StrngBootSuite4をインストール

2. ソースコードの雛形をSpring Initializrを用いて作成。この時、「使用した技術要素」で上記したものを
選択して初期化する。

3. 自動生成された、application.propatiesを以下のようにする。

spring.datasource.url=jdbc:mysql://localhost:3306/todolist

spring.datasource.username=todolist

spring.datasource.password=todolist

spring.datasource.driverClassName=com.mysql.cj.jdbc.Driver

spring.jpa.database=MYSQL

spring.jpa.hibernate.ddl-auto=update

server.port=8080

4. StrngBootSuite4の、「プロジェクト ＞ チーム ＞ 共有」 から、githubのパスを通して、
プッシュ、コミットできるようにする。
