## AppleMilkTea 2.0_alpha 1.7.10

### 動作環境:
・Minecraft 1.7.10
<br>・MinecraftForge 10.13.0.1197+
 
### ライセンス:
・ソースコード：MMPL-1.0
<br>・テクスチャ・効果音：CC-BY-NC

### 注意事項
・このMODは現在、未実装・作成途中の追加要素が多数あるα版です。
<br>　よって今後、頻繁に内容が変わりますのでご注意下さい。
<br>・このファイル群には、コンパイルに必要な他MOD様のAPIが含まれていません。
<br>　よってこのままエクリプス等に落としこんでもPluginクラス群がエラーを吐きますのでご注意下さい。
<br>　（api類の再配布は致しませんのでご自身で入手して下さい。）

### APIについて
以下の注意をよくお読みになった上でご使用下さい。
<br>※APIも本体同様、今後追加や変更が多くあるものと予想されます。
<br>　ご使用の際はその点ご了承下さい。
<br>
<br>・レジストリ内のmods/defeatedcrow/apiフォルダをクローン又はダウンロードし、ご自身の開発環境に置いて下さい。
<br>・配布の際は、なるべくご自身のmodのzipフォルダに同梱しないようお願い致します。
<br>（package-info.classを追加しましたので、APIとして認識はされると思います。）
<br>・apiを元に作成されたmodの権利はあなたにあります。
<br>　但し、apiの権利はdefeatedcrowにあり、MMPL_1.0が適用されますのでご注意下さい。
<br>
<br>
<br>◯APIで出来る事
<br>・ティーメーカーへのレシピ登録・レシピリスト取得（ミルク投入の可否それぞれのメソッドがあります）
<br>・アイスメーカーへのレシピ登録・レシピリスト取得（空容器が返るレシピ登録もあります）
<br>・フードプロセッサーへのレシピ登録・レシピリスト取得（副生成物のあるレシピ・材料の鉱石辞書指定も可）
<br>・エバポレーターへのレシピ登録・レシピリスト取得（完成品は液体・アイテムそれぞれ登録可能）
<br>・アイスメーカーの燃料の登録
<br>・チャージ燃料（電池アイテム）の登録
<br>・当MODのアイテム・ブロックの取得
<br>・食べられるItem及びItemBlock作成の補助（空容器返却メソッド付き）
<br>・当MOD追加ポーション（Immunization及びReflex）のシステムの利用
<br>・インセンスの追加・インターフェイスの利用
