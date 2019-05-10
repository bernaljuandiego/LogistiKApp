package co.edu.konradlorenz.logistikapp.Layouts;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import co.edu.konradlorenz.logistikapp.Entities.Nivel;
import co.edu.konradlorenz.logistikapp.R;


public class ListviewAdapter extends BaseAdapter {

    Context context;

    ArrayList<Nivel> bean;
    Typeface fonts1,fonts2;

    Activity main;




    public ListviewAdapter(Context context, ArrayList<Nivel> bean) {


        this.context = context;
        this.bean = bean;
    }

    @Override
    public int getCount() {
        return bean.size();
    }

    @Override
    public Object getItem(int position) {
        return bean.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        fonts1 =  Typeface.createFromAsset(context.getAssets(),
                "fonts/MavenPro-Regular.ttf");

        fonts2 = Typeface.createFromAsset(context.getAssets(),
                "fonts/MavenPro-Regular.ttf");

        final ViewHolder viewHolder;

        if (convertView == null){
            LayoutInflater layoutInflater = (LayoutInflater)context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.adapter_registro,null);

            viewHolder = new ViewHolder();


            viewHolder.title = (TextView) convertView.findViewById(R.id.title);
            viewHolder.price = (TextView) convertView.findViewById(R.id.price);
            viewHolder.detail = (TextView) convertView.findViewById(R.id.detail);



            viewHolder.title.setTypeface(fonts1);




            convertView.setTag(viewHolder);

        }else {

            viewHolder = (ViewHolder)convertView.getTag();
        }


        Nivel bean = (Nivel) getItem(position);

        viewHolder.title.setText(bean.getNombre());
        viewHolder.price.setText(Integer.toString(bean.getCajas().size()));
        viewHolder.detail.setText(bean.getDescripcion());





        return convertView;
    }

    private class ViewHolder {

        TextView title;
        TextView price;
        TextView detail;



    }
}



