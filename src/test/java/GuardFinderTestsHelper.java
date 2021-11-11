public class GuardFinderTestsHelper {

    public int horizontal;
    public int vertical;
    public int[][] walls;
    public int[][] guards;
    public int[][][] expectedDistance;

    public GuardFinderTestsHelper(int h, int v, int[][] guards, int[][] walls, int[][][] expectedDistance)
    {
        this.walls = walls;
        this.guards = guards;
        this.expectedDistance = expectedDistance;
        this.horizontal = h;
        this.vertical = v;
    }

    public static GuardFinderTestsHelper[] CreateTestData()
    {
        GuardFinderTestsHelper[] data = new GuardFinderTestsHelper[]
        {
            new GuardFinderTestsHelper(2,2,
                    /* guards:*/ new int[][]{new int[]{1,1}},
                    /* walls: */ new int[][]{new int[]{0,0}},
                    /* expectedResults:*/ new int[][][]{
                            new int[][]{ new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE},   new int[]{1,0}},
                            new int[][]{ new int[]{0,1},                                    new int[]{0,0}}
                    }),
                // Todo: finish this set
            new GuardFinderTestsHelper(3,2,
                    /* guards:*/ new int[][]{new int[]{1,1}},
                    /* walls: */ new int[][]{new int[]{1,3}},
                    /* expectedResults:*/ new int[][][]{
                    new int[][]{ new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE},   new int[]{1,0}},
                    new int[][]{ new int[]{0,1},                                    new int[]{0,0}}
            })
        };

        return data;
    }
}
