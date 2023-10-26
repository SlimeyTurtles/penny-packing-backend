package avinh.codejams2023.pennypackingbackend.model.turkey;

public class Cube extends Shape {

    public Cube(int size) {
        super(new Surface[]{
            new Surface(new Coordinate(0,0,0), new Coordinate(0,0,size), new Coordinate(size,0,0)),
            new Surface(new Coordinate(0,0,0), new Coordinate(0,size,0), new Coordinate(0,0,size)),
            new Surface(new Coordinate(0,0,0), new Coordinate(size,0,0), new Coordinate(0,size,0)),
            new Surface(new Coordinate(size,size,size), new Coordinate(0,size,size), new Coordinate(size,size,0)),
            new Surface(new Coordinate(size,size,size), new Coordinate(size,size,0), new Coordinate(size,0,size)),
            new Surface(new Coordinate(size,size,size), new Coordinate(size,0,size), new Coordinate(0,size,size))
        });
    }

    public static void main(String[] args) {
        Cube myCube = new Cube(3);

        System.out.println(myCube);

        System.out.println("True: " + myCube.checkBounds(new Coordinate(0,0,0)));
        System.out.println("True: " + myCube.checkBounds(new Coordinate(1,1,1)));
        System.out.println("True: " + myCube.checkBounds(new Coordinate(2,2,2)));
        System.out.println("True: " + myCube.checkBounds(new Coordinate(3,3,3)));
        System.out.println("False: " + myCube.checkBounds(new Coordinate(4,4,4)));
        System.out.println("False: " + myCube.checkBounds(new Coordinate(-1,-1,-1)));
        System.out.println("False: " + myCube.checkBounds(new Coordinate(5,0,0)));
        System.out.println("False: " + myCube.checkBounds(new Coordinate(0,5,0)));
        System.out.println("False: " + myCube.checkBounds(new Coordinate(5,0,5)));
    }
    
}
