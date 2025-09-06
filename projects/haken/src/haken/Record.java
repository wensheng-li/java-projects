package haken;

public abstract class Record {
	/**
	 * フィールド
	 */
	private int ID;
	private boolean eraseFlag;
	
	/**
	 * コンストラクタ Record
	 */
	Record() {
		this.ID = -1;
		this.eraseFlag = false;
	}
	
	/**
	 * コンストラクタ Record
	 * @param iD
	 * @param eraseFlag
	 */
	Record(int iD, boolean eraseFlag){
		this.ID = iD;
		this.eraseFlag = eraseFlag;
	}
	
	/**
	 * getID
	 * @return int
	 */
	public int getID() {
		return ID;
	}
	
	/**
	 * setID
	 * @param int iD
	 */
	public void setID(int iD) {
		ID = iD;
	}
	
	/**
	 * getEraseFlag
	 * @return boolean
	 */
	public boolean getEraseFlag() {
		return eraseFlag;
	}
	
	/**
	 * setEraseFlag
	 * @param boolean eraseFlag
	 */
	public void setEraseFlag(boolean eraseFlag) {
		this.eraseFlag = eraseFlag;
	}
	
	// 抽象メソッド
	// writeForCSV
	/**
	 * 実装内容：CSVファイルに出力する値を戻る
	 * @return String
	 */
	public abstract String writeForCSV();
	
}
