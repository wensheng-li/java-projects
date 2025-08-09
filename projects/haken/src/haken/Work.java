package haken;

public class Work extends Record {
	/**
	 * フィールド
	 */
	private int personID; // 従業員ID
	private int clientID; // 顧客ID
	private String startTime; // 稼働開始年月日
	private String endTime; // 稼働終了年月日
	private int price; // 契約単価
	
	/**
	 * 　コンストラクタ　Work
	 */
	Work (int ID, int personID, int clientID,
			String startTime, String endTime,
			int price, boolean eraseFlag) {
		super (ID, eraseFlag);
		this.personID = personID;
		this.clientID = clientID;
		this.startTime = startTime;
		this.endTime = endTime;
		this.price = price;
	}

	Work (String record) throws Exception {
		setData (record);
	}
	
	/**
	 * setData
	 * @param String record
	 * @throws Exception
	 */
	public void setData(String record) throws Exception {
		String[] n = record.split(","); // レコードを","で分割する。
		
		try {
			if (n.length != 7) throw new ArrayIndexOutOfBoundsException ("不正なレコードを読み込みました。");
			
			setID(Integer.parseInt(n[0]));
			personID = Integer.parseInt(n[1]);
			clientID = Integer.parseInt(n[2]);
			startTime = n[3];
			endTime = n[4];
			price = Integer.parseInt(n[5]);
			
			if (n[6].equals("t")) setEraseFlag (true);
			else if (n[6].equals("f")) setEraseFlag (false);
			else throw new NumberFormatException();
			
		} catch (NumberFormatException e) {
			System.out.println("数値また削除フラグに変換できない値がレコードに含まれています。");
		}
	}

	/**
	 * toString
	 * 
	 * @return String
	 */
	public String toString() {
		String ts = "ID: " + getID() + "　従業員ID：" + personID + "　顧客ID：" + clientID + "　" + startTime + "〜"
				+ endTime + "　契約単価：" + price;
		return ts;
	}

	/**
	 * 抽象メソットの実装
	 * 
	 * writeForCSV
	 * @return String
	 */
	public String writeForCSV() {
		String s = "" + getID() + "," + personID + "," + clientID +
				"," + startTime + "," + endTime + "," + price + "," + (getEraseFlag() ? "t" : "f");
		return s;
	}
	
	// Getters & Setters
	/**
	 * 従業員のIDを取得する　getPersonID
	 * 
	 * @return personID
	 */
	public int getPersonID() {
		return personID;
	}

	/**
	 * 顧客IDを取得する：getClientID
	 * 
	 * @return clientID
	 */
	public int getClientID() {
		return clientID;
	}

	/**
	 * 稼働開始年月日 getStartTime
	 * 
	 * @return startTime
	 */
	public String getStartTime() {
		return startTime;
	}

	/**
	 * 稼働終了年月日 getEndTime
	 * 
	 * @return endTime
	 */
	public String getEndTime() {
		return endTime;
	}

	/**
	 * 契約単価を取得する：getPrice
	 * 
	 * @return price
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * 従業員IDを設定する： personID
	 * 
	 * @param personID 
	 */
	public void setPersonID(int personID) {
		this.personID = personID;
	}

	/**
	 * @param clientIDを設定する： clientID
	 */
	public void setClientID(int clientID) {
		this.clientID = clientID;
	}

	/**
	 * 稼働開始年月日を設定する： startTime
	 * 
	 * @param startTime 
	 */
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	/**
	 * 稼働終了年月日を設定する： endTime
	 * 
	 * @param endTime 
	 */
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	/**
	 * 契約単価を設定する： price
	 * 
	 * @param price 
	 */
	public void setPrice(int price) {
		this.price = price;
	}

}
