
import java.io.*;

public class Playlist {
	
	String[] playlist1 = new String[20];
	
	//Agregar cancion
	public void addSong(String nombreCancion, String duracionCancion) {
		boolean agregada = false;
		for (int i=0; i<playlist1.length; i++) {
			if(playlist1[i]==null) {
				playlist1[i] = nombreCancion + " - " + duracionCancion;
				agregada = true;
				System.out.println("Agregada con éxito la canción " + nombreCancion + ", duración " + duracionCancion);
				break;
			}
		}
			if (agregada == false) {
				System.out.println("No hay espacio en la lista, extiéndela");
			}
	}
	
	//Mostrar canciones
	public void mostrar() {
		for (int i=0; i<playlist1.length; i++) {
			if (playlist1[i] != null) {
				System.out.println(playlist1[i]);
			}
		}
	}
	
	//Comprobar canciones
	public boolean comprobar(String nombreCancion) {
		for(int i=0; i<playlist1.length; i++) {
			if (playlist1[i] != null && playlist1[i].startsWith(nombreCancion)) {
				return true;	
			}	
		}
		return false;
	}
	
	//Duracion total
	public double duracion() {
		double total = 0;
		for (int i=0; i<playlist1.length; i++) {
			if (playlist1[i] != null) {
				String[] partes = playlist1[i].split(" - ");
				double minutos = Double.parseDouble(partes[1]);
				total += minutos;	
			}
		}
		return total;	
	}
	
	//Cancion mas larga
	public String masLarga() {
		String nombre = null;
		double duracion = 0;
		double maxDuracion = 0;
		for (int i=0; i<playlist1.length; i++) {
			if(playlist1[i] != null) {
				String[] partes = playlist1[i].split(" - ");
				duracion = Double.parseDouble(partes[1]);
				if (duracion>maxDuracion) {
					maxDuracion = duracion;
					nombre = playlist1[i];
				}
			}
		}
		return nombre;
	}
	
	//Eliminar cancion
	public void eliminar(String nombre) {
		for(int i=0; i<playlist1.length; i++) {
			if(playlist1[i] != null && playlist1[i].startsWith(nombre)) {
				playlist1[i] = null;
				break;
			}
		}
	}
	
	//Datos
	public void exportar() {
	String rutaCarpeta = System.getProperty("user.home") + "\\Desktop\\Java";
	File carpeta = new File(rutaCarpeta);
		if (!carpeta.exists()) {
			carpeta.mkdirs();
		}
		File txt = new File(carpeta, "Playlist.txt");
	
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(txt))) {
			for (int i=0;i<playlist1.length;i++) {
				if (playlist1[i]!=null) {
					bw.write(playlist1[i]);
					bw.newLine();
					
				}
			}
			System.out.println("Exportado con éxito");
			
		}
		catch (IOException e) {
			System.out.println("Error al escribir el archivo" + e.getMessage());
		}
	}
	
	public void importar() {
		File txt = new File(System.getProperty("user.home") + "\\Desktop\\Java", "Playlist.txt");
			if (!txt.exists()) {
				System.out.println("No se encontró el archivo");
				return;
			}
			 try (BufferedReader br = new BufferedReader(new FileReader(txt))) {
				 for (int i=0; i<playlist1.length;i++) {
					if (playlist1[i] == null) {
						String linea = br.readLine();
						if (linea != null) {
							playlist1[i] = linea;						
					 } 	else {
							
							break;
						}
					}
					
				 }
				 System.out.println("Importado con éxito");
			 }
			 catch (IOException e) {
				 System.out.println("Error de ejecución: " + e.getMessage());
			 }
			
		
		
	}
	
	
	
	
}
