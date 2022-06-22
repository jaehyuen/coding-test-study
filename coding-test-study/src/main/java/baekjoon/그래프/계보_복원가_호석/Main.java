package baekjoon.그래프.계보_복원가_호석;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader                     br      = new BufferedReader(new InputStreamReader(System.in));
		int                                N       = Integer.parseInt(br.readLine());

		StringTokenizer                    st      = new StringTokenizer(br.readLine());

		// 이름, 순번 맵핑
		HashMap<String, Integer>           people1 = new HashMap<>();
		HashMap<Integer, String>           people2 = new HashMap<>();

		// 선조 리스트 저장 맵
		HashMap<String, ArrayList<String>> map     = new HashMap<String, ArrayList<String>>();

		// 관계 저장용 리스트
		ArrayList<ArrayList<Integer>>      graph   = new ArrayList<ArrayList<Integer>>();

		for (int i = 0; i < N; i++) {
			String name = st.nextToken();

			people1.put(name, i);
			people2.put(i, name);

			graph.add(new ArrayList<Integer>());
		}

		int   M = Integer.parseInt(br.readLine());

		int[] v = new int[N];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int tmp1 = people1.get(st.nextToken());
			int tmp2 = people1.get(st.nextToken());

			graph.get(tmp2)
				.add(tmp1);

			v[tmp1]++;

		}

		// 시초 저장용 리스트
		ArrayList<String> fatherList = new ArrayList<String>();
		Queue<String>     q          = new LinkedList<String>();

		// 가문의 시초를 찾아낸다
		for (Entry<String, Integer> m : people1.entrySet()) {
			if (v[m.getValue()] == 0) {
				fatherList.add(m.getKey());
				q.add(m.getKey());
			}
		}

		// 위상정렬
		while (!q.isEmpty()) {
			String now    = q.poll();
			int    nowIdx = people1.get(now);

			for (int next : graph.get(nowIdx)) {
				v[next]--;

				if (v[next] == 0) {

					// 본인의 자식을 저장
					String            nextName = people2.get(next);
					ArrayList<String> tmpList  = map.getOrDefault(now, new ArrayList<>());
					tmpList.add(nextName);
					map.put(now, tmpList);

					q.add(people2.get(next));
				}
			}

		}

		// 가문의 시초를 정렬
		Collections.sort(fatherList);

		// 가문의 갯수 출력
		System.out.println(fatherList.size());

		// 가문의 시초 출력
		for (String father : fatherList) {
			System.out.print(father + " ");
		}
		System.out.println();

		// 이름 리스트 정렬
		ArrayList<String> nameList = new ArrayList<String>(people1.keySet());
		Collections.sort(nameList);

		for (String name : nameList) {

			// 자식 리스트 get 및 정렬
			ArrayList<String> childList = map.getOrDefault(name, new ArrayList<String>());
			Collections.sort(childList);

			// 자식 리스트 출력
			System.out.print(name + " " + childList.size() + " ");

			for (String child : childList) {
				System.out.print(child + " ");
			}
			System.out.println();
		}

	}

}
