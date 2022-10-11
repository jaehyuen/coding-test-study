package baekjoon.브루트포스.물건_팔기;

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

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[][] arr = new int[N][2];

		for (int i = 0; i < N; i++) {

			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
		}

		//가격순 정렬
		Arrays.sort(arr, (o1, o2) -> {
			return o1[0] - o2[0];
		});

        int maxPrice = 0;
        int maxTotalPrice = 0;

        for(int i = 0 ; i < N ; i++){
            int total = 0;
            
            //판매시 이득이면 추가
            for(int j = i; j < N ;j++){
                int tmp = arr[i][0] - arr[j][1];
                if(tmp > 0)
                    total += tmp;
            }
            
            //최대값 갱신
            if(maxTotalPrice < total){
                maxTotalPrice = total;
                maxPrice = arr[i][0];
            }
        }

        System.out.println(maxPrice);

	}
}