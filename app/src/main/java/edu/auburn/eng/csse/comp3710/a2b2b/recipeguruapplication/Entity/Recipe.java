package edu.auburn.eng.csse.comp3710.a2b2b.recipeguruapplication.Entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "Recipe", foreignKeys = {@ForeignKey(entity = Account.class, parentColumns = "AccountID", childColumns = "AccountID", onDelete = ForeignKey.CASCADE),
        @ForeignKey(entity = RecipeType.class, parentColumns = "RecipeTypeID", childColumns = "RecipeTypeID", onDelete = ForeignKey.CASCADE)}, indices = {@Index("RecipeTypeID"), @Index("AccountID")})
public class Recipe {

    @PrimaryKey(autoGenerate = true)
    private int RecipeID;

    @ColumnInfo(name = "RecipeName")
    private String RecipeName;

    @ColumnInfo(name = "CookTime")
    private String CookTime;

    @ColumnInfo(name = "PrepTime")
    private String PrepTime;

    @ColumnInfo(name = "TotalTime")
    private String TotalTime;

    @ColumnInfo(name = "Servings")
    private int Servings;

    @ColumnInfo(name = "isFavorite")
    private int isFavorite;

    @ColumnInfo(name = "AccountID")
    private int AccountID;

    @ColumnInfo(name = "RecipeTypeID")
    private int RecipeTypeID;

    //getters and setters
    public void setAccountID(int AccountID) {
        this.AccountID = AccountID;
    }
    public int getAccountID() {
        return this.AccountID;
    }

    public void setRecipeTypeID(int RecipeTypeID) {this.RecipeTypeID = RecipeTypeID;}
    public int getRecipeTypeID() {return this.RecipeTypeID;}

    public void setRecipeID(int RecipeID) {this.RecipeID = RecipeID;}
    public int getRecipeID() {return this.RecipeID;}

    public void setRecipeName(String RecipeName) {this.RecipeName = RecipeName;}
    public String getRecipeName() {return this.RecipeName;}

    public void setCookTime(String CookTime) {this.CookTime = CookTime;}
    public String getCookTime() {return this.CookTime;}

    public void setPrepTime(String PrepTime) {this.PrepTime = PrepTime;}
    public String getPrepTime() {return this.PrepTime;}

    public void setTotalTime(String TotalTime) {this.TotalTime = TotalTime;}
    public String getTotalTime() {return this.TotalTime;}

    public void setServings(int Servings) {this.Servings = Servings;}
    public int getServings(){return this.Servings;}

    public void setIsFavorite(int isFavorite) {this.isFavorite = isFavorite;}
    public int getIsFavorite() {return this.isFavorite;}
}
