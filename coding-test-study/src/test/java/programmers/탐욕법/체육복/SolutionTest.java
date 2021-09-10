package programmers.탐욕법.체육복;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

	@Test
	void case1() {

		int[]    lost     = { 2, 4 };
		int[]    reserve  = { 1, 3, 5 };
		Solution solution = new Solution();

		assertEquals(4, solution.solution(5, lost, reserve));
	}

	@Test
	void case2() {

		int[]    lost     = { 2, 4 };
		int[]    reserve  = { 3 };
		Solution solution = new Solution();

		assertEquals(4, solution.solution(5, lost, reserve));
	}

	@Test
	void case3() {
		int[]    lost     = { 3 };
		int[]    reserve  = { 1 };
		Solution solution = new Solution();

		assertEquals(4, solution.solution(3, lost, reserve));
	}
	@Test
	void case4() {
		int[]    lost     = { 2, 3, 4 };
		int[]    reserve  = {1, 2, 3 };
		Solution solution = new Solution();

		assertEquals(4, solution.solution(5, lost, reserve));
	}
	
	@Test
	void case5() {
		int[]    lost     = { 2,4 };
		int[]    reserve  = { 3,1 };
		Solution solution = new Solution();

		assertEquals(5, solution.solution(5, lost, reserve));
	}

}
