package SeleniumActivities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class Activity13_2a {
	
	public void writeExcel(String filePath) {
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Test");
		
		List<String[]> data = new ArrayList<String[]>();
		String[] heading = {"ID", "First Name", "Last Name", "Email", "Ph.No."};
		String[] row1 = {"1", "Satvik", "Shah", "satshah@example.com", "4537829158"};
		String[] row2 = {"2", "Avinash", "Kati", "avinashK@example.com", "4892184058"};
		String[] row3 = {"3", "Lahri", "Rath", "lahri.rath@example.com", "4528727830"};
		
		data.add(heading);
		data.add(row1);
		data.add(row2);
		data.add(row3);
		
		//iterate over data and write to sheet
		
		int rownum = 0;
		for(String[] rowData : data) {
			Row row = sheet.createRow(rownum++);
			int cellnum = 0;
			for(String cellData : rowData) {
				Cell cell = row.createCell(cellnum++);
				cell.setCellValue(cellData);
			}
		}
		
		try {
			//this writes to the workbook
			FileOutputStream out = new FileOutputStream(new File(filePath));
			workbook.write(out);
			out.close();
			workbook.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void readExcel(String filePath) {
		try {
			FileInputStream file = new FileInputStream(filePath);
			
			//Create Workbook instance holding reference to Excel file
			XSSFWorkbook workbook = new XSSFWorkbook(filePath);
			
			//Get first sheet from the workbook
			XSSFSheet sheet = workbook.getSheetAt(0);
			
			//Iterate through each row one by one
			Iterator<Row> rowIterator = sheet.iterator();
			
			while(rowIterator.hasNext()) {
				Row row = rowIterator.next();
				
				//For each row, iterate through all the columns
				Iterator<Cell> cellIterator = row.iterator();
				
				while(cellIterator.hasNext()) {
					
					Cell cell = cellIterator.next();
					//Check the cell type and format accordingly
					switch(cell.getCellType()) {
					case NUMERIC:
						System.out.print(cell.getNumericCellValue() + " \t ");
						break;
					case STRING:
						System.out.print(cell.getStringCellValue() + " \t ");
						break;
					default:
						System.out.print("Invalid Value");
						break;
					}
				}
				System.out.println();
			}
			
			file.close();
			workbook.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		// Prepare the path of excel file
		String filePath = "C:\\Users\\AliKhan\\Desktop\\sample.xlsx";
		
		//Create an object of current class
        Activity13_2a objExcelFile = new Activity13_2a();
 
        //Write the file using file name, sheet name and the data to be filled
        objExcelFile.writeExcel(filePath);
        
        //Call read file method of the class to read data
        objExcelFile.readExcel(filePath);
		

	}
	
	

}
