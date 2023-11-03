package avinh.codejams2023.pennypackingbackend.model.stuffing;

import avinh.codejams2023.pennypackingbackend.model.turkey.Coordinate;

public class HorizontalCoin {

    public Coordinate[] coordinateList;
    public Coordinate size;

    public HorizontalCoin(Coordinate coordinate, Coordinate size) {
        this.size = size;
        updatePosition(coordinate);
    }

    // Manually declare X Y Z
    public HorizontalCoin(Coordinate coordinate, int xSize, int ySize, int zSize) {
        this(coordinate, new Coordinate(xSize, ySize, zSize));
    }

    // Radius & Height Constructor
    public HorizontalCoin(Coordinate coordinate, int height, int radius) {
        this(coordinate, new Coordinate((radius/2), height, (radius/2)));
    }
    
    // Size constructor where height == radius
    public HorizontalCoin(Coordinate coordinate, int size) {
        this(coordinate, size, size, size);
    }

    public void updatePosition(Coordinate coordinate) {
        
        double xMin = coordinate.x - 0.5 * size.x;
        double yMin = coordinate.y - 0.5 * size.y;
        double zMin = coordinate.z - 0.5 * size.z;
        double xMax = coordinate.x + 0.5 * size.x;
        double yMax = coordinate.y + 0.5 * size.y;
        double zMax = coordinate.z + 0.5 * size.z;

        coordinateList = new Coordinate[] {
            new Coordinate(xMin, yMin, zMin),
            new Coordinate(xMin, yMin, zMax),
            new Coordinate(xMax, yMin, zMin),
            new Coordinate(xMax, yMin, zMax),
            new Coordinate(xMin, yMax, zMin),
            new Coordinate(xMin, yMax, zMax),
            new Coordinate(xMax, yMax, zMin),
            new Coordinate(xMax, yMax, zMax)
        };
    }

    public void displaceByCoordinate(Coordinate displacement) {
        for (Coordinate coordinate : coordinateList) {
            coordinate.displace(displacement);
        }
    }

    public void displaceByUnit(Coordinate displacement) {
        displacement.x *= size.x;
        displacement.y *= size.y;
        displacement.z *= size.z;

        displaceByCoordinate(displacement);
    }

    public String toString() {
        String returnString = "";

        for (Coordinate coordinate : coordinateList) {
            returnString += coordinate;
        }

        return returnString;
    }

    public static void main(String[] args) {

        Coordinate myCoordinate = new Coordinate(0.5, 0.5, 0.5);
        HorizontalCoin myCoin = new HorizontalCoin(myCoordinate, 1);

        System.out.println("Constructor Test");
        System.out.println(myCoin);
        System.out.println();

        myCoordinate = new Coordinate(1, 1, 1);
        myCoin.displaceByCoordinate(myCoordinate);

        System.out.println("Displacement By Coordinate Test");
        System.out.println(myCoin);
        System.out.println();

        myCoin = new HorizontalCoin(myCoordinate, 2);

        System.out.println("Constructor Test");
        System.out.println(myCoin);
        System.out.println();

        myCoin.displaceByUnit(myCoordinate);

        System.out.println("Dispacement By Unit Test");
        System.out.println(myCoin);
        System.out.println();
    }
}
