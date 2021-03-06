package test;

import java.util.HashMap;

import junit.framework.TestCase;
import servicios.Frecuencias;

public class TestCalcularFrecuencias extends TestCase {

	private static final String rutaArchivo1 = "src/archivos/file.txt";
	private static final String rutaArchivo2 = "src/archivos/file2.txt";
	private static final String rutaArchivo3 = "src/archivos/file3.txt";

	public void testCalcularFrecuencias() {
		HashMap<String, Integer> map1 = new HashMap<String, Integer>();
		map1.put("RENE-ASTRID", 2);
		map1.put("RENE-ANDRES", 2);
		map1.put("ASTRID-ANDRES", 3);

		HashMap<String, Integer> map2 = new HashMap<String, Integer>();
		map2.put("RENE-ASTRID", 3);

		HashMap<String, Integer> map3 = new HashMap<String, Integer>();
		map3.put("ASTRID-DANA", 3);
		map3.put("RUTH-ANDRES", 3);
		map3.put("RUTH-DANA", 3);
		map3.put("RUTH-RENE", 2);
		map3.put("RUTH-ASTRID", 3);
		map3.put("RENE-DANA", 4);
		map3.put("RENE-ASTRID", 2);
		map3.put("RENE-ANDRES", 2);
		map3.put("ASTRID-ANDRES", 3);
		map3.put("ANDRES-DANA", 3);

		System.out.println("TEST 1: file " + rutaArchivo1);
		assertEquals(map1, Frecuencias.calcularFrecuencias(rutaArchivo1));
		System.out.println("\nTEST 2: file " + rutaArchivo2);
		assertEquals(map2, Frecuencias.calcularFrecuencias(rutaArchivo2));
		System.out.println("\nTEST 3: file " + rutaArchivo3);
		assertEquals(map3, Frecuencias.calcularFrecuencias(rutaArchivo3));

		
	}
}