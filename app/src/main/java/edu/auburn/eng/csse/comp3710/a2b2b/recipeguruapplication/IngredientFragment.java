package edu.auburn.eng.csse.comp3710.a2b2b.recipeguruapplication;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.List;

import edu.auburn.eng.csse.comp3710.a2b2b.recipeguruapplication.Database.AppDatabase;
import edu.auburn.eng.csse.comp3710.a2b2b.recipeguruapplication.Entity.Ingredient;
import edu.auburn.eng.csse.comp3710.a2b2b.recipeguruapplication.Entity.Measurement;

public class IngredientFragment extends Fragment {

    private Ingredient myNewIngredient;
    private String myText;
    private int myAmount;
    private int myRecipeID;
    private int myMeasurementID;
    private String myMeasurementName;
    private List<Measurement> measurementList;

    private EditText myIngredientName;
    private EditText myIngredientAmount;
    private Spinner myMeasurement;
    private Button mySaveButton;
    private AppDatabase db;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        measurementList = db.measurementDao().getAll();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.ingredient_fragment, container, false);

        myIngredientName = v.findViewById(R.id.ingredient_name);
        myIngredientName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                myText = s.toString();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        myIngredientAmount = v.findViewById(R.id.ingredient_amount);
        myIngredientAmount.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                myAmount = Integer.parseInt(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        myMeasurement = v.findViewById(R.id.ingredient_measurements);
        myMeasurement.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                myMeasurementName = myMeasurement.getSelectedItem().toString();
                myMeasurementID = db.measurementDao().findMeasurementByName(myMeasurementName).getMeasurementID();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(myMeasurement.getContext(), R.array.measurementNames, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        myMeasurement.setAdapter(adapter);

        mySaveButton = v.findViewById(R.id.ingredient_save_button);
        mySaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myNewIngredient.setIngredientText(myText);
                myNewIngredient.setIngredientAmount(myAmount);
                myNewIngredient.setMeasurementID(myMeasurementID);
                myNewIngredient.setRecipeID(1);
                db.ingredientDao().addIngredient(myNewIngredient);
            }
        });

        return v;
    }

}
