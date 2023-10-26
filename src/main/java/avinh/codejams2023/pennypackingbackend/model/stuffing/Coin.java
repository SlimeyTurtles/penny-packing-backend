package avinh.codejams2023.pennypackingbackend.model.stuffing;

import avinh.codejams2023.pennypackingbackend.model.turkey.Coordinate;

public class Coin {
    
    public Coordinate[] coordinateList; // List of coordinates to check
    public Coordinate position;

    public Coin(Coordinate[] coordinateList, Coordinate position) {
        this.coordinateList = coordinateList;
    }

    public Coin(Coordinate[] coordinateList) {
        this.coordinateList = coordinateList;
        this.position = new Coordinate(0,0,0);
    }

    public void setPosition(Coordinate newPosition) {
        for (Coordinate coordinate : coordinateList) {
            coordinate.x += newPosition.x - position.x;
            coordinate.y += newPosition.y - position.y;
            coordinate.z += newPosition.z - position.z;
        }
    }

    public void displacePosition(Coordinate newPosition) {
        for (Coordinate coordinate : coordinateList) {
            coordinate.x += newPosition.x;
            coordinate.y += newPosition.y;
            coordinate.z += newPosition.z;
        }
        
        this.position.x += newPosition.x;
        this.position.y += newPosition.y;
        this.position.z += newPosition.z;
    }

    public String toString() {
        String returnString = "";

        for (Coordinate coordinate : coordinateList) {
            returnString += coordinate;
        }

        return returnString;
    }

    public static void main(String[] args) {
        Coin myCoin = new Coin(new Coordinate[]{
            new Coordinate(-1, -1, -1),
            new Coordinate(-1, -1, 1),
            new Coordinate(1, -1, -1),
            new Coordinate(1, -1, 1),
            new Coordinate(-1, 1, -1),
            new Coordinate(-1, 1, 1),
            new Coordinate(1, 1, -1),
            new Coordinate(1, 1, 1)
        });
        
        myCoin.setPosition(new Coordinate(1,1,1));
        System.out.println(myCoin);
        myCoin.setPosition(new Coordinate(-3,-4,5));
        System.out.println(myCoin);
    }
    
}
