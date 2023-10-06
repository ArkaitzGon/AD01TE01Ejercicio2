package principal;

import java.io.*;

/**
 * Ejercicio 2
 * Lee un fichero e imprime en otro fichero las palabras que son un palindromo
 * Puede leer varias lineas e imrpime las palabras en lineas diferentes.
 */
public class Palindromo {

	public static void main(String[] args) {
		File ficLectura = new File("ficheroLectura.txt");
		
		File ficSalida = new File("ficheroSalida.txt");
		try {
			BufferedReader lectura = new BufferedReader(new FileReader(ficLectura));
			BufferedWriter escritura = new BufferedWriter(new FileWriter(ficSalida));
			
			String linea;
			
			while((linea = lectura.readLine()) != null) {
				String[] palabras = linea.split("\\s+");
				
				for(int i = 0; i < palabras.length; i++) {
					if(esPalindromo(palabras[i])) {
						escritura.write(palabras[i] + "\n");
					}
				}
			}
			lectura.close();
			escritura.close();
		}catch(IOException ioe) {
			ioe.printStackTrace();
		}
	}
	
	/**
	 * Metodo que evalua si una palabra es un palindromo
	 * @param palabra con la palabra a evaluar
	 * @return true si la palabra es un palindromo
	 */
	public static boolean esPalindromo(String palabra) {
		char[] cadena = palabra.toCharArray();
		String palabraInvertida = "";
		
		for(int i = cadena.length - 1; i >= 0; i--) {
			palabraInvertida += cadena[i];
		}
		
		if(palabra.equalsIgnoreCase(palabraInvertida)) {
			return true;
		}
		return false;
	}

}
