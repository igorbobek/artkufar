package com.artkufar.artkufar.Controller;

import com.artkufar.artkufar.Model.Deal;
import com.artkufar.artkufar.Model.Product;
import com.artkufar.artkufar.Model.User;
import com.artkufar.artkufar.Service.DealService;
import com.artkufar.artkufar.Service.ProductService;
import com.artkufar.artkufar.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ProductController {

    @Autowired
    ProductService productService;
    @Autowired
    UserService userService;
    @Autowired
    DealService dealService;

    @GetMapping("/product/{index}")
    public ModelAndView product(@PathVariable(value = "index") String indexStr){
        int id;
        try{
            id = Integer.parseInt(indexStr);
        }catch (NumberFormatException e){
            return new ModelAndView("redirect:/gallery");
        }
        if(productService.getById((long)id) == null){
            new ModelAndView("redirect:/gallery");
        }
        ModelAndView modelAndView = new ModelAndView("product");
        modelAndView.addObject("product", productService.getById((long)id));
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findByName(auth.getName());
        modelAndView.addObject("user", user);
        return modelAndView;
    }

    @Secured("ROLE_BUYER")
    @PostMapping("/addToCart")
    public String addToCart(HttpServletRequest request, @RequestParam("productId") String idStr){
        String referer = request.getHeader("Referer");
        long id;
        try {
            id = Long.parseLong(idStr);
        }catch (NumberFormatException e){
            System.err.println(e.getMessage());
            return "redirect:/gallery";
        }
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.getBuyerByName(auth.getName());
        dealService.save(new Deal(productService.getById(id), user.getBuyer()));
        return "redirect:"+referer;
    }

    @PostMapping("/deleteProduct")
    public String deleteProduct(HttpServletRequest request,
                                @RequestParam("productId") String idStr){
        String referer = request.getHeader("Referer");
        long id;
        try {
            id = Long.parseLong(idStr);
        }catch (NumberFormatException e){
            System.err.println(e.getMessage());
            return "redirect:"+referer;
        }
        productService.delete(id);
        return "redirect:"+referer;
    }

    @Secured("ROLE_ADMIN")
    @GetMapping("/history")
    public ModelAndView history(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("deals", dealService.getAll());
        return modelAndView;
    }
}
