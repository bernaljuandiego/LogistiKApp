package co.edu.konradlorenz.logistikapp.Layouts;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements BaseSliderView.OnSliderClickListener {
    SliderLayout mDemoSlider;


    private ExpandableHeightListView listview;
    private ArrayList<BeanclassList> Bean;
    private ListviewAdapter baseAdapter;


    private String[] TITLEC = {"Basic Hair Cut", "Advance Hair Cut","Basic Hair Cut"};
    private String[] PRICEC = {"$ 15", "$ 29","$ 15"};
    private String[] DETAILC = {"Trimming, Split removal", "Get fresh look and blow dry look plus spa","Trimming, Split removal"};


    private String[] TITLES = {"Basic Hair Cut", "Advance Hair Cut", "Advance Hair Cut"};
    private String[] PRICES = {"$ 15", "$ 29", "$ 29"};
    private String[] DETAILS = {"Trimming, Split removal", "Get fresh look and blow dry look plus spa", "Trimming, Split removal"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //        /        ********LISTVIEW   HAIR CUT***********


        listview = (ExpandableHeightListView)findViewById(R.id.haircut_list);


        Bean = new ArrayList<BeanclassList>();

        for (int i= 0; i< TITLEC.length; i++){

            BeanclassList BeanclassList = new BeanclassList(TITLEC[i], PRICEC[i], DETAILC[i]);
            Bean.add(BeanclassList);

        }

        baseAdapter = new ListviewAdapter(MainActivity.this, Bean) {
        };

        listview.setAdapter(baseAdapter);



        //        /        ********LISTVIEW   HAIR STYLING***********


        listview = (ExpandableHeightListView)findViewById(R.id.hairstyling_list);


        Bean = new ArrayList<BeanclassList>();

        for (int i= 0; i< TITLES.length; i++){

            BeanclassList BeanclassList = new BeanclassList(TITLES[i], PRICES[i], DETAILS[i]);
            Bean.add(BeanclassList);

        }

        baseAdapter = new ListviewAdapter(MainActivity.this, Bean) {
        };

        listview.setAdapter(baseAdapter);



        //         ********Slider*********

        mDemoSlider = (SliderLayout)findViewById(R.id.slider);

        HashMap<String,Integer> file_maps = new HashMap<String, Integer>();
        file_maps.put("1", R.drawable.pic1);
        file_maps.put("2",R.drawable.pic);
        file_maps.put("3",R.drawable.pic2);


        for(String name : file_maps.keySet()){
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
        mDemoSlider.addOnPageChangeListener(this);

    }

    @Override
    public void onSliderClick(BaseSliderView slider) {









    }
}
