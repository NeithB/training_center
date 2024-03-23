package modele;

import java.sql.Time;
import java.time.LocalTime;
import java.util.Date;

public class Calendrier {
	
	private int id_calendar;
	private Date date_calendar;
	private String heure_calendar;
	private User user;
	
	public Calendrier(int id_calendar, Date date_calendar, String heure_calendar) {
		
		this.id_calendar = id_calendar;
		this.date_calendar = date_calendar;
		this.heure_calendar = heure_calendar;
	
	}


	public int getId_calendar() {
		return id_calendar;
	}


	public Date getDate_calendar() {
		return date_calendar;
	}

	public void setDate_calendar(Date date_calendar) {
		this.date_calendar = date_calendar;
	}

	public String getHeure_calendar() {
		return heure_calendar;
	}

	public void setHeure_calendar(String heure_calendar) {
		this.heure_calendar = heure_calendar;
	}



	@Override
	public String toString() {
		return "Calendrier [id_calendar=" + id_calendar + ", date_calendar=" + date_calendar + ", heure_calendar="
				+ heure_calendar + "]";
	}
	

}
