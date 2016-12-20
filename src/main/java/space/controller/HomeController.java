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
        List<FunFact> funFacts = this.funFactRepository.findAll();

        model.addAttribute("view", "home/index");
        model.addAttribute("categories", categories);
        model.addAttribute("funFacts", funFacts);

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

    @GetMapping("/funfact")
    public String factDetails(Model model) {

       // Random rand = new Random();
       // Funfact funfact = this.funfactRepository.findAll();
       // Set<Funfact> funfacts = funFact.getFunFact();

       // Funfact randomFunFact = facts.get(rand.nextInt(facts.size()));
        List<FunFact> funfacts = this.funFactRepository.findAll();
        model.addAttribute("view", "funfact/details");
        model.addAttribute("funfacts", funfacts);

        return "base-layout";
    }
}



