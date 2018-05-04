package edu.auburn.eng.csse.comp3710.a2b2b.recipeguruapplication;

import android.os.Bundle;
import android.widget.Button;

import java.util.List;

import butterknife.BindView;
import edu.auburn.eng.csse.comp3710.a2b2b.recipeguruapplication.Database.AppDatabase;
import edu.auburn.eng.csse.comp3710.a2b2b.recipeguruapplication.Entity.Recipe;

public class RecipeDetailsFragment extends RecipeActivity{
    AppDatabase db;
    List<Recipe> appRecipes = db.recipeDao().typeRecipeList(1, 1);
    List<Recipe> bfastRecipes = db.recipeDao().typeRecipeList(1, 2);
    List<Recipe> lunchRecipes = db.recipeDao().typeRecipeList(1, 3);
    List<Recipe> dinnerRecipes = db.recipeDao().typeRecipeList(1, 4);
    List<Recipe> dessertRecipes = db.recipeDao().typeRecipeList(1, 5);

    @BindView(R.id.appetizerButton)
    Button appetizerbutton;

    @BindView(R.id.breakfastButton)
    Button breakfastbutton;

    @BindView(R.id.lunchButton)
    Button lunchbutton;

    @BindView(R.id.dinnerButton)
    Button dinnerbutton;

    @BindView(R.id.dessertsButton)
    Button dessertbutton;


    @Override public void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);

    }

//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        View v = inflater.inflate(R.layout.main_menu, container, false);
//        ButterKnife.bind(this);
//
//        appetizerbutton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                setContentView(appRecipes);
//            }
//        });
//        breakfastbutton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                setContentView(bfastRecipes);
//            }
//        });
//        lunchbutton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                setContentView(lunchRecipes);
//            }
//        });
//        dinnerbutton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                setContentView(dinnerRecipes);
//            }
//        });
//        dessertbutton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                setContentView(dessertRecipes);
//            }
//        });
//
//
//        return v;
//    }




}
