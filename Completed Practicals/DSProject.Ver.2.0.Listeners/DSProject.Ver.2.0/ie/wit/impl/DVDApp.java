package ie.wit.impl;

public class DVDApp
{
 
	
   public static void main( String args[] )
   {
	   int option;

	   DVDManager manager = new DVDManager();
	   do {
	   option = manager.menuMain();
	   
	   	switch(option)
	   		{
	   	case 1  : manager.menuAddDevice();
	   			  break;
	   	case 2  : manager.menuPlayDevice();
	   			  break;
	   	case 3  : manager.menuListDevices();
	   		      break;		 
	   	case 4  : break;		
	   	default : break;
	   		}
	   } while(option != 4);
   } 			
}


