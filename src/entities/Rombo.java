/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import metrics.ComplexityLogger;

/**
 *
 * @author miguel
 */
public class Rombo extends FiguraSuper implements Figura {

    public Rombo(int valor1, int valor2) {
        super(valor1, valor2);
    }

    @Override
    public double calcularArea() {
        this.area = (valor1 * valor2) / 2;
        ComplexityLogger.increaseMultiplicaciones(1);
        ComplexityLogger.increaseDivisiones(1);
        return area;
    }

    @Override
    public double calcularVolumen() {
        ComplexityLogger.increaseMultiplicaciones(2);
        ComplexityLogger.increaseRadicaciones(1);
        ComplexityLogger.increaseDivisiones(1);
        this.volumen = (Math.sqrt(2) / 3) * Math.pow((valor1 * valor2), 3);
        return volumen;
    }

}
