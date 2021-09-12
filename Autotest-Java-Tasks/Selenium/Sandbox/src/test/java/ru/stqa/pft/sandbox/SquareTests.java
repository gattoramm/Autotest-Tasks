package ru.stqa.pft.sandbox;

import org.testng.annotations.Test;

public class SquareTests {
    @Test
    public void testArea() {
        Square square = new Square(5);
        assert square.area() == 25;
    }
}
