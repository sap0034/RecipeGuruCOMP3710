package edu.auburn.eng.csse.comp3710.a2b2b.recipeguruapplication.Entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;


@Entity(tableName = "RecipeType")
public class RecipeType {
    @PrimaryKey(autoGenerate = true)
    private int RecipeTypeID;

    @ColumnInfo(name = "RecipeTypeText")
    private String RecipeTypeText;

    public void setRecipeTypeID(int RecipeTypeID) {this.RecipeTypeID = RecipeTypeID;}
    public int getRecipeTypeID() {return this.RecipeTypeID;}

    public void setRecipeTypeText(String RecipeTypeText) {this.RecipeTypeText = RecipeTypeText;}
    public String getRecipeTypeText() {return this.RecipeTypeText;}
}
