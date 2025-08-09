package haken;

public class DeleteWorkStatus extends ConsoleStatus {
	// フィールド
		private PersonList pl;
		private WorkList wl;
		private int id = -1;
		private String data;
		private WorkList selectedWl = null;
		
		/**
		 * コンストラクタ DeletePersonStatus
		 * 
		 * @param String firstMsg
		 * @param String promptMsg
		 * @param boolean IsEndStatus
		 * @param PersonList pl
		 */
		DeleteWorkStatus(String firstMsg, String promptMsg, boolean IsEndStatus, PersonList pl, WorkList wl) {
			super(firstMsg, promptMsg, IsEndStatus);
			this.pl = pl;
			this.wl = wl;
			this.id = -1;
			this.data = "";
			this.selectedWl = null;
		}
		
		/**
		 * 最初に出力するメッセージを表示する
		 * このクラスでは従業員のデータの削除処理のみを行う
		 * 
		 * displayFirstMsg
		 * @throws Exception
		 */
		public void displayFirstMsg () throws Exception {
			String comma;
			
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
			
			selectedWl = wl.searchByPersonID(p.getID());
			// 指定した従業員IDの従業員が割り当てられている稼働の表示
			selectedWl.displayWithClient();
			
			System.out.print("削除する稼働ID入力してください。¥n[ ");
			comma = "";
			for (int idx = 0; idx < wl.size(); idx++) {
				Work w = selectedWl.get(idx);
				
				// idxの値と同じ稼働IDのレコードがない場合、飛ばす
				if (w == null) continue;
				System.out.println(comma + w.getID());
				comma = ", ";
			}
			System.out.print("]＞");
			data = inputMessage();
			
			try {
				id = Integer.parseInt(data); // 削除する稼働ID
			} catch (NumberFormatException e) {
				id = -1;
			}
		}
		
		/**
		 * Y が入力された場合指定されたレコードを削除、
		 * N（またはそれ以外）の場合何もせずに初期状態に遷移するようにしている
		 * 
		 * getNextStatus
		 * @param String s
		 * @return ConsoleStatus
		 */
		public ConsoleStatus getNextStatus (String s) {
			if (s.equals("Y")) {
				wl.delete(id);
				System.out.println("削除しました。");
			}
			
			return super.getNextStatus(" ");
		}
}
