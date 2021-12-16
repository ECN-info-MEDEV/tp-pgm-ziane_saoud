/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.centralenantes.tp.pgm.ziane_saoud;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Scanner;
import javax.imageio.ImageIO;


/**
 *
 * @author X
 */
public class Read_write {
    
    private String file;
    private BufferedImage image = new BufferedImage(800, 800, BufferedImage.TYPE_4BYTE_ABGR);

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

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
            this.image.setRGB(picHeight, picWidth, maxvalue);
            for(int i=0; i<picHeight; i++) {
                for(int j=0; j<picWidth; j++) {
                    int a = data2D[i][j];
                    Color newColor = new Color(a,a,a);
                    this.image.setRGB(j,i,newColor.getRGB());
                    System.out.println("image construite");
                }
            }
            
            File output = new File(this.file+".jpg");
            ImageIO.write(this.image, "jpg", output);
            
    }

    
}

