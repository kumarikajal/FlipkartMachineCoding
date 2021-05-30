package com.flipkart.driver;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.flipkart.entity.Centre;
import com.flipkart.entity.User;
import com.flipkart.service.VaccinationServiceImpl;


public class VaccinationDrive {

	public static void main(String[] args) throws Exception {
		VaccinationServiceImpl vaccinationServiceImpl=new  VaccinationServiceImpl();
		Scanner sc = new Scanner(System.in);
		String input;
		System.out.println("Welcome to coflip App");
		while(true) {
			input = sc.nextLine();
			if(input.equals("end")) {
				System.exit(1);
			}
			
			String[] i = input.split(" ");
			
			switch(i[0]) {
				case "registerUser":
					      if(i.length<4)
					      {
					    	  System.out.println("Enter more paramters");
					      }
					      else
					      {
					         User user= new User(i[1],i[2],i[3],0);
					         vaccinationServiceImpl.registerUser(user);
					      }
					
					break;
					
				case "registerCentre":
					if(i.length<4)
				      {
				    	  System.out.println("Enter more paramters");
				      }
					else
					{
					  Centre centre= new Centre(Integer.parseInt(i[1]),Integer.parseInt(i[2]),i[3]);
				      vaccinationServiceImpl.registerCentre(centre);
					}
					break;
					
				case "getCentres":
					      
					    vaccinationServiceImpl.getCentre(i[1]);
					  
					
				
					break;
					
				case "bookSlot":
					if(i.length<3)
				      {
				    	  System.out.println("Enter more paramters");
				      }
					else
					{
						   vaccinationServiceImpl.bookSlot(i[1], Long.parseLong(i[2]));
					}
					break;   
					
		
					
				case "getStats":
					
					
						   vaccinationServiceImpl.getStats();
						
							
					
					break;   
				    
				default:
					break;
			}
		}
		
	}
}
	
	

