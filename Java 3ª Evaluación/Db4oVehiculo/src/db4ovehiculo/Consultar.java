
package db4ovehiculo;

import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Query;
import java.util.ArrayList;
import objetos.Camion;
import objetos.Vehiculo;
/**
 *
 * @author David
 */
public class Consultar {
    
    public static Vehiculo obtenerVehiculoPorMatricula(ObjectContainer baseDatos, String matricula){
        Vehiculo vehiculo = null;
        Query query = baseDatos.query();
        query.constrain(Vehiculo.class);
        query.descend("matricula").constrain(matricula);
        ObjectSet resultado = query.execute();
        while (resultado.hasNext()){
            vehiculo = (Vehiculo)resultado.next();
        }
        return vehiculo;       
    }
    
    public static boolean existeVehiculoPorMatricula(ObjectContainer baseDatos, String matricula){
        return obtenerVehiculoPorMatricula(baseDatos, matricula) !=null;
    }
    
    public static ArrayList<Camion> obtenerCamionesPorPrecio(ObjectContainer baseDatos, float precio){
        ArrayList<Camion> camiones = new ArrayList<>();
        Camion camion = new Camion(null, null, precio, 0, null);
        ObjectSet resultado = baseDatos.queryByExample(camion);
        while(resultado.hasNext()){
            camiones.add((Camion)resultado.next());
        }
        return camiones;
    }
    
    public static ArrayList<Vehiculo> obtenerVehiculosDeUnPropietario(ObjectContainer baseDatos, String propietario){
        ArrayList<Vehiculo> vehiculos = new ArrayList<>();
        Query query = baseDatos.query();
        query.constrain(Vehiculo.class);
        query.descend("propietario").constrain(propietario);   
        query.descend("matricula").orderAscending();
        ObjectSet resultado = query.execute();
        while(resultado.hasNext()){
            vehiculos.add((Vehiculo)resultado.next());
        }
        return vehiculos;
    }
}
