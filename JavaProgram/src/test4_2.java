/***
 *
 * インスタンスの複製
 *
 */
public class test4_2 {
	public static void start(){
		Sword sword = new Sword("エクスカリバー", 100000);
		Hello hello = new Hello("コスケ", 200, 100, sword);

		System.out.println("<hello変数>" + hello);

		//hello2変数にhelloのクローンを代入し、複製を行う。
		Hello hello2 = hello.clone();
		System.out.println("<hello2変数>" + hello2);

		//ソードの名前を変更します。
		System.out.println("\n" + "<hello2変数>ソード変更後");
		hello2.sword.setName("プラチナソード");
		System.out.println("<hello変数>" + hello);
		System.out.println("<hello2変数>" + hello2);

	}
}
class Hello implements Cloneable{
	String name;
	int hp;
	int mp;
	Sword sword; //have-a関係
	public Hello(){}
	public Hello(String name, int hp, int mp, Sword sword){
		this.name = name;
		this.hp = hp;
		this.mp = mp;
		this.sword = sword;
	}
	//Helloクラスのクローンメソッド
	public Hello clone(){
		//インスタンスを生成する。
		Hello result = new Hello();
		result.name = this.name;
		result.hp = this.hp;
		result.mp = this.mp;
		//result.sword = this.sword; 			//浅いコピー（shallow copy)
		result.sword = this.sword.clone();	//深いコピー（deep copy）
		return result;
	}
	public String toString(){
		return "名前：" + this.name + " HP：" + this.hp + " MP:" + this.mp + this.sword;
	}
}
class Sword implements Cloneable{
	String name;
	int attackDamege;
	public Sword(){};
	public Sword(String name, int attackDamege){
		this.name = name;
		this.attackDamege = attackDamege;
	}
	public void setName(String name){
		this.name = name;
	}
	//Swordクラスのクローンメソッド
	public Sword clone(){
		Sword result = new Sword();
		result.name = this.name;
		result.attackDamege = this.attackDamege;
		return result;
	}

	public String toString(){
		return " ソード名：" + this.name + " 威力：" +this.attackDamege;
	}
}