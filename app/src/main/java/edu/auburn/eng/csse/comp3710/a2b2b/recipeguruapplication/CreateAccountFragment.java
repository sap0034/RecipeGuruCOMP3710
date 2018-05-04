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
import android.widget.Toast;

import java.util.Date;
import java.util.List;

import butterknife.BindView;
import edu.auburn.eng.csse.comp3710.a2b2b.recipeguruapplication.Database.AppDatabase;
import edu.auburn.eng.csse.comp3710.a2b2b.recipeguruapplication.Entity.Account;

public class CreateAccountFragment extends Fragment {
    private Account myNewAccount;
    private EditText myFirstNameCreate;
    private EditText myLastNameCreate;
    private EditText myEmailCreate;
    private EditText myPasswordCreate;
    private EditText myPasswordConfirm;
    private Button mySaveButton;

    private String myFirstName;
    private String myLastName;
    private String myEmail;
    private String myPassword;
    private String myPasswordConfirmation;
    private AppDatabase db;
    @BindView(R.id.saveAccountButton)
    Button saveAccount;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myNewAccount = new Account();
        List<Account> accountList = db.accountDao().getAll();
        allFilledIn();
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
                myFirstName = s.toString();
                allFilledIn();
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
                myLastName = s.toString();
                allFilledIn();
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
                myEmail = s.toString();
                allFilledIn();
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
                myPassword = s.toString();
                allFilledIn();
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
                myPasswordConfirmation = s.toString();
                allFilledIn();
            }


            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        mySaveButton = (Button) v.findViewById(R.id.saveAccountButton);
        mySaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (myPasswordConfirmation.equals(myPassword)) {
                    myNewAccount.setFirstName(myFirstName);
                    myNewAccount.setLastName(myLastName);
                    myNewAccount.setEmailAddress(myEmail);
                    myNewAccount.setPassword(myPassword);
                    myNewAccount.setAccountCreatedDatetime(new Date().toString());
                    db.accountDao().addAccount(myNewAccount);
                }
                else {
                    Toast.makeText(getContext(), R.string.same_password_different, Toast.LENGTH_SHORT).show();
                }
            }
        });

        return v;
    }

    private void allFilledIn() {
        int i = 0;

        if (myFirstName == null) {
            i++;
        }
        if (myLastName == null) {
            i++;
        }
        if (myEmail == null) {
            i++;
        }
        if (myPassword == null) {
            i++;
        }
        if (myPasswordConfirmation == null) {
            i++;
        }

        if (i > 0) {
            mySaveButton.setEnabled(false);
        }
        else {
            mySaveButton.setEnabled(true);
        }
    }

}
