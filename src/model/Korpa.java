package model;

import java.util.List;
import java.util.Objects;

public class Korpa implements Prikaz{
	private Kupac kupac;
	private List<StavkaUKorpi> stavkeUKorpi;
	public Korpa() {
		super();
	}
	
	public Korpa(Kupac kupac, List<StavkaUKorpi> stavkeUKorpi) {
		super();
		this.kupac = kupac;
		this.stavkeUKorpi = stavkeUKorpi;
	}

	public Kupac getKupac() {
		return kupac;
	}

	public void setKupac(Kupac kupac) {
		this.kupac = kupac;
	}

	public List<StavkaUKorpi> getStavkeUKorpi() {
		return stavkeUKorpi;
	}

	public void setStavkeUKorpi(List<StavkaUKorpi> stavkeUKorpi) {
		this.stavkeUKorpi = stavkeUKorpi;
	}

	@Override
	public int hashCode() {
		return Objects.hash(kupac, stavkeUKorpi);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Korpa other = (Korpa) obj;
		return Objects.equals(kupac, other.kupac) && Objects.equals(stavkeUKorpi, other.stavkeUKorpi);
	}

	@Override
	public String toString() {
		return "Korpa [kupac=" + kupac + ", stavkeUKorpi=" + stavkeUKorpi + "]";
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
