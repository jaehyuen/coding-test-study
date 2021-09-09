package programmers.탐욕법.단속카메라;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

	@Test
	void case1() {

		int[][]  routes   = { { -20, 15 }, { -14, -5 }, { -18, -13 }, { -5, -3 } };

		Solution solution = new Solution();

		assertEquals(2, solution.solution(routes));
	}

}
