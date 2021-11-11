import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class FibonacciSomadorTests
{
    // object to be tested
    private FibonacciSomador _somador;

    // input data and expected output
    public static int[][] data() {
        return new int[][] { { 1 , 1 }, { 2, 1 }, { 3, 2 }, {4, 3}, {5, 5}, {6, 8}, {9, 34}, {10, 55}, {16, 987}, {19, 4181} };
    }

    @BeforeEach
    void setUp()
    {
        _somador = new FibonacciSomador();
    }

    @ParameterizedTest
    @MethodSource(value = "data")
    public void TestFibonacciRecursively(int[] data)
    {
        int n = data[0];
        int expectedSumValue = data[1];

        assertEquals(expectedSumValue, _somador.NesimoValor(n));
    }

    @ParameterizedTest
    @MethodSource(value = "data")
    public void TestFibonacciManeiraMa(int[] data)
    {
        int n = data[0];
        int expectedSumValue = data[1];

        assertEquals(expectedSumValue, _somador.ManeiraMa(n));
    }
}
