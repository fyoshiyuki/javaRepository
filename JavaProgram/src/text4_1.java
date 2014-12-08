import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/***
 * ソートの実行
 */
public class text4_1 {
	public static void start(){
		//AccountインスタンスをAccountの配列変数にぶっこみます
		Account[] account = { new Account(3563,"test01",6000),
							  new Account(1645,"test08",1200),
							  new Account(8654,"test04",2900)
							};

		//ListにArrayListとしてAccountインスタンスを順次、格納しています。
		List<Account> list = new ArrayList<>();
		for(Account data : account){
			list.add(data);
		}

		System.out.println("【ソート実行前】");
		Iterator<Account> it = list.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}

		System.out.println("【ソート実行後＜口座番号-降順＞】");
		/**ソートの実施 Collectionクラスの静的メソッドsort(対象リスト)
		 * ソートの自然順序付けはAccountクラスのCompareToメソッド(オーバーライド)で決めています。**/
		Collections.sort(list);

		for(int i = 0; i < list.size(); i++){
			System.out.println(list.get(i));
		}
	}
}

/**
 * 自然順序付けの作成
 * Collection.sort()を使用するため
 */
class Account implements Comparable<Account>{
	int number; //口座番号
	String name; //名前
	int zandaka; //残高


	public Account(int number, String name, int zandaka){
		this.number = number;
		this.name = name;
		this.zandaka = zandaka;
	}

	public int compareTo(Account obj) {
		// TODO 自動生成されたメソッド・スタブ
		//自身のインスタンスの口座番号が引数の口座番号よりも小さい場合、ー１を返す
		if(this.number < obj.number){
			return 1;
		}//自身のインスタンスの口座番号が引数の口座番号よりも大きい場合、１を返す
		if(this.number > obj.number){
			return -1;
		}//自身のインスタンス口座番号と引数口座番号が等しい場合は、０を返す。
		return 0;
	}

	public String toString(){
		return "口座番号:[" + this.number + "] 名前:[" + this.name + "] 残高 [" + this.zandaka + "]";
	}
}
