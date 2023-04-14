import java.util.HashMap;
import java.util.Map;

public class CollectionTestOthers {

	public static void main(String[] args) {

		Map<Integer, Integer> list = new HashMap<Integer, Integer>();
		final int counter = 100000;
		int result = 0;

		long startTime = System.currentTimeMillis();
		for (int i = 0; i < counter; i++)
			list.put(i, i);
		long endTime = System.currentTimeMillis();

		System.out.println(endTime - startTime);

		startTime = System.currentTimeMillis();

		for (int i = 0; i < counter; i++) {
			list.get(i);
		}

		endTime = System.currentTimeMillis();

		System.out.println(endTime - startTime);

		startTime = System.currentTimeMillis();
		for (int i = 0; i < counter; i++)
			list.remove(0);
		endTime = System.currentTimeMillis();

		System.out.println(endTime - startTime);
	}
}
