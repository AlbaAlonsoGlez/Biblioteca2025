/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package es.educastur.alba.biblioteca2025;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author alu01d
 */
public class Biblioteca2025 {

    private ArrayList <Libro> libros;
    private ArrayList <Usuario> usuarios;
    private ArrayList <Prestamo> prestamos;
    private ArrayList <Prestamo> prestamosHist;
    
    public Biblioteca2025() {
        this.libros = new ArrayList();
        this.usuarios = new ArrayList();
        this.prestamos = new ArrayList();
        this.prestamosHist = new ArrayList();
    }
    
    public static void main(String[] args) {
        Biblioteca2025 b= new Biblioteca2025();
        b.cargaDatos();
        b.fueraPlazo();
        b.menu();
    }

    //<editor-fold defaultstate="collapsed" desc="MENÚS">
    private void menu() {
        Scanner sc= new Scanner(System.in);
        int opcion=0;
        do {
            System.out.println("1. LIBROS");
            System.out.println("2. USUARIOS");
            System.out.println("3. PRÉSTAMOS");
            System.out.println("4. LISTADOS");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1: {
                    menuLibros();
                    break;
                }
                case 2: {
                    menuUsuarios();
                    break;
                }
                case 3: {
                    menuPrestamos();
                    break;
                }
                case 4: {
                    menuListados();
                    break;
                }
            }
        } while (opcion != 9);
    }

    
    private void menuLibros() {
        Scanner sc= new Scanner(System.in);
        int opcion=0;
        do {
            System.out.println("LIBROS");
            System.out.println("1. NUEVO LIBRO");
            System.out.println("2. ELIMINAR LIBRO");
            System.out.println("3. MODIFICAR LIBRO");
            System.out.println("4. LISTADO DE LIBROS");
            System.out.println("9. SALIR");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1: {
                    nuevoLibro();
                    break;
                }
                case 2: {
                    eliminarLibro();
                    break;
                }
                case 3: {
                    modificarLibro();
                    break;
                }
                case 4: {
                    listadoLibro();
                    break;
                }
            }
        } while (opcion != 9);
    }
    
    private void menuUsuarios() {
        Scanner sc= new Scanner(System.in);
        int opcion=0;
        do {
            System.out.println("USUARIOS");
            System.out.println("1. NUEVO USUARIO");
            System.out.println("2. ELIMINAR USUARIO");
            System.out.println("3. LISTADO DE USUARIOS");
            System.out.println("9. SALIR");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1: {
                    nuevoUsuario();
                    break;
                }
                case 2: {
                    eliminarUsuario();
                    break;
                }

                case 3: {
                    listadoUsuario();
                    break;
                }
            }
        } while (opcion != 9);
    }
    
    private void menuPrestamos() {
        Scanner sc= new Scanner(System.in);
        int opcion=0;
        do {
            System.out.println("PRÉSTAMOS");
            System.out.println("1. NUEVO PRÉSTAMO");
            System.out.println("2. DEVOLVER PRÉSTAMO");
            System.out.println("3. PRÓRROGA DE PRÉSTAMOS");
            System.out.println("4. LISTADO GENERAL DE PRÉSTAMOS");
            
            System.out.println("9. SALIR");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1: {
                    nuevoPrestamo();
                    break;
                }
                case 2: {
                    devolverPrestamo();
                    break;
                }
                case 3: {
                    prorrogaPrestamo();
                    break;
                }
                case 4: {
                    listadoPrestamo();
                    break;
                }
             
            }
        } while (opcion != 9);
    }
    private void menuListados() {
        Scanner sc= new Scanner(System.in);
        int opcion=0;
        do {
            System.out.println("PRÉSTAMOS");
            System.out.println("1. LISTADO DE PRÉSTAMOS-USUARIOS");
            System.out.println("2. LISTADO DE PRÉSTAMOS-LIBROS");
            System.out.println("3. LIBRO MÁS PRESTADO");
            System.out.println("4. USUARIO CON MÁS PRÉSTAMOS");
            System.out.println("9. SALIR");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1: {
                    listadoPrestamoUsu();
                    break;
                }
                case 2: {
                    listadoPrestamoLib();
                    break;
                }
                case 3: {
                    libroMasPrestado();
                    break;
                }
                case 4: {
                    usuarioMasPrestamos();
                    break;
                }
             
            }
        } while (opcion != 9);
    }
   
    
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="GESTIÓN LIBROS">
    private void nuevoLibro() {
       String isbn, titulo, autor, genero;
       int ejemplares;
        Scanner sc=new Scanner (System.in);
        System.out.println("NUEVO LIBRO");
        isbn=solicitaIsbn();
        System.out.println("Escribe el título del libro");
        titulo = sc.nextLine();
        System.out.println("Escribe el autor del libro");
        autor = sc.nextLine();
        System.out.println("Indica el género del libro");
        genero = sc.nextLine();
        System.out.println("Indica el número de ejemplares del libro");
        ejemplares=sc.nextInt();
        
        libros.add(new Libro(isbn, titulo, autor, genero, ejemplares));
        System.out.println("El libro ha sido creado :D");
    }
    
    private void eliminarLibro() {
        Scanner sc=new Scanner (System.in);
        String isbn=solicitaIsbn();
        int pos = buscaIsbn(isbn);
        if (pos==-1) {
            System.out.println("El libro que buscas no existe");
        } else {
            libros.remove(pos);
        }
    }

    private void modificarLibro() {
        System.out.println("Escribe el isbn del libro a modificar");
         Scanner sc=new Scanner (System.in);
         String nombre= sc.nextLine();
         int posicion = buscaIsbn(nombre);
         
         if (posicion==-1) {
             System.out.println("El isbn del libro que buscas no se encuentra en la biblioteca");
         } else {
             System.out.println("Si quieres añadir ejemplares (+), si quieres restar ejemplares (-): ");
             int agrego = sc.nextInt();
             if (agrego>=1) {
                 libros.get(posicion).setEjemplares(libros.get(posicion).getEjemplares()+agrego);
             } else  {
                 libros.get(posicion).setEjemplares(libros.get(posicion).getEjemplares()+agrego);
             }
             System.out.println("El libro ha sido modificado :D");
         }
    }
    
    private void listadoLibro() {
        for (Libro l : libros) {
            System.out.println(l);
        }
    }
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="GESTIÓN USUARIOS">
    private void nuevoUsuario() {
        String dni, nombre, email, telefono;
        Scanner sc=new Scanner (System.in);
        System.out.println("NUEVO USUARIO");
        dni=solicitaDni();
        System.out.println("Escribe el nombre del usuario");
        nombre = sc.nextLine();
        do{
            System.out.println("Escribe el email del usuario:");
            email=sc.next();
        }while(!email.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"));         
        do{
            System.out.println("Escribe el teléfono del usuario:");
            telefono=sc.next();
        }while(!telefono.matches("[6-7][0-9]{8}"));
        
        usuarios.add(new Usuario(dni, nombre, email, telefono));
        System.out.println("El usuario ha sido creado :D");
    }

    private void eliminarUsuario() {
        Scanner sc=new Scanner (System.in);
        String dni=solicitaDni();
        int pos = buscaDni(dni);
        if (pos==-1) {
            System.out.println("El usuario que buscas no existe");
        } else {
            usuarios.remove(pos);
        }
    }

    private void listadoUsuario() {
        for (Usuario u : usuarios) {
            System.out.println(u);
        }
    }  
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="GESTIÓN PRÉSTAMOS">
    private void nuevoPrestamo() {
        System.out.println("Identificación del usuario");
        String dni=solicitaDni();
        int posUsuario=buscaDni(dni);
        if (posUsuario==-1) {
            System.out.println("Aún no es usuario de la biblioteca :(");
        } else {
            System.out.println("Identificación del libro:");
            String isbn= solicitaIsbn();
            int posLibro=buscaIsbn(isbn);
            if (posLibro==-1) {
                System.out.println("El ISBN pertenece a un libro que no tenemos");
            } else if  (libros.get(posLibro).getEjemplares()>0) {
                if ((buscaPrestamo(dni, isbn))==-1) {
                LocalDate hoy=LocalDate.now();
                prestamos.add(new Prestamo(libros.get(posLibro),usuarios.get(posUsuario),hoy,hoy.plusDays(15)));
                libros.get(posLibro).setEjemplares(libros.get(posLibro).getEjemplares()-1);
                } else {
                    System.out.println("Este usuario ya tiene este libro en préstamo");
                }
            } else {
                System.out.println("No quedan unidades disponibles de este libro :( ");
            }
        }
    }

    private void devolverPrestamo() {
        System.out.println("Datos del préstamo: ");
        String isbnLibro=solicitaIsbn();
        int pos=buscaPrestamo(solicitaDni(),isbnLibro);
        if (pos==-1){
            System.out.println("No hay ningún préstamo con esos datos");
        }else{
            prestamos.get(pos).setFechaDev(LocalDate.now());
            libros.get(buscaIsbn(isbnLibro))
              .setEjemplares(libros.get(buscaIsbn(isbnLibro)).getEjemplares()+1);
                prestamosHist.add(prestamos.get(pos));
                prestamos.remove(pos);
            }
            System.out.println("La devolucióbn ha sido hecha :D");
    }

    private void prorrogaPrestamo() {
        System.out.println("Datos para la prórroga del préstamo: ");
        int pos= buscaPrestamo(solicitaDni(), solicitaIsbn());
        if (pos==-1) {
            System.out.println("No hay préstamos con los datos indicados :(");
        } else {
            prestamos.get(pos).setFechaDev(prestamos.get(pos).getFechaDev().plusDays(15));
            prestamos.get(pos).setFechaDev(LocalDate.now());
        }
        System.out.println("El préstamo ha sido modificado :D");
    }

    private void listadoPrestamo() {
       System.out.println("Listado de préstamos activos: ");
       for (Prestamo p : prestamos) {
           if (p.getFechaDev().isBefore(LocalDate.now())) {
                System.out.print("Este libro está fuera de plazo: ");
           }
           System.out.println(p);
        }
       System.out.println("Listado de préstamos históricos: ");
       for (Prestamo ph : prestamosHist) {
           System.out.println(ph);
       }
    }
    
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="LISTADOS">
    
        private void listadoPrestamoUsu() {
        String dni= solicitaDni();
        int pos=buscaDni(dni);
        if (pos==-1) {
            System.out.println("No hay ningún usuario con ese DNI :(");
        } else {
            System.out.println("Listado de préstamos activos del usuario " + usuarios.get(pos).getNombre()); 
            for (Prestamo p : prestamos) {
               if (p.getUsuarioPrest().getDni().equals(dni)) {
                   if (p.getFechaDev().isBefore(LocalDate.now())) {
                       System.out.print("Este libro está fuera de plazo: ");
                   }
                   System.out.println(p);
               }
            }
            System.out.println("Listado de préstamos históricos del usuario " + usuarios.get(pos).getNombre()); 
            for (Prestamo ph : prestamosHist) {
               if (ph.getUsuarioPrest().getDni().equals(dni)) {
               System.out.println(ph);    
               }
            }
        }
    }
    
    private void listadoPrestamoLib() {
        String isbn = solicitaIsbn();
        int pos=buscaIsbn(isbn);
        if (pos==-1) {
            System.out.println("El libro no se ha encontrado :(");
        } else {
            for (Prestamo p : prestamos) {
                if (p.getLibroPrest().getIsbn().equals(isbn)) {
                    System.out.println(p.getUsuarioPrest());
                }
            }
        }
        
        System.out.println("Usuarios que ya han leído el libro");
        for (Prestamo ph : prestamosHist) {
                if (ph.getLibroPrest().getIsbn().equals(isbn)) {
                    System.out.println(ph.getUsuarioPrest());
                }
            }
    }
    
    private void libroMasPrestado() {
        ArrayList <Integer> contadoresLibros=new ArrayList();
        int contador;
        for (Libro l : libros) {
            contador = 0;
            for (Prestamo p : prestamos) {
                if (l==p.getLibroPrest()) {
                    contador ++;
                }
            }
            for (Prestamo ph : prestamosHist) {
                if (l==ph.getLibroPrest()) {
                    contador ++;
                }
            } 
            contadoresLibros.add(contador);
         }
         int maxLibros=0;
            for (int c:contadoresLibros) {
                if (c>maxLibros) {
                    maxLibros=c;
                }
            }
        System.out.println("El libro más prestado de la biblioteca con " + maxLibros + " préstamos es: " );
        for (int i = 1; i < libros.size(); i++) {
            if (contadoresLibros.get(i)==maxLibros) {
                    System.out.println("'" + libros.get(i) + "'");
            }
        }
    }
                
    private void usuarioMasPrestamos() {
    ArrayList <Integer> contadoresUsuarios=new ArrayList();
        int contador;
        for (Usuario u : usuarios) {
            contador=0;
            for (Prestamo p:prestamos) {
                if (u==p.getUsuarioPrest()){
                    contador++;
                }
            }
            for (Prestamo p:prestamosHist) {
                if (u==p.getUsuarioPrest()){
                    contador++;
                }
            }
            contadoresUsuarios.add(contador);
        }
        
        int max=0;
        for (int c:contadoresUsuarios){
            if (c>max){
                max=c;
            }
        }
        System.out.println("Los usuarios/as mas lectores/as con " + max + " prestamos son: " );
               
        for (int i = 0; i < contadoresUsuarios.size(); i++) {
            if (contadoresUsuarios.get(i)==max){
                System.out.println(usuarios.get(i));
            }
        }
    }               
    
    /** OTRA FORMA DE HACERLO SIN USAR ARRAYS:
        private void libroMasPrestado() {
        int prestamosMax = 0;
        Libro libroMasPrestado = null;
        for (Libro l : libros) {
            int contador = 0;
            for (Prestamo p : prestamos) {
                if (p.getLibroPrest().getIsbn().equals(l.getIsbn())) {
                    contador ++;
                }
            }
            for (Prestamo ph : prestamosHist) {
                if (ph.getLibroPrest().getIsbn().equals(l.getIsbn())) {
                    contador ++;
                }
            }
            if (contador > prestamosMax) {
                prestamosMax = contador;
                libroMasPrestado = l;
            }
        }
        if (libroMasPrestado!=null) {
            System.out.println("El libro más prestado de la biblioteca es " + "'" + libroMasPrestado.getTitulo() + "'" + " con " + prestamosMax + " préstamos" );
        } else {
            System.out.println("No se han registrado préstamos :(");
        }
    }
    
    private void usuarioMasPrestamos() {
        int prestamosMax = 0;
        Usuario usuarioMasPrestamos = null;
        for (Usuario u : usuarios) {
            int contador = 0;
            for (Prestamo p : prestamos) {
                if (p.getUsuarioPrest().getDni().equals(u.getDni())) {
                    contador++;
                }
            }
            for (Prestamo p: prestamosHist) {
                if (p.getUsuarioPrest().getDni().equals(u.getDni())) {
                    contador++;
                }
            }
            if (contador > prestamosMax) {
                prestamosMax = contador;
                usuarioMasPrestamos = u;
            }
        }
        if (usuarioMasPrestamos!=null) {
            System.out.println("El usuario con más préstamos de la biblioteca es " + usuarioMasPrestamos.getNombre() + " con " + prestamosMax + " préstamos");
        } else {
            System.out.println("No se han registrado préstamos :(");
        }
    }
    */ 
    
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="MÉTODOS AUXILIARES">
    /**
     * Método que muestra qué libros se encuentran fuera de plazo
     */
    public void fueraPlazo() {
        System.out.println("Présamos fuera de plazo: ");
        for (Prestamo p : prestamos) {
           if (p.getFechaDev().isBefore(LocalDate.now())) {
               System.out.println(p);;
           } 
        }
    }
    
    /**
     * Método que solicita al usuario un String
     * @return (String) dni
     */
    public String solicitaDni() {
        Scanner sc=new Scanner(System.in);
        System.out.println("Teclea el DNI del usuario");
        String dni=sc.next();
        return dni;
    }
    
    /**
     * Método que solicita al usuario un String
     * @return (String) isbn
     */
    public String solicitaIsbn() {
        Scanner sc=new Scanner(System.in);
        System.out.println("Teclea el ISBN del libro");
        String isbn=sc.next();
        return isbn;
    }
    
    /**
     * Método para buscar un dni en la colección usurios
     * @param dni (String) del usuario a busca en la colección
     * @return int posición del suusrio en el Arraylist, valor -1 si no se encuentra
     */
    public int buscaDni(String dni) {
        int pos=-1;
        for (int i = 0; i < usuarios.size(); i++) {
            if(usuarios.get(i).getDni().equals(dni)) {
                pos=i;
                break;
            }
        }
        return pos;
    }
    
    /**
     * Método para buscar un isbn en la colección libros
     * @param isbn (String) del libro a buscar en la colección
     * @return int posición del lbiro en el Arraylist, valor -1 si no se encuentra
     */
    public int buscaIsbn(String isbn) {
        int pos=-1;
        for (int i = 0; i < libros.size(); i++) {
            if(libros.get(i).getIsbn().equals(isbn)) {
                pos=i;
                break;
            }
        }
        return pos;
    }
    
    public int buscaPrestamo (String dni, String isbn) {
        int pos=-1;
        for (int i = 0; i < prestamos.size(); i++) {
            if(prestamos.get(i).getUsuarioPrest().getDni().equals(dni) && prestamos.get(i).getLibroPrest().getIsbn().equals(isbn)) {
                pos=i;
                break;
            }
        }return pos;
    }
    
    public void cargaDatos(){
        libros.add(new Libro("1-11","El Hobbit","JRR Tolkien","Aventuras",3)); 
        libros.add(new Libro("1-22","El Silmarillon","JRR Tolkien","Aventuras",3)); 
        libros.add(new Libro("1-33","El Médico","N. Gordon","Aventuras",4)); 
        libros.add(new Libro("1-44","Chamán","N. Gordon","Aventuras",3)); 
        libros.add(new Libro("1-55","Momo","M. Ende","Aventuras",2)); 
        libros.add(new Libro("1-66","Paraíso inhabitado","A.M.Matute","Aventuras",2)); 
        libros.add(new Libro("1-77","Olvidado Rey Gudú","A.M.Matute","Aventuras",2)); 
        libros.add(new Libro("1-88","El último barco","D.Villar","Novela Negra",3)); 
        libros.add(new Libro("1-99","Ojos de agua","D.Villar","Novela Negra",2)); 

        usuarios.add(new Usuario("11","Ana","ana@email.com","621111111")); 
        usuarios.add(new Usuario("22","David","david@email.com","622222222")); 
        usuarios.add(new Usuario("33","Bea","bea@email.com","623333333")); 
        usuarios.add(new Usuario("44","Lucas","lucas@email.com","624444444")); 
        usuarios.add(new Usuario("55","Carlota","carlota@email.com","625555555")); 
        usuarios.add(new Usuario("66","Juan","juan@email.com","626666666"));
        
        LocalDate hoy= LocalDate.now();
        prestamos.add(new Prestamo(libros.get(2),usuarios.get(0), hoy.minusDays(12),hoy.plusDays(3)));
        prestamos.add(new Prestamo(libros.get(8),usuarios.get(2), hoy,hoy.plusDays(15)));
        prestamos.add(new Prestamo(libros.get(5),usuarios.get(4), hoy,hoy.plusDays(15)));
        prestamos.add(new Prestamo(libros.get(5),usuarios.get(0), hoy,hoy.plusDays(15)));
        prestamos.add(new Prestamo(libros.get(6),usuarios.get(2), hoy,hoy.plusDays(15)));
        prestamos.add(new Prestamo(libros.get(2),usuarios.get(1), hoy,hoy.plusDays(15)));
    
        for (Libro l:libros) {
            System.out.println(l);
        }
        System.out.println("");
        for (Usuario u:usuarios) {
            System.out.println(u);
        }
        System.out.println("");
        for (Prestamo p:prestamos) {
            System.out.println(p);
        }
    }
//</editor-fold>

}
