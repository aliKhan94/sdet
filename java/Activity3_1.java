import java.util.ArrayList;
import java.util.List;

public class Activity3_1 {

	public static void main(String[] args) {
		//creating arrayList
		
		List<String> myList = new ArrayList<String>();
		
		//Adding names in array list
		myList.add("Ali");
		myList.add("Neeraj");
		myList.add("Nitin");
		
		//adding object at specific index
		myList.add(1,"Kaushik");
		myList.add(3,"Sud");
		
		
		
		//Print all the names
		System.out.println("List of people: ");
		/*for(int i = 0; i < myList.size(); i++) {
			System.out.println(myList.get(i));
		}*/
		
		for(String s: myList) {
			System.out.println(s);
		}
		
		//Get 3rd name in the list
		System.out.println("3rd name in the list: "+myList.get(2));
		
		//Check name exists
		
		System.out.println("Is Neeraj in the list: "+myList.contains("Neeraj"));
		
		//Size of the list
		System.out.println("List befor deletion: "+myList);
		System.out.println("Size of the list: "+myList.size());
		
		//remove a name and print size of list
		myList.remove("Nitin");
		System.out.println("List size after removing: "+myList.size());
		System.out.println("List: "+myList);

	}

}
