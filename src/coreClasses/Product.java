package coreClasses;
import java.util.*;


public class Product 
{
	private final String ID;
	private String name;
	private String description;
	//Talk to cunt------
	private double price;
	//------------------
	private List<String> itemIds;
	private float heigth;
	private float width;
	private float depth;
	private float weight;
	private I_Priority priority;
	
	public Product(String id)
	{
		this.ID = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public List<String> getItemIds() {
		return itemIds;
	}

	public void setItemIds(List<String> itemIds) {
		this.itemIds = itemIds;
	}

	public float getHeigth() {
		return heigth;
	}

	public void setHeigth(float heigth) {
		this.heigth = heigth;
	}

	public float getWidth() {
		return width;
	}

	public void setWidth(float width) {
		this.width = width;
	}

	public float getDepth() {
		return depth;
	}

	public void setDepth(float depth) {
		this.depth = depth;
	}

	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	public I_Priority getPriority() {
		return priority;
	}

	public void setPriority(I_Priority priority) {
		this.priority = priority;
	}

	public String getID() {
		return ID;
	}
}
