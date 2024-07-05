package challenge07;

public class Test {

	public static void main(String[] args) {

//
//		long start = System.currentTimeMillis();
//
//		long counter = 0;
//
//		for (int i = 0; i < 40_000 * 40_000; i++) {
//
//			counter++;
//		}
//
//		long diff = System.currentTimeMillis() - start;
//
//		System.out.println(diff / 1000);
//		System.out.println(counter);

		Solution.solution(new int[]{4,2}, new int[]{1,1}, new int[]{3,1}, 12);
//		Solution.solution(new int[]{300,275}, new int[]{150,150}, new int[]{185,100}, 500);
//		Solution.solution(new int[]{3,2}, new int[]{1,1}, new int[]{2,1}, 4);
//		Solution.solution(new int[]{3,3}, new int[]{1,1}, new int[]{2,2}, 10000);
	}
}
