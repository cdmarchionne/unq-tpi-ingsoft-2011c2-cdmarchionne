
public class Hash {

	public static Integer obtenerHash(String palabra) {
		if(palabra!=null){
			return hash(palabra);
		}
		return null;
	}
	
	public static Integer hash(String palabra) {
		Integer acumulador=0;
		for(int i=0 ; i<palabra.length() ; i++){
			acumulador = acumulador + palabra.charAt(i);
		}
		return acumulador;
	}

}
