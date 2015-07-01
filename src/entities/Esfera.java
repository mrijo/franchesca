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
public class Esfera extends FiguraSuper implements Figura {

    public Esfera(int valor1, int valor2) {
        super(valor1, valor2);
    }

    @Override
    public double calcularArea() {
        this.area = 4 * Math.PI * Math.pow(valor1, 2);
        ComplexityLogger.increasePotencias(1);
        ComplexityLogger.increaseMultiplicaciones(2);
        return area;
    }

    @Override
    public double calcularVolumen() {
        this.volumen = (4 / 3) * Math.PI * Math.pow(valor1, 3);
        ComplexityLogger.increasePotencias(1);
        ComplexityLogger.increaseMultiplicaciones(2);
        ComplexityLogger.increaseDivisiones(1);
        return volumen;
    }

}
