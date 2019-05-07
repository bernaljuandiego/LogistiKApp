package co.edu.konradlorenz.logistikapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;
import co.edu.konradlorenz.logistikapp.Entities.Nivel;
import co.edu.konradlorenz.logistikapp.R;

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
       View view =inflater.inflate(R.layout.list_layout,null);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProductViewHolder holder, int position) {

        Nivel product =productList.get(position);

        //binding the data with the viewholder views
        holder.textViewTitle.setText(product.getNombre());
        holder.textViewShortDesc.setText(product.getDescripcion());
        holder.textName.setText(String.valueOf(product.getCajas()));
        holder.textHour.setText("11/04/2019");

    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    class ProductViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView textViewTitle, textViewShortDesc, textName, textHour;

        public ProductViewHolder(View itemView) {
            super(itemView);

            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            textViewShortDesc = itemView.findViewById(R.id.textViewShortDesc);
            textName = itemView.findViewById(R.id.textName);
            textHour = itemView.findViewById(R.id.textHour);
            imageView = itemView.findViewById(R.id.imageView);
        }

    }
}
