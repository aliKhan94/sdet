//Abstract class
abstract class Book {
	
	String title;
	//Abstract Method
	abstract void setTitle(String s);
	//Concrete Method
	public String getTitle() {
		return title;
	}
}

//Inheriting Abstract Class
class MyBook extends Book {
	//Defining Abstract Method
	public void setTitle(String s) {
		title = s;
	}
}

public class Activity2_1 {

	public static void main(String[] args) {
		//Initializing title
		String title = "Think Straight";
		
		//Creating Object fo MyBook Class
		MyBook newNovel = new MyBook();
		
		//Set title 
		newNovel.setTitle(title);
		//Print Result
		System.out.println("The title is: "+newNovel.getTitle());
	}

}
