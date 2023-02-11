# 수 고르기

### 문제

N개의 자연수가 좌우로 배열되어 있다. 여러분은 이 중 K개를 골라야 한다. 고를 때는 K개 모두를 한번에 골라야 한다.

여러분이 고른 수 각각에 대해서 그 수의 점수를 계산할 것이다. 점수는 자신의 수에서 자신의 왼쪽에 있는 수 중 선택된 수의 개수를 뺀 값이다. 이렇게 고른 수 각각에 그 점수를 계산한 후 전체점수는 계산된 점수들의 합이다. 여러분은 전체점수가 최대가 되도록 K개의 수를 골라야 한다.

예를 들어서, N = 5개의 자연수가 순서대로 2 3 1 2 1 로 주어지고, K = 3이라고 하자. 만약 첫 번째 2와 두 개의 1을 골랐다면, 각 수의 점수를 계산해서 나열하면 2 0 −1과 같다. 따라서 전체 점수는 1이다. 만약 첫 번째 2와 3, 그리고 두 번째 2를 고르고, 각 수의 점수를 계산해서 나열하면, 2 2 0과 같다. 따라서 전체점수는 4이다. 이 예에서 전체점수의 최댓값은 4이다.

N개의 자연수 배열과 양의 정수 K가 주어질 때, 전체점수의 최댓값을 출력하는 프로그램을 작성하시오.

### 입력

첫 번째 줄에 N과 K가 공백 하나를 사이로 두고 주어진다. 두 번째 줄에 N개의 자연수가 공백 하나를 사이에 두고 주어진다.

### 출력

첫 번째 줄에 주어진 N개의 수 중 K개의 수를 고를 때, 전체점수의 최댓값을 출력한다.

### 제한

- 1 ≤ N ≤ 5 000
- 1 ≤ K ≤ N
- 주어지는 자연수는 1 이상 100 000 이하

### 서브태스크

<table class="table table-bordered td-middle subtask-table" style="width: 100%;">
	<thead>
		<th style="width: 5%;">번호</th><th style="width: 5%;">배점</th><th style="width: 90%;">제한</th>
	</thead>
	<tbody>
		<tr data-subtask-id="1"><td>1</td><td>4</td><td class="subtask-body"><p>N &le; 3</p></td>
		</tr>
		<tr data-subtask-id="2"><td>2</td><td>25</td><td class="subtask-body"><p>N &le; 20</p></td>
		</tr><tr data-subtask-id="3"><td>3</td><td>7</td><td class="subtask-body"><p>K = 1</p></t>
		</tr>
		<tr data-subtask-id="4"><td>4</td><td>9</td><td class="subtask-body"><p>K = 2</p></td></tr>
		<tr data-subtask-id="5"><td>5</td><td>15</td><td class="subtask-body"><p>주어지는 N개의 수가 단조증가(감소하지 않는 순서)로 정렬되어 있다. 이는 즉, N개의 수 각각에 대해 그 수의 왼쪽에는 해당 수 이하의 값들만 있고, 오른쪽에는 해당 수 이상의 값들만 있다는 뜻이다.</p></td></tr>
		<tr data-subtask-id="6"><td>6</td><td>40</td><td class="subtask-body"><p>추가 제약 조건없음</p></td></tr>
	</tbody>
</table>

### 예제 입력 1 

~~~
5 3
2 3 1 2 1
~~~

### 예제 출력 1 

~~~
4
~~~

### 예제 입력 2 

~~~
6 2
4 1 5 2 6 3
~~~

### 예제 출력 2 

~~~
10
~~~