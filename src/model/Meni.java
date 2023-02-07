package model;

import java.util.List;
import java.util.Objects;

public class Meni implements Prikaz{
	
	private String id;
	private List<Stavka> listaStavki;
	
	public Meni() {
		
	}

	public Meni(List<Stavka> listaStavki) {
		super();
		this.listaStavki = listaStavki;
	}

	public List<Stavka> getListaStavki() {
		return listaStavki;
	}

	public void setListaStavki(List<Stavka> listaStavki) {
		this.listaStavki = listaStavki;
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	
	@Override
	public int hashCode() {
		return Objects.hash(id, listaStavki);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Meni other = (Meni) obj;
		return Objects.equals(id, other.id) && Objects.equals(listaStavki, other.listaStavki);
	}

	
	@Override
	public String toString() {
		return "Meni [id=" + id + ", listaStavki=" + listaStavki + "]";
	}

	@Override
	public void jednostavanPrikaz() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void detaljanPrikaz() {
		// TODO Auto-generated method stub
		
	}
	
	
}
