/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RestService;

import Kafka.Consumer;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import Kafka.Productor;


/**
 *
 * @author rafael
* Reglas para la URI
* 1. Debe tener minimo 11 caracteres
* 2. Los caracteres deben ser solo números
* 3. Las funciones deben ser mayores de cero
* 4. Los servicios deben ser mayores de cero
* 5. 
*/




@Path("public")
public class Rest {

//    kafcaRemote kafca = lookupkafcaRemote();

    
    String OK="200";
    String NOK="500 codigo no reconocido";

    
    @GET @Path("{path:.*}")
    @Produces({"text/html"})
    public String operar(@PathParam("path") String path) {

    String Respuesta="";    
    String salida=validaCodigo(path);

     if(salida.equals(OK)){        
     Productor p= new Productor();    
     p.producir(path);
     Consumer c= new Consumer();
     Respuesta=c.consumirMsg();
    }
    

    return salida;
    }

    
private String validaCodigo(String path){

    return (longitudMinima(path) && !tieneCaracteres(path) && esfuncionvalida(path) && esServicioValido(path) && esfacturaValida(path))?OK:NOK;
}    
    
    

private boolean longitudMinima(String path){
     return (path.length() >= 9);
}
private boolean tieneCaracteres(String path){

    String abcdario="abcdefghijklmnopqrstuvwxyz";
    String ABCDARIO="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    boolean respuesta=false;
            
    char [] mvocales= abcdario.toCharArray();
    char [] MVOCALES=ABCDARIO.toCharArray();
   
    for(int a=0; a< mvocales.length; a++){
       respuesta  = (path.indexOf(mvocales[a]) > 0);
       if(respuesta)
           break;
    }
    if(!respuesta)
          for(int a=0; a< MVOCALES.length; a++){
                respuesta  = (path.indexOf(MVOCALES[a]) > 0);
                if(respuesta)
                   break;
           }
    
    
   return respuesta;
}
private boolean esfuncionvalida(String path){
   return (Integer.parseInt(path.substring(0,1)) > 0);
}
private boolean esServicioValido(String path){
    return (Integer.parseInt(path.substring(2,6)) > 0);
}    
private boolean esfacturaValida(String path){
      return (Integer.parseInt(path.substring(7,path.length()-1)) > 0) && (path.substring(7,path.length()-1).length() >=4 );
}

 

}
