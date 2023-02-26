package ai.mlproject.imageclassificationwebapp.web;

import ai.mlproject.imageclassificationwebapp.domain.Image;
import ai.mlproject.imageclassificationwebapp.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class ImageController {

    private final ImageService imageService;

    @Autowired
    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @GetMapping("/upload")
    public String showUploadForm(Model model) {
        model.addAttribute("image", new Image());
        return "upload";
    }

    @PostMapping("/upload")
    public String handleUploadForm(@ModelAttribute("image") Image image, @RequestParam("imageFile") MultipartFile file) {
        imageService.saveImage(image, file);
        return "redirect:/";
    }
}