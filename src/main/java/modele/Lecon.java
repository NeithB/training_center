package modele;

public class Lecon {
	
	private int id_lecon;
	private String titre;
	private User user;
	private Niveaux niveaux;
	
	public Lecon(int id_lecon, String titre,User user,Niveaux niveaux) {
		super();
		this.id_lecon = id_lecon;
		this.titre = titre;
		this.user=user;
		this.niveaux=niveaux;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public int getId_lecon() {
		return id_lecon;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Niveaux getNiveaux() {
		return niveaux;
	}
	public void setNiveaux(Niveaux niveaux) {
		this.niveaux = niveaux;
	}
	@Override
	public String toString() {
		return "Lecon [id_lecon=" + id_lecon + ", titre=" + titre + ", user=" + user + ", niveaux=" + niveaux + "]";
	}
	

}
