package avinh.codejams2023.pennypackingbackend.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import avinh.codejams2023.pennypackingbackend.model.Stuffer;
import avinh.codejams2023.pennypackingbackend.model.stuffing.HorizontalCoin;
import avinh.codejams2023.pennypackingbackend.model.turkey.Coordinate;
import avinh.codejams2023.pennypackingbackend.model.turkey.Cube;

@RestController
@RequestMapping("/api")
public class API {

    @GetMapping("/square")
    public List<Coordinate> getSquare() {
        Cube myCube = new Cube(20);
        Coordinate myCoordinate = new Coordinate(0, 0, 0);
        HorizontalCoin myCoin = new HorizontalCoin(myCoordinate, 2);
        Stuffer myStuffer = new Stuffer();

        Coordinate[] coordinateList = myStuffer.stuff(myCube, myCoin);

        ArrayList<Coordinate> myList = new ArrayList<Coordinate>();

        for (Coordinate coordinate : coordinateList) {
            myList.add(coordinate);
        }

        return myList;
    }

    @CrossOrigin(
        origins = {"http://localhost:3000", "https://penny-packing.vercel.app/"}, 
        allowedHeaders = "Requestor-Type", 
        exposedHeaders = "{Access-Control-Allow-Origin")
    @GetMapping("/square/{size}")
    public ResponseEntity<List<Coordinate>> getSquare(@PathVariable("size") int size) {

        HttpHeaders headers = new HttpHeaders();
        headers.set("Access-Control-Allow-Origin", "true");

        Cube myCube = new Cube(size);
        Coordinate myCoordinate = new Coordinate(0, 0, 0);
        HorizontalCoin myCoin = new HorizontalCoin(myCoordinate, 2);
        Stuffer myStuffer = new Stuffer();

        Coordinate[] coordinateList = myStuffer.stuff(myCube, myCoin);

        ArrayList<Coordinate> myList = new ArrayList<Coordinate>();

        for (Coordinate coordinate : coordinateList) {
            myList.add(coordinate);
        }

        return ResponseEntity.ok().headers(headers).body(myList);
    }

}
