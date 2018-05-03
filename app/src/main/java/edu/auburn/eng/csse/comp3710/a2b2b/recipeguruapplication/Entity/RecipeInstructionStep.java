package edu.auburn.eng.csse.comp3710.a2b2b.recipeguruapplication.Entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "RecipeInstructionStep", foreignKeys = @ForeignKey(entity = Recipe.class,
parentColumns = "RecipeID", childColumns = "RecipeID", onDelete = ForeignKey.CASCADE), indices = @Index("RecipeID"))
public class RecipeInstructionStep {

    @PrimaryKey(autoGenerate = true)
    private int RecipeInstructionStepID;

    @ColumnInfo(name = "RecipeInstructionText")
    private String RecipeInstructionText;

    @ColumnInfo(name = "RecipeInstructionOrderNumber")
    private int RecipeInstructionOrderNumber;

    @ColumnInfo(name = "RecipeID")
    private int RecipeID;

    public void setRecipeInstructionStepID(int RecipeInstructionStepID) {this.RecipeInstructionStepID = RecipeInstructionStepID;}
    public int getRecipeInstructionStepID() {return this.RecipeInstructionStepID;}

    public void setRecipeInstructionText(String RecipeInstructionText) {this.RecipeInstructionText = RecipeInstructionText;}
    public String getRecipeInstructionText() {return this.RecipeInstructionText;}

    public void setRecipeInstructionOrderNumber(int RecipeInstructionOrderNumber) {this.RecipeInstructionOrderNumber = RecipeInstructionOrderNumber;}
    public int getRecipeInstructionOrderNumber() {return this.RecipeInstructionOrderNumber;}

    public void setRecipeID(int RecipeID) {this.RecipeID = RecipeID;}
    public int getRecipeID() {return this.RecipeID;}
}
