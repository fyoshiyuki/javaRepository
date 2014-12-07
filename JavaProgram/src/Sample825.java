import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.event.*;

//イベント処理の問題
public class Sample825{ //extends JPanel{
	private JButton button1;
	private JButton button2;
	private JLabel label;
	private int button1Cnt = 0;

	public Sample825(){
		JFrame frame = new JFrame("問題");
		JPanel panel = new JPanel();

		button1 = new JButton("押して！");
		button2 = new JButton("リセット");
		label = new JLabel("この文字を変えます");
		label.setHorizontalAlignment(SwingConstants.CENTER);

		panel.setLayout(new GridLayout(2,2));
		panel.add(label);
		panel.add(javax.swing.Box.createRigidArea(new Dimension(1,1)));
		panel.add(button1);
		panel.add(button2);

		Border border = BorderFactory.createEmptyBorder(30,30,30,30);
		panel.setBorder(border);

		//ボタンにリスナを設定
		button1.addActionListener(new AddActionHandler());
		button2.addActionListener(new AddActionHandler());

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
			if(e.getSource() == button1){
				button1Cnt++;
			}else if(e.getSource() == button2){
				button1Cnt = 0;
			}
			label.setText(button1Cnt + "回目のクリック");
		}
	}
	/*private class RemoveActionHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO 自動生成されたメソッド・スタブ
			button1Cnt = 0;
			label.setText(button1Cnt + "回目のクリック");
		}
	}*/
}