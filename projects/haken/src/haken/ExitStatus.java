package haken;

public class ExitStatus extends ConsoleStatus {
	/**
	 * コンストラクタ ExistStatus
	 * 
	 * @param firstMsg
	 * @param promptMsg
	 * @param IsEndStatus
	 */
	ExitStatus(String firstMsg, String promptMsg, boolean IsEndStatus) {
		super(firstMsg, promptMsg, IsEndStatus);
	}
	
	/**
	 * システムを終了する特別なメッセージ
	 * 
	 * displayFirstMsg
	 */
	public void displayFirstMsg () {
		System.out.println("システムを終了します。");
	}
}
