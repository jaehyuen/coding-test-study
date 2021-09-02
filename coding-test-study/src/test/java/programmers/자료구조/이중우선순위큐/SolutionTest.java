package programmers.자료구조.이중우선순위큐;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SolutionTest {

	@Test
	void case1() {

		String[] operations = { "I 16", "D 1" };

		Solution solution   = new Solution();

		assertEquals(2, solution.solution(operations));
	}

	@Test
	void case2() {

		String[] operations = { "I 7", "I 5", "I -5", "D -1" };

		Solution solution   = new Solution();

		assertEquals(2, solution.solution(operations));
	}

}
