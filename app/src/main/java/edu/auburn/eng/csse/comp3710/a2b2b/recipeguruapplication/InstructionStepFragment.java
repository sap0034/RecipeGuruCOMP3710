package edu.auburn.eng.csse.comp3710.a2b2b.recipeguruapplication;

import android.app.Fragment;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import butterknife.BindView;
import edu.auburn.eng.csse.comp3710.a2b2b.recipeguruapplication.Database.AppDatabase;
import edu.auburn.eng.csse.comp3710.a2b2b.recipeguruapplication.Entity.Recipe;
import edu.auburn.eng.csse.comp3710.a2b2b.recipeguruapplication.Entity.RecipeInstructionStep;

public class InstructionStepFragment extends Fragment{
@BindView(R.id.step_number)
    EditText stepNumber;

@BindView(R.id.step_text)
    EditText stepText;

@BindView(R.id.instruction_save_button)
    Button saveInstruction;

@BindView(R.id.recipe_id)
LinearLayout recipeID;

    private RecipeInstructionStep myNewInstructionStep;
    private String myText;
    private int myRecipeID;
    private int orderNumber;

    private EditText myInstructionText;
    private EditText myStepNumber;
    private Recipe Recipe;
    private Button mySaveButton;
    private AppDatabase db;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.ingredient_fragment, container, false);

        myInstructionText = v.findViewById(R.id.ingredient_name);
        myInstructionText.addTextChangedListener(new TextWatcher() {
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

        myStepNumber = v.findViewById(R.id.ingredient_amount);
        myStepNumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                orderNumber = Integer.parseInt(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        mySaveButton = v.findViewById(R.id.instruction_save_button);
        mySaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myNewInstructionStep.setRecipeInstructionText(myText);
                myNewInstructionStep.setRecipeInstructionOrderNumber(orderNumber);
                myNewInstructionStep.setRecipeID(1);
                db.recipeInstructionStepDao().addInstruction(myNewInstructionStep);
            }
        });

        return v;
    }


    public void DeleteInstruction(RecipeInstructionStep instructionStep) {
        db.recipeInstructionStepDao().delete(instructionStep);
    }


}
