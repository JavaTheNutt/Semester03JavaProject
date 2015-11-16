package ie.wit.assignment.implObjects;

import ie.wit.assignment.exceptions.InputNotValidException;
import ie.wit.assignment.exceptions.ItemNotFoundException;
import ie.wit.assignment.exceptions.ListEmptyException;
import ie.wit.assignment.gui.PopUp;
import ie.wit.assignment.ie.wit.assignment.comparators.FirstNameComparator;
import ie.wit.assignment.ie.wit.assignment.comparators.IdComparator;
import ie.wit.assignment.ie.wit.assignment.comparators.SurnameComparator;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.Serializable;
import java.util.*;
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
		list = new LinkedList<>();
	}

	public boolean addItem(Collectible itemIn)
	{
		if (list.add(itemIn)) {
			ItemCounter.add(type);
			return true;
		}
		return false;
	}

	public boolean removeItem(Collectible item) throws ListEmptyException, ItemNotFoundException
	{
		checkExists(item);
		return list.remove(item);
	}

	public boolean removeItem(String idIn) throws ListEmptyException, ItemNotFoundException
	{
		return removeItem(getItem(idIn));
	}

	public int getIndex(Collectible itemIn) throws ListEmptyException, ItemNotFoundException
	{
		checkExists(itemIn);
		return list.indexOf(itemIn);
	}

	private boolean checkEmpty() throws ListEmptyException
	{
		if (list.isEmpty()) {
			throw new ListEmptyException("The list is empty");
		}
		return true;
	}

	private boolean checkExists(Collectible itemIn) throws ItemNotFoundException, ListEmptyException
	{
		checkEmpty();
		if (list.indexOf(itemIn) < 0) {
			throw new ItemNotFoundException("Item not found");
		}
		return true;
	}

	public Collectible getItem(String idIn) throws ListEmptyException, ItemNotFoundException
	{
		checkEmpty();
		list.sort(new IdComparator());
		int index = Collections.binarySearch(list, idIn);
		if (index >= 0) {
			return list.get(index);
		}
		throw new ItemNotFoundException("The item was not found");

	}

	public Collectible getItem(String fName, String lName) throws ListEmptyException, ItemNotFoundException
	{
		checkEmpty();
		/*int surnameIndex = searchSurname(lName);
		if(surnameIndex >= 0){
			int firstNameIndex = searchFirstName(fName);
			return list.get(firstNameIndex);
		}*/
		for (Collectible item : list) {
			if (item.getFName().equalsIgnoreCase(fName) && item.getLName().equalsIgnoreCase(lName)) {
				return item;
			}
		}
		throw new ItemNotFoundException("Item not found");
	}

	private int searchSurname(String surname)
	{
		list.sort(new SurnameComparator());
		return Collections.binarySearch(list, surname);
	}

	private int searchFirstName(String fName)
	{
		list.sort(new FirstNameComparator());
		return Collections.binarySearch(list, fName);
	}

	public Collectible getItem(String[] names) throws ListEmptyException, ItemNotFoundException
	{
		return getItem(names[0], names[1]);
	}

	public String[] getNamesInArray() throws ListEmptyException
	{
		checkEmpty();
		return getNamesInArray(list);
	}

	public String[] getNamesInArray(List<Collectible> listIn) throws ListEmptyException
	{
		String[] array = new String[listIn.size()];
		int i = 0;
		for (Collectible item : listIn) {
			array[i] = item.getFName() + " " + item.getLName();
			i++;
		}
		return array;
	}

	public ObservableList<Collectible> getAsObservableList() throws ListEmptyException
	{
		checkEmpty();
		return getAsObservableList(list);
	}

	public ObservableList<Collectible> getAsObservableList(List<Collectible> listIn)
	{
		ObservableList<Collectible> tempList = FXCollections.observableArrayList();
		for (Collectible item : listIn) {
			tempList.add(item);
		}
		return tempList;
	}

	public String getNameFromId(String idIn) throws ListEmptyException, ItemNotFoundException
	{
		checkEmpty();
		list.sort(new IdComparator());
		int itemIndex = Collections.binarySearch(list, idIn);
		if (itemIndex >= 0) {
			Collectible item = list.get(itemIndex);
			return item.getFName() + " " + item.getLName();
		}
		throw new ItemNotFoundException("The item was not found");
	}

	public String getIdFromName(String nameIn) throws ListEmptyException, ItemNotFoundException, InputNotValidException
	{
		checkEmpty();
		if (!nameIn.contains(" ")) {
			throw new InputNotValidException("Please enter a name with spaces");
		}
		String[] names = nameIn.split(" ");
		if (names.length > 2) {
			throw new InputNotValidException("Please ensure that there is only a first name and surname");
		}
		return getIdFromName(names[0], names[1]);
	}

	public String getIdFromName(String fNameIn, String lNameIn) throws ListEmptyException, ItemNotFoundException
	{
		checkEmpty();
		String id = getItem(fNameIn, lNameIn).getId();
		if (id != null) {
			return id;
		}
		throw new ItemNotFoundException("The item was not found");
	}
}
