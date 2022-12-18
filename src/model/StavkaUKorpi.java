package model;

import java.util.Objects;

public class StavkaUKorpi {
	private Korpa korpa;
	private Stavka stavka;
	private Double kolicina;
	private Double cena;
	private JedinicaMere jedinicaMere;
	public StavkaUKorpi() {
		super();
	}
	public StavkaUKorpi(Korpa korpa, Stavka stavka, Double kolicina, Double cena, JedinicaMere jedinicaMere) {
		super();
		this.korpa = korpa;
		this.stavka = stavka;
		this.kolicina = kolicina;
		this.cena = cena;
		this.jedinicaMere = jedinicaMere;
	}
	public Korpa getKorpa() {
		return korpa;
	}
	public void setKorpa(Korpa korpa) {
		this.korpa = korpa;
	}
	public Stavka getStavka() {
		return stavka;
	}
	public void setStavka(Stavka stavka) {
		this.stavka = stavka;
	}
	public Double getKolicina() {
		return kolicina;
	}
	public void setKolicina(Double kolicina) {
		this.kolicina = kolicina;
	}
	public Double getCena() {
		return cena;
	}
	public void setCena(Double cena) {
		this.cena = cena;
	}
	public JedinicaMere getJedinicaMere() {
		return jedinicaMere;
	}
	public void setJedinicaMere(JedinicaMere jedinicaMere) {
		this.jedinicaMere = jedinicaMere;
	}
	@Override
	public String toString() {
		return "StavkaUKorpi [korpa=" + korpa + ", stavka=" + stavka + ", kolicina=" + kolicina + ", cena=" + cena
				+ ", jedinicaMere=" + jedinicaMere + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(cena, jedinicaMere, kolicina, korpa, stavka);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StavkaUKorpi other = (StavkaUKorpi) obj;
		return Objects.equals(cena, other.cena) && jedinicaMere == other.jedinicaMere
				&& Objects.equals(kolicina, other.kolicina) && Objects.equals(korpa, other.korpa)
				&& Objects.equals(stavka, other.stavka);
	}
	
	
}
