package programmers.해시.위장;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SolutionTest {

	@Test
	void case1() {
		String[][] clothes  = { { "yellowhat", "headgear" }, { "bluesunglasses", "eyewear" },{ "green_turban", "headgear" } };

		Solution   solution = new Solution();

		assertEquals(5, solution.solution(clothes));
	}

	@Test
	void case2() {
		String[][] clothes  = { { "crowmask", "face" }, { "bluesunglasses", "face" }, { "smoky_makeup", "face" } };

		Solution   solution = new Solution();

		assertEquals(3, solution.solution(clothes));
	}

}
