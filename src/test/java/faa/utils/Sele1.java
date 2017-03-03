package faa.utils;
import java.io.*;
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


public class Sele1
{

    public static void main(String[] args)
    {
        // TODO Auto-generated method stub
        //String FileName = "C:\\Users\\u304081\\Desktop\\Java\\new.xlsx";
        String fileName = "C:\\Users\\jfrankl6\\Tools\\TestResults\\JayTestResults.xlsx";

        try 
        {
            FileInputStream fileInputStream3 = new FileInputStream(fileName);
            File outputsheetfile1 = new File(fileName);
            if(outputsheetfile1.exists()) 
            {
                System.out.println("File existed");
                try
                {
                    XSSFWorkbook ObjWorkBook = new XSSFWorkbook(fileInputStream3);
                    XSSFSheet DriverTableSheet = ObjWorkBook.getSheetAt(0);
                    for(int i=1;i<3;i++)
                    {
                    XSSFRow row1 = DriverTableSheet.getRow(i);
                    XSSFCell Cell1 = row1.getCell(0);

                    System.out.println("Cell1"+ Cell1);
                    //System.out.println("Cell2"+ Cell2);
                     String str = "Abc";
                     Cell1.setCellValue(str);

                     FileOutputStream out1 = new FileOutputStream (fileName,false);
                     ObjWorkBook.write(out1);
                     fileInputStream3.close();
                    }

                } 
            catch (IOException e) 
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        }
    }