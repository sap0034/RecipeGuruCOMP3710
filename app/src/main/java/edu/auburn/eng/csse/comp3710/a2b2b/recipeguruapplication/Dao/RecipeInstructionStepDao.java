package edu.auburn.eng.csse.comp3710.a2b2b.recipeguruapplication.Dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import edu.auburn.eng.csse.comp3710.a2b2b.recipeguruapplication.Entity.RecipeInstructionStep;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

@Dao
public interface RecipeInstructionStepDao {
    @Query("SELECT * FROM RecipeInstructionStep Where RecipeID = :RecipeID")
    List<RecipeInstructionStep> getAll(int RecipeID);

    @Query("SELECT * FROM RecipeInstructionStep where RecipeInstructionText LIKE :RecipeInstructionText AND RecipeID LIKE :RecipeID")
    RecipeInstructionStep findRecipeInstructionByName(String RecipeInstructionText, int RecipeID);

    @Query("SELECT COUNT(*) FROM RecipeInstructionStep Where RecipeID = :RecipeID")
    int countRecipeInstructionStep(int RecipeID);

    @Insert
    void insertAll(RecipeInstructionStep... recipeInstructionSteps);

    @Insert(onConflict = REPLACE)
    void addInstruction(RecipeInstructionStep recipeInstructionStep);

    @Delete
    void delete(RecipeInstructionStep recipeInstructionStep);
}
