package edu.auburn.eng.csse.comp3710.a2b2b.recipeguruapplication.Database;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import edu.auburn.eng.csse.comp3710.a2b2b.recipeguruapplication.Dao.AccountDao;
import edu.auburn.eng.csse.comp3710.a2b2b.recipeguruapplication.Dao.IngredientDao;
import edu.auburn.eng.csse.comp3710.a2b2b.recipeguruapplication.Dao.MeasurementDao;
import edu.auburn.eng.csse.comp3710.a2b2b.recipeguruapplication.Dao.RecipeDao;
import edu.auburn.eng.csse.comp3710.a2b2b.recipeguruapplication.Dao.RecipeImageDao;
import edu.auburn.eng.csse.comp3710.a2b2b.recipeguruapplication.Dao.RecipeInstructionStepDao;
import edu.auburn.eng.csse.comp3710.a2b2b.recipeguruapplication.Dao.RecipeTypeDao;
import edu.auburn.eng.csse.comp3710.a2b2b.recipeguruapplication.Entity.Account;
import edu.auburn.eng.csse.comp3710.a2b2b.recipeguruapplication.Entity.Ingredient;
import edu.auburn.eng.csse.comp3710.a2b2b.recipeguruapplication.Entity.Measurement;
import edu.auburn.eng.csse.comp3710.a2b2b.recipeguruapplication.Entity.Recipe;
import edu.auburn.eng.csse.comp3710.a2b2b.recipeguruapplication.Entity.RecipeImage;
import edu.auburn.eng.csse.comp3710.a2b2b.recipeguruapplication.Entity.RecipeInstructionStep;
import edu.auburn.eng.csse.comp3710.a2b2b.recipeguruapplication.Entity.RecipeType;

@Database(entities = {Account.class, Ingredient.class, Measurement.class, Recipe.class, RecipeImage.class, RecipeInstructionStep.class, RecipeType.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase INSTANCE;

    public abstract AccountDao accountDao();
    public abstract RecipeDao recipeDao();
    public abstract IngredientDao ingredientDao();
    public abstract MeasurementDao measurementDao();
    public abstract RecipeImageDao recipeImageDao();
    public abstract RecipeInstructionStepDao recipeInstructionStepDao();
    public abstract RecipeTypeDao recipeTypeDao();

    public static AppDatabase getAppDatabase(Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE =
                            Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "recipeguru-database")
                                    .build();
                }
            }
        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }
}
