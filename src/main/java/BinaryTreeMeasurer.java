
public class BinaryTreeMeasurer {

    public BinaryTreeMeasurer()
    {
    }

    public int getLongestDepth(Node node, int currentDepth)
    {
        int leftDepth = currentDepth;
        int rightDepth = currentDepth;

        if(node.right ==  null && node.left == null)
        {
            return currentDepth;
        }
        else
        {
            if(node.right != null)
            {
                rightDepth = getLongestDepth(node.right, currentDepth+1);
            }
            if(node.left != null)
            {
                leftDepth = getLongestDepth(node.left, currentDepth+1);
            }
        }

        return leftDepth > rightDepth ? leftDepth : rightDepth;
    }
}
