package avinh.codejams2023.pennypackingbackend.model.turkey;

public class Cube extends Shape {

    public Cube(int size) {
        super(new Surface[]{
            new Surface(new Coordinate((-size/2),(-size/2),(-size/2)), new Coordinate((-size/2),(-size/2),(size/2)), new Coordinate((size/2),(-size/2),(-size/2))),
            new Surface(new Coordinate((-size/2),(-size/2),(-size/2)), new Coordinate((-size/2),(size/2),(-size/2)), new Coordinate((-size/2),(-size/2),(size/2))),
            new Surface(new Coordinate((-size/2),(-size/2),(-size/2)), new Coordinate((size/2),(-size/2),(-size/2)), new Coordinate((-size/2),(size/2),(-size/2))),
            new Surface(new Coordinate((size/2),(size/2),(size/2)), new Coordinate((-size/2),(size/2),(size/2)), new Coordinate((size/2),(size/2),(-size/2))),
            new Surface(new Coordinate((size/2),(size/2),(size/2)), new Coordinate((size/2),(size/2),(-size/2)), new Coordinate((size/2),(-size/2),(size/2))),
            new Surface(new Coordinate((size/2),(size/2),(size/2)), new Coordinate((size/2),(-size/2),(size/2)), new Coordinate((-size/2),(size/2),(size/2)))
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
