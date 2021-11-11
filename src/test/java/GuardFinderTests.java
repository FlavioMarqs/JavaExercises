import MapaRectangularStuff.GuardFinder;
import MapaRectangularStuff.MapaRectangular;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GuardFinderTests
{
    // object to be tested
    private GuardFinder pathFinder;

    // input data and expected output
    public static GuardFinderTestsHelper[] data()
    {
        return GuardFinderTestsHelper.CreateTestData();/*{
                new GuardFinderTestsHelper(7, 5, new int[][]{new int[]{1,1}, new int[]{5,3}}, new int[][]{new int[]{4,2}, new int[]{5,2}, new int[]{4,3}, new int[]{4,4} }, new int[][][]{1,1}),
                new GuardFinderTestsHelper(7, 5, new int[][]{new int[]{1,1}, new int[]{5,3}}, new int[][]{new int[]{4,2}, new int[]{5,2}, new int[]{4,3}, new int[]{4,4} }, new int[][][]{1,2})
        };*/
    }

    @BeforeEach
    public void setUp()
    {
        pathFinder = new GuardFinder();
    }

    @ParameterizedTest
    @MethodSource(value = "data")
    public void TestNodeMeasurer(GuardFinderTestsHelper helper)
    {
        MapaRectangular mapa = new MapaRectangular(helper.horizontal, helper.vertical);

        for(int i=0; i<helper.walls.length; i++)
        {
            mapa.setWall(helper.walls[i][0], helper.walls[i][1]);
        }
        for(int i=0; i<helper.guards.length; i++)
        {
            mapa.setGuard(helper.guards[i][0], helper.guards[i][1]);
        }

        for(int i=0; i<mapa.horizontalSize; i++)
        {
            for(int j=0; j<mapa.verticalSize; j++)
            {
                if(mapa.map[i][j] == null)
                {
                    mapa.setEmpty(i, j);
                }
            }
        }

        int[][][] results = pathFinder.findShortestPathsToGuard(mapa);

        for(int i=0; i<mapa.horizontalSize; i++)
        {
            for(int j=0; j<mapa.verticalSize; j++)
            {
                final int m = i;
                final int n = j;
                assertAll(
                    ()->assertEquals(helper.expectedDistance[m][n][0], results[m][n][0]),
                    ()->assertEquals(helper.expectedDistance[m][n][1], results[m][n][1])
                );
            }
        }
    }
}
