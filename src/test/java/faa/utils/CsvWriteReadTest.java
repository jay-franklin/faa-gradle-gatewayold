package faa.utils;

import java.io.File;
import java.io.PrintWriter;

/**package faa.utils;

 * @author ashraf
 *
 */
public class CsvWriteReadTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		String fileName = System.getProperty("user.home")+"/student.csv";
		//  pw = new PrintWriter(new File("C:\\Users\\jfrankl6\\Tools\\TestResults\\JayTestResults1.csv"));
		  
		
		System.out.println("Write CSV file:");
		CsvFileWriter.writeCsvFile(fileName);
		
		System.out.println("\nRead CSV file:");
		CsvFileReader.readCsvFile(fileName);

	}

}
