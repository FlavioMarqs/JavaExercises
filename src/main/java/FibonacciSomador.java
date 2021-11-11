public class FibonacciSomador
{
    private int[] fibonacciSum;

    public FibonacciSomador()
    {
        fibonacciSum = new int[20];
    }

    public int ManeiraMa(int n)
    {
        if(n > 1000)
            return -1;

        switch(n)
        {
            case 0: return 0;
            case 1:
            case 2: return 1;
            case 3: return 2;
        }

        int[] vals = new int[n];
        vals[0] = 0;
        vals[1] = 1;
        vals[2] = 1;
        vals[3] = 2;

        for(int i=2; i<n; i++)
        {
            vals[i] = vals[i-1] + vals[i-2];
        }

        return vals[n-1]+vals[n-2];
    }

    public int NesimoValor(int n)
    {
        if(n > 1000)
            return -1;

        int val = 0;
       switch(n)
       {
           case 0: val = 0;
           break;
           case 1: val = 1;
           break;
           case 2: val = 1;
           default: val = NesimoValor(n-1) + NesimoValor(n-2);
           break;
       }

       fibonacciSum[n] = val;
       return val;
    }
}