package avinh.codejams2023.pennypackingbackend.model.turkey;

public class Shape {
    public Surface[] surfaceList;
    public Coordinate minCoordinate, maxCoordinate;
    
    public Shape(Surface[] surfaceList) {
        
        minCoordinate = new Coordinate(
            surfaceList[0].A.x,
            surfaceList[0].A.y,
            surfaceList[0].A.z
        );

        maxCoordinate = new Coordinate(
            surfaceList[0].A.x,
            surfaceList[0].A.y,
            surfaceList[0].A.z
        );

        for (Surface surface : surfaceList) {
            Coordinate[] coordinateList = new Coordinate[]{surface.A, surface.B, surface.C};

            for (Coordinate testCoordinate : coordinateList) {
                if (testCoordinate.x < minCoordinate.x) { minCoordinate.x = testCoordinate.x; } 
                else if (testCoordinate.x > maxCoordinate.x) { maxCoordinate.x = testCoordinate.x; }
                if (testCoordinate.y < minCoordinate.y) { minCoordinate.y = testCoordinate.y; } 
                else if (testCoordinate.y > maxCoordinate.y) { maxCoordinate.y = testCoordinate.y; }
                if (testCoordinate.z < minCoordinate.z) { minCoordinate.z = testCoordinate.z; } 
                else if (testCoordinate.z > maxCoordinate.z) { maxCoordinate.z = testCoordinate.z; }
            }
        }
        
        this.surfaceList = surfaceList;
    }

    public Shape(Surface[] surfaceList, Coordinate minCoordinate, Coordinate maxCoordinate) {
        this.surfaceList = surfaceList;
        this.minCoordinate = minCoordinate;
        this.maxCoordinate = maxCoordinate;
    }

    public boolean checkBounds(Coordinate testCoordinate) {
        for (Surface surf : surfaceList) {
            if (!surf.checkBounds(testCoordinate)) {
                return false;
            }
        }
        return true;
    }

    public String toString() {
        return "minCoordinate: " + minCoordinate + "\nmaxCoordinate: " + maxCoordinate + "\n";
    }

    public static void main(String[] args) {

        Coordinate A = new Coordinate(-1, 1, 0);
        Coordinate B = new Coordinate(-1, 0, 1);
        Coordinate C = new Coordinate(0, 0, 0);

        Coordinate D = new Coordinate(-12, 1, -3);
        Coordinate E = new Coordinate(100, 12, 1);
        Coordinate F = new Coordinate(4, -1211, 4);

        Surface[] surfaceList = new Surface[]{
            new Surface(A,B,C),
            new Surface(D,E,F)
        };
        Shape myShape = new Shape(surfaceList);
        
        System.out.println(myShape);
    }
}