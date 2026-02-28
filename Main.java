import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Biblioteca biblioteca = new Biblioteca();

        int opcion;

        do {
            System.out.println("\n===== SISTEMA BIBLIOTECA =====");
            System.out.println("1. Agregar Libro");
            System.out.println("2. Agregar Usuario");
            System.out.println("3. Realizar Préstamo");
            System.out.println("4. Mostrar Libros");
            System.out.println("5. Mostrar Usuarios");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = Integer.parseInt(sc.nextLine());

            switch (opcion) {

                case 1:
                    System.out.print("ID del libro: ");
                    String isbn = sc.nextLine();

                    System.out.print("Título: ");
                    String titulo = sc.nextLine();

                    System.out.print("Autor: ");
                    String autor = sc.nextLine();

                    Libro libro = new Libro(isbn, titulo, autor);
                    biblioteca.agregarLibro(libro);
                    break;

                case 2:
                    System.out.print("Matrícula/ID(solo números): ");
                    String id = sc.nextLine();

                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();

                    System.out.print("Tipo (1=Alumno, 2=Docente): ");
                    int tipo = Integer.parseInt(sc.nextLine());

                    Usuario usuario;

                    if (tipo == 1) {
                        usuario = new Alumno(id, nombre);
                    } else {
                        usuario = new Docente(id, nombre);
                    }

                    biblioteca.agregarUsuario(usuario);
                    break;

                case 3:
                    biblioteca.realizarPrestamo(sc);
                    break;

                case 4:
                    biblioteca.mostrarLibros();
                    break;

                case 5:
                    biblioteca.mostrarUsuarios();
                    break;

                case 6:
                    System.out.println("Saliendo del sistema.");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }

        } while (opcion != 6);

        sc.close();
    }
}