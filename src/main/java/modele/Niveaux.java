package modele;

public class Niveaux {
	private int id_niveaux ;
	private String libelle;
	private Calendrier calendrier;
	
	public Niveaux(int id_niveaux, String libelle,Calendrier calendrier) {
	
		this.id_niveaux = id_niveaux;
		this.libelle = libelle;
		
		this.calendrier=calendrier;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public int getId_niveaux() {
		return id_niveaux;
	}

	public Calendrier getCalendrier() {
		return calendrier;
	}

	public void setCalendrier(Calendrier calendrier) {
		this.calendrier = calendrier;
	}

	@Override
	public String toString() {
		return "Niveaux [id_niveaux=" + id_niveaux + ", libelle=" + libelle + ", user=" + ", calendrier="
				+ calendrier + "]";
	}

	
	

}
