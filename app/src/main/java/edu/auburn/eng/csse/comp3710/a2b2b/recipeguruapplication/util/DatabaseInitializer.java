package edu.auburn.eng.csse.comp3710.a2b2b.recipeguruapplication.util;

import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.util.Log;

import java.util.List;

import edu.auburn.eng.csse.comp3710.a2b2b.recipeguruapplication.Database.AppDatabase;
import edu.auburn.eng.csse.comp3710.a2b2b.recipeguruapplication.Entity.Account;
import edu.auburn.eng.csse.comp3710.a2b2b.recipeguruapplication.Entity.Ingredient;
import edu.auburn.eng.csse.comp3710.a2b2b.recipeguruapplication.Entity.Measurement;
import edu.auburn.eng.csse.comp3710.a2b2b.recipeguruapplication.Entity.Recipe;
import edu.auburn.eng.csse.comp3710.a2b2b.recipeguruapplication.Entity.RecipeInstructionStep;
import edu.auburn.eng.csse.comp3710.a2b2b.recipeguruapplication.Entity.RecipeType;

public class DatabaseInitializer {
    private static final String TAG = DatabaseInitializer.class.getName();

    public static void populateAsync(@NonNull final AppDatabase db) {
        PopulateDbAsync task = new PopulateDbAsync(db);
        task.execute();
    }

    public static void populateSync(@NonNull final AppDatabase db) {
        populateWithTestData(db);
    }

    private static Account addAccount(final AppDatabase db, Account account) {
        db.accountDao().insertAll(account);
        return account;
    }

    private static Ingredient addIngredient(final AppDatabase db, Ingredient ingredient) {
        db.ingredientDao().insertAll(ingredient);
        return ingredient;
    }
    private static Recipe addRecipe(final AppDatabase db, Recipe recipe) {
        db.recipeDao().insertAll(recipe);
        return recipe;
    }
    private static RecipeInstructionStep addRecipeInstructionStep(final AppDatabase db, RecipeInstructionStep recipeInstructionStep) {
        db.recipeInstructionStepDao().insertAll(recipeInstructionStep);
        return recipeInstructionStep;
    }
    private static Measurement addMeasurement(final AppDatabase db, Measurement measurement) {
        db.measurementDao().insertAll(measurement);
        return measurement;
    }
    private static RecipeType addRecipeType(final AppDatabase db, RecipeType recipeType) {
        db.recipeTypeDao().insertAll(recipeType);
        return recipeType;
    }

    private static void populateWithTestData(AppDatabase db) {
        //account test data
        Account account = new Account();
        account.setFirstName("Stephanie");
        account.setLastName("Parrish");
        account.setEmailAddress("test@test.com");
        account.setPassword("admin");
        account.setAccountCreatedDatetime("04-30-2018");
        addAccount(db, account);

        List<Account> accountList = db.accountDao().getAll();
        Log.d(DatabaseInitializer.TAG, "Rows Count: " + accountList.size());

        //recipe type test data
        RecipeType recipeType = new RecipeType();
        recipeType.setRecipeTypeText("Appetizer");
        addRecipeType(db, recipeType);

        RecipeType recipeType1 = new RecipeType();
        recipeType1.setRecipeTypeText("Breakfast");
        addRecipeType(db, recipeType1);

        RecipeType recipeType2 = new RecipeType();
        recipeType2.setRecipeTypeText("Lunch");
        addRecipeType(db, recipeType2);

        RecipeType recipeType3 = new RecipeType();
        recipeType3.setRecipeTypeText("Dinner");
        addRecipeType(db, recipeType3);

        RecipeType recipeType4 = new RecipeType();
        recipeType4.setRecipeTypeText("Dessert");
        addRecipeType(db, recipeType4);

        List<RecipeType> recipeTypeList = db.recipeTypeDao().getAll();
        Log.d(DatabaseInitializer.TAG, "Rows Count: " + recipeTypeList.size());

        //recipe test data
        Recipe recipe = new Recipe();
        recipe.setRecipeName("Fruit Dip");
        recipe.setAccountID(1);
        recipe.setPrepTime("15mins");
        recipe.setCookTime("0");
        recipe.setTotalTime("15mins");
        recipe.setIsFavorite(1);
        recipe.setServings(4);
        recipe.setRecipeTypeID(5);
        addRecipe(db, recipe);

        Recipe recipe1 = new Recipe();
        recipe1.setRecipeName("Ham Sandwhich");
        recipe1.setAccountID(1);
        recipe1.setPrepTime("5mins");
        recipe1.setCookTime("0");
        recipe1.setTotalTime("5mins");
        recipe1.setIsFavorite(0);
        recipe1.setServings(1);
        recipe1.setRecipeTypeID(3);
        addRecipe(db, recipe1);

        List<Recipe> recipeList = db.recipeDao().getAll(1);
        Log.d(DatabaseInitializer.TAG, "Rows Count: " + recipeList.size());

        //recipe measurement test data
        Measurement measurement = new Measurement();
        measurement.setMeasurementName("tbsp");
        addMeasurement(db, measurement);

        Measurement measurement1 = new Measurement();
        measurement1.setMeasurementName("tsp");
        addMeasurement(db, measurement1);

        Measurement measurement2 = new Measurement();
        measurement2.setMeasurementName("ounce");
        addMeasurement(db, measurement2);

        Measurement measurement3 = new Measurement();
        measurement3.setMeasurementName("cup");
        addMeasurement(db, measurement3);

        Measurement measurement4 = new Measurement();
        measurement4.setMeasurementName("pint");
        addMeasurement(db, measurement4);

        Measurement measurement5 = new Measurement();
        measurement5.setMeasurementName("piece(s)");
        addMeasurement(db, measurement5);

        Measurement measurement6 = new Measurement();
        measurement6.setMeasurementName("gallon");
        addMeasurement(db, measurement6);

        List<Measurement> measurementList = db.measurementDao().getAll();
        Log.d(DatabaseInitializer.TAG, "Rows Count: " + measurementList.size());

        //ingredients
        Ingredient ingredient = new Ingredient();
        ingredient.setIngredientText("Greek Yogurt");
        ingredient.setIngredientAmount(1);
        ingredient.setMeasurementID(4);
        ingredient.setRecipeID(1);
        addIngredient(db, ingredient);

        Ingredient ingredient1 = new Ingredient();
        ingredient1.setIngredientText("Whipped Cream");
        ingredient1.setIngredientAmount(1);
        ingredient1.setMeasurementID(4);
        ingredient1.setRecipeID(1);
        addIngredient(db, ingredient1);

        Ingredient ingredient2 = new Ingredient();
        ingredient2.setIngredientText("Ham");
        ingredient2.setIngredientAmount(1);
        ingredient2.setMeasurementID(6);
        ingredient2.setRecipeID(2);
        addIngredient(db, ingredient2);

        Ingredient ingredient3 = new Ingredient();
        ingredient3.setIngredientText("Bun");
        ingredient3.setIngredientAmount(1);
        ingredient3.setMeasurementID(6);
        ingredient3.setRecipeID(2);
        addIngredient(db, ingredient2);

        List<Ingredient> ingredientList = db.ingredientDao().getAll(1);
        Log.d(DatabaseInitializer.TAG, "Rows Count: " + ingredientList.size());

        List<Ingredient> ingredientList1 = db.ingredientDao().getAll(2);
        Log.d(DatabaseInitializer.TAG, "Rows Count: " + ingredientList1.size());

        RecipeInstructionStep recipeInstructionStep = new RecipeInstructionStep();
        recipeInstructionStep.setRecipeID(1);
        recipeInstructionStep.setRecipeInstructionOrderNumber(1);
        recipeInstructionStep.setRecipeInstructionText("Mix all ingredients in a bowl.");
        addRecipeInstructionStep(db, recipeInstructionStep);

        RecipeInstructionStep recipeInstructionStep1 = new RecipeInstructionStep();
        recipeInstructionStep1.setRecipeID(1);
        recipeInstructionStep1.setRecipeInstructionOrderNumber(2);
        recipeInstructionStep1.setRecipeInstructionText("Chill for one hour then serve.");
        addRecipeInstructionStep(db, recipeInstructionStep1);

        RecipeInstructionStep recipeInstructionStep2 = new RecipeInstructionStep();
        recipeInstructionStep2.setRecipeID(2);
        recipeInstructionStep2.setRecipeInstructionOrderNumber(1);
        recipeInstructionStep2.setRecipeInstructionOrderNumber(1);
        recipeInstructionStep2.setRecipeInstructionText("Put ham on bun and serve.");

        List<RecipeInstructionStep> recipeInstructionStepList = db.recipeInstructionStepDao().getAll(1);
        Log.d(DatabaseInitializer.TAG, "Rows Count: " + recipeInstructionStepList.size());

        List<RecipeInstructionStep> recipeInstructionStepList2 = db.recipeInstructionStepDao().getAll(2);
        Log.d(DatabaseInitializer.TAG, "Rows Count: " + recipeInstructionStepList2.size());
    }

    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {

        private final AppDatabase mDb;

        PopulateDbAsync(AppDatabase db) {
            mDb = db;
        }

        @Override
        protected Void doInBackground(final Void... params) {
            populateWithTestData(mDb);
            return null;
        }

    }
}
