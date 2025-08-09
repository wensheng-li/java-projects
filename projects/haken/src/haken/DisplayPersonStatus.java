package haken;

public class DisplayPersonStatus extends ConsoleStatus {
	// フィールド
	private Person pe;
	private WorkList workList; // 稼働状況を得るために用いる稼働のリスト
	
	/**
	 * コンストクタ DisplayPersonStatus
	 * 
	 * @param String firstMsg
	 * @param String promptMsg
	 * @param WorkList workList
	 * @param boolean IsEndStatus
	 */
	DisplayPersonStatus(String firstMsg, String promptMsg, WorkList workList, boolean IsEndStatus) {
		super(firstMsg, promptMsg, IsEndStatus);
		this.pe = null;
		this.workList = workList;
	}
	
	/**
	 * setPersonResord
	 * @param Person pe
	 */
	public void setPersonRecord (Person pe) {
		this.pe = pe;
	}
	
	/**
	 * displayFirstMsg
	 */
	public void displayFirstMsg () {
		displayPerson();
	}
	
	/**
	 * displayPerson
	 * 選択された従業員のID、氏名などを表示する処理
	 */
	public void displayPerson() {
		// 従業員のレコードの内容を出力
		System.out.println(pe.toString());
		System.out.println("稼働状況ーーーーーーーーーーーーーーーーー");
		// 該当従業員が割り当てられいる
		// 稼働（Work）を表示
		WorkList wl = workList.searchByPersonID(pe.getID());
		wl.allDisplay();
	}
	
	// 入力内容が何があろうと、前の状態に戻る
	public ConsoleStatus getNextStatus (String s) {
		return super.getNextStatus(" ");
	}
}
