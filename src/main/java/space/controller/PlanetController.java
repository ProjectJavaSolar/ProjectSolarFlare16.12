package space.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import space.repository.PlanetRepository;

@Controller
public class PlanetController {
    @Autowired
    private PlanetRepository planetRepository;

    @GetMapping("/mercury")
    public String mercury(Model model){
        return "planets/mercury";
    }
    @GetMapping("/venus")
    public String venus(Model model){
        return "planets/venus";
    }
    @GetMapping("/earth")
    public String earth(Model model){
        return "planets/earth";
    }
    @GetMapping("/mars")
    public String mars(Model model){
        return "planets/mars";
    }
    @GetMapping("/jupiter")
    public String jupiter(Model model){
        return "planets/jupiter";
    }
    @GetMapping("/saturn")
    public String saturn(Model model){
        return "planets/saturn";
    }
    @GetMapping("/uranus")
    public String uranus(Model model){
        return "planets/uranus";
    }
    @GetMapping("/neptune")
    public String neptune(Model model){
        return "planets/neptune";
    }
    @GetMapping("/pluto")
    public String pluto(Model model){
        return "planets/pluto";
    }
}
