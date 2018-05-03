package edu.auburn.eng.csse.comp3710.a2b2b.recipeguruapplication.Dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import edu.auburn.eng.csse.comp3710.a2b2b.recipeguruapplication.Entity.RecipeImage;

@Dao
public interface RecipeImageDao {
    @Query("SELECT * FROM RecipeImage WHERE  RecipeID = :RecipeID")
    List<RecipeImage> getAll(int RecipeID);

    @Query("SELECT * FROM RecipeImage where RecipeImagePath LIKE :RecipeImagePath AND RecipeID LIKE :RecipeID")
    RecipeImage findRecipeImageByName(String RecipeImagePath, int RecipeID);

    @Query("SELECT COUNT(*) FROM RecipeImage")
    int countRecipeImages();

    @Insert
    void insertAll(RecipeImage... recipeImages);

    @Delete
    void delete(RecipeImage recipeImage);
}
