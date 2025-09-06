package haken;

import java.util.ArrayList;
import java.util.List;

public class WorkList implements RecordList {
	// フィールド
	private List<Work> list;
	private ClientList c_list;
	
	/**
	 * コンストラクタ WorlList
	 * @param Client c_list
	 */
	WorkList (ClientList c_list) {
		this.list = new ArrayList<Work>();
		this.c_list = c_list;
	}
	
	/**
	 * コンストラクタ WorkList
	 * 
	 * @param List<Work> al
	 * @param ClientList c_list
	 */
	WorkList(List<Work> al, ClientList c_list) {
		this.list = al;
		this.c_list = c_list;
	}
	
	/**
	 * size
	 * @param int
	 */
	public int size() {
		return list.size();
	}
	
	/**
	 * add リストにレコードを追加
	 * @param Work w
	 */
	public void add(Work w) {
		for (int idx = 0; idx < list.size(); idx++) {
			Work widx = list.get(idx);
			
			// 同じIDのレコードがある場合
			if (widx.getID() == w.getID())
				// 何もせず終了
				return;
			else if (widx.getID() > w.getID()) {
				// レコードを追加
				list.add(idx, w);
				return;
			}	
		}
		// リスト末尾にレコードを追加
		list.add(w);
	}
	
	/**
	 * add 実装されたメソッド
	 * @param String data
	 * @throws Exception
	 */
	public void add(String data) throws Exception {
		Work w = new Work (data);
		add (w);
	}

	/**
	 * getRecord レコードを取得（実装されたメソッド）
	 * @param int idx
	 * @return Record
	 */
	public Record getRecord(int idx) {
		if (idx >= list.size())
			return null;
		else
			return list.get(idx);
	}

	/**
	 * delete 削除
	 * @param int ID
	 * @return boolean
	 */
	public boolean delete (int ID) {
		Work w;
		if (find(ID) == -1)
			return false;
		else {
			w = get(ID);
			w.setEraseFlag(true);
			return true;
		}
	}

	
	
	/**
	 * allDisplay
	 */
	public void allDisplay () {
		for (Work w : list) {
			System.out.println(w.toString());
		}
	}
	// 顧客名とともにID、稼働開始年月日、稼働終了年月日を出力する。
	/**
	 * displayWithClient
	 */
	public void displayWithClient () {
		Client c;
		
		for (Work w : list) {
			if (!w.getEraseFlag()) {
				System.out.println(w.getID() + "¥t");
				System.out.println(w.getStartTime() + "〜");
				System.out.println(w.getEndTime() + "¥t");
				
				c = c_list.get(w.getClientID());
				if(c != null) {
					System.out.print(c.getName());
				} else {
					System.out.println("（顧客が存在しません。）");
				}
			}
		}
	}
	
	/**
	 * find
	 * @param int ID
	 * @return int
	 */
	public int find(int ID) {
		// 引数のIDと同じIDをもつレコードの位置を検索
		for (int idx = 0; idx < list.size(); idx++) {
			Work widx = list.get(idx);
			
			if (widx.getID() == ID)
				return idx;
		}
		return -1;
	}
	

	/**
	 * get
	 * @param int ID
	 * @return Work
	 */
	public Work get(int ID) {
		Work w;
		
		// 引数のIDと同じIDをもつレコードが存在するらば、そのレコードを返す
		int idx;
		if ((idx = find(ID)) != -1) {
			w = list.get(idx);
			
			// 削除フラグ＝falseなら該当レコードを返す
			if (!w.getEraseFlag())
				return w;
			else
				return null;
		}
		else
			return null;
	}
	
	/**
	 * searchByPersonID 従業員IDで検索する
	 * 
	 * @param int pID
	 * @return WorkList
	 */
	public WorkList searchByPersonID (int pID) {
		
		ArrayList<Work> l = new ArrayList<Work>();
		
		for (int idx = 0; idx < list.size(); idx++) {
			Work w = list.get(idx);
			
			// idx番目のレコードのpersonID (従業員ID)が引数のpIDと一致するかどうかを確認する
			if (w.getPersonID() == pID && !w.getEraseFlag()) {
				l.add(w);
			}
		}
		
		return new WorkList (l, c_list);
	}

}
