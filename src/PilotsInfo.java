import com.google.gson.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class PilotsInfo {
	
	private String name;
	private String address;
	private String city;
	private int zip;
	private String credentials;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getZip() {
		return zip;
	}
	public void setZip(int zip) {
		this.zip = zip;
	}
	public String getCredentials() {
		return credentials;
	}
	public void setCredentials(String credentials) {
		this.credentials = credentials;
	}
	
	/*
	 * The function takes in a text file as input and converts the text file
	 * into Json object and displays the output to the console.
	 * The function has a void return type
	 * 
	 * NOTE: I did not do extra validation because I went with the assumption that
	 * the text file will be formatted like I have in the data.txt. After every space,
	 * if the file is not empty, that chunk of data gets parse into JsonObject and added 
	 * to the list 
	 */
	@SuppressWarnings("resource")
	public static void convertTextToJson(String file) {
		PilotsInfo pd = new PilotsInfo();
		ArrayList<String> list = new ArrayList<String>();
		// loop through the text file
		try {
			Scanner s = new Scanner(new File(file));
			while (s.hasNext()) {
				s.next();
				pd.setName(s.nextLine());
				s.next();
				pd.setAddress(s.nextLine());
				s.next();
				pd.setCity(s.nextLine());
				s.next();
				pd.setZip(Integer.parseInt(s.nextLine().trim()));
				s.next();
				pd.setCredentials(s.nextLine());
				
				// Converts text to Gson object then JsonObject
				// and store them in a list
				Gson gson = new GsonBuilder().setPrettyPrinting().create();
				list.add(gson.toJson(pd));
			}
			s.close();
		}
		catch(FileNotFoundException e) {
			System.out.println("file not found");
		}
		//print the list of jsonObjects to the console
		System.out.println(list.toString());
	}
	// main 
	public static void main(String[] args) {
		convertTextToJson("data.txt");
	}
}
