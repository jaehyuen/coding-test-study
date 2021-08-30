package programmers.자료구조.기능개발;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SolutionTest {

	@Test
	void case1() {

		int[]    progresses = { 93, 30, 55 };
		int[]    speeds     = { 1, 30, 5};

		Solution solution   = new Solution();

		assertEquals(new int[] { 4, 1, 3, 0 }, solution.solution(progresses, speeds));
	}
	
	@Test
	void case2() {

		int[]    progresses = { 95, 90, 99, 99, 80, 99 };
		int[]    speeds     = { 1, 1, 1, 1, 1, 1};

		Solution solution   = new Solution();

		assertEquals(new int[] { 4, 1, 3, 0 }, solution.solution(progresses, speeds));
	}

}
