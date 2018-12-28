/*
E/15/138 Irfan M.M.M
Lab05
*/

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {

    private static  Map<String, List<Contact>> firstNameMap = new HashMap<String, List<Contact>>();
    private static  Map<String, List<Contact>> lastNameMap = new HashMap<String, List<Contact>>();
    private  static String mode;
    private  static String key;

    // change the path if you are reading the csv file from a different location
    private static final String csvFile =System.getProperty("user.dir")+"/csvfile.csv";
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // String input
        System.out.println("Please enter the FirstName or LastName");
        String input = sc.nextLine();
	String[] a;
         try{
        	a=input.split(":");
 		key=a[1].toLowerCase();
        	mode=a[0];
         }catch (ArrayIndexOutOfBoundsException e){
	System.out.println("Invalid Input");
        return;		 
	} 

        addCsv();// adding the csv file content to map
       
        if(!search()){
            System.out.println("No entries were matching");
        }
    }

    public static boolean search(){

        if(mode.equalsIgnoreCase("f")){
            if(!firstNameMap.containsKey(key)){
                return false; // return if the key is not there in the map
            }
            List<Contact> list=firstNameMap.get(key);
            for (Contact contact: list) {
              contact.printDetails();// print all the matches
            }
            return true;
        }
        if(mode.equalsIgnoreCase("l")){
            if(!lastNameMap.containsKey(key)){
                return false; // return if the key is not there in the map
            }
            List<Contact> list=lastNameMap.get(key);
            for (Contact contact: list) {
              contact.printDetails();// print all the matches
            }
            return true;
        }
        return false;

    }

    public static void addCsv() {
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        try {

            br = new BufferedReader(new FileReader(csvFile));
            line = br.readLine();//ignore the first line
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] array = line.split(cvsSplitBy);
                // get content from csv
                String firstName=array[0];
                String lastName=array[1];
                String phoneNumber=array[2];

                Contact c=new Contact(firstName,lastName,phoneNumber);
                //Create lists for both the maps
                List<Contact> fNameList=new ArrayList<Contact>();
                List<Contact> lNameList=new ArrayList<Contact>();

                if(firstNameMap.containsKey(firstName.toLowerCase())){
                    firstNameMap.get(firstName.toLowerCase()).add(c);//if the key is already there,just add the next entry
                }else {
                    fNameList.add(c);
                    firstNameMap.put(firstName.toLowerCase(),fNameList);// create a new key and a list
                }

                if(lastNameMap.containsKey(lastName.toLowerCase())){
                    lastNameMap.get(lastName.toLowerCase()).add(c);
                }else {
                    lNameList.add(c);
                    lastNameMap.put(lastName.toLowerCase(),lNameList);
                }
            }

            //handling exceptions
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
