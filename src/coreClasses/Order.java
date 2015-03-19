package coreClasses;
import java.util.List;

public class Order 
{
	private final String ID;
	private List<String> productIds;
	private String shippingAddress;
	
	public Order(String id)
	{
		this.ID = id;
	}

	public List<String> getProductIds() {
		return productIds;
	}

	public void setProductIds(List<String> productIds) {
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
