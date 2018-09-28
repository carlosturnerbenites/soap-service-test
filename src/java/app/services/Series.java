package app.services;
// Generated 27/09/2018 11:29:33 PM by Hibernate Tools 4.3.1


import java.math.BigDecimal;

/**
 * Series generated by hbm2java
 */
public class Series  implements java.io.Serializable {


     private int id;
     private String name;
     private int year;
     private BigDecimal rate;

    public Series() {
    }

    public Series(int id, String name, int year, BigDecimal rate) {
       this.id = id;
       this.name = name;
       this.year = year;
       this.rate = rate;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public int getYear() {
        return this.year;
    }
    
    public void setYear(int year) {
        this.year = year;
    }
    public BigDecimal getRate() {
        return this.rate;
    }
    
    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }




}


