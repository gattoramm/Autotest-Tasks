package ru.stqa.pft.sandbox;

public class MyFirstProgram {
    public static void main(String[] args) {
        Square s = new Square(5);
        System.out.println("Area of square = " + s.area());

        Rectangle r = new Rectangle(4, 6);
        System.out.println("Area of rectangle = " + s.area());
    }

    public static void hello(String somebody) {
        System.out.println("Hello, " + somebody + "!");
    }
}