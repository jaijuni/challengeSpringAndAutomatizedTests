package com.mercadolivre.bootcamp.challengeSpringAndAutomatizadedTests.controllers;

import com.mercadolivre.bootcamp.challengeSpringAndAutomatizadedTests.dtos.HouseDTO;
import com.mercadolivre.bootcamp.challengeSpringAndAutomatizadedTests.dtos.RoomDTO;
import com.mercadolivre.bootcamp.challengeSpringAndAutomatizadedTests.services.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;

@RestController
public class HouseController {
    @Autowired
    private HouseService houseService;

    @GetMapping("/house/size")
    public HouseDTO getTotalHouseSize(@RequestBody @Valid HouseDTO house) {
        return houseService.getHouseSize(house);
    }

    @GetMapping("/house/value")
    public HouseDTO getHouseAmount(@RequestBody @Valid HouseDTO house) {
        return houseService.getHouseAmount(house);
    }

    @GetMapping("/house/biggerRoom")
    public RoomDTO getBiggerRoom(@RequestBody @Valid HouseDTO house) {
        return houseService.getBiggestRoom(house);
    }

    @GetMapping("/house/room/sizes")
    public HashMap<String, Double> getTotalSizesByRoom(@RequestBody @Valid HouseDTO house) {
        return houseService.getTotalSizeByRoom(house);
    }
}
