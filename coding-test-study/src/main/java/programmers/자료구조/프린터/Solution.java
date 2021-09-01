package programmers.자료구조.프린터;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {

	public int solution(int[] priorities, int location) {

		List<Integer>       prioritiesList  = Arrays.stream(priorities)
			.boxed()
			.collect(Collectors.toList());
		LinkedList<Integer> prioritiesQueue = new LinkedList<>(prioritiesList);
		prioritiesList.sort(null);

		int stize  = priorities.length;
		int result = 0;

		for (int i = 9; i > 0; i--) {
			for (int j = 0; j < prioritiesQueue.size(); j++) {
				
				if (prioritiesQueue.get(0) == i) {
					System.out.println("삭제 : " + prioritiesQueue.get(0));
					result++;
					prioritiesQueue.set(0, 0);
					
					// location=location+i/stize;
//					j--;
				}
				System.out.println(prioritiesQueue+" location : "+location);
				if (prioritiesQueue.get(location) == 0) {
					break;
				}
				prioritiesQueue.add(prioritiesQueue.get(0));
				prioritiesQueue.removeFirst();
				
				if(location < 1) {
					location=stize-1;
				}else {
					location--;
				}
			//	location = location > stize ? 0 : location++;
//				int tmp=prioritiesQueue.get(0);
//				prioritiesQueue.set(0,0);
//				prioritiesQueue.set(j,0);

			}
			System.out.println();
			//System.out.println(prioritiesQueue);

		}
		//System.out.println(prioritiesList);
		System.out.println(result);
		System.out.println();

//		location+i/size
		return 1;
	}

}
