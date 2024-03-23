package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.List;

import modele.Calendrier;
import modele.Lecon;
import modele.Niveaux;
import modele.User;

public class CoursDao extends DAO {

	public CoursDao() {
		super();
	}

	public void insert(Lecon lecon) {
		String query = "INSERT INTO lecon VALUES(NULL,?,?,?)";

		try {

			PreparedStatement statement = getConnection().prepareStatement(query);

			statement.setString(1, lecon.getTitre());
			statement.setInt(2, lecon.getUser().getId_user());
			statement.setInt(3, lecon.getNiveaux().getId_niveaux());

			statement.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Dans CoursDao methode insert" + e.getMessage());
		}

	}

	public List<Lecon> listeCours() {

		List<Lecon> liste = new ArrayList<>();
		String query = "SELECT * FROM lecon";
		try {
			PreparedStatement statement = getConnection().prepareStatement(query);

			ResultSet resultset = statement.executeQuery();

			UserDao userDao = new UserDao();
			NiveauDao niveauDao = new NiveauDao();
			
			while (resultset.next()) {


				int id_lecon = resultset.getInt("id_lecon");
				String titre = resultset.getString("titre");

				int id_niv = resultset.getInt("niveau");
				int id_user = resultset.getInt("admin");

				Niveaux niveau = niveauDao.getNiveau(id_niv);
				User user = userDao.getUser(id_user);
				
				

				Lecon cours = new Lecon(id_lecon, titre, user, niveau);
				
				liste.add(cours);

			}

			return liste;

		} catch (SQLException e) {
			System.out.println("Dans CoursDao classe listCours " + e.getMessage());
		}

		return null;
	}
	public Lecon getLecon(int id) {
		
		String query = "SELECT* FROM lecon WHERE id_lecon=?";
		try {
			PreparedStatement statement = getConnection().prepareStatement(query);


			statement.setInt(1, id);
			
			ResultSet resultset = statement.executeQuery();

			if (resultset.next()) {

				UserDao userDao = new UserDao();
				NiveauDao niveauDao = new NiveauDao();

				int id_lecon = resultset.getInt("id_lecon");
				String titre = resultset.getString("titre");

				int id_niv = resultset.getInt("niveau");
				int id_user = resultset.getInt("admin");

				Niveaux niveau = niveauDao.getNiveau(id_niv);
				User user = userDao.getUser(id_user);

				return new Lecon(id_lecon, titre, user, niveau);
			}

			

		} catch (SQLException e) {
			System.out.println("Dans CoursDao getLecon " + e.getMessage());
		}

		return null;
	}

	public void supprimer(int id) {
		String query = "DELETE FROM lecon WHERE id_lecon=?";

		try {
			PreparedStatement statement = getConnection().prepareStatement(query);
			statement.setInt(1, id);

			statement.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Dans coursDao methode supprimer " + e.getMessage());
		}
		
	}

}
