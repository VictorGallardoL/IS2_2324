package es.unican.is2.franquiciasucmain;

import es.unican.is2.franquiciasucbusiness.GestionEmpleados;
import es.unican.is2.franquiciasucbusiness.GestionTiendas;
import es.unican.is2.franquiciasucdao.EmpleadosDAO;
import es.unican.is2.franquiciasucdao.TiendasDAO;
import es.unican.is2.franquiciasucgui.VistaGerente;

/**
 * Clase principal que construye la aplicaci�n de tres capas y lanza su ejecuci�n
 */
public class Runner {

	public static void main(String[] args) {
		// Crear componentes capa DAO
		TiendasDAO tiendasDAO = new TiendasDAO();
		EmpleadosDAO empleadosDAO = new EmpleadosDAO();
		
		// Crear componentes capa negocio
		GestionTiendas gTiendas = new GestionTiendas(tiendasDAO);
		GestionEmpleados gEmpleados = new GestionEmpleados(tiendasDAO, empleadosDAO);
		
		// Crear componentes capa presentacion
		VistaGerente vista = new VistaGerente(gTiendas, gEmpleados);
		
		// Lanzar ejecuci�n (hacer visible la interfaz)
		vista.setVisible(true);
		
	
		
	}
}
