

import java.util.HashMap;
import java.util.Map;

class KeylessEntry extends Object{

	static class Key {
		Integer id;
		Byte[] b;
		
		Key(Integer id) {
			this.id = id;
			b= new Byte[100];
		}

		@Override
		public int hashCode() {
			return id.hashCode();
		}
	}

	public static void main(String[] args) {
		Map m = new HashMap();
		while (true) {
			int i = 0;
			for (; i < 100000; i++) {
				if (!m.containsKey(new Key(i)))
					m.put(new Key(i), "Number:" + i);
			}
			System.out.println("Running: "+i);
			System.gc();
		}
	}
}