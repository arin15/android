package mvp.android.my.training.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import mvp.android.my.training.R;
import mvp.android.my.training.adapter.ListAdapter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] list = getResources().getStringArray(R.array.country);

        ListAdapter listAdapter = new ListAdapter(this, R.layout.list, list);
        ListView listView = (ListView) findViewById(R.id.listView1);
        listView.setAdapter(listAdapter);

    }
}
