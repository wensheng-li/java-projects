package haken;

import java.io.IOException;

/**
 * NameSelectStatus
 */
public class NameSelectionStatus extends ConsoleStatus {
	// フィールド
	private DisplayPersonsByNameStatus next;
	
	/**
	 * コンストラクタ NameSelectionStatus
	 * 
	 * @param String firstMsg
	 * @param String promptMsg
	 * @param boolean IsEndStatus
	 * @param DisplayPersonsByNameStatus next
	 */
	NameSelectionStatus(String firstMsg, String promptMsg, boolean IsEndStatus, 
			DisplayPersonsByNameStatus next) {
		super(firstMsg, promptMsg, IsEndStatus);
		this.next = next;
	}

	/**
	 * 次の状態に遷移することを促すためのメッセージの表示
	 * 
	 * InputMessage
	 * @throws IOException
	 * @return String
	 */
	public String inputMessage () throws IOException {
		String msg = super.inputMessage();
		next.setName(msg);
		
		return msg;
	}
	
	/**
	 * このクラスは、次にDisplayPersonsByNameStatusを呼ぶと
	 * 決まっているため、何が入力されても
	 *  DisplayPersonsByNameStatusに遷移するようにしている
	 *  
	 *  getNextStatus
	 *  @param String s
	 *  @return ConsoleStatus
	 */
	public ConsoleStatus getNextStatus (String s) {
		return next;
	}
}
