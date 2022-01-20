package baekjoon.그래프.맥주_마시면서_걸어가기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));

		int            T   = Integer.parseInt(br.readLine());
		int            INF = 987654321;

		for (int i = 0; i < T; i++) {

			int             N    = Integer.parseInt(br.readLine());

			boolean[][]     arr  = new boolean[N + 2][N + 2];

			ArrayList<Node> list = new ArrayList<>();

			for (int j = 0; j < N + 2; j++) {
				StringTokenizer st   = new StringTokenizer(br.readLine());
				int             tmp1 = Integer.parseInt(st.nextToken());
				int             tmp2 = Integer.parseInt(st.nextToken());
				list.add(new Node(tmp1, tmp2));
			}

			for (int j = 0; j < N + 2; j++) {
				for (int j2 = j + 1; j2 < N + 2; j2++) {
					if (getDistance(list.get(j), list.get(j2)) <= 1000) {
						arr[j][j2] = arr[j2][j] = true;
					}
				}
			}

			for (int j = 0; j < N + 2; j++) {
				for (int j2 = 0; j2 < N + 2; j2++) {
					for (int k = 0; k < N + 2; k++) {

						if (arr[j2][j] && arr[j][k]) {
							arr[j2][k] = true;
						}
					}
				}
			}

			System.out.println(arr[0][N + 1] ? "happy" : "sad");
//         }

		}

	}

	public static int getDistance(Node n1, Node n2) {

		return Math.abs(n1.x - n2.x) + Math.abs(n1.y - n2.y);

	}

}

class Node {
	int x;
	int y;

	public Node(int x, int y) {
		this.x = x;
		this.y = y;
	}
}