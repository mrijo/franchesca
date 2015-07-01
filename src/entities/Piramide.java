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
public class Piramide extends FiguraSuper implements Figura {

    public Piramide(int valor1, int valor2, int valor3) {
        super(valor1, valor2, valor3);
    }

    @Override
    public double calcularArea() {
        ComplexityLogger.increaseMultiplicaciones(1);
        ComplexityLogger.increaseSumas(1);
        ComplexityLogger.increaseDivisiones(1);
        this.area = (valor1 * valor2 + valor3) / 2;
        return area;
    }

    @Override
    public double calcularVolumen() {
        ComplexityLogger.increaseMultiplicaciones(1);
        ComplexityLogger.increaseDivisiones(1);
        this.volumen = (this.area * valor3) / 3;
        return volumen;
    }

}
