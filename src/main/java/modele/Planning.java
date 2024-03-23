package modele;

public class Planning {
	
	private Calendrier calendrier;
	private Lecon lecon;
	
	public Planning(Calendrier calendrier, Lecon lecon) {
		
		this.calendrier = calendrier;
		this.lecon = lecon;
	}

	public Calendrier getCalendrier() {
		return calendrier;
	}

	public void setCalendrier(Calendrier calendrier) {
		this.calendrier = calendrier;
	}

	public Lecon getLecon() {
		return lecon;
	}

	public void setLecon(Lecon lecon) {
		this.lecon = lecon;
	}

	@Override
	public String toString() {
		return "Planning [calendrier=" + calendrier + ", lecon=" + lecon + "]";
	}


}
