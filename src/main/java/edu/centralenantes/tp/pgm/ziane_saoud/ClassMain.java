/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.centralenantes.tp.pgm.ziane_saoud;
 import java.io.*;
/**
 *
 * @author X
 */
public class ClassMain {

  public static void main(String[] args) {
    BytePixmap p1;
    try {
      p1 = new BytePixmap(args[0]);         // lecture du fichier
    } catch (IOException e) { p1 = null; System.exit(0); }
    for ( int i=0; i<p1.size; i++)           // pour tous les pixels :
      p1.data[i] = (byte)(255 - p1.data[i]); // oui cela marche tout de même !
    ShortPixmap p2 = new ShortPixmap(p1);  // clonage
    for ( int i=0; i<p2.size; i++)           // pour tous les pixels :
      p2.data[i] = (short)(255 - p2.data[i]);// là c'est plus évident !
    p1.write("neg_"+args[0]);                // écriture de l'image en négatif
    p2.write("copy_"+args[0]);               // écriture de l'image d'origine
  }

}
