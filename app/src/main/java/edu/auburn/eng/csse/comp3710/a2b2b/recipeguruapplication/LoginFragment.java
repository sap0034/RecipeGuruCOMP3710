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

public class LoginFragment extends Fragment {

    private Account myTestAccount;
    private EditText myEmailLogin;
    private EditText myPasswordLogin;
    private Button myLoginButton;
    private Button myCreateAccountButton;
    private Button myForgotPasswordButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myTestAccount = new Account();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.login_fragment, container, false);

        myEmailLogin = (EditText) v.findViewById(R.id.emailLogin);
        myEmailLogin.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence s, int i, int i1, int i2) {
                myTestAccount.setEmailAddress(s.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        myPasswordLogin = (EditText) v.findViewById(R.id.passwordLogin);
        myPasswordLogin.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence s, int i, int i1, int i2) {
                myTestAccount.setPassword(s.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        myLoginButton = (Button) v.findViewById(R.id.loginButton);
        myLoginButton.setEnabled(false);

        myCreateAccountButton = (Button) v.findViewById(R.id.createAccountButton);

        myForgotPasswordButton = (Button) v.findViewById(R.id.forgotPasswordButton);

        return v;
    }

}
