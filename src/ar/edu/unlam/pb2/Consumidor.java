package ar.edu.unlam.pb2;

import java.util.HashSet;

public class Consumidor {

	private Integer dNI_ESPERADO;
	private String nOMBRE_ESPERADO;
	private HashSet<MedioDePago> mediosDePagoDisponibles;

	public Consumidor(Integer dNI_ESPERADO, String nOMBRE_ESPERADO) {
		// TODO Auto-generated constructor stub
		this.dNI_ESPERADO=dNI_ESPERADO;
		this.nOMBRE_ESPERADO=nOMBRE_ESPERADO;
		mediosDePagoDisponibles= new  HashSet<MedioDePago>();
	}

	public String getNomNbre() {
		// TODO Auto-generated method stub
		return nOMBRE_ESPERADO;
	}

	public Integer getDni() {
		// TODO Auto-generated method stub
		return dNI_ESPERADO;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dNI_ESPERADO == null) ? 0 : dNI_ESPERADO.hashCode());
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
		Consumidor other = (Consumidor) obj;
		if (dNI_ESPERADO == null) {
			if (other.dNI_ESPERADO != null)
				return false;
		} else if (!dNI_ESPERADO.equals(other.dNI_ESPERADO))
			return false;
		return true;
	}

	public void agregarMedioDePago(MedioDePago medio) {
		// TODO Auto-generated method stub
		mediosDePagoDisponibles.add(medio);
	}

	public Integer getCantidadDeMediosDePago() {
		// TODO Auto-generated method stub
		return mediosDePagoDisponibles.size();
	}

	public MedioDePago getMedioPagador(long nroDeCompra) {
		// TODO Auto-generated method stub
		return buscarMedioDePago(nroDeCompra);
	}

	private MedioDePago buscarMedioDePago(long id) {
		// TODO Auto-generated method stub
		for(MedioDePago mp: mediosDePagoDisponibles) {
			if(mp.getId().equals(id)) {
				return mp;
			}
		}
		
		return null;
	}

	
}
