package co.edu.konradlorenz.logistikapp.Fragments;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import co.edu.konradlorenz.logistikapp.Adapters.UsuarioAdapter;
import co.edu.konradlorenz.logistikapp.Entities.Usuario;
import co.edu.konradlorenz.logistikapp.R;
import pl.droidsonroids.gif.GifImageView;


public class ListarEstudiantesFragment extends Fragment {
    private RecyclerView items;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private DatabaseReference baseDeDatos;
    private ArrayList<Usuario> estudiantes;
    private ValueEventListener lisener;
    private GifImageView gif;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_lista_estudiantes, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        baseDeDatos = FirebaseDatabase.getInstance().getReference("BaseDatos").child("Users");
        estudiantes = new ArrayList<>();
        gif = (GifImageView) getView().findViewById(R.id.gif);
    }

    @Override
    public void onResume() {
        super.onResume();
        StartAnimations();
        lisener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                estudiantes.clear();
                gif.setVisibility(View.GONE);
                for (DataSnapshot asistenteSnapshot: snapshot.getChildren()) {
                    Usuario estudiante = asistenteSnapshot.getValue(Usuario.class);
                    estudiantes.add(estudiante);
                }

                items = (RecyclerView) getView().findViewById(R.id.listaCategoria);
                items.setHasFixedSize(true);

                // use a linear layout manager
                mLayoutManager = new LinearLayoutManager(getContext());
                items.setLayoutManager(mLayoutManager);

                // specify an adapter (see also next example)
                mAdapter = new UsuarioAdapter(estudiantes,getContext());
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
        RelativeLayout l=(RelativeLayout) getView().findViewById(R.id.card);
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
