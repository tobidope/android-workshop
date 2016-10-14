package com.axa.academy.calculator;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculatorUnitTest {

    private Calculator calculator;

    @BeforeClass
    public static void setUpBeforeClass() {
        // Runs before tests execution, example: initialization of resources
    }

    @AfterClass
    public static void tearDownAfterClass() {
        // Runs after all test are executed, example: closing resources
    }

    @Before
    public void setUp() {
        // Execution before each test method, example: test isolation
        calculator = new Calculator();
    }

    @After
    public void tearDown() {
        // Execution after each test method
    }

    @Test
    public void testAddPositives() throws Exception {
        assertEquals(4, calculator.add(2, 2));
    }

    @Test
    public void testAddPositiveNegative() throws Exception {
        assertEquals(0, calculator.add(2, -2));
    }

    @Test
    public void testAddNegatives() throws Exception {
        assertEquals(-4, calculator.add(-2, -2));
    }

    @Test
    public void testSubstractPositives() throws Exception {
        assertEquals(0, calculator.substract(2, 2));
    }

    @Test
    public void testSubstractPositiveNegative() throws Exception {
        assertEquals(4, calculator.substract(2, -2));
    }

    @Test
    public void testSubstractNegatives() throws Exception {
        assertEquals(0, calculator.substract(-2, -2));
    }

}