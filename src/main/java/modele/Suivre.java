package modele;

public class Suivre {
	private User user;
	private Lecon lecon;
	
	public Suivre(User user, Lecon lecon) {
	
		this.user = user;
		this.lecon = lecon;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Lecon getLecon() {
		return lecon;
	}

	public void setLecon(Lecon lecon) {
		this.lecon = lecon;
	}

	@Override
	public String toString() {
		return "Suivre [user=" + user + ", lecon=" + lecon + "]";
	}

}
