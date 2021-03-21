package goodcode.controllers;

import java.io.File;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Step1:べたに実装
 */
@Controller
public class Step1Action {

    @Autowired
    ServletContext context;

    @RequestMapping("/step1")
    public String step1(Model model) {
        File[] foodFiles = new File(context.getRealPath("/images/food")).listFiles();
        File[] animalFiles = new File(context.getRealPath("/images/animal")).listFiles();
        File[] landscapeFiles = new File(context.getRealPath("/images/landscape")).listFiles();

        long foodSize = sizeOfFiles(foodFiles);
        long animalSize = sizeOfFiles(animalFiles);
        long landscapeSize = sizeOfFiles(landscapeFiles);

        model.addAttribute("foodFiles", foodFiles);
        model.addAttribute("animalFiles", animalFiles);
        model.addAttribute("landscapeFiles", landscapeFiles);
        model.addAttribute("foodSize", foodSize);
        model.addAttribute("animalSize", animalSize);
        model.addAttribute("landscapeSize", landscapeSize);
        return "step1";
    }

    public long sizeOfFiles(File[] files) {
        long totalSize = 0;
        for (File file : files) {
            totalSize += file.length();
        }
        return totalSize;
    }
}