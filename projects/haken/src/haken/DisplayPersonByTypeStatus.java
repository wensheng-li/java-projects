package haken;

/**
 * DisplayPersonByTypeStatus
 */
public class DisplayPersonByTypeStatus extends ConsoleStatus {
	// フィールド
	private String work;
	private PersonList plist;
	private PersonList selectedList;
	private DisplayPersonStatus next;
	
	/**
	 * コンストラクタ DisplayPersonByTypeStatus
	 * 
	 * @param String firstMsg
	 * @param String promptMsg
	 * @param boolean IsEndStatus
	 * @param PersonList plist
	 * @param DisplayPersonStatus next
	 */
	DisplayPersonByTypeStatus(String firstMsg, String promptMsg, boolean IsEndStatus,
			PersonList plist, DisplayPersonStatus next) {
		super(firstMsg, promptMsg, IsEndStatus);
		this.work = "";
		this.plist = plist;
		this.selectedList = null;
		this.next = next;
	}

	/**
	 * displayFirstMsg 最初に出力するメッセージを表示する
	 * @throws Exception
	 */
	public void displayFirstMsg () throws Exception {
		displayList();
		super.displayFirstMsg();
	}
	
	/**
	 * setWork
	 * @param String work
	 */
	public void setWork (String work) {
		this.work = work;
	}
	
	/**
	 * 入力された職種をもつ従業員のレコードだけを取り出す処理
	 * displayList
	 */
	public void displayList() {
		// 入力された職種をもつ従業員のレコードだけを
		// selectedListに取り出す
		selectedList = plist.searchByTypes(work);
		// selectedListの件数＝0ならば該当職種をもつ
		// 従業員はいないと表示
		if (selectedList.size() <= 0) {
			System.out.println("従業員が存在しません。");
		} else {
			selectedList.allDisplay();
		}
	}
	
	/**
	 * getNextStatus
	 * 次の状態に遷移すること促すためのメッセージの表示
	 * 
	 * @param String s
	 * @return ConsoleStatus
	 */
	public ConsoleStatus getNextStatus (String s) {
		// 数値が入力された場合、その数値と同じIDをもつ
		// レコードがselectedListにあるかどうか判定し、
		// あればそれを次の状態DisplayPersonStatusに渡す
		try {
			int i = Integer.parseInt(s);
			Person p = selectedList.get(i);
			
			if (p == null)
				return this;
			else {
				next.setPersonRecord(p);
				return next;
			}
		} catch (NumberFormatException e) {
			return super.getNextStatus(s);
		}
	}
}
