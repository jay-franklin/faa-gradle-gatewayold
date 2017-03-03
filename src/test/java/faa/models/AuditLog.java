/**
 * 
 */
/**
 * @author jfranklin
 *
 */
	//package com.helloselenium.selenium.test;
	package faa.models;
	import faa.utils.DataGenerator;
	import java.io.*;
	import java.util.concurrent.TimeUnit;
	 
	import org.apache.poi.ss.usermodel.Cell;
	import org.apache.poi.xssf.usermodel.XSSFSheet;
	import org.apache.poi.xssf.usermodel.XSSFWorkbook;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.firefox.FirefoxDriver;
	 
//	public class SaveTestResultToExcelFile{
	public class AuditLog {
	public static void main(String[] args) { 
	 
	        WebDriver driver = new FirefoxDriver();
	 
	        driver.get("http://www.google.com");
	 
	        driver.manage().window().maximize();  
	       
	        WebElement searchbox = driver.findElement(By.name("q"));
	 
	 try {
	    
	  FileInputStream file = new FileInputStream(new File("C:\\testdata.xlsx")); 
	  XSSFWorkbook workbook = new XSSFWorkbook(file);
	 
	  XSSFSheet sheet = workbook.getSheetAt(0);
	 
	for (int i=1; i <= sheet.getLastRowNum(); i++){
	 
	        Cell resultCell= sheet.getRow(i).getCell(3);
	 
	        String keyword = sheet.getRow(i).getCell(2).getStringCellValue();
	 
	        searchbox.clear();
	 
	        searchbox.sendKeys(keyword);
	 
	        searchbox.submit();       
	  
	        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
	 
	        String searchText =  searchbox.getAttribute("value");
	 
	        if(searchText.equals(keyword)){
	                System.out.println("Search is successful.");
	                resultCell.setCellValue("PASS");
	        } else {
	                System.out.println("Search is not successful.");
	                resultCell.setCellValue("FAIL");
	        }
	 
	}
	 
	  workbook.close();
	  file.close();
	 
	  FileOutputStream outFile =new FileOutputStream(new File("C:\\testdata-result.xlsx"));
	  workbook.write(outFile);
	  outFile.close();
	 
	 } catch (FileNotFoundException fnfe) {
	  fnfe.printStackTrace();
	 } catch (IOException ioe) {
	  ioe.printStackTrace();
	 }
	 }
	}