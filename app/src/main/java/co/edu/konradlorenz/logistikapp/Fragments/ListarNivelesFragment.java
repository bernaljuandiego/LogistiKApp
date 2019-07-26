package co.edu.konradlorenz.logistikapp.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import co.edu.konradlorenz.logistikapp.Activities.AgregarNivelActivity;
import co.edu.konradlorenz.logistikapp.Adapters.NivelAdapter;
import co.edu.konradlorenz.logistikapp.Entities.Nivel;
import co.edu.konradlorenz.logistikapp.Entities.Registro;
import co.edu.konradlorenz.logistikapp.Entities.Usuario;
import co.edu.konradlorenz.logistikapp.R;
import pl.droidsonroids.gif.GifImageView;


public class ListarNivelesFragment extends Fragment {
    private List<Nivel> productList;
    private View view;
    private DatabaseReference baseDeDatos;
    private ValueEventListener lisener;
    private GifImageView gif;
    private RecyclerView items;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private FloatingActionButton floatingActionButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_lista_niveles, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        productList = new ArrayList<>();
        gif = (GifImageView) view.findViewById(R.id.gif);
        baseDeDatos = FirebaseDatabase.getInstance().getReference("BaseDatos").child("Niveles");
        floatingActionButton = (FloatingActionButton) getView().findViewById(R.id.floating_action_button);
    }

    @Override
    public void onResume() {
        super.onResume();
        StartAnimations();

        //prueba
        ArrayList<Integer> cajas = new ArrayList<>();
        cajas.add(1);
        cajas.add(2);
        Nivel nivel = new Nivel("prueba",cajas,"nivel de prueba", "juan Diego","11-01-2019");
        ArrayList<Registro> registros = new ArrayList<>();
        registros.add(new Registro("100m", new Usuario("1", "juan", "correo", "ffd")));
        nivel.setRegistros(registros);
        baseDeDatos.child("1").setValue(nivel);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), AgregarNivelActivity.class);
                startActivity(intent);
            }
        });

        lisener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                productList.clear();
                gif.setVisibility(View.GONE);
                for (DataSnapshot asistenteSnapshot: snapshot.getChildren()) {
                    Nivel estudiante = asistenteSnapshot.getValue(Nivel.class);
                    productList.add(estudiante);
                }

                items= (RecyclerView) getView().findViewById(R.id.recyclerView);
                items.setHasFixedSize(true);

                // use a linear layout manager
                mLayoutManager = new GridLayoutManager(getContext(),2);
                items.setLayoutManager(mLayoutManager);

                // specify an adapter (see also next example)
                mAdapter = new NivelAdapter(getContext(),productList);
                items.setAdapter(mAdapter);
            }
            @Override
            public void onCancelled(DatabaseError firebaseError) {
                Log.e("The read failed: " ,firebaseError.getMessage());
            }
        };
        baseDeDatos.addValueEventListener(lisener);
    }


    @Override
    public void onPause() {
        super.onPause();
        baseDeDatos.removeEventListener(lisener);
    }

    private void StartAnimations() {
        Animation anim = AnimationUtils.loadAnimation(getContext(), R.anim.alpha);
        anim = AnimationUtils.loadAnimation(getContext(), R.anim.translate);
        anim.reset();
        RecyclerView l=(RecyclerView) getView().findViewById(R.id.recyclerView);
        l.clearAnimation();
        l.startAnimation(anim);
        Thread splashTread = new Thread() {
            @Override
            public void run() {
                try {
                    int waited = 0;
                    // SplashActivity screen pause time
                    while (waited < 1000) {
                        sleep(100);
                        waited += 100;
                    }
                } catch (InterruptedException e) {
                } finally {
                }

            }
        };
        splashTread.start();
    }
}