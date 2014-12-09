import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
/***
 * ＜画面遷移の調査＞
 * クラス名：screenTransition
 * スーパークラス：JFrame
 */
public class screenTransition extends JFrame{
	/***
	 * 属性
	 * ・PanelName : パネル名
	 * ・MainPanel : JPanel [パネル名：main]
	 * ・SubPanel  : JPanel [パネル名：Sub1]
	 */
	private String[] PanelNames = {"main", "Sub1"};
	private MainPanel mp = new MainPanel(this ,PanelNames[0]);
	private SubPanel sp = new SubPanel(this ,PanelNames[1]);
//	Container ct;

	public screenTransition(){
		//フレームのタイトルと大きさを設定
		this.setTitle("画面遷移プログラム");
		this.setBounds(100,100,500,500);

		//フレームにコンテナを貼り付け、コンテナにパネルを張り付ける
		//ct = this.getContentPane();
		//ct.setLayout(null);
		//ct.add(sp); sp.setVisible(false);
		//ct.add(mp); mp.setVisible(true);

		getContentPane().add(mp);
		//mp.setVisible(true);
		//getContentPane().add(sp); mp.setVisible(false);
		//this.add(sp); sp.setVisible(false);

		//最大化を拒否
		this.setResizable(false);
		//フレームのお決まりの処理
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		//this.pack();
		this.setVisible(true);
	}
	//パネルチェンジメソッド
	public void PanelChange(JPanel jp, String str){
		System.out.println("呼び出し元のパネル：" + jp.getName());
		String name = jp.getName();

		System.out.println("指定画面パネル：" + str);
		//呼び出し元のクラスのパネルを不可視にする。
		if(name.equals(PanelNames[0])){
			mp = (MainPanel)jp;
			//remove(mp);
			mp.setVisible(false);
		}
		if(name.equals(PanelNames[1])){
			sp = (SubPanel)jp;
			//remove(sp);
			sp.setVisible(false);
		}
		//呼び出し元から次の画面遷移先指定に対して、パネルを可視状態にする
		if(str.equals(PanelNames[0])){
			setPanel(mp);
		}
		if(str.equals(PanelNames[1])){
			setPanel(sp);		}
	}
	//パネル設定処理
	public void setPanel(JPanel jp){
		System.out.println("setPanel(jp = " + jp + ")");
		getContentPane().add(jp);
		jp.setVisible(true);
	}

	/**********************************
	 * クラス名：MainPanelクラス
	 * スーパークラス：JPanel
	 * インターフェース：ActionListener
	 **********************************/
	public class MainPanel extends JPanel implements ActionListener{
		//フィールド
		private screenTransition mainFrame;
		private JLabel panelTitle;
		private JButton btn;

		//コンストラクタ
		public MainPanel(screenTransition p_frame,String str){
			// パネルの設定
			this.mainFrame = p_frame;			// have-a関係（フレームとパネル）
			this.setName(str);					// パネル名
			this.setLayout(null);				// コンポーネントを座標で配置するため、レイアウトマネージャーを無効とする。
			this.setSize(500,500);				// パネルサイズ
			this.setBackground(Color.BLACK);	// パネルバックカラー

			// コンポーネント（ラベル）の作成
			panelTitle = new JLabel(this.getClass().getCanonicalName() + "クラスのパネル");
			panelTitle.setForeground(Color.WHITE);
			panelTitle.setBounds(10, 10, 500, 10);
			this.add(panelTitle);

			// コンポーネント（ボタン）の作成
			this.btn = new JButton("SubPanelに移動");
			this.btn.setBounds(20, 50, 200, 30);
			this.add(btn);
			this.btn.setActionCommand("1");
			this.btn.addActionListener(this);	//ボタンにアクションリスナーを関連づける
		}
		//@Override ActionListenerクラスの抽象メソッドの実装
		public void actionPerformed(ActionEvent e) {
			System.out.println("MainPanelクラスのイベントハンドラ");
			System.out.println("> 受け取ったイベントのアクションコマンド：" + e.getActionCommand());
			System.out.println("> ボタン[MainPanelに移動]のアクションコマンド" + this.btn.getActionCommand());

			if(e.getActionCommand() == this.btn.getActionCommand()){
				//PanelChangeメソッド実行前の情報
				System.out.println(this);
				this.mainFrame.PanelChange(this, this.mainFrame.PanelNames[1]);
			}
		}
		//@Override ObjectクラスのtoString()メソッド
		public String toString(){
			return "クラス名：" + this.getClass() + " パネル名：" + this.getName();
		}
	}
	/*************************************
	 * クラス名：SubPanelクラス
	 * スーパークラス：JPanel
	 * インターフェース：ActionListener
	 *************************************/
	class SubPanel extends JPanel implements ActionListener{
		screenTransition mainFrame;
		JButton btn = new JButton("MainPanelに移動");
		JLabel panelTitle;

		SubPanel(screenTransition p_frame, String str){
			// パネルの設定
			this.mainFrame = p_frame;
			this.setName(str);
			this.setLayout(null);//コンポーネントを座標で配置するため、レイアウトマネージャーを無効とする。
			this.setSize(400, 400);
			this.setBackground(Color.WHITE);

			// コンポーネント（ラベル）の作成
			panelTitle = new JLabel(getClass().getCanonicalName() + "クラスのパネル");
			panelTitle.setBounds(10, 10, 500, 10);
			panelTitle.setForeground(Color.BLACK);
			this.add(panelTitle);

			// コンポーネント（ボタン）の作成
			this.btn.setBounds(250,50,200,30);
			this.add(btn);
			this.btn.setActionCommand("2");
			this.btn.addActionListener(this);
		}
		//@Override ActionListenerクラスの抽象メソッドの実装
		public void actionPerformed(ActionEvent e) {
			System.out.println("SubPanelクラスのイベントハンドラ");
			System.out.println("> 受け取ったイベントのアクションコマンド：" + e.getActionCommand());
			System.out.println("> ボタン[MainPanelに移動]のアクションコマンド" + this.btn.getActionCommand());

			//イベント判定（ボタン押下）
			if(e.getActionCommand() == this.btn.getActionCommand()){
				//PanelChangeメソッド実行前の情報
				System.out.println(this);
				this.mainFrame.PanelChange(this, this.mainFrame.PanelNames[0]);
			}
		}
		//@Override ObjectクラスのtoString()メソッド
		public String toString(){
			return "クラス名：" + this.getClass() + " パネル名：" + this.getName();
		}
	}
}