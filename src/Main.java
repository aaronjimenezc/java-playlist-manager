

import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		Playlist lista = new Playlist();
		
		int opcion=0;
		
		do {
			System.out.println("MENU PLAYLIST");
			System.out.println("1. AÑADIR CANCIÓN");
			System.out.println("2. MOSTRAR CANCIONES");
			System.out.println("3. COMPROBAR CANCIÓN");
			System.out.println("4. VER DURACIÓN TOTAL");
			System.out.println("5. VER CANCIÓN MAS LARGA");
			System.out.println("6. ELIMINAR CANCIÓN");
			System.out.println("7. IMPORTAR PLAYLIST");
			System.out.println("8. EXPORTAR PLAYLIST");
			System.out.println("9. SALIR");
			
			opcion = scanner.nextInt();
			scanner.nextLine();
			
			switch (opcion){
			
			case 1: 
				String nombre = null;
				String duracion = null;
				System.out.println("Escribe el nombre de la canción");
				nombre = scanner.nextLine();
				System.out.println("Escribe la duración");
				duracion = scanner.nextLine();
				lista.addSong(nombre, duracion);
				break;
				
			case 2: 
				lista.mostrar();
				break;
				
			case 3:
				String nombre1 = null;
				System.out.println("Dime el nombre de la canción que quieres buscar");
				nombre1 = scanner.nextLine();
					if (lista.comprobar(nombre1) == true) {
					System.out.println("La canción se encuentra en la lista"); 
					}
					else {
						System.out.println("La canción no está en la lista");
					}
					
					
				break;
				
			case 4: 
				System.out.println("Duración total: " + lista.duracion() + " minutos");
				break;
				
			case 5: System.out.println("La canción más larga es " + lista.masLarga());
				break;
				
			case 6: 
				String nombre2 = null;
				System.out.println("Qué canción quieres eliminar?");
				nombre2 = scanner.nextLine();
				lista.eliminar(nombre2);
				break;
				
			case 7:
				lista.importar();
				break;
				
			case 8:
				lista.exportar();
				break;
				
	
			case 9: System.out.println("Hasta luego.");
			break;
				
				
			}
			
		}
		while(opcion != 9);
		
		
		

	}

}
