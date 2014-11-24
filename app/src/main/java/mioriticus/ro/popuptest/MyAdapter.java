package mioriticus.ro.popuptest;

import android.content.Context;
import android.graphics.PorterDuff;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {

    private final Context mContext;
    private ArrayList<String> mData = new ArrayList<>();

    public MyAdapter(Context context) {
        mContext = context;

        initData();
    }

    private void initData() {
        for (int i = 1; i <= 20; i++) {
            mData.add("Item " + i);
        }
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.list_item, parent, false);
        TextView tv = (TextView) rowView.findViewById(R.id.textView);
        tv.setText(mData.get(position));

        ImageButton btn = (ImageButton) rowView.findViewById(R.id.imageButton);
        btn.getBackground().setColorFilter(0xff808080, PorterDuff.Mode.MULTIPLY);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popup = new PopupMenu(mContext, v);
                MenuInflater inflater = popup.getMenuInflater();
                inflater.inflate(R.menu.contextual, popup.getMenu());
                popup.show();
            }
        });

        return rowView;
    }
}
