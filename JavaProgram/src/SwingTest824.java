import java.awt.*;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.event.*;

public class SwingTest824{
	SwingTest824(){
		JFrame frame = new JFrame("問題");
		Panel panel = new Panel();

		Border border = BorderFactory.createEmptyBorder(30,30,30,30);
		panel.setBorder(border);

		Container ct = frame.getContentPane();
		ct.add(panel);

		//Frameのセットアップ
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
}
class Panel extends JPanel implements ActionListener{

	JButton button;
	JLabel label;
	int i = 0;

	Panel(){
		button = new JButton("押して！");
		label = new JLabel(" この文字を変えます");
		label.setHorizontalAlignment(SwingConstants.CENTER);

		this.setLayout(new GridLayout(1,2));
		this.add(label);
		this.add(button);

		this.button.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		if(e.getSource() == this.button){
			System.out.println(e.getSource().toString());
			i++;
			this.label.setText(i + "回目のクリック");
		}
	}

}
