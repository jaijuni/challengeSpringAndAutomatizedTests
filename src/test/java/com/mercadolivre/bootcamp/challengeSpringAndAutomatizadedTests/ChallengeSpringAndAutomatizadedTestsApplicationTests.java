package com.mercadolivre.bootcamp.challengeSpringAndAutomatizadedTests;

import static org.assertj.core.api.Assertions.*;
import com.mercadolivre.bootcamp.challengeSpringAndAutomatizadedTests.dtos.HouseDTO;
import com.mercadolivre.bootcamp.challengeSpringAndAutomatizadedTests.dtos.RoomDTO;
import com.mercadolivre.bootcamp.challengeSpringAndAutomatizadedTests.exceptions.NoAliasFoundedException;
import com.mercadolivre.bootcamp.challengeSpringAndAutomatizadedTests.models.HouseModel;
import com.mercadolivre.bootcamp.challengeSpringAndAutomatizadedTests.models.PropertyAliasModel;
import com.mercadolivre.bootcamp.challengeSpringAndAutomatizadedTests.models.RoomModel;
import com.mercadolivre.bootcamp.challengeSpringAndAutomatizadedTests.services.HouseService;
import com.mercadolivre.bootcamp.challengeSpringAndAutomatizadedTests.services.implementations.HouseServiceImplementation;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@SpringBootTest
class ChallengeSpringAndAutomatizadedTestsApplicationTests {
	private static HouseDTO houseDTO = new HouseDTO();
	private static HouseService service = new HouseServiceImplementation();
	private static RoomDTO room = new RoomDTO();
	private static List<RoomDTO> rooms = new ArrayList<>();
	private static PropertyAliasModel alias = new PropertyAliasModel();
	private static HashMap<String, Double> listOfAliases = new HashMap<String, Double>();

	@BeforeAll
	public static void initTheHouseObject() {
		room.setName("Living Room");
		room.setLength(20.0);
		room.setWidth(30.0);
		rooms.add(room);

		room.setName("Kitchen");
		room.setLength(20.0);
		room.setWidth(20.0);
		rooms.add(room);

		room.setName("Bed Room");
		room.setLength(20.0);
		room.setWidth(30.0);
		rooms.add(room);

		houseDTO.setName("Test's House");
		houseDTO.setAlias("Jardim Leoni");
		houseDTO.setRooms(rooms);

		alias.setAliases(listOfAliases);
	}

	@Test
	public void shouldReturnTheTotalOfSquareMetersOfAHouse() {
		Double houseSize = 0.0;

		for (int i=0; i < houseDTO.getRooms().size(); i++) {
			RoomDTO room = houseDTO.getRooms().get(i);
			houseSize = houseSize + (room.getLength() * room.getWidth());
		}

		assertThat(service.getHouseSize(houseDTO)).isEqualTo(houseSize);
	}

	@Test
	public void shouldReturnAnExceptionIfAliasNotFound() {
		assertThatThrownBy(() -> service.getValueByAliasName("Jardim Leoni 2")).hasMessage("Alias not founded on database");
	}

	@Test
	public void shouldReturnValueOfSquareMeterOfAnAlias() throws NoAliasFoundedException{
		assertThat(service.getValueByAliasName("Jardim Leoni")).isEqualTo(800.0);
	}

	@Test
	public void shouldReturnTheBiggestRoomFromTheHouse() {
		List<RoomDTO> rooms = houseDTO.getRooms();
		RoomDTO biggestRoom = rooms.get(0);

		for (int i = 1; i< rooms.size(); i++) {
			RoomDTO room = rooms.get(i);
			if(RoomModel.getSize(room) > RoomModel.getSize(biggestRoom)) {
				biggestRoom = room;
			}
		}

		assertThat(service.getBiggestRoom(houseDTO)).isEqualTo(biggestRoom);
	}

	@Test
	public void shouldReturnTheCorrectNumberOfARoom() {
		RoomDTO room = houseDTO.getRooms().get(0);
		assertThat(RoomModel.getSize(room)).isEqualTo(room.getLength() * room.getWidth());
	}
}
