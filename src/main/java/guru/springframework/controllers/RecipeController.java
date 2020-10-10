package guru.springframework.controllers;

import guru.springframework.domain.Recipe;
import guru.springframework.services.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by jt on 6/19/17.
 */
@Controller
public class RecipeController {

    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping("/recipe/show/{id}")
    public String showById(@PathVariable String id, Model model){

        Recipe recipe = recipeService.findById(Long.valueOf(id));
        model.addAttribute("recipe", recipe);
        model.addAttribute("categories", recipe.getCategories());
        model.addAttribute("ingredients",recipe.getIngredients());
        model.addAttribute("directions",recipe.getDirections());
        model.addAttribute("notes",recipe.getNotes().getRecipeNotes());
        model.addAttribute("difficulty",recipe.getDifficulty().name());
        model.addAttribute("servings",recipe.getServings());
        model.addAttribute("cookTime",recipe.getCookTime());
        model.addAttribute("prepTime",recipe.getPrepTime());
        model.addAttribute("source",recipe.getSource());
        model.addAttribute("url",recipe.getUrl());

        return "recipe/show";
    }

}
