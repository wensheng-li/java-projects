package haken;

/**
 * Client <- Record クラスを継承
 */
public class Client extends Record {
	/**
	 * フィールド
	 */
	private String name; // 会社名
	private String address; // 住所
	private String tel; // 電話番号
	
	/**
	 * コンストラクタ　Client
	 * @param String record
	 * @throws Exception
	 */
	Client(String record) throws Exception {
		setData(record);
	}
	
	/**
	 * setData
	 * @param String record
	 * @throws Exception
	 */
	public void setData (String record) throws Exception {
		String[] n = record.split(","); // レコードを","で分割
		
		try {
			if (n.length != 5) throw new ArrayIndexOutOfBoundsException ("不正なレコードをよみこみました。");
			
			setID(Integer.parseInt(n[0]));
			name = n[1];
			address = n[2];
			tel = n[3];
			
			if (n[4].equals("t")) setEraseFlag(true);
			else if (n[4].equals("f")) setEraseFlag(false);
			else throw new NumberFormatException();
		} catch (NumberFormatException e) {
			System.out.println("数値または削除フラグに変換できない値がレコードに含まれています。");
			throw e;
		}
	}
	
	/**
	 * toString
	 * @return String
	 */
	public String toString() {
		String ts = "ID: " + getID() + "　会社名: " + name
				+ "　住所:" + address
				+ "　電話番号: " + tel;
		return ts;
	}
	
	/**
	 * 抽象メソッドwriteForCSVの実装
	 *  writeForCSV
	 *  @return String
	 */
	public String writeForCSV() {
		String s = "" + getID() + "." + name + "," + address +
				"," + tel + "," + (getEraseFlag() ? "t" : "f");
		
		return s;
	}

	/**
	 * 会社名を取得する：getName
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 *住所を取得する：getAddress
	 * @return address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * 電話番号を取得する：getTel
	 * @return tel
	 */
	public String getTel() {
		return tel;
	}

	/**
	 * 会社名name 設定する
	 * @param  name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 住所address 設定する
	 * @param  address
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * 電話番号tel 設定する
	 * @param  tel
	 */
	public void setTel(String tel) {
		this.tel = tel;
	}

}
