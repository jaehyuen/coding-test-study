package programmers.해시.완주하지_못한_선수;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SolutionTest {

	@Test
	void case1() {
		String[] participant = { "leo", "kiki", "eden" };
		String[] completion  = { "eden", "kiki" };

		Solution solution    = new Solution();

		assertEquals("leo", solution.solution(participant, completion));
	}
	
	@Test
	void case2() {
		String[] participant = { "marina", "josipa", "nikola", "vinko", "filipa" };
		String[] completion  = { "josipa", "filipa", "marina", "nikola" };

		Solution solution    = new Solution();

		assertEquals("vinko", solution.solution(participant, completion));
	}

	@Test
	void case3() {
		String[] participant = { "mislav", "stanko", "mislav", "ana" };
		String[] completion  = { "stanko", "ana", "mislav" };

		Solution solution    = new Solution();

		assertEquals("leo", solution.solution(participant, completion));
	}

}
