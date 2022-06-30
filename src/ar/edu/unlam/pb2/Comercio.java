package ar.edu.unlam.pb2;

public class Comercio {

	private Long cUIT_ESPERADO;
	private String nOMBRE_ESPERADO;

	public Comercio(Long cUIT_ESPERADO, String nOMBRE_ESPERADO) throws CuitInvalidoException {
		// TODO Auto-generated constructor stub
		//this.cUIT_ESPERADO=cUIT_ESPERADO;
		setCuit(cUIT_ESPERADO);
		this.nOMBRE_ESPERADO=nOMBRE_ESPERADO;
	}

	private void setCuit(Long cUIT_ESPERADO) throws CuitInvalidoException {
		// TODO Auto-generated method stub
		//System.out.println(Long.toString(cUIT_ESPERADO).charAt(0)=='3');
		if(Long.toString(cUIT_ESPERADO).length()==11 &&  Long.toString(cUIT_ESPERADO).charAt(0)=='3' &&  Long.toString(cUIT_ESPERADO).charAt(1)=='0' ) {
			this.cUIT_ESPERADO=cUIT_ESPERADO;
		}else {
			throw new CuitInvalidoException();
		}
	}

	public String getNomNbre() {
		// TODO Auto-generated method stub
		return nOMBRE_ESPERADO;
	}

	public Long getCuit() {
		// TODO Auto-generated method stub
		return cUIT_ESPERADO;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cUIT_ESPERADO == null) ? 0 : cUIT_ESPERADO.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Comercio other = (Comercio) obj;
		if (cUIT_ESPERADO == null) {
			if (other.cUIT_ESPERADO != null)
				return false;
		} else if (!cUIT_ESPERADO.equals(other.cUIT_ESPERADO))
			return false;
		return true;
	}
	
	

}
