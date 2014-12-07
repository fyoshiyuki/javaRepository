import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.Border;

//文字の入力
public class code832 {
	private JTextField textField;
	private JButton okBtn;
	private JTextField readTextField;
	private JLabel readLabel;
	private JPasswordField pwText;
	code832(){
		JFrame frame = new JFrame("テキスト文字の入力");
		JPanel panel = new JPanel();
		//textField = new JTextField(20);
		readTextField =  new JTextField(20);
		readLabel = new JLabel();
		readLabel.setPreferredSize(new Dimension(300,30)); //サイズの変更がここから反映している
		pwText = new JPasswordField(10);
		pwText.setEchoChar('@');
		//pwText.setOpaque(true); //Opaqueって何？？
		//pwText.setPreferredSize(new Dimension(200,30));
		okBtn = new JButton("OK");
		Border border = BorderFactory.createEmptyBorder(20,20,20,20);
		panel.setBorder(border);

		border = BorderFactory.createLineBorder(Color.BLACK);
		readLabel.setBorder(border);

		//readTextField.setEnabled(false);
		//readTextField.setBackground(Color.lightGray);
		panel.setLayout(new GridLayout(2,2));

		panel.add(pwText);
		panel.add(readLabel);
		panel.add(okBtn);
		//panel.add(readTextField);

		//textField.addActionListener(new AddActionHandler());
		pwText.addActionListener(new AddActionHandler());
		okBtn.addActionListener(new AddActionHandler());

		//Container ct = frame.getContentPane();
		//ct.add(panel);
		frame.add(panel);

		frame.setBounds(100,100,400,800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
	private class AddActionHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO 自動生成されたメソッド・スタブ

			if(e.getSource() == textField){
				String msg = textField.getText();

				readLabel.setText(msg);
				//readTextField.setEnabled(true);
				//readTextField.setText(msg);
				//readTextField.setEnabled(false);
			}
			if(e.getSource() == pwText){
				int select = JOptionPane.showConfirmDialog(null, "処理をつづけますか？", "TITLE", JOptionPane.YES_NO_CANCEL_OPTION);
				if(select == JOptionPane.YES_OPTION){
					readLabel.setText("「YES」が押されました");
					//readLabel.removeAll();
					okBtn.setVisible(true);
				}else if(select == JOptionPane.NO_OPTION){
					readLabel.setText("「NO」が押されました");
					okBtn.setVisible(false);
				}else{
					readLabel.setText("「取消」が押されました");
				}
			}
			if(e.getSource() == okBtn){
				JOptionPane.showMessageDialog(null, "HelloWorld!","タイトル文字", JOptionPane.WARNING_MESSAGE);
				System.out.println("IN");
				StringBuilder sb = new StringBuilder();
				for(char data : pwText.getPassword()){
					sb.append(data);
				}
				readLabel.setText(sb.toString());
			}
		}

	}

}
