package ar.edu.unlam.pb2;

public class CuentaVirtual extends MedioDePago implements Transferible {

	private String cVU_ESPERADO;
	private String eNTIDAD_ESPERADA;
	private String tITULAR_ESPERADO;

	public CuentaVirtual(String cVU_ESPERADO, String eNTIDAD_ESPERADA, String tITULAR_ESPERADO) throws CVUInvalidoException {
		// TODO Auto-generated constructor stub
		//this.cVU_ESPERADO=cVU_ESPERADO;
		setCvu(cVU_ESPERADO);
		this.eNTIDAD_ESPERADA=eNTIDAD_ESPERADA;
		this.tITULAR_ESPERADO=tITULAR_ESPERADO;
	}

	private void setCvu(String cVU_ESPERADO2) throws CVUInvalidoException {
		// TODO Auto-generated method stub
		if(cVU_ESPERADO2.length()==23) {
			this.cVU_ESPERADO=cVU_ESPERADO2;
		}else {
			throw new CVUInvalidoException();
		}
	}

	@Override
	public String getEntidad() {
		// TODO Auto-generated method stub
		return eNTIDAD_ESPERADA;
	}

	@Override
	public String getTitular() {
		// TODO Auto-generated method stub
		return tITULAR_ESPERADO;
	}

	public String getCvu() {
		// TODO Auto-generated method stub
		return cVU_ESPERADO;
	}

}
