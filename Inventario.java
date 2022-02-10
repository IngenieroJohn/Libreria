import java.util.ArrayList;

public class Inventario {
	private ArrayList<Libro> libros = new ArrayList<Libro>();
	
	public void almacenar(Libro libro) {
		libros.add(libro);
	}
	
	public Libro getLibrobyIsbn(String isbn) {
		for(Libro l: libros) {
			if(l.getIsbn().equals(isbn)) {
				return l;
			}
		}
		return null;
	}

	public ArrayList<Libro> getLibros() {
		return libros;
	}
	
	public void ventaLibro(Libro libro, int cantidad) {
		if(libro.getCantidad()< cantidad) {
			System.out.println("No hay suficientes libros para la venta");
		}
		else if(libro.getCantidad()>=cantidad) {
			libro.setCantidad(libro.getCantidad()- cantidad);	
		}
	}

	public void showlibros() {
		for (Libro lv: libros) {
			System.out.println(lv);
		}
	}
	
	public Libro result(String isbn) {
		for(Libro l: libros) {
			if(l.getIsbn().equals(isbn)) {
				Libro result = l;
				return result;
			}
		}
		return null;
	}

	
}
