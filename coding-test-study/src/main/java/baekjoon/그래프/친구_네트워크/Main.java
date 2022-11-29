package baekjoon.그래프.친구_네트워크;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

	public static int[] arr;
	public static int[] friendCnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder  sb = new StringBuilder();

		int            T  = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			int                      F         = Integer.parseInt(br.readLine());

			HashSet<String>          set       = new HashSet<String>();
			HashMap<String, Integer> map       = new HashMap<String, Integer>();

			String[][]               friendArr = new String[F][2];

			// 사람 정보 저장
			for (int j = 0; j < F; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());

				friendArr[j][0] = st.nextToken();
				friendArr[j][1] = st.nextToken();

				set.add(friendArr[j][0]);
				set.add(friendArr[j][1]);
			}

			int j = 1;
			arr       = new int[set.size() + 1];
			friendCnt = new int[set.size() + 1];

			// 사람을 이름별로 인덱스 부여
			for (String s : set) {

				map.put(s, j);
				arr[j]       = j;
				friendCnt[j] = 1;

				j++;
			}

			for (String[] f : friendArr) {

				// 사람 두명의 부모를 구함
				int a = find(map.get(f[0]));
				int b = find(map.get(f[1]));

				// 부모가 다르면 연결
				if (a != b) {
					if (a > b) {
						arr[a] = b;
					} else {
						arr[b] = a;
					}

					// 친구 카운트를 합쳐준다
					friendCnt[a] += friendCnt[b];
					friendCnt[b]  = friendCnt[a];

				}

				sb.append(friendCnt[a] + "\n");

			}

		}
		System.out.println(sb.toString());

	}

	public static int find(int node) {
		if (node == arr[node]) {
			return node;
		}

		return arr[node] = find(arr[node]);
	}
}
