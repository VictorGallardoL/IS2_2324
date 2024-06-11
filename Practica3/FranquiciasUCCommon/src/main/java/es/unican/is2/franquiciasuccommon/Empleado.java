package es.unican.is2.franquiciasuccommon;



import java.time.LocalDate;
import java.util.Objects;
/**
 * Clase que representa un empleado de la franquicia, 
 * con sus datos personales 
 * y su estado en la franquicia (baja y categoria)
 */
public class Empleado {
	
	private String DNI;
	private String nombre;
	private Categoria categoria;
	private LocalDate fechaContratacion;
	private boolean baja = false;
	
	public Empleado() {	}
	
	/**
	 * Constructor del empleado con DNI, nombre, categoria y fecha de contratacion.
	 * Por defecto, baja se inicializa a false. 
	 * @param DNI
	 * @param nombre
	 * @param categoria
	 * @param fechaContratacion
	 */
	public Empleado(String DNI, String nombre, Categoria categoria, LocalDate fechaContratacion) {
		this.nombre = nombre;
		this.DNI=DNI;
		this.categoria=categoria;
		this.fechaContratacion=fechaContratacion;
	}
	
	/**
	 * Retorna el sueldo bruto del empleado
	 */
	public double sueldoBruto() {
		double sueldoBase = 0;
		switch (categoria) {
		case ENCARGADO:
			sueldoBase = 2000;
			break;
		case VENDEDOR:
			sueldoBase = 1500;
			break;
		case AUXILIAR:
			sueldoBase = 1000;
			break;
	}
		
		int antiguedad = LocalDate.now().getYear() - fechaContratacion.getYear();

        // Calcular el complemento por antigüedad
        int complementoAntiguedad = 0;
        if (antiguedad >= 20) {
            complementoAntiguedad = 200;
        } else if (antiguedad >= 10) {
            complementoAntiguedad = 100;
        } else if (antiguedad >= 5) {
            complementoAntiguedad = 50;
        }
        
        double sueldo = sueldoBase + complementoAntiguedad;
        if (baja) {
        	sueldo *= 0.75;
        }
		return sueldo;
	}
	
	/** 
	 * Dar de baja al empleado
	 */
	public void darDeBaja() {
		this.baja=true;
	}
	
	/**
	 * Dar de alta al empleado
	 */
	public void darDeAlta() {
		this.baja=false;
	}
	
	
	/**
	 * Retorna el dni del vendedor
	 * @return id
	 */
	public String getDNI() {
		return DNI;
	}
	
	/**
	 * Retorna el nombre del vendedor
	 * @return nombre
	 */
	public String getNombre() {
		return nombre;
	}
	
	/**
	 * Retorna la categoria del empleado
	 *  @return categoria
	 */
	public Categoria getCategoria () {
		return categoria;
	}
	
	/**
	 * Retorna la fecha de contrato
	 * @return Fecha de contratacion
	 */
	public LocalDate getFechaContratacion() {
		return fechaContratacion;
	}
	
	/**
	 * Retorna si el empleado est� de baja
	 * @return true si esta de baja
	 *         false si no lo esta
	 */
	public boolean getBaja() {
		return baja;
	}
		
	
	public void setDNI(String dNI) {
		DNI = dNI;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setFechaContratacion(LocalDate fechaContratacion) {
		this.fechaContratacion = fechaContratacion;
	}
	
	public void setBaja(boolean baja) {
		this.baja = baja;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Empleado empleado = (Empleado) o;
		return Objects.equals(DNI, empleado.DNI);
	}

	@Override
	public int hashCode() {
		return Objects.hash(DNI);
	}
	
}
