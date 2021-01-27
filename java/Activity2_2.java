import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class Plane {
    private List<String> passengers;
    private int maxPassengers;
    private Date lastTimeTookOf;
    private Date lastTimeLanded;
    
    Plane(int maxPassengers) {
    	this.maxPassengers = maxPassengers;
    	this.passengers = new ArrayList<>();
    	
    }
    
    
    public void onboard(String passenger) {
    	//TODO add passenger using add() method
    	
    	this.passengers.add(passenger);
    }
    
    public Date takeOff() {
    	//TODO returns current date and time
    	
    	this.lastTimeTookOf = new Date();
    	return lastTimeTookOf;
    }
    
    public void land(Date currentDate) {
    	//TODO sets the value of lastTimeLanded to the current date and time. Also clear() the array.
    	this.lastTimeLanded = currentDate;
    	this.passengers.clear();
    }
    
    public Date getLastTimeLanded() {
    	//TODO returns the value of lastTimeLanded
    	
    	return lastTimeLanded;
    }
    
    public List<String> getPassesngers() {
    	return passengers;
    }
}


public class Activity2_2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//There is a plane with max 10 passengers
		Plane plane = new Plane(10);
		//Adding names to the passengers list
		plane.onboard("Ali");
		plane.onboard("Nitin");
		plane.onboard("Neeraj");
		plane.onboard("Kaushik");
		//Print Take-off Time
		System.out.println("Plane take-off time: "+plane.takeOff());
		
		//Print Passengers list
		System.out.println("People on the plane: "+plane.getPassesngers());
		
		//Plane in flight..
		Thread.sleep(5000);
		
		//Land the plane
		plane.land(new Date());
		
		//Print time of landing 
		System.out.println("Plane landing time: "+plane.getLastTimeLanded());
		System.out.println("People on the plane after landing: "+plane.getPassesngers());
	}

}
