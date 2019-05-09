package co.edu.konradlorenz.logistikapp.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;
import java.util.List;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import co.edu.konradlorenz.logistikapp.Activities.LoginActivity;
import co.edu.konradlorenz.logistikapp.Adapters.ProductAdapter;
import co.edu.konradlorenz.logistikapp.Entities.Nivel;
import co.edu.konradlorenz.logistikapp.R;
import pl.droidsonroids.gif.GifImageView;


public class NivelesFragment extends Fragment {
    RecyclerView recyclerView;
    ProductAdapter adapter;

    List<Nivel> productList;
    private View view;
    private DatabaseReference baseDeDatos;
    private ValueEventListener lisener;
    private GifImageView gif;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_lista_niveles, container, false);
//        Recyclerview code is here

        productList = new ArrayList<>();
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        gif = (GifImageView) view.findViewById(R.id.gif);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getActivity(), 2);
        recyclerView.setLayoutManager(mLayoutManager);
        baseDeDatos = FirebaseDatabase.getInstance().getReference("BaseDatos").child("Niveles");




        //adding some items to our list
        lisener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                gif.setVisibility(View.GONE);
                productList.clear();
                FloatingActionButton floatingActionButton =
                        (FloatingActionButton) getView().findViewById(R.id.floating_action_button);

                floatingActionButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(getActivity(), AgregarNivelFragment.class);
                        startActivity(intent);
                    }
                });

                for (DataSnapshot asistenteSnapshot: snapshot.getChildren()) {
                    Nivel nivel = asistenteSnapshot.getValue(Nivel.class);
                    productList.add(nivel);
                }

                ProductAdapter adapter = new ProductAdapter(getActivity(), productList);
                //setting adapter to recyclerview
                recyclerView.setAdapter(adapter);
            }
            @Override
            public void onCancelled(DatabaseError firebaseError) {
                Log.e("The read failed: " ,firebaseError.getMessage());
            }
        };


        baseDeDatos.addValueEventListener(lisener);

        return view;



    }

    @Override
    public void onPause() {
        super.onPause();
        baseDeDatos.removeEventListener(lisener);
    }
}


