package main.java.org.kniit.lab2.task3;

import java.util.Scanner;

class Calculator {
    public static double add(double a, double b){
        return a + b;
    }
    public static double substract(double a, double b){
        return a - b;
    }
    public static double multiply(double a, double b){
        return a * b;
    }
    public static double divide(double a, double b){
        return a / b;
    }
}

public class Main{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.print("Введите первое число: ");
            if (input.hasNext("exit")){
                System.exit(0);
            }
            double a = input.nextDouble();
            System.out.print("Введите оператор (+, -, *, /): ");
            if (input.hasNext("exit")){
                System.exit(0);
            }
            String s = input.next();
            System.out.print("Введите второе число: ");
            if (input.hasNext("exit")){
                System.exit(0);
            }
            double b = input.nextDouble();
            switch (s) {
                case "+" -> System.out.println("Результат: " + Calculator.add(a, b));
                case "-" -> System.out.println("Результат: " + Calculator.substract(a, b));
                case "*" -> System.out.println("Результат: " + Calculator.multiply(a, b));
                case "/" -> {
                    if (b != 0) {
                        System.out.println("Результат: " + Calculator.divide(a, b));
                    } else {
                        System.out.println("Ошибка: деление на ноль");
                    }
                }
            }
        }
    }
}