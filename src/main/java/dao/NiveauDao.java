package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import modele.Calendrier;
import modele.Niveaux;

public class NiveauDao extends DAO {
	
	public NiveauDao() {
		super();
	}

	public void insert(Niveaux niv) {
		String query="INSERT INTO niveaux VALUES(NULL,?,?)";
		
		try {
			
			PreparedStatement statement=getConnection().prepareStatement(query);
			
			statement.setString(1,  niv.getLibelle());
			statement.setInt(2, niv.getCalendrier().getId_calendar());
						
			statement.executeUpdate();
			
			
		} catch (SQLException e) {
			System.out.println("Dans NiveauDao Methode insert "+e.getMessage());
		}
		
		
	}
	public Niveaux getNiveau(int id) {
		
		String query="SELECT * FROM niveaux WHERE id_Niveaux= ?";
		
		try {
			
			PreparedStatement statement=getConnection().prepareStatement(query);
			
			statement.setInt(1, id);
			
			
			ResultSet resultset=statement.executeQuery();
			
			
			if(resultset.next()) {
				
				UserDao userDao=new UserDao();
				CalendrierDao calDao=new CalendrierDao();
				
				int id_niveau=resultset.getInt("id_Niveaux"); 
				String libelle=resultset.getString("libelle");
				
				
				int id_cal=resultset.getInt("calendrier");
							
				Calendrier cal=calDao.getCalendrier(id_cal);
				
				
				return new Niveaux(id_niveau, libelle, cal); 					
						
			};
			
			
		} catch (SQLException e) {
			System.out.println("Dans NiveauDao methode getNiveau "+ e.getMessage());
		}
		
		return null;
		
		
	}
	public List<Niveaux> listesNiveaux() {

		
		
		List<Niveaux> liste=new ArrayList<>();
		
		String query="SELECT * FROM niveaux";
		
		try {
			
			PreparedStatement statement=getConnection().prepareStatement(query);
			
			ResultSet resultset=statement.executeQuery();
			
			
			while(resultset.next()) {
				
				UserDao userDao=new UserDao();
				CalendrierDao calDao=new CalendrierDao();
				
				int id_niveau=resultset.getInt("id_Niveaux"); 
				String libelle=resultset.getString("libelle");
				
						
				int id_cal=resultset.getInt("calendrier");
				
				
					
				Calendrier cal=calDao.getCalendrier(id_cal);
				
				
				Niveaux niveaux=new Niveaux(id_niveau, libelle, cal);
				
				liste.add(niveaux);
									
			};
			return liste;
			
		} catch (SQLException e) {
			System.out.println("Dans Niveau methode listeNiveau "+ e.getMessage());
		}
		
		return null;
		
		
	}

	public void supprimer(int id) {
		
		String query = "DELETE FROM niveaux WHERE id_niveaux=?";

		try {
			PreparedStatement statement = getConnection().prepareStatement(query);
			statement.setInt(1, id);

			statement.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Dans niveauxDao methode supprimer " + e.getMessage());
		}
		
	}

}
