package co.edu.konradlorenz.logistikapp.Activities;

import androidx.appcompat.app.AppCompatActivity;
import co.edu.konradlorenz.logistikapp.Entities.Nivel;
import co.edu.konradlorenz.logistikapp.Layouts.ChildAnimationExample;
import co.edu.konradlorenz.logistikapp.Layouts.ExpandableHeightListView;
import co.edu.konradlorenz.logistikapp.Layouts.ListviewAdapter;
import co.edu.konradlorenz.logistikapp.Layouts.SliderLayout;
import co.edu.konradlorenz.logistikapp.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;


public class ResultActivity extends AppCompatActivity implements BaseSliderView.OnSliderClickListener {
    SliderLayout mDemoSlider;


    private ExpandableHeightListView listview;
    private ExpandableHeightListView listview2;
    private ArrayList<Nivel> Bean;
    private ArrayList<Nivel> Bean2;
    private ListviewAdapter baseAdapter;
    private ListviewAdapter baseAdapter2;
    private DatabaseReference baseDeDatos;
    private ValueEventListener lisener;

    public static void Call(Activity activity)
    {
        // Creating an intent with the current activity and the activity we wish to start
        Intent myIntent = new Intent(activity, ResultActivity.class);
        activity.startActivity(myIntent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        listview = (ExpandableHeightListView) findViewById(R.id.haircut_list);

        listview2 = (ExpandableHeightListView) findViewById(R.id.hairstyling_list);

        baseDeDatos = FirebaseDatabase.getInstance().getReference("BaseDatos").child("Niveles");
        Bean = new ArrayList<>();
        Bean2 = new ArrayList<>();

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
    public void onPause() {
        super.onPause();
        baseDeDatos.removeEventListener(lisener);
    }


    @Override
    protected void onResume() {
        super.onResume();
        lisener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                Bean.clear();

                for (DataSnapshot asistenteSnapshot: snapshot.getChildren()) {
                    Nivel nivel = asistenteSnapshot.getValue(Nivel.class);
                    Bean.add(nivel);
                    Bean2.add(nivel);
                }

                baseAdapter = new ListviewAdapter(ResultActivity.this, Bean) {};
                baseAdapter2 = new ListviewAdapter(ResultActivity.this, Bean2) {};
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
    public void onSliderClick(BaseSliderView slider) {

    }
}

