package baekjoon.그리디.떡국;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader            br  = new BufferedReader(new InputStreamReader(System.in));
		int                       N   = Integer.parseInt(br.readLine());
		StringTokenizer           st  = new StringTokenizer(br.readLine());

		// 그릇 크기 카운팅
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		//그릇 크기별 갯수중에 가장 많은 만큼 탑이 쌓아진다
		int                       max = 0;

		for (int i = 0; i < N; i++) {
			
			int c   = Integer.parseInt(st.nextToken());
			int tmp = map.getOrDefault(c, 0) + 1;
			map.put(c, tmp);
			max = Math.max(tmp, max);

		}
		System.out.println(max);
	}

}
