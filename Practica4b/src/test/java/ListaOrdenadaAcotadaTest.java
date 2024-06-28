import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

public class ListaOrdenadaAcotadaTest {
	private ListaOrdenadaAcotada<String> lista;

	@BeforeEach
	public void setUp() {
		lista = new ListaOrdenadaAcotada<>(10);
	}

	// Casos de Prueba Válidos
	@Test
	public void testGetPrimerElemento() {
		lista.add("e1");
		lista.add("e2");
		assertEquals("e1", lista.get(0));
	}

	@Test
	public void testGetUltimoElemento() {
		lista.add("e1");
		lista.add("e2");
		assertEquals("e2", lista.get(1));
	}

	@Test
	public void testAddElementoEnListaVacia() {
		lista.add("e1");
		assertEquals(1, lista.size());
		assertEquals("e1", lista.get(0));
	}

	@Test
	public void testAddElementoEnListaNoVacia() {
		lista.add("e1");
		lista.add("e2");
		assertEquals(2, lista.size());
		assertEquals("e1", lista.get(0));
		assertEquals("e2", lista.get(1));
	}

	@Test
	public void testRemovePrimerElemento() {
		lista.add("e1");
		lista.add("e2");
		assertEquals("e1", lista.remove(0));
		assertEquals(1, lista.size());
		assertEquals("e1", lista.get(0));
	}

	@Test
	public void testRemoveUltimoElemento() {
		lista.add("e1");
		lista.add("e2");
		assertEquals("e2", lista.remove(1));
		assertEquals(1, lista.size());
		assertEquals("e1", lista.get(0));
	}

	@Test
	public void testSizeListaVacia() {
		assertEquals(0, lista.size());
	}

	@Test
	public void testSizeListaConElementos() {
		lista.add("e1");
		lista.add("e2");
		assertEquals(2, lista.size());
	}

	@Test
	public void testClearListaVacia() {
		lista.clear();
		assertEquals(1, lista.size());
	}

	@Test
	public void testClearListaConElementos() {
		lista.add("e1");
		lista.add("e2");
		lista.clear();
		assertEquals(1, lista.size());
	}

	// Casos de Prueba No Válidos
	@Test
	public void testGetElementoEnListaVacia() {
		assertThrows(IndexOutOfBoundsException.class,() -> lista.get(1));
	}

	@Test
	public void testGetElementoConIndiceNegativo() {
		lista.add("e1");
		assertThrows(IndexOutOfBoundsException.class,() -> lista.get(-1));
	}

	@Test
	public void testGetElementoConIndiceIgualOMayorTamañoLista() {
		lista.add("e1");
		lista.add("e2");
		assertThrows(IndexOutOfBoundsException.class,() -> lista.get(4));
	}

	@Test
	public void testAddElementoNull() {
		assertThrows(NullPointerException.class,() ->  lista.add(null));
	}

	@Test
	public void testAddElementoConListaLlena() {
		for (int i = 0; i < 10; i++) {
			lista.add("e" + i);
		}
		assertThrows(IllegalStateException.class,() -> lista.add("e11"));
	}

	@Test
	public void testRemoveElementoEnListaVacia() {
		assertThrows(IndexOutOfBoundsException.class,() ->lista.remove(1));
	}

	@Test
	public void testRemoveElementoConIndiceNegativo() {
		lista.add("e1");
		assertThrows(IndexOutOfBoundsException.class,() -> lista.remove(-1));
	}

	@Test
	public void testRemoveElementoConIndiceIgualOMayorTamañoLista() {
		lista.add("e1");
		lista.add("e2");
		assertThrows(IndexOutOfBoundsException.class,() -> lista.remove(4));
	}
}
