package com.foodrecommender.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class FoodRecommenderController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/recommend")
    public String recommend(@RequestParam("ingredients") String ingredients, Model model) {
        // 간단한 추천 로직
        List<String> recommendations = new ArrayList<>();
        if (ingredients.toLowerCase().contains("tomato")) {
            recommendations.add("Tomato Soup");
            recommendations.add("Tomato Pasta");
        }
        if (ingredients.toLowerCase().contains("cheese")) {
            recommendations.add("Cheese Sandwich");
            recommendations.add("Cheese Pizza");
        }
        if (recommendations.isEmpty()) {
            recommendations.add("No matching recipes found. Try different ingredients!");
        }

        model.addAttribute("recommendations", recommendations);
        return "recommendations";
    }
}
