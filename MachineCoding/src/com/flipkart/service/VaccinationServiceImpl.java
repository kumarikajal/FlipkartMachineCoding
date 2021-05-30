package com.flipkart.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.flipkart.entity.Centre;
import com.flipkart.entity.User;

public class VaccinationServiceImpl implements VaccinationService {
	static Long centreId=1L;
	List<User> userlist;
	List<Centre> centrelist;
	Map<String ,User> userMap;
	Map<Long,Centre> centreMap;


	public VaccinationServiceImpl() {
		super();
		userlist=new ArrayList<>();
		centrelist=new ArrayList<>();
		userMap=new HashMap<>();
		centreMap=new HashMap<>();
	
		   
	}

	@Override
	public void registerUser(User user) {
		
		 userlist.add(user);
		 userMap.put(user.getEmail(), user);
		 System.out.println("User successfully registered");
		
	}

	@Override
	public void registerCentre(Centre centre) {
		
		centrelist.add(centre);
		centre.setCentreId(centreId);
		centreId++;
		centreMap.put(centreId, centre);
		System.out.println("Centre successfully registered");
	
	}

	@Override
	public List<Centre> getCentre(String email) {
		
		   User user=userMap.get(email);
		   String val="covax";
		   List<Centre> value=new ArrayList<Centre>();
		   for(Centre centre:centrelist)
		   {
			  if( user.getVaccineType().toLowerCase()=="covax"&&centre.getCovaxNo()>0)
				  {value.add(centre);
				   val="covax";
				  }
			  else if( user.getVaccineType().toLowerCase()=="covishield"&&centre.getCovisiledNo()>0)
			      {value.add(centre);
			         val="covishield";
			      }
		   }
		   
		   Comparator com=new Comparator<Centre>() {

			@Override
			public int compare(Centre c1, Centre c2) {
				String val="covax";
				if(user.getVaccineType().toLowerCase()=="covax")
					val="covax";
				if(user.getVaccineType().toLowerCase()=="covishield")
					val="covishield";
				if(val.equals("covishield"))
					   return  c1.getCovisiledNo()-c2.getCovisiledNo();
				else if(val.equals("covax"))
					   return  c1.getCovaxNo()-c2.getCovaxNo();
				
				return c1.getListUser().size()-c2.getListUser().size();
					
	            
			}
			   
		};
		   Collections.sort(value,com);
		   for(Centre centre:value)
		   {
			   System.out.println(centre.getCovaxNo()+" "+centre.getCovisiledNo());
			   
		   }
		
		return null;
	}

	@Override
	public void bookSlot(String userEmail,Long CentreId) {
		
		User user=userMap.get(userEmail);
		if(user.getSlotsBooked()==1)
			 System.out.println("No further bookings can be made");
		user.setSlotsBooked(1);
		String vax=user.getVaccineType().toLowerCase();
		Centre centre=centreMap.get(CentreId);
		boolean flag=false;
	 
		if(user.getVaccineType()=="covax"&&centre.getCovaxNo()>0)
			{centre.setCovaxNo(centre.getCovaxNo()-1);
			 flag=true;
			 
			}
		else if(user.getVaccineType()=="covishield"&&centre.getCovisiledNo()>0)
			{centre.setCovisiledNo(centre.getCovisiledNo()-1);
			flag=true;
			 
			}
		if(flag==false)
			System.out.println("booking can not be made");
		else
		centre.adduser(user);	
	}

	@Override
	public void getStats() {
		// TODO Auto-generated method stub
		for(Centre centre: centrelist)
		{
			System.out.println(centre.getCentreId()+" "+centre.getCovaxNo()+" "+centre.getCovisiledNo()+" "+centre.getLocation());
			for(User user:centre.getListUser())
			{
				System.out.println(user.getEmail()+" "+user.getUserName());
				
			}
			
		}
	
	}

}
