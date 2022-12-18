package model;

import java.util.Objects;

public class Restoran {
	private String naziv;
	private Double besplatnaDostava;
	private Meni meni;
	private VlasnikRestorana vlasnik;
	private String id;
	
	public Restoran() {
		
	}
	
	public Restoran(String id, String naziv, Double besplatnaDostava, Meni meni, VlasnikRestorana vlasnik) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.besplatnaDostava = besplatnaDostava;
		this.meni = meni;
		this.vlasnik = vlasnik;
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
	public Double getBesplatnaDostava() {
		return besplatnaDostava;
	}
	public void setBesplatnaDostava(Double besplatnaDostava) {
		this.besplatnaDostava = besplatnaDostava;
	}
	public Meni getMeni() {
		return meni;
	}
	public void setMeni(Meni meni) {
		this.meni = meni;
	}
	public VlasnikRestorana getVlasnik() {
		return vlasnik;
	}
	public void setVlasnik(VlasnikRestorana vlasnik) {
		this.vlasnik = vlasnik;
	}
	@Override
	public String toString() {
		return "Restoran [id =" + id + "naziv=" + naziv + ", besplatnaDostava=" + besplatnaDostava + ", meni=" + meni + ", vlasnik="
				+ vlasnik + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(besplatnaDostava, id, meni, naziv, vlasnik);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Restoran other = (Restoran) obj;
		return Objects.equals(besplatnaDostava, other.besplatnaDostava) && Objects.equals(id, other.id)
				&& Objects.equals(meni, other.meni) && Objects.equals(naziv, other.naziv)
				&& Objects.equals(vlasnik, other.vlasnik);
	}	
}
