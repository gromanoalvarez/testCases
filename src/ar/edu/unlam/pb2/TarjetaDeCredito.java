package ar.edu.unlam.pb2;

public class TarjetaDeCredito extends MedioDePago implements Pagadora {
	
	private Long nUMERO_ESPERADO;
	private String tITULAR_ESPERADO;
	private String fECHA_DE_VENCIMIENTO_ESPERADO;
	private Integer cODIGO_DE_SEGURIDAD_ESPERADO;
	private double LIMITE_COMPRA_EN_PESOS;
	private double LIMITE_DE_COMPRA_EN_DOLARES;

	public TarjetaDeCredito(Long nUMERO_ESPERADO, String tITULAR_ESPERADO, String fECHA_DE_VENCIMIENTO_ESPERADO,
			Integer cODIGO_DE_SEGURIDAD_ESPERADO, double LIMITE_COMPRA_EN_PESOS, double LIMITE_DE_COMPRA_EN_DOLARES) throws NumeroDeTarjetaInvalidoException {
		//this.nUMERO_ESPERADO=nUMERO_ESPERADO;
		setNumeroDeTarjeta(nUMERO_ESPERADO);
		this.tITULAR_ESPERADO=tITULAR_ESPERADO;
		this.fECHA_DE_VENCIMIENTO_ESPERADO=fECHA_DE_VENCIMIENTO_ESPERADO;
		this.cODIGO_DE_SEGURIDAD_ESPERADO=cODIGO_DE_SEGURIDAD_ESPERADO;
		this.LIMITE_COMPRA_EN_PESOS=LIMITE_COMPRA_EN_PESOS;
		this.LIMITE_DE_COMPRA_EN_DOLARES=LIMITE_DE_COMPRA_EN_DOLARES;
		
	}
	
	private void setNumeroDeTarjeta(Long nUMERO_ESPERADO2) throws NumeroDeTarjetaInvalidoException {
		// TODO Auto-generated method stub
		if(nUMERO_ESPERADO2<16) {
			throw new NumeroDeTarjetaInvalidoException();
		}else {
			this.nUMERO_ESPERADO=nUMERO_ESPERADO2;
		}
	}

	public TarjetaDeCredito(Long nUMERO_ESPERADO, String tITULAR_ESPERADO, String fECHA_DE_VENCIMIENTO_ESPERADO,
			Integer cODIGO_DE_SEGURIDAD_ESPERADO) {
		// TODO Auto-generated constructor stub
		this.nUMERO_ESPERADO=nUMERO_ESPERADO;
		this.tITULAR_ESPERADO=tITULAR_ESPERADO;
		this.fECHA_DE_VENCIMIENTO_ESPERADO=fECHA_DE_VENCIMIENTO_ESPERADO;
		this.cODIGO_DE_SEGURIDAD_ESPERADO=cODIGO_DE_SEGURIDAD_ESPERADO;
		this.LIMITE_COMPRA_EN_PESOS=0.0;
		this.LIMITE_DE_COMPRA_EN_DOLARES=0.0;
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

	public Object getLimiteDeCompraEnPesos() {
		// TODO Auto-generated method stub
		return LIMITE_COMPRA_EN_PESOS;
	}

	public Object getLimiteDeCompraEnDolares() {
		// TODO Auto-generated method stub
		return LIMITE_DE_COMPRA_EN_DOLARES;
	}

}
