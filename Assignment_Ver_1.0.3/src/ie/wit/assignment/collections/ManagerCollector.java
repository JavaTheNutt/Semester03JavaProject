package ie.wit.assignment.collections;

public class ManagerCollector extends ListOfObjects 
{
	public ManagerCollector()
	{
		super();
	}
	public ManagerCollector(int sizeIn)
	{
		super(sizeIn, 1);
	}
	@Override
	private int search(String idIn) {
		if(!isEmpty()){
			for(int i = 0; i < totalObjects; i++){
				if(idIn.equals(list.getManagerId())){
					
				}
			}
		}
		
	}
	
}
