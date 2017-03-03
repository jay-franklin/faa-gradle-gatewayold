package faa.utils;

import java.io.*;
import java.text.*;
import java.util.*;

public class LogToFile {

   private static String logFile = "C:\\Users\\jfrankl6\\Tools\\TestResults\\JayTestResults.txt";
   private final static DateFormat df = new SimpleDateFormat ("yyyy.MM.dd  hh:mm:ss ");

   private LogToFile() { }
   
   public static void setLogFilename(String filename) {
       logFile = filename;
       new File(filename).delete();

       try {
           write("LOG file : " + filename);
       }
       catch (Exception e) { 
           System.out.println(stack2string(e));
       }
       
   }
   
   public static void write(String msg) {
       write(logFile, msg);
   }
   
   public static void write(Exception e) {
       write(logFile, stack2string(e));
   }

   public static void write(String file, String msg) {
       try {
           Date now = new Date();
           String currentTime = LogToFile.df.format(now); 
           FileWriter aWriter = new FileWriter(file, true);
           aWriter.write(currentTime + " " + msg 
                   + System.getProperty("line.separator"));
           System.out.println(currentTime + "\t " + msg);
           aWriter.flush();
           aWriter.close();
       }
       catch (Exception e) {
           System.out.println(stack2string(e));
       }
   }
   
   private static String stack2string(Exception e) {
       try {
           StringWriter sw = new StringWriter();
           PrintWriter pw = new PrintWriter(sw);
           e.printStackTrace(pw);
           return "------\r\n" + sw.toString() + "------\r\n";
       }
       catch(Exception e2) {
           return "bad stack2string";
       }
   }
}

