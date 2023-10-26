package avinh.codejams2023.pennypackingbackend.model.turkey;
public class Surface {
    
    public double[] vector = new double[3];
    public Coordinate A, B, C;

    // A is the hand, B is the index finger (x-axis), C is the middle finger (z-axis)
    public Surface(Coordinate A, Coordinate B, Coordinate C) {
        
        // Solves for the vector components of the surfaces normal vector
        this.vector[0] = (A.y-B.y)*(A.z-C.z) - (A.y-C.y)*(A.z-B.z);
        this.vector[1] = (A.x-C.x)*(A.z-B.z) - (A.x-B.x)*(A.z-C.z);
        this.vector[2] = (A.x-B.x)*(A.y-C.y) - (A.x-C.x)*(A.y-B.y);
        
        this.A = A;
        this.B = B;
        this.C = C;
    }

    // Solves for which region the checkCoordinate is on of the Surface plane
    // Returns true if on the same side as the Surface normal vector, false otherwise
    public boolean checkBounds(Coordinate checkCoordinate) {
        return 
            vector[0] * (checkCoordinate.x - A.x) + 
            vector[1] * (checkCoordinate.y - A.y) + 
            vector[2] * (checkCoordinate.z - A.z) >= 0 
            ? true : false;
    }

    // Tester method
    public static void main(String[] args) {
        Surface surf = new Surface(new Coordinate(1,3,4), new Coordinate(3,1,0), new Coordinate(2,2,1));
        System.out.println("x: " + surf.vector[0]);
        System.out.println("y: " + surf.vector[1]);
        System.out.println("z: " + surf.vector[2]);

        System.out.println("In bounds check: " + surf.checkBounds(new Coordinate(3,1,0)));
        System.out.println("In bounds check: " + surf.checkBounds(new Coordinate(2,2,1)));
        System.out.println("In bounds check: " + surf.checkBounds(new Coordinate(-100,100,0)));
        System.out.println("In bounds check: " + surf.checkBounds(new Coordinate(-20,1,-20)));
    }
}