import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class BinaryTreeMeasurerTests
{
    // object to be tested
    private BinaryTreeMeasurer binaryTreeMeasurer;

    // input data and expected output
    public static BinaryTreeTestHelper[] data()
    {
        return new BinaryTreeTestHelper[]{
                new BinaryTreeTestHelper(10, new int[]{1,2,3,4,5,6,7,8,9,10}),
                new BinaryTreeTestHelper(3, new int[]{151, 151, 152, 150, 149, 150, 159}),
                new BinaryTreeTestHelper(7, new int[]{151, 150, 149, 148, 147, 146, 145}),
                new BinaryTreeTestHelper(2, new int[]{11,10,12}),
                new BinaryTreeTestHelper(7, new int[]{151, 150, 149, 148, 147, 146, 145}),
                new BinaryTreeTestHelper(11, new int[]{10, 145, 159, 180, 200, 201, 302, 444, 503, 504, 505, 505}),
                new BinaryTreeTestHelper(5, new int[]{4,9,159,714,999})
        };
    }

    @BeforeEach
    void setUp()
    {
        binaryTreeMeasurer = new BinaryTreeMeasurer();
    }

    @ParameterizedTest
    @MethodSource(value = "data")
    public void TestNodeMeasurer(BinaryTreeTestHelper helper)
    {
        CustomBinaryTree tree = new CustomBinaryTree();

        for(int i=0; i<helper.values.length; i++)
        {
            tree.add(helper.values[i]);
        }

        assertEquals(helper.depth, binaryTreeMeasurer.getLongestDepth(tree.root, 1));
    }
}
