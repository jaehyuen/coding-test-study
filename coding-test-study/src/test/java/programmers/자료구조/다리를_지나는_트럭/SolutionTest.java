package programmers.자료구조.다리를_지나는_트럭;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SolutionTest {

	@Test
	void case1() {

		int[]    truck_weights = { 7, 4, 5, 6 };

		Solution solution      = new Solution();

		assertEquals(8, solution.solution(2, 10, truck_weights));
	}

	@Test
	void case2() {

		int[]    truck_weights = { 10 };

		Solution solution      = new Solution();

		assertEquals(101, solution.solution(100, 100, truck_weights));
	}

	@Test
	void case3() {

		int[]    truck_weights = { 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 };

		Solution solution      = new Solution();

		assertEquals(110, solution.solution(100, 100, truck_weights));
	}

//	@Test
//	void case2() {
//
//		int[]    priorities = { 1, 1, 9, 1, 1, 1 };
//
//		Solution solution   = new Solution();
//
//		assertEquals(5, solution.solution(priorities, 0));
//	}
//
//	@Test
//	void case3() {
//
//		int[]    priorities = { 2, 1, 2, 1, 2 };
//
//		Solution solution   = new Solution();
//
//		assertEquals(5, solution.solution(priorities, 0));
//	}

}
