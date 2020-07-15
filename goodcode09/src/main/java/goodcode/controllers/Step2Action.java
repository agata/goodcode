package goodcode.controllers;

import goodcode.util.FileUtil;

import java.io.File;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Step2:可読性を高めるためのメソッドの抽出
 */
@Controller
public class Step2Action {
	
	@Autowired
	ServletContext context; 
	
	@RequestMapping("/step2")
	public String step2(Model model) {
		var foodFiles = getFiles("/images/food");
		var animalFiles = getFiles("/images/animal");
		var landscapeFiles = getFiles("/images/landscape");
		var foodSize = FileUtil.sizeOfFiles(foodFiles);
		var animalSize = FileUtil.sizeOfFiles(animalFiles);
		var landscapeSize = FileUtil.sizeOfFiles(landscapeFiles);
		model.addAttribute("foodFiles", foodFiles);
		model.addAttribute("animalFiles", animalFiles);
		model.addAttribute("landscapeFiles", landscapeFiles);
		model.addAttribute("foodSize", foodSize);
		model.addAttribute("animalSize", animalSize);
		model.addAttribute("landscapeSize", landscapeSize);
		return "step2";
	}

	private File[] getFiles(String path) {
		var files = new File(context.getRealPath(path)).listFiles();
		return files;
	}
}