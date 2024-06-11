package es.unican.is2.franquiciasucbusiness;

import es.unican.is2.franquiciasuccommon.DataAccessException;
import es.unican.is2.franquiciasuccommon.Empleado;
import es.unican.is2.franquiciasuccommon.IEmpleadosDAO;
import es.unican.is2.franquiciasuccommon.IGestionAltasBajas;
import es.unican.is2.franquiciasuccommon.IGestionEmpleados;
import es.unican.is2.franquiciasuccommon.ITiendasDAO;
import es.unican.is2.franquiciasuccommon.OperacionNoValidaException;
import es.unican.is2.franquiciasuccommon.Tienda;
import es.unican.is2.franquiciasucdao.EmpleadosDAO;
import es.unican.is2.franquiciasucdao.TiendasDAO;

public class GestionEmpleados implements IGestionEmpleados, IGestionAltasBajas	{

	private IEmpleadosDAO IE;
	private ITiendasDAO IT;

	public GestionEmpleados(ITiendasDAO tiendasDAO, IEmpleadosDAO empleadosDAO) {
		IT = tiendasDAO;
		IE = empleadosDAO;
	}

	@Override
	public Empleado nuevoEmpleado(Empleado e, String nombre) throws OperacionNoValidaException, DataAccessException {

		Tienda tienda = IT.tiendaPorNombre(nombre);
		if (tienda == null) {
			return null;
		}
		if (IE.empleado(e.getDNI()) != null) {
			throw new OperacionNoValidaException(null);
		}
		tienda.anhadeEmpleado(e);
		IT.modificarTienda(tienda);
        IE.crearEmpleado(e);
		return e;
	}

	@Override
	public Empleado eliminarEmpleado(String dni, String nombre) throws OperacionNoValidaException, DataAccessException {
		Tienda tienda = IT.tiendaPorNombre(nombre);
		if (tienda == null) {
			return null;
		}
		Empleado e = IE.empleado(dni);
		if (e == null || tienda.buscaEmpleado(dni) == null) {
            throw new OperacionNoValidaException("El empleado no está en la tienda");
			}
		tienda.eliminarEmpleado(e);
		 IT.modificarTienda(tienda);
	     IE.eliminarEmpleado(dni);
		return e;
	}

	@Override
	public boolean trasladarEmpleado(String dni, String actual, String destino)
			throws OperacionNoValidaException, DataAccessException {
		Empleado e = IE.empleado(dni);
		if (e == null) {
			return false;
			}
		Tienda tActual = IT.tiendaPorNombre(actual);
		if (tActual == null || tActual.buscaEmpleado(dni) == null) {
            throw new OperacionNoValidaException("El empleado no está en la tienda actual");
		}
		
		Tienda tDestino = IT.tiendaPorNombre(destino);
		if (tDestino == null) {
			return false;
		}
		
		tActual.eliminarEmpleado(e);
        IT.modificarTienda(tActual);
		tDestino.anhadeEmpleado(e);
        IT.modificarTienda(tDestino);
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
        IE.modificarEmpleado(e);
        
		return true;
	}

	@Override
	public boolean altaMedica(String dni) throws DataAccessException {
		Empleado e = IE.empleado(dni);	
		if (e == null) {
			return false;
		}
		e.darDeAlta();
        IE.modificarEmpleado(e);

		return true;
	}
}

