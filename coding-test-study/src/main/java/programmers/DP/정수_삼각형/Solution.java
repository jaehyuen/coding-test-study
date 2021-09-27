package programmers.DP.정수_삼각형;

class Solution {
	public int solution(int[][] triangle) {

		for (int i = triangle.length - 2; i >= 0; i--) {
			for (int j = 0; j < triangle[i].length; j++) {

				triangle[i][j] += triangle[i + 1][j] > triangle[i + 1][j + 1] ? triangle[i + 1][j]
						: triangle[i + 1][j + 1];

			}
		}

		return triangle[0][0];
	}
}
