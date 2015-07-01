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
public class Paralelopipedo extends FiguraSuper implements Figura {

    public Paralelopipedo(int valor1, int valor2, int valor3) {
        super(valor1, valor2, valor3);
    }

    @Override
    public double calcularArea() {
        this.area = valor1;
        ComplexityLogger.increaseSumas(2);
        ComplexityLogger.increaseMultiplicaciones(5);
        return 2 * valor1 * valor2 + 2 * valor1 * valor3 + 2 * valor2 * valor3;
    }

    @Override
    public double calcularVolumen() {
        this.volumen = valor1;
         ComplexityLogger.increaseMultiplicaciones(2);
        return valor1 * valor2 * valor3;
    }

}
