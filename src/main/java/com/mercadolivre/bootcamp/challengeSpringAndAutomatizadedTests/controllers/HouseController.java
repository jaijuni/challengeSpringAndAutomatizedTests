package com.mercadolivre.bootcamp.challengeSpringAndAutomatizadedTests.controllers;

import com.mercadolivre.bootcamp.challengeSpringAndAutomatizadedTests.dtos.HouseDTO;
import com.mercadolivre.bootcamp.challengeSpringAndAutomatizadedTests.dtos.RoomDTO;
import com.mercadolivre.bootcamp.challengeSpringAndAutomatizadedTests.exceptions.NoAliasFoundedException;
import com.mercadolivre.bootcamp.challengeSpringAndAutomatizadedTests.services.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;

@RestController
public class HouseController {
    @Autowired
    private HouseService houseService;

    @GetMapping("/house/size")
    public ResponseEntity getTotalHouseSize(@RequestBody @Valid HouseDTO house) {
        return new ResponseEntity(houseService.getHouseSize(house), HttpStatus.OK);
    }

    @GetMapping("/house/value")
    public HouseDTO getHouseAmount(@RequestBody @Valid HouseDTO house) throws NoAliasFoundedException {
        return houseService.getHouseAmount(house);
    }

    @GetMapping("/house/room/biggest-room")
    public RoomDTO getBiggerRoom(@RequestBody @Valid HouseDTO house) {
        return houseService.getBiggestRoom(house);
    }

    @GetMapping("/house/rooms/size")
    public HashMap<String, Double> getTotalSizesByRoom(@RequestBody @Valid HouseDTO house) {
        return houseService.getTotalSizeByRoom(house);
    }
}
