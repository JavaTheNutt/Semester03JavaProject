package ie.wit.assignment.implObjects;

import ie.wit.assignment.exceptions.InputNotValidException;
import ie.wit.assignment.exceptions.ItemNotFoundException;
import ie.wit.assignment.exceptions.ListEmptyException;
import ie.wit.assignment.gui.PopUp;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Exchanger;

public class Collector implements Serializable
{
	private List<Collectible> list;
	private int type;

	public List<Collectible> getList()
	{
		return list;
	}

	public void setList(List<Collectible> list)
	{
		this.list = list;
	}

	public int getType()
	{
		return type;
	}

	public void setType(int type)
	{
		this.type = type;
	}

	public Collector(int type)
	{
		this.type = type;
		list = new ArrayList<>();
	}
	public boolean addItem(Collectible itemIn)
	{
		return list.add(itemIn);
	}
	public boolean removeItem(Collectible item)
	{
		try{
			checkExists(item);
			return list.remove(item);
		} catch(ListEmptyException e){
			PopUp.alertBox("Error", e.getMessage());
			return false;
		} catch (ItemNotFoundException e){
			PopUp.alertBox("Error", e.getMessage());
			return false;
		} catch (Exception e){
			PopUp.alertBox("Error", "An unknown error has occurred");
			return false;
		}

	}
	public boolean removeItem(String idIn)
	{
		return removeItem(getItem(idIn));
	}
	public int getIndex(Collectible itemIn)
	{
		try{
			checkExists(itemIn);
			return list.indexOf(itemIn);
		} catch(ListEmptyException e){
			PopUp.alertBox("Error", e.getMessage());
			return -999;
		} catch (ItemNotFoundException e){
			PopUp.alertBox("Error", e.getMessage());
			return -999;
		} catch (Exception e){
			PopUp.alertBox("Error", "An unknown error has occurred");
			return -999;
		}

	}

	private boolean checkEmpty() throws  ListEmptyException
	{
		if (list.isEmpty()){
			throw new ListEmptyException("The list is empty");
		}
		return true;
	}
	private boolean checkExists(Collectible itemIn)throws ItemNotFoundException, ListEmptyException
	{
		checkEmpty();
		if(list.indexOf(itemIn) < 0){
			throw new ItemNotFoundException("Item not found");
		}
		return true;
	}
	public Collectible getItem(String idIn)
	{
		try{
			checkEmpty();
			for (Collectible item : list){
				if (item.getId().equalsIgnoreCase(idIn)){
					return item;
				}
			}
			throw new ItemNotFoundException("The item was not found");
		} catch(ListEmptyException e){
			PopUp.alertBox("Error", e.getMessage());
			return null;
		} catch (ItemNotFoundException e){
			PopUp.alertBox("Error", e.getMessage());
			return null;
		} catch (Exception e){
			PopUp.alertBox("Error", "An Unknown error has occurred ");
			return null;
		}

	}

	public Collectible getItem(String fName, String lName)
	{
		try{
			checkEmpty();
			for (Collectible item : list){
				if(item.getFName().equalsIgnoreCase(fName) && item.getLName().equalsIgnoreCase(lName)){
					return item;
				}
			}
			throw new ItemNotFoundException("Item not found");
		} catch(ListEmptyException e){
			PopUp.alertBox("Error", e.getMessage());
			return null;
		} catch (ItemNotFoundException e){
			PopUp.alertBox("Error", e.getMessage());
			return null;
		} catch (Exception e){
			PopUp.alertBox("Error", "An Unknown error has occurred ");
			return null;
		}
	}
	public Collectible getItem(String[] names)
	{
		return getItem(names[0], names[1]);
	}
	public String[] getNamesInArray()
	{
		try{
			checkEmpty();
			String[] array = new String[list.size()];
			int i = 0;
			for(Collectible item : list){
				array[i] = item.getFName() + " " + item.getLName();
				i++;
			}
			return array;
		} catch (ListEmptyException e){
			PopUp.alertBox("Error", e.getMessage());
			return null;
		} catch (Exception e){
			PopUp.alertBox("Error", "An unknown error has occurred");
			return null;
		}

	}
	public String[] getNamesInArray(List<Collectible> listIn)
	{
		String[] array = new String[listIn.size()];
		int i = 0;
		for (Collectible item : listIn) {
			array[i] = item.getFName() + " " + item.getLName();
			i++;
		}
		return array;
	}
	public ObservableList<Collectible> getAsObservableList()
	{
		try{
			checkEmpty();
			ObservableList<Collectible> tempList = FXCollections.observableArrayList();
			for (Collectible item : list){
				tempList.add(item);
			}
			return tempList;
		} catch (ListEmptyException e){
			PopUp.alertBox("Error", e.getMessage());
			return null;
		} catch (Exception e){
			PopUp.alertBox("Error", "An unknown error has occurred");
			return null;
		}
	}
	public ObservableList<Collectible> getAsObservableList(ArrayList<Collectible> listIn){
		ObservableList<Collectible> tempList= FXCollections.observableArrayList();
		for(Collectible item : listIn){
			tempList.add(item);
		}
		return tempList;
	}
	public String getNameFromId(String idIn)
	{
		try{
			checkEmpty();
			for (Collectible item : list){
				if(item.getId().equals(idIn)){
					return item.getFName() + " " + item.getLName();
				}
			}
			throw new ItemNotFoundException("The item was not found");
		} catch(ListEmptyException e){
			PopUp.alertBox("Error", e.getMessage());
			return null;
		} catch(ItemNotFoundException e){
			PopUp.alertBox("Error", e.getMessage());
			return null;
		} catch (Exception e){
			PopUp.alertBox("Error", "An unknown error has occurred");
			return null;
		}

	}
	public String getIdFromName(String nameIn)
	{
		try{
			checkEmpty();
			if(!nameIn.contains(" ")){
				throw new InputNotValidException("Please enter a name with spaces");
			}
			String[] names = nameIn.split(" ");
			if(names.length > 2){
				throw new InputNotValidException("Please ensure that there is only a first name and surname");
			}
			return getIdFromName(names[0], names[1]);
		}catch (InputNotValidException e){
			PopUp.alertBox("Error", e.getMessage());
			return null;
		} catch(ListEmptyException e){
			PopUp.alertBox("Error", e.getMessage());
			return null;
		}  catch (Exception e){
			PopUp.alertBox("Error", "An unknown error has occurred");
			return null;
		}
	}
	public String getIdFromName(String fNameIn, String lNameIn)
	{
		try{
			checkEmpty();
			for(Collectible item : list){
				if(item.getFName().equalsIgnoreCase(fNameIn) && item.getLName().equalsIgnoreCase(lNameIn)){
					return item.getId();
				}
			}
			throw new ItemNotFoundException("The item was not found");
		}catch(ListEmptyException e){
			PopUp.alertBox("Error", e.getMessage());
			return null;
		} catch(ItemNotFoundException e){
			PopUp.alertBox("Error", e.getMessage());
			return null;
		} catch(Exception e){
			PopUp.alertBox("Error", "An unknown error has occurred");
			return null;
		}
	}
}
