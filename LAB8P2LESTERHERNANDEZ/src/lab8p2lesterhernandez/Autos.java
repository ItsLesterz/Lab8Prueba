/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab8p2lesterhernandez;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 * @author Daniel
 */
public class Autos {
    RandomAccessFile carrito;
    public Autos() throws FileNotFoundException{
        File dir = new File("Vehiculo");
        dir.mkdir();
        carrito = new RandomAccessFile("Vehiculo/Carros.txt","rw");
    }
    
    public void addCar(int num, String tipo, String corredor, int r, int g, int b) throws IOException {
        carrito.seek(carrito.length());
        carrito.writeInt(num);
        carrito.writeLong(0);
        carrito.writeUTF(tipo);
        carrito.writeUTF(corredor);
        carrito.writeInt(r);
        carrito.writeInt(g);
        carrito.writeInt(b);
    }
    
    public boolean searchNum(int identify) throws IOException{
        carrito.seek(0);
        while(carrito.getFilePointer()<carrito.length()){
            int num = carrito.readInt();
            carrito.readLong();
            carrito.readUTF();
            carrito.readUTF();
            carrito.skipBytes(12);
            if(num==identify){
                return true;
            }
        }
        return false;
    }
    
    public int searchType() throws IOException{
        carrito.seek(0);
        while(carrito.getFilePointer()<carrito.length()){
            carrito.readInt();
            carrito.readLong();
            String tipo = carrito.readUTF();
            carrito.readUTF();
            carrito.skipBytes(12);
            if(tipo.equals("McQueen")){
                return 1;
            }else if(tipo.equals("Convertible")){
                return 2;
            }else if(tipo.equals("Nascar")){
                return 3;
            }
        }
        return 0;
    }
    
    
}
