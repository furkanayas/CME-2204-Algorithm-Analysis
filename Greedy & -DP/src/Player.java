import java.util.ArrayList;

public class Player {

	String name;
	int position;
	int rating;
	int prices;
	double PriceQuality;
	int yerorder;
	
	public int getYerorder() {
		return yerorder;
	}

	public void setYerorder(int yerorder) {
		this.yerorder = yerorder;
	}

	public Player()
	{
		name ="nil";
		position = 0;
		rating = 0;
		prices = 0;
		PriceQuality = 0;
		yerorder = 0;
	}
	

	public Player(String name, int position, int rating, int prices, double priceQuality) {
		this.name = name;
		this.position = position;
		this.rating = rating;
		this.prices = prices;
		PriceQuality = priceQuality;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPosition() {
		return position;
	}
	public void setPosition(int position) {
		this.position = position;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public int getPrices() {
		return prices;
	}
	public void setPrices(int prices) {
		this.prices = prices;
	}
	public double getPriceQuality() {
		return PriceQuality;
	}
	public void setPriceQuality(double priceQuality) {
		PriceQuality = priceQuality;
	}
	
	void printPlayer()
	{
		System.out.println(name + " " + position + " " + rating + " " + prices + " " + PriceQuality);
	}
	
	
	
}
