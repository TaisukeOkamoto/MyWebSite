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
	private int categoryId;
	private java.util.Date itemCreateDate;
	private java.util.Date itemUpdateDate;
	private int rate;
	private ArrayList <ItemInfoBeans> itemList;

	private int amount;

	public ItemInfoBeans(int id,String itemName,String itemDetail,int priceWithTax,String fileName,int categoryId,java.util.Date itemCreateDate,java.util.Date itemUpdateDate,int rate){
		this.id = id;
		this.itemName = itemName;
		this.itemDetail = itemDetail;
		this.priceWithTax = priceWithTax;
		this.fileName = fileName;
		this.categoryId = categoryId;
		this.itemCreateDate = itemCreateDate;
		this.itemUpdateDate = itemUpdateDate;
		this.rate = rate;
	}

	public ItemInfoBeans(String itemName,String itemDetail,int priceWithTax,String fileName,int categoryId,int rate){
		this.itemName = itemName;
		this.itemDetail = itemDetail;
		this.priceWithTax = priceWithTax;
		this.fileName = fileName;
		this.categoryId = categoryId;
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

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
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
}
