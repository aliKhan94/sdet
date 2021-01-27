package JavaActivity2;

import java.util.Arrays;

public class Activity1_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] numArr = {10, 77, 10, 54, -11, 10};
		System.out.println("Original Array: " + Arrays.toString(numArr));
		int sum = 0;
		for(int x : numArr) {
			if (x == 10) {
				sum = sum + x;
			}
		}
		
		if (sum == 30)
			System.out.println("Yes, sum is 30");
		else
			System.out.println("No, it is not eqqual to 30");
	}

}
