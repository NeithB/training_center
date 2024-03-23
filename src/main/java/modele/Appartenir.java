package modele;

public class Appartenir {
	
	private User user;
	private Niveaux niveau;
	
	public Appartenir(User user, Niveaux niveau) {
		
		this.user = user;
		this.niveau = niveau;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Niveaux getNiveau() {
		return niveau;
	}

	public void setNiveau(Niveaux niveau) {
		this.niveau = niveau;
	}

	@Override
	public String toString() {
		return "Appartenir [user=" + user + ", niveau=" + niveau + "]";
	}
	

}
