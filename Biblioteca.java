import java.util.ArrayList;
import java.util.Scanner;

public class Biblioteca {

    private ArrayList<Libro> libros;
    private ArrayList<Usuario> usuarios;
    private ArrayList<Prestamo> prestamos;

    public Biblioteca() {
        libros = new ArrayList<>();
        usuarios = new ArrayList<>();
        prestamos = new ArrayList<>();
    }

    // Getters
    public ArrayList<Libro> getLibros() {
        return libros;
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    // Agregar libro
    public void agregarLibro(Libro libro) {
        libros.add(libro);
        System.out.println("Libro agregado correctamente.");
    }

    // Agregar usuario
    public void agregarUsuario(Usuario usuario) {
        usuarios.add(usuario);
        System.out.println("Usuario agregado correctamente.");
    }

    // Mostrar libros
    public void mostrarLibros() {
        if (libros.isEmpty()) {
            System.out.println("No hay libros registrados.");
            return;
        }

        for (Libro l : libros) {
            System.out.println(l);
        }
    }

    // Mostrar usuarios
    public void mostrarUsuarios() {
        if (usuarios.isEmpty()) {
            System.out.println("No hay usuarios registrados.");
            return;
        }

        for (Usuario u : usuarios) {
            System.out.println(u);
        }
    }

    // Realizar préstamo INTERACTIVO
    public void realizarPrestamo(Scanner sc) {

        if (libros.isEmpty() || usuarios.isEmpty()) {
            System.out.println("Debe registrar libros y usuarios primero.");
            return;
        }

        System.out.print("Ingrese ID del usuario: ");
        String idUsuario = sc.nextLine();

        Usuario usuarioEncontrado = null;
        for (Usuario u : usuarios) {
            if (u.getId().equals(idUsuario)) {
                usuarioEncontrado = u;
                break;
            }
        }

        if (usuarioEncontrado == null) {
            System.out.println("Usuario no encontrado.");
            return;
        }

        System.out.print("Ingrese ISBN del libro: ");
        String isbn = sc.nextLine();

        Libro libroEncontrado = null;
        for (Libro l : libros) {
            if (l.getIsbn().equals(isbn) && l.isDisponible()) {
                libroEncontrado = l;
                break;
            }
        }

        if (libroEncontrado == null) {
            System.out.println("Libro no disponible o no existe.");
            return;
        }

        Prestamo nuevoPrestamo = new Prestamo(usuarioEncontrado, libroEncontrado);
        prestamos.add(nuevoPrestamo);
        libroEncontrado.setDisponible(false);

        System.out.println("Préstamo realizado exitosamente.");
    }
}