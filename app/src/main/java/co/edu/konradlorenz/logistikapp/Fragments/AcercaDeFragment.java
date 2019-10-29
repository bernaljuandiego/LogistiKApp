package co.edu.konradlorenz.logistikapp.Fragments;



import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;

import java.util.HashMap;

import co.edu.konradlorenz.logistikapp.Layouts.ChildAnimationExample;
import co.edu.konradlorenz.logistikapp.Layouts.SliderLayout;
import co.edu.konradlorenz.logistikapp.R;


public class AcercaDeFragment extends Fragment {

    private SliderLayout mDemoSlider;;
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_acerca_de, container, false);
    }

    @Override
    public void onResume() {
        super.onResume();

        mDemoSlider = (SliderLayout) getView().findViewById(R.id.slider);

        HashMap<String, Integer> file_maps = new HashMap<String, Integer>();
        file_maps.put("1", R.drawable.ejemplo_uso);
        file_maps.put("2", R.drawable.cargador);
        file_maps.put("3", R.drawable.marcador);


        for (String name : file_maps.keySet()) {
            TextSliderView textSliderView = new TextSliderView(getContext());
            // initialize a SliderLayout
            textSliderView
                    //  .description(name)
                    .image(file_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.CenterCrop);


            textSliderView.bundle(new Bundle());
            textSliderView.getBundle().putString("extra", name);

            mDemoSlider.addSlider(textSliderView);
        }
        mDemoSlider.setPresetTransformer(SliderLayout.Transformer.Default);
        mDemoSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        mDemoSlider.setCustomAnimation(new ChildAnimationExample());
        mDemoSlider.setDuration(4000);
    }
}
