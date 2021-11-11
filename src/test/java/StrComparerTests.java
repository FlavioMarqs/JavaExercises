import MapaRectangularStuff.GuardFinder;
import MapaRectangularStuff.MapaRectangular;
import StrComparer.StrComparer;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StrComparerTests
{
    // object to be tested
    private StrComparer strComparer;

    // input data and expected output
    public static String[][] data() {
        return new String[][]{new String[]{"ANACOM", "AnA" },
                              new String[]{"JACINTAJACINTA", "jacinta" },
                              new String[]{"JOSÉ", "MALHOA" }
        };
    }

    @BeforeEach
    public void setUp()
    {
        strComparer = new StrComparer();
    }

    //@ParameterizedTest
   // @MethodSource(value = "data")
    @Test
    public void isWithin_ShouldReturnTrue(/*String[] params*/)
    {
        String[][] params = new String[][]{
                new String[]{"ANACOM", "AnA" },
                new String[]{"JACINTAJACINTA", "jacinta" }};
        for(int i=0; i<params.length; i++)
        {
            String original = params[i][0];
            String comp = params[i][1];

            Assert.assertTrue(strComparer.isWithin(original, comp));
        }
    }

    @Test
    public void isWithin_ShouldReturnFalse()
    {
        String[][] params = new String[][]{
                new String[]{"JOSEMALHOA", "JOSÉ" },
                new String[]{"JACINTAJACINTA", "jacintaANABELA" }};
        for(int i=0; i<params.length; i++)
        {
            String original = params[i][0];
            String comp = params[i][1];

            Assert.assertFalse(strComparer.isWithin(original, comp));
        }
    }
}
