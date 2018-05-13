package com.artkufar.artkufar.Controller;

import com.artkufar.artkufar.Dao.ProductGenreCategoryDao;
import com.artkufar.artkufar.Model.Product;
import com.artkufar.artkufar.Model.User;
import com.artkufar.artkufar.Service.ProductService;
import com.artkufar.artkufar.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class IndexController {

    @Autowired
    UserService userService;
    @Autowired
    ProductService productService;


    @GetMapping("/")
    public ModelAndView index(){

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findByName(auth.getName());
        if(user == null){
            return new ModelAndView("redirect:/gallery/");
        }
        if(user.getArtist() == null && user.getBuyer() == null){
            return new ModelAndView("redirect:/gallery");
        }
        if(user.getBuyer() == null){
            return new ModelAndView("redirect:/artist/"+user.getName());
        }else {
            return new ModelAndView("redirect:/gallery");
        }

    }

    @PostMapping("/")
    public void index(HttpServletResponse response) throws IOException{
        response.sendRedirect("/");
    }

    @GetMapping("/gallery")
    public ModelAndView gallery(){
        ModelAndView modelAndView = new ModelAndView("gallery");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if(!(SecurityContextHolder.getContext().getAuthentication() instanceof AnonymousAuthenticationToken)){
            modelAndView.addObject("user", userService.findByName(auth.getName()));
        }
        modelAndView.addObject("products", productService.getAll());
        return modelAndView;
    }

}
