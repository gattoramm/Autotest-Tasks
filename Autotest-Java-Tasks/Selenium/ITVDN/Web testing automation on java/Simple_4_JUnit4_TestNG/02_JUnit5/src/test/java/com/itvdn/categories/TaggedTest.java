package com.itvdn.categories;

import com.itvdn.ArithmeticOperation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaggedTest {

    private final ArithmeticOperation arithmeticOperation = new ArithmeticOperation();

    @Test
    @Tag("slow")
    @DisplayName("I am so slow")
    void runsSlowly() {
        assertEquals(3, arithmeticOperation.add(1, 2));
    }

    @Test
    @Tag("fast")
    @DisplayName("I am really fast!")
    void runsFast() {
        assertEquals(1, arithmeticOperation.substract(2, 1));
    }
}
