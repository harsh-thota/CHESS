public class main {
	public static void main(String[] args) {
		board b = new board();
		b.init();
		b.print();
		b.printCor();
		b.capture(new int[]{6,3},new int[] {5,3});
		b.capture(new int[]{6,4},new int[] {4,4});
		b.capture(new int[]{7,4},new int[] {6,3});
		b.capture(new int[]{6,3},new int[] {5,2});
		b.capture(new int[]{5,2},new int[] {4,2});
		b.capture(new int[]{4,2},new int[] {4,3});
		b.capture(new int[]{1,4},new int[] {3,4});
		b.capture(new int[]{4,3},new int[] {3,4});
		b.print();

	}

	
	
}
