package mvp.android.my.training.view;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;

import java.util.List;

import mvp.android.my.training.R;
import mvp.android.my.training.adapter.GridAdapter;

/**
 * Created by KTW on 2016-05-03.
 */
public class GridViewActivity extends AppCompatActivity {

    Activity act = this;
    GridView gridView;
    private List<ResolveInfo> apps;
    private PackageManager packageManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent mainIntent = new Intent(Intent.ACTION_MAIN, null);
        mainIntent.addCategory(Intent.CATEGORY_LAUNCHER);

        packageManager = getPackageManager();
        apps = packageManager.queryIntentActivities(mainIntent, 0);

        setContentView(R.layout.activity_gridview);

        gridView = (GridView) findViewById(R.id.gridView1);
        gridView.setAdapter(new GridAdapter(act, apps, packageManager));

    }
}
