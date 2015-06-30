/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import entities.Figura;
import entities.FiguraSuper;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author miguel
 */
public class AreaTableModel extends AbstractTableModel {

    private ArrayList<Figura> figurasAreas;

    public AreaTableModel(ArrayList<Figura> figurasAreas) {
        this.figurasAreas = figurasAreas;
    }

    @Override
    public int getRowCount() {
        return figurasAreas.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        FiguraSuper figura = (FiguraSuper) figurasAreas.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return figura.getClass().toString();
            case 1:
                return figura.getValor1();
            case 2:
                return figura.getValor2();
            case 3:
                return figura.getValor3();
            case 4:
                return figura.getArea();

        }
        return 0;
    }

}
