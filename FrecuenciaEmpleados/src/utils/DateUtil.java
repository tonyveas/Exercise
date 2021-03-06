package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	// public static final String PATRON = "MM/dd/yyyy HH:mm:ss";

	public static final String PATRON = "HH:mm";

	public static String convertir(Date fecha) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(PATRON);
		return simpleDateFormat.format(fecha);
	}

	public static Date convertirDate(String fecha) throws ParseException {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(PATRON);
		return simpleDateFormat.parse(fecha);
	}

}
