package goodcode.action;

import goodcode.util.FileUtil;

import java.io.File;

import javax.servlet.ServletContext;

import org.seasar.cubby.action.Action;
import org.seasar.cubby.action.ActionResult;
import org.seasar.cubby.action.Forward;
import org.seasar.cubby.action.Path;

/**
 * Step3:関連のあるデータをオブジェクトに
 */
@Path("/")
public class Step3Action extends Action {
	
	public ServletContext context;
	public ImageFiles foodFiles;
	public ImageFiles animalFiles;
	public ImageFiles landscapeFiles;
	
	public ActionResult step3() {
		foodFiles = getFiles("/images/food");
		animalFiles = getFiles("/images/animal");
		landscapeFiles = getFiles("/images/landscape");
		return new Forward("step3.jsp");
	}
	
	private ImageFiles getFiles(String path) {
		File[] files =  new File(context.getRealPath(path)).listFiles();
		return new ImageFiles(files, FileUtil.sizeOfFiles(files));
	}

	public static class ImageFiles {
		private final File[] files;
		private long size;

		public ImageFiles(File[] files, long size) {
			this.files = files;
			this.size = size;
		}
		
		public File[] getFiles() {
			return this.files;
		}
		
		public long getSizeOfFiles() {
			return this.size;
		}
	}
}