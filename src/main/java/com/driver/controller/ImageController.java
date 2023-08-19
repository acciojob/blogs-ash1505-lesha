package com.driver.controller;

import com.driver.models.Blog;
@@ -12,23 +13,26 @@
@RequestMapping("/images")
public class ImageController {

    @Autowired
    ImageService imageService;

    @PostMapping("/{blogId}/add-image")
    public ResponseEntity<String> addImage(@PathVariable int blogId, @RequestParam String description, @RequestParam String dimensions) {
        // Add image into the give blog
        imageService.addImage(blogId,description,dimensions);
        return new ResponseEntity<>("Added image successfully", HttpStatus.OK);
    }

    @GetMapping("/countImagesInScreen/{id}/{screenDimensions}")
    public ResponseEntity<Integer> countImagesInScreen(@PathVariable int id, @PathVariable String screenDimensions){
        int count=imageService.countImagesInScreen(id,screenDimensions);
        return new ResponseEntity<>(count, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteImage(@PathVariable int id) {
        // delete image using deleteById
        imageService.deleteImage(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}