/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javamongobrenda;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.Mongo;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author esbre
 */
public class Conection {
    
    DB baseDatos;
    DBCollection coleccion;
    BasicDBObject document = new BasicDBObject();
    
    
    public Conection (){
        Mongo mongo = new Mongo("localhost",27017);
        baseDatos = mongo.getDB("Actividad6");
        coleccion = baseDatos.getCollection("Actividad6");
        System.out.println("Conexion exitosa");
}
    
    public boolean insertar(String actividad){
        
        document.put("actividad", actividad);
        coleccion.insert(document);
        
        return true;
    } 
    
    public void mostrar(){
        
        DBCursor cursor = coleccion.find();
        
        while(cursor.hasNext()){
        
            System.out.println(cursor.next());
        }
        
    }
    
    public boolean actualizar(String actividadAnterior, String actividadNueva){
        
        document.put("actividadAnterior", actividadAnterior);
        BasicDBObject documentoNuevo = new BasicDBObject();
        documentoNuevo.put("actividadNueva",actividadNueva);
        coleccion.findAndModify(document, documentoNuevo);
        
        return true;
    }
    
    public boolean eliminar(String actividad){
        document.put("actividad", actividad);
        coleccion.remove(document);
        return true;
    }
    
}
