package MapaRectangularStuff;

import java.util.LinkedList;
import java.util.List;

public class GuardFinder {

    public GuardFinder()
    {
    }

    public int[][][] findShortestPathsToGuard(MapaRectangular map)
    {
        int[][][] values = new int[map.horizontalSize][map.verticalSize][2];

        for(int i=0; i<map.horizontalSize; i++)
        {
            for(int j=0; j<map.verticalSize; j++)
            {
                values[i][j] = findClosestGuard(map, i, j);
            }
        }

        return values;
    }

    private int[] findClosestGuard2(MapaRectangular map, int x, int y)
    {
        // todo : this
        return null;
    }

    private int[] findClosestGuard(MapaRectangular map, int x, int y)
    {
        if(map.map[x][y] == PositionType.TypeWall)
            return new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE};

        List<int[]> distances = new LinkedList<int[]>();
        int hitCount = 0;
        // calculate forwards, horizontally:
        for(int i=x; i<map.horizontalSize; i++)
        {
            // calculate downwards, vertically:
            for(int j=y; j<map.verticalSize; j++)
            {
                PositionType current = map.map[i][j];
                if(current == PositionType.TypeGuard)
                {
                    distances.add(new int[]{i-x, j-y});
                }
                if(current == PositionType.TypeWall)
                {
                    distances.add(new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE});
                }
            }
            // calculate upwards, vertically:
            for(int j=y; j>=0; j--)
            {
                PositionType current = map.map[i][j];
                if(current == PositionType.TypeGuard)
                {
                    distances.add(new int[]{i-x, y-j});
                }
                if(current == PositionType.TypeWall)
                {
                    distances.add(new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE});
                }
            }
        }

        // calculate backwards, horizontally:
        for(int i=x; i>=0; i--)
        {
            // calculate downwards, vertically:
            for(int j=y; j<map.verticalSize; j++)
            {
                PositionType current = map.map[i][j];
                if(current == PositionType.TypeGuard)
                {
                    distances.add(new int[]{x-i, j-y});
                }
                if(current == PositionType.TypeWall)
                {
                    distances.add(new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE});
                }
            }
            // calculate upwards, vertically:
            for(int j=y; j>=0; j--)
            {
                PositionType current = map.map[i][j];
                if(current == PositionType.TypeGuard)
                {
                    distances.add(new int[]{x-i, y-j});
                }
                if(current == PositionType.TypeWall)
                {
                    distances.add(new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE});
                }
            }
        }

        int shortest = Integer.MAX_VALUE;
        int[] shortestDistanceInCoordinates = new int[2];
        for(int[] dist : distances)
        {
            if(dist[0] == Integer.MIN_VALUE || dist[1] == Integer.MIN_VALUE)
                continue;

            int temp = dist[0]+dist[1];
            if(temp <= shortest)
            {
                shortest = temp;
                shortestDistanceInCoordinates = dist;
            }
        }

        return shortestDistanceInCoordinates;
    }
}
