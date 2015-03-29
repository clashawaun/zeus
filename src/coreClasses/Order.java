package coreClasses;
import java.util.ArrayList;

public class Order 
{
	private final String ID;
	private ArrayList<String> productIds;
	private String shippingAddress;
	
	public Order(String id)
	{
		this.ID = id;
	}

	public ArrayList<String> getProductIds() {
		return productIds;
	}

	public void setProductIds(ArrayList<String> productIds) {
		this.productIds = productIds;
	}

	public String getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public String getID() {
		return ID;
	}
	
	
}
