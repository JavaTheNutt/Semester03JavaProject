package ie.wit.impl;

import ie.wit.abs.Device;

import javax.swing.JOptionPane;

public class Cd extends Device
{

	protected String artist;

	public Cd() {
		super();
		this.artist = "";
	}
	public Cd(int id, String title, double price, String artist) {
	    super(id,title,price);
		this.artist = artist;
	}

	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String toString() {
		return "CD INFO [ id=" + id + ", title=" + title
				+ ", price=" + price + ", artist=" + artist + "]\n";
	}
	public void play() 
	{
	JOptionPane.showMessageDialog(null,"This is an Audo Clip of " + this.title + " Playing by " + this.artist);	
	}

	public String decoder()
	{
		return ".MP3";
	}
	
}
