package space.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import space.entity.Article;
import space.entity.Category;
import space.entity.FunFact;
import space.repository.CategoryRepository;
import space.repository.FunFactRepository;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.lang.Integer;

@Controller
public class HomeController {

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private FunFactRepository funFactRepository;

    @GetMapping("/")
    public String index(Model model) {

        List<Category> categories = this.categoryRepository.findAll();

        model.addAttribute("view", "home/index");
        model.addAttribute("categories", categories);

        return "base-layout";
    }

    @RequestMapping("/error/403")
    public String accessDenied(Model model) {
        model.addAttribute("view", "error/403");

        return "base-layout2";
    }

    @GetMapping("/category/{id}")
    public String listArticles(Model model, @PathVariable Integer id) {
        if (!this.categoryRepository.exists(id)) {
            return "redirect:/";
        }

        Category category = this.categoryRepository.findOne(id);
        Set<Article> articles = category.getArticles();

        model.addAttribute("articles", articles);
        model.addAttribute("category", category);
        model.addAttribute("view", "home/list-articles");

        return "base-layout2";
    }

    @GetMapping("/category")
    public String listCategories(Model model) {

        List<Category> categories = this.categoryRepository.findAll();

        model.addAttribute("view", "article/category");
        model.addAttribute("categories", categories);

        return "base-layout2";
    }

    @GetMapping("/error/402")
    public String registerError(Model model) {
        model.addAttribute("view", "error/402");

        return "base-layout2";
    }

    @GetMapping("/funfact/list")
    public String factDetails(Model model) {
//        Integer idMax = "SELECT COUNT (id) FROM funfacts";

//        int min = 1;
//        int max = GetMaxIdNumber();



        Random rand = new Random();

        List<FunFact> facts = this.funFactRepository.findAll();
       // FunFact randomFunFact = facts.get(rand.nextInt(facts.size()));

        model.addAttribute("view", "funfact/list");
        model.addAttribute("funFact", facts);

        return "base-layout";
    }
}



