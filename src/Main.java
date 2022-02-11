import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	

	public static void main(String[] args) {
			
		
		boolean salir = false;
		
		Inventario inventario = new Inventario();
		Mensajes msm = new Mensajes();
		
		ArrayList<Libro> libros = inventario.getLibros();
		Libro l1 = new Libro("001", "title", 12, 1);
		inventario.almacenar(l1);
		Libro l2 = new Libro("002", "titl", 2, 1);
		inventario.almacenar(l2);
		Libro l3 = new Libro("003", "tit", 24, 1);
		inventario.almacenar(l3);
		Libro l4 = new Libro("004", "ti", 200, 1);
		inventario.almacenar(l4);
		Libro l5 = new Libro("005", "t", 34, 1);
		inventario.almacenar(l5);
		do {
			Scanner scan = new Scanner (System.in);
			msm.menuprincipal();
			
			
			int op = scan.nextInt();
			String isbn;
			String title;
			double prize;
			int books;
			switch(op) {
			
			case 1:
				System.out.println("Ingresar isbn: ");
				isbn = scan.next();
				inventario.result(isbn);
				
				if(inventario.result(isbn) != null)  {
					System.out.println(" \n ERRO DE INGRESO (ISBN REPETIDO) XXXXXXXXXX");
					
				}
				else {
					System.out.println("Ingrese título: ");
					title = scan.next();
					System.out.println("Ingrese precio: ");
					prize= scan.nextDouble();
					System.out.println("Ingrese la cantidad de libros en inventario: ");
					books = scan.nextInt();
					System.out.println("");
					
					Libro ln = new Libro(isbn, title, prize, books);
					inventario.almacenar(ln);
					
				}
				break;
				
				
			case 2:
				
				System.out.println("Ingresar el isbn: ");
				isbn = scan.next();
				inventario.result(isbn);
				
				if(inventario.result(isbn) != null) {
					System.out.println(inventario.result(isbn) + "\n");
				}else {
					System.out.println("No se encontro el libro con el ISBN "+ isbn +"\n");
				}
				break;
				
				
			case 3:
				System.out.println("***** VENTA DE LIBRO ***** \n");
				inventario.showlibros();
				System.out.println("\n ¿Qué libro desea vender (ingrese isbn): ");
				isbn = scan.next();
				inventario.result(isbn);
					if(inventario.result(isbn) != null) {
						System.out.println("\n ¿Cuántos desea vender:");
						books= scan.nextInt();
						inventario.ventaLibro(inventario.result(isbn), books);
						System.out.println("\n Venta hecha $$$$$");
					}
					else {
						System.out.println("No se encontro el libro con el ISBN "+ isbn +"\n");
						}
				
				break;
				
			case 4:
				Collections.sort(libros);
				for (int i=0; i <3;i++ ) {
					System.out.println(libros.get(i)); 
				}
				
				break; 
				
				
			case 5:
				inventario.showlibros();

				break;
				
				
			case 0:
				
				salir =true;
				break;
			}
			
		}
		while(!salir);
		
		
		
		
	}

}
