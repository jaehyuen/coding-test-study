package baekjoon.브루트포스.크면서_작은_수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static int[] arr1;
	static int[] arr2;
	static boolean[] v;

	static int size = 0;
	static int X = 0;

	static ArrayList<Integer> list = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String tmp = br.readLine();
		char[] charTmp = tmp.toCharArray();
		X = Integer.parseInt(tmp);
		size = charTmp.length;

		arr1 = new int[charTmp.length];
		arr2 = new int[charTmp.length];
		v = new boolean[charTmp.length];

		// 숫자 한자리씩 저장
		for (int i = 0; i < charTmp.length; i++) {
			arr1[i] = charTmp[i] - '0';
		}

		find(0);
		
		//찾은 값을 정렬하여 가장 작은값을 뽑는다
		Collections.sort(list);

		//배열이 비었으면 0 출력
		if (list.isEmpty()) {
			System.out.println(0);
		} else {
			System.out.println(list.get(0));
		}

	}

	public static void find(int idx) {
		
		//같은 자리수를 찾으면 저장
		if (idx == size) {
			String tmp = "";

			//순서대로 조합
			for (int i = 0; i < arr2.length; i++) {
				tmp += arr2[i];
			}
			
			//숫자로 변경
			int num = Integer.parseInt(tmp);

			//처음값보다 크면 리스트에 추가
			if (num > X) {
				list.add(Integer.parseInt(tmp));
			}

			return;
		}

		for (int i = 0; i < size; i++) {
			if (!v[i]) {
				v[i] = true;
				arr2[idx] = arr1[i];
				find(idx + 1);
				v[i] = false;
			}
		}

	}
}