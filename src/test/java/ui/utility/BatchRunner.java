package ui.utility;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

public class BatchRunner {
	static Runtime rt = Runtime.getRuntime();
	static Process child1, child2;
	private static String basedir = System.getProperty("user.dir");
	private static String command1, command2;

	public static void main(String[] arr) {
		String dir = basedir + "/mongo-batch";
		String ext = ".bat";
		findExeFiles(dir, ext);
	}

	private static void findExeFiles(String dir, String ext) {
		File file = new File(dir);
		if (!file.exists())
			System.out.println(dir + " Directory doesn't exists");
		File[] listFiles = file.listFiles(new MyFileNameFilter(ext));
		if (listFiles.length == 0) {
			System.out.println(dir + "doesn't have any file with extension " + ext);
		} else {
			for (File f : listFiles)
				command1 = "cmd.exe /c start" + " " + f.getAbsolutePath();
			command2 = "cmd.exe /c start" + " " + " java -jar " + dir + "/klov-0.1.0.jar";
			try {
				System.out.println("here");

				child1 = rt.exec(command1);
				child2 = rt.exec(command2);
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static class MyFileNameFilter implements FilenameFilter {
		private String ext;

		public MyFileNameFilter(String ext) {
			this.ext = ext.toLowerCase();
		}

		@Override
		public boolean accept(File dir, String name) {
			return name.toLowerCase().endsWith(ext);
		}
	}
}