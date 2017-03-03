
package faa.cucumber.pages;

import org.openqa.selenium.support.FindBy;

import faa.utils.DataGenerator;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.WebElementFacade;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;


public class RandomValuesPage extends BasePageObject  {

	CreateNewProfilePage createNewProfilePage;
	UpdateStrikeProfilePage updateStrikeProfilePage;
	FaaHomePage faaHomePage;

	
	
	
	
	String[] newProfilePhysicalAddress  = DataGenerator.randomAddress();
	String[] newProfileMailingAddress  = DataGenerator.randomAddress();
	

	
	public void clickOnCancelConfirmAddressButton() {
		System.out.println("Click the Cancel Confirm Address 'btn' Button");
	}



	
	
//////////////////////
	public void updatePhysicalAndMailingAddress(){
		System.out.println("New Physical Country is " + newProfilePhysicalAddress[0]);
		System.out.println("New Physical Address1 is " + newProfilePhysicalAddress[1]);
		System.out.println("New Physical Address2 is " + newProfilePhysicalAddress[2]);
		System.out.println("New Physical City is " + newProfilePhysicalAddress[3]);
		System.out.println("New Physical State is " + newProfilePhysicalAddress[4]);
		System.out.println("New Physical Zip is " + newProfilePhysicalAddress[5]);
		
		System.out.println("New Mailing Country is " + newProfileMailingAddress[0]);
		System.out.println("New Mailing Address1 is " + newProfileMailingAddress[1]);
		System.out.println("New Mailing Address2 is " + newProfileMailingAddress[2]);
		System.out.println("New Mailing City is " + newProfileMailingAddress[3]);
		System.out.println("New Mailing State is " + newProfileMailingAddress[4]);
		System.out.println("New Mailing Zip is " + newProfileMailingAddress[5]);
		//updatedPhysicalCountry
		Serenity.setSessionVariable("varProfilePhysicalCountry").to(newProfilePhysicalAddress[0]);
		String updatedProfilePhysicalCountry = Serenity.sessionVariableCalled("varProfilePhysicalCountry").toString();
		System.out.println("On Verify new Physical Country is--->  " + updatedProfilePhysicalCountry);
		createNewProfilePage.selectProfilePhysicalCountryDropDown(updatedProfilePhysicalCountry); 
		
		//updatedProfilePhysicalAddress1
		Serenity.setSessionVariable("varProfilePhysicalAddress1").to(newProfilePhysicalAddress[1]);
		String updatedProfilePhysicalAddress1 = Serenity.sessionVariableCalled("varProfilePhysicalAddress1").toString();
		System.out.println("On Verify new Physical Address1 is--->  " + updatedProfilePhysicalAddress1);
//		createNewProfilePage.typeIntoCreateProfileMailingAddress1(updatedProfilePhysicalAddress1);
		createNewProfilePage.typeIntoCreateProfilePhysicalAddress1(updatedProfilePhysicalAddress1);

	}

	public void randomRoleTypes() {
		System.out.println("Random Role Types 1-->" + DataGenerator.randomRoleType2());
		System.out.println("Random Role Types 2-->" + DataGenerator.randomRoleType2());
		System.out.println("Random Role Types 3-->" + DataGenerator.randomRoleType2());
		System.out.println("Random Role Types 4-->" + DataGenerator.randomRoleType2());
		System.out.println("Random Role Types XX->"  );
	}

//	public class B {

	  public static void main(String[] args) throws FileNotFoundException {
	     Map<String,Integer> map = new HashMap<String,Integer>();
	     for(int i = 0; i < 1000; ++i)
	     {
	        String s = choose(new File("C:/Users/jfrankl6/workspacex/faa-gradle-newtest/src/test/java/faa/utils/role_types.txt"));
	        if(!map.containsKey(s))
	           map.put(s, 0);
	        map.put(s, map.get(s) + 1);
	     }

	     System.out.println(map);
	  }

	  public static String choose(File f) throws FileNotFoundException
	  {
	     String result = null;
	     Random rand = new Random();
	     int n = 0;
	     for(Scanner sc = new Scanner(f); sc.hasNext(); )
	     {
	        ++n;
	        String line = sc.nextLine();
	        if(rand.nextInt(n) == 0)
	           result = line;         
	     }

	     return result;      
	  }


		public void randomRoleTypes3() {

	  try {
	        //I would prefer to read my file using NIO, which is faster
		    Path pathToMyTextFile = Paths.get((System.getProperty("user.dir") + "/src/test/java/faa/utils/titles.txt"));
	        //Path pathToMyTextFile = Paths.get("C:/Users/jfrankl6/workspacex/faa-gradle-newtest/src/test/java/faa/utils/role_types.txt");
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
	        System.out.println("randomWord Random Role Types -->" + randomWord);
	    } catch (IOException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    }

	}

		
		public static void randomRoleTypes4(String[] args) throws IOException {

//			public static void main(String[] args) throws IOException {
			    File nouns = new File("C:/Users/jfrankl6/workspacex/faa-gradle-newtest/src/test/java/faa/utils/role_types.txt");
			    Scanner scan = new Scanner(nouns);
			    while(scan.hasNextLine()){
			        if("__(N)".equals(scan.nextLine().trim())){
			            int word = (int) (Math.random() * 100);
			            System.out.println("Random Role Types 4-->" + word);
			            System.out.println("Random Role Types scan-->" + scan.next());

			        }
			    }
			}


		/** @return random title from file 
		 * @throws IOException */
		public String randomTitle() {
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

			        //Here I get a random Noun
			        String randomWord = linesInFile.get(randomIndexForWord);
			        System.out.println("randomWord Random Title -->" + randomWord);
			        returnValue = randomWord;
			    } catch (IOException e) {
			        // TODO Auto-generated catch block
			        e.printStackTrace();
			    }
		        System.out.println("returnValue Random Title -->" + returnValue);
			  return returnValue;
		}
					
		
		
		


}	
	
	
	
	
	
	
	
	
	
	
		
		

