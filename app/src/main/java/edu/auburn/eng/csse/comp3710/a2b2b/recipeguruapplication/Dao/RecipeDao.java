package edu.auburn.eng.csse.comp3710.a2b2b.recipeguruapplication.Dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import edu.auburn.eng.csse.comp3710.a2b2b.recipeguruapplication.Entity.Recipe;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;


@Dao
public interface RecipeDao {

    @Query("SELECT * FROM Recipe WHERE AccountID = :AccountID")
    List<Recipe> getAll(int AccountID);

    @Query("SELECT * FROM Recipe where RecipeName LIKE :RecipeName")
    Recipe findRecipeByName(String RecipeName);

    @Query("SELECT COUNT(*) from Recipe where AccountID LIKE :AccountID")
    int countRecipes(int AccountID);

    @Insert(onConflict = REPLACE)
    void addRecipe(Recipe recipe);

    @Insert
    void insertAll(Recipe... recipes);

    @Delete
    void delete(Recipe recipe);
}
