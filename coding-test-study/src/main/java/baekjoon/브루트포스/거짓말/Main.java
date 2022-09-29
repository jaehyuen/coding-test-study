package baekjoon.브루트포스.거짓말;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	static Set<Integer>                  trueSet = new HashSet<Integer>();

	// 사람별 파티 참여정보
	static ArrayList<ArrayList<Integer>> list    = new ArrayList<ArrayList<Integer>>();

	// 파티 정보
	static ArrayList<ArrayList<Integer>> pList   = new ArrayList<ArrayList<Integer>>();

	public static void main(String[] args) throws IOException {
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int             N  = Integer.parseInt(st.nextToken());
		int             M  = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());

		int tmp = Integer.parseInt(st.nextToken());

		// 진실을 아는사람 추가
		for (int i = 0; i < tmp; i++) {
			trueSet.add(Integer.parseInt(st.nextToken()));

		}

		for (int i = 0; i <= N; i++) {
			list.add(new ArrayList<Integer>());
		}

		// 파티 정보와 사랑별 파티 참여정보 저장
		for (int i = 0; i < M; i++) {
			st  = new StringTokenizer(br.readLine());
			tmp = Integer.parseInt(st.nextToken());

			ArrayList<Integer> p = new ArrayList<Integer>();

			// 파티에 추가
			for (int j = 0; j < tmp; j++) {

				int person = Integer.parseInt(st.nextToken());
				list.get(person)
					.add(i);
				p.add(person);
			}

			pList.add(p);

		}

		int cnt = 0;

		for (ArrayList<Integer> party : pList) {
			if (find(party, N)) {
				cnt++;
			}

		}
		System.out.println(cnt);
	}

	public static boolean find(ArrayList<Integer> party, int n) {
		Queue<Integer> q = new LinkedList<Integer>();

		// 방문 체크
		boolean[]      v = new boolean[n + 1];

		// 우선 진실을 아는자가 있는지 확인
		for (int i : party) {
			if (trueSet.contains(i)) {
				return false;
			}
			q.add(i);
			v[i] = true;
		}

		while (!q.isEmpty()) {
			int now = q.poll();

			// 본인이 포함된 파티 인덱스 조회
			for (int partyIdx : list.get(now)) {

				// 파티별 참가자 반복
				for (int i : pList.get(partyIdx)) {

					// 우선 진실을 아는자가 있는지 확인
					if (trueSet.contains(i)) {
						return false;
					} else {
						// 체크를 안해봣으면 큐에 넣는다
						if (!v[i]) {
							q.add(i);
							v[i] = true;
						}

					}

				}

			}
		}

		return true;
	}
}