///LUIS DURÁN Y SOFÍA FLORES
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class GUIAdministradorLibros {
    
	AdministradorLibros admin;
	
    public GUIAdministradorLibros() {
        admin = new AdministradorLibros();

        JFrame frame = new JFrame("¡¡¡BIENVENIDO A TU BIBLIOTECA!!!");
        JMenuBar menuBar = new JMenuBar();
        JMenu acciones = new JMenu("Opciones");
        JMenuItem agregarItem = new JMenuItem("Agregar libro");
        JMenuItem eliminarItem = new JMenuItem("Eliminar libro por ISBN");
        JMenuItem mostrarItem = new JMenuItem("Mostrar todos los libros");
        
        agregarItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                accionAgregarLibro();
            }
        });

        eliminarItem.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                accionEliminarLibroPorISBN();
            }
        });

        mostrarItem.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                accionMostrarLibros();
            }
        });

        acciones.add(agregarItem);
        acciones.add(eliminarItem);
        acciones.add(mostrarItem);
        menuBar.add(acciones);
        frame.setJMenuBar(menuBar);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 100);
        frame.setVisible(true);
    }

    void accionAgregarLibro() {
        String titulo = JOptionPane.showInputDialog("Ingrese el título del libro que desea agregar:");
        String autor = JOptionPane.showInputDialog("Ingrese el autor del libro:");
        String ISBN = JOptionPane.showInputDialog("Ingrese el ISBN del libro:");
        if (titulo != null && autor != null && ISBN != null) {
            admin.agregarLibro(titulo, autor, ISBN);
            JOptionPane.showMessageDialog(null, "¡El libro fue agregado a su biblioteca!");
        }
    }

    void accionEliminarLibroPorISBN() throws HeadlessException {
        String ISBN = JOptionPane.showInputDialog("Coloque el ISBN del libro a eliminar:");
        admin.eliminarLibro(ISBN);
        if(admin.eliminarLibro(ISBN)) {
        	JOptionPane.showMessageDialog(null, "Su libro se eliminó exitosamente...");
        } else {
        	JOptionPane.showMessageDialog(null, "Lo sentimos, no se encontró dicho ISBN, pruebe con otro");
        }
    }

    void accionMostrarLibros() {
        String todosLibros = admin.mostrarLibros();
        if (!todosLibros.isEmpty()) {
            JOptionPane.showMessageDialog(null, todosLibros, "Biblioteca", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "No hay libros en la biblioteca.", "Biblioteca", JOptionPane.INFORMATION_MESSAGE);
        }
    }
  }