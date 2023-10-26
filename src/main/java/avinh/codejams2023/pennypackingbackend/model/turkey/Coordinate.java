package avinh.codejams2023.pennypackingbackend.model.turkey;

public class Coordinate {

    public double x, y, z;

    public Coordinate(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public void displace(Coordinate coordinate) {
        x += coordinate.x;
        y += coordinate.y;
        z += coordinate.z;
    }

    public String toString() {
        return "(" + x + ", " + y + ", " + z + ")\n";
    }

    public static void main(String[] args) {
        Coordinate myCoordinate = new Coordinate(1, -2, 3);
        System.out.println(myCoordinate);

        Coordinate displacement = new Coordinate(5, -3, 0);
        myCoordinate.displace(displacement);
        System.out.println(myCoordinate);
    }
}
