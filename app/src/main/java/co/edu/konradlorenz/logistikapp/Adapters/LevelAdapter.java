package co.edu.konradlorenz.logistikapp.Adapters;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import co.edu.konradlorenz.logistikapp.Activities.ResultActivity;
import co.edu.konradlorenz.logistikapp.Entities.Nivel;
import co.edu.konradlorenz.logistikapp.R;
import co.edu.konradlorenz.logistikapp.UnityPlayerActivity;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import static androidx.core.content.ContextCompat.startActivity;

public class LevelAdapter extends RecyclerView.Adapter<LevelAdapter.LevelViewHolder>  {

    private ArrayList<Nivel> items;

    private Context context;

    public LevelAdapter(ArrayList<Nivel> items, Context context) {
        this.items = items;
        this.context = context;
    }


    public ArrayList<Nivel> getItems() {
        return items;
    }

    public void setItems(ArrayList<Nivel> items) {
        this.items = items;
    }


    @NonNull
    @Override
    public LevelAdapter.LevelViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_level, parent, false);
        LevelAdapter.LevelViewHolder pvh = new LevelAdapter.LevelViewHolder(v);
        return pvh;
    }



    @Override
    public void onBindViewHolder(@NonNull LevelAdapter.LevelViewHolder holder, int position) {
        holder.nombre.setText(items.get(position).getNombre());
        holder.descripcion.setText(items.get(position).getDescripcion());
        holder.botonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, ResultActivity.class);
                startActivity(context,i,null);
            }
        });
    }


    @Override
    public int getItemCount() {
        return items.size();
    }


    public static class LevelViewHolder extends RecyclerView.ViewHolder {
        TextView nombre;
        TextView descripcion;
        Button botonStart;

        LevelViewHolder(View itemView) {
            super(itemView);
            nombre = (TextView) itemView.findViewById(R.id.nombreCard);
            descripcion = itemView.findViewById((R.id.descripcion_card));
            botonStart = itemView.findViewById(R.id.button_start);
        }
    }
}
