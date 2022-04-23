package eagle_view_test;

import java.util.Collections;
import java.util.PriorityQueue;

public class PolutionFilter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] array = {5, 19, 8, 1};
		int[] array2 = {10, 10};
		int[] array3 = {3,0, 5};
		
		PolutionFilter obj = new PolutionFilter();
		
		System.out.println(obj.solution(array));
		System.out.println(obj.solution(array2));
		System.out.println(obj.solution(array3));

	}

	public int solution(int[] A) {

		int totalPollution = 0;
		PriorityQueue<Integer> pQueue = new PriorityQueue<>(Collections.reverseOrder());		

		for (int a : A) {
			pQueue.add(a);
			totalPollution = totalPollution + a;
		}

		double minimunPolutionLevel = (double) totalPollution / 2;

		int numberOfFilters = 0;

		while (totalPollution > minimunPolutionLevel) {

			double filteredValue = (double) pQueue.poll() / 2;
			totalPollution = (int) (totalPollution - filteredValue);
			numberOfFilters++;
			pQueue.add((int) filteredValue);

		}
		return numberOfFilters;
	}
}
