package com.mercadolivre.bootcamp.challengeSpringAndAutomatizadedTests;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

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
import org.mockito.*;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@SpringBootTest
class ChallengeUnitTests {

	private static HouseDTO houseDTO = new HouseDTO();
	@InjectMocks
	private static HouseService service = new HouseServiceImplementation();
	private static RoomDTO room = new RoomDTO();
	private static RoomDTO room1 = new RoomDTO();
	private static RoomDTO room2 = new RoomDTO();
	private static List<RoomDTO> rooms = new ArrayList<>();
	private static PropertyAliasModel alias = new PropertyAliasModel();
	private static HashMap<String, Double> listOfAliases = new HashMap<String, Double>();


	@BeforeAll
	public static void initTheHouseObject() {
		room.setName("Living Room");
		room.setLength(30.0);
		room.setWidth(30.0);
		rooms.add(room);

		room1.setName("Kitchen");
		room1.setLength(20.0);
		room1.setWidth(20.0);
		rooms.add(room1);

		room2.setName("Bed Room");
		room2.setLength(20.0);
		room2.setWidth(30.0);
		rooms.add(room2);

		houseDTO.setName("Test's House");
		houseDTO.setAlias("Jardim Leoni");
		houseDTO.setRooms(rooms);

	}

	@Test
	public void shouldReturnTheTotalOfSquareMetersOfAHouse() {
		Double houseSizeToCompare = 1900.0;

		Double testCase = service.getHouseSize(houseDTO);

		assertThat(testCase).isEqualTo(houseSizeToCompare);
	}

	@Test
	public void shouldReturnAnExceptionIfAliasNotFound() throws NoAliasFoundedException {
		assertThatThrownBy(() -> alias.getByAliasName("Jardim Leonis"))
				.isInstanceOf(NoAliasFoundedException.class)
				.hasMessage("Alias not founded on database");
	}

	@Test
	public void shouldReturnValueOfSquareMeterOfAnAlias() throws NoAliasFoundedException{
		Double expectedValue = 1000.0;

		Double testCase = alias.getByAliasName("Fortaleza");

		assertThat(testCase).isEqualTo(expectedValue);
	}

	@Test
	public void shouldReturnTheBiggestRoomFromTheHouse() {
		RoomDTO biggestRoom = rooms.get(0);
		RoomDTO testCase = HouseModel.getBiggestRoom(houseDTO);
		assertThat(testCase).isEqualTo(biggestRoom);
	}

	@Test
	public void shouldReturnTheCorrectSizeOfARoom() {
		assertThat(RoomModel.getSize(room)).isEqualTo(room.getLength() * room.getWidth());
	}
}
