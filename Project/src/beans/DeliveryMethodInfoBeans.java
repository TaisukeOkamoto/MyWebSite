package beans;

/**
 * 配送方法
 * @author okamototaisuke
 *
 */
public class DeliveryMethodInfoBeans {

	private int id;
	private String deliveryName;
	private int deliveryPrice;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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



}
