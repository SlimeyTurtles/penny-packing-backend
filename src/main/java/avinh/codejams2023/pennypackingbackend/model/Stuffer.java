package avinh.codejams2023.pennypackingbackend.model;
import java.util.ArrayList;

import avinh.codejams2023.pennypackingbackend.model.stuffing.HorizontalCoin;
import avinh.codejams2023.pennypackingbackend.model.turkey.Coordinate;
import avinh.codejams2023.pennypackingbackend.model.turkey.Cube;
import avinh.codejams2023.pennypackingbackend.model.turkey.Shape;

public class Stuffer {
    
    public boolean checkCoin(Shape shape, HorizontalCoin coin) {
        for (Coordinate coordinate : coin.coordinateList) {
            if (!shape.checkBounds(coordinate)) {
                return false;
            }
        }
        return true;
    }

    public Coordinate[] cubicStuffer(Shape shape, HorizontalCoin coin) {

        ArrayList<Coordinate> arrayList = new ArrayList<Coordinate>();

        for (double x = shape.minCoordinate.x + (coin.size.x / 2); x < shape.maxCoordinate.x; x += coin.size.x) {
            for (double y = shape.minCoordinate.y + (coin.size.y / 2); y < shape.maxCoordinate.y; y += coin.size.y) {
                for (double z = shape.minCoordinate.z + (coin.size.z / 2); z < shape.maxCoordinate.z; z += coin.size.z) {
                    Coordinate coordinate = new Coordinate(x, y, z);

                    coin.updatePosition(coordinate);

                    if (checkCoin(shape, coin)) {
                        arrayList.add(coordinate);
                    }
                }
            }
        }

        Coordinate[] returnList = new Coordinate[arrayList.size()];

        for (int i = 0; i < arrayList.size(); i++) {
            returnList[i] = arrayList.get(i);
        }

        return returnList;
    }

    public static void main(String[] args) {
        Cube myCube = new Cube(3);
        Coordinate myCoordinate = new Coordinate(0, 0, 0);
        HorizontalCoin myCoin = new HorizontalCoin(myCoordinate, 1);
        Stuffer myStuffer = new Stuffer();

        Coordinate[] coordinateList = myStuffer.cubicStuffer(myCube, myCoin);

        for (Coordinate coordinate : coordinateList) {
            System.out.println(coordinate);
        }
    }

}
