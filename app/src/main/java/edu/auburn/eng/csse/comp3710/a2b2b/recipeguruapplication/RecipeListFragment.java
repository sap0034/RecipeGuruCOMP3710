package edu.auburn.eng.csse.comp3710.a2b2b.recipeguruapplication;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import edu.auburn.eng.csse.comp3710.a2b2b.recipeguruapplication.Database.AppDatabase;
import edu.auburn.eng.csse.comp3710.a2b2b.recipeguruapplication.Entity.Recipe;

public class RecipeListFragment extends Fragment {
    private RecyclerView myRecipeList;
    private RecipeAdapter myRecipeAdapter;
    private List<Recipe> myImports;
    private AppDatabase db;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.recipe_list_fragment, container, false);

        myRecipeList = v.findViewById(R.id.recipe_recycler_view);
        myRecipeList.setLayoutManager(new LinearLayoutManager(getActivity()));
        updateUI();
        return v;
    }

    private void updateUI() {
        myImports = db.recipeDao().getAll(0);
        myRecipeAdapter = new RecipeAdapter(myImports);
        myRecipeList.setAdapter(myRecipeAdapter);
    }

    private class RecipeHolder extends RecyclerView.ViewHolder {
        public RecipeHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.list_recipe, parent, false));
        }
    }

    private class RecipeAdapter extends RecyclerView.Adapter<RecipeHolder> {
        private List<Recipe> myRecipes;

        public RecipeAdapter(List<Recipe> recipes){
            myRecipes = recipes;
        }

        @Override
        public RecipeHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            return new RecipeHolder(layoutInflater, parent);
        }

        @Override
        public void onBindViewHolder(RecipeHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return myRecipes.size();
        }
    }
}
