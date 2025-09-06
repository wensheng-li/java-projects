package haken;

import java.io.IOException;

public class TypeSelectionStatus extends ConsoleStatus {
	// フィールド
	private DisplayPersonByTypeStatus next;
	
	/**
	 * コンストラクタ TypeSelectionStatus
	 * 
	 * @param String firstMsg
	 * @param String promptMsg
	 * @param boolean IsEndStatus
	 * @param DisplayPersonByTypeStatus next
	 */
	TypeSelectionStatus(String firstMsg, String promptMsg, boolean IsEndStatus, DisplayPersonByTypeStatus next) {
		super(firstMsg, promptMsg, IsEndStatus);
		this.next = next;
	}
	
	/**
	 * inputMessage
	 * 次の状態に遷移することを促すためのメッセージの表示
	 * 
	 * @throws IOException
	 * @return String msg
	 */
	public String inputMessage () throws IOException {
		String msg = super.inputMessage();
		next.setWork(msg);
		
		return msg;
	}
	
	/**
	 * getNextStatus
	 * このクラスは、次にDisplayPersonByTypeStatusを呼ぶと
	 * 決まっているため、何が入力されてもDisplayPersonByTypeStatusに
	 * 遷移するようにしている
	 * 
	 * @param String s
	 * @return ConsoleStatus
	 */
	public ConsoleStatus getNextStatus (String s) {
		return next;
	}
}
