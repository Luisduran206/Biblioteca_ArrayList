///LUIS DURÁN Y SOFÍA FLORES
import java.util.ArrayList;

class Libro {
    
	private String titulo;
    private String autor;
    private String ISBN;

    public Libro(String titulo, String autor, String ISBN) {		///Constructor
        this.titulo = titulo;
        this.autor = autor;
        this.ISBN = ISBN;
    }
    
///Métodos para título
    public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
///Métodos para autor	
	public void setAutor(String autor) {
		this.autor = autor;
	}
	
	public String getAutor() {
		return autor;
	}
	
///Métodos para ISBN	
	public void setISBN(String ISBN) {
		this.ISBN = ISBN;
	}
	
	public String getISBN(){
		return ISBN;
	}
	
///Método toString()	
	public String toString(ArrayList<Libro> biblioteca) {
			StringBuilder stringBuilder = new StringBuilder();
			for (int j = 0; j < biblioteca.size(); j++) {
	            stringBuilder.append(biblioteca.get(j).getTitulo() + " por " + biblioteca.get(j).getAutor() + " - ISBN: " + biblioteca.get(j).getISBN() + "\n");
			}
		return stringBuilder.toString();
    }
	
}