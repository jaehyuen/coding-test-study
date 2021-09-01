package programmers.자료구조.프린터;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SolutionTest {

	@Test
	void case1() {

		int[]    priorities = { 2, 1, 3, 2 };

		Solution solution   = new Solution();

		assertEquals(1, solution.solution(priorities, 2));
	}

	@Test
	void case2() {

		int[]    priorities = { 1, 1, 9, 1, 1, 1 };

		Solution solution   = new Solution();

		assertEquals(5, solution.solution(priorities, 0));
	}

	@Test
	void case3() {

		int[]    priorities = { 2, 1, 2, 1, 2 };

		Solution solution   = new Solution();

		assertEquals(5, solution.solution(priorities, 0));
	}

}
