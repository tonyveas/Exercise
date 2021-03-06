package servicios;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import utils.ArchivoException;

public class ManejadorArchivos {

	public static HashMap<String, String[]> leer(String rutaArchivo) throws ArchivoException {
		HashMap<String, String[]> map = new HashMap<String, String[]>();
		File file = new File(rutaArchivo);
		FileReader fileReader = null;
		BufferedReader br = null;
		String linea = "";
		String[] data;
		String[] horarios;
		try {
			fileReader = new FileReader(file);
			br = new BufferedReader(fileReader);
			while ((linea = br.readLine()) != null) {
				data = linea.split("=");
				horarios = data[1].split(",");
				map.put(data[0], horarios);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("No existe el archivo");
			throw new ArchivoException("No existe el archivo " + rutaArchivo);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Error al leer el archivo");
			throw new ArchivoException("Error al leer el archivo " + rutaArchivo);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error");
			throw new ArchivoException("Error");
		} finally {
			try {
				if (br != null) {
					br.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("Error al cerrar el BufferedReader br ");
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Error");
			}
			try {
				if (fileReader != null) {
					fileReader.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("Error al cerrar el FileReader fileReader ");
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Error");
			}
		}
		return map;
	}

}
