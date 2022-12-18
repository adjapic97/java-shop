package model;

import java.util.List;
import java.util.Objects;

public class VlasnikRestorana extends Korisnik {
	private List<Restoran> listaRestorana;

	public VlasnikRestorana() {
		super();
	}

	public VlasnikRestorana(List<Restoran> listaRestorana) {
		super();
		this.listaRestorana = listaRestorana;
	}

	public VlasnikRestorana(String ime, String prezime, String korisnickoIme, String lozinka) {
		super(ime, prezime, korisnickoIme, lozinka);
	}

	public List<Restoran> getListaRestorana() {
		return listaRestorana;
	}

	public void setListaRestorana(List<Restoran> listaRestorana) {
		this.listaRestorana = listaRestorana;
	}

	@Override
	public String toString() {
		return "VlasnikRestorana [listaRestorana=" + listaRestorana + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(listaRestorana);
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
		VlasnikRestorana other = (VlasnikRestorana) obj;
		return Objects.equals(listaRestorana, other.listaRestorana);
	}
	
	
	
 }
