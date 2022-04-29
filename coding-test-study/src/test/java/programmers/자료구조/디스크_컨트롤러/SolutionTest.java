package programmers.자료구조.디스크_컨트롤러;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SolutionTest {

	@Test
	void case1() {

		int[][]  jobs     = { { 0, 3 }, { 2, 6 }, { 1, 9 } };

		Solution solution = new Solution();

		assertEquals(9, solution.solution(jobs));
	}

	@Test
	void case2() {

		int[][]  jobs     = { { 0, 10 }, { 4, 10 }, { 5, 11 }, { 15, 2 } };

		Solution solution = new Solution();
		assertEquals(15, solution.solution(jobs));
	}

}
