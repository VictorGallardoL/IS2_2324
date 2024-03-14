public class GestionEmpleados implements IGestionEmpleados, IGestionAltasBajas	{

	private IEmpleadosDAO IE;
	private ITiendasDAO IT;

	public GestionEmpleados(TiendasDAO tiendasDAO, EmpleadosDAO empleadosDAO) {
		IT = tiendasDAO;
		IE = empleadosDAO;
	}

	@Override
	public Empleado nuevoEmpleado(Empleado e, String nombre) throws OperacionNoValidaException, DataAccessException {
		// TODO Auto-generated method stub

		Tienda tienda = IT.tiendaPorNombre(nombre);
		if (tienda == null) {
			return null;
		}
		if (IE.empleado(e.getDNI()) != null) {
			throw new OperacionNoValidaException(null);
		}
		tienda.anhadeEmpleado(e);

		return e;
	}

	@Override
	public Empleado eliminarEmpleado(String dni, String nombre) throws OperacionNoValidaException, DataAccessException {
		// TODO Auto-generated method stub
		Tienda tienda = IT.tiendaPorNombre(nombre);
		if (tienda == null) {
			return null;
		}
		Empleado e = IE.empleado(dni);
		if (e == null) {
			return null;
			}
		tienda.eliminarEmpleado(e);
		return e;
	}

	@Override
	public boolean trasladarEmpleado(String dni, String actual, String destino)
			throws OperacionNoValidaException, DataAccessException {
		// TODO Auto-generated method stub
		Empleado e = IE.empleado(dni);
		if (e == null) {
			return false;
			}
		Tienda tActual = IT.tiendaPorNombre(actual);
		if (tActual == null) {
			return false;
		}
		if (tActual.buscaEmpleado(dni) == null) {
			throw new OperacionNoValidaException(null);
		}
		Tienda tDestino = IT.tiendaPorNombre(destino);
		if (tDestino == null) {
			return false;
		}
		tActual.eliminarEmpleado(e);
		tDestino.anhadeEmpleado(e);
		return true;
	}

	@Override
	public Empleado empleado(String dni) throws DataAccessException {
		Empleado e = IE.empleado(dni);		
		return e;
	}

	@Override
	public boolean bajaMedica(String dni) throws DataAccessException {
		Empleado e = IE.empleado(dni);	
		if (e == null) {
			return false;
		}
		e.darDeBaja();
		return true;
	}

	@Override
	public boolean altaMedica(String dni) throws DataAccessException {
		Empleado e = IE.empleado(dni);	
		if (e == null) {
			return false;
		}
		e.darDeAlta();
		return true;
	}
}

