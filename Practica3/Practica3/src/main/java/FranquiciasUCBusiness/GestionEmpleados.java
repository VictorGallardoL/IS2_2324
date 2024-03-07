
public class GestionEmpleados implements IGestionEmpleados, IGestionAltasBajas	{

	@Override
	public Empleado nuevoEmpleado(Empleado e, String nombre) throws OperacionNoValidaException, DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Empleado eliminarEmpleado(String dni, String nombre) throws OperacionNoValidaException, DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean trasladarEmpleado(String dni, String actual, String destino)
			throws OperacionNoValidaException, DataAccessException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Empleado empleado(String dni) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean bajaMedica(String dni) throws DataAccessException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean altaMedica(String dni) throws DataAccessException {
		// TODO Auto-generated method stub
		return false;
	}


	}

