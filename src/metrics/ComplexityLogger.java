/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metrics;

/**
 *
 * @author miguel
 */
public class ComplexityLogger {

    private static int sumas = 0;
    private static int multiplicaciones = 0;
    private static int divisiones = 0;
    private static int potencias = 0;
    private static int restas = 0;
    private static int radicaciones = 0;
    private static int asignaciones = 0;

    public static int getSumas() {
        return sumas;
    }

    public static void increaseSumas(int sumas) {
        ComplexityLogger.sumas += sumas;
    }

    public static int getMultiplicaciones() {
        return multiplicaciones;
    }

    public static void increaseMultiplicaciones(int multiplicaciones) {
        ComplexityLogger.multiplicaciones += multiplicaciones;
    }

    public static int getDivisiones() {
        return divisiones;
    }

    public static void increaseDivisiones(int divisiones) {
        ComplexityLogger.divisiones += divisiones;
    }

    public static int getPotencias() {
        return potencias;
    }

    public static void increasePotencias(int potencias) {
        ComplexityLogger.potencias += potencias;
    }

    public static int getRestas() {
        return restas;
    }

    public static void increaseRestas(int restas) {
        ComplexityLogger.restas += restas;
    }

    public static int getRadicaciones() {
        return radicaciones;
    }

    public static void increaseRadicaciones(int radicaciones) {
        ComplexityLogger.radicaciones += radicaciones;
    }

    public static int getAsignaciones() {
        return asignaciones;
    }

    public static void increaseAsignaciones(int asignaciones) {
        ComplexityLogger.asignaciones += asignaciones;
    }
    
    
    

}
