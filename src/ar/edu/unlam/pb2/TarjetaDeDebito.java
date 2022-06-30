package ar.edu.unlam.pb2;

public class TarjetaDeDebito extends MedioDePago implements Pagadora{

	private Long nUMERO_ESPERADO;
	private String tITULAR_ESPERADO;
	private String fECHA_DE_VENCIMIENTO_ESPERADO;
	private Integer cODIGO_DE_SEGURIDAD_ESPERADO;
	private double saldo;

	public TarjetaDeDebito(Long nUMERO_ESPERADO, String tITULAR_ESPERADO, String fECHA_DE_VENCIMIENTO_ESPERADO,
			Integer cODIGO_DE_SEGURIDAD_ESPERADO) throws NumeroDeTarjetaInvalidoException {
		//this.nUMERO_ESPERADO=nUMERO_ESPERADO;
		setNumeroDeTarjeta(nUMERO_ESPERADO);
		this.tITULAR_ESPERADO=tITULAR_ESPERADO;
		this.fECHA_DE_VENCIMIENTO_ESPERADO=fECHA_DE_VENCIMIENTO_ESPERADO;
		this.cODIGO_DE_SEGURIDAD_ESPERADO=cODIGO_DE_SEGURIDAD_ESPERADO;
		saldo=0.0;
	}

	private void setNumeroDeTarjeta(Long nUMERO_ESPERADO2) throws NumeroDeTarjetaInvalidoException {
		// TODO Auto-generated method stub
		if(nUMERO_ESPERADO2<16) {
			throw new NumeroDeTarjetaInvalidoException();
		}else {
			this.nUMERO_ESPERADO=nUMERO_ESPERADO2;
		}
	}

	@Override
	public Long getNumero() {
		// TODO Auto-generated method stub
		return nUMERO_ESPERADO;
	}

	@Override
	public String getTitular() {
		// TODO Auto-generated method stub
		return tITULAR_ESPERADO;
	}

	@Override
	public Integer getCodigoDeSeguridad() {
		// TODO Auto-generated method stub
		return cODIGO_DE_SEGURIDAD_ESPERADO;
	}

	@Override
	public String getFechaDeVencimiento() {
		// TODO Auto-generated method stub
		return fECHA_DE_VENCIMIENTO_ESPERADO;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	
}
