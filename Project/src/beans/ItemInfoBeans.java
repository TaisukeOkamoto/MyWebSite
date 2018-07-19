package beans;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * 商品情報
 * @author okamototaisuke
 *
 */
public class ItemInfoBeans implements Serializable {

	private int id;
	private String itemName;
	private String itemDetail;
	private int priceWithTax;
	private String fileName;
	private int lCategory;
	private int sCategory;
	private String sCategoryName;
	private int userType;
	private java.util.Date itemCreateDate;
	private java.util.Date itemUpdateDate;
	private int rate;
	private ArrayList <ItemInfoBeans> itemList;

	private int amount;

	public ItemInfoBeans(int id,String itemName,String itemDetail,int priceWithTax,String fileName,int lCategory,int sCategory,java.util.Date itemCreateDate,java.util.Date itemUpdateDate,int rate){
		this.id = id;
		this.itemName = itemName;
		this.itemDetail = itemDetail;
		this.priceWithTax = priceWithTax;
		this.fileName = fileName;
		this.setlCategory(lCategory);
		this.setsCategory(sCategory);
		this.itemCreateDate = itemCreateDate;
		this.itemUpdateDate = itemUpdateDate;
		this.rate = rate;
	}

	public ItemInfoBeans(String itemName,String itemDetail,int priceWithTax,String fileName,int lCategory,int sCategory,int userType,int rate){
		this.itemName = itemName;
		this.itemDetail = itemDetail;
		this.priceWithTax = priceWithTax;
		this.fileName = fileName;
		this.setlCategory(lCategory);
		this.setsCategory(sCategory);
		this.userType = userType;
		this.rate = rate;
	}

	public ItemInfoBeans() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemDetail() {
		return itemDetail;
	}

	public void setItemDetail(String itemDetail) {
		this.itemDetail = itemDetail;
	}

	public int getPriceWithTax() {
		return priceWithTax;
	}

	public void setPriceWithTax(int priceWithTax) {
		this.priceWithTax = priceWithTax;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public java.util.Date getItemCreateDate() {
		return itemCreateDate;
	}

	public void setItemCreateDate(java.util.Date itemCreateDate) {
		this.itemCreateDate = itemCreateDate;
	}

	public java.util.Date getItemUpdateDate() {
		return itemUpdateDate;
	}

	public void setItemUpdateDate(java.util.Date itemUpdateDate) {
		this.itemUpdateDate = itemUpdateDate;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}
	public ArrayList<ItemInfoBeans> getItemList() {
		return itemList;
	}
	public void setItemList(ArrayList<ItemInfoBeans> itemList) {
		this.itemList = itemList;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getUserType() {
		return userType;
	}

	public void setUserType(int userType) {
		this.userType = userType;
	}

	public int getlCategory() {
		return lCategory;
	}

	public void setlCategory(int lCategory) {
		this.lCategory = lCategory;
	}

	public int getsCategory() {
		return sCategory;
	}

	public void setsCategory(int sCategory) {
		this.sCategory = sCategory;
	}

	public String getsCategoryName() {
		return sCategoryName;
	}

	public void setsCategoryName(String sCategoryName) {
		this.sCategoryName = sCategoryName;
	}

}
