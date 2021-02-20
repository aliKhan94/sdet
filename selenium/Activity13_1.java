package SeleniumActivities;

import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

public class Activity13_1 {

	public static void main(String[] args) throws IOException, CsvException {
		CSVReader reader = new CSVReader(new FileReader("C:\\Users\\AliKhan\\Desktop\\Sample.csv"));
		
		List<String[]> list = reader.readAll();
		
		System.out.println("No. of rows: "+list.size());
		
		Iterator<String[]> itr = list.iterator();
		
		while(itr.hasNext()) {
			String[] str = itr.next();
			
			System.out.print("Values are: ");
			for(int i = 0; i < str.length; i++) {
				System.out.print("\t"+str[i]);
			}
			
			System.out.println();
		}
		
		reader.close();

	}

}
