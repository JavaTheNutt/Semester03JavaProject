package ie.wit.impl;

import ie.wit.abs.Device;

import javax.swing.*;

public class Dvd extends Device {

protected int region;

public Dvd() 
{
	super();
	this.region = 0;
}

public Dvd(int id, String title, double price, int region) 
{
	super(id,title,price);
	this.region = region;
}

public int getRegion() {
	return region;
}
public void setRegion(int region) {
	this.region = region;
}

public String toString() {
	return "DVD INFO [id=" + id + ", title=" + title + ", price=" + price + ", region=" + region + "]\n";
}

public void play() 
{
JOptionPane.showMessageDialog(null,"This is a Video Clip of " + this.title + " Playing");	
}

public String decoder()
{
	return ".AVI";
}

public String getInfo() { return this.toString(); }

}

