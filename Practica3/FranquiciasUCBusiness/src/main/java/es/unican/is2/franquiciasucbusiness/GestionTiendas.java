package es.unican.is2.franquiciasucbusiness;
import es.unican.is2.franquiciasuccommon.DataAccessException;
import es.unican.is2.franquiciasuccommon.IGestionTiendas;
import es.unican.is2.franquiciasuccommon.ITiendasDAO;
import es.unican.is2.franquiciasuccommon.OperacionNoValidaException;
import es.unican.is2.franquiciasuccommon.Tienda;
import es.unican.is2.franquiciasuccommon.TiendasDAO;

public class GestionTiendas implements IGestionTiendas {
	private ITiendasDAO IT;


	public GestionTiendas(TiendasDAO tiendasDAO) {
		IT = tiendasDAO;
	}

	@Override
	public Tienda nuevaTienda(Tienda t) throws DataAccessException {
		if (IT.tiendaPorNombre(t.getNombre()) != null) {
			return null;
		}
		IT.crearTienda(t);
		return t;
	}

	@Override
	public Tienda eliminarTienda(String nombre) throws OperacionNoValidaException, DataAccessException {
		Tienda t = IT.tiendaPorNombre(nombre);
		if(t.getEmpleados() != null) {
			throw new OperacionNoValidaException(null);
		}
		return t;
	}

	@Override
	public Tienda tienda(String nombre) throws DataAccessException {
		Tienda t = IT.tiendaPorNombre(nombre);
		return t;
	}
	
}
