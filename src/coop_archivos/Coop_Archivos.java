/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coop_archivos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Edison
 */
public class Coop_Archivos {

    /**
     * @param args the command line arguments
     */
    static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println(" --- ARCHIVOS BANCARIOS--- ");
        System.out.println("Lectura / escritura de archivos TXT ");
        mainmenu();
        
    }
    
            private static void mainmenu(){
                int y = 0;
            while (y != 3)
            {
                System.out.println("");
                System.out.println("-- Menú --");
                System.out.println("Escribir todos los registros del archivo txt..........................1");
                System.out.println("Listar registros en un nuevo archivo txt .........................2");
                System.out.println("Salir...............................................................3");
                
                y = getconsolenumber();

                switch (y)
                {
                    case 0:
                        System.out.println("Opcion no valida");
                        break;
                    case 1:
                        String a = "s";
                        List<Producto> fileproductslist = new ArrayList<Producto>();
                        
                        while (!a.equals("n")){
                         Producto nuevopro = getnewuserdata();
                    
                        if (validate_data(nuevopro)){
                            fileproductslist.add(nuevopro);
                            FileWR.writefile(fileproductslist, "PROD201705.txt");
                        }else{
                        System.out.println("Los datos ingresados no son validos!");
                        }
                        System.out.println("¿Desea agregar otro producto S/N?");
                        a = sc.next().toLowerCase();
                        }
                        break;
                    case 2:
                        break;
                    case 3:
                        System.out.println("El programa ha finalizado!");
                        break;                        
                    default:
                        System.out.println("opción no valida");
                        break;
                }
            
            }
        }
        private static int getconsolenumber(){
                int valorconsola = 0;
                Scanner sc = new Scanner(System.in);
                try
                {
                    valorconsola = sc.nextInt();
                    return valorconsola;
                }
                catch (Exception e)
                {
                    valorconsola = -1;
                    return valorconsola;
                }
    }
        
        private static boolean validate_data(Producto product){
            boolean iscorrect = true;
            if (product.TipoProducto.isEmpty() || product.TipoProducto.equals("")){
                FileWR.writeerrorfile("EO1 - CAMPO TIPO PRODUCTO NO PUEDE SER VACÍO");
                iscorrect = false;
            }
            else if (product.Producto.isEmpty() || product.Producto.equals("")){
                FileWR.writeerrorfile("EO2 - CAMPO PRODUCTO NO PUEDE SER VACÍO");
                iscorrect = false;
            }
            else if (product.NombreProducto.isEmpty() || product.NombreProducto.equals("")){
                FileWR.writeerrorfile("EO3 - CAMPO NOMBRE DE PRODUCTO NO PUEDE SER VACÍO");
                iscorrect = false;
            }
            else if (product.Saldo.isEmpty() || product.Saldo.equals("")){
                FileWR.writeerrorfile("EO4 - CAMPO SALDO NO PUEDE SER VACÍO");
                iscorrect = false;
            }
            else if(product.Saldo.length() != 17){
                FileWR.writeerrorfile("EO5 - CAMPO SALDO NO TIENE LA LONGITUD CORRECTA DE 17 DIGITOS");
                iscorrect = false;
            }
            
            try{
                  product.Saldoft = Float.parseFloat(product.Saldo);
               }catch(Exception e){
                FileWR.writeerrorfile("EO5 - CAMPO SALDO NO TIENE FORMATO NUMERICO CORRECTO");
                iscorrect = false;
            }
            return iscorrect;
        }
     
        private static Producto getnewuserdata(){
            try{
            
            Producto _productdata = new Producto();
            System.out.println("Ingrese los datos del nuevo producto");
            System.out.print("Tipo de producto: ");
            _productdata.TipoProducto = sc.next();
            System.out.println("");
            System.out.print("Producto: ");
            _productdata.Producto = sc.next();
            System.out.println("");
            System.out.print("Nombre del producto: ");
            _productdata.NombreProducto = sc.next();
            System.out.println("");
            System.out.print("Saldo (17 digitos obligatorio): ");
            _productdata.Saldo = sc.next();
             //System.out.println("");
            return _productdata;
            }
            catch (Exception e){
                System.out.print("Los datos ingresados no cumplen con el formato");
                //write error file
                return null;
            }
    }
}
