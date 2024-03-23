package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;
import java.util.*;
import java.util.List;

import com.mysql.cj.protocol.Resultset;

import modele.Calendrier;
import modele.User;

public class CalendrierDao extends DAO{
	
	public CalendrierDao() {
		super();
	}

	public void insert(Calendrier cal) {
		
		String query="INSERT INTO calendrier VALUES(NULL,?,?)";
		
		try {
			
			PreparedStatement statement=getConnection().prepareStatement(query);
			
			statement.setDate(1, (Date) cal.getDate_calendar());
			statement.setObject(2, cal.getHeure_calendar());
			
						
			statement.executeUpdate();
			
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		
	}

	public List<Calendrier>  calendar() {
		
			 List<Calendrier> liste =new ArrayList<>();
			
			UserDao userDao=new UserDao();
			
			String query="SELECT* From calendrier";
			
			try {
				PreparedStatement statement=getConnection().prepareStatement(query);
				
				ResultSet resultset=statement.executeQuery();
				
				while(resultset.next()) {
					
					
					
					 Calendrier calend =new Calendrier(
					
							resultset.getInt("id_calendar"),
							resultset.getDate("date_cal"),
							resultset.getString("heure_cal")
				
							);	
					 
					 liste.add(calend);
				};
				return liste;
				
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		
		return null;
	}
	
	public Calendrier getCalendrier(int id) {
		
		
		String query="SELECT * FROM calendrier WHERE id_calendar= ?";
			
			try {
				
				PreparedStatement statement=getConnection().prepareStatement(query);
				
				statement.setInt(1, id);
				
				
				ResultSet resultset=statement.executeQuery();
				
				if(resultset!=null) {
					
					if(resultset.next()) {
						
						
						
						int id_calendar=resultset.getInt("id_calendar"); 
						Date date_calendar=resultset.getDate("date_cal");
						String heure_cal=resultset.getString("heure_cal");
					
						return new Calendrier(id_calendar, date_calendar, heure_cal);						
								
					}
					
					
				}
				
				
			} catch (SQLException e) {
				System.out.println("Dans calendrierDao methode getCalendrier "+ e.getMessage());
			}
			
			return null;
			
			
		}

	public void supprimer(int id) {
		
		
		
	}

	

}
