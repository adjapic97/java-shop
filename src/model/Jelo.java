package model;

import java.util.Objects;

public class Jelo extends Stavka {
	private TipJela tipJela;

	public Jelo() {
		super();
	}

	public Jelo(TipJela tipJela) {
		super();
		this.tipJela = tipJela;
	}

	public TipJela getTipJela() {
		return tipJela;
	}

	public void setTipJela(TipJela tipJela) {
		this.tipJela = tipJela;
	}

	@Override
	public String toString() {
		return "Jelo [tipJela=" + tipJela + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(tipJela);
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
		Jelo other = (Jelo) obj;
		return tipJela == other.tipJela;
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
