/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linearsimple.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 *
 * @author Rinoier
 */
public class DataClass {
    
    private int Nomor;

    public static final String PROP_NOMOR = "Nomor";

    private double DataX;

    public static final String PROP_DATAX = "DataX";

    public DataClass(int Nomor, double DataX, double DataY) {
        this.Nomor = Nomor;
        this.DataX = DataX;
        this.DataY = DataY;
    }

    public DataClass(double DataX, double DataY) {
        this.DataX = DataX;
        this.DataY = DataY;
    }

    public DataClass(int Nomor) {
        this.Nomor = Nomor;
    }

    private double DataY;

    public static final String PROP_DATAY = "DataY";

    /**
     * Get the value of DataY
     *
     * @return the value of DataY
     */
    public double getDataY() {
        return DataY;
    }

    /**
     * Set the value of DataY
     *
     * @param DataY new value of DataY
     */
    public void setDataY(double DataY) {
        double oldDataY = this.DataY;
        this.DataY = DataY;
        propertyChangeSupport.firePropertyChange(PROP_DATAY, oldDataY, DataY);
    }

    /**
     * Get the value of DataX
     *
     * @return the value of DataX
     */
    public double getDataX() {
        return DataX;
    }

    /**
     * Set the value of DataX
     *
     * @param DataX new value of DataX
     */
    public void setDataX(double DataX) {
        double oldDataX = this.DataX;
        this.DataX = DataX;
        propertyChangeSupport.firePropertyChange(PROP_DATAX, oldDataX, DataX);
    }

    /**
     * Get the value of Nomor
     *
     * @return the value of Nomor
     */
    public int getNomor() {
        return Nomor;
    }

    /**
     * Set the value of Nomor
     *
     * @param Nomor new value of Nomor
     */
    public void setNomor(int Nomor) {
        int oldNomor = this.Nomor;
        this.Nomor = Nomor;
        propertyChangeSupport.firePropertyChange(PROP_NOMOR, oldNomor, Nomor);
    }

    private transient final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    /**
     * Add PropertyChangeListener.
     *
     * @param listener
     */
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    /**
     * Remove PropertyChangeListener.
     *
     * @param listener
     */
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }

}
