
public class item {
	private String itemDetails;
	private int quantity;
	private double itemPrice;
	private double totalPrice;
	
	public item(String itemDetails, int quantity, double totalPrice)
	{
		this.itemDetails = itemDetails;
		this.quantity = quantity;
		
		this.totalPrice = totalPrice;
	}
	
	public String getItemDetails()
	{
		return itemDetails;
	}
	public int getQuantity()
	{
		return quantity;
	}

	public double getTotalPrice()
	{
		return totalPrice;
	}
	
	public void setItemDetails(String itemDetails)
	{
		this.itemDetails = itemDetails;
	}
	public void setQuantity(int quantity)
	{
		this.quantity = quantity;
	}
	public void setTotalPrice(float totalPrice)
	{
		this.totalPrice = totalPrice;
	}
}
