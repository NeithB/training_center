package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.List;

import com.mysql.cj.protocol.Resultset;

import modele.Niveaux;
import modele.User;

public class UserDao extends DAO {

	public UserDao() {
		super();
	}

	public void insert(User user) {
		String query = "INSERT INTO utilisateur VALUES(NULL,?,?,?,?,?,?,?,?)";

		try {

			PreparedStatement statement = getConnection().prepareStatement(query);

			statement.setString(1, user.getNom());
			statement.setString(2, user.getPrenom());
			statement.setString(3, user.getSexe());
			statement.setString(4, user.getLogin());
			statement.setString(5, user.getMdp());
			statement.setString(6, user.getEmail());
			statement.setString(7, user.getRole());
			statement.setInt(8, user.getNiveau().getId_niveaux());

			statement.executeUpdate();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}

	public User connecter(String login, String mdp) {
		String query = "SELECT * FROM utilisateur where login=? AND mdpasse=?";

		try {

			PreparedStatement statement = getConnection().prepareStatement(query);

			statement.setString(1, login);
			statement.setString(2, mdp);

			ResultSet resultset = statement.executeQuery();

			if (resultset.next()) {

				NiveauDao niveauDao = new NiveauDao();

				int intNiv = Integer.parseInt(resultset.getString("niveau"));

				Niveaux niveau = niveauDao.getNiveau(intNiv);

				return new User(

						resultset.getInt("id_user"),
						resultset.getString("nom"),
						resultset.getString("prenom"),
						resultset.getString("sexe"), 
						resultset.getString("login"),
						resultset.getString("mdpasse"),
						resultset.getString("email"),
						resultset.getString("role"), 
						niveau);

			}
			;

		} catch (SQLException e) {
			System.out.println("dans UserDao connecter" + e.getMessage());
		}

		return null;
	}

	public void supprimer(int id) {

		String query = "DELETE FROM utilisateur WHERE id_user=?";

		try {
			PreparedStatement statement = getConnection().prepareStatement(query);
			statement.setInt(1, id);

			statement.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Dans UserDao methode supprimer " + e.getMessage());
		}

	}

	public User getUser(int id) {
		String query = "SELECT * FROM utilisateur WHERE id_user= ?";

		try {

			PreparedStatement statement = getConnection().prepareStatement(query);

			statement.setInt(1, id);

			ResultSet resultset = statement.executeQuery();

			if (resultset.next()) {

				NiveauDao niveauDao = new NiveauDao();

				int intNiv = Integer.parseInt(resultset.getString("niveau"));

				Niveaux niveau = niveauDao.getNiveau(intNiv);

				return new User(

						resultset.getInt("id_user"), resultset.getString("nom"), resultset.getString("prenom"),
						resultset.getString("sexe"), resultset.getString("login"), resultset.getString("mdpasse"),
						resultset.getString("email"), resultset.getString("role"), niveau);

			}
			;

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return null;

	}

	public List<User> listeUsers() {
		String query = "SELECT * FROM utilisateur";
		List<User> liste = new ArrayList<>();
		try {

			PreparedStatement statement = getConnection().prepareStatement(query);

			ResultSet resultset = statement.executeQuery();

			while (resultset.next()) {

				NiveauDao niveauDao = new NiveauDao();

				int intNiv = Integer.parseInt(resultset.getString("niveau"));

				Niveaux niveau = niveauDao.getNiveau(intNiv);

				User user = new User(

						resultset.getInt("id_user"), resultset.getString("nom"), resultset.getString("prenom"),
						resultset.getString("sexe"), resultset.getString("login"), resultset.getString("mdpasse"),
						resultset.getString("email"), resultset.getString("role"), niveau);

				liste.add(user);
			}
			;
			return liste;

		} catch (SQLException e) {
			System.out.println("Dans Liste user " + e.getMessage());
		}

		return null;

	}

	public void modifier(User user, int id) {
		
		String query="UPDATE utilisateur SET nom=?,prenom=?,sexe=?,email=?,niveau=? WHERE id_user=?";
		try {
			PreparedStatement statement=getConnection().prepareStatement(query);		
			statement.setString(1, user.getNom());
			statement.setString(2, user.getPrenom());
			statement.setString(3, user.getSexe());
			statement.setString(4, user.getEmail());
			statement.setInt   (5, user.getNiveau().getId_niveaux());
			
			statement.setInt(6, id);
			
			statement.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("dans userDao methode modifier "+e.getMessage());
		}
		
		
	}

}
