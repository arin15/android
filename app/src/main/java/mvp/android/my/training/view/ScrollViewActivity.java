package mvp.android.my.training.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import mvp.android.my.training.R;

/**
 * Created by KTW on 2016-05-04.
 */
public class ScrollViewActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrollview);

        ImageView imageView1 = (ImageView) findViewById(R.id.imageView1);
        ImageView imageView2 = (ImageView) findViewById(R.id.imageView2);
        ImageView imageView3 = (ImageView) findViewById(R.id.imageView3);
        ImageView imageView4 = (ImageView) findViewById(R.id.imageView4);
        ImageView imageView5 = (ImageView) findViewById(R.id.imageView5);
        ImageView imageView6 = (ImageView) findViewById(R.id.imageView6);

        imageView1.setAdjustViewBounds(true);
        imageView1.setMaxHeight(400);
        imageView1.setMaxWidth(400);

        imageView2.setAdjustViewBounds(true);
        imageView2.setMaxHeight(400);
        imageView2.setMaxWidth(400);

        imageView3.setAdjustViewBounds(true);
        imageView3.setMaxHeight(400);
        imageView3.setMaxWidth(400);

        imageView4.setAdjustViewBounds(true);
        imageView4.setMaxHeight(400);
        imageView4.setMaxWidth(400);

        imageView5.setAdjustViewBounds(true);
        imageView5.setMaxHeight(400);
        imageView5.setMaxWidth(400);

        imageView6.setAdjustViewBounds(true);
        imageView6.setMaxHeight(400);
        imageView6.setMaxWidth(400);

        imageView1.setImageDrawable(getResources().getDrawable(R.drawable.suzy1));
        imageView2.setImageDrawable(getResources().getDrawable(R.drawable.suzy2));
        imageView3.setImageDrawable(getResources().getDrawable(R.drawable.suzy3));
        imageView4.setImageDrawable(getResources().getDrawable(R.drawable.suzy1));
        imageView5.setImageDrawable(getResources().getDrawable(R.drawable.suzy2));
        imageView6.setImageDrawable(getResources().getDrawable(R.drawable.suzy3));
    }
}
