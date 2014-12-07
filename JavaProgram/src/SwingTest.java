import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.*;

public class SwingTest{
	private JButton loginBtn;
	private int cnt = 0;
	public SwingTest(){
		//JFrameクラスのインスタンスを生成して、フレームを実装する。
		JFrame jframe = new JFrame("ログイン画面");

		/** ラベルの作成 **/
		//「ユーザーID」を表示させるためのラベルを作成
		JLabel UserIdLabel = new JLabel("ユーザーID");
		//「パスワード」を表示させるためのラベルを作成
		JLabel PasswordLabel = new JLabel("パスワード");
		// 日付(例「日付：2014年12月07日」)ラベルの作成
		JLabel DateLabel = new JLabel();
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy'年'MM'月'dd'日'");
		DateLabel.setText("日付：" + sdf.format(date));

		/** ボタンの作成 **/
		ImageIcon icon = new ImageIcon("new_iconJava.jpg");
		loginBtn = new JButton("ログイン",icon);


		/** コンポーネントに枠線をつける**/
		//Borderインターフェースの変数に指定された色で直線ボーダーを生成し格納
		Border border = BorderFactory.createLineBorder(Color.CYAN, 3);
		UserIdLabel.setBorder(border);
		border = BorderFactory.createTitledBorder("枠線の情報");
		PasswordLabel.setBorder(border);
		border = BorderFactory.createRaisedBevelBorder();
		DateLabel.setBorder(border);

		/** パネルの作成（レイアウトマネージャーの作成） **/
		//引数にレイアウトマネージャーを設定したとき JPanel panel = new JPanel(new GridLayout(2,2));
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		border = BorderFactory.createEtchedBorder();
		border = BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),"パネル１");
		//border = BorderFactory.createTitledBorder("パネル１");
		panel.setBorder(border);
		//panel.add(UserIdLabel);
		panel.add(PasswordLabel);
		panel.add(DateLabel);
		panel.add(Box.createRigidArea(new Dimension(10,100)));
		panel.add(loginBtn);


		JPanel panel1 = new JPanel();
		panel1.setBorder(border);
		panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));
		panel1.add(UserIdLabel);
		panel1.add(PasswordLabel);
		//panel.add(DateLabel);

		/** コンポーネントをフレームに組み込む **/
		Container ct = null;
		ct = jframe.getContentPane();
System.out.println("ok");
		ct.setLayout(new GridLayout(2,1));
		ct.add(panel);
		ct.add(panel1);
System.out.println("Ok2");

		/** イベントリスナーの関連付け **/
		this.loginBtn.addActionListener(new AddActionHandler());


		//プログラム終了を示す
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//コンポーネントサイズにウィンドウを設定
		jframe.pack();
		//可視状態にする
		jframe.setVisible(true);
	}

	private class AddActionHandler implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {

				System.out.println("ボタンオン" + cnt);
				cnt++;
			}
		}
}

class back{
	public void test(){
		Border border = BorderFactory.createLineBorder(Color.RED, 10);
		border = BorderFactory.createTitledBorder("test");
		border = BorderFactory.createEtchedBorder();
		border = BorderFactory.createRaisedBevelBorder();
	}
}
