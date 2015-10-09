package ie.wit.abs;

public abstract class Device 
{
	protected int id;
	protected String title;
	protected double price;
	
	public Device()
	{
		this.id = 0;
		this.title = "";
		this.price = 0.0;	
	}
	
	public Device(int id, String title, double price) {
		this.id = id;
		this.title = title;
		this.price = price;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	public abstract void play();

	public abstract String decoder();

	public String getInfo() { return this.toString(); }
	
	
}
