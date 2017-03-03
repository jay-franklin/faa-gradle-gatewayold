package faa.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;

public class CsvFile {


public static void main(String[]args){
PrintWriter pw = null;
try {
//	  private static String logFile = "C:\\Users\\jfrankl6\\Tools\\TestResults\\JayTestResults.csv";
    pw = new PrintWriter(new File("C:\\Users\\jfrankl6\\Tools\\TestResults\\JayTestResults1.csv" ));
//    FileWriter pw = new FileWriter("C:\\Users\\jfrankl6\\Tools\\TestResults\\JayTestResults1.csv", true );
    
} catch (FileNotFoundException e) {
    e.printStackTrace();
}
StringBuilder builder = new StringBuilder();
String ColumnNamesList = "Id,Name";
// No need give the headers Like: id, Name on builder.append
builder.append(ColumnNamesList +"\n");
builder.append("12"+",");
builder.append("Chola1");
builder.append('\n');
//builder.write(builder.toString());
//builder.close();
System.out.println("done!");
}
}