package vista;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Logger {
	
	private static Logger instancia = null;

	public static final Logger getInstancia() {
		if(instancia == null) {
			instancia = new Logger();
		}
		return instancia;
	}
	
	public final void mostrar(String texto) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:MM:ss:SS ");
 
    	System.out.println("[VISTA] " + dateFormat.format(Calendar.getInstance().getTime()) + "\t"+ texto);
	}


}
