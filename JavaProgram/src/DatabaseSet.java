import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseSet{
	//静的初期化ブロックという
	//初めて利用されるときだけに処理が走る
	//コンストラクタとは異なり、newするたびに走らない。
	static{
		//step0 事前準備 JDBCドライバの有効化
		/*JDBCドライバのJARファイル内のドライバクラスをJVMに読み込み、
		  有効化する。その一般的な書き方*/
		try{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("ドライバの有効化処理");
			//org.gjt.mm.mysql.Driver
		}catch(ClassNotFoundException e){
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

	public void dbConnect(){
		String url = "jdbc:mysql://localhost/javastudy";
		String user = "root";
		String password = "admin";

		Connection con = null;
		try{
			/**Step1 DBへの接続**/
			//mysqlの場合、urlは「jdbc:mysql://(サーバ名)/(データベース名)」
			con = DriverManager.getConnection(url, user, password);
			System.out.println("ＤＢに接続しました。");
			///トランザクション処理のため、自動コミットを手動コミットに設定
			con.setAutoCommit(false);

			/** Step2 SQL送信処理**/
			String sql = "DELETE FROM TEST WHERE ID = ?";
			//sql = "INSERT INTO TEST VALUE (?, ?)";
			//sql = "UPDATE TEST SET NAME = ? WHERE ID = ?";
			sql = "CREATE TABLE TEST2 (TESTID VARCHAR(4), TESTNAME VARCHAR(50))";

			/*** Step2-1については、insert/update/deleteそれぞれ同じ書き方 ***/
			/*** Step2-1-1 送信すべきSQL分のひな形を準備 ***/
			// PreparedStatement:用意された表現法という意味らしい
			PreparedStatement psmt = con.prepareStatement(sql);

			/*** Step2-1-2 ひな形に値を流し込みSQL文を組み立てて送信する***/
			// 第１引数：sqlの？のパラメータ番号(1から)
			// 第２引数：代入値で、文字列をsqlを流し込むときは「""」から「''」に代わります。
			//           toString()結果：DELETE FROM TEST WHERE ID = '0004'
			//psmt.setString(1, "0004");
			//psmt.setString(2, "ddテト君");
			System.out.println(psmt.toString());

			// データを送信し、その結果(処理したレコード件数)を代入します。
			int count = psmt.executeUpdate();

			/*** Step2-1-3 処理結果を反映する ***/
			System.out.println("処理件数は" + count + "件です");

			/*** Step2-2については、selectの書き方 ***/
			sql = "select * from test where id >= ?";
			//送信するsqlのひな形を作成
			psmt = con.prepareStatement(sql);
			//ひな形に値を流し込み、sqlを組み立てます
			psmt.setString(1, "0005");
			//sqlを送信して、結果表をResultSetの変数に返します。
			System.out.println("SQL：" + psmt.toString());
			ResultSet rs = psmt.executeQuery();


			//結果表を1レコードずつ読み込みます。next)の動きはIteratorと類似
			count = 0;
			while(rs.next()){
				//System.out.println("ID:" + rs.getString(1) + " name:" + rs.getString(2));
				System.out.println("ID:" + rs.getString("id") + " name:" + rs.getString("name"));
				count++;
			}
			System.out.println("データ取得件数は" + count + "件です");

			con.rollback();
			con.commit();
		}catch(SQLException e){
			e.printStackTrace();
			try{
				con.rollback();
			}catch(SQLException rollback){
				rollback.printStackTrace();
			}
		}finally{
			/**Step3 DB接続の切断**/
			//接続かどうか判断
			if(con != null){
				try{
					//接続してれば、接続を切断する
					con.close();
					System.out.println("ＤＢを切断しました。");
				}catch(SQLException e){
					//クローズ処理でエラー
					e.printStackTrace();
				}
			}

		}
	}
}