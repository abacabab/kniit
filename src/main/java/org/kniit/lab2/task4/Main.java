package org.kniit.lab2.task4;

class Container{
    public double volume, occupied;

    public Container(double volume){
        this.volume = volume;
        this.occupied = 0;
    }
    public void add(Shape shape){
        if (occupied + shape.getVolume() <= volume) {
            occupied += shape.getVolume();
            System.out.println("фигура добавлена");
        }
        else System.out.println("Not enough volume to add");
    }
}
class Shape{
    protected double a;
    public void Shape(double a){
        this.a = a;
    }
    public double getVolume(){
        return a * a * a;
    }
}

class Sphere extends Shape{
    private double r;
    public Sphere(double r){
        this.r = r;
    }
    public double getVolume(){
        return 4 * Math.PI * r * r * r / 3;
    }
}

class Cube extends Shape{
    public Cube(double a) { this.a = a; }
}

class Cylinder extends Shape{
    private double r, h;
    public Cylinder(double r, double h){
        this.r = r;
        this.h = h;
    }
    public double getVolume(){
        return Math.PI * r * r * h;
    }
}

public class Main {
    public static void main(String[] args) {
        Container container = new Container(1000);

        Shape sphere= new Sphere(5);
        Shape cube = new Cube(300 );

        container.add(sphere);
        container.add(cube);
    }
}
