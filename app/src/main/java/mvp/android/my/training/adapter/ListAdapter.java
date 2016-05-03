package mvp.android.my.training.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import mvp.android.my.training.R;


/***
 * 2016-05-03
 * 어댑터 연습
 * 안드로이드 프로그래밍의 첫 발걸음
 */
public class ListAdapter extends BaseAdapter {

    LayoutInflater inflater;
    String[] category;  //데이터 (country)
    Context mContext;   //MainActivity
    int mListLayout;    //list.xml
    public String TAG = "listAdapter";
    public int listCount = 0;

    public ListAdapter(Context tContext, int listLayout, String[] tmp) {
        mContext = tContext;
        mListLayout = listLayout;
        category = tmp;
        inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if(category != null) {
            listCount = category.length;
        }
    }

    @Override
    public int getCount() {
        return listCount;
    }

    @Override
    public Object getItem(int arg) {
        return arg;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(mListLayout, parent, false);
        }

        final  int positionInt = position;

        ((TextView) convertView.findViewById(R.id.textView1)).setText(category[position]);
        convertView.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v) {
                detailInfo(positionInt);
            }
        });

        return convertView;
    }

    public void detailInfo(int position){
        AlertDialog.Builder detailPop = new AlertDialog.Builder(mContext);
        detailPop.setMessage(category[position]).setCancelable(false).setPositiveButton("확인", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                Toast.makeText(mContext, "확인을 클릭했습니다.", Toast.LENGTH_LONG).show();
            }
        }).setNegativeButton("닫기", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();
            }
        });

        AlertDialog alert = detailPop.create();
        alert.setTitle("상세정보");
        alert.setIcon(android.R.drawable.ic_search_category_default);
        alert.show();
    }
}
