package edu.auburn.eng.csse.comp3710.a2b2b.recipeguruapplication.Entity;


import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "RecipeImage", foreignKeys = @ForeignKey(entity = Recipe.class,
        parentColumns = "RecipeID", childColumns = "RecipeID", onDelete = ForeignKey.CASCADE), indices = @Index("RecipeID"))
public class RecipeImage {
    @PrimaryKey(autoGenerate = true)
    private int RecipeImageID;

    @ColumnInfo(name = "RecipeImagePath")
    private String RecipeImagePath;

    @ColumnInfo(name = "RecipeID")
    private int RecipeID;

    public void setRecipeImageID(int RecipeImageID) {this.RecipeImageID = RecipeImageID;}
    public int getRecipeImageID() {return RecipeImageID;}

    public void setRecipeImagePath(String RecipeImagePath) {this.RecipeImagePath = RecipeImagePath;}
    public String getRecipeImagePath() {return RecipeImagePath;}

    //getters and setters
    public void setRecipeID(int RecipeID) {this.RecipeID = RecipeID;}
    public int getRecipeID() {return this.RecipeID;}

}
