package haken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
/**
 * ConsoleStatus
 */
public class ConsoleStatus {
	/**
	 * フィールド
	 */
	// 次に遷移する状態を記録する HashMap
	private HashMap<String, ConsoleStatus> nextStatus;
	// 終了状態でアルカド化を表す変数
	private boolean IsEndStatus;
	// 状態遷移後、最初に出力するメッセージ
	private String firstMsg;
	// 次の状態に遷移することを促すためのメッセージ
	private String promptMsg;
	
	/**
	 * コンストラクタ ConsoleStatus
	 * 
	 * @param String firstMsg
	 * @param String promptMsg
	 * @param boolean IsEndStatus
	 */
	ConsoleStatus (String firstMsg, String promptMsg, boolean IsEndStatus) {
		this.nextStatus = new HashMap<String, ConsoleStatus>();
		this.firstMsg = firstMsg;
		this.promptMsg = promptMsg;
		this.IsEndStatus = IsEndStatus;
	}
	
	/**
	 *  getIsEndStatus 終了状態かどうかをチェックする
	 *  
	 * @return boolean
	 */
	public boolean getIsEndStatus () {
		return IsEndStatus;
	}
	
	/**
	 * setNextStatus 次の状態をセットする
	 * 
	 * @param String s
	 * @param ConsoleStatus c
	 */
	public void setNextStatus (String s, ConsoleStatus c) {
		nextStatus.put(s, c);
	}
	
	/**
	 * getNextStatus 次の状態を得る
	 * 
	 * @param s
	 * @return
	 */
	public ConsoleStatus getNextStatus (String s) {
		// 入力された文字列に対応付けられた次の状態が
		// あるかどうかを判定し、あればの状態を返す；
		// なければthis（現在の状態）を返す
		ConsoleStatus cs;
		if ((cs = nextStatus.get(s)) != null)
			return cs;
		else
			return this;
	}
	
	// 最初に出力するメッセージを表示する
	/**
	 * displayFirstMsg 
	 * @throws Exception
	 */
	public void displayFirstMsg() throws Exception {
		System.out.println(firstMsg);
	}
	// 次の状態に遷移することを促すためのメッセージの表示
	/**
	 * displayPromptMsg
	 */
	public void displayPromptMsg () {
		System.out.println(promptMsg);
	}
	/**
	 * inputMessage 操作者からのキー入力を受け付ける
	 * 
	 * @return String
	 * @throws IOException
	 */
	public String inputMessage () throws IOException {
		String s = null;
		try {
			BufferedReader input = new BufferedReader (new InputStreamReader (System.in));
			s = input.readLine();
		} catch (IOException e) {
			System.out.println("入力中エラーが発生しました。");
			throw e;
		}
		return s;
	}
}
