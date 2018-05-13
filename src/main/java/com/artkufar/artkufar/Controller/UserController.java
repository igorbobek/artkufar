package com.artkufar.artkufar.Controller;

import com.artkufar.artkufar.Dao.BuyerDao;
import com.artkufar.artkufar.Dao.UserDao;
import com.artkufar.artkufar.Model.Artist;
import com.artkufar.artkufar.Model.Buyer;
import com.artkufar.artkufar.Model.User;
import com.artkufar.artkufar.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    UserDao userDao;


    @Secured("ROLE_ANONYMOUS")
    @GetMapping("/signup")
    public ModelAndView signup(){
        ModelAndView modelAndView = new ModelAndView("signup");
        modelAndView.addObject("user", new User());
        return modelAndView;
    }

    @Secured("ROLE_ANONYMOUS")
    @PostMapping("/signup")
    public ModelAndView signup(@ModelAttribute("user") User userForm,
                       @RequestParam("matchingPassword") String matchPass,
                       @RequestParam("role") String roleForm,
                       @RequestParam("biography") String biography,
                       @RequestParam("address") String address
                       ){
        ModelAndView modelAndView = new ModelAndView();
        boolean role = (Integer.parseInt(roleForm) == 1);


        if(userForm.getName().equals("") || userForm.getEmail().equals("") || userForm.getPassword().equals("")){
            modelAndView.setViewName("signup");
            modelAndView.addObject("error", "Вводимые поля не должны быть пустыми!");
            return modelAndView;
        }

        if (!userForm.getPassword().equals(matchPass)){
            modelAndView.setViewName("signup");
            modelAndView.addObject("error", "Оба введенных пароля должны быть идентичны!");
            return modelAndView;
        }
        try{
            userForm.setPassword(new BCryptPasswordEncoder().encode(userForm.getPassword()));
            if(role){
                userForm.setArtist(new Artist(biography));
            }else {
                userForm.setBuyer(new Buyer(address));
            }
            userService.save(userForm);
            modelAndView = new ModelAndView(new RedirectView("/"));
            return modelAndView;
        }catch (Exception e){
            modelAndView.setViewName("signup");
            modelAndView.addObject("error", e.getMessage());
            System.err.println(e.getMessage());
        }
        return modelAndView;

    }

    @Secured("ROLE_ANONYMOUS")
    @GetMapping("/login")
    public ModelAndView login(){
        Iterable activeUserInfo = userDao.findAll();
        ModelAndView modelAndView = new ModelAndView("login");
        return modelAndView;
    }

    @Secured("ROLE_BUYER")
    @GetMapping("/cart")
    public ModelAndView cart(){
        ModelAndView modelAndView = new ModelAndView("cart");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.getBuyerByName(auth.getName());
        modelAndView.addObject("deals",user.getBuyer().getDeals());
        modelAndView.addObject("user", user);
        return modelAndView;
    }

    @Secured({"ROLE_ADMIN", "ROLE_ARTIST", "ROLE_BUYER"})
    @GetMapping("/account")
    public ModelAndView changeAccountSetting(){
        ModelAndView modelAndView = new ModelAndView("account");
        modelAndView.addObject("user", userService.findByName(SecurityContextHolder.getContext().getAuthentication().getName()));
        return modelAndView;
    }

    @Secured({"ROLE_ADMIN", "ROLE_ARTIST", "ROLE_BUYER"})
    @PostMapping("/account/change")
    public String changeAccountSetting(@ModelAttribute("user") User userForm){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findByName(auth.getName());
        if(user.getArtist() == null) {
            user.getBuyer().setAddress(userForm.getBuyer().getAddress());
        }else {
            user.getArtist().setBiography(userForm.getArtist().getBiography());
        }
        user.setEmail(userForm.getEmail());
        user.setFirstName(userForm.getFirstName());
        user.setSurname(userForm.getSurname());
        userService.save(user);
        return "redirect:/account";
    }


}
