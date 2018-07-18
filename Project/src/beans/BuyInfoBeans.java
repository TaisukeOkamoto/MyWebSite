package beans;

import java.io.Serializable;
import java.util.Date;

/**
 * 購入情報
 * @author okamototaisuke
 *
 */
public class BuyInfoBeans implements Serializable {

	private int id;
	private int userId;
	private int totalPrice;
	private int deliveryMethodId;
	private Date buyDate;

	private String deliveryName;
	private int deliveryPrice;
	private int buyId;

	public BuyInfoBeans() {

	}

	public BuyInfoBeans(int id,int totalPrice, String deliveryName,int deliveryPrice, Date buyDate) {
		this.id = id;
		this.totalPrice = totalPrice;
		this.deliveryName = deliveryName;
		this.deliveryPrice = deliveryPrice;
		this.buyDate = buyDate;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	public int getDeliveryMethodId() {
		return deliveryMethodId;
	}
	public void setDeliveryMethodId(int deliveryMethodId) {
		this.deliveryMethodId = deliveryMethodId;
	}
	public Date getBuyDate() {
		return buyDate;
	}
	public void setBuyDate(Date buyDate) {
		this.buyDate = buyDate;
	}

	public String getDeliveryName() {
		return deliveryName;
	}

	public void setDeliveryName(String deliveryName) {
		this.deliveryName = deliveryName;
	}

	public int getDeliveryPrice() {
		return deliveryPrice;
	}

	public void setDeliveryPrice(int deliveryPrice) {
		this.deliveryPrice = deliveryPrice;
	}

	public int getBuyId() {
		return buyId;
	}

	public void setBuyId(int buyId) {
		this.buyId = buyId;
	}


}
