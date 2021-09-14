package programmers.탐욕법.섬_연결하기;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

	@Test
	void case1() {

		int[][]  costs    = {{0, 1, 1}, {0, 4, 5}, {2, 4, 1}, {2, 3, 1}, {3, 4, 1}};

		Solution solution = new Solution();

		assertEquals(8, solution.solution(5, costs));
	}

	@Test
	void case2() {

		int[][]  costs    = { { 0, 1, 5 }, { 1, 2, 3 }, { 2, 3, 3 }, { 3, 1, 2 }, { 3, 0, 4 }, { 2, 4, 6 },
				{ 4, 0, 7 } };

		Solution solution = new Solution();

		assertEquals(15, solution.solution(5, costs));
	}
	
}
