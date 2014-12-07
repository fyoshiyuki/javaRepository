import java.util.ArrayList;
import java.util.Date;
import java.util.List;
public class Main {

	public static void main(String[] args) {
		/** １章 文字列操作 **/
		//list1_1実行
		//list1_1();

		//list1_2実行
		//list1_2();

		//list1_3実行
		//list1_3();

		//list1_4実行
		//list1_4();

		//list1_5実行
		//list1_5();

		//list1_6実行
		//list1_6();

		//text1_1
		//test1_1();
		//test1_2();

		//String str = "A191";
		//if(str.matches("A[0-9]{1,2}")){
		//	System.out.println("パターンにマッチした。");
		//}
		//現在日時を取得する。
		//Date now = new Date();
		//System.out.println(now.getTime());
		//interaterClass.sample();
		//MaxListPerformance.test();

		//DatabaseSet ds = new DatabaseSet();
		//ds.dbConnect();

		//SwingTest st = new SwingTest();
		//SwingTest824 st = new SwingTest824();
		code832 st = new code832();
		//ArrayList<Item> items = ItemDAO.findByMinimumPrice(4);


		//System.out.printf("%-20s%-10s%-10s", "Name", "Price", "Weight" );
		//System.out.print("\n");
		//for(Item item : items){

		//	System.out.printf("%-10s%10d%10d", item.getName(), item.getPrice(), item.getWeight());
		//	System.out.println();
		//}

	}
	public static void test1_2(){
		String folder = "c:\\javadev";
		String file = "readme.txt";
		System.out.println(folder);

		//文字列の末尾が「\」で終わるかどうかの判定
		if(!(folder.endsWith("\\"))){
			System.out.println("\\で終わらない為、追加します。");
			folder += "\\";
		}
		System.out.println(folder + file);
	}
	public static void test1_1(){
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < 100; i++){
			sb.append((i+1) + ",");
		}
		System.out.println(sb.toString());

		String s = sb.toString();
		String[] str = s.split("[,]");
		for(String data : str){
			System.out.println(data);
		}

	}
	/**
	 * list1_1 文字列の調査用メソッド
	 */
	public static void list1_1(){
		String s1 = "スッキリJava";
		String s2 = "java";
		String s3 = "Java";
		String s4 = "";
		String s5 = " "; //半角スペース1文字
		String s6 = "　"; //全角スペース1文字

		//1.内容が等しいかどうかを判定(equalsメソッド)
		if(s1.equals(s2)){
			System.out.println("s1とs2の文字内容は、どちらとも等しい");
		}
		if(s2.equals(s3)){
			System.out.println("s2とs3の文字内容は、どちらとも等しい");
		}
		if(s1.equals(s1)){
			System.out.println("s1とs1の文字内容は、どちらとも等しい");
		}
		//2.大文字、小文字を区別せず、内容が等しいか調べる
		if(s2.equalsIgnoreCase(s3)){
			System.out.println("s2とs3の文字内容は、大文字・小文字の区別をしなければ等しい");
		}
		//3.文字列の長さを調べる
		System.out.println("s1の文字列の長さ：" + s1.length()); //スッキリJava(←大文字１文字の長さは1)
		System.out.println("s2の文字列の長さ：" + s2.length());
		System.out.println("s3の文字列の長さ：" + s3.length());

		//4.空文字かを調べる
		if(s4.isEmpty()){
			System.out.println("s4は空文字です");
		}
		if(s5.isEmpty()){
			System.out.println("s5は空文字です");
		}
		if(s6.isEmpty()){
			System.out.println("s6は空文字です");
		}


	}

	/**
	 * list1_2 文字列の検索
	 */
	public static void list1_2(){
		String s1 = "Java and JavaScript";
		//一部に文字列sを含むかを調べる
		if(s1.contains("java")){
			System.out.println("変数s1には「java」が含まれています");
		}
		if(s1.contains("Java")){
			System.out.println("変数s1には「Java」が含まれています");
		}
		if(s1.contains("d Java")){
			System.out.println("変数s1には「d Java」が含まれています");
		}

		//文字列sで始まるかを調べる
		if(s1.startsWith("Java")){
			System.out.println("変数s1は、初めは「Java」が最初に始まります。");
		}
		//文字列sで終わるかを調べる
		if(s1.endsWith("cript")){
			System.out.println("変数s1は、末尾が「cript」で終わります。");
		}
		//文字ch(または文字列str)が最初に登場する位置を調べる
		System.out.println("文字列s1で最初に文字「v」が登場する位置：" + s1.indexOf('v'));
		System.out.println("文字列s1で最初に文字列「 and」が登場する位置：" + s1.indexOf(" and"));
		System.out.println("文字列s1で最初に文字列「JAVA」が登場する位置：" + s1.indexOf("JAVA"));
		//文字ch(または文字列str)が後から検索して、最初に登場する位置を調べる
		System.out.println("文字列s1で最後に文字「v」が登場する位置：" + s1.lastIndexOf('v'));
		System.out.println("文字列s1で最後に文字列「Java」が登場する位置：" + s1.lastIndexOf("Java"));
		System.out.println("文字列s1で最後に文字列「JAVA」が登場する位置：" + s1.lastIndexOf("JAVA"));
	}

	/**
	 * list1_3 文字列を切り出す
	 */
	public static void list1_3(){
		String s1 = "Java programming";

		//指定位置の１文字を取り出す
		System.out.println("文字列s1の4番目の文字：" + s1.charAt(3));
		//指定位置の１文字を取り出す
		//System.out.println("文字列s1の長さと同番目の文字" + s1.charAt(s1.length()));

		//指定位置から始まる文字列を取り出す
		System.out.println("文字列s1の4番目以降の文字列：" + s1.substring(3));
		//指定位置から文字列を部分的に取り出す
		System.out.println("文字列s1の6番目から10番目手前の文字列" + s1.substring(5, 9));

	}

	/**
	 * list1_4 文字列の変換
	 */
	public static void list1_4(){
		String s1 = "JAVA";
		String s2 = "Java";
		String s3 = "    abc efg    ";
		String s4 = "　abc efg　";

		//大文字から小文字変換
		System.out.println("変数s1「JAVA」を大文字から小文字変換：" + s1.toLowerCase());

		//小文字から大文字変換
		System.out.println("変数s2「Java」を小文字から大文字変換：" + s2.toUpperCase());

		//前後の空白を除去する
		System.out.println("変数s3「    abc efg    」の前後の空白除去変換：「" + s3.trim() + "」");
		System.out.println("変数s3「　abc efg　」の前後の空白除去変換不可(全角スペース)：「" + s4.trim() + "」");

		//文字列を置き換える
		System.out.println("変数s1「Java」の「AV」を「XX」に変換する：" + s1.replace("AV","XX"));
	}

	/**
	 * list1_5 文字列の連結(StringBuilderクラスを使用)
	 */
	public static void list1_5(){
		StringBuilder sb = new StringBuilder();
		//10回、バッファに書き込む
		for(int i = 0; i < 10; i++){
			sb.append("Java");
		}
		//StringBuilder型の参照型変数sb2
		StringBuilder sb2;
		//参照先を同じにして、バッファに追加文字列を追加
		sb2 = sb;
		sb2.append("aiueo").append("kakikukeko"); //☆戻り値がStringBuilderの為、当記述が成り立つ（メソッドチェーンと呼ぶ）
		sb2.append(sb2.toString());
		//バッファに書き込んだ内容を出力します
		System.out.println("sb.toString() = " + sb.toString());
	}

	/**
	 * list1_6
	 */
	public static void list1_6(){
		String str = "Java Programming";

		char[] ch = str.toCharArray();
		for(char chOut : ch){
			try {
				Thread.sleep(500);
				System.out.print(chOut);
			} catch (InterruptedException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}

		}

		//良く分からない？？？？？
		byte[] by = str.getBytes();
		for(byte byOut : by){
			System.out.println(byOut);
		}
	}
}
