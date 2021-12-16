/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.centralenantes.tp.pgm.ziane_saoud;

import java.io.IOException;

 import java.io.*;

/**
 *
 * @author X
 */
public class ClassMain {
    public static void main(String[] args) throws IOException {
        
        String file = "baboon.pgm";
        
        Read_write read = new Read_write(file);
        
        read.read();
        
    }
 
}
