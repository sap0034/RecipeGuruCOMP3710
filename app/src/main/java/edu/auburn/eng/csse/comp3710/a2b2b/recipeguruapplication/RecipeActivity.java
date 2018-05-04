package edu.auburn.eng.csse.comp3710.a2b2b.recipeguruapplication;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

public class RecipeActivity extends MainActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);
        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragment_container);

        if (fragment == null) {
            fragment = new CreateAccountFragment();
            fm.beginTransaction().add(R.id.fragment_container, fragment).commit();
        }

        setupToolbar(R.id.toolbar, "Recipe Guru", R.color.colorWhiteTrans, R.color.colorNavy, R.drawable.ic_burger);
    }
}
