package model;

import java.util.Objects;

public class Kupac extends Korisnik {
	private double raspolozivoNovcanoStanje;
	private String kucnaAdresa;
	private Korpa korpa;
	private String kolekcijaPorudzbina;
	public Kupac() {
		super();
	}

	public Kupac(String ime, String prezime, String korisnickoIme, String lozinka) {
		super(ime, prezime, korisnickoIme, lozinka);
	}

	public Kupac(double raspolozivoNovcanoStanje, String kucnaAdresa, Korpa korpa, String kolekcijaPorudzbina) {
		super();
		this.raspolozivoNovcanoStanje = raspolozivoNovcanoStanje;
		this.kucnaAdresa = kucnaAdresa;
		this.korpa = korpa;
		this.kolekcijaPorudzbina = kolekcijaPorudzbina;
	}
	public double getRaspolozivoNovcanoStanje() {
		return raspolozivoNovcanoStanje;
	}
	public void setRaspolozivoNovcanoStanje(double raspolozivoNovcanoStanje) {
		this.raspolozivoNovcanoStanje = raspolozivoNovcanoStanje;
	}
	public String getKucnaAdresa() {
		return kucnaAdresa;
	}
	public void setKucnaAdresa(String kucnaAdresa) {
		this.kucnaAdresa = kucnaAdresa;
	}
	public Korpa getKorpa() {
		return korpa;
	}
	public void setKorpa(Korpa korpa) {
		this.korpa = korpa;
	}
	public String getKolekcijaPorudzbina() {
		return kolekcijaPorudzbina;
	}
	public void setKolekcijaPorudzbina(String kolekcijaPorudzbina) {
		this.kolekcijaPorudzbina = kolekcijaPorudzbina;
	}
	@Override
	public String toString() {
		return "Kupac [raspolozivoNovcanoStanje=" + raspolozivoNovcanoStanje + ", kucnaAdresa=" + kucnaAdresa
				+ ", korpa=" + korpa + ", kolekcijaPorudzbina=" + kolekcijaPorudzbina + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(kolekcijaPorudzbina, korpa, kucnaAdresa, raspolozivoNovcanoStanje);
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Kupac other = (Kupac) obj;
		return Objects.equals(kolekcijaPorudzbina, other.kolekcijaPorudzbina) && Objects.equals(korpa, other.korpa)
				&& Objects.equals(kucnaAdresa, other.kucnaAdresa)
				&& Double.doubleToLongBits(raspolozivoNovcanoStanje) == Double
						.doubleToLongBits(other.raspolozivoNovcanoStanje);
	}
	
	
}
