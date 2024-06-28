
public class Direccion {
	public String calle;
	public String zip;
	public String localidad;
	
	public Direccion(String calle, String zip, String localidad) { //WMC +1
		this.calle = calle;
		this.zip = zip;
		this.localidad = localidad;
	}
	
	public void cambiaDireccion(String nuevaCalle, String nuevoZip, String nuevaLocalidad) { //WMC +1
		calle = nuevaCalle;
		zip = nuevoZip;
		localidad = nuevaLocalidad;
	}
	
	public String getCalle() { //WMC +1
		return calle;
	}

	public String getZip() { //WMC +1
		return zip;
	}

	public String getLocalidad() { //WMC +1
		return localidad;
	}
	
}
