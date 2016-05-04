package mvp.android.my.training.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import mvp.android.my.training.R;


/**
 * Created by KTW on 2016-05-03.
 */
public class GridAdapter extends BaseAdapter {

    LayoutInflater inflater;
    private List<ResolveInfo> apps;
    private PackageManager packageManager;

    public GridAdapter(Activity act, List<ResolveInfo> apps, PackageManager packageManager) {
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

        return convertView;
    }
}
