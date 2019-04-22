/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linearsimple.model;

import java.text.DecimalFormat;
import java.util.List;
import linearsimple.model.Data;

/**
 *
 * @author Rinoier
 */
public class RegresiLinear {
    int n = 0;                
    double sumx = 0.0, sumy = 0.0, sumx2 = 0.0;
    double xbar;
    double ybar;
    double xxbar = 0.0, yybar = 0.0, xybar = 0.0;
    double beta1;
    double beta0;
    int df;
    double rss;  // residual sum of squares
    double ssr; // regression sum of squares
    double R2;
    double svar;
    double svar1;
    double svar0;
    java.util.List<linearsimple.model.Data> listData;
    DecimalFormat format = new DecimalFormat ("0.######");
    

    public void setN(int n) {
        this.n = n;
    }

    public void setSumx(double sumx) {
        this.sumx = sumx;
    }

    public void setSumy(double sumy) {
        this.sumy = sumy;
    }

    public void setSumx2(double sumx2) {
        this.sumx2 = sumx2;
    }

    public void setXbar(double xbar) {
        this.xbar = xbar;
    }

    public void setYbar(double ybar) {
        this.ybar = ybar;
    }

    public void setXxbar(double xxbar) {
        this.xxbar = xxbar;
    }

    public void setYybar(double yybar) {
        this.yybar = yybar;
    }

    public void setXybar(double xybar) {
        this.xybar = xybar;
    }

    public void setBeta1(double beta1) {
        this.beta1 = beta1;
    }

    public void setBeta0(double beta0) {
        this.beta0 = beta0;
    }

    public void setDf(int df) {
        this.df = df;
    }

    public void setRss(double rss) {
        this.rss = rss;
    }

    public void setSsr(double ssr) {
        this.ssr = ssr;
    }

    public void setR2(double R2) {
        this.R2 = R2;
    }

    public void setSvar(double svar) {
        this.svar = svar;
    }

    public void setSvar1(double svar1) {
        this.svar1 = svar1;
    }

    public void setSvar0(double svar0) {
        this.svar0 = svar0;
    }

    public void setListData(List<Data> listData) {
        this.listData = listData;
    }

    public RegresiLinear(List<Data> listData) {
        this.listData = listData;        
        this.Train();        
    }
    
    
    

    public RegresiLinear() {
    }

    private void Train() {
        n = 0;                
        sumx = 0.0;
        sumy = 0.0;
        sumx2 = 0.0;
        for (Data data : listData) {
            n++;
            Double dataX = data.getDataX();
            Double dataY = data.getDataY();
            sumx  += dataX;
            sumx2 += dataX * dataX;
            sumy  += dataY;            
        }

        xbar = sumx / n;
        ybar = sumy / n;

        // second pass: compute summary statistics
        xxbar = 0.0;
        yybar = 0.0;
        xybar = 0.0;
        for (Data data : listData) {
            Double dataX = data.getDataX();
            Double dataY = data.getDataY();
            xxbar += (dataX - xbar) * (dataX - xbar);
            yybar += (dataY - ybar) * (dataY - ybar);
            xybar += (dataY - xbar) * (dataY - ybar);            
        }        
        beta1 = xybar / xxbar;
        beta0 = ybar - beta1 * xbar;

        // print results
        System.out.println("y   = " + beta1 + " * x + " + beta0);
        
        // analyze results
        df = n - 2;
        rss = 0.0;      // residual sum of squares
        ssr = 0.0;      // regression sum of squares
        for (Data data : listData) {
            double fit = beta1*data.getDataX() + beta0;
            rss += (fit - data.getDataY()) * (fit - data.getDataY());
            ssr += (fit - ybar) * (fit - ybar);            
        }
        R2    = ssr / yybar;
        svar  = rss / df;
        svar1 = svar / xxbar;
        svar0 = svar/n + xbar*xbar*svar1;
        svar0 = svar * sumx2 / (n * xxbar);
        
        System.out.println("R^2                 = " + R2);
        System.out.println("std error of beta_1 = " + Math.sqrt(svar1));
        System.out.println("std error of beta_0 = " + Math.sqrt(svar0));
        System.out.println("std error of beta_0 = " + Math.sqrt(svar0));

        System.out.println("SSTO = " + yybar);
        System.out.println("SSE  = " + rss);
        System.out.println("SSR  = " + ssr);        
    }

    public int getN() {
        return n;
    }

    public double getSumx() {
        return sumx;
    }

    public double getSumy() {
        return sumy;
    }

    public double getSumx2() {
        return sumx2;
    }

    public double getXbar() {
        return xbar;
    }

    public double getYbar() {
        return ybar;
    }

    public double getXxbar() {
        return xxbar;
    }

    public double getYybar() {
        return yybar;
    }

    public double getXybar() {
        return xybar;
    }

    public double getBeta1() {
        return beta1;
    }

    public double getBeta0() {
        return beta0;
    }

    public String getBeta1String() {
        return format.format(beta1);
    }
    
    public String getBeta0String() {
        return format.format(beta0);
    }

    public int getDf() {
        return df;
    }

    public double getRss() {
        return rss;
    }

    public double getSsr() {
        return ssr;
    }

    public double getR2() {
        return R2;
    }

    public double getSvar() {
        return svar;
    }

    public double getSvar1() {
        return svar1;
    }

    public double getSvar0() {
        return svar0;
    }

    public List<Data> getListData() {
        return listData;
    }

    
}
