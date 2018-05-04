package edu.auburn.eng.csse.comp3710.a2b2b.recipeguruapplication;

import android.app.Fragment;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import edu.auburn.eng.csse.comp3710.a2b2b.recipeguruapplication.Database.AppDatabase;
import edu.auburn.eng.csse.comp3710.a2b2b.recipeguruapplication.Entity.Account;
import edu.auburn.eng.csse.comp3710.a2b2b.recipeguruapplication.Entity.Recipe;
import edu.auburn.eng.csse.comp3710.a2b2b.recipeguruapplication.Entity.RecipeType;


public class RecipeCreateFragment extends Fragment {
    private Account myAccount;
    private Recipe myNewRecipe;
    private EditText myRecipeName;
    private EditText myRecipeCookTime;
    private EditText myRecipePrepTime;
    private EditText myRecipeTotalTime;
    private EditText myServings;
    private EditText myRecipeType;
    private Button mySaveButton;
    private Spinner recipetypespinner;
    AppDatabase db;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myNewRecipe = new Recipe();
    }

    //add items to spinner recipe types
    public void addRecipeTypeSpinner() {
        recipetypespinner = (Spinner) getView().findViewById(R.id.recipetype_spinner);
        List<RecipeType> recipeTypeList = db.recipeTypeDao().getAll();
        List<String> list = new ArrayList<String>();
        for (RecipeType name:recipeTypeList) {
            String recipetype = name.getRecipeTypeText();
            list.add(recipetype);
        }
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_item, list);
        recipetypespinner.setAdapter(dataAdapter);

    }

    //add listener
    public void addListenerOnSpinnerItemSelection() {
        recipetypespinner = (Spinner) getView().findViewById(R.id.recipetype_spinner);
    }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View v = inflater.inflate(R.layout.activity_recipe, container, false);

            myRecipeName = (EditText) v.findViewById(R.id.createrecipename);
            myRecipeName.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence s, int i, int i1, int i2) {
                    myNewRecipe.setRecipeName(s.toString());
                }

                @Override
                public void afterTextChanged(Editable editable) {

                }
            });

            myRecipeCookTime = (EditText) v.findViewById(R.id.recipe_cooktime);
            myRecipeCookTime.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence s, int i, int i1, int i2) {
                    myNewRecipe.setCookTime(s.toString());
                }

                @Override
                public void afterTextChanged(Editable editable) {

                }
            });

            myRecipePrepTime = (EditText) v.findViewById(R.id.recipe_preptime);
            myRecipePrepTime.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence s, int i, int i1, int i2) {
                    myNewRecipe.setPrepTime(s.toString());
                }

                @Override
                public void afterTextChanged(Editable editable) {

                }
            });

            myRecipeTotalTime = (EditText) v.findViewById(R.id.recipe_totaltime);
            myRecipeTotalTime.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence s, int i, int i1, int i2) {
                    myNewRecipe.setTotalTime(s.toString());
                }

                @Override
                public void afterTextChanged(Editable editable) {

                }
            });

            myServings = (EditText) v.findViewById(R.id.servingsnumber);
            myServings.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence s, int i, int i1, int i2) {

                }


                @Override
                public void afterTextChanged(Editable editable) {

                }
            });

            mySaveButton = (Button) v.findViewById(R.id.saveRecipebutton);
            mySaveButton.setEnabled(false);

            db.recipeDao().addRecipe(myNewRecipe);


            return v;
        }




}
