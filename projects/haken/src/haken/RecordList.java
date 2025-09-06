package haken;

/**
 *  RecordList
 */
interface RecordList {
	// 抽象メソッド
	/**
	 * add
	 * 実装内容：レコードを追加する。
	 * @param data
	 * @throws Exception
	 */
	public abstract void add (String data) throws Exception;
	
	// 抽象メソッド
	/**
	 * getRecord
	 * 実装内容：レコードを追加する。
	 * @param idx
	 * @return Record
	 */
	public abstract Record getRecord (int idx);
	
	// 抽象メソッド
	/**
	 * size
	 * 実装内容：レコード件数を取得する
	 * @return int
	 */
	public abstract int size();

}
