import java.time.LocalDate;

public class TarjetaDebito extends Tarjeta {
	
	private double saldoDiarioDisponible;

	public TarjetaDebito(String numero, String titular, CuentaAhorro c) { //WMC +1
		super(numero, titular, c);
	}
	
	@Override
	public void retirar(double x) throws saldoInsuficienteException, datoErroneoException { //WMC +1
		if (saldoDiarioDisponible<x) { //WMC +1 //CCog +1
			throw new saldoInsuficienteException("Saldo insuficiente");
		}
		this.mCuentaAsociada.retirar("Retirada en cajero autom�tico", x);
		saldoDiarioDisponible-=x;
	}
	
	@Override
	public void pagoEnEstablecimiento(String datos, double x) throws saldoInsuficienteException, datoErroneoException { //WMC +1
		if (saldoDiarioDisponible<x) { //WMC +1 //CCog +1
			throw new saldoInsuficienteException("Saldo insuficiente");
		}
		this.mCuentaAsociada.retirar("Compra en : " + datos, x);
		saldoDiarioDisponible-=x;
	}
	
	public LocalDate getCaducidadDebito() { //WMC +1
		return this.mCuentaAsociada.getCaducidadDebito();
	}
	
	/**
	 * M�todo invocado autom�ticamente a las 00:00 de cada d�a
	 */
	public void restableceSaldo() { //WMC +1
		saldoDiarioDisponible = mCuentaAsociada.getLimiteDebito();
	}
	
	public CuentaAhorro getCuentaAsociada() { //WMC +1
		return mCuentaAsociada;
	}

}