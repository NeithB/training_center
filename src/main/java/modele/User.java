package modele;

public class User {
	

	private int id_user;
	private String nom;
	private String prenom;
	private String sexe;
	private String login;
	private String mdp;
	private String email;
	private String role;
	private Niveaux niveau;
	
	public User(int id_user, String nom, String prenom, String sexe, String login, String mdp,String email, String role,Niveaux niveau) {
		
		this.id_user = id_user;
		this.nom = nom;
		this.prenom = prenom;
		this.sexe = sexe;
		this.login = login;
		this.mdp = mdp;
		this.role = role;
		this.email = email;
		this.niveau=niveau;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getId_user() {
		return id_user;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Niveaux getNiveau() {
		return niveau;
	}

	public void setNiveau(Niveaux niveau) {
		this.niveau = niveau;
	}

	@Override
	public String toString() {
		return "User [id_user=" + id_user + ", nom=" + nom + ", prenom=" + prenom + ", sexe=" + sexe + ", login="
				+ login + ", mdp=" + mdp + ", email=" + email + ", role=" + role + ", niveau=" + niveau + "]";
	}
	
	

}
