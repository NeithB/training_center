package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.List;

import modele.Calendrier;
import modele.Lecon;
import modele.Planning;

public class PlanningDao extends DAO {

	public void insert(Planning plan) {
		String query="INSERT INTO planifier VALUES(?,?)";
		
		try {
			PreparedStatement statement=getConnection().prepareStatement(query);
			
			statement.setInt(1, plan.getLecon().getId_lecon());
			statement.setInt(2, plan.getCalendrier().getId_calendar());
			
			statement.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("Dans planningDao methode insert "+ e.getMessage());
		}		
				
	}
	
	public List<Planning> listePlaning(){
		
		List<Planning> liste=new ArrayList<>();
		String query="SELECT * FROM planifier ";
		try {
			PreparedStatement statement=getConnection().prepareStatement(query);
					
			ResultSet resultset = statement.executeQuery();
			
			while(resultset.next()) {
				
				CalendrierDao calDao=new CalendrierDao();
				CoursDao coursDao=new CoursDao();
				
				int intCours=resultset.getInt("lecon");
				int intCal=resultset.getInt("calendrier");
				
				
				
				Calendrier calendrier=calDao.getCalendrier(intCal);
				Lecon cours=coursDao.getLecon(intCours);
				
				
				
				Planning planing=new Planning(calendrier, cours);
				
				
				
				liste.add(planing);			
			}
			
			return liste;
			
		} catch (SQLException e) {
			System.out.println("Dans planningDao listePlanning "+ e.getMessage());
		}
		
		
		
		return null;
	}

	public void supprimer(int idL, int idC) {
		String query="DELETE FROM planifier WHERE lecon=? AND calendrier=?";
		try {
			PreparedStatement statement=getConnection().prepareStatement(query);
			
			statement.setInt(1, idL);
			statement.setInt(2, idC);
			
			statement.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("Dans planingDao methode supprimer "+e.getMessage());
		}
		
	}

}
