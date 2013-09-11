/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cancelado;

/**
 *
 * @author Arango
 */
import wsconnectionfm.WSConecFM;

public class Cancelacion {
  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    String uuid = "F8EEFFAA-C74E-4DF7-BE66-A9C340756E5A";

    // Creamos la instancia a la clase WSConecFM
    WSConecFM connect = new WSConecFM();

    // Configuramos el valor del RFC
    connect.setRfcEmisor("TUMG620310R95");

    String r = connect.cancelar(uuid);

    System.out.println(r);

  }
}
