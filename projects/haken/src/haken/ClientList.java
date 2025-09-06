package haken;

import java.util.ArrayList;
import java.util.List;

/**
 * ClientList 顧客リスト＜ー RecordListインタフェースを実装
 */
public class ClientList implements RecordList{
	// フィールド
	private List<Client> list;
	
	// コンストラクタ ClientList
	ClientList() {
		this.list = new ArrayList<Client>();
	}
	
	/**
	 * size 実装されたメソッド
	 * @return int
	 */
	public int size() {
		return list.size();
	}

	/**
	 * add 
	 * 
	 * @param String data
	 * @throws Exception
	 */
	public void add(String data) throws Exception {
		Client p = new Client(data);
		
		for (int idx = 0; idx < list.size(); idx++) {
			Client pidx = list.get(idx);
			// 同じIDのレコードがある場合
			if (pidx.getID() == p.getID()) {
				return; // 何もせず終了
			} else if (pidx.getID() > p.getID()) {
				// レコードを追加
				list.add(idx, p);
				return;
			}
		}
		// リスト末尾にレコードを追加
		list.add(p);
	}

	/**
	 * getRecord 実装されたメソッド
	 * 
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
	 * allDisplay
	 */
	public void allDisplay () {
		for (Client p : list) {
			System.out.println(p.toString());
		}
	}
	
	/**
	 * find IDで顧客リストに検索する
	 * 
	 * @param int ID
	 * @return int
	 */
	public int find (int ID) {
		// 引数のIDと同じIDをもつレコードの位置を検索
		for (int idx = 0; idx < list.size(); idx++) {
			Client pidx = list.get(idx);
			if (pidx.getID() == ID)
				return idx;
		}
		return -1;
	}
	
	/**
	 * get レコードを取得する
	 * 
	 * @param int ID
	 * @return Client
	 */
	public Client get(int ID) {
		// 引数のIDと同じIDをもつレコードが存在するならば、そのレコードを返す
		int idx;
		if ((idx = find(ID)) != -1)
			return list.get(idx);
		else
			return null;
	}
}
