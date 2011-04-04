package goodcode.action;

import goodcode.util.FileUtil;

import java.io.File;

import javax.servlet.ServletContext;

import org.seasar.cubby.action.Action;
import org.seasar.cubby.action.ActionResult;
import org.seasar.cubby.action.Forward;
import org.seasar.cubby.action.Path;

/**
 * Step2:可読性を高めるためのメソッドの抽出
 */
@Path("/")
public class Step2Action extends Action {
	
	public ServletContext context;
	public File[] foodFiles;
	public File[] animalFiles;
	public File[] landscapeFiles;
	public long foodSize;
	public long animalSize;
	public long landscapeSize;
	
	public ActionResult step2() {
		foodFiles = getFiles("/images/food");
		animalFiles = getFiles("/images/animal");
		landscapeFiles = getFiles("/images/landscape");
		foodSize = FileUtil.sizeOfFiles(foodFiles);
		animalSize = FileUtil.sizeOfFiles(animalFiles);
		landscapeSize = FileUtil.sizeOfFiles(landscapeFiles);
		return new Forward("step2.jsp");
	}

	private File[] getFiles(String path) {
		File[] files = new File(context.getRealPath(path)).listFiles();
		return files;
	}
}