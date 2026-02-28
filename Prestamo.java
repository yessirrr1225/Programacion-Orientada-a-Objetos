public class Prestamo {

    private Usuario usuario;
    private Libro libro;

    public Prestamo(Usuario usuario, Libro libro) {
        this.usuario = usuario;
        this.libro = libro;
    }

    @Override
    public String toString() {
        return "Usuario: " + usuario.getId() +
               ", Libro: " + libro.getIsbn();
    }
}