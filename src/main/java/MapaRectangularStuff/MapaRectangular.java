package MapaRectangularStuff;

public class MapaRectangular {

    public int horizontalSize;
    public int verticalSize;

    public int guardCount = 0;

    public PositionType[][] map;

    public MapaRectangular(int h, int v)
    {
        horizontalSize = h;
        verticalSize = v;

        map = new PositionType[h][v];
    }

    public void setGuard(int h, int v)
    {
        if(h >= 0 && h < horizontalSize &&
           v >= 0 && v < verticalSize)
        {
            map[h][v] = PositionType.TypeGuard;
            guardCount++;
        }
    }

    public void setWall(int h, int v)
    {
        if(h >= 0 && h < horizontalSize &&
                v >= 0 && v < verticalSize)
        {
            map[h][v] = PositionType.TypeWall;
        }
    }

    public void setEmpty(int h, int v)
    {
        if(h >= 0 && h < horizontalSize &&
                v >= 0 && v < verticalSize)
        {
            map[h][v] = PositionType.TypeEmpty;
        }
    }
}
