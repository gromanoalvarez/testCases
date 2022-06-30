package ar.edu.unlam.pb2;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestCases {

	@Test
	public void queSePuedaCrearUnaTarjetaDeDebito() throws NumeroDeTarjetaInvalidoException, CuitInvalidoException{
		// Preparaci�n 
		final Long NUMERO_ESPERADO = 5446789813221201L;
		final String TITULAR_ESPERADO = "CAMILA CIENFUEGOS";
		final Integer CODIGO_DE_SEGURIDAD_ESPERADO = 123;
		final String FECHA_DE_VENCIMIENTO_ESPERADO = "25/05/2022";
		final double SALDO_ESPERADO = 10000.0;
		
		// Ejecuci�n
		try {
		Pagadora tarjetaDeDebito = new TarjetaDeDebito(NUMERO_ESPERADO, TITULAR_ESPERADO, FECHA_DE_VENCIMIENTO_ESPERADO, CODIGO_DE_SEGURIDAD_ESPERADO);

		//Se casteo la tarjeta de Debito para adquerir el metodo de la especializacion setSaldo que es propio de la clase hija
		((TarjetaDeDebito)tarjetaDeDebito).setSaldo(10000.0);
		
		// Verificaci�n
		assertEquals(NUMERO_ESPERADO, tarjetaDeDebito.getNumero());
		assertEquals(TITULAR_ESPERADO, tarjetaDeDebito.getTitular());
		assertEquals(CODIGO_DE_SEGURIDAD_ESPERADO, tarjetaDeDebito.getCodigoDeSeguridad());
		assertEquals(FECHA_DE_VENCIMIENTO_ESPERADO, tarjetaDeDebito.getFechaDeVencimiento());
		assertEquals(SALDO_ESPERADO, ((TarjetaDeDebito)tarjetaDeDebito).getSaldo(), 0.01); //se agrego el tercer parametro para poder utilizar el assertEquals
		}catch(NumeroDeTarjetaInvalidoException nti) {
			System.err.println("numero de tarjeta invalido");
		}
	}
	
	@Test
	public void queSePuedaCrearUnaTarjetaDeCredito() throws NumeroDeTarjetaInvalidoException{
		// Preparaci�n 
		final Long NUMERO_ESPERADO = 4246789813221201L;
		final String TITULAR_ESPERADO = "SOFIA BARRIENTOS";
		final Integer CODIGO_DE_SEGURIDAD_ESPERADO = 567;
		final String FECHA_DE_VENCIMIENTO_ESPERADO = "25/05/2025";
		final double LIMITE_COMPRA_EN_PESOS = 100000.0;
		final double LIMITE_DE_COMPRA_EN_DOLARES = 1000.0;
		
		// Ejecuci�n
		try {
		Pagadora tarjetaDeCredito = new TarjetaDeCredito(NUMERO_ESPERADO, TITULAR_ESPERADO, FECHA_DE_VENCIMIENTO_ESPERADO, CODIGO_DE_SEGURIDAD_ESPERADO, LIMITE_COMPRA_EN_PESOS, LIMITE_DE_COMPRA_EN_DOLARES);

		// Verificaci�n
		assertEquals(NUMERO_ESPERADO, tarjetaDeCredito.getNumero());
		assertEquals(TITULAR_ESPERADO, tarjetaDeCredito.getTitular());
		assertEquals(CODIGO_DE_SEGURIDAD_ESPERADO, tarjetaDeCredito.getCodigoDeSeguridad());
		assertEquals(FECHA_DE_VENCIMIENTO_ESPERADO, tarjetaDeCredito.getFechaDeVencimiento());
		assertEquals(LIMITE_COMPRA_EN_PESOS, ((TarjetaDeCredito)tarjetaDeCredito).getLimiteDeCompraEnPesos());
		assertEquals(LIMITE_DE_COMPRA_EN_DOLARES, ((TarjetaDeCredito)tarjetaDeCredito).getLimiteDeCompraEnDolares());
		}catch(NumeroDeTarjetaInvalidoException nti) {
			System.err.println("numero de tarjeta invalido");
		}
	}
	
	@Test
	public void queSePuedaCrearUnaCuentaBancaria() throws CBUInvalidoException{
		// Preparaci�n 
		final String CBU_ESPERADO = "01702046600000087865";
		final String ENTIDAD_ESPERADA = "Santander";
		final String TITULAR_ESPERADO = "Vicente De La Pradera";
		
		// Ejeruci�n
		try {
		Transferible cuentaBancaria = new CuentaBancaria(CBU_ESPERADO, ENTIDAD_ESPERADA, TITULAR_ESPERADO);
		
		// Verificaci�n
		assertEquals(CBU_ESPERADO, ((CuentaBancaria)cuentaBancaria).getCbu());
		assertEquals(ENTIDAD_ESPERADA, cuentaBancaria.getEntidad());
		assertEquals(TITULAR_ESPERADO, cuentaBancaria.getTitular());
		}catch(CBUInvalidoException cbuInvalid) {
			System.err.println("cbu invalido");
		}
	}
	
	@Test
	public void queSePuedaCrearUnaCuentaVirtual() throws CVUInvalidoException{
		// Preparaci�n 
		final String CVU_ESPERADO = "46467898132212011234552";
		final String ENTIDAD_ESPERADA = "Mercado Pago";
		final String TITULAR_ESPERADO = "Leticia Bridgeton";
		
		try {
		// Ejecuci�n
		Transferible cuentaVirtual = new CuentaVirtual(CVU_ESPERADO, ENTIDAD_ESPERADA, TITULAR_ESPERADO);

		// Verificaci�n
		assertEquals(CVU_ESPERADO, ((CuentaVirtual)cuentaVirtual).getCvu());
		assertEquals(ENTIDAD_ESPERADA, cuentaVirtual.getEntidad());
		assertEquals(TITULAR_ESPERADO, cuentaVirtual.getTitular());
		}catch(CVUInvalidoException cvuInvalid) {
			System.err.println("cvu invalido");
		}
	}
	
	@Test
	public void queSePuedaCrearUnComercio() throws CuitInvalidoException{
		// Preparaci�n 
		final String NOMBRE_ESPERADO = "El almacen de la esquina";
		final Long CUIT_ESPERADO = 30215654124L;
		
		// Ejecuci�n
		try {
		Comercio elAlmacen = new Comercio(CUIT_ESPERADO, NOMBRE_ESPERADO);
		
		// Verificaci�n
		assertEquals(NOMBRE_ESPERADO, elAlmacen.getNomNbre());
		assertEquals(CUIT_ESPERADO, elAlmacen.getCuit());
		}catch(CuitInvalidoException cuitInvalid) {
			System.err.println("Cuit invalido");
		}
	}
	
	@Test
	public void queSePuedaCrearUnConsumidor() { 
		// Preparaci�n 
		final String NOMBRE_ESPERADO = "Erika Romeo";
		final Integer DNI_ESPERADO = 33458712;
		
		// Ejecuci�n
		Consumidor nuevo = new Consumidor(DNI_ESPERADO, NOMBRE_ESPERADO);
		
		// Verificaci�n
		assertEquals(NOMBRE_ESPERADO, nuevo.getNomNbre());
		assertEquals(DNI_ESPERADO, nuevo.getDni());
	}
	
	@Test
	public void queSePuedanAgregarComerciosALaBilletera() throws CuitInvalidoException{
		// Preparaci�n 
		final Integer CANTIDAD_DE_COMERCIOS_ESPERADOS = 2;
		
		// Ejecuci�n
		Billetera mataGalan = new Billetera("Ank");
		try {
		mataGalan.agregarComercio(new Comercio(30456213545L, "Supermercado"));
		mataGalan.agregarComercio(new Comercio(30215654124L, "Panader�a"));
		mataGalan.agregarComercio(new Comercio(30215654124L, "Panader�a"));
		}catch(CuitInvalidoException cuitInvalid) {
			System.err.println("Cuit invalido");
		}
		// Verificaci�n
		assertEquals(CANTIDAD_DE_COMERCIOS_ESPERADOS, mataGalan.getCantidadDeComercios());
	}
	
	@Test
	public void queSePuedanAgregarConsumidoresALaBilletera() {
		// Preparaci�n 
		final Integer CANTIDAD_DE_CONSUMIDORES_ESPERADOS = 2;
		
		// Ejecuci�n
		Billetera mataGalan = new Billetera("Bna+");
		
		mataGalan.agregarConsumidor(new Consumidor(27541231, "Luis Gomez"));
		mataGalan.agregarConsumidor(new Consumidor(27541231, "Luis Gomez"));
		mataGalan.agregarConsumidor(new Consumidor(36541231, "Sofia Molina"));
		
		// Verificaci�n
		assertEquals(CANTIDAD_DE_CONSUMIDORES_ESPERADOS, mataGalan.getCantidadDeConsumidores());
	}
	
	@Test
	public void queSePuedanAgregarDistintosMediosDePagoALaBilleteraDeUnConsumidor() throws NumeroDeTarjetaInvalidoException, CBUInvalidoException, CVUInvalidoException, NoCoincideTitularException{
		// Preparaci�n 
		final Integer CANTIDAD_DE_MEDIOS_EN_LA_BILLETERA_ESPERADOS = 4;
		
		// Ejecuci�n
		try {
		Billetera mataGalan = new Billetera("MercadoPago");
		mataGalan.agregarConsumidor(new Consumidor(27541231, "Luis Gomez"));
		
		mataGalan.agregarMedioDePago((Integer)27541231, new TarjetaDeDebito(48332562153254623L, "Luis Gomez", "10/10/2026", 265));
		mataGalan.agregarMedioDePago((Integer)27541231, new TarjetaDeDebito(48332562153254623L, "Luis Gomez", "10/10/2026", 312));
		mataGalan.agregarMedioDePago((Integer)27541231, new TarjetaDeCredito(5423542385612354L, "Luis Gomez", "10/10/2026", 153));
		mataGalan.agregarMedioDePago((Integer)27541231, new CuentaBancaria("01702046600000087865", "Naci�n", "Luis Gomez"));
		mataGalan.agregarMedioDePago((Integer)27541231, new CuentaVirtual("0000003100036521571806", "Mercado Pago", "Luis Gomez"));

		// Verificaci�n
		assertEquals(CANTIDAD_DE_MEDIOS_EN_LA_BILLETERA_ESPERADOS, mataGalan.getCantidadDeMediosDePago(27541231));
		}catch(NumeroDeTarjetaInvalidoException cuitInvalid) {
			System.err.println("Numero tarjeta invalido");
		}
		catch(CBUInvalidoException cuitInvalid) {
			System.err.println("cbu  invalido");
		}
		catch(CVUInvalidoException cuitInvalid) {
			System.err.println("cvu  invalido");
		}
		catch(NoCoincideTitularException cuitInvalid) {
			System.err.println("No coincide el titular");
		}
	}
	
	@Test
	public void queSePuedaPagarConUnaTarjetaDeCredito() throws NumeroDeTarjetaInvalidoException, CBUInvalidoException, CVUInvalidoException, ExcedeLimiteDeCompraException, NoCoincideTitularException, CuitInvalidoException{
		// Preparaci�n 
		Billetera mataGalan = new Billetera("Ank");
		mataGalan.agregarConsumidor(new Consumidor(27541231, "Luis Gomez"));
		mataGalan.agregarMedioDePago(27541231, new TarjetaDeCredito(48332562153254623L, "Luis Gomez", "10/10/2026", 265, 100000.0, 1000.0));
		mataGalan.agregarComercio(new Comercio(30456213545L, "Panader�a"));	
		// Ejecuci�n	
		Compra codigoQR = mataGalan.generarCodigoQR(30456213545L, 1000.0);
		Boolean resultado = mataGalan.pagar(codigoQR, mataGalan.getConsumidor(27541231).getMedioPagador(48332562153254623L));
		
		// Verificaci�n
		assertTrue(resultado);
	}
	
	@Test
	public void queSePuedaTransferirDeUnaCuentaAOtra() throws NumeroDeTarjetaInvalidoException, CBUInvalidoException, CVUInvalidoException, SaldoInsuficienteException, NoCoincideTitularException{
		// Preparaci�n 
		Billetera mataGalan = new Billetera("Ual�");
		Transferible cuentaOrigen = new CuentaBancaria("01702046600000087865", "Naci�n", "Luis Gomez");
		Consumidor consumidorOrigen = new Consumidor(27541231, "Luis Gomez");
		mataGalan.agregarConsumidor(consumidorOrigen);
		mataGalan.agregarMedioDePago((Integer)27541231, (MedioDePago)cuentaOrigen);
		
		Transferible cuentaDestino = new CuentaBancaria("01744046600000087335", "Galicia", "Sandra Bustos");
		Consumidor consumidorDestino = new Consumidor(33896541, "Sandra Bustos");
		mataGalan.agregarConsumidor(consumidorDestino);
		mataGalan.agregarMedioDePago((Integer)33896541, (MedioDePago)cuentaDestino);
				
		// Ejecuci�n
		Boolean resultado = mataGalan.transferir((MedioDePago)cuentaOrigen, (MedioDePago)cuentaDestino);
				
		// Verificaci�n
		assertTrue(resultado);
	}
	/*
	@Test (expected=SaldoInsuficienteException.class)
	public void queNoSePuedaTransferirSiElSaldoNoEsSuficiente() {
	
		//producir la SaldoInsuficienteException , dejarlo sin tratar para que se produzca y lo reciba el expected
		
		
	}
	
	@Test (expected=SaldoInsuficienteException.class)
	public void queNoSePuedaComprarSiElSaldoDeLaTarjetaDeDebitoEsInsuficiente() {

	}
	
	@Test (expected=ExcedeLimiteDeCompraException.class)
	public void queNoSePuedaComprarSiSeExcedeElLimiteDeCompraDeLaTarjetaDeCredito() {

	}
	*/
}
