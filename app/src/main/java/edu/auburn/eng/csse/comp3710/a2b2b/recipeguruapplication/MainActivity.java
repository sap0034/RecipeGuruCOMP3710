package edu.auburn.eng.csse.comp3710.a2b2b.recipeguruapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import edu.auburn.eng.csse.comp3710.a2b2b.recipeguruapplication.Database.AppDatabase;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page);
    }

    @Override
    protected void onDestroy() {
        AppDatabase.destroyInstance();
        super.onDestroy();
    }
}
