package beans;

import java.util.ArrayList;

public class BuyDetailInfoBeans {
	private int id;
	private int buyId;
	private int itemId;
	private int buyHowmany;

	private ArrayList <BuyDetailInfoBeans> BuyDetailInfoList;

	public ArrayList<BuyDetailInfoBeans> getBuyDetailInfoList() {
		return BuyDetailInfoList;
	}
	public void setBuyDetailInfoList(ArrayList<BuyDetailInfoBeans> buyDetailInfoList) {
		BuyDetailInfoList = buyDetailInfoList;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getBuyId() {
		return buyId;
	}
	public void setBuyId(int buyId) {
		this.buyId = buyId;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public int getBuyHowmany() {
		return buyHowmany;
	}
	public void setBuyHowmany(int buyHowmany) {
		this.buyHowmany = buyHowmany;
	}


}
