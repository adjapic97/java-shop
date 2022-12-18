package model;

import java.util.List;
import java.util.Objects;

public class Porudzbina implements Prikaz{
	private Kupac kupac;
	private String adresaIsporuke;
	private TipDostave tipDostave;
	private List<StavkaUKorpi> poruceneStavke;
	
	
	
	public Porudzbina() {
		super();
	}
	
	
	public Porudzbina(Kupac kupac, String adresaIsporuke, TipDostave tipDostave, List<StavkaUKorpi> poruceneStavke) {
		super();
		this.kupac = kupac;
		this.adresaIsporuke = adresaIsporuke;
		this.tipDostave = tipDostave;
		this.poruceneStavke = poruceneStavke;
	}

	
	public Kupac getKupac() {
		return kupac;
	}


	public void setKupac(Kupac kupac) {
		this.kupac = kupac;
	}


	public String getAdresaIsporuke() {
		return adresaIsporuke;
	}


	public void setAdresaIsporuke(String adresaIsporuke) {
		this.adresaIsporuke = adresaIsporuke;
	}


	public TipDostave getTipDostave() {
		return tipDostave;
	}


	public void setTipDostave(TipDostave tipDostave) {
		this.tipDostave = tipDostave;
	}


	public List<StavkaUKorpi> getPoruceneStavke() {
		return poruceneStavke;
	}


	public void setPoruceneStavke(List<StavkaUKorpi> poruceneStavke) {
		this.poruceneStavke = poruceneStavke;
	}


	@Override
	public void jednostavanPrikaz() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void detaljanPrikaz() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public String toString() {
		return "Porudzbina [kupac=" + kupac + ", adresaIsporuke=" + adresaIsporuke + ", tipDostave=" + tipDostave
				+ ", poruceneStavke=" + poruceneStavke + "]";
	}


	@Override
	public int hashCode() {
		return Objects.hash(adresaIsporuke, kupac, poruceneStavke, tipDostave);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Porudzbina other = (Porudzbina) obj;
		return Objects.equals(adresaIsporuke, other.adresaIsporuke) && Objects.equals(kupac, other.kupac)
				&& Objects.equals(poruceneStavke, other.poruceneStavke) && tipDostave == other.tipDostave;
	} 
	
}
