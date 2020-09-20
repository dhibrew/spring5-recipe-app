package guru.springframework.controller;

import guru.springframework.domain.Difficulty;
import guru.springframework.domain.Recipe;
import guru.springframework.repositories.RecipeRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Iterator;

@Controller
public class IndexController {

    private RecipeRepository recipeRepository;

    public IndexController(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @RequestMapping({"/","","/index"})
    public String getIndexPage(){
        Recipe recipe = new Recipe();
        recipe.setDifficulty(Difficulty.EASY);
        recipe.setDescription("Telor ceplok");
        recipeRepository.save(recipe);

        Iterable<Recipe>recipes = recipeRepository.findAll();

        while (recipes.iterator().hasNext()){
            System.out.println("recipe : "+recipes.iterator().next().getDescription());
        }

        return "index";
    }
}
