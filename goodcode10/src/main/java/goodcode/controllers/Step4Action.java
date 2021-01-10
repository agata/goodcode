package goodcode.controllers;

import goodcode.util.FileUtil;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Step4:配列/コレクション化
 */
@Controller
public class Step4Action {

    public static final String[] PATHS = {
        "/images/food",
        "/images/animal",
        "/images/landscape"
    };

    @Autowired
    public ServletContext context;

    @RequestMapping("/step4")
    public String step4(Model model) {
        var filesList = new ArrayList<ImageFiles>();
        for (var path : PATHS) {
            filesList.add(getFiles(path));
        }
        model.addAttribute("filesList", filesList);
        return "step4";
    }

    private ImageFiles getFiles(String path) {
        var files = new File(context.getRealPath(path)).listFiles();
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