package programmers.탐욕법.큰_수_만들기;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

	@Test
	void case1() {

		Solution solution = new Solution();

		assertEquals("94", solution.solution("1924", 2));
	}
	@Test
	void case2() {

		Solution solution = new Solution();

		assertEquals("3234", solution.solution("1231234", 3));
	}
	@Test
	void case3() {

		Solution solution = new Solution();

		assertEquals("775841", solution.solution("4177252841", 4));
	}
//
//	@Test
//	void case2() {
//
//		int[]    lost     = { 2, 4 };
//		int[]    reserve  = { 3 };
//		Solution solution = new Solution();
//
//		assertEquals(4, solution.solution(5, lost, reserve));
//	}
//
//	@Test
//	void case3() {
//		int[]    lost     = { 3 };
//		int[]    reserve  = { 1 };
//		Solution solution = new Solution();
//
//		assertEquals(4, solution.solution(3, lost, reserve));
//	}
}
