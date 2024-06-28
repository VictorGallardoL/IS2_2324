import java.time.LocalDateTime;

public class Movimiento {
	private String concepto;
	private LocalDateTime fecha;
	private double importe;

	public double getImporte() { //WMC +1
		return importe;
	}

	public void setImporte(double newMImporte) { //WMC +1
		importe = newMImporte;
	}
	
	public String getConcepto() { //WMC +1
		return concepto;
	}

	public void setConcepto(String newMConcepto) { //WMC +1
		concepto = newMConcepto;
	}

	public LocalDateTime getFecha() { //WMC +1
		return fecha;
	}

	public void setFecha(LocalDateTime newMFecha) { //WMC +1
		fecha = newMFecha;
	}
	
}