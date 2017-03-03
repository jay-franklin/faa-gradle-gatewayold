package faa.utils;

import java.io.*;
import java.text.*;
import java.util.*;

//import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.lang.String;

import javax.swing.JOptionPane;

import jxl.Cell;

import org.apache.poi.hssf.util.CellReference;
import org.apache.poi.ss.formula.functions.Column;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFComment;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class LogToFileXlsx {

   private static String logFile = "C:\\Users\\jfrankl6\\Tools\\TestResults\\JayTestResults.xlsx";
   private final static DateFormat df = new SimpleDateFormat ("yyyy.MM.dd  hh:mm:ss ");

   private LogToFileXlsx() { }
   
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
           String currentTime = LogToFileXlsx.df.format(now); 
           FileWriter aWriter = new FileWriter(file, true);
           aWriter.write(currentTime + " " + msg 
                   + System.getProperty("line.separator"));
           System.out.println(currentTime + ", " + msg);
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

