package model;

import java.util.Objects;

public abstract class Korisnik {
	private String ime;
	private String prezime;
	private String korisnickoIme;
	private String lozinka;
	
	public Korisnik() {
	}

	public Korisnik(String ime, String prezime, String korisnickoIme, String lozinka) {
		this.ime = ime;
		this.prezime = prezime;
		this.korisnickoIme = korisnickoIme;
		this.lozinka = lozinka;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getKorisnickoIme() {
		return korisnickoIme;
	}

	public void setKorisnickoIme(String korisnickoIme) {
		this.korisnickoIme = korisnickoIme;
	}

	public String getLozinka() {
		return lozinka;
	}

	public void setLozinka(String lozinka) {
		this.lozinka = lozinka;
	}

	@Override
	public String toString() {
		return "Korisnik [ime=" + ime + ", prezime=" + prezime + ", korisnickoIme=" + korisnickoIme + ", lozinka="
				+ lozinka + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(ime, korisnickoIme, lozinka, prezime);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Korisnik other = (Korisnik) obj;
		return Objects.equals(ime, other.ime) && Objects.equals(korisnickoIme, other.korisnickoIme)
				&& Objects.equals(lozinka, other.lozinka) && Objects.equals(prezime, other.prezime);
	}
	
	
}
