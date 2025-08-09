package haken;

import java.io.IOException;

/**
 * UpdatePersonStatus
 */
public class UpdatePersonStatus extends ConsoleStatus {
	// フィールド
	private PersonList pl;
	
	private String[] messages = {
			"1. 氏名¥t¥t2. 住所¥n",
			"3. 電話番号¥t¥t4. 職種¥n",
			"5. 勤続年数¥t¥t6. 単価¥n"
	};
	private String data;
	
	/**
	 * コンストラクタ UpdatePersonStatus
	 * 
	 * @param String firstMsg
	 * @param String promptMsg
	 * @param boolean IsEndStatus
	 * @param PersonList pl
	 */
	UpdatePersonStatus(String firstMsg, String promptMsg, boolean IsEndStatus, PersonList pl) {
		super(firstMsg, promptMsg, IsEndStatus);
		this.pl = pl;
		this.data = "";
	}

	/**
	 * 最初に出力するメッセージを表示する
	 * このクラスでは従業員のデータの更新処理のみを行う
	 * 
	 * displayFirstMsg
	 * @throws IOExceeption
	 */
	public void displayFirstMsg () throws IOException {
		int id, no, num;
		
		// IDの入力
		System.out.println("従業員IDを入力してください。¥n＞");
		data = inputMessage();
		
		try {
			id = Integer.parseInt(data); // 従業員ID
			
		} catch (NumberFormatException e) {
			System.out.println("数値に変換できないデータが入力されています。");
			System.out.println("再入力してください。");
			displayFirstMsg();
			return;
		}
		
		Person p = pl.get(id);
		if (p == null) {
			System.out.println("指定のIDの従業員は存在しません。");
			System.out.println("再入力してください。");
			displayFirstMsg();
			return;
		}
		
		// 従業員の情報出力
		System.out.println(p.toString());
		
		System.out.println("¥n更新したい項目を入力してください。");
		// messagesの各文字列を順に表示する
		for (int idx = 0; idx < messages.length; idx++) {
			System.out.println(messages[idx]);
		}
		
		// 更新する項目の番号の入力
		System.out.println("¥n更新する項目の番号を入力してください。¥n＞");
		data = inputMessage();
		
		try {
			no = Integer.parseInt(data); // 更新する項目の番号
			if (no == 5 || no == 6) {
				num = Integer.parseInt(data); // 勤続年数または単価
				if (no == 5) {
					p.setWorkingYears (num);
				} else {
					p.setPrice(num);
				}
			} else if (no >= 1 && no <= 4){
				switch (no) {
				case 1:
					p.setName(data);
					break;
				case 2:
					p.setAddress(data);
					break;
				case 3:
					p.setTel(data);
					break;
				case 4:
					p.setType(data);
					break;
				default:
						break;
				}
				
			}
		} catch (NumberFormatException e) {
			System.out.println("数値に変換できないデータが入力されています。");
			System.out.println("再入力してください。");
			displayFirstMsg();
			return;
		}
	}
	
	/**
	 * 次の状態に遷移することを促すためのメッセージの表示
	 * このクラスは、初期状態に戻ると決まっていているため、何が
	 * 入力されても初期状態に遷移するようにしている。
	 * 
	 * getNextStatus
	 * @param String s
	 * @return ConsoleStatus
	 */
	public ConsoleStatus getNextStatus (String s) {
		return super.getNextStatus(" ");
	}
}
