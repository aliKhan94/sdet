import java.util.Arrays;
import java.util.Scanner;

public class Activity1_4 {
	
	//Insertion Sort Method Implementation
	public static void insertionSort(int[] arr) {
		
		for(int i = 1; i < arr.length; i++) {
			int key = arr[i];
			int j = i -1;
			
			while(j >= 0 && key < arr[j]) {
					arr[j+1] = arr[j];
					j--;
				}
			arr[j+1] = key;
			
			}
		System.out.println(Arrays.toString(arr));
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Creating Scanner Class Object
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter input array size: ");
		int size = scan.nextInt();
		
		//array declaration
		int[] numArr = new int[size];
		
		//initializing an integer array
		System.out.println("Enter input array elements: ");
		for(int i = 0; i < size; i++) {
			numArr[i] = scan.nextInt();
		}
		scan.close();
		//Displaying Input Array
		System.out.println("Input array: ");
		System.out.println(Arrays.toString(numArr));
		
		//Displaying sorted array
		System.out.println("Sorted array in ascending order: ");
		insertionSort(numArr);
	}

}
