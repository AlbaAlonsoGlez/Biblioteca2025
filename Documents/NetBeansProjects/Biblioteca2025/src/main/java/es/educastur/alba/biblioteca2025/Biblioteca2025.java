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
    
    public Biblioteca2025() {
        this.libros = new ArrayList();
        this.usuarios = new ArrayList();
        this.prestamos = new ArrayList();
    }
    
    public static void main(String[] args) {
        Biblioteca2025 b= new Biblioteca2025();
        b.cargaDatos();
    }

    //<editor-fold defaultstate="collapsed" desc="MENÚS">
    private void menu() {
        Scanner sc= new Scanner(System.in);
        int opcion=0;
        do {
            System.out.println("LIBROS");
            System.out.println("USUARIOS");
            System.out.println("PRÉSTAMOS");
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
            }
        } while (opcion != 9);
    }

    
    private void menuLibros() {
        Scanner sc= new Scanner(System.in);
        int opcion=0;
        do {
            System.out.println("LIBROS");
            System.out.println("NUEVO LIBRO");
            System.out.println("ELIMINAR LIBRO");
            System.out.println("MODIFICAR LIBRO");
            System.out.println("LISTADOS");
            System.out.println("SALIR");
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
            System.out.println("NUEVO USUARIO");
            System.out.println("ELIMINAR USUARIO");
            System.out.println("MODIFICAR USUARIO");
            System.out.println("USUARIOS");
            System.out.println("SALIR");
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
                    modificarUsuario();
                    break;
                }
                case 4: {
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
            System.out.println("NUEVO PRÉSTAMO");
            System.out.println("ELIMINAR PRÉSTAMO");
            System.out.println("MODIFICAR PRÉSTAMO");
            System.out.println("PRÉSTAMOS");
            System.out.println("SALIR");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1: {
                    nuevoPrestamo();
                    break;
                }
                case 2: {
                    eliminarPrestamo();
                    break;
                }
                case 3: {
                    modificarPrestamo();
                    break;
                }
                case 4: {
                    listadoPrestamo();
                    break;
                }
            }
        } while (opcion != 9);
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="GESTIÓN LIBROS">
    private void nuevoLibro() {
       
    }
    
    private void eliminarLibro() {
       
    }

    private void modificarLibro() {
        
    }
    
    private void listadoLibro() {
        
    }
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="GESTIÓN USUARIOS">
    private void nuevoUsuario() {
        
    }

    private void eliminarUsuario() {
      
    }

    private void modificarUsuario() {
       
    }

    private void listadoUsuario() {
        
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="GESTIÓN PRÉSTAMOS">
    private void nuevoPrestamo() {
        
    }

    private void eliminarPrestamo() {

    }

    private void modificarPrestamo() {

    }

    private void listadoPrestamo() {

    }
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="MÉTODOS AUXILIARES">
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
        prestamos.add(new Prestamo(libros.get(2),usuarios.get(0), hoy,hoy.plusDays(15)));
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
