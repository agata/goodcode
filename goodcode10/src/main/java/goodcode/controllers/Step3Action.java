package goodcode.controllers;

import goodcode.util.FileUtil;

import java.io.File;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Step3:関連のあるデータをオブジェクトに
 */
@Controller
public class Step3Action {

    @Autowired
    ServletContext context;

    @RequestMapping("/step3")
    public String step3(Model model) {
        ImageFiles foodFiles = getFiles("/images/food");
        ImageFiles animalFiles = getFiles("/images/animal");
        ImageFiles landscapeFiles = getFiles("/images/landscape");

        model.addAttribute("foodFiles", foodFiles);
        model.addAttribute("animalFiles", animalFiles);
        model.addAttribute("landscapeFiles", landscapeFiles);
        return "step3";
    }

    private ImageFiles getFiles(String path) {
        File[] files = new File(context.getRealPath(path)).listFiles();
        return new ImageFiles(path, files);
    }

    public static class ImageFiles {
        private final String path;
        private final File[] files;
        private long size;

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