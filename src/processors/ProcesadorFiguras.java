/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package processors;

import com.opencsv.CSVReader;
import entities.Cubo;
import entities.Esfera;
import entities.Figura;
import entities.FiguraSuper;
import entities.Paralelopipedo;
import entities.Piramide;
import entities.Rombo;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import metrics.ComplexityLogger;

/**
 *
 * @author miguel
 */
public class ProcesadorFiguras {

    private String[] values;
    private boolean gruposPares;
    private ArrayList<Figura> figuras;
    private ArrayList<Figura> figurasAreas;
    private ArrayList<Figura> figurasVolumenes;
    private double sumAreas = 0;
    private double sumVol = 0;
    private double proSumAreas = 0;
    private double proSumVol = 0;

    public ProcesadorFiguras() {
        figuras = new ArrayList<>();
    }

    
    
    
    //string must be comma separate value
    public void fillValuesFromSTR(String txt) {
        /*
         CSVReader reader = new CSVReader(new StringReader(txt),',',' ');
         try {
         values = reader.readAll();
         } catch (IOException ex) {
         Logger.getLogger(AreaProcessor.class.getName()).log(Level.SEVERE, null, ex);
         }*/

        values = txt.split(",");
        gruposPares = (values.length % 2 == 0);
        ComplexityLogger.increaseDivisiones(1);
    }

    public void fillFigurasStrategy() {
        if (gruposPares) {
            this.fillEvenGroup();
        } else {
            this.fillOddGroup();
        }
        proSumAreas = sumAreas / figuras.size();
        proSumVol = sumVol / figuras.size();

        ComplexityLogger.increaseDivisiones(2);

        Collections.sort(figuras, (Figura fig1, Figura fig2) -> {
            return Integer.compare((int) ((FiguraSuper) fig1).getArea(), (int) ((FiguraSuper) fig2).getArea());
        });
        figurasAreas = (ArrayList<Figura>) figuras.clone();

        Collections.sort(figuras, (Figura fig1, Figura fig2) -> {
            return Integer.compare((int) ((FiguraSuper) fig2).getVolumen(), (int) ((FiguraSuper) fig1).getVolumen());
        });
        figurasVolumenes = figuras;
    }

    private void fillOddGroup() {
        int groupCount = values.length / 3;
        ComplexityLogger.increaseDivisiones(1);
        int counterAux = 0;
        for (int i = 0; i < groupCount; i++) {
            int counter = i + counterAux;
            int counter2 = counter + 1;
            int counter3 = counter + 2;
            ComplexityLogger.increaseSumas(7);
            if (values[counter].equals(values[counter2]) && values[counter2].equals(values[counter3])) {
                figuras.add(new Cubo(Integer.valueOf(values[counter]), Integer.valueOf(values[counter2]), Integer.valueOf(values[counter3])));
            } else if (values[counter].equals(values[counter2]) | values[counter].equals(values[counter3]) | values[counter2].equals(values[counter3])) {
                figuras.add(new Piramide(Integer.valueOf(values[counter]), Integer.valueOf(values[counter2]), Integer.valueOf(values[counter3])));
            } else {
                figuras.add(new Paralelopipedo(Integer.valueOf(values[counter]), Integer.valueOf(values[counter + 1]), Integer.valueOf(values[counter + 2])));
            }
            sumAreas += figuras.get(i).calcularArea();
            sumVol += figuras.get(i).calcularVolumen();

            counterAux += 2;
        }

    }

    private void fillEvenGroup() {
        int groupCount = values.length / 2;
        ComplexityLogger.increaseDivisiones(1);
        int counter = 0;
        for (int i = 0; i < groupCount; i++) {

            ComplexityLogger.increaseSumas(7);

            int counter2 = i + counter + 1;
            int counter1 = i + counter;

            if (values[counter1].equals(values[counter2])) {
                figuras.add(new Esfera(Integer.valueOf(values[counter1]), Integer.valueOf(values[counter2])));
            } else {
                figuras.add(new Rombo(Integer.valueOf(values[counter1]), Integer.valueOf(values[counter2])));
            }
            counter++;
            sumAreas += figuras.get(i).calcularArea();
            sumVol += figuras.get(i).calcularVolumen();
        }
    }

    public String[] getValues() {
        return values;
    }

    public void setValues(String[] values) {
        this.values = values;
    }

    public boolean isGruposPares() {
        return gruposPares;
    }

    public void setGruposPares(boolean gruposPares) {
        this.gruposPares = gruposPares;
    }

    public ArrayList<Figura> getFiguras() {
        return figuras;
    }

    public void setFiguras(ArrayList<Figura> figuras) {
        this.figuras = figuras;
    }

    public ArrayList<Figura> getFigurasAreas() {
        return figurasAreas;
    }

    public void setFigurasAreas(ArrayList<Figura> figurasAreas) {
        this.figurasAreas = figurasAreas;
    }

    public ArrayList<Figura> getFigurasVolumenes() {
        return figurasVolumenes;
    }

    public void setFigurasVolumenes(ArrayList<Figura> figurasVolumenes) {
        this.figurasVolumenes = figurasVolumenes;
    }

    public double getProSumAreas() {
        return Math.ceil(proSumAreas);
    }

    public void setProSumAreas(double proSumAreas) {
        this.proSumAreas = proSumAreas;
    }

    public double getProSumVol() {
        return Math.ceil(proSumVol);
    }

    public void setProSumVol(double proSumVol) {
        this.proSumVol = proSumVol;
    }

}
