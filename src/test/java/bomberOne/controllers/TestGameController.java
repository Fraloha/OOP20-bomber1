package bomberone.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.Test;

public class TestGameController {

	List<Integer> exList = List.of(1,2,3);
	
	@Test
	public void testList() {
		assertEquals(List.of(1,2,3), exList);
	}
}
