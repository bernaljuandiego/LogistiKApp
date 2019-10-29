package co.edu.konradlorenz.logistikapp.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import co.edu.konradlorenz.logistikapp.Entities.Nivel;
import co.edu.konradlorenz.logistikapp.Entities.Registro;
import co.edu.konradlorenz.logistikapp.Entities.Usuario;
import co.edu.konradlorenz.logistikapp.Fragments.ListarResultadosFragment;
import co.edu.konradlorenz.logistikapp.Layouts.ChildAnimationExample;
import co.edu.konradlorenz.logistikapp.Layouts.ExpandableHeightListView;
import co.edu.konradlorenz.logistikapp.Layouts.ListviewAdapter;
import co.edu.konradlorenz.logistikapp.Layouts.SliderLayout;
import co.edu.konradlorenz.logistikapp.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.facebook.login.LoginManager;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;


public class ResultadoActivity extends AppCompatActivity implements BaseSliderView.OnSliderClickListener {
    SliderLayout mDemoSlider;

    private FirebaseAuth mAuth;


    private ExpandableHeightListView listview;
    private ExpandableHeightListView listview2;
    private ArrayList<Nivel> Bean;
    private ArrayList<Nivel> Bean2;
    private ListviewAdapter baseAdapter;
    private ListviewAdapter baseAdapter2;
    private DatabaseReference baseDeDatos;
    private ValueEventListener lisener;
    private static String distancia;
    private Usuario usuario;
    private String id = "";
    private DatabaseReference mDatabase;

    public static void Call(Activity activity, String distancias)
    {
        distancia = distancias;
        Intent myIntent = new Intent(activity, ResultadoActivity.class);
        activity.startActivity(myIntent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);


        mDatabase = FirebaseDatabase.getInstance().getReference();
        mAuth = FirebaseAuth.getInstance();

        //toolbar
        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);

        TabLayout tab = (TabLayout) findViewById(R.id.tablayout);
        tab.setVisibility(View.GONE);

        setTitle("Evaluacion");

        TextView texto = (TextView) findViewById(R.id.texto_distancia);
        texto.setText(distancia);
        id = mDatabase.push().getKey();
        //usuario = new Usuario(mAuth.getCurrentUser().getDisplayName(), mAuth.getCurrentUser().getEmail(), mAuth.getCurrentUser().getPhotoUrl().toString(), mAuth.getCurrentUser().getUid());
        //mDatabase.child("BaseDatos").child("Niveles").child("evaluación").child("registros").child(id).setValue(new Registro(distancia,new Usuario()));


        Fragment fragment = new ListarResultadosFragment();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.contenido, fragment);
        ft.commit();

        mDemoSlider = (SliderLayout) findViewById(R.id.slider);

        HashMap<String, Integer> file_maps = new HashMap<String, Integer>();
        file_maps.put("1", R.drawable.ejemplo_uso);
        file_maps.put("2", R.drawable.cargador);
        file_maps.put("3", R.drawable.marcador);


        for (String name : file_maps.keySet()) {
            TextSliderView textSliderView = new TextSliderView(this);
            // initialize a SliderLayout
            textSliderView
                    //  .description(name)
                    .image(file_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.CenterCrop)
                    .setOnSliderClickListener(this);


            textSliderView.bundle(new Bundle());
            textSliderView.getBundle().putString("extra", name);

            mDemoSlider.addSlider(textSliderView);
        }
        mDemoSlider.setPresetTransformer(SliderLayout.Transformer.Default);
        mDemoSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        mDemoSlider.setCustomAnimation(new ChildAnimationExample());
        mDemoSlider.setDuration(4000);
    }

    @Override
    public void onSliderClick(BaseSliderView slider) {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_toolbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_sign_out:
                cerrarSesion();
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }

    private void cerrarSesion() {
        mAuth.signOut();
        LoginManager.getInstance().logOut();
        Intent intent = new Intent(this, IniciarSesionActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}

