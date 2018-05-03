package edu.auburn.eng.csse.comp3710.a2b2b.recipeguruapplication.Entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "Ingredient", foreignKeys = {@ForeignKey(entity = Recipe.class,
        parentColumns = "RecipeID", childColumns = "RecipeID", onDelete = ForeignKey.CASCADE), @ForeignKey(entity = Measurement.class,
        parentColumns = "MeasurementID", childColumns = "MeasurementID", onDelete = ForeignKey.CASCADE)}, indices ={ @Index("MeasurementID"), @Index("RecipeID"), @Index("IngredientText")})
public class Ingredient {

    @PrimaryKey(autoGenerate = true)
    private int IngredientID;

    @ColumnInfo(name = "IngredientText")
    private String IngredientText;

    @ColumnInfo(name = "IngredientAmount")
    private int IngredientAmount;

    @ColumnInfo(name = "RecipeID")
    private int RecipeID;

    @ColumnInfo(name = "MeasurementID")
    private int MeasurementID;

    //getters and setters
    public void setRecipeID(int RecipeID) {this.RecipeID = RecipeID;}
    public int getRecipeID() {return this.RecipeID;}

    public void setIngredientID(int IngredientID) {this.IngredientID = IngredientID;}
    public int getIngredientID() {return this.IngredientID;}

    public void setIngredientText(String IngredientText) {this.IngredientText = IngredientText;}
    public String getIngredientText() { return this.IngredientText;}

    public void setIngredientAmount(int IngredientAmount) {this.IngredientAmount = IngredientAmount;}
    public int getIngredientAmount() {return this.IngredientAmount;}

    public void setMeasurementID(int MeasurementID) {this.MeasurementID = MeasurementID;}
    public int getMeasurementID() {return this.MeasurementID;}
}
