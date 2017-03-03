package faa.utils;

import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

	public class WriteOpenCSV2 {

	    public static void main(String[] args) throws IOException {
	        String fileName = "C:\\Users\\jfrankl6\\Tools\\TestResults\\JayTestResults4.csv" ;
	    	//String outputFile = "users.csv";
	    	// before we open the file check to see if it already exists
//			boolean alreadyExists = new File(fileName).exists();
	    	
//			// if the file didn't already exist then we need to write out the header line
//			if (!alreadyExists)
//			{
//		        String[] items1 = {"id", "date", "firstname", "lastname" };
//		        List<String[]> header = new ArrayList<>();
//		        header.add(items1); 
//		        
//			}

//	        String[] items = {"id", "date", "firstname", "lastname" };
//	        List<String[]> data = new ArrayList<>();

//	        data.add(items); 
	        ArrayList<String> obj = new ArrayList<String>();
	        obj.add(0, "GP-142: Incorporate US Address Validation into Mailing Address - Happy path");
	        System.out.println("1 Current array list is:"+ obj);
	        obj.add(1, "GP-143: Incorporate US Address Validation into Physical Address - Happy path");
	        System.out.println("2 Current array list is:"+ obj);
	        obj.add("GP-145: Incorporate International Address Validation into Mailing Address - Happy path");
	        System.out.println("3 Current array list is:"+ obj);
	        obj.add("GP-145: Incorporate International Address Validation into Mailing Address - Happy path");
	        System.out.println("4 Current array list is:"+ obj);

	        List<String> sample = new ArrayList<String>(Arrays.asList("GP-142", "Incorporate US Address Validation into Physical Address - Happy path"));
	        System.out.println("5 Current array list sample is:"+ sample);
	        // obj.add(0, "GP-142: Incorporate US Address Validation into Mailing Address - Happy path");
	        
	        
//	        String[] items ={"GP-143", "Incorporate US Address Validation into Mailing Address - Happy path"};
//	        String[] items ={"GP-142", "Incorporate US Address Validation into Physical Address - Happy path"};
	        
	        //String[] items ={"GP-144", "Incorporate International Address Validation into Physical Address - Happy path"};
	        
	        
			// else assume that the file already has the correct header line
	        //String[] items = {"book", "coin", "pencil"};
	        //String[] items ={"GP-145", "Incorporate International Address Validation into Mailing Address - Happy path"};
	        //String[] items ={"GP-144", "Incorporate International Address Validation into Physical Address - Happy path"};
//	        String[] items ={"GP-143", "Incorporate US Address Validation into Mailing Address - Happy path"};
//	        String[] items ={"GP-142", "Incorporate US Address Validation into Physical Address - Happy path"};
//	        String[] items ={"GP-141", "US Address Validation - UI Scenario 1"};
//	        String[] items ={"GP-140", "US Address Validation - UI Scenario 2"};
//	        String[] items ={"GP-139", "US Address Validation - UI Scenario 4"};
//	        String[] items ={"GP-138", "US Address Validation - UI Scenario 5"};
//	        String[] items ={"GP-137", "International Address Validation - UI Scenario 2"};
//	        String[] items ={"GP-136", "International Address Validation - UI Scenario 4"};
//	        String[] items ={"GP-135", "US Address Validation - UI Scenario 3"};
//	        String[] items ={"GP-134", "International Address Validation - UI Scenario 3"};
//	        String[] items ={"GP-133", "International Address Validation - UI Scenario 1"};
//	        String[] items ={"GP-132", "2 Strike Rule (SS)"};
//	        String[] items ={"GP-131", "Application Refresh"};

	        
	        //	        String[] items2 = {"pen", "chair", "lamp"};
//	        String[] items3 = {"ball", "bowl", "spectacles"};

//	        List<String[]> entries = new ArrayList<>();
//	        entries.add(items1);
	        
//	        entries.add(items2);
//	        entries.add(items3);

//	        String fileName = "C:\\Users\\jfrankl6\\Tools\\TestResults\\JayTestResults1.csv" ;
//	        try (CSVWriter writer = new CSVWriter(new FileWriter(fileName,true))) {
//	            writer.writeAll(entries);
//	        }
	    }
	}
