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
        File[] foodFiles = getFiles("/images/food");
        File[] animalFiles = getFiles("/images/animal");
        File[] landscapeFiles = getFiles("/images/landscape");

        long foodSize = FileUtil.sizeOfFiles(foodFiles);
        long animalSize = FileUtil.sizeOfFiles(animalFiles);
        long landscapeSize = FileUtil.sizeOfFiles(landscapeFiles);

        model.addAttribute("foodFiles", foodFiles);
        model.addAttribute("animalFiles", animalFiles);
        model.addAttribute("landscapeFiles", landscapeFiles);
        model.addAttribute("foodSize", foodSize);
        model.addAttribute("animalSize", animalSize);
        model.addAttribute("landscapeSize", landscapeSize);
        return "step2";
    }

    private File[] getFiles(String path) {
        File[] files = new File(context.getRealPath(path)).listFiles();
        return files;
    }
}