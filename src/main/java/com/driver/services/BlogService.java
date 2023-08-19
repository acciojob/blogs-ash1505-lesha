package com.driver.services;
import com.driver.models.Blog;
import com.driver.models.Image;
import com.driver.models.User;
import com.driver.repositories.BlogRepository;
import com.driver.repositories.ImageRepository;
import com.driver.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@@ -23,11 +24,16 @@ public class BlogService {

    public Blog createAndReturnBlog(Integer userId, String title, String content) {
        //create a blog at the current time

        User user=userRepository1.findById(userId).get();
        Blog blog=new Blog(user,title,content);
        blog.setPubDate(new Date());
        userRepository1.save(user);
        user.getBlogList().add(blog);
        return blog;
    }

    public void deleteBlog(int blogId){
        //delete blog and corresponding images

        blogRepository1.deleteById(blogId);
    }
}
}