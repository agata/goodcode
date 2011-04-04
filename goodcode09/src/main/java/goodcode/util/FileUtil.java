package goodcode.util;

import java.io.File;

public class FileUtil {
	public static long sizeOfFiles(File[] files) {
		long totalSize = 0;
		for (File file : files) {
			totalSize += file.length();
		}
		return totalSize;
	}
}
