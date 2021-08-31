package programmers.자료구조.주식가격;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SolutionTest {

	@Test
	void case1() {

		int[]    prices = {1, 2, 3, 2, 3 };

		Solution solution      = new Solution();

		assertEquals(8, solution.solution(prices));
	}


}
