package examples.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestCollectionsUtils {
	public static void main(String[] args) {
		List<Integer> numbers = new ArrayList<>(12);
		for (int i = 1; i <= 12; i++) {
			numbers.add(new Integer(i));
		}
		System.out.println("Starting List\n" + numbers);
		Collections.shuffle(numbers); // Randomize
		System.out.println("Shuffled List\n" + numbers);
		Collections.sort(numbers); // Sort
		System.out.println("Sorted List\n" + numbers);
		List<Integer> numbers2 = Collections.unmodifiableList(numbers);
		Collections.shuffle(numbers); // woops!
	}
}