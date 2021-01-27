package JavaActivity1;

public class Car {
	// Class Member Variables
	String color;
	String transmission;
	int make;
	int tyres;
	int doors;
	
	//Constructor
	Car() {
		tyres = 4;
		doors = 4;
	}
	
	//Class Methods
	void displayCharacteristics() {
		
		 System.out.println("Color of the car is "+color);
		 System.out.println("Transmission of the car is "+transmission);
		 System.out.println("Made in year "+make);
		 System.out.println("No. of tyres is "+tyres);
		 System.out.println("No of doors is "+doors);
	}
	
	void accelarate() {
		
		System.out.println("Car is moving forward.");
	}
	
	void brake() {
		
		System.out.println("Car has stopped.");
	}
}
