package ar.edu.unlam.pb2;

import java.util.HashMap;
import java.util.HashSet;

public class Billetera {

	private String nombre;
	private HashSet<Comercio> comerciosIncluidos;
	private HashSet<Consumidor> consumidoresIncluidos;
	private HashMap<Compra, MedioDePago> comprasRealizadas;

	public Billetera(String nombre) {
		// TODO Auto-generated constructor stub
		this.nombre=nombre;
		comerciosIncluidos= new HashSet<Comercio>();
		consumidoresIncluidos= new HashSet<Consumidor>();
		comprasRealizadas = new HashMap<Compra, MedioDePago>();
	}

	public void agregarComercio(Comercio comercio) {
		// TODO Auto-generated method stub
		comerciosIncluidos.add(comercio);
	}

	public Integer getCantidadDeComercios() {
		// TODO Auto-generated method stub
		return comerciosIncluidos.size();
	}

	public void agregarConsumidor(Consumidor consumidor) {
		// TODO Auto-generated method stub
		consumidoresIncluidos.add(consumidor);
	}

	public Integer getCantidadDeConsumidores() {
		// TODO Auto-generated method stub
		return consumidoresIncluidos.size();
	}

	public void agregarMedioDePago(Integer dniConsumidor, MedioDePago medio) throws NoCoincideTitularException {
		// TODO Auto-generated method stub
		Consumidor deseado = getConsumidor(dniConsumidor);
		deseado.agregarMedioDePago(medio);
	}

	public Consumidor getConsumidor(Integer dniConsumidor) throws NoCoincideTitularException {
		// TODO Auto-generated method stub
		for(Consumidor c: consumidoresIncluidos) {
			if(c.getDni().equals(dniConsumidor)) {
				return c;
			}
		}
		throw new NoCoincideTitularException();
	}

	public Integer getCantidadDeMediosDePago(Integer dniConsumidor) throws NoCoincideTitularException {
		// TODO Auto-generated method stub
		Consumidor deseado = getConsumidor(dniConsumidor);
		return deseado.getCantidadDeMediosDePago();
	}

	public Compra generarCodigoQR(Long cuitDeComercio, double MONTO) {
		// TODO Auto-generated method stub

		Compra nueva = new Compra( cuitDeComercio,  MONTO);
		return nueva;
	}

	public Boolean pagar(Compra codigoQR, MedioDePago medioPagador) {
		// TODO Auto-generated method stub
		Integer antes = comprasRealizadas.size();
		comprasRealizadas.put(codigoQR,medioPagador);
		Integer despues = comprasRealizadas.size();
		if(despues>antes)return true;
		else {
			return null;
		}
	}
	
	/*
	SaldoInsuficienteException: Cuando se intenta realizar una compra con tarjeta de débito o transferencia a una cuenta, pero no se dispone el saldo necesario para completar la transacción.
	ExcedeLimiteDeCompraException: Cuando se desea realizar una compra con tarjeta de crédito, pero se excede el límite disponible en esa tarjeta.

	*/
	public Boolean transferir(MedioDePago cuentaOrigen, MedioDePago cuentaDestino) {
		// TODO Auto-generated method stub
		
		return true;
	}
	
	

}
