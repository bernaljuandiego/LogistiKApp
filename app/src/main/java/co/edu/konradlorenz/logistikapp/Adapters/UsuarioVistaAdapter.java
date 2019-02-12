package co.edu.konradlorenz.logistikapp.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;

import co.edu.konradlorenz.logistikapp.Entities.Estudiante;
import co.edu.konradlorenz.logistikapp.R;

public class UsuarioVistaAdapter extends RecyclerView.Adapter<UsuarioVistaAdapter.UsuarioViewHolder> {

    private ArrayList<Estudiante> items;

    public UsuarioVistaAdapter(ArrayList<Estudiante> items) {
        this.items = items;
    }


    public ArrayList<Estudiante> getItems() {
        return items;
    }

    public void setItems(ArrayList<Estudiante> items) {
        this.items = items;
    }


    @NonNull
    @Override
    public UsuarioViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_usuario, parent, false);
        UsuarioViewHolder pvh = new UsuarioViewHolder(v);
        return pvh;
    }

 

    @Override
    public void onBindViewHolder(@NonNull UsuarioViewHolder holder, int position) {
        holder.nombre.setText(items.get(position).getNombre()+" "+items.get(position).getApellido());
        holder.codigo.setText(Integer.toString(items.get(position).getCodigo()));
        holder.correo.setText(items.get(position).getCorreo());
    }


    @Override
    public int getItemCount() {
        return items.size();
    }


    public static class UsuarioViewHolder extends RecyclerView.ViewHolder {
        TextView nombre;
        TextView codigo;
        TextView correo;

        UsuarioViewHolder(View itemView) {
            super(itemView);
            nombre = (TextView) itemView.findViewById(R.id.nombreCard);
            codigo = (TextView) itemView.findViewById(R.id.codigoCard);
            correo = (TextView) itemView.findViewById(R.id.correoCard);
        }
    }
}

