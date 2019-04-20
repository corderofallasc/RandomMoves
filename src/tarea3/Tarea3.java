/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea3;

import myInterface.DisplayFrame;
import myInterface.Simulator;

/**
 *
 * @author Christian
 */
public class Tarea3 {
        static final int X_MAPA = 50;
        static final int Y_MAPA = 50;
        static final int ANCHO_MAPA = 400;
        static final int ALTO_MAPA = 400;
        static final int TIEMPO_ESPERA = 250;

    public static void main(String[] args) throws InterruptedException {
        DisplayFrame myFrame = new DisplayFrame(X_MAPA, Y_MAPA, ANCHO_MAPA, ALTO_MAPA);
        Simulator mySimulator = new Simulator(myFrame);

        myFrame.setVisible(true);
        mySimulator.startSimulation(TIEMPO_ESPERA);
    }
    
}
