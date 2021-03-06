package space.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class PlanetController {

    @GetMapping("/mercury")
    public String mercury(Model model){
        model.addAttribute("view", "planets/mercury");

        return "base-layout2";
    }
    @GetMapping("/venus")
    public String venus(Model model){
        model.addAttribute("view", "planets/venus");

        return "base-layout2";
    }
    @GetMapping("/earth")
    public String earth(Model model){
        model.addAttribute("view", "planets/earth");

        return "base-layout2";
    }
    @GetMapping("/mars")
    public String mars(Model model){
        model.addAttribute("view", "planets/mars");

        return "base-layout2";
    }
    @GetMapping("/jupiter")
    public String jupiter(Model model){
        model.addAttribute("view", "planets/jupiter");

        return "base-layout2";
    }
    @GetMapping("/saturn")
    public String saturn(Model model){
        model.addAttribute("view", "planets/saturn");

        return "base-layout2";
    }
    @GetMapping("/uranus")
    public String uranus(Model model){
        model.addAttribute("view", "planets/uranus");

        return "base-layout2";
    }
    @GetMapping("/neptune")
    public String neptune(Model model){
        model.addAttribute("view", "planets/neptune");

        return "base-layout2";
    }
    @GetMapping("/pluto")
    public String pluto(Model model){
        model.addAttribute("view", "planets/pluto");

        return "base-layout2";
    }
    @GetMapping("/sun")
    public String slunceto(Model model){
        model.addAttribute("view", "planets/sun");

        return "base-layout2";
    }
    @GetMapping("/moon")
    public String moon(Model model){
        model.addAttribute("view", "planets/moon");

        return "base-layout2";
    }
}
