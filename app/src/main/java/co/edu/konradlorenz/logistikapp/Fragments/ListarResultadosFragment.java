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

import co.edu.konradlorenz.logistikapp.Activities.ResultActivity;
import co.edu.konradlorenz.logistikapp.Adapters.LevelAdapter;
import co.edu.konradlorenz.logistikapp.Adapters.UsuarioVistaAdapter;
import co.edu.konradlorenz.logistikapp.Entities.Nivel;
import co.edu.konradlorenz.logistikapp.Entities.User;
import co.edu.konradlorenz.logistikapp.Layouts.ExpandableHeightListView;
import co.edu.konradlorenz.logistikapp.Layouts.ListviewAdapter;
import co.edu.konradlorenz.logistikapp.R;


public class ListarResultadosFragment extends Fragment {
    private DatabaseReference baseDeDatos;
    private ValueEventListener lisener;


    private ExpandableHeightListView listview;
    private ExpandableHeightListView listview2;
    private ArrayList<Nivel> Bean;
    private ArrayList<Nivel> Bean2;
    private ListviewAdapter baseAdapter;
    private ListviewAdapter baseAdapter2;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_lista_resultados, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        baseDeDatos = FirebaseDatabase.getInstance().getReference("BaseDatos").child("Niveles");
        listview = (ExpandableHeightListView) getView().findViewById(R.id.haircut_list);
        listview2 = (ExpandableHeightListView) getView().findViewById(R.id.hairstyling_list);
        Bean = new ArrayList<>();
        Bean2 = new ArrayList<>();
    }



    @Override
    public void onResume() {
        super.onResume();
        lisener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                Bean.clear();
                Bean2.clear();
                for (DataSnapshot asistenteSnapshot: snapshot.getChildren()) {
                    Nivel nivel = asistenteSnapshot.getValue(Nivel.class);
                    Bean.add(nivel);
                    Bean2.add(nivel);
                }

                baseAdapter = new ListviewAdapter(getActivity(), Bean) {};
                baseAdapter2 = new ListviewAdapter(getContext(), Bean2) {};
                listview.setAdapter(baseAdapter);
                listview2.setAdapter(baseAdapter2);
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
}
