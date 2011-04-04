package goodcode.action;

import goodcode.util.FileUtil;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import org.seasar.cubby.action.Action;
import org.seasar.cubby.action.ActionResult;
import org.seasar.cubby.action.Forward;
import org.seasar.cubby.action.Path;

/**
 * Step4:配列/コレクション化
 */
@Path("/")
public class Step4Action extends Action {
	
	public static final String[] PATHS = {
		"/images/food",
		"/images/animal",
		"/images/landscape"
	};
	
	public ServletContext context;
	public List<ImageFiles> filesList;
	
	public ActionResult step4() {
		List<ImageFiles> filesList = new ArrayList<ImageFiles>();
		for (String path : PATHS) {
			filesList.add(getFiles(path));
		}
		this.filesList = filesList;
		return new Forward("step4.jsp");
	}
	
	private ImageFiles getFiles(String path) {
		File[] files =  new File(context.getRealPath(path)).listFiles();
		return new ImageFiles(path, files);
	}

	public static class ImageFiles {
		private final String path;
		private final File[] files;
		private final long size;

		public ImageFiles(String path, File[] files) {
			this.path = path;
			this.files = files;
			this.size = FileUtil.sizeOfFiles(files);
		}
		
		public String getPath() {
			return this.path;
		}
		
		public File[] getFiles() {
			return this.files;
		}
		
		public long getSizeOfFiles() {
			return this.size;
		}
	}
}