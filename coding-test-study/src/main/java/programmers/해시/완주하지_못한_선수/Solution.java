package programmers.해시.완주하지_못한_선수;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
	
	public String solution(String[] participant, String[] completion) {
		List<String> participantList = new ArrayList<String>(Arrays.asList(participant));
		List<String> completionList  = new ArrayList<String>(Arrays.asList(completion));
		participantList.sort(null);
		completionList.sort(null);

		for (int i = 0; i < completionList.size(); i++) {
			if (!participantList.get(i)
				.equals(completionList.get(i))) {
				return participantList.get(i);
			}
		}
		return participantList.get(participantList.size() - 1);
	}
}
