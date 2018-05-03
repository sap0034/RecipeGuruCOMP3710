package edu.auburn.eng.csse.comp3710.a2b2b.recipeguruapplication.Dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import edu.auburn.eng.csse.comp3710.a2b2b.recipeguruapplication.Entity.RecipeType;

@Dao
public interface RecipeTypeDao {
    @Query("SELECT * FROM RecipeType")
    List<RecipeType> getAll();

    @Query("SELECT * FROM RecipeType where RecipeTypeText LIKE :RecipeTypeText")
    RecipeType findRecipeTypeByName(String RecipeTypeText);

    @Query("SELECT COUNT(*) FROM RecipeType")
    int countRecipeType();

    @Insert
    void insertAll(RecipeType... recipeTypes);

    @Delete
    void delete(RecipeType recipeType);

}
