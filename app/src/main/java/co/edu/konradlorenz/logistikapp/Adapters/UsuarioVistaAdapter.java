package co.edu.konradlorenz.logistikapp.Adapters;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

import co.edu.konradlorenz.logistikapp.Entities.User;
import co.edu.konradlorenz.logistikapp.R;

public class UsuarioVistaAdapter extends RecyclerView.Adapter<UsuarioVistaAdapter.UsuarioViewHolder> {

    private ArrayList<User> items;

    public UsuarioVistaAdapter(ArrayList<User> items, Context context) {
        this.items = items;
        this.context = context;
    }


    public ArrayList<User> getItems() {
        return items;
    }

    public void setItems(ArrayList<User> items) {
        this.items = items;
    }

    private Context context;


    @NonNull
    @Override
    public UsuarioViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_usuario, parent, false);
        UsuarioViewHolder pvh = new UsuarioViewHolder(v);
        return pvh;
    }

 

    @Override
    public void onBindViewHolder(@NonNull UsuarioViewHolder holder, int position) {
        holder.nombre.setText(items.get(position).getNombre());
        holder.correo.setText(items.get(position).getCorreo());
        Glide.with(context).load(items.get(position).getFotoPerfil()).apply(RequestOptions.circleCropTransform()).into(holder.imagenUsuario);
    }


    @Override
    public int getItemCount() {
        return items.size();
    }


    public static class UsuarioViewHolder extends RecyclerView.ViewHolder {
        TextView nombre;
        TextView correo;
        ImageView imagenUsuario;

        UsuarioViewHolder(View itemView) {
            super(itemView);
            imagenUsuario = (ImageView) itemView.findViewById(R.id.imagenCard);
            nombre = (TextView) itemView.findViewById(R.id.nombreCard);
            correo = (TextView) itemView.findViewById(R.id.correoCard);
        }
    }
}

