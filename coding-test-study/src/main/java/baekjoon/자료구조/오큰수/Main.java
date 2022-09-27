package baekjoon.자료구조.오큰수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader  br  = new BufferedReader(new InputStreamReader(System.in));

		int             N   = Integer.parseInt(br.readLine());
		int[]           arr = new int[N];
		int[]           r   = new int[N];
		Stack<Integer>  s   = new Stack<Integer>();

		StringTokenizer st  = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());

		}
		StringBuilder sb = new StringBuilder();


		for (int i = N - 1; i >= 0; i--) {

			//현재 값보다 작으면 다 뺴준다
			while (!s.empty() && s.peek() <= arr[i])
				s.pop();

			//값이 없으면 -1
			if (s.empty())
				r[i] = -1;
			else
				r[i] = s.peek();

			//현재값을 스택에넣어줌
			s.push(arr[i]);
		}

		for (int i : r) {
			sb.append(i + " ");
		}
		System.out.println(sb.toString());

	}

}
