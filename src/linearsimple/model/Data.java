/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linearsimple.model;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvBindByPosition;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Rinoier
 */
@Entity
@Table(name = "data", catalog = "sederhana", schema = "")
@NamedQueries({
    @NamedQuery(name = "Data.findAll", query = "SELECT d FROM Data d")
    , @NamedQuery(name = "Data.findByDataId", query = "SELECT d FROM Data d WHERE d.dataId = :dataId")
    , @NamedQuery(name = "Data.findByDataX", query = "SELECT d FROM Data d WHERE d.dataX = :dataX")
    , @NamedQuery(name = "Data.findByDataY", query = "SELECT d FROM Data d WHERE d.dataY = :dataY")})
public class Data implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "data_id")
//    @CsvBindByName(column = "No")    
    @GeneratedValue
    private Integer dataId;
    @Column(name = "data_x")
    @CsvBindByName(column = "Minggu")    
//    @CsvBindByPosition(position = 1) 
    private Double dataX;
    @Column(name = "data_y")
    @CsvBindByName(column = "Tangki")    
    private Double dataY;

    @Transient
    private double PrediksiY;
    
    public static final String PROP_PREDIKSIY = "PrediksiY";

    /**
     * Get the value of PrediksiY
     *
     * @return the value of PrediksiY
     */
    public double getPrediksiY() {
        return PrediksiY;
    }

    /**
     * Set the value of PrediksiY
     *
     * @param PrediksiY new value of PrediksiY
     */
    public void setPrediksiY(double PrediksiY) {
        double oldPrediksiY = this.PrediksiY;
        this.PrediksiY = PrediksiY;
        changeSupport.firePropertyChange(PROP_PREDIKSIY, oldPrediksiY, PrediksiY);
    }
    
    public Data() {
        this.dataX = 1d;
        this.dataY = 1d;
    }

    public Data(Integer dataId) {
        this.dataX = 1d;
        this.dataY = 1d;
        this.dataId = dataId;
    }

    public Integer getDataId() {
        return dataId;
    }

    public void setDataId(Integer dataId) {
        Integer oldDataId = this.dataId;
        this.dataId = dataId;
        changeSupport.firePropertyChange("dataId", oldDataId, dataId);
    }

    public Double getDataX() {
        return dataX;
    }

    public void setDataX(Double dataX) {
        Double oldDataX = this.dataX;
        this.dataX = dataX;
        changeSupport.firePropertyChange("dataX", oldDataX, dataX);
    }

    public Double getDataY() {
        return dataY;
    }

    public void setDataY(Double dataY) {
        Double oldDataY = this.dataY;
        this.dataY = dataY;
        changeSupport.firePropertyChange("dataY", oldDataY, dataY);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dataId != null ? dataId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Data)) {
            return false;
        }
        Data other = (Data) object;
        if ((this.dataId == null && other.dataId != null) || (this.dataId != null && !this.dataId.equals(other.dataId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "linearsimple.Data[ dataId=" + dataId + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }

    public void prediksi(double X,double b0,double b1) {
        this.PrediksiY= b0 + (X * b1);
        
    }
    
}
