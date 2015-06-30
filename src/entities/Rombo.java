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
public class Rombo extends FiguraSuper implements Figura{

    public Rombo(int valor1, int valor2) {
        super(valor1, valor2);
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
