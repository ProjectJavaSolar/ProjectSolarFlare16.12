package space.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import space.bindingModel.FunFactBindingModel;
import space.entity.FunFact;
import space.repository.FunFactRepository;

import javax.validation.constraints.NotNull;

@Controller
public class FunFactController {

    @Autowired
    private FunFactRepository funFactRepository;

    @GetMapping("/funfact/create")
    @PreAuthorize("isAuthenticated()")
    public String create(Model model){

        model.addAttribute("view", "funfact/create");

        return "base-layout";
    }
    @NotNull
    @PostMapping("/funfact/create")
    public String createProcess(FunFactBindingModel funFactBindingModel){

        if(StringUtils.isEmpty(funFactBindingModel.getContent())){
            return "redirect:/funfact/create";
        }
        FunFact funFact = new FunFact(funFactBindingModel.getContent());

        this.funFactRepository.saveAndFlush(funFact);

        return "redirect:/";
    }
}
