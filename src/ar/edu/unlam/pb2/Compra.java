package ar.edu.unlam.pb2;

public class Compra {

	private Long nroDeCompra;
	private double mONTO;
	private Boolean paga;

	public Compra(Long nroDeCompra, double mONTO) {
		// TODO Auto-generated constructor stub
		this.nroDeCompra=nroDeCompra;
		this.mONTO=mONTO;
		paga=false;
	}

	public Long getNroDeCompra() {
		return nroDeCompra;
	}

	public void setNroDeCompra(Long nroDeCompra) {
		this.nroDeCompra = nroDeCompra;
	}

	public double getmONTO() {
		return mONTO;
	}

	public void setmONTO(double mONTO) {
		this.mONTO = mONTO;
	}

	public Boolean getPaga() {
		return paga;
	}

	public void setPaga(Boolean paga) {
		this.paga = paga;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nroDeCompra == null) ? 0 : nroDeCompra.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		Compra other = (Compra) obj;
		if (nroDeCompra == null) {
			if (other.nroDeCompra != null)
				return false;
		} else if (!nroDeCompra.equals(other.nroDeCompra))
			return false;
		return true;
	}
	
	

}
