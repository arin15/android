package mvp.android.my.training.adapter;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import mvp.android.my.training.R;


/**
 * Created by KTW on 2016-05-03.
 */
public class GridAdapter extends BaseAdapter {

    Activity act;
    LayoutInflater inflater;
    private List<ResolveInfo> apps;
    private PackageManager packageManager;

    public GridAdapter(Activity act, List<ResolveInfo> apps, PackageManager packageManager) {
        this.act = act;
        inflater = (LayoutInflater) act.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.apps = apps;
        this.packageManager = packageManager;
    }

    public final int getCount() {
        return apps.size();
    }

    public final Object getItem(int position) {
        return apps.get(position);
    }

    public final long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item, parent, false);
        }

        final ResolveInfo info = apps.get(position);

        ImageView imageView = (ImageView) convertView.findViewById(R.id.imageView1);
        TextView textView = (TextView) convertView.findViewById(R.id.textView1);
        imageView.setImageDrawable(info.activityInfo.loadIcon(packageManager));
        textView.setText(info.activityInfo.loadLabel(packageManager).toString());

        Log.v("[Program]", info.activityInfo.packageName + "," + info.activityInfo.name);

        imageView.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_RUN);
                intent.setComponent(new ComponentName(
                        info.activityInfo.packageName,
                        info.activityInfo.name));
                act.startActivity(intent);
                String msg = info.activityInfo.packageName + "," + info.activityInfo.name;
                Toast.makeText(act, msg, Toast.LENGTH_LONG).show();
            }
        });
        return convertView;
    }
}
