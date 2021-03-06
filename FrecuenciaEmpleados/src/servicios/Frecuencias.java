package servicios;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
//import java.util.Set;

import utils.ArchivoException;

public class Frecuencias {

	public static boolean validarRangoDeHoras(String hora1, String hora2) {
		boolean cumpleCaso = false;
		if (hora1.substring(0, 2).equals(hora2.substring(0, 2))) {
			try {
				if (hora1.equals(hora2)) {
					cumpleCaso = true;
				} else {
					String[] fecha1Arr = hora1.substring(2).split("-");
					String[] fecha2Arr = hora2.substring(2).split("-");
					SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
					if ((dateFormat.parse(fecha1Arr[0]).compareTo(dateFormat.parse(fecha2Arr[0])) == 0)
							&& (dateFormat.parse(fecha1Arr[1]).compareTo(dateFormat.parse(fecha2Arr[1])) > 0)) {
						cumpleCaso = true;
					} else if ((dateFormat.parse(fecha1Arr[0]).compareTo(dateFormat.parse(fecha2Arr[0])) < 0)
							&& (dateFormat.parse(fecha1Arr[1]).compareTo(dateFormat.parse(fecha2Arr[1])) > 0)) {
						cumpleCaso = true;
					} else if ((dateFormat.parse(fecha1Arr[0]).compareTo(dateFormat.parse(fecha2Arr[0])) < 0)
							&& (dateFormat.parse(fecha1Arr[1]).compareTo(dateFormat.parse(fecha2Arr[1])) == 0)) {
						cumpleCaso = true;
					} else if ((dateFormat.parse(fecha2Arr[0]).compareTo(dateFormat.parse(fecha1Arr[0])) == 0)
							&& (dateFormat.parse(fecha2Arr[1]).compareTo(dateFormat.parse(fecha1Arr[1])) > 0)) {
						cumpleCaso = true;
					} else if ((dateFormat.parse(fecha2Arr[0]).compareTo(dateFormat.parse(fecha1Arr[0])) < 0)
							&& (dateFormat.parse(fecha2Arr[1]).compareTo(dateFormat.parse(fecha1Arr[1])) > 0)) {
						cumpleCaso = true;
					} else if ((dateFormat.parse(fecha2Arr[0]).compareTo(dateFormat.parse(fecha1Arr[0])) < 0)
							&& (dateFormat.parse(fecha2Arr[1]).compareTo(dateFormat.parse(fecha1Arr[1])) == 0)) {
						cumpleCaso = true;
					}
				}
			} catch (ParseException ex) {
				System.out.println("Error al parserar");
				ex.printStackTrace();
			}
		}
		return cumpleCaso;
	}

	public static HashMap<String, Integer> calcularFrecuencias(String rutaArchivo) {
		HashMap<String, String[]> map = null;
		HashMap<String, Integer> mapaFrecuencias = new HashMap<String, Integer>();
		try {
			map = ManejadorArchivos.leer(rutaArchivo);
			HashMap<String, ArrayList<String>> frecuencias = new HashMap<String, ArrayList<String>>();
			for (String nombreEmpleado1 : map.keySet()) {
				HashMap<String, String[]> horarios1temp = new HashMap<String, String[]>();
				horarios1temp.put(nombreEmpleado1, map.get(nombreEmpleado1));
				for (String nombreEmpleado2 : map.keySet()) {
					HashMap<String, String[]> horarios2temp = new HashMap<String, String[]>();
					horarios2temp.put(nombreEmpleado2, map.get(nombreEmpleado2));
					HashMap<String, ArrayList<String>> comunesHorarios = comunes(horarios1temp, horarios2temp);
					if (!comunesHorarios.isEmpty()) {
						for (String s : comunesHorarios.keySet()) {
							if (!comparar(s, frecuencias)) {
								frecuencias.put(s, comunesHorarios.get(s));
							}
						}
					}
				}
			}
			for (String paresEmpleados : frecuencias.keySet()) {
				System.out.println(paresEmpleados + ":" + frecuencias.get(paresEmpleados).size());
			}
			for (String paresEmpleados : frecuencias.keySet()) {
				mapaFrecuencias.put(paresEmpleados, frecuencias.get(paresEmpleados).size());
			}
		} catch (ArchivoException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return mapaFrecuencias;
	}

	public static HashMap<String, String[]> frecuencias2(String rutaArchivo) {
		HashMap<String, String[]> map = null;
		try {
			map = ManejadorArchivos.leer(rutaArchivo);
			HashMap<String, ArrayList<String>> frecuencias = new HashMap<String, ArrayList<String>>();
			for (String nombreEmpleado1 : map.keySet()) {
				HashMap<String, String[]> horarios1temp = new HashMap<String, String[]>();
				horarios1temp.put(nombreEmpleado1, map.get(nombreEmpleado1));
				for (String nombreEmpleado2 : map.keySet()) {
					HashMap<String, String[]> horarios2temp = new HashMap<String, String[]>();
					horarios2temp.put(nombreEmpleado2, map.get(nombreEmpleado2));
					HashMap<String, ArrayList<String>> comunesHorarios = comunes(horarios1temp, horarios2temp);
					if (!comunesHorarios.isEmpty()) {
						for (String s : comunesHorarios.keySet()) {
							if (!comparar(s, frecuencias)) {
								frecuencias.put(s, comunesHorarios.get(s));
							}
						}
					}
				}
			}
			for (String paresEmpleados : frecuencias.keySet()) {
				System.out.println(paresEmpleados + ":" + frecuencias.get(paresEmpleados).size());
			}
		} catch (ArchivoException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return map;
	}

	public static void frecuencias(String rutaArchivo) {
		HashMap<String, String[]> map = null;
		try {
			map = ManejadorArchivos.leer(rutaArchivo);
			HashMap<String, ArrayList<String>> frecuencias = new HashMap<String, ArrayList<String>>();
			for (String nombreEmpleado1 : map.keySet()) {
				HashMap<String, String[]> horarios1temp = new HashMap<String, String[]>();
				horarios1temp.put(nombreEmpleado1, map.get(nombreEmpleado1));
				for (String nombreEmpleado2 : map.keySet()) {
					HashMap<String, String[]> horarios2temp = new HashMap<String, String[]>();
					horarios2temp.put(nombreEmpleado2, map.get(nombreEmpleado2));
					HashMap<String, ArrayList<String>> comunesHorarios = comunes(horarios1temp, horarios2temp);
					if (!comunesHorarios.isEmpty()) {
						for (String s : comunesHorarios.keySet()) {
							if (!comparar(s, frecuencias)) {
								frecuencias.put(s, comunesHorarios.get(s));
							}
						}
					}
				}
			}
			for (String paresEmpleados : frecuencias.keySet()) {
				System.out.println(paresEmpleados + ":" + frecuencias.get(paresEmpleados).size());
			}
		} catch (ArchivoException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}

	}

	public static boolean comparar(String cadena, HashMap<String, ArrayList<String>> map) {
		String[] data = cadena.split("-");
		boolean existe = false;
		if (map.containsKey(cadena)) {
			existe = true;
		} else if (map.containsKey(data[1] + "-" + data[0])) {
			existe = true;
		}
		return existe;
	}

	public static HashMap<String, ArrayList<String>> comunes(HashMap<String, String[]> horarios1,
			HashMap<String, String[]> horarios2) {
		HashMap<String, ArrayList<String>> comunes = new HashMap<String, ArrayList<String>>();
		String nombreEmpleado1 = "";
		String nombreEmpleado2 = "";
		for (String nEmpleado1 : horarios1.keySet()) {
			nombreEmpleado1 = nEmpleado1;
		}
		for (String nEmpleado2 : horarios2.keySet()) {
			nombreEmpleado2 = nEmpleado2;
		}
		String[] horariosEmpleado1 = horarios1.get(nombreEmpleado1);
		String[] horariosEmpleado2 = horarios2.get(nombreEmpleado2);
		for (int i = 0; i < horariosEmpleado1.length; i++) {
			for (int j = 0; j < horariosEmpleado2.length; j++) {
				if (!nombreEmpleado1.equals(nombreEmpleado2)) {
					if (validarRangoDeHoras(horariosEmpleado1[i], horariosEmpleado2[j])) {
						if (!comunes.containsKey(nombreEmpleado1 + "-" + nombreEmpleado2)) {
							ArrayList<String> temp = new ArrayList<String>();
							temp.add(horariosEmpleado1[i]);
							comunes.put(nombreEmpleado1 + "-" + nombreEmpleado2, temp);
						} else {
							ArrayList<String> temp = comunes.get(nombreEmpleado1 + "-" + nombreEmpleado2);
							temp.add(horariosEmpleado1[i]);
							comunes.put(nombreEmpleado1 + "-" + nombreEmpleado2, temp);
						}
					}
				}
			}
		}
		return comunes;
	}

}
