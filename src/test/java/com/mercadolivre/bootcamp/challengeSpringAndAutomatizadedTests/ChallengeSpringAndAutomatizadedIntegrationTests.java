package com.mercadolivre.bootcamp.challengeSpringAndAutomatizadedTests;

import com.mercadolivre.bootcamp.challengeSpringAndAutomatizadedTests.dtos.HouseDTO;
import com.mercadolivre.bootcamp.challengeSpringAndAutomatizadedTests.dtos.RoomDTO;
import com.mercadolivre.bootcamp.challengeSpringAndAutomatizadedTests.exceptions.NoAliasFoundedException;
import com.mercadolivre.bootcamp.challengeSpringAndAutomatizadedTests.models.PropertyAliasModel;
import com.mercadolivre.bootcamp.challengeSpringAndAutomatizadedTests.services.HouseService;
import com.mercadolivre.bootcamp.challengeSpringAndAutomatizadedTests.services.implementations.HouseServiceImplementation;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;

@SpringBootTest
public class ChallengeSpringAndAutomatizadedIntegrationTests {

    private static PropertyAliasModel aliasModel = new PropertyAliasModel();
    private static HouseDTO house = new HouseDTO();
    private static HouseService service = new HouseServiceImplementation();
    private static RoomDTO room = new RoomDTO();
    private static List<RoomDTO> rooms = new ArrayList<>();

    @BeforeAll
    public static void initTests() {
        room.setWidth(5.0);
        room.setLength(4.0);
        room.setName("Sala");
        rooms.add(room);

        room.setWidth(5.0);
        room.setLength(6.0);
        room.setName("Sala 2");
        rooms.add(room);

        room.setWidth(5.0);
        room.setLength(5.0);
        room.setName("Sala 3");
        rooms.add(room);

        house.setName("Jairo's House");
        house.setAlias("Fortaleza");
        house.setRooms(rooms);
    }

    @Test
    public void shouldReturnAmountOfHouse() throws NoAliasFoundedException {
        assertThat(service.getHouseAmount(house).getAmount()).isEqualTo(75000.0);
    }

}
