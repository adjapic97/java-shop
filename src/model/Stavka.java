package model;

import java.util.Objects;

public abstract class Stavka implements Prikaz {
	private String naziv;
	private String id;
	private Double kolicina;
	private JedinicaMere jedinicaMere;
	
	public Stavka() {
		
	}
	
	public Stavka(String id,String naziv, Double kolicina, JedinicaMere jedinicaMere) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.kolicina = kolicina;
		this.jedinicaMere = jedinicaMere;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public Double getKolicina() {
		return kolicina;
	}

	public void setKolicina(Double kolicina) {
		this.kolicina = kolicina;
	}

	public JedinicaMere getJedinicaMere() {
		return jedinicaMere;
	}

	public void setJedinicaMere(JedinicaMere jedinicaMere) {
		this.jedinicaMere = jedinicaMere;
	}

	@Override
	public String toString() {
		return "Stavka [naziv=" + naziv + ", kolicina=" + kolicina + ", jedinicaMere=" + jedinicaMere + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, jedinicaMere, kolicina, naziv);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Stavka other = (Stavka) obj;
		return Objects.equals(id, other.id) && jedinicaMere == other.jedinicaMere
				&& Objects.equals(kolicina, other.kolicina) && Objects.equals(naziv, other.naziv);
	}

    
}
