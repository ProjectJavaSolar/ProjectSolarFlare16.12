package space.controller;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import space.bindingModel.UserBindingModel;
import space.entity.Role;
import space.entity.User;
import space.repository.RoleRepository;
import space.repository.UserRepository;

import javax.servlet.http.HttpServletResponse;

@Controller
public class UserController {

    @Autowired
    RoleRepository roleRepository;
    @Autowired
    UserRepository userRepository;

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("view", "user/register");

        return "base-layout2";
    }

    @PostMapping("/register")
    public String registerProcess(UserBindingModel userBindingModel){

        if(!userBindingModel.getPassword().equals(userBindingModel.getConfirmPassword())){
            return "redirect:/register";
        }

//       if(this.userRepository.findByEmail(principal.getUsername().exists(email))){
//           return "redirect:/error/402";
//       }

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
try {


        User user = new User(
                userBindingModel.getEmail(),
                userBindingModel.getFullName(),
                bCryptPasswordEncoder.encode(userBindingModel.getPassword())
        );

        Role userRole = this.roleRepository.findByName("ROLE_USER");

        user.addRole(userRole);

        this.userRepository.saveAndFlush(user);

        return "redirect:/login";
    } catch (Exception E){return "redirect:/error/402";
    }
    }

    @GetMapping("/login")
    public String login(Model model){
        model.addAttribute("view", "user/login");

        return "base-layout2";
    }

    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }

        return "redirect:/login?logout";
    }

    @GetMapping("/profile")
    @PreAuthorize("isAuthenticated()")
    public String profilePage(Model model){
        UserDetails principal = (UserDetails) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();

        User user = this.userRepository.findByEmail(principal.getUsername());

        model.addAttribute("user", user);
        model.addAttribute("view", "user/profile");

        return "base-layout2";
    }
}
