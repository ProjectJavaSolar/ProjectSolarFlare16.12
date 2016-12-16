package space.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import space.repository.FunFactRepository;

@Controller
public class FunFactController {
    @Autowired
    private FunFactRepository funFactRepository;

    @GetMapping("/funfact")
    public String index(Model model){
        model.addAttribute("view", "funfact");

        return "base-layout";
    }
}
