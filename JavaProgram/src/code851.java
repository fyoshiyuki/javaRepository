import java.awt.*;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.event.*;
import java.util.ArrayList;
import java.util.Vector;

public class code851 {
	private JComboBox list;
	private JButton selectBtn;
	private String[] data = {"","リンゴ", "バナナ", "メロン", "パパイヤ", "ぶどう","なし","ザクロ","こーら"};

	code851(){
		JFrame frame = new JFrame("リスト表示");
		JPanel panel = new JPanel();
		//ArrayListにStringデータを入れて、JComboBoxのコンストラクタ引数に入れたがエラー
		//ArrayList<String> arrayData = new ArrayList<String>();
		Vector<String> vectData = new Vector<>();
		for(String str : data){
		//	arrayData.add(str);
			vectData.add(str);
		}
		//引数はObject[]であるが、通常は通常はString型の値を配列として作成し指定します。
		//list = new JComboBox<String>(data);
		//↓デフォルト上だと最大表示件数は８件、それ以降はスクロールによって操作する
		list = new JComboBox<String>(vectData);
		//リスト最大表示件数
		list.setMaximumRowCount(10);
		list.setPreferredSize(new Dimension(200,40));
		//JScrollPane scroll = new JScrollPane(list);
		selectBtn = new JButton("選択");

		Border border = BorderFactory.createEmptyBorder(30,30,30,30);
		panel.setBorder(border);
		panel.add(list);
		Container ct = frame.getContentPane();
		ct.add(panel);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
}
