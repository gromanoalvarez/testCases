package ar.edu.unlam.pb2;

public class CuentaBancaria extends MedioDePago implements Transferible {

	private String cBU_ESPERADO;
	private String eNTIDAD_ESPERADA;
	private String tITULAR_ESPERADO;
	private Double saldo;

	public CuentaBancaria(String cBU_ESPERADO, String eNTIDAD_ESPERADA, String tITULAR_ESPERADO) throws CBUInvalidoException {
		//this.cBU_ESPERADO=cBU_ESPERADO;
		setCbu(cBU_ESPERADO);
		this.eNTIDAD_ESPERADA=eNTIDAD_ESPERADA;
		this.tITULAR_ESPERADO=tITULAR_ESPERADO;
		saldo=0.0;
	}

	private void setCbu(String cBU_ESPERADO2) throws CBUInvalidoException {
		// TODO Auto-generated method stub
		Integer largoEsperado=20;
		if(cBU_ESPERADO2.length()==largoEsperado) {
			this.cBU_ESPERADO=cBU_ESPERADO2;
		}else {
			throw new CBUInvalidoException();
		}
		
	}

	public String getCbu() {
		// TODO Auto-generated method stub
		return cBU_ESPERADO;
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



}
