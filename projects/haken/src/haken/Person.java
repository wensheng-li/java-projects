package haken;

/**
 * Person ＜ー　Recordクラスを継承
 */
public class Person extends Record{
	/**
	 * フィールド
	 */
	private String name; // 氏名
	private String address; // 住所
	private String tel; // 電話番号
	private String type; // 職種
	private int workingYears; // 勤続年数
	private int price; // 単価
	
	/**
	 * コンストラクタ・Constructor Person
	 * @param int ID
	 * @param String name
	 * @param String address
	 * @param String tel
	 * @param String type
	 * @param int workingYears
	 * @param int price
	 * @param boolean eraseFlag
	 */
	public Person(int ID, String name, String address, String tel, String type, int workingYears, int price, boolean eraseFlag) {
		super(ID, eraseFlag);
		this.name = name;
		this.address = address;
		this.tel = tel;
		this.type = type;
		this.workingYears = workingYears;
		this.price = price;
	}
	
	/**
	 * コンストクタ Person
	 * @param String record
	 * @throws Exception
	 */
	Person(String record) throws Exception {
		setData(record);
	}
	

	public void setData(String record) throws Exception {
		String[] n = record.split(","); // 	レコードを”,”で分割
		try {
			System.out.println();
			if (n.length != 8) {
				throw new ArrayIndexOutOfBoundsException ("不正なレコードを読み込みました。");
			}
				
			setID(Integer.parseInt(n[0]));
			name = n[1];
			address = n[2];
			tel = n[3];
			type = n[4];
			workingYears = Integer.parseInt(n[5]);
			price = Integer.parseInt(n[6]);
			if (n[7].equals("t")) setEraseFlag (false);
			else if (n[7].equals("f")) setEraseFlag (false);
			else throw new NumberFormatException ();	
			
		} catch (NumberFormatException e) {
			System.out.println("数値または削除に変換できない値がレコードに含まれています。");
			throw e;
		}
	}
	/**
	 *  toString
	 *  @return String ts
	 */
	public String toString () {
		String ts = "ID: " + getID() + "　氏名 : " + name 
				+ "¥n住所: " + address + "電話番号 : " + tel 
				+ "¥n職種: " + type + "¥n : " + workingYears + "年";
		
		return ts;
	}
	/**
	 * 抽象メソットwriteForCSVの実装
	 * ＠return String
	 */
	public String writeForCSV() {
		String s = "" + getID() + "," + name + "," + address + 
				"," + tel + "," + type + "," + workingYears + "," +
				"," + price + "," + (getEraseFlag() ? "t" : "f");
				
		return s;
	}

	/**
	 *  氏名を取得する：getName
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 *  住所を取得する：getAddress
	 * @return address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 *  電話番号を取得する：getTel
	 * @return tel
	 */
	public String getTel() {
		return tel;
	}

	/**
	 *  職種を取得する：getType
	 * @return type
	 */
	public String getType() {
		return type;
	}

	/**
	 *  勤続年数を取得する：getWorkingYears
	 * @return workingYears
	 */
	public int getWorkingYears() {
		return workingYears;
	}

	/**
	 *  単価を取得する：getPrice
	 * @return price
	 */
	public int getPrice() {
		return price;
	}

	/**
	 *  name 設定する
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 *  address 設定する
	 * @param address
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 *  電話番号を 設定する
	 * @param tel
	 */
	public void setTel(String tel) {
		this.tel = tel;
	}

	/**
	 *  type 設定する
	 * @param type
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 *  workingYears 設定する
	 * @param workingYears
	 */
	public void setWorkingYears(int workingYears) {
		this.workingYears = workingYears;
	}

	/**
	 *  price 設定する
	 * @param price
	 */
	public void setPrice(int price) {
		this.price = price;
	}
	}
