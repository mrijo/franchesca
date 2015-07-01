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
public class Cubo extends FiguraSuper implements Figura {

    public Cubo(int valor1, int valor2, int valor3) {
        super(valor1, valor2, valor3);
    }

    @Override
    public double calcularArea() {
        this.area = Math.pow(valor1, 2);
        ComplexityLogger.increasePotencias(1);
        return area;
    }

    @Override
    public double calcularVolumen() {
        this.volumen = Math.pow(valor1, 3);
        ComplexityLogger.increasePotencias(1);
        return volumen;
    }

}
