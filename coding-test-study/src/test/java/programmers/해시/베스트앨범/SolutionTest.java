package programmers.해시.베스트앨범;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SolutionTest {

	@Test
	void case1() {

		String[] genres   = { "classic", "pop", "classic", "classic", "pop" };
		int[]    plays    = { 500, 600, 150, 800, 2500 };

		Solution solution = new Solution();

		assertEquals(new int[] { 4, 1, 3, 0 }, solution.solution(genres, plays));
	}

}
