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
    }

    public void fillFigurasStrategy() {
        if (gruposPares) {
            this.fillEvenGroup();
        } else {
            this.fillOddGroup();
        }
      
        Collections.sort(figuras, (Figura fig1, Figura fig2) -> {
             return Integer.compare( (int)((FiguraSuper)fig1).getArea(), (int)((FiguraSuper)fig2).getArea());
        });
        figurasAreas = (ArrayList<Figura>)figuras.clone();

        Collections.sort(figuras, (Figura fig1, Figura fig2) -> {
            return Integer.compare( (int)((FiguraSuper)fig2).getVolumen(), (int)((FiguraSuper)fig1).getVolumen());
        });
        figurasVolumenes = figuras;
    }

    private void fillOddGroup() {
        int groupCount = values.length / 3;
        int counterAux = 0;
        for (int i = 0; i < groupCount; i++) {
            int counter = i + counterAux;
            if (values[counter].equals(values[counter + 1]) && values[counter + 1].equals(values[counter + 2])) {
                figuras.add(new Cubo(Integer.valueOf(values[counter]), Integer.valueOf(values[counter + 1]), Integer.valueOf(values[counter + 2])));
            } else if (values[counter].equals(values[counter + 1]) | values[counter].equals(values[counter + 2]) | values[counter + 1].equals(values[counter + 2])) {
                figuras.add(new Piramide(Integer.valueOf(values[counter]), Integer.valueOf(values[counter + 1]), Integer.valueOf(values[counter + 2])));
            } else {
                figuras.add(new Paralelopipedo(Integer.valueOf(values[counter]), Integer.valueOf(values[counter + 1]), Integer.valueOf(values[counter + 2])));
            }
            figuras.get(i).calcularArea();
            figuras.get(i).calcularVolumen();
            
            counterAux += 2;
        }

    }

    private void fillEvenGroup() {
        int groupCount = values.length / 2;
        int counter = 0;
        for (int i = 0; i < groupCount; i++) {
            if (values[i + counter].equals(values[i + counter + 1])) {
                figuras.add(new Esfera(Integer.valueOf(values[i + counter]), Integer.valueOf(values[i + counter + 1])));
            } else {
                figuras.add(new Rombo(Integer.valueOf(values[i + counter]), Integer.valueOf(values[i + counter + 1])));
            }
            counter++;
            figuras.get(i).calcularArea();
            figuras.get(i).calcularVolumen();
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

}
