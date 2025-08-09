package haken;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

/**
 * FileSaver
 */
public class FileSaver {
	// フィールド
	private String fileName;
	
	/**
	 * コンストラクタ FileSaver
	 * @param String fileName
	 */
	FileSaver (String fileName) {
		this.fileName = fileName;
	}
	
	public void write (RecordList rl) throws FileNotFoundException, IOException {
		// ファイル名＝fileNameのファイルに書き込みを行う
		BufferedWriter output = null;
		try {
			try {
				output = new BufferedWriter (new FileWriter (fileName));
				
				// 引数RecordListに格納されたレコードを１行ずつ書き込む
				int idx = 0;
				Record r;
				while (idx < rl.size()) {
					r = rl.getRecord(idx);
					output.write(r.writeForCSV());
					output.newLine(); //改行文字をファイルに出力
					idx++;
				}
			} finally {
				if (output != null) {
					output.close();
				}
			} 
			} catch (FileNotFoundException e) {
				System.out.println(fileName + "を開くことができません。");
				throw e;
		} catch (IOException e) {
			System.out.println("ファイル書き込み中エラーが発生しました。");
			throw e;
		}
	}
}
