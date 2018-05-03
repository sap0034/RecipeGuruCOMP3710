package edu.auburn.eng.csse.comp3710.a2b2b.recipeguruapplication.Dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import edu.auburn.eng.csse.comp3710.a2b2b.recipeguruapplication.Entity.Ingredient;

@Dao
public interface IngredientDao {
    @Query("SELECT * FROM Ingredient WHERE RecipeID = :RecipeID")
    List<Ingredient> getAll(int RecipeID);

    @Query("SELECT * FROM Ingredient where IngredientText LIKE :IngredientText")
    Ingredient findByName(String IngredientText);

    @Query("SELECT COUNT(*) from Ingredient")
    int countIngredients();

    @Insert
    void insertAll(Ingredient... ingredients);

    @Delete
    void delete(Ingredient ingredient);
}
