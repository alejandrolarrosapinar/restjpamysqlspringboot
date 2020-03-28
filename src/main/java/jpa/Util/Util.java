package jpa.Util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Util {

	public static String formateaFecha(Date fecha) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return sdf.format(fecha);
	}
}
