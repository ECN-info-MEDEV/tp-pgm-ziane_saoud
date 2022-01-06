package edu.centralenantes.tp.pgm.ziane_saoud;
import javax.swing.JScrollPane;
   import java.awt.image.*;
   import java.io.*;   
   import javax.imageio.*;
   import javax.swing.*;

public class affich extends JFrame {
    
  
  public void affichx(String fix) {
      	
try
{
 File fi = new File(fix);
 BufferedImage currentImage = ImageIO.read(fi);
 JLabel imageLabel = new JLabel(); 
 imageLabel.setIcon(new ImageIcon(currentImage));
 imageLabel.setText(null);
 JScrollPane jsp = new JScrollPane(imageLabel);
 getContentPane().add(jsp);
 setSize(400,400);
 setVisible(true);
 this.setTitle(fix);
  }
  catch (Exception io)
  {
  	System.out.println(io);
  }
}
  public static void main(String[] args) {
    new affich();
  }
}
           