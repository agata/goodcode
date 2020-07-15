package goodcode.util;

import java.io.File;

public class FileUtil {
	public static long sizeOfFiles(File[] files) {
		var totalSize = 0;
		for (var file : files) {
			totalSize += file.length();
		}
		return totalSize;
	}
}
