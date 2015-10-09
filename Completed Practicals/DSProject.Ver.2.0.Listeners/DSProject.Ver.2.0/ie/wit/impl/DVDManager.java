package ie.wit.impl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import ie.wit.abs.Device;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JTextField;



public class DVDManager 
{
	private static Icon myIcon = getImageResource("/images/logosmall.gif");
	private static Icon anIcon = new ImageIcon();
	private static int currentSize = 0, maxSize = 10;
	
	private Device[] DeviceList = new Device[maxSize];

////////////////////////////////////////////////////////////////////////////////////////
	public DVDManager()
	{
		   Dvd aDVD = new Dvd(101,"Batman",9.99,2);
		   DeviceList[currentSize] = aDVD;
		   currentSize++;
		   
		   Cd aCD = new Cd(102,"21",12.99,"Adele");
		   DeviceList[currentSize] = aCD;
		   currentSize++;
	}
private static ImageIcon getImageResource(String path) {
	
	URL url = DVDManager.class.getResource(path);
	return new ImageIcon(url);
}
////////////////////////////////////////////////////////////////////////////////////////	
	 
	public int menuMain()
	{
		int option = 0;
		
		   String opt1 = new String("1. Add a Device :");
		   String opt2 = new String("2. Play a Device :");
		   String opt3 = new String("3. List All Devices :");
		   String opt4 = new String("4. Exit :");
		   String msg = new String("Enter Option:");
		   JTextField opt = new JTextField("");
		   
		   Object message[] = new Object[7];

		   message[0] = myIcon;
		   message[1] = opt1;
		   message[2] = opt2;
		   message[3] = opt3;
		   message[4] = opt4;
		   message[5] = msg;
		   message[6] = opt;

		   int response = JOptionPane.showConfirmDialog(null,message,"Device Data Entry",JOptionPane.OK_CANCEL_OPTION,
				                                        JOptionPane.QUESTION_MESSAGE ,anIcon);
		   
		   if(response == JOptionPane.CANCEL_OPTION)
			   ;
		   else
		   	{
			   try {
				   option = Integer.parseInt( opt.getText());
			   	   }
			   catch (Exception e)
			   {
			   JOptionPane.showMessageDialog(null,"Data Input Error" + e + "\nPlease Try Again");
			   }
		   	}
		   return option;
	}	
////////////////////////////////////////////////////////////////////////////////////////
public void menuAddDevice()
{
	   String msgID = new String("Device ID :");
	   String msgName = new String("Device Title :");
	   String msgPrice = new String("Device Price :");
	   String msgRegion = new String("Region (if applicable) :");
	   String[] regions = {"Not A DVD", "1", "2", "3", "4"};
	   
	   String msgArtist = new String("Artist :");
	   
	   JTextField id = new JTextField("");
	   JTextField name = new JTextField("");
	   JTextField price = new JTextField("");
	   JComboBox region = new JComboBox(regions);
	   JTextField artist = new JTextField("");
	   
	   region.addActionListener(new ComboListener(artist));
	   
	   Object message[] = new Object[12];

	   message[0] = myIcon;
	   message[1] = msgID;
	   message[2] = id;
	   message[3] = msgName;
	   message[4] = name;
	   message[5] = msgPrice;
	   message[6] = price;
	   message[7] = msgRegion;
	   message[8] = region;
	   message[9] = msgArtist;
	   message[10] = artist;
	   
	   int response = JOptionPane.showConfirmDialog(null,message,"Device Data Entry",JOptionPane.OK_CANCEL_OPTION,
			                                        JOptionPane.QUESTION_MESSAGE ,anIcon);
	   
	   if(response == JOptionPane.CANCEL_OPTION)
		   ;
	   else
	   	{
		   try {
		
			   if(region.getSelectedIndex() != 0)
			   {
			   Dvd d = new Dvd();
			   
			   d.setId( Integer.parseInt( id.getText()) );
			   d.setTitle( name.getText() );
			   d.setPrice( Double.parseDouble( price.getText()) );
			   d.setRegion(Integer.parseInt( (String) region.getSelectedItem()));
			   
		       addDeviceToList(d);
		   	   }
			   else
				   {
					   Cd c = new Cd();
					   
					   c.setId( Integer.parseInt( id.getText()) );
					   c.setTitle( name.getText() );
					   c.setPrice( Double.parseDouble( price.getText()) );
					   c.setArtist(artist.getText());
					   
				       addDeviceToList(c);
				   }
		   }
		   catch (Exception e)
		   {
		   JOptionPane.showMessageDialog(null,"Data Input Error" + e + "\nPlease Try Again");
		   }
	   	}
}
//////////////////////////////////////////////////////////////////////////////////////
private void addDeviceToList(Device d)
{
	try {
		DeviceList[currentSize] = d;
		currentSize++;
	}
		
	catch (Exception sqle)
			{
			JOptionPane.showMessageDialog(null,"Insert Into List Error" + sqle);	
			}	
}
//////////////////////////////////////////////////////////////////////////////////////
public void menuPlayDevice()
{
	String txtID = JOptionPane.showInputDialog("Please Enter the ID of the Device to Play");
    int id = Integer.parseInt(txtID);
    boolean found = false;
    int i = 0;
    
    while(!found && (DeviceList[i] != null) )
    	{
    	if(DeviceList[i].getId() == id)
    		{
    		    DeviceList[i].play();
                found = true;
    		}
    	i++;
    	}
    
    if(!found) JOptionPane.showMessageDialog(null,"Sorry, ID Does Not Exist..");

}
//////////////////////////////////////////////////////////////////////////////////////
public void menuListDevices()
{
	JOptionPane.showMessageDialog(null,DeviceList);
}
/////////////////////////////////////////////////////////////////////////////////////
private class ComboListener implements ActionListener
{
	private JTextField artist;

	public ComboListener(JTextField artist)
	{
		this.artist = artist;
	}

	public void actionPerformed(ActionEvent e) {
		JComboBox jcb = (JComboBox) e.getSource();
		
		if(jcb.getSelectedIndex() == 0)
			artist.setEnabled(true);
			else
				artist.setEnabled(false);
	}
}
/////////////////////////////////////////////////////////////////////////////////////
}
