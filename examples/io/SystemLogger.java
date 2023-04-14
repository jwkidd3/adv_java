package examples.io;

import java.io.*;

public class SystemLogger {

	public static void main(String[] args) {
		File logFile = new File("/tmp/log.txt");
		if(!logFile.exists()) {
			try {
				if(logFile.createNewFile()) {
					FileOutputStream fos = new FileOutputStream(logFile);
					PrintStream pos = new PrintStream(fos);
					System.setOut(pos);
				}
			} catch (IOException e) {
				System.err.println("Can not change std out - using console: " + e.getMessage());
			}
		}

		System.out.println("Test output");
	}

}
