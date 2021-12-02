/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.centralenantes.tp.pgm.ziane_saoud;

import java.io.DataInputStream;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


/**
 *
 * @author X
 */
public class Read_write {
    
    private String file;

    public Read_write(String file) {
        this.file = file;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }
    
    
    
    public void read() throws FileNotFoundException, IOException{
        
        FileInputStream fileInputStream = new FileInputStream(this.file);
        Scanner scan = new Scanner(fileInputStream);
        
        scan.nextLine();
        
        scan.nextLine();
        
        int picWidth = scan.nextInt();
        int picHeight = scan.nextInt();
        int maxvalue = scan.nextInt();
        
        fileInputStream.close();
        
        fileInputStream = new FileInputStream(this.file);
        DataInputStream dis = new DataInputStream(fileInputStream);
        
        int[][] data2D = new int[picHeight][picWidth];
        for (int row = 0; row < picHeight; row++) {
        for (int col = 0; col < picWidth; col++) {
            data2D[row][col] = dis.readUnsignedByte();
            //System.out.print(data2D[row][col] + " ");
            }
        }
        
        System.out.println(data2D.toString());
    }
    
}
