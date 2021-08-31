package programmers.자료구조.더_맵게;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SolutionTest {

	@Test
	void case1() {

		int[]    prices = {1, 2, 3, 9, 10, 12 };

		Solution solution      = new Solution();

		assertEquals(2, solution.solution(prices,7));
	}


}
