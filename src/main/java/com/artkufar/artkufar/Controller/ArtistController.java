package com.artkufar.artkufar.Controller;

import com.artkufar.artkufar.Dao.*;
import com.artkufar.artkufar.Model.*;
import com.artkufar.artkufar.Service.DealService;
import com.artkufar.artkufar.Service.ProductGenreCategoryService;
import com.artkufar.artkufar.Service.ProductService;
import com.artkufar.artkufar.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class ArtistController {

    @Autowired
    ProductService service;
    @Autowired
    UserService userService;
    @Autowired
    ProductGenreCategoryService productGenreCategoryService;
    @Autowired
    MaterialDao materialDao;
    @Autowired
    CategoryDao categoryDao;
    @Autowired
    ProductDao productDao;
    @Autowired
    DealService dealService;
    @Autowired
    GenreDao genreDao;

    @GetMapping("/artist/{artist}")
    public ModelAndView artistPage(@PathVariable(value = "artist") String artistName, HttpServletResponse response) throws IOException{
        ModelAndView modelAndView = new ModelAndView("artist");
        User user = userService.getArtistByName(artistName);
        if(userService.getArtistByName(artistName) == null){
            return new ModelAndView("redirect:/");
        }
        modelAndView.addObject("artist", user);
        modelAndView.addObject("user", userService.findByName(SecurityContextHolder.getContext().getAuthentication().getName()));
        modelAndView.addObject("products", user.getArtist().getProducts());
        return modelAndView;
    }

    @Secured("ROLE_ARTIST")
    @GetMapping("/artist/addProduct")
    public ModelAndView addProduct(ModelAndView modelAndView){
        modelAndView.setViewName("new_product");
        modelAndView.addObject("product", new Product());
        return modelAndView;
    }

    @Secured("ROLE_ARTIST")
    @PostMapping("/artist/addProduct")
    public void addProduct(@ModelAttribute("product") Product productForm,
                           @RequestParam("genre") String genreForm,
                           @RequestParam("category") String categoryForm,
                           @RequestParam("material_name") String materialName,
                           @RequestParam("material_color") String materialColor,
                           HttpServletResponse response) throws IOException{
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        productForm.setArtist(userService.getArtistByName(auth.getName()).getArtist());
        if(materialDao.findByName(materialName) == null){
            productForm.getMaterials().add(new Material(materialName, materialColor));
        }else{
            productForm.getMaterials().add(materialDao.findByName(materialName));
        }
        Category category;
        Genre genre;
        if(categoryDao.findByCategory(categoryForm) == null){
            category = new Category(categoryForm);
        }else{
            category = categoryDao.findByCategory(categoryForm);
        }
        if(genreDao.findByGenre(genreForm) == null){
            genre = new Genre(genreForm);
        }else{
            genre = genreDao.findByGenre(genreForm);
        }

        productGenreCategoryService.save(new ProductGenreCategory(productForm, genre, category));
        response.sendRedirect("/");
    }

    @Secured("ROLE_ARTIST")
    @GetMapping("/buyers")
    public ModelAndView buyers(){
        ModelAndView modelAndView = new ModelAndView("buyers");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.getArtistByName(auth.getName());
        modelAndView.addObject("user", user);
        modelAndView.addObject("deals", productDao.findByArtistAndDealsIsNotNull(user.getArtist()));
        return modelAndView;
    }

    @Secured("ROLE_ARTIST")
    @PostMapping("/confirm")
    public String confirmBuyer(HttpServletRequest request, @RequestParam("dealId") String idStr) throws IOException{
        String referer = request.getHeader("Referer");
        long id = 0;
        try{
            id = Long.parseLong(idStr);
        }catch (NumberFormatException e){
            System.err.println(e.getMessage());
            return "redirect:/";
        }
        Deal deal = dealService.getById(id);
        deal.setFlag(!deal.isFlag());
        dealService.save(deal);
        return "redirect:"+referer;
    }

}
