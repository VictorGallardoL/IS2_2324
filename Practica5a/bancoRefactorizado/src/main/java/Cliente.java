import java.util.LinkedList;
import java.util.List;

public class Cliente {

	public String nombre;
	public String telefono;
	public String dni;
	public Direccion direccion;

	private List<Cuenta> Cuentas = new LinkedList<Cuenta>();

	public Cliente(String titular, String calle, String zip, String localidad, 
			String telefono, String dni) {  //WMC +1
		this.nombre = titular;
		direccion = new Direccion(calle, zip, localidad);
		this.telefono = telefono;
		this.dni = dni;
	}


	public void anhadeCuenta(Cuenta c) { //WMC +1
		Cuentas.add(c);
	}

	public double getSaldoTotal() { //WMC +1
		double total = 0.0;
		for (Cuenta c: Cuentas) { //CCog +1
			total += getSaldoIndividual(c);
			}
		return total;
	}

	private double getSaldoIndividual(Cuenta c) { //WMC +1
		double saldoIndividual = 0.0;
		if (c instanceof CuentaAhorro) { //WMC +1 //CCog +1
			saldoIndividual = ((CuentaAhorro) c).getSaldo();
		}else if (c instanceof CuentaValores)  { //WMC +1 //CCog +1
			for (Valor v: ((CuentaValores) c).getValores()) { //CCog +2
				saldoIndividual += v.getCotizacion()*v.getNumValores();
			}
		}
		return saldoIndividual;
	}
	public String getNombre() { //WMC +1
		return nombre;
	}

	public String getTelefono() { //WMC +1
		return telefono;
	}

	public String getDni() { //WMC +1
		return dni;
	}



}