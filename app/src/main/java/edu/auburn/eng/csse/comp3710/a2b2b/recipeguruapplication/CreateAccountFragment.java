package edu.auburn.eng.csse.comp3710.a2b2b.recipeguruapplication;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import edu.auburn.eng.csse.comp3710.a2b2b.recipeguruapplication.Entity.Account;

public class CreateAccountFragment extends Fragment {
    private Account myNewAccount;
    private EditText myFirstNameCreate;
    private EditText myLastNameCreate;
    private EditText myEmailCreate;
    private EditText myPasswordCreate;
    private EditText myPasswordConfirm;
    private Button mySaveButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myNewAccount = new Account();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.create_account_fragment, container, false);

        myFirstNameCreate = (EditText) v.findViewById(R.id.firstNameCreate);
        myFirstNameCreate.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence s, int i, int i1, int i2) {
                myNewAccount.setFirstName(s.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        myLastNameCreate = (EditText) v.findViewById(R.id.lastNameCreate);
        myLastNameCreate.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence s, int i, int i1, int i2) {
                myNewAccount.setLastName(s.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        myEmailCreate = (EditText) v.findViewById(R.id.emailCreate);
        myEmailCreate.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence s, int i, int i1, int i2) {
                myNewAccount.setEmailAddress(s.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        myPasswordCreate = (EditText) v.findViewById(R.id.passwordCreate);
        myPasswordCreate.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence s, int i, int i1, int i2) {
                myNewAccount.setPassword(s.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        myPasswordConfirm = (EditText) v.findViewById(R.id.passwordCreateConfirm);
        myPasswordConfirm.addTextChangedListener(new TextWatcher() {
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

        mySaveButton = (Button) v.findViewById(R.id.saveAccountButton);
        mySaveButton.setEnabled(false);

        return v;
    }
}
