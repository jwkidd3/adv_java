package concurrent.semaphore;

import java.util.concurrent.Semaphore;

public class SemaphoreTest {
	private final Semaphore roomOrganizer = new Semaphore(2, true);

	public static void main(String[] args) {
		SemaphoreTest test = new SemaphoreTest();
		test.mystart();

	}

	public void mystart() {
		for (int i = 0; i < 10; i++) {
			People people = new People();
			people.start();
		}
	}

	public class People extends Thread {
		@Override
		public void run() {
			try {
				roomOrganizer.acquire();
			} catch (InterruptedException e) {
				System.out.println("received InterruptedException");
				return;
			}
			System.out.println("Thread " + this.getId()
					+ " starts to use the room");
			try {
				sleep(1000);
			} catch (InterruptedException e) {

			}
			System.out.println("Thread " + this.getId() + " leave the room\n");
			roomOrganizer.release();
		}
	}
}