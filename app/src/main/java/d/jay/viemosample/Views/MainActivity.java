package d.jay.viemosample.Views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import d.jay.viemosample.R;
import d.jay.viemosample.Views.CategeoryFragments;

public class MainActivity extends AppCompatActivity {

    CategeoryFragments categeoryFragments;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        categeoryFragments = new CategeoryFragments();
        getSupportFragmentManager().beginTransaction().add(R.id.content_frame,categeoryFragments)
                .commit();
    }
}

