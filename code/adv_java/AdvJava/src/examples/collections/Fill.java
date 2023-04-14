package examples.collections;

import java.util.Collection;
import java.util.Iterator;

class Fill {
	static Collection init(Collection c, int slots) {
		for (int i = 0; i < slots; i++) {
			c.add("Test Value " + i);
		}
		return c;
	}

	static void deleteSecond(Collection c) {
		Iterator itr = c.iterator();
		boolean even = false;
		while (itr.hasNext()) {
			itr.next();
			if (even) {
				itr.remove();
			}
			even = !even;
		}
	}
}