package co.edu.konradlorenz.logistikapp.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;
import co.edu.konradlorenz.logistikapp.Activities.ResultActivity;
import co.edu.konradlorenz.logistikapp.Entities.Nivel;
import co.edu.konradlorenz.logistikapp.R;

import static androidx.core.content.ContextCompat.startActivity;

/**
 * Created by KURPC on 24-01-2018.
 */

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder>{

    private Context mCtx;
    private List<Nivel> productList;

    public ProductAdapter(Context mCtx, List<Nivel> productList) {
        this.mCtx = mCtx;
        this.productList = productList;
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
       View view =inflater.inflate(R.layout.adapter_niveles,null);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProductViewHolder holder, int position) {

        Nivel product =productList.get(position);

        //binding the data with the viewholder views
        holder.numberLevels.setText("#"+(position+1));
        holder.textViewTitle.setText(product.getNombre());
        holder.textViewShortDesc.setText(product.getDescripcion());
        holder.textName.setText(product.getCreador());
        holder.textHour.setText(product.getFecha());
        holder.botonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(mCtx, ResultActivity.class);
                startActivity(mCtx,i,null);
            }
        });

    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    class ProductViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView,botonStart;
        TextView textViewTitle, textViewShortDesc, textName, textHour, numberLevels;

        public ProductViewHolder(View itemView) {
            super(itemView);

            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            textViewShortDesc = itemView.findViewById(R.id.textViewShortDesc);
            textName = itemView.findViewById(R.id.textName);
            textHour = itemView.findViewById(R.id.textHour);
            imageView = itemView.findViewById(R.id.imageView);
            botonStart = itemView.findViewById(R.id.button_start);
            numberLevels = itemView.findViewById(R.id.number_level);

        }

    }
}
