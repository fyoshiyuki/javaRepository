import java.awt.*;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.event.*;

public class Sample826 {
	JButton buttonRed;
	JButton buttonBlue;
	JButton buttonYellow;
	JLabel label;

	public Sample826(){
		System.out.println("コンストラクタ");
		JFrame frame = new JFrame("問題");
		JPanel panel = new JPanel();

		label = new JLabel("文字色を変えます"); //引数により表示サイズが変わる
		buttonRed = new JButton("Red");
		buttonBlue = new JButton("Blue");
		buttonYellow = new JButton("Yellow");

		buttonRed.addActionListener(new AddActonHandler());
		buttonBlue.addActionListener(new AddActonHandler());
		buttonYellow.addActionListener(new AddActonHandler());

		panel.add(label);
		panel.setLayout(new GridLayout(2,3));
		panel.add(label);
		panel.add(javax.swing.Box.createRigidArea(new Dimension(5,0)));
		panel.add(javax.swing.Box.createRigidArea(new Dimension(5,0)));
		panel.add(buttonRed);
		panel.add(buttonBlue);
		panel.add(buttonYellow);

		Border border = BorderFactory.createEmptyBorder(30,30,30,30);
		panel.setBorder(border);
		Container ct = frame.getContentPane();
		ct.add(panel);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
	private class AddActonHandler implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO 自動生成されたメソッド・スタブ
			if(e.getSource() == buttonRed){
				label.setText("文字色は赤色です");
				label.setForeground(Color.RED);
			}else if (e.getSource() == buttonBlue){
				label.setText("文字色は青色です");
				label.setForeground(Color.BLUE);
			}else if(e.getSource() == buttonYellow){
				label.setText("文字色は黄色です");
				label.setForeground(Color.YELLOW);
			}
		}
	}

}
