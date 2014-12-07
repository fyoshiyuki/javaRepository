import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.Border;

public class Sample827 {
	JButton changedBtn; //有効と無効に切り替わるボタン
	JButton trueBtn; //changedBtnを有効にする
	JButton falseBtn; //changedBtnを無効にする
	Sample827(){
		JFrame frame = new JFrame("有効無効の切り替え");
		JPanel panel = new JPanel();
		changedBtn = new JButton("切り替え");
		trueBtn = new JButton("有効");
		falseBtn = new JButton("無効");

		//イベント対象コンポーネント
		trueBtn.addActionListener(new AddActionHandler());
		falseBtn.addActionListener(new AddActionHandler());

		panel.setLayout(new GridLayout(1,3));
		panel.add(changedBtn);
		panel.add(trueBtn);
		panel.add(falseBtn);

		Border border = BorderFactory.createEmptyBorder(30,30,30,30);
		panel.setBorder(border);
		Container ct = frame.getContentPane();
		ct.add(panel);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
	private class AddActionHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO 自動生成されたメソッド・スタブ
			if(e.getSource() == trueBtn){
				changedBtn.setEnabled(true);
			}else if(e.getSource() == falseBtn){
				changedBtn.setEnabled(false);
			}
		}

	}

}
