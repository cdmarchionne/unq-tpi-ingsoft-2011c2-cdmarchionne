
public class Capicua {

	public static boolean comprobar(String palabra) {
		int top = 0;
		int bottom = palabra.length()-1;
		final char[] palabraToArray = palabra.toCharArray();
		
		if (!(palabra.isEmpty())) {
			while(bottom>top){
				if (!(palabraToArray[top]==palabraToArray[bottom])) {
					return false;
				}
				top++;
				bottom--;
			}
		}
			
		return true;
	}

}
