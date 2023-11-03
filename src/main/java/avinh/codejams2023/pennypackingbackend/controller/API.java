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

    @CrossOrigin(
        origins = {"http://localhost:3000", "https://penny-packing.vercel.app/"}, 
        allowedHeaders = "Requestor-Type", 
        exposedHeaders = "{Access-Control-Allow-Origin")
    @GetMapping("/square/{shapeSize}/{coinSize}")
    public ResponseEntity<List<Coordinate>> getSquare(
        @PathVariable("shapeSize") int shapeSize,
        @PathVariable("coinSize") int coinSize
        ) {

        HttpHeaders headers = new HttpHeaders();

        Cube myCube = new Cube(shapeSize);
        HorizontalCoin myCoin = new HorizontalCoin(new Coordinate(0, 0, 0), coinSize);
        Stuffer myStuffer = new Stuffer();

        Coordinate[] coordinateList = myStuffer.cubicStuffer(myCube, myCoin);

        ArrayList<Coordinate> myList = new ArrayList<Coordinate>();

        for (Coordinate coordinate : coordinateList) {
            myList.add(coordinate);
        }

        return ResponseEntity.ok().headers(headers).body(myList);
    }

}
