interface BicycleParts {
	public int gears = 0;
	public int currentSpeed = 0;
	
}

interface BicycleOperations {
	public void applyBrake(int decrement);
	public void speedUp(int increment);
}


class Bicycle implements BicycleParts, BicycleOperations {
	
	public int gears;
	public int currentSpeed;
	
	Bicycle(int gears, int currentSpeed) {
		this.gears = gears;
		this.currentSpeed = currentSpeed;
	}
	
	public void applyBrake(int decrement) {
		currentSpeed = currentSpeed - decrement;
	}
	
	public void speedUp(int increment) {
		currentSpeed = currentSpeed + increment;
	}
	
	public String bicycleDesc() {
		/*System.out.println("No. of gears: " + gears);
		System.out.println("Current speed of bicycle: " + currentSpeed);*/
		
		return ("No. of gears: " + gears +"\n" + "Current speed of bicycle: " + currentSpeed);
	}

}

class MountainBike extends Bicycle {
	
	public int seatHeight;
	
	MountainBike(int gears, int currentSpeed, int seatHeight) {
		super(gears, currentSpeed);
		this.seatHeight = seatHeight;
		
	}
	
	public void setHeight (int newValue) {
		seatHeight = newValue;
	}
	
	public String bicycleDesc() {
		
		return ("No. of gears: " + gears +"\n" + "Current speed of bicycle: " + currentSpeed + "\n" + "Seat height is: " + seatHeight);
	}
	
}


public class Activity2_3 {
	public static void main(String args[]) {
	    MountainBike mb = new MountainBike(4, 0, 20);
	    System.out.println(mb.bicycleDesc());
	    mb.speedUp(25);
	    mb.applyBrake(5);
	    
	    System.out.println("After applying speed: ");
	    System.out.println(mb.bicycleDesc());
	}
}