package edu.centralenantes.tp.pgm.ziane_saoud;
import java.awt.*;
import java.io.*;
import java.awt.image.BufferedImage;
import javax.imageio.*;
class Canny{
    public void filtre(String fil){
		try {
                        BufferedImage img=ImageIO.read(new File(fil));
                        int [][] pixel= new int[img.getWidth()][img.getHeight()];
                        int x,y,g;	
//***************************************************
//Conversion enniveau du Gris
	      for (int i = 0; i < img.getWidth(); i++) {
		for (int j = 0; j < img.getHeight(); j++) {
		Color pixelcolor= new Color(img.getRGB(i,j));
		int r=pixelcolor.getRed();
		int gb=pixelcolor.getGreen();
		int b=pixelcolor.getBlue();
		int hy=(r+gb+b)/3;
		int rgb=new Color(hy,hy,hy).getRGB();
		// changer la couleur de pixel avec la nouvelle couleur invers�e
		img.setRGB(i, j, rgb);
		}
	}	
// parcourir les pixels de l'image
	for (int i = 0; i < img.getWidth(); i++){
		for (int j = 0; j < img.getHeight(); j++) 
		{ // recuperer couleur de chaque pixel
		Color pixelcolor= new Color(img.getRGB(i, j));
		// recuperer les valeur rgb (rouge ,vert ,bleu) de cette couleur
		 pixel[i][j]=img.getRGB(i, j);
		}
        }
//*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*
	for (int i = 1; i < img.getWidth()-2; i++) 
	{
		for (int j = 1; j < img.getHeight()-2; j++) 
		{	
                    x=-pixel[i][j]+pixel[i][j+2];
                    y=pixel[i][j]-pixel[i+2][j];            
                    g=Math.abs(x)+Math.abs(y);	
                    pixel[i][j]=g;

	}
    }	
		for (int i = 0; i < img.getWidth(); i++) {
		for (int j = 0; j < img.getHeight(); j++) {	
		Color pixelcolor= new Color(pixel[i][j]);
		int r=pixelcolor.getRed();
		int gb=pixelcolor.getGreen();
		int b=pixelcolor.getBlue();		
	        int rgb=new Color(r,gb,b).getRGB();
		// changer la couleur de pixel avec la nouvelle couleur invers�e
		img.setRGB(i, j, rgb);

		}
	}	
		// enregistrement d'image
             ImageIO.write(img, "bmp",new File("canny.bmp"));//ImageIO.write()//;
	}

	 catch (Exception e) {
             
		System.err.println("erreur -> "+e.getMessage());
	}
	
	System.out.println("fin");	
	}
}