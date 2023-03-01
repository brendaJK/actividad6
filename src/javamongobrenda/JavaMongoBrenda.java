
package javamongobrenda;

/**
 *
 * @author Brenda Gutierrez 
 */
public class JavaMongoBrenda {

    public static void main(String[] args) {
        
     Conection conexion = new Conection();
     
     conexion.mostrar();
     conexion.insertar("Acampar");
     System.out.println("Siguiente Registro");
     conexion.mostrar();
     System.out.println("Siguiente");
     conexion.actualizar("Conferencia", "Caminata");
     conexion.mostrar();
    
    }
    
}
