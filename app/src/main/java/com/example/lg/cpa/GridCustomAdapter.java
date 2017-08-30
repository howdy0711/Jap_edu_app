package com.example.lg.cpa;
        import android.widget.BaseAdapter;
        import android.content.Context;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ImageView;
        import android.widget.TextView;
public class GridCustomAdapter extends BaseAdapter  {
    private Context mContext;
    public Integer[] images = {R.drawable.video1,R.drawable.video2,R.drawable.video3,
            R.drawable.video4,R.drawable.video5,R.drawable.video6,
            R.drawable.video7,R.drawable.video8,R.drawable.viedo9,
            };
    public static String[] imagesnames = {"제 1화","제 2화","제 3화", "제 4화","제 5화","제 6화",
            "제 7화","제 8화","제 9화",
    };
    public GridCustomAdapter(Context context)
    {
        mContext = context;
    }
    @Override
    public int getCount() {
        return imagesnames.length;
    }
    @Override
    public Object getItem(int position) {
        return imagesnames[position];
    }
    @Override
    public long getItemId(int position) {
// TODO Auto-generated method stub
        return 0;
    }
    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view=inflater.inflate(R.layout.girditem, parent, false);
        TextView image_name = (TextView)view.findViewById(R.id.image_name);
        ImageView icon = (ImageView)view.findViewById(R.id.image);
        image_name.setText(imagesnames[position]);
        icon.setImageResource(images[position]);
        return view;
    }

}
