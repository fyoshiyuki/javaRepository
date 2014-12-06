import java.sql.*;
import java.util.ArrayList;

/***
 * DAO[Data Access Object](データベースアクセス処理を専門に行うクラス)
 */
public class ItemDAO {
	static{
		//jdbc-driverの有効化
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("ドライバーを有効");
		} catch (ClassNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}
	public static ArrayList<Item> findByMinimumPrice(int price){
		String url = "jdbc:mysql://localhost/javastudy";
		String user = "root";
		String password = "admin";
		//Item item = null;
		//ArrayList<Item> itemlist = null;

		Connection con = null;
		try {
			//データベースを接続
			con = DriverManager.getConnection(url, user, password);
			System.out.println("接続開始");

			//sql送信処理
			//SQLに送信するためのひな形を作成
			PreparedStatement jsps = con.prepareStatement("SELECT * FROM ITEMS WHERE PRICE > ?");

			//ひな形に？に対する値を設定してSQL文を組み立てて送信する
			jsps.setInt(1, price);
			ResultSet rs = jsps.executeQuery();

			int cnt = 0;
			ArrayList<Item> itemlist = new ArrayList<>();
			//Itemインスタンスを生成し、セットする
			while(rs.next()){
				Item item = new Item();
				item.setName(rs.getString("name"));
				item.setPrice(rs.getInt("price"));
				item.setWeight(rs.getInt("weight"));
				itemlist.add(item);
				cnt++;
			}
			System.out.println("取得件数：" + cnt + "件です");
			rs.close();
			jsps.close();
			return itemlist;

		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} finally{
			if(con != null){
				try{
					con.close();
					System.out.println("接続終了");
				}catch(SQLException e){
					e.printStackTrace();
				}
			}
		}
		return null;
	}

}
