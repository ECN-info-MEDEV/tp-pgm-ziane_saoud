package edu.centralenantes.tp.pgm.ziane_saoud;
//-----------------------------------------------------------------------
		//      Les bibliotheques       /
//-----------------------------------------------------------------------
//***************************************************
/*                                                  *
 *             TP Traitement d'Image                *
 *		          
                                                    *
 *                                                  *
 *                                                  *
 ****************************************************/
import java.io.*;
import java.util.*;
import java.io.IOException;
import javax.swing.*;
import java.awt.*; 
import java.awt.event.*; 
class Imag  extends JFrame implements ActionListener
{
Container cont;
public static int pixelx[]= new int[256];	
JMenuBar menu=new JMenuBar();
JMenu fichier= new JMenu(" HISTOGRAMME");
JMenu tpc= new JMenu("FILTRE  (PMP) ");
JMenu apro= new JMenu("A PROPOS"); 
JMenuItem nvf= new JMenuItem("Nouveau");
JMenuItem impo= new JMenuItem("HISTOGRAMME");
JMenuItem impob= new JMenuItem("SOBEL");
JMenuItem impoc= new JMenuItem("CANNY ");
JMenuItem aprox= new JMenuItem("A Propos");
String ftpxy="";
String ftpxya="";
String ftpxyb="";
String ftpxyax="";
FileDialog fDial;
FileDialog fDiala;
FileDialog fDialb;
FileDialog fDialax;
Cartesien pes;
ImageIcon imgbx = new ImageIcon("aze.db");
JLabel imbx = new JLabel(imgbx);
public Imag()
{
    
    this.setTitle("TRAITEMNT D'IMAGE");
    this.setSize(this.getToolkit().getScreenSize());
    cont=this.getContentPane();
    getContentPane().setBackground(SystemColor.white); 
    setJMenuBar(menu);//declaration de menu
    menu.setBackground(Color.white);
    menu.setForeground(Color.BLACK);
    fichier.setBackground(Color.white);
    fichier.setForeground(Color.BLACK);
    cont.add(fichier);//
    cont.add(impo);
    menu.add(fichier);
    nvf.setBackground(Color.white);
    nvf.setForeground(Color.BLACK);
    impo.setBackground(Color.white);
    impo.setForeground(Color.BLACK);
    fichier.addSeparator();
    fichier.add(impo);
    fichier.addSeparator();
    impo.addActionListener(this);
    tpc.setBackground(Color.white);
    tpc.setForeground(Color.BLACK);
    apro.setBackground(Color.white);
    apro.setForeground(Color.BLACK);
    aprox.setBackground(Color.white);
    aprox.setForeground(Color.BLACK);
    cont.add(tpc);//
    cont.add(impob);
    cont.add(impoc);
    cont.add(apro);//
    cont.add(aprox);//
    menu.add(tpc);
    menu.add(apro);
    menu.add(aprox);
   	impob.setBackground(Color.white);
	impob.setForeground(Color.BLACK);
	impoc.setBackground(Color.white);
	impoc.setForeground(Color.BLACK);
	tpc.addSeparator();
	tpc.add(impoc);
	tpc.addSeparator();
	apro.addSeparator();
	apro.add(aprox);
	apro.addSeparator();
	fDial=new FileDialog(this, "Choisir une Image PGM", FileDialog.LOAD);
	fDiala=new FileDialog(this, "Choisir une Image PGM ", FileDialog.LOAD);
	fDialax=new FileDialog(this, "Choisir une Image PGM ", FileDialog.LOAD);
	   cont.add(imbx);
             imbx.setBounds(100,30,900,660);
		fDialb=new FileDialog(this, "Choisir une Image PGM ", FileDialog.LOAD);

//******************************************************************************
// Récupération d'une Image PGM Pour l'histogramme	
    impo.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent ev) {
	fDial.setVisible(true);
    String nom=fDial.getFile();
     if (nom!=null) {
     String dir=fDial.getDirectory();
      ftpxy=dir+nom;
      System.out.println(dir+nom+"\n");
           }
           else System.out.println("S�lection annul�e.\n");
	if(ftpxy!="")
	{
	        	try
{
		histogramme(ftpxy);
}
catch(Exception ert)
{
JOptionPane.showMessageDialog(null,"ERREUR  :   IMPOSSIBLE D'IMPORTER LES DONNEES???","ERREUR",JOptionPane.ERROR_MESSAGE);
}
	}
	}
});
  
  
  
  	aprox.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent ev) {

JOptionPane.showMessageDialog(null,"Traitement d'image \n \n  SAOUD & ZIANE  \n\n  \n \n Informatique","A PROPOS",JOptionPane.INFORMATION_MESSAGE);

	}
});
 //*************************************************************
// Filtrage 	
    impoc.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent ev) {
    fDialb.setVisible(true);
    String nom=fDialb.getFile();
     if (nom!=null) {
     String dir=fDialb.getDirectory();
      ftpxyb=dir+nom;
      System.out.println(ftpxyb+"\n");
           }
           else System.out.println("Sélection annulée.\n");
	if(ftpxyb!="")
	{
	
        try {
	affich af1 = new affich();
	affich af2 = new affich();
	affich af3 = new affich();
	affich af4 = new affich();
	affich af5 = new affich();
	Canny cn =new Canny();
	cn.filtre(ftpxyb);
	af5.affichx("Canny.bmp");

}


	
	
catch(Exception ert)
{
JOptionPane.showMessageDialog(null,"ERREUR  :   IMPOSSIBLE D'IMPORTER LES DONNEES???","ERREUR",JOptionPane.ERROR_MESSAGE);
}
}
	}
});
 
   //**************************************************************************
   
   impob.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent ev) {
	fDialb.setVisible(true);
    String nom=fDialb.getFile();
     if (nom!=null) {
     String dir=fDialb.getDirectory();
      ftpxyb=dir+nom;
      System.out.println(ftpxyb+"\n");
           }
           else System.out.println("S�lection annul�e.\n");
	if(ftpxyb!="")
	{
	        	try


{
		//sobel(ftpxyb);
}


	
	
catch(Exception ert)
{
JOptionPane.showMessageDialog(null,"ERREUR  :   IMPOSSIBLE D'IMPORTER LES DONNEES???","ERREUR",JOptionPane.ERROR_MESSAGE);
}
}
	}
});
} 

  //****************************************************************************
  // Méthode Pour la Création de l'Histogramme
  //------------------------------------------
	public void histogramme (String url)
	{
			try
	{
	int vxy=0;
    	for(int k=0 ; k<=255;k++ )
    	{
    		
    	pixelx[k]=0;	
    	}
	 String ligne;
     StringTokenizer st;
     
     String lignex;
     StringTokenizer stx;
	int cmp=0;
		int cmpx=0;
	 BufferedReader fich=new BufferedReader(new FileReader(url));
           while ((ligne=fich.readLine())!=null)
    {
        st=new StringTokenizer(ligne," ");
    	while(st.hasMoreTokens())
    	{
    	String	mot=st.nextToken();
    	cmpx++;
    	}
    }
    fich.close();
     int pixels[]= new int[cmpx];	
     BufferedReader fichx=new BufferedReader(new FileReader(url));
     lignex=fichx.readLine();
     lignex=fichx.readLine();
     lignex=fichx.readLine();
     lignex=fichx.readLine();

    
		
       while ((lignex=fichx.readLine())!=null)
    {
        stx=new StringTokenizer(lignex," ");
    	while(stx.hasMoreTokens())
    	{
    	String	mot=stx.nextToken();
    	pixels[cmp]=Integer.parseInt(mot);
    	vxy=pixels[cmp];
    	pixelx[vxy]=pixelx[vxy]+1;
    	
	   	cmp++;
    	}
    }
    
 	JOptionPane.showMessageDialog(null,"OPERATION TERMINEE AVEC SUCCES ","HISTOGRAMME",JOptionPane.INFORMATION_MESSAGE);

	}
	catch(IOException ex)
	{
		System.out.println(ex);
	}
		catch(NumberFormatException ey)
	{
	}
	
	Imaga ima=new Imaga();
ima.setVisible(true);
	
	}
	
//******************************************************************************	
	 public void actionPerformed(ActionEvent r)
{	
}
//******************************************************************************
//******************************************************************************
	public static void main (String args [])throws Exception
	{
	
Imag im=new Imag();
im.setVisible(true);

	}
}


//******************************************************************************
//******************************************************************************

class Cartesien extends Canvas
		{
			Cartesien(){}
			
			public void paint (Graphics g)
				{
					g.setColor(Color.black);
					for(int i=0;i<=255;i++)
					{
					g.drawLine(i,600-this.HEIGHT,i,600-Imag.pixelx[i]/10);
				
					}
								}
		}

//******************************************************************************
//******************************************************************************

class Imaga  extends JFrame
{
	Cartesien pes;
	Container cont;
public Imaga()
{
  this.setBounds(300,30,268,630);
  this.setTitle("Histogramme Image");
  getContentPane().setBackground(SystemColor.white);
  cont=this.getContentPane();
  cont.setLayout(null);
  pes = new Cartesien();
  pes.setBounds(0,00,401,600);
  cont.add(pes);
	
}	
	
}

//******************************************************************************
//******************************************************************************