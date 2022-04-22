/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coop_archivos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author Edison
 */
public class FileWR {
      
    public static void writefile(List<Producto> productos, String filename){
    		try {
                    
			FileOutputStream outputStream = new FileOutputStream(filename);
			OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, "UTF-16");
			BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
                                        System.out.println("ID + NOMBRE + APELLIDO +      FECHA REGISTRO      +   CORREO   +   ACTIVO (1:SI/2:NO) + ROL + IDENTIFICACION");
            for (int a=0; a < productos.size(); a++) { 
bufferedWriter.write(productos.get(a).TipoProducto+"{"+productos.get(a).Producto+"{"+productos.get(a).NombreProducto+"{"+productos.get(a).Saldo+"{");
			
            }

                        bufferedWriter.newLine();
                        
                        
			bufferedWriter.close();
                      
		} catch (IOException e) {
			e.printStackTrace();
		}
    
    }
    public static List<Producto> readfile(String filename){
    List<Producto> fileproductslist = new ArrayList<Producto>();
    
    		try {
			FileReader reader = new FileReader("users.txt");
			BufferedReader bufferedReader = new BufferedReader(reader);

			String line;

			while ((line = bufferedReader.readLine()) != null) {
                                Producto product = new Producto();
                                String[] arr = line.toLowerCase().split("{");
                                
                                product.TipoProducto = arr[0].replace("-", "");
                                product.Producto = arr[1].replace("-", "");
                                product.NombreProducto = arr[2].replace("-", "");
                                product.Saldo = arr[3].replace("-", "");
                                fileproductslist.add(product);
				System.out.println(line);
			}
			reader.close();

		} catch (IOException e) {
			e.printStackTrace();
		}    
    
    return fileproductslist;
    }
    
    public static void writeerrorfile(String error){
    
    
    }

}
