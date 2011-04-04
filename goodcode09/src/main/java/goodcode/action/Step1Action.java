package goodcode.action;

import java.io.File;

import javax.servlet.ServletContext;

import org.seasar.cubby.action.Action;
import org.seasar.cubby.action.ActionResult;
import org.seasar.cubby.action.Forward;
import org.seasar.cubby.action.Path;

/**
 * Step1:べたに実装
 */
@Path("/")
public class Step1Action extends Action {
	
	public ServletContext context;
	public File[] foodFiles;
	public File[] animalFiles;
	public File[] landscapeFiles;
	public long foodSize;
	public long animalSize;
	public long landscapeSize;
	
	public ActionResult step1() {
		foodFiles = new File(context.getRealPath("/images/food")).listFiles();
		animalFiles = new File(context.getRealPath("/images/animal")).listFiles();
		landscapeFiles = new File(context.getRealPath("/images/landscape")).listFiles();
		foodSize = sizeOfFiles(foodFiles);
		animalSize = sizeOfFiles(animalFiles);
		landscapeSize = sizeOfFiles(landscapeFiles);
		return new Forward("step1.jsp");
	}
	
	public long sizeOfFiles(File[] files) {
		long totalSize = 0;
		for (File file : files) {
			totalSize += file.length();
		}
		return totalSize;
	}
}