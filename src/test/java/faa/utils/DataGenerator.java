package faa.utils;

/////import au.com.bytecode.opencsv.CSVReader;
//import faa.cucumber.pages.FileWriter;

import com.opencsv.CSVReader;

import org.apache.commons.lang3.RandomStringUtils;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;
import org.openqa.selenium.WebElement;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
//import java.time.LocalDate;
//import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Properties;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/** Helper class that helps create random data like SSN's and Receipt numbers as
 * well as words and numbers. This class returns random data for use with
 * forms/entry data.
 * 
 * @author jfranklin */
public class DataGenerator {

	public static Properties serenityProperties;

	/** Returns a random number
	 * 
	 * @param length
	 *            - int - the number of numbers you want returned
	 * @return - String - random number */
	public static String randomNumber(int length) {
		return RandomStringUtils.randomNumeric(length);
	}

	/** @return random int between min and max */
	public static int randomIntegerBetween(int min, int max) {
		Random rand = new Random();
		return rand.nextInt((max - min) + 1) + min;
	}

	/** Returns a random date of birth over 12 years 9 months and under 85
	 * 
	 * @return String - Date format: mm/dd/yyyy */
	public static String randomBDay12to85() {
		Random rand = new Random();
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MONTH, -9);
		cal.add(Calendar.YEAR, -12);
		int randomNum = rand.nextInt((71 - 0) + 1) + 0;
		cal.add(Calendar.YEAR, -randomNum);
		randomNum = rand.nextInt((11 - 0) + 1) + 0;
		cal.add(Calendar.MONTH, -randomNum);
		randomNum = rand.nextInt((28 - 0) + 1) + 0;
		cal.add(Calendar.DATE, -randomNum);
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy");
		String year = format1.format(cal.getTime());
		format1 = new SimpleDateFormat("MM");
		String month = format1.format(cal.getTime());
		format1 = new SimpleDateFormat("dd");
		String day = format1.format(cal.getTime());
		return month + "/" + day + "/" + year;
	}

	/** returns random string with number and letters
	 * 
	 * @param length
	 *            - int - number of characters
	 * @return String - random alphanumeric */
	public static String randomAlphaNumeric(int length) {
		return RandomStringUtils.randomAlphanumeric(length);
	}

	public static String randomAlphabetic(int length) {
		return RandomStringUtils.randomAlphabetic(length);
	}

	/** @param length
	 *            - number of characters you want returned
	 * @param allowdSplChrs
	 *            - a string that contains the characters you would like
	 *            included in addition to alphanumeric. ie. "!@#$%^"
	 * @return String - random string */
	public static String randomStringWithAllowedSplChars(int length, String allowdSplChrs) {
		String allowedChars = "abcdefghijklmnopqrstuvwxyz" + // alphabets
				"1234567890" + // numbers
				allowdSplChrs;
		return RandomStringUtils.random(length, allowedChars);
	}

	/** Generates a random email in the correct format. test@test.org
	 * 
	 * @param length
	 *            - number of characters in the first part of the email. ie.
	 *            FirstPart@test.org
	 * @return - String - random email formatted String */
	public static String randomEmailFormattedString(int length) {
		length = length - 15;
		String allowedChars = "abcdefghijklmnopqrstuvwxyz" + // alphabets
				"1234567890" + // numbers
				"_-."; // special characters
		return RandomStringUtils.random(length, allowedChars) + "@faa.drone.test";
	}

	/** generates a URL format string
	 * 
	 * @param length
	 *            - String
	 * @return */
	public static String randomUrl(int length) {
		String allowedChars = "abcdefghijklmnopqrstuvwxyz" + // alphabets
				"1234567890" + // numbers
				"_-."; // special characters
		String url = "";
		String temp = RandomStringUtils.random(length, allowedChars);
		url = temp.substring(0, 3) + "." + temp.substring(4, temp.length() - 4) + "."
				+ temp.substring(temp.length() - 3);
		return url;
	}
	/** @return random emailLogin from file randomEmailLoginIntegration.txt
	 * @throws IOException */
	public static String randomEmailLoginIntegration() {
		String returnValue = "null";
		  try {
		        //I would prefer to read my file using NIO, which is faster
		        Path pathToMyTextFile = Paths.get((System.getProperty("user.dir") + "/src/test/java/faa/utils/randomEmailLoginIntegration.txt"));
		        //Then I would like to obtain the lines in Array, also I could have them available for process later
		        List<String> linesInFile = Files.readAllLines(pathToMyTextFile, StandardCharsets.ISO_8859_1);
		        //If I want to access a random element, I would use random methods to access a random index of the list and retrieve that element
		        Random randomUtil = new Random();

		        //I will use the formula for random and define the maximum (which will be the length of the array -1) and the minimum which will be zero
		        //since the indexes are represented from 0 to length - 1
		        int max = linesInFile.size() - 1;
		        int min = 0;
		        System.out.println("Random max-->" + max);
		        System.out.println("Random min-->" + min);
		        System.out.println("Random linesInFile.size()-->" + linesInFile.size());

		        //You can simplify this formula later, I'm just putting the whole thing
		        int randomIndexForWord = randomUtil.nextInt((max - min + 1)) + min;

		        //Here I get a random Noun
		        String randomWord = linesInFile.get(randomIndexForWord);
		        System.out.println("randomWord Random Title -->" + randomWord);
		        returnValue = randomWord;
		    } catch (IOException e) {
		        // TODO Auto-generated catch block
		        e.printStackTrace();
		    }
		  return returnValue;
	}
	
	/** @return random emailLogin from file getRandomNonHobbyistEmailLoginIntegration.txt
	 * @throws IOException */
	public static String getRandomNonHobbyistEmailLoginIntegration() {
		String returnValue = "null";
		  try {
		        //I would prefer to read my file using NIO, which is faster
		        Path pathToMyTextFile = Paths.get((System.getProperty("user.dir") + "/src/test/java/faa/utils/randomNonHobbyistEmailLoginIntegration.txt"));
		        //Then I would like to obtain the lines in Array, also I could have them available for process later
		        List<String> linesInFile = Files.readAllLines(pathToMyTextFile, StandardCharsets.ISO_8859_1);
		        //If I want to access a random element, I would use random methods to access a random index of the list and retrieve that element
		        Random randomUtil = new Random();

		        //I will use the formula for random and define the maximum (which will be the length of the array -1) and the minimum which will be zero
		        //since the indexes are represented from 0 to length - 1
		        int max = linesInFile.size() - 1;
		        int min = 0;
		        System.out.println("Random max-->" + max);
		        System.out.println("Random min-->" + min);
		        System.out.println("Random linesInFile.size()-->" + linesInFile.size());

		        //You can simplify this formula later, I'm just putting the whole thing
		        int randomIndexForWord = randomUtil.nextInt((max - min + 1)) + min;

		        //Here I get a random Noun
		        String randomWord = linesInFile.get(randomIndexForWord);
		        System.out.println("randomWord Random Non Hobbyist Email Integration -->" + randomWord);
		        returnValue = randomWord;
		    } catch (IOException e) {
		        // TODO Auto-generated catch block
		        e.printStackTrace();
		    }
		  return returnValue;
	}
	
	/** @return random emailLogin from file getRandomNonHobbyistEmailLoginIntegration.txt
	 * @throws IOException */
	public static String getRandomNonHobbyistEmailLoginTest() {
		String returnValue = "null";
		  try {
		        //I would prefer to read my file using NIO, which is faster
		        Path pathToMyTextFile = Paths.get((System.getProperty("user.dir") + "/src/test/java/faa/utils/randomNonHobbyistEmailLoginTest.txt"));
		        //Then I would like to obtain the lines in Array, also I could have them available for process later
		        List<String> linesInFile = Files.readAllLines(pathToMyTextFile, StandardCharsets.ISO_8859_1);
		        //If I want to access a random element, I would use random methods to access a random index of the list and retrieve that element
		        Random randomUtil = new Random();

		        //I will use the formula for random and define the maximum (which will be the length of the array -1) and the minimum which will be zero
		        //since the indexes are represented from 0 to length - 1
		        int max = linesInFile.size() - 1;
		        int min = 0;
		        System.out.println("Random max-->" + max);
		        System.out.println("Random min-->" + min);
		        System.out.println("Random linesInFile.size()-->" + linesInFile.size());

		        //You can simplify this formula later, I'm just putting the whole thing
		        int randomIndexForWord = randomUtil.nextInt((max - min + 1)) + min;

		        //Here I get a random Noun
		        String randomWord = linesInFile.get(randomIndexForWord);
		        System.out.println("randomWord Random Non Hobbyist Email Integration -->" + randomWord);
		        returnValue = randomWord;
		    } catch (IOException e) {
		        // TODO Auto-generated catch block
		        e.printStackTrace();
		    }
		  return returnValue;
	}
	
	
	
	
	/** @return random emailLogin from file randomHobbyistEmailLoginIntegration.txt
	 * @throws IOException */
	public static String getRandomHobbyistEmailLoginIntegration() {
		String returnValue = "null";
		  try {
		        //I would prefer to read my file using NIO, which is faster
		        Path pathToMyTextFile = Paths.get((System.getProperty("user.dir") + "/src/test/java/faa/utils/randomHobbyistEmailLoginIntegration.txt"));
		        //Then I would like to obtain the lines in Array, also I could have them available for process later
		        List<String> linesInFile = Files.readAllLines(pathToMyTextFile, StandardCharsets.ISO_8859_1);
		        //If I want to access a random element, I would use random methods to access a random index of the list and retrieve that element
		        Random randomUtil = new Random();

		        //I will use the formula for random and define the maximum (which will be the length of the array -1) and the minimum which will be zero
		        //since the indexes are represented from 0 to length - 1
		        int max = linesInFile.size() - 1;
		        int min = 0;
		        System.out.println("Random max-->" + max);
		        System.out.println("Random min-->" + min);
		        System.out.println("Random linesInFile.size()-->" + linesInFile.size());

		        //You can simplify this formula later, I'm just putting the whole thing
		        int randomIndexForWord = randomUtil.nextInt((max - min + 1)) + min;

		        //Here I get a random Noun
		        String randomWord = linesInFile.get(randomIndexForWord);
		        System.out.println("randomWord Random Hobbyist Email Integration -->" + randomWord);
		        returnValue = randomWord;
		    } catch (IOException e) {
		        // TODO Auto-generated catch block
		        e.printStackTrace();
		    }
		  return returnValue;
	}
	
	/** @return random emailLogin from file getRandomHobbyistEmailLoginTest.txt
	 * @throws IOException */
	public static String getRandomHobbyistEmailLoginTest() {
		String returnValue = "null";
		  try {
		        //I would prefer to read my file using NIO, which is faster
		        Path pathToMyTextFile = Paths.get((System.getProperty("user.dir") + "/src/test/java/faa/utils/randomHobbyistEmailLoginTest.txt"));
		        //Then I would like to obtain the lines in Array, also I could have them available for process later
		        List<String> linesInFile = Files.readAllLines(pathToMyTextFile, StandardCharsets.ISO_8859_1);
		        //If I want to access a random element, I would use random methods to access a random index of the list and retrieve that element
		        Random randomUtil = new Random();

		        //I will use the formula for random and define the maximum (which will be the length of the array -1) and the minimum which will be zero
		        //since the indexes are represented from 0 to length - 1
		        int max = linesInFile.size() - 1;
		        int min = 0;
		        System.out.println("Random max-->" + max);
		        System.out.println("Random min-->" + min);
		        System.out.println("Random linesInFile.size()-->" + linesInFile.size());

		        //You can simplify this formula later, I'm just putting the whole thing
		        int randomIndexForWord = randomUtil.nextInt((max - min + 1)) + min;

		        //Here I get a random Noun
		        String randomWord = linesInFile.get(randomIndexForWord);
		        System.out.println("randomWord Random Hobbyist Email Test -->" + randomWord);
		        returnValue = randomWord;
		    } catch (IOException e) {
		        // TODO Auto-generated catch block
		        e.printStackTrace();
		    }
		  return returnValue;
	}
		
	
	
	
	
	
	
	
	
	
	
	public static String randomEmailLoginTest() {
		String returnValue = "null";
		  try {
		        //I would prefer to read my file using NIO, which is faster
		        Path pathToMyTextFile = Paths.get((System.getProperty("user.dir") + "/src/test/java/faa/utils/randomEmailLoginTest.txt"));
		        //Then I would like to obtain the lines in Array, also I could have them available for process later
		        List<String> linesInFile = Files.readAllLines(pathToMyTextFile, StandardCharsets.ISO_8859_1);
		        //If I want to access a random element, I would use random methods to access a random index of the list and retrieve that element
		        Random randomUtil = new Random();

		        //I will use the formula for random and define the maximum (which will be the length of the array -1) and the minimum which will be zero
		        //since the indexes are represented from 0 to length - 1
		        int max = linesInFile.size() - 1;
		        int min = 0;
		        System.out.println("Random max-->" + max);
		        System.out.println("Random min-->" + min);
		        System.out.println("Random linesInFile.size()-->" + linesInFile.size());

		        //You can simplify this formula later, I'm just putting the whole thing
		        int randomIndexForWord = randomUtil.nextInt((max - min + 1)) + min;

		        //Here I get a random Noun
		        String randomWord = linesInFile.get(randomIndexForWord);
		        System.out.println("randomWord Random Title -->" + randomWord);
		        returnValue = randomWord;
		    } catch (IOException e) {
		        // TODO Auto-generated catch block
		        e.printStackTrace();
		    }
		  return returnValue;
	}

	public static String randomEmailLoginStage() {
		String returnValue = "null";
		  try {
		        //I would prefer to read my file using NIO, which is faster
		        Path pathToMyTextFile = Paths.get((System.getProperty("user.dir") + "/src/test/java/faa/utils/randomEmailLoginStage.txt"));
		        //Then I would like to obtain the lines in Array, also I could have them available for process later
		        List<String> linesInFile = Files.readAllLines(pathToMyTextFile, StandardCharsets.ISO_8859_1);
		        //If I want to access a random element, I would use random methods to access a random index of the list and retrieve that element
		        Random randomUtil = new Random();

		        //I will use the formula for random and define the maximum (which will be the length of the array -1) and the minimum which will be zero
		        //since the indexes are represented from 0 to length - 1
		        int max = linesInFile.size() - 1;
		        int min = 0;
		        System.out.println("Random max-->" + max);
		        System.out.println("Random min-->" + min);
		        System.out.println("Random linesInFile.size()-->" + linesInFile.size());

		        //You can simplify this formula later, I'm just putting the whole thing
		        int randomIndexForWord = randomUtil.nextInt((max - min + 1)) + min;

		        //Here I get a random Noun
		        String randomWord = linesInFile.get(randomIndexForWord);
		        System.out.println("randomWord Random Title -->" + randomWord);
		        returnValue = randomWord;
		    } catch (IOException e) {
		        // TODO Auto-generated catch block
		        e.printStackTrace();
		    }
		  return returnValue;
	}
	
	/** @return random Street Address formatted string. Format: 123 Fake St.
	 * @throws IOException */
	public static String randomStreetAddress() {
		String returnValue = randomNumber(4);
		Random rand = new Random();
		RandomAccessFile raf;
		try {
			raf = new RandomAccessFile(
					System.getProperty("user.dir") + "/src/test/java/faa/utils/DCStreetNames.txt", "r");
			final long randomLocation = (long) rand.nextInt((((int) (raf.length()) - 20) - 0) + 1) + 0;
			raf.seek(randomLocation);
			raf.readLine();
			returnValue = returnValue + " " + raf.readLine().trim();
			raf.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String[] StreetTypes = { "Ave", "Rd", "St", "Dr", "Ln", "Way", "Pl", "Ct", "Terr", "Hwy", "Pkwy", "Blvd" };
		rand = new Random();
		int randomNum = rand.nextInt((11 - 0) + 1) + 0;
		returnValue = returnValue + " " + StreetTypes[randomNum];
		return returnValue;
	}

	public static String randomFirstName() {
		String returnValue = "null";
		  try {
		        //I would prefer to read my file using NIO, which is faster
		        Path pathToMyTextFile = Paths.get((System.getProperty("user.dir") + "/src/test/java/faa/utils/FirstNames.txt"));
		        //Then I would like to obtain the lines in Array, also I could have them available for process later
		        List<String> linesInFile = Files.readAllLines(pathToMyTextFile, StandardCharsets.ISO_8859_1);
		        //If I want to access a random element, I would use random methods to access a random index of the list and retrieve that element
		        Random randomUtil = new Random();

		        //I will use the formula for random and define the maximum (which will be the length of the array -1) and the minimum which will be zero
		        //since the indexes are represented from 0 to length - 1
		        int max = linesInFile.size() - 1;
		        int min = 0;
		        System.out.println("Random max-->" + max);
		        System.out.println("Random min-->" + min);
		        System.out.println("Random linesInFile.size()-->" + linesInFile.size());

		        //You can simplify this formula later, I'm just putting the whole thing
		        int randomIndexForWord = randomUtil.nextInt((max - min + 1)) + min;
		        System.out.println("Random randomIndexForWord-->" + randomIndexForWord);
		        //Here I get a random Noun
		        String randomWord = linesInFile.get(randomIndexForWord);
		        System.out.println("randomWord Random First Name -->" + randomWord);
		        returnValue = randomWord;
		    } catch (IOException e) {
		        // TODO Auto-generated catch block
		        e.printStackTrace();
		    }
		  return returnValue;
	}
	


	/** @return random middle name (same as first name)
	 * @throws IOException */
	public static String randomMiddleName() {
		return randomFirstName();
	}
	
	public static String randomLastName() {
		String returnValue = "null";
		  try {
		        //I would prefer to read my file using NIO, which is faster
		        Path pathToMyTextFile = Paths.get((System.getProperty("user.dir") + "/src/test/java/faa/utils/LastNames.txt"));
		        //Then I would like to obtain the lines in Array, also I could have them available for process later
		        List<String> linesInFile = Files.readAllLines(pathToMyTextFile, StandardCharsets.ISO_8859_1);
		        //If I want to access a random element, I would use random methods to access a random index of the list and retrieve that element
		        Random randomUtil = new Random();

		        //I will use the formula for random and define the maximum (which will be the length of the array -1) and the minimum which will be zero
		        //since the indexes are represented from 0 to length - 1
		        int max = linesInFile.size() - 1;
		        int min = 0;
		        System.out.println("Random max-->" + max);
		        System.out.println("Random min-->" + min);
		        System.out.println("Random linesInFile.size()-->" + linesInFile.size());

		        //You can simplify this formula later, I'm just putting the whole thing
		        int randomIndexForWord = randomUtil.nextInt((max - min + 1)) + min;
		        System.out.println("Random randomIndexForWord-->" + randomIndexForWord);
		        //Here I get a random Noun
		        String randomWord = linesInFile.get(randomIndexForWord);
		        System.out.println("randomWord Random Last Name -->" + randomWord);
		        returnValue = randomWord;
		    } catch (IOException e) {
		        // TODO Auto-generated catch block
		        e.printStackTrace();
		    }
		  return returnValue;
	}
	


	
	public static String randomSuffixName() {
		String returnValue = "null";
		  try {
		        //I would prefer to read my file using NIO, which is faster
		        Path pathToMyTextFile = Paths.get((System.getProperty("user.dir") + "/src/test/java/faa/utils/suffix.txt"));
		        //Then I would like to obtain the lines in Array, also I could have them available for process later
		        List<String> linesInFile = Files.readAllLines(pathToMyTextFile, StandardCharsets.ISO_8859_1);
		        //If I want to access a random element, I would use random methods to access a random index of the list and retrieve that element
		        Random randomUtil = new Random();

		        //I will use the formula for random and define the maximum (which will be the length of the array -1) and the minimum which will be zero
		        //since the indexes are represented from 0 to length - 1
		        int max = linesInFile.size() - 1;
		        int min = 0;
		        System.out.println("Random max-->" + max);
		        System.out.println("Random min-->" + min);
		        System.out.println("Random linesInFile.size()-->" + linesInFile.size());

		        //You can simplify this formula later, I'm just putting the whole thing
		        int randomIndexForWord = randomUtil.nextInt((max - min + 1)) + min;
		        System.out.println("Random randomIndexForWord-->" + randomIndexForWord);
		        //Here I get a random Noun
		        String randomWord = linesInFile.get(randomIndexForWord);
		        System.out.println("randomWord Random Suffix -->" + randomWord);
		        returnValue = randomWord;
		    } catch (IOException e) {
		        // TODO Auto-generated catch block
		        e.printStackTrace();
		    }
		  return returnValue;
	}

	
	/** @return random title from file 
	 * @throws IOException */
	public static String randomTitle() {
		String returnValue = "null";
		  try {
		        //I would prefer to read my file using NIO, which is faster
		        Path pathToMyTextFile = Paths.get((System.getProperty("user.dir") + "/src/test/java/faa/utils/titles.txt"));
		        //Then I would like to obtain the lines in Array, also I could have them available for process later
		        List<String> linesInFile = Files.readAllLines(pathToMyTextFile, StandardCharsets.ISO_8859_1);
		        //If I want to access a random element, I would use random methods to access a random index of the list and retrieve that element
		        Random randomUtil = new Random();

		        //I will use the formula for random and define the maximum (which will be the length of the array -1) and the minimum which will be zero
		        //since the indexes are represented from 0 to length - 1
		        int max = linesInFile.size() - 1;
		        int min = 0;
		        System.out.println("Random max-->" + max);
		        System.out.println("Random min-->" + min);
		        System.out.println("Random linesInFile.size()-->" + linesInFile.size());

		        //You can simplify this formula later, I'm just putting the whole thing
		        int randomIndexForWord = randomUtil.nextInt((max - min + 1)) + min;
		        System.out.println("Random randomIndexForWord-->" + randomIndexForWord);

		        //Here I get a random Noun
		        String randomWord = linesInFile.get(randomIndexForWord);
		        System.out.println("randomWord Random Title -->" + randomWord);
		        returnValue = randomWord;
		    } catch (IOException e) {
		        // TODO Auto-generated catch block
		        e.printStackTrace();
		    }
		  return returnValue;
	}
		
	public static String randomCancelReason() {	
	String returnValue = "null";
	  try {
	        //I would prefer to read my file using NIO, which is faster
	        Path pathToMyTextFile = Paths.get((System.getProperty("user.dir") + "/src/test/java/faa/utils/cancelReason.txt"));
	        //Then I would like to obtain the lines in Array, also I could have them available for process later
	        List<String> linesInFile = Files.readAllLines(pathToMyTextFile, StandardCharsets.ISO_8859_1);
	        //If I want to access a random element, I would use random methods to access a random index of the list and retrieve that element
	        Random randomUtil = new Random();

	        //I will use the formula for random and define the maximum (which will be the length of the array -1) and the minimum which will be zero
	        //since the indexes are represented from 0 to length - 1
	        int max = linesInFile.size() - 1;
	        int min = 0;
	        System.out.println("Random max-->" + max);
	        System.out.println("Random min-->" + min);
	        System.out.println("Random linesInFile.size()-->" + linesInFile.size());

	        //You can simplify this formula later, I'm just putting the whole thing
	        int randomIndexForWord = randomUtil.nextInt((max - min + 1)) + min;
	        System.out.println("Random randomIndexForWord-->" + randomIndexForWord);
	        //Here I get a random Noun
	        String randomWord = linesInFile.get(randomIndexForWord);
	        System.out.println("randomWord Random Cancel Reason -->" + randomWord);
	        returnValue = randomWord;
	    } catch (IOException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    }
	  return returnValue;	
	}	
	
	
	
	public static String randomOrganizationName() {
		String returnValue = "null";
		  try {
			    Path pathToMyTextFile = Paths.get((System.getProperty("user.dir") + "/src/test/java/faa/utils/organizations.txt"));
		        List<String> linesInFile = Files.readAllLines(pathToMyTextFile, StandardCharsets.ISO_8859_1);
		        Random randomUtil = new Random();
		        //I will use the formula for random and define the maximum (which will be the length of the array -1) and the minimum which will be zero
		        //since the indexes are represented from 0 to length - 1
		        int max = linesInFile.size() - 1;
		        int min = 0;
		        System.out.println("Random max-->" + max);
		        System.out.println("Random min-->" + min);
		        System.out.println("Random linesInFile.size()-->" + linesInFile.size());

		        //You can simplify this formula later, I'm just putting the whole thing
		        int randomIndexForWord = randomUtil.nextInt((max - min + 1)) + min;
		        System.out.println("Random randomIndexForWord-->" + randomIndexForWord);
		        //Here I get a random Noun
		        String randomWord = linesInFile.get(randomIndexForWord);
		        System.out.println("randomWord Random Organization -->" + randomWord);
		        returnValue = randomWord;
		    } catch (IOException e) {
		        // TODO Auto-generated catch block
		        e.printStackTrace();
		    }
	        System.out.println("returnValue Random Organization -->" + returnValue);
		  return returnValue;
	}
	

	public static String randomCompanyName() {
		String returnValue = "null";
		  try {
			    Path pathToMyTextFile = Paths.get((System.getProperty("user.dir") + "/src/test/java/faa/utils/companies.txt"));
		        List<String> linesInFile = Files.readAllLines(pathToMyTextFile, StandardCharsets.ISO_8859_1);
		        Random randomUtil = new Random();
		        //I will use the formula for random and define the maximum (which will be the length of the array -1) and the minimum which will be zero
		        //since the indexes are represented from 0 to length - 1
		        int max = linesInFile.size() - 1;
		        int min = 0;
		        System.out.println("Random max-->" + max);
		        System.out.println("Random min-->" + min);
		        System.out.println("Random linesInFile.size()-->" + linesInFile.size());

		        //You can simplify this formula later, I'm just putting the whole thing
		        int randomIndexForWord = randomUtil.nextInt((max - min + 1)) + min;
		        System.out.println("Random randomIndexForWord-->" + randomIndexForWord);
		        //Here I get a random Noun
		        String randomWord = linesInFile.get(randomIndexForWord);
		        System.out.println("randomWord Random Company Name -->" + randomWord);
		        returnValue = randomWord;
		    } catch (IOException e) {
		        // TODO Auto-generated catch block
		        e.printStackTrace();
		    }
	        System.out.println("returnValue Random Company Name -->" + returnValue);
		  return returnValue;
	}
	
	/** @return random Company Name from file 
	 * @throws IOException */
	public static String randomCompanyName2() {
		Random rand = new Random();
		String returnValue = "null";
		RandomAccessFile raf;
		try {
			raf = new RandomAccessFile(System.getProperty("user.dir") + "/src/test/java/faa/utils/companies.txt",
					"r");
			long randomLocation = (long) rand.nextInt((((int) (raf.length()) - 20) - 0) + 1) + 0;
			System.out.println("Random Location Line Number -->"+ randomLocation); 
			if (randomLocation == 0){
				randomLocation = randomLocation + 1;
				System.out.println("New Random Location Line Number -->"+ randomLocation); 
			}
			raf.seek(randomLocation);
			raf.readLine();
			returnValue = raf.readLine().trim();
			raf.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return returnValue.toUpperCase();
	}

	/**
	 * @return random City State Zip combination. Array format: String[] =
	 *         {"city", "state", "zip"}
	 * @throws IOException
	 */
	public static String[] randomCityStateZip() {
		Random rand = new Random();
		String returnValue = "";

		RandomAccessFile raf;
		try {
			raf = new RandomAccessFile(System.getProperty("user.dir")
					+ "/src/test/java/faa/utils/cityStateZip.txt", "r");
			final long randomLocation = (long) rand.nextInt((((int) (raf
					.length()) - 20) - 0) + 1) + 0;
			System.out.println("New Random Location Line Number -->"+ randomLocation); 
			raf.seek(randomLocation);
			raf.readLine();
			returnValue = raf.readLine().trim();
			raf.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String[] cityStateZip = returnValue.split(",");
		return cityStateZip;
	}

	
	
	
	/**
	 * @return random Country, Address1, Address2, City, State, Zipcode combination. Array format: String[] =
	 *         {"Country", "Address1", "Address2", "city", "state", "zip"}
	 * @throws IOException
	 * United States,8250 Joel St,Spring Hill,Florida,34606

	 */ 
	public static String[] randomAddress() {
		Random rand = new Random();
		//String returnValue = "";
		String[] address = null;
		//System.out.println("**********************addressListus.txt*************");
		try(FileReader csvFileReader = new FileReader(System.getProperty("user.dir")
				 + "/src/test/java/faa/utils/gatewayUsAddressList.txt");
				CSVReader csvReader = new CSVReader(csvFileReader)) {
			List<String []> lines = csvReader.readAll();
			int randomLocation = rand.nextInt(lines.size());
			if (randomLocation == 0){
				randomLocation = randomLocation + 1;
				System.out.println("New Random Location Line Number -->"+ randomLocation); 
			}
			address = lines.get(randomLocation );

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("**********************addressListus.txt***" + address[0] );
		return address;
	}
	

	/**
	 * @return random Country, Address1, Address2, City, State, Zipcode combination. Array format: String[] =
	 *         {"Country", "Address1", "Address2", "city", "state", "zip"}
	 * @throws IOException
	 * United States,8250 Joel St,Spring Hill,Florida,34606

	 */

//new one
	public static String[] randomAddressStrike() {
		Random rand = new Random();
		//String returnValue = "";
		String[] address = null;
		//System.out.println("**********************AddressListStrike.txt*************");
		try(FileReader csvFileReader = new FileReader(System.getProperty("user.dir")
				 + "/src/test/java/faa/utils/AddressListStrike.txt");
				CSVReader csvReader = new CSVReader(csvFileReader))	{
			List<String []> lines = csvReader.readAll();
			
			int randomLocation = rand.nextInt(lines.size());
//			if (randomLocation == 0){
//				randomLocation = randomLocation + 1;
//				System.out.println("New Random Location Line Number -->"+ randomLocation); 
//			}
			address = lines.get(randomLocation);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("**********************AddressListStrike.txt***" + address[0] );
		return address;
	}
		
	/**
	 * @return random Country, Address1, City State Zipcode combination. Array format: String[] =
	 *         {"Country", "Address1", "Address2", "city", "state", "zip"}
	 * @throws IOException
	 * United States,8250 Joel St,Spring Hill,Florida,34606

	 */
	public static String[] randomAllAddress() {
		Random rand = new Random();
		String returnValue = "";
		String[] address = null;
		//System.out.println("**********************AllAddressList.txt*************");
		try(FileReader csvFileReader = new FileReader(System.getProperty("user.dir")
				 + "/src/test/java/faa/utils/AllAddressList.txt");
				CSVReader csvReader = new CSVReader(csvFileReader)) {


			List<String []> lines = csvReader.readAll();


			final int randomLocation = rand.nextInt(lines.size());
			
			address = lines.get(randomLocation);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("**********************AddressListStrike.txt***" + address[0] );
		return address;
	}
	
	
	/**
	 * @return random Country, Address1, Address2, City, State, Zipcode combination. Array format: String[] =
	 *         {"Country", "Address1", "Address2", "city", "state", "zip"}
	 * @throws IOException
	 * United States,8250 Joel St,Spring Hill,Florida,34606

	 */
	
	public static String[] randomAddressInternational() {
		Random rand = new Random();
		String returnValue = "";
		String[] address = null;
		//System.out.println("**********************addressListInternational.txt*************");
		try(FileReader csvFileReader = new FileReader(System.getProperty("user.dir")
				 + "/src/test/java/faa/utils/addressListInternational.txt");
				
				CSVReader csvReader = new CSVReader(csvFileReader)) {


			List<String []> lines = csvReader.readAll();


			final int randomLocation = rand.nextInt(lines.size());
			
			address = lines.get(randomLocation);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("**********************addressListInternational.txt***" + address[0] );
		return address;
	}
		
	public static String randomUasType() {
		String returnValue = "null";
		  try {
			    Path pathToMyTextFile = Paths.get((System.getProperty("user.dir") + "/src/test/java/faa/utils/uas_types.txt"));
		        List<String> linesInFile = Files.readAllLines(pathToMyTextFile, StandardCharsets.ISO_8859_1);
		        Random randomUtil = new Random();

		        //I will use the formula for random and define the maximum (which will be the length of the array -1) and the minimum which will be zero
		        //since the indexes are represented from 0 to length - 1
		        int max = linesInFile.size() - 1;
		        int min = 0;
		        System.out.println("Random max-->" + max);
		        System.out.println("Random min-->" + min);
		        System.out.println("Random linesInFile.size()-->" + linesInFile.size());

		        //You can simplify this formula later, I'm just putting the whole thing
		        int randomIndexForWord = randomUtil.nextInt((max - min + 1)) + min;

		        //Here I get a random Noun
		        String randomWord = linesInFile.get(randomIndexForWord);
		        System.out.println("randomWord Random Role Types -->" + randomWord);
		        returnValue = randomWord;
		    } catch (IOException e) {
		        // TODO Auto-generated catch block
		        e.printStackTrace();
		    }
	        System.out.println("returnValue Random Role Types -->" + returnValue);
		  return returnValue;
	}
	
	
	
	
	
	
	
//	
	/** @return random Type Name from file 
	 * @throws IOException */
	public static String randomUasType2() {
		Random rand = new Random();
		String returnValue = "null";
		RandomAccessFile raf;
		try {
			raf = new RandomAccessFile(System.getProperty("user.dir") + "/src/test/java/faa/utils/uas_types.txt",
					"r");
			final long randomLocation = (long) rand.nextInt((((int) (raf.length()) - 1) - 0) + 1) + 0;
			raf.seek(randomLocation);
			raf.readLine();
			returnValue = raf.readLine().trim();
			raf.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return returnValue;
	}
	
	/** @return random Type Name from file 
	 * @throws IOException */
	public static String randomRoleType() {
		String returnValue = "null";
		  try {
			    Path pathToMyTextFile = Paths.get((System.getProperty("user.dir") + "/src/test/java/faa/utils/role_types.txt"));
		        List<String> linesInFile = Files.readAllLines(pathToMyTextFile, StandardCharsets.ISO_8859_1);
		        Random randomUtil = new Random();

		        //I will use the formula for random and define the maximum (which will be the length of the array -1) and the minimum which will be zero
		        //since the indexes are represented from 0 to length - 1
		        int max = linesInFile.size() - 1;
		        int min = 0;
		        System.out.println("Role Type Code Random max-->" + max);
		        System.out.println("Role Type Code Random min-->" + min);
		        System.out.println("Role Type Code Random linesInFile.size()-->" + linesInFile.size());

		        //You can simplify this formula later, I'm just putting the whole thing
		        int randomIndexForWord = randomUtil.nextInt((max - min + 1)) + min;

		        //Here I get a random Noun
		        String randomWord = linesInFile.get(randomIndexForWord);
		        System.out.println("randomWord Random Role Types -->" + randomWord);
		        returnValue = randomWord;
		    } catch (IOException e) {
		        // TODO Auto-generated catch block
		        e.printStackTrace();
		    }
	        System.out.println("returnValue Random Role Types -->" + returnValue);
		  return returnValue;
	}
	
	public static String randomRoleType2() {
		Random rand = new Random();
		String returnValue = "null";
		RandomAccessFile raf;
		try {
			raf = new RandomAccessFile(System.getProperty("user.dir") + "/src/test/java/faa/utils/role_types.txt",
					"r");
			final long randomLocation = (long) rand.nextInt((((int) (raf.length()) - 20) - 0) + 1) + 0;
			raf.seek(randomLocation);
			System.out.println("RandomLocation-->" + randomLocation);
			System.out.println("Raf Length-->" + raf.length());
			
			raf.readLine();
			returnValue = raf.readLine().trim();
			raf.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return returnValue;
	}
	
	
	
	public static String randomSerialNumbersNonHobbyist() {
		String returnValue = "null";
		  try {
			    Path pathToMyTextFile = Paths.get((System.getProperty("user.dir") + "/src/test/java/faa/utils/SerialNumbersNonHobbyist.txt"));
		        List<String> linesInFile = Files.readAllLines(pathToMyTextFile, StandardCharsets.ISO_8859_1);
		        Random randomUtil = new Random();
		        //I will use the formula for random and define the maximum (which will be the length of the array -1) and the minimum which will be zero
		        //since the indexes are represented from 0 to length - 1
		        int max = linesInFile.size() - 1;
		        int min = 0;
		        System.out.println("Random max-->" + max);
		        System.out.println("Random min-->" + min);
		        System.out.println("Random linesInFile.size()-->" + linesInFile.size());

		        //You can simplify this formula later, I'm just putting the whole thing
		        int randomIndexForWord = randomUtil.nextInt((max - min + 1)) + min;

		        //Here I get a random Noun
		        String randomWord = linesInFile.get(randomIndexForWord);
		        System.out.println("randomWord Random Role Types -->" + randomWord);
		        returnValue = randomWord;
		    } catch (IOException e) {
		        // TODO Auto-generated catch block
		        e.printStackTrace();
		    }
	        System.out.println("returnValue Random Role Types -->" + returnValue);
		  return returnValue;
	}
	
	
	/**
	 * @return random Serial Numbers Non Hobbyist. Array format: String[] =
	 *       
	 * @throws IOException
	 */
		public static String randomSerialNumbersNonHobbyist2() {
			Random rand = new Random();
			String returnValue = "null";
			RandomAccessFile raf;
			try {
				raf = new RandomAccessFile(System.getProperty("user.dir") + "/src/test/java/faa/utils/SerialNumbersNonHobbyist.txt",
						"r");
				final long randomLocation = (long) rand.nextInt((((int) (raf.length()) - 20) - 0) + 1) + 0;
				raf.seek(randomLocation);
				raf.readLine();
				returnValue = raf.readLine().trim();
				raf.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return returnValue;
		}
	
	
	
	
	/** @return random Expire Month form file
	 * @throws IOException */
	public static String randomExpMonth() {
		Random rand = new Random();
		String returnValue = "null";
		RandomAccessFile raf;
		try {
			raf = new RandomAccessFile(System.getProperty("user.dir") + "/src/test/java/faa/utils/expMonth.txt",
					"r");
			final long randomLocation = (long) rand.nextInt((((int) (raf.length()) - 20) - 0) + 1) + 0;
			raf.seek(randomLocation);
			raf.readLine();
			returnValue = raf.readLine().trim();
			raf.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return returnValue;
	}
	/** @return random Expire Year form file
	 * @throws IOException */
	public static String randomExpYear() {
		Random rand = new Random();
		String returnValue = "null";
		RandomAccessFile raf;
		try {
			raf = new RandomAccessFile(System.getProperty("user.dir") + "/src/test/java/faa/utils/expYear.txt",
					"r");
			final long randomLocation = (long) rand.nextInt((((int) (raf.length()) - 20) - 0) + 1) + 0;
			raf.seek(randomLocation);
			raf.readLine();
			returnValue = raf.readLine().trim();
			raf.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return returnValue;
	}
	
	/**
	 * @return random Credit Card Number. Array format: String[] =
	 *       
	 * @throws IOException
	 */
	public static String randomCreditCardNumber() {
			Random rand = new Random();
			String returnValue = "";
			try {
				RandomAccessFile raf = new RandomAccessFile(
						System.getProperty("user.dir") + "/src/test/java/faa/utils/creditCards.txt", "r");
				final long randomLocation = (long) rand.nextInt((((int) (raf.length()) - 20) - 0) + 1) + 0;
				raf.seek(randomLocation);
				raf.readLine();
				returnValue = raf.readLine().trim();
				raf.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

			return returnValue.toUpperCase();
		}

	public static String getActiveInvitedUserFromDB() {
		DatabaseConnection databaseConnection = new DatabaseConnection("integration");
		databaseConnection.executeStatement(
		"SELECT email_address FROM uasdb.party_enrollment_invitation where email_address like'my%faadrone%@gmail.com' "
		+ "and party_enroll_invit_status_cd = 'ACTIVATED'  order by party_enroll_invit_status_dttm asc limit 1");
		ArrayList<String> firstRow = new ArrayList<String>();
		firstRow = databaseConnection.getNextRowArray();
		String result = firstRow.get(0);
		databaseConnection.closeConnection();
		return result;
	}

	
	
	//##Add Users ## Query
	public static String getActiveAccountToAddUserFromIntegrationDB() {
		DatabaseConnection databaseConnection = new DatabaseConnection("integration");
		databaseConnection.executeStatement("select ci.email_address from party_enrollment pe " +
	"inner join party_enrollment_account pea on pe.party_enroll_acct_id = pea.party_enroll_acct_id " +
	"inner join contact_info ci on ci.contact_info_id = pe.contact_info_id " +
	"inner join person_info pi on pi.person_info_id = pea.person_info_id " +
	"inner join organization_info oi on oi.party_enroll_id = pe.party_enroll_id " +
	"inner join organization_address oa on oa.org_info_id = oi.org_info_id " +
	"inner join address a on a.address_id = oa.address_id " +
	"where pe.changed_by_username like 'my%faadrone%' " +
	"and pe.party_enroll_type_cd in  ('ORGANIZATION')  " +
	"and pe.party_enroll_status_cd = 'ACTIVE' order by pi.changed_on_dttm asc " );
		ArrayList<String> firstRow = new ArrayList<String>();
		firstRow = databaseConnection.getNextRowArray();
		String result = firstRow.get(0);
		System.out.println("Logging in as Active Account to Add User to Integration Database --> " + result);
		databaseConnection.closeConnection();
		return result;
	}

	//##Add Users ## Query
	public static String getActiveAccountToAddUserFromTestDB() {
		DatabaseConnection databaseConnection = new DatabaseConnection("Test");
		databaseConnection.executeStatement("select ci.email_address from party_enrollment pe " +
	"inner join party_enrollment_account pea on pe.party_enroll_acct_id = pea.party_enroll_acct_id " +
	"inner join contact_info ci on ci.contact_info_id = pe.contact_info_id " +
	"inner join person_info pi on pi.person_info_id = pea.person_info_id " +
	"inner join organization_info oi on oi.party_enroll_id = pe.party_enroll_id " +
	"inner join organization_address oa on oa.org_info_id = oi.org_info_id " +
	"inner join address a on a.address_id = oa.address_id " +
	"where pe.changed_by_username like 'my%faadrone%' " +
	"and pe.party_enroll_type_cd in  ('ORGANIZATION')  " +
	"and pe.party_enroll_status_cd = 'ACTIVE' order by pi.changed_on_dttm asc " );
		ArrayList<String> firstRow = new ArrayList<String>();
		firstRow = databaseConnection.getNextRowArray();
		String result = firstRow.get(0);
		System.out.println("Logging in as Active Account to Add User to Test Database --> " + result);
		databaseConnection.closeConnection();
		return result;
	}

	
	//##Add Users ## Query
	public static String getActiveAccountToAddUserFromStageDB() {
		DatabaseConnection databaseConnection = new DatabaseConnection("Stage");
		databaseConnection.executeStatement("select ci.email_address from party_enrollment pe " +
	"inner join party_enrollment_account pea on pe.party_enroll_acct_id = pea.party_enroll_acct_id " +
	"inner join contact_info ci on ci.contact_info_id = pe.contact_info_id " +
	"inner join person_info pi on pi.person_info_id = pea.person_info_id " +
	"inner join organization_info oi on oi.party_enroll_id = pe.party_enroll_id " +
	"inner join organization_address oa on oa.org_info_id = oi.org_info_id " +
	"inner join address a on a.address_id = oa.address_id " +
	"where pe.changed_by_username like 'my%faadrone%' " +
	"and pe.party_enroll_type_cd in  ('ORGANIZATION')  " +
	"and pe.party_enroll_status_cd = 'ACTIVE' order by pi.changed_on_dttm asc " );
		ArrayList<String> firstRow = new ArrayList<String>();
		firstRow = databaseConnection.getNextRowArray();
		String result = firstRow.get(0);
		System.out.println("Logging in as Active Account to Add User to Stage Database --> " + result);
		databaseConnection.closeConnection();
		return result;
	}

	
	
	
	public static String getActiveUserWithExpiredInvitesFromIntegrationDB() {
		DatabaseConnection databaseConnection = new DatabaseConnection("integration");
		System.out.println("databaseConnection " + databaseConnection );
		databaseConnection.executeStatement("select pea.username from party_enrollment_invitation pei "
				+ "join organization_party_enrollment ope on (pei.org_info_id = ope.org_info_id) "
				+ "join organization_info oi on (oi.org_info_id = ope.org_info_id) "
				+ "join party_enrollment pe on (ope.party_enroll_id = pe.party_enroll_id) "
				+ "join party_enrollment_account pea on (pe.party_enroll_acct_id = pea.party_enroll_acct_id) "
				+ "where pei.party_enroll_invit_status_cd = 'EXPIRED' and pea.external_auth_user_id is not null "
				+ "and (pei.created_by_username  like  'my%faadrone%' or pei.changed_by_username like 'my%faadrone%') "
				+ "order by pei.changed_on_dttm asc limit 1");
		ArrayList<String> firstRow = new ArrayList<String>();
		firstRow = databaseConnection.getNextRowArray();
		String result = firstRow.get(0);
		System.out.println("Logging in as Active User with expired Invited Users in their Organization from Integration Database is-->" + result);
		databaseConnection.closeConnection();
		return result;
	}
	
	
	
	//getRandomNonHobbyistEmailLoginIntegration
	public static String getActiveNonHobbyistUserFromIntegrationDB() {
		//System.out.println("app.base.host is " + serenityProperties.getProperty("app.base.host"));
		DatabaseConnection databaseConnection = new DatabaseConnection("integration");
		System.out.println("databaseConnection " + databaseConnection );
		databaseConnection.executeStatement("select pea.username from party_enrollment pe " + 
		"join contact_info ci using (contact_info_id) " +
		"join party_enrollment_account pea using (party_enroll_acct_id) " +
		"join person_info pi using (person_info_id) " +
		"join organization_info oi using (party_enroll_id) " +
		"join organization_address oa using (org_info_id) " +
		"where pea.changed_by_username like 'my%faadrone%' " +
		"order by pea.changed_on_dttm asc limit 1 ");
//	
//		databaseConnection.executeStatement("select pea.username from party_enrollment pe " +
//		"inner join party_enrollment_account pea on pe.party_enroll_acct_id = pea.party_enroll_acct_id " +
//		"inner join contact_info ci on ci.contact_info_id = pe.contact_info_id " +
//		"inner join person_info pi on pi.person_info_id = pea.person_info_id " +
//		"inner join person_address pa on pa.person_info_id = pea.person_info_id " + 
//		"inner join address a on a.address_id = pa.address_id " +
//		"where pe.changed_by_username like 'my%faadrone%' " +
//		"and pe.party_enroll_type_cd in  ('ORGANIZATION') " +
//		"and pe.party_enroll_status_cd = 'ACTIVE' " +
//		"order by pi.changed_on_dttm asc limit 1 ");
		ArrayList<String> firstRow = new ArrayList<String>();
		firstRow = databaseConnection.getNextRowArray();
		String result = firstRow.get(0);
		System.out.println("Active Non Hobbyist Login Email Address from Integration Database is-->" + result);
		databaseConnection.closeConnection();
		return result;
	}
	//Change Primary Email Address 
	public static String getActiveNonHobbyistCpeUserFromIntegrationDB() {
		DatabaseConnection databaseConnection = new DatabaseConnection("integration");
		System.out.println("databaseConnection " + databaseConnection );
		System.out.println("###For Change Primary Password TEST --->Active Non Hobbyist User for automated tests####");
		databaseConnection.executeStatement("select pea.username from party_enrollment pe " +
		"join party_enrollment_account pea using (party_enroll_acct_id) " +
		"join person_info pi using (person_info_id) " +
		"where pe.changed_by_username like 'my%faadrone%' " + 
		"and pe.party_enroll_type_cd in ('INDIVIDUAL','ORGANIZATION') " +
		"and pe.party_enroll_status_cd = 'ACTIVE' " +
		"order by pea.changed_on_dttm asc limit 1 ");
//		databaseConnection.executeStatement("select pea.username from party_enrollment pe"
//				+ "join party_enrollment_account pea using (party_enroll_acct_id)"
//				+ "join person_info pi using (person_info_id)"
//				+ "where pe.party_enroll_status_cd = 'ACTIVE' "
//				+ "and pe.changed_by_username like 'my%faadrone%' "
//				+ "and pe.party_enroll_type_cd in ('INDIVIDUAL','ORGANIZATION')"
//				+ "order by pea.changed_on_dttm asc limit 1");
		ArrayList<String> firstRow = new ArrayList<String>();
		firstRow = databaseConnection.getNextRowArray();
		String result = firstRow.get(0);
		System.out.println("Active Non Hobbyist Login Email Address from Integration Database is-->" + result);
		databaseConnection.closeConnection();
		return result;
	}
	//Change Primary Email Address 
	public static String getActiveNonHobbyistCpeUserFromTestDB() {
		//System.out.println("app.base.host is " + serenityProperties.getProperty("app.base.host"));
		DatabaseConnection databaseConnection = new DatabaseConnection("test");
		System.out.println("databaseConnection " + databaseConnection );
		databaseConnection.executeStatement("select pea.username from party_enrollment pe " +
		"join party_enrollment_account pea using (party_enroll_acct_id) " +
		"join person_info pi using (person_info_id) " +
		"where pe.changed_by_username like 'my%faadrone%' " + 
		"and pe.party_enroll_type_cd in ('INDIVIDUAL','ORGANIZATION') " +
		"and pe.party_enroll_status_cd = 'ACTIVE' " +
		"order by pea.changed_on_dttm asc limit 1 ");
		ArrayList<String> firstRow = new ArrayList<String>();
		firstRow = databaseConnection.getNextRowArray();
		String result = firstRow.get(0);
		System.out.println("Active Non Hobbyist Login Email Address from Test Database is-->" + result);
		databaseConnection.closeConnection();
		return result;
	} 
	//Change Primary Email Address 
	public static String getActiveNonHobbyistCpeUserFromStageDB() {
		//System.out.println("app.base.host is " + serenityProperties.getProperty("app.base.host"));
			DatabaseConnection databaseConnection = new DatabaseConnection("stage");
			System.out.println("databaseConnection " + databaseConnection );
			databaseConnection.executeStatement("select pea.username from party_enrollment pe " +
					"join party_enrollment_account pea using (party_enroll_acct_id) " +
					"join person_info pi using (person_info_id) " +
					"where pe.changed_by_username like 'my%faadrone%' " + 
					"and pe.party_enroll_type_cd in ('INDIVIDUAL','ORGANIZATION') " +
					"and pe.party_enroll_status_cd = 'ACTIVE' " +
					"order by pea.changed_on_dttm asc limit 1 ");
			ArrayList<String> firstRow = new ArrayList<String>();
			firstRow = databaseConnection.getNextRowArray();
			String result = firstRow.get(0);
			System.out.println("Active Non Hobbyist Login Email Address from Stage Database is-->" + result);
			databaseConnection.closeConnection();
			return result;
	} 
	
	
	public static String getActiveNonHobbyistUserFromTestDB() {
		//System.out.println("app.base.host is " + serenityProperties.getProperty("app.base.host"));
		DatabaseConnection databaseConnection = new DatabaseConnection("test");
		System.out.println("databaseConnection " + databaseConnection );
		databaseConnection.executeStatement("select pea.username from party_enrollment pe " +
		"inner join party_enrollment_account pea on pe.party_enroll_acct_id = pea.party_enroll_acct_id " +
		"inner join contact_info ci on ci.contact_info_id = pe.contact_info_id " +
		"inner join person_info pi on pi.person_info_id = pea.person_info_id " +
		"inner join person_address pa on pa.person_info_id = pea.person_info_id " + 
		"inner join address a on a.address_id = pa.address_id " +
		"where pe.changed_by_username like 'my%faadrone%' " +
		"and pe.party_enroll_type_cd in  ('ORGANIZATION') " +
		"and pe.party_enroll_status_cd = 'ACTIVE' " +
		"order by pi.changed_on_dttm asc limit 1 ");
		ArrayList<String> firstRow = new ArrayList<String>();
		firstRow = databaseConnection.getNextRowArray();
		String result = firstRow.get(0);
		System.out.println("Active Non Hobbyist Login Email Address from Test Database is-->" + result);
		databaseConnection.closeConnection();
		return result;
	} 

	public static String getActiveNonHobbyistUserFromStageDB() {
		//System.out.println("app.base.host is " + serenityProperties.getProperty("app.base.host"));
			DatabaseConnection databaseConnection = new DatabaseConnection("stage");
			System.out.println("databaseConnection " + databaseConnection );
			databaseConnection.executeStatement("select pea.username from party_enrollment pe " +
					"inner join party_enrollment_account pea on pe.party_enroll_acct_id = pea.party_enroll_acct_id " +
					"inner join contact_info ci on ci.contact_info_id = pe.contact_info_id " +
					"inner join person_info pi on pi.person_info_id = pea.person_info_id " +
					"inner join person_address pa on pa.person_info_id = pea.person_info_id " + 
					"inner join address a on a.address_id = pa.address_id " +
					"where pe.changed_by_username like 'my%faadrone%' " +
					"and pe.party_enroll_type_cd in  ('ORGANIZATION') " +
					"and pe.party_enroll_status_cd = 'ACTIVE' " +
					"order by pi.changed_on_dttm asc limit 1 ");
			ArrayList<String> firstRow = new ArrayList<String>();
			firstRow = databaseConnection.getNextRowArray();
			String result = firstRow.get(0);
			System.out.println("Active Non Hobbyist Login Email Address from Stage Database is-->" + result);
			databaseConnection.closeConnection();
			return result;
	} 
	
	public static String getActiveHobbyistUserFromDB() {
		DatabaseConnection databaseConnection = new DatabaseConnection("integration");
		databaseConnection.executeStatement("select pea.username from party_enrollment pe " + 
				"join party_enrollment_account pea using (party_enroll_acct_id)" +
				"join person_info pi using (person_info_id) " +
				"where pe.party_enroll_status_cd = 'ACTIVE' and pe.changed_by_username like 'my%faadrone%' " + 
				"and pe.party_enroll_type_cd in ('INDIVIDUAL') " +
				"order by pi.changed_on_dttm asc limit 1 ");
		ArrayList<String> firstRow = new ArrayList<String>();
		firstRow = databaseConnection.getNextRowArray();
		String result = firstRow.get(0);
		System.out.println("Active Hobbyist Login Email Address from Integration Database is-->" + result);
		databaseConnection.closeConnection();
		return result;
	}
	//Active Hobbyist Account from Gateway Integration DB
	public static String getActiveHobbyistUserFromGatewayIntegrationDB() {
		System.out.println("<<--Hobbyist Profile Now at the INTEGRATION Database Step---->>" );
		DatabaseConnection databaseConnection = new DatabaseConnection("integration");
		databaseConnection.executeStatement("select pea.username " + 
				"from party_enrollment pe " +
				"inner join party_enrollment_account pea on pe.party_enroll_acct_id = pea.party_enroll_acct_id " +
				"inner join contact_info ci on ci.contact_info_id = pe.contact_info_id " +
				"inner join person_info pi on pi.person_info_id = pea.person_info_id " +
				"inner join person_address pa on pa.person_info_id = pi.person_info_id " +
				"inner join address a on a.address_id = pa.address_id " +
				"where pe.changed_by_username like 'my%faadrone%' " +
				"and pe.party_enroll_type_cd in  ('INDIVIDUAL')  " +
				"and pe.party_enroll_status_cd = 'ACTIVE' " +
				"order by pi.changed_on_dttm asc limit 1") ;
//		databaseConnection.executeStatement("select ci.email_address from party_enrollment pe " +
//		"inner join party_enrollment_account pea on pe.party_enroll_acct_id = pea.party_enroll_acct_id " +
//		"inner join contact_info ci on ci.contact_info_id = pe.contact_info_id " +
//		"inner join person_info pi on pi.person_info_id = pea.person_info_id " +
//		"inner join person_address pa on pa.person_info_id = pea.person_info_id " + 
//		"inner join address a on a.address_id = pa.address_id " +
//		"where pe.changed_by_username like 'my%faadrone%' " +
//		"and pe.party_enroll_type_cd in  ('INDIVIDUAL') " +
//		"and pe.party_enroll_status_cd = 'ACTIVE' " +
//		"order by pi.changed_on_dttm asc limit 1 ");
		ArrayList<String> firstRow = new ArrayList<String>();
		firstRow = databaseConnection.getNextRowArray();
		String result = firstRow.get(0);
		System.out.println("Gateway Application Active Hobbyist Login Email Address from Integration Database is-->" + result);
		databaseConnection.closeConnection();
		return result;
	}

	//Active Non Hobbyist Account from Gateway Integration DB
	public static String getActiveNonHobbyistUserFromGatewayIntegrationDB() {
		System.out.println("<<--Non Hobbyist Profile Now at the Gateway INTEGRATION Database Step---->>" );
		DatabaseConnection databaseConnection = new DatabaseConnection("integration");
		databaseConnection.executeStatement("select pea.username " +
		"from party_enrollment pe " +
		"inner join party_enrollment_account pea on pe.party_enroll_acct_id = pea.party_enroll_acct_id " +
		"inner join contact_info ci on ci.contact_info_id = pe.contact_info_id " +
		"inner join person_info pi on pi.person_info_id = pea.person_info_id " +
		"inner join organization_info oi on oi.party_enroll_id = pe.party_enroll_id " +
		"inner join organization_address oa on oa.org_info_id = oi.org_info_id " +
		"inner join address a on a.address_id = oa.address_id " +
		"where pe.changed_by_username like 'my%faadrone%' " +
		"and pe.party_enroll_type_cd in  ('ORGANIZATION')  " +
		"and pe.party_enroll_status_cd = 'ACTIVE' " +
		"order by pi.changed_on_dttm asc limit 1"); 
		ArrayList<String> firstRow = new ArrayList<String>();
		firstRow = databaseConnection.getNextRowArray();
		String result = firstRow.get(0);
		System.out.println("Gateway Application Active Non Hobbyist with Completed Profile Login Email Address from Integration Database is-->" + result);
		databaseConnection.closeConnection();
		return result;
	}

	
	
	//logInRandomNonHobbyistPersonalAndOrgProfile
	//Active Non Hobbyist Account to Update Personal and Org Profie from Gateway Integration DB
	public static String getActiveNonHobbyistPersonalAndOrgProfile() {
		System.out.println("<<--Non Hobbyist Personal and Org Profile Now at the Gateway INTEGRATION Database Step---->>" );
		DatabaseConnection databaseConnection = new DatabaseConnection("integration");
		databaseConnection.executeStatement("select pea.username " +
				"from party_enrollment pe " +
				"inner join party_enrollment_account pea on pe.party_enroll_acct_id = pea.party_enroll_acct_id " +
				"inner join contact_info ci on ci.contact_info_id = pe.contact_info_id " +
				"inner join organization_info oi on oi.party_enroll_id = pe.party_enroll_id " +
				"inner join organization_address oa on oa.org_info_id = oi.org_info_id " +
				"inner join person_info pi on pi.person_info_id = pea.person_info_id " +
				"inner join person_address pa on pa.person_info_id = pi.person_info_id " +
				"inner join address a on a.address_id = pa.address_id " +
				"inner join address aa on aa.address_id = oa.address_id " +
				"where pe.changed_by_username like 'my%faadrone%' " +
				"and pe.party_enroll_status_cd = 'ACTIVE' " +
				"order by pi.changed_on_dttm asc limit 1");
//		databaseConnection.executeStatement("select ci.email_address " +
//		"from party_enrollment pe " +
//		"inner join party_enrollment_account pea on pe.party_enroll_acct_id = pea.party_enroll_acct_id " +
//		"inner join contact_info ci on ci.contact_info_id = pe.contact_info_id " +
//		"inner join person_info pi on pi.person_info_id = pea.person_info_id " +
//		"inner join organization_info oi on oi.party_enroll_id = pe.party_enroll_id " +
//		"inner join organization_address oa on oa.org_info_id = oi.org_info_id " +
//		"inner join address a on a.address_id = oa.address_id " +
//		"where pe.changed_by_username like 'my%faadrone%' " +
//		"and pe.party_enroll_type_cd in  ('ORGANIZATION')  " +
//		"and pe.party_enroll_status_cd = 'ACTIVE' " +
//		"order by pi.changed_on_dttm asc limit 1"); 
		ArrayList<String> firstRow = new ArrayList<String>();
		firstRow = databaseConnection.getNextRowArray();
		String result = firstRow.get(0);
		System.out.println("Gateway Application Active Non Hobbyist with Completed Profile Login Email Address from Integration Database is-->" + result);
		databaseConnection.closeConnection();
		return result;
	}

	
	
	//Active Hobbyist Account from Test DB
	public static String getActiveHobbyistUserFromGatewayTestDB() {
		System.out.println("<<--Now at the TEST Database Step---->>" );
		DatabaseConnection databaseConnection = new DatabaseConnection("test");
		databaseConnection.executeStatement("select pea.username from party_enrollment pe " + 
				"join party_enrollment_account pea using (party_enroll_acct_id)" +
				"join person_info pi using (person_info_id) " +
				"where pe.party_enroll_status_cd = 'ACTIVE' and pe.changed_by_username like 'my%faadrone%'  " + 
				"and pe.party_enroll_type_cd in ('INDIVIDUAL') " +
				"order by pi.changed_on_dttm asc limit 1 ");
		ArrayList<String> firstRow = new ArrayList<String>();
		firstRow = databaseConnection.getNextRowArray();
		String result = firstRow.get(0);
		System.out.println("Gateway Application Active Hobbyist Login Email Address from Test Database is-->" + result);
		databaseConnection.closeConnection();
		return result;
	}

	
	//Cancel Registration 
	public static String getHobbyistUserFromGatewayCancelRegistrationIntegrationDB() {
		DatabaseConnection databaseConnection = new DatabaseConnection("integration");
		databaseConnection.executeStatement("select pea.username from party_enrollment pe "
				+ "join party_enrollment_account pea using (party_enroll_acct_id)"
				+ "join person_info pi using (person_info_id) "
//				+ "join registration r using (party_enroll_id) "
				+ "where pe.party_enroll_status_cd = 'ACTIVE' and pe.changed_by_username like 'my%faadrone%' "
				+ "and pe.party_enroll_type_cd in ('INDIVIDUAL') "
				+ "order by pi.changed_on_dttm asc  limit 1");
		ArrayList<String> firstRow = new ArrayList<String>();
		firstRow = databaseConnection.getNextRowArray();
		String result = firstRow.get(0);
		System.out.println("Gateway Application Active Hobbyist Email Address to Cancel Registration from Integration Database is-->" + result);
		databaseConnection.closeConnection();
		return result;
	}

	//Cancel Registration 
	public static String getHobbyistUserFromGatewayCancelRegistrationTestDB() {
		DatabaseConnection databaseConnection = new DatabaseConnection("test");
		databaseConnection.executeStatement(""
				+ "select pea.username from party_enrollment pe "
				+ "join party_enrollment_account pea using (party_enroll_acct_id)"
				+ "join person_info pi using (person_info_id) "
//				+ "join registration r using (party_enroll_id) "
				+ "where pe.party_enroll_status_cd = 'ACTIVE' and pe.changed_by_username like 'my%faadrone%' "
				+ "and pe.party_enroll_type_cd in ('INDIVIDUAL') "
				+ "order by pi.changed_on_dttm asc  limit 1");
		ArrayList<String> firstRow = new ArrayList<String>();
		firstRow = databaseConnection.getNextRowArray();
		String result = firstRow.get(0);
		System.out.println("Gateway Application Active Hobbyist Email Address to Cancel Registration from Test Database is-->" + result);
		databaseConnection.closeConnection();
		return result;
	}

	
	/** <li>Creates a start and end date/time 1 hour apart</li>
	 * <li>Returns a string array 4 wide</li>
	 * <li>{"StartDate", "StartTime", "EndDate", "EndTime"}</li>
	 * 
	 * @return - a new string array to use for schedules. Example:
	 *         {"01/15/2016", "09:00 PM", "01/15/2016", "10:00 PM"} */
	public static String[] GetNewUniqueDateAndTimeForSchedules() {
		String returnArray[] = new String[4];
		DateTime scheduleDate = new DateTime().withMinuteOfHour(0)
				.plusHours(DataGenerator.randomIntegerBetween(1, 26280));
		returnArray[0] = scheduleDate.toString("MM/dd/yyyy", Locale.US);
		returnArray[1] = scheduleDate.toString("hh:mm a", Locale.US);
		returnArray[2] = scheduleDate.toString("MM/dd/yyyy", Locale.US);
		returnArray[3] = scheduleDate.plusHours(1).toString("hh:mm a", Locale.US);
		return returnArray;
	}

	/** format examples:
	 * <p>
	 * MM_dd_yyyy
	 * <p>
	 * MM/dd/yyyy */
	public static String GetDateToday(String format) {
		return getDateForNumberOfDaysInFuture(0, format);
	}

	/** format examples:
	 * <p>
	 * MM_dd_yyyy
	 * <p>
	 * MM/dd/yyyy
	 * <p>
	 * MM-dd-yyyy */
	public static String getDateForNumberOfDaysInFuture(int numberOfDaysInTheFuture, String format) {
		DateTime scheduleDate = new DateTime();
		return scheduleDate.plusDays(numberOfDaysInTheFuture).toString(format, Locale.US);
	}

	/** Re-formats date from originalFormat to newFormat
	 * 
	 * @param date
	 * @param originalFormat
	 * @param newFormat
	 * @return - new date */
	public static String formatDate(String date, String originalFormat, String newFormat) {
		String outputDate = "";
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(originalFormat);
			Date tempDate = sdf.parse(date);
			SimpleDateFormat outputDateFormat = new SimpleDateFormat(newFormat);
			outputDate = outputDateFormat.format(tempDate);
		} catch (ParseException ex) {
			System.out.println("Parse Exception");
		}
		return outputDate;

	}

	/** Return a list that contains the capture groups of the regex expression
	 * when compiled against the string
	 * 
	 * @param string
	 * @param regularExpression
	 * @return */
	public static List<String> getValuesFromRegEx(String string, String regularExpression) {
		List<String> returnList = new ArrayList<String>();
		Matcher m = Pattern.compile(regularExpression).matcher(string);
		if (m.find()) {
			for (int i = 0; i < m.groupCount(); i++) {
				returnList.add(m.group(i));
			}
		}
		return returnList;
	}

	/** true if the given string and regular expression returns at least 1 match
	 * 
	 * @param string
	 * @param regularExpression
	 * @return */
	public static boolean isRegExMatch(String string, String regularExpression) {
		return Pattern.compile(regularExpression).matcher(string).find();
	}

	public static void writeTestResultsToFile() {
		try {
			FileWriter writer = new FileWriter("C:/Users/" + System.getProperty("user.name") + "/Tools/TestResults/testResults.txt", true);
			//BufferedWriter bufferedWriter = new BufferedWriter(writer);
			writer.write("\r\n"); //write new line
			writer.write("Hello World");
			writer.write(", ");
			writer.write("\r\n"); //write new line
			writer.write(DataGenerator.randomOrganizationName() + " " );
			writer.write(", ");
			writer.write(DataGenerator.getActiveNonHobbyistCpeUserFromIntegrationDB() + " ");
			writer.write("\r\n"); //write new line
			writer.write("See You Again!");
			writer.write("\r\n"); //write new line
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	//	public static String getActiveNonHobbyistCpeUserFromIntegrationDB() {
public static DateTime currentDateTimeStamp() {
	LocalDate date = LocalDate.now();
//	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/DD/YYYY HH:mm:ss a");
//	String text = date.format(formatter);
//	LocalDate parsedDate = LocalDate.parse(text, formatter);
//	System.out.println("Date Time Stamp is-> " + parsedDate);
//
	DateTime rightNow = new DateTime();
	
	// ISO STANDARD (default format of DateTime)
	DateTimeFormatter isoFormat = ISODateTimeFormat.dateTime();
	System.out.println(isoFormat.print(rightNow));	//2016-06-07T23:59:39.633-03:00
	
	// CUSTOM FORMAT DATE
	DateTimeFormatter fmt1 = DateTimeFormat.forPattern("MM-dd-yyyy HH:mm:ss");
	System.out.println(fmt1.print(rightNow));		//06-07-2016 23:59:39
	
	DateTimeFormatter fmt2 = DateTimeFormat.forPattern("yyyy-MMM-dd");
	System.out.println(fmt2.print(rightNow));		//2016-Jun-07
	
	return rightNow;
	
	
	}	 
	
	
}
