import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;


public class text4 {

	public static void test(){
		//勇者Aを生成
		Hero h = new Hero("tanaka", 100, 50);
		System.out.println("最初に生成した勇者");
		System.out.println("変数h = " + h + "\n");

		Set<Hero> list = new HashSet<>();
		//List<Hero> list = new ArrayList<>();W
		//勇者Aをリストに格納
		list.add(h);
		h = new Hero("tanakaA", 100, 50);
		list.add(h);
		h = new Hero("tanakaB", 100, 50);
		list.add(h);

		Iterator it = list.iterator();
		System.out.println("listデータを表示");
		while(it.hasNext()){
			System.out.println("listの勇者：" + it.next());
		}System.out.println();
		System.out.println("listの要素数 = " + list.size());
		//System.out.println("listの勇者 = " + list.get(0) + "\n");

		//HPは異なるが同じ名前の勇者を生成
		h = new Hero("tanaka", 100, 50);
		System.out.println("削除対象の勇者の情報");
		System.out.println("変数h = " + h + "\n");

		//リストに入っている勇者が「new Hero("勇者A", 200, 50)」の勇者の名前と同じならば削除する。
		System.out.println("削除開始");
		for(int i = 0; i < list.size(); i++){
			/**
			 * 【ArrayListによる削除処理の注意】
			 *  (注意)remove()処理では JVMがArrayListから同じものを探す為にequals()による等価判定を行う。
			 *  そのため、等価判定の条件を設定するためにequalsメソッドをオーバーライドしないと処理は正しく行われない。
			 *  Hash系クラスによる削除処理の注意
			**/

			/**【Hash系による注意点】
			 * (注意)HashSet/HashMapは２段階方式で目的要素を探します。
			 *  ① - あいまいな方法で、各要素に「だいたい同じか？」を問い合わせる（hashcode()メソッド）
			 *  ② - ①をパスした後、equalsメソッドで「厳密に同じか？」を問い合わせる。
			 *  これより、Heroクラスのhashcode()メソッドをオーバーライドする必要がある。
			 *
			 * ※ equalsメソッドもオーバーライドする必要がある
			**/
			list.remove(h);
		}
		System.out.println("削除後のlistの要素数 = " + list.size());
	}

}
class Hero{
	String name;
	int hp, mp;

	public Hero(String name, int hp, int mp){
		this.name = name;
		this.hp = hp;
		this.mp = mp;
	}

	//ハッシュコードのオーバーライド（Hash系のremove()で必要になるメソッド
	public int hashCode(){
		int result = 37; //代入値(37)は適当でよい
		//System.out.println("name = " + this.name + " name.hashCode() = " + this.name.hashCode());
		result = result * 31 * this.name.hashCode();
		result = result * 31 * this.hp;
		return result;
	}
	//インスタンス同士の等価判定(equals）をオーバーライド
	public boolean equals(Object obj){
		//自分自身のインスタンスならばtrueを返す
		if(obj == this){ return true; }
		//objインスタンスの参照先がNULLの場合、falseを返す
		if(obj == null){ return false; }
		//objインスタンスのクラスがHeroクラスでない場合はfalseを返す
		if(!(obj instanceof Hero)){	return false; }
		//objはHeroクラスなので、objインスタンスをキャストして、等価判定条件で処理する。
		Hero hero = (Hero)obj;
		//名前が同じ場合は等価とみなす。
		if(!(this.name.trim().equals(hero.name.trim()))){ return false; }
		return true;
	}

	//ObjectクラスのtoString()メソッドをオーバーライド
	public String toString(){
		//return "勇者" + this.name + "のHPは " + this.hp + "、MPは " + this.mp;
		return "勇者" + this.name + "のHPは " + this.hp + "、MPは " + this.mp + "[hashCode() result値 =" + this.hashCode() + "]";
		//this.name.hashcode()の値は名前が同じならば同じかも
		/*******************************************************************************************************************************
		 * テストを行った内容は
		 * ① HashListに格納されたHeroインスタンスのString nameを「tanaka」「tanakaA」「tanakaB」としたときのnameのhashcode()を調べた。
		 * ② 削除対象に生成した「tanaka」のnameのhashcode()も調べた。
		 * ①と②の値を比較する。
		 * 【結果】
		 * ① HashListに格納したHeroインスタンスのname.hashcode値
		 * 「tanaka」：[name.hashcode = -881030602]
		 * 「tanakaA」:[name.hashcode = -1542144821]
		 * 「tanakaB」：[name.hashcode = -1542144820]
		 * ② 削除対象に生成したHeroインスタンスの「tanaka」のname.hashcode値
		 * 「tanaka」：[name.hashcode = -881030602]
		 * 【考察】
		 * 自分で作成したクラスで同じインスタンスのハッシュコードはhashCode()をオーバーライドしていなければ異なるが、
		 * StringのインスタンスはhashCode値がどちらとも同じであった。
		 ******************************************************************************************************************************/
	}
}
