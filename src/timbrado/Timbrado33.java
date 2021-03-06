/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timbrado;

import java.io.*;
import wsconnectionfm.WSConecFM;

public class Timbrado33 {
    
    public static void main(String[] args) throws IOException {
    // TODO code application logic here
    WSConecFM connect = new WSConecFM();
    /* Configurar las variables de conexion
     * puede cambiar:
     * 1.- Url de conexion con soap
     * 2.- Usuario de conexion
     * 3.- Contraseña de Usuario
     * 4.- Indicar si desea generar el pdf
     * 5.- Indicar si desea generar el txt
     * 6.- Indicar si desea genera el cbb (Activarlo, desactiva generar pdf)
     */
    connect.setRfcEmisor("TUMG620310R95");
    String pathdir = System.getProperty("user.dir");

    /* EL parametro enviado al metodo timbrar puede ser:
     * un archivo xml, un layot txt o un string que contenga el xml
     */
    String r = connect.timbrar(pathdir+"/ejemplos/ejemploTimbrado33.xml");

    if (connect.error) {
      System.out.println(r);
    }
    else {
      String xml = new String(new sun.misc.BASE64Decoder().decodeBuffer(connect.strXml));
      try {
          File archivo = new File(pathdir+"/resultados/ejemploXML_CFDI33.xml");
          FileWriter escribir = new FileWriter(archivo);
          escribir.write(xml);
          escribir.close();
        }
        catch(Exception e) {
          System.out.println(e.getMessage().toString());
      }
      if (connect.generarPDF) {
        OutputStream out;
        try {
          byte[] b = new sun.misc.BASE64Decoder().decodeBuffer(connect.strPdf);
          out = new FileOutputStream(pathdir+"/resultados/ejemploPDF_CFDI33.pdf");
          out.write(b, 0, b.length);
          out.close();
        }catch (Exception e) {
          System.out.println(e);
        }
      }
      if (connect.generarCBB) {
        OutputStream out;
        try {
          byte[] b = new sun.misc.BASE64Decoder().decodeBuffer(connect.strCbb);
          out = new FileOutputStream(pathdir+"/resultados/ejemploCBB_CFDI33.png");
          out.write(b, 0, b.length);
          out.close();
        }catch (Exception e) {
          System.out.println(e);
        }
      }
      if (connect.generarTXT) {
        String txt = new String(new sun.misc.BASE64Decoder().decodeBuffer(connect.strTxt));
        try {
          File archivo = new File(pathdir+"/resultados/ejemploTXT_CFDI33.txt");
          FileWriter escribir = new FileWriter(archivo);
          escribir.write(txt);
          escribir.close();
        }
        catch(Exception e) {
          System.out.println(e.getMessage().toString());
        }
      }
      System.out.println(r);
      System.out.println("El comprobante lo encuentra en: "+pathdir+"/resultados/");
    }
  }
    
}
