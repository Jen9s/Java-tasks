package org.example;

import java.util.Comparator;
import java.util.Objects;

public class Shoe implements Comparable<Shoe>{
    private String name;
    private double date;
    private int counter;
    private double price;

    public Shoe(){}

    public Shoe(String name,double date,int counter,double price){
        this.name = name;
        this.date = date;
        this.counter = counter;
        this.price = price;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getDate() {
        return date;
    }

    public void setDate(double date) {
        this.date = date;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public int compareTo(Shoe o) {
        return this.name.compareTo(o.name);
    }

//    @Override
//    public boolean equals(Object obj) {
//        return Objects.equals(this.zena, ((Lekarstvo)obj).zena)
//                && Objects.equals(this.nameFirma, ((Lekarstvo)obj).nameFirma)
//                && Objects.equals(this.counterLekarstv, ((Lekarstvo)obj).counterLekarstv)
//                && Objects.equals(this.nameLekarstv, ((Lekarstvo)obj).nameLekarstv)
//                && Objects.equals(this.yearXronenie, ((Lekarstvo)obj).yearXronenie);
//    }

    @Override
    public String toString(){
        return this.name + " " + this.date + " " + this.counter + " " + this.price;
    }

}

class NameComparator implements Comparator<Shoe> {

    @Override
    public int compare(Shoe o1, Shoe o2) {
        return o1.getName().compareTo(o2.getName());
    }
}

class PriceHighComparator implements Comparator<Shoe> {

    @Override
    public int compare(Shoe o1, Shoe o2) {
        return Double.compare(o1.getPrice(),o2.getPrice());
    }
}

