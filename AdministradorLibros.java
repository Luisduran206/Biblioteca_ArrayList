///LUIS DURÁN Y SOFÍA FLORES
import java.util.ArrayList;

class AdministradorLibros {
    private static ArrayList<Libro> biblioteca = new ArrayList<>();

    static String titulo;
    static String autor; 
    static String ISBN;
    static Libro libro = new Libro(titulo, autor, ISBN);
    
    public void agregarLibro(String titulo, String autor, String ISBN) {
    	libro.setTitulo(titulo);
    	libro.setAutor(autor);
    	libro.setISBN(ISBN);
    	
    	biblioteca.add(new Libro(libro.getTitulo(), libro.getAutor(), libro.getISBN()));
    }
    
    public boolean eliminarLibro(String ISBN) {
    	boolean found = true;
    	for(int i = 0; i < biblioteca.size(); i++) {
    		if(ISBN.equals(biblioteca.get(i).getISBN())) {
    			biblioteca.remove(i);
    			found = true;
    			break;
    		} else {
    			found = false;
    			continue;
    		}
    	}
    	return found;
    }
    
    public String mostrarLibros() {
    	String cadena = libro.toString(biblioteca);
    	return cadena;
    }
}