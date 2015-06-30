/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

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
        return area;
    }

    @Override
    public double calcularVolumen() {
        this.volumen = valor1;
        return volumen;
    }

}
