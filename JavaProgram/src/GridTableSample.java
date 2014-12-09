import java.awt.*;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
/***
 * グリッド表の勉強
 */
public class GridTableSample extends JFrame{
	//仮の登録データ（データモデル）
	private String[][] dm = {
			{"20141201","ポテトチップス","200","3"},
			{"20141201","昼食","1200","1"},
			{"20141202","たばこ","430","4"},
			{"20141203","コーラ","100","3"},
			{"20141204","ポテトチップス","200","3"},
			{"20141204","昼食","1200","1"},
			{"20141204","たばこ","430","4"},
			{"20141205","コーラ","100","3"},
			{"20141206","ポテトチップス","200","3"},
			{"20141207","昼食","1200","1"},
			{"20141208","たばこ","430","4"},
			{"20141209","コーラ","100","3"}
			};
	//仮の項目名（列モデル）
	private String[] cm = {"日付","科目","金額","個数"};

	//コンストラクタ
	GridTableSample(){
		//JFrameの設定
		setTitle("グリッド表の扱い方");
		setBounds(10, 10, 500, 500);

		//グリッド表の作成
		JTable table = new JTable(dm, cm);//データモデルと列モデルを設定
		//JTable table = new JTable(6, 4); //デフォルトモデルを使用、空のセルの行列でJTableを構築
		//TableModel tm = dm;
		//JTable table = new JTable();
		//JTable table = new JTable(dm);

//Vectorクラス：設定してみたが正しく表示されない。

		/*Vector<String> rowData = new Vector<>();
		/*for(int i=0; i < dm.length; i++){
			String str = Integer.toString(i);
			rowData.add(str);
		}*/
		/*
		Vector<String> columnNames = new Vector<>();
		columnNames.add("日付");
		columnNames.add("科目");
		columnNames.add("金額");
		columnNames.add("個数");
		DefaultTableModel dtm = new DefaultTableModel(columnNames,0);

		for(int i = 0; i < dm.length; i++){
			for(int j = 0; j < dm[i].length; j ++){
				System.out.println(dm[i][j]);
				rowData.add(dm[i][j]);
				dtm.insertRow(i, rowData);
			}
			//dtm.insertRow(i, rowData);
		}*/

		//テーブルサイズ変更時、自動サイズ変更モードを設定
		//table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF); //
		//table.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN); //サイズ変更列の直後の列で
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS); //サイズ変更列の直後の列で
		//table.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS); //サイズ変更列の直後の列で
		table.setGridColor(Color.ORANGE);

		JScrollPane sp = new JScrollPane(table);
		sp.setBackground(Color.LIGHT_GRAY);
		sp.setPreferredSize(new Dimension(400, 200));

		JPanel panel = new JPanel();
		panel.add(sp);

		getContentPane().add(panel);

		//JFrameおきまりの設定
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

}
