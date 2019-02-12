package co.edu.konradlorenz.logistikapp.Fragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.ScrollView;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

import co.edu.konradlorenz.logistikapp.Entities.Estudiante;
import co.edu.konradlorenz.logistikapp.Entities.Nivel;
import co.edu.konradlorenz.logistikapp.R;


public class AgregarNivelFragment extends Fragment {


    private DatabaseReference baseDeDatos;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Agregar Nivel");
        baseDeDatos = FirebaseDatabase.getInstance().getReference("BaseDatos");
    }

    @Override
    public void onResume() {
        super.onResume();
        StartAnimations();
        final Button registrar = (Button) getView().findViewById(R.id.botonRegistro);

        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText nombreNivel = (EditText) getView().findViewById(R.id.nombreNivel);
                String nombreNivelString = nombreNivel.getText().toString();
                EditText descNivel = (EditText) getView().findViewById(R.id.descripcionNivel);
                String descNivelString = descNivel.getText().toString();
                ArrayList<Integer> cajasSeleccionadas = obtenerCajasSeleccionadas();
                if (!TextUtils.isEmpty(nombreNivelString) && !TextUtils.isEmpty(descNivelString)) {
                    if (cajasSeleccionadas.isEmpty()) {
                        Toast.makeText(getContext(), "Seleccione por lo menos una caja", Toast.LENGTH_LONG).show();
                    } else {
                        Nivel nivelNuevo = new Nivel(nombreNivelString, cajasSeleccionadas, descNivelString);
                        baseDeDatos.child("Niveles").child(nombreNivelString).setValue(nivelNuevo);
                        Toast.makeText(getContext(), "Nivel Registrado!", Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(getContext(), "llenar los campos ", Toast.LENGTH_LONG).show();
                }
            }
        });


        final Button mostrar = (Button) getView().findViewById(R.id.mostrar);
        mostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HorizontalScrollView tablaCajas = (HorizontalScrollView) getView().findViewById(R.id.tablaCajas);
                tablaCajas.setVisibility(View.VISIBLE);
                registrar.setVisibility(View.VISIBLE);
                mostrar.setVisibility(View.GONE);
            }
        });
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_agregar_nivel, container, false);
    }

    private void StartAnimations() {
        Animation anim = AnimationUtils.loadAnimation(getContext(), R.anim.translate);
        anim.reset();
        CardView l = (CardView) getView().findViewById(R.id.card);
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

    private ArrayList<Integer> obtenerCajasSeleccionadas() {
        CheckBox caja1 = (CheckBox) getView().findViewById(R.id.checkBox1);
        CheckBox caja2 = (CheckBox) getView().findViewById(R.id.checkBox2);
        CheckBox caja3 = (CheckBox) getView().findViewById(R.id.checkBox3);
        CheckBox caja4 = (CheckBox) getView().findViewById(R.id.checkBox4);
        CheckBox caja5 = (CheckBox) getView().findViewById(R.id.checkBox5);
        CheckBox caja6 = (CheckBox) getView().findViewById(R.id.checkBox6);
        CheckBox caja7 = (CheckBox) getView().findViewById(R.id.checkBox7);
        CheckBox caja8 = (CheckBox) getView().findViewById(R.id.checkBox8);
        CheckBox caja9 = (CheckBox) getView().findViewById(R.id.checkBox9);
        CheckBox caja10 = (CheckBox) getView().findViewById(R.id.checkBox10);
        CheckBox caja11 = (CheckBox) getView().findViewById(R.id.checkBox11);
        CheckBox caja12 = (CheckBox) getView().findViewById(R.id.checkBox12);
        CheckBox caja13 = (CheckBox) getView().findViewById(R.id.checkBox13);
        CheckBox caja14 = (CheckBox) getView().findViewById(R.id.checkBox14);
        CheckBox caja15 = (CheckBox) getView().findViewById(R.id.checkBox15);
        CheckBox caja16 = (CheckBox) getView().findViewById(R.id.checkBox16);
        CheckBox caja17 = (CheckBox) getView().findViewById(R.id.checkBox17);
        CheckBox caja18 = (CheckBox) getView().findViewById(R.id.checkBox18);
        CheckBox caja19 = (CheckBox) getView().findViewById(R.id.checkBox19);
        CheckBox caja20 = (CheckBox) getView().findViewById(R.id.checkBox20);
        CheckBox caja21 = (CheckBox) getView().findViewById(R.id.checkBox21);
        CheckBox caja22 = (CheckBox) getView().findViewById(R.id.checkBox22);
        CheckBox caja23 = (CheckBox) getView().findViewById(R.id.checkBox23);
        CheckBox caja24 = (CheckBox) getView().findViewById(R.id.checkBox24);
        CheckBox caja25 = (CheckBox) getView().findViewById(R.id.checkBox25);
        CheckBox caja26 = (CheckBox) getView().findViewById(R.id.checkBox26);
        CheckBox caja27 = (CheckBox) getView().findViewById(R.id.checkBox27);
        CheckBox caja28 = (CheckBox) getView().findViewById(R.id.checkBox28);
        CheckBox caja29 = (CheckBox) getView().findViewById(R.id.checkBox29);
        CheckBox caja30 = (CheckBox) getView().findViewById(R.id.checkBox30);
        CheckBox caja31 = (CheckBox) getView().findViewById(R.id.checkBox31);
        CheckBox caja32 = (CheckBox) getView().findViewById(R.id.checkBox32);
        CheckBox caja33 = (CheckBox) getView().findViewById(R.id.checkBox33);
        CheckBox caja34 = (CheckBox) getView().findViewById(R.id.checkBox34);
        CheckBox caja35 = (CheckBox) getView().findViewById(R.id.checkBox35);
        CheckBox caja36 = (CheckBox) getView().findViewById(R.id.checkBox36);
        CheckBox caja37 = (CheckBox) getView().findViewById(R.id.checkBox37);
        CheckBox caja38 = (CheckBox) getView().findViewById(R.id.checkBox38);
        CheckBox caja39 = (CheckBox) getView().findViewById(R.id.checkBox39);
        CheckBox caja40 = (CheckBox) getView().findViewById(R.id.checkBox40);
        CheckBox caja41 = (CheckBox) getView().findViewById(R.id.checkBox41);
        CheckBox caja42 = (CheckBox) getView().findViewById(R.id.checkBox42);
        CheckBox caja43 = (CheckBox) getView().findViewById(R.id.checkBox43);
        CheckBox caja44 = (CheckBox) getView().findViewById(R.id.checkBox44);
        CheckBox caja45 = (CheckBox) getView().findViewById(R.id.checkBox45);
        CheckBox caja46 = (CheckBox) getView().findViewById(R.id.checkBox46);
        CheckBox caja47 = (CheckBox) getView().findViewById(R.id.checkBox47);
        CheckBox caja48 = (CheckBox) getView().findViewById(R.id.checkBox48);
        CheckBox caja49 = (CheckBox) getView().findViewById(R.id.checkBox49);
        CheckBox caja50 = (CheckBox) getView().findViewById(R.id.checkBox50);
        CheckBox caja51 = (CheckBox) getView().findViewById(R.id.checkBox51);
        CheckBox caja52 = (CheckBox) getView().findViewById(R.id.checkBox52);
        CheckBox caja53 = (CheckBox) getView().findViewById(R.id.checkBox53);
        CheckBox caja54 = (CheckBox) getView().findViewById(R.id.checkBox54);
        CheckBox caja55 = (CheckBox) getView().findViewById(R.id.checkBox55);
        CheckBox caja56 = (CheckBox) getView().findViewById(R.id.checkBox56);
        CheckBox caja57 = (CheckBox) getView().findViewById(R.id.checkBox57);
        CheckBox caja58 = (CheckBox) getView().findViewById(R.id.checkBox58);
        CheckBox caja59 = (CheckBox) getView().findViewById(R.id.checkBox59);
        CheckBox caja60 = (CheckBox) getView().findViewById(R.id.checkBox60);
        CheckBox caja61 = (CheckBox) getView().findViewById(R.id.checkBox61);
        CheckBox caja62 = (CheckBox) getView().findViewById(R.id.checkBox62);
        CheckBox caja63 = (CheckBox) getView().findViewById(R.id.checkBox63);
        CheckBox caja64 = (CheckBox) getView().findViewById(R.id.checkBox64);
        CheckBox caja65 = (CheckBox) getView().findViewById(R.id.checkBox65);
        CheckBox caja66 = (CheckBox) getView().findViewById(R.id.checkBox66);
        CheckBox caja67 = (CheckBox) getView().findViewById(R.id.checkBox67);
        CheckBox caja68 = (CheckBox) getView().findViewById(R.id.checkBox68);
        CheckBox caja69 = (CheckBox) getView().findViewById(R.id.checkBox69);
        CheckBox caja70 = (CheckBox) getView().findViewById(R.id.checkBox70);
        CheckBox caja71 = (CheckBox) getView().findViewById(R.id.checkBox71);
        CheckBox caja72 = (CheckBox) getView().findViewById(R.id.checkBox72);
        CheckBox caja73 = (CheckBox) getView().findViewById(R.id.checkBox73);
        CheckBox caja74 = (CheckBox) getView().findViewById(R.id.checkBox74);
        CheckBox caja75 = (CheckBox) getView().findViewById(R.id.checkBox75);
        CheckBox caja76 = (CheckBox) getView().findViewById(R.id.checkBox76);
        CheckBox caja77 = (CheckBox) getView().findViewById(R.id.checkBox77);
        CheckBox caja78 = (CheckBox) getView().findViewById(R.id.checkBox78);
        CheckBox caja79 = (CheckBox) getView().findViewById(R.id.checkBox79);
        CheckBox caja80 = (CheckBox) getView().findViewById(R.id.checkBox80);
        CheckBox caja81 = (CheckBox) getView().findViewById(R.id.checkBox81);
        CheckBox caja82 = (CheckBox) getView().findViewById(R.id.checkBox82);
        CheckBox caja83 = (CheckBox) getView().findViewById(R.id.checkBox83);
        CheckBox caja84 = (CheckBox) getView().findViewById(R.id.checkBox84);
        CheckBox caja85 = (CheckBox) getView().findViewById(R.id.checkBox85);
        CheckBox caja86 = (CheckBox) getView().findViewById(R.id.checkBox86);
        CheckBox caja87 = (CheckBox) getView().findViewById(R.id.checkBox87);
        CheckBox caja88 = (CheckBox) getView().findViewById(R.id.checkBox88);
        CheckBox caja89 = (CheckBox) getView().findViewById(R.id.checkBox89);
        CheckBox caja90 = (CheckBox) getView().findViewById(R.id.checkBox90);
        CheckBox caja91 = (CheckBox) getView().findViewById(R.id.checkBox91);
        CheckBox caja92 = (CheckBox) getView().findViewById(R.id.checkBox92);
        CheckBox caja93 = (CheckBox) getView().findViewById(R.id.checkBox93);
        CheckBox caja94 = (CheckBox) getView().findViewById(R.id.checkBox94);
        CheckBox caja95 = (CheckBox) getView().findViewById(R.id.checkBox95);
        CheckBox caja96 = (CheckBox) getView().findViewById(R.id.checkBox96);
        CheckBox caja97 = (CheckBox) getView().findViewById(R.id.checkBox97);
        CheckBox caja98 = (CheckBox) getView().findViewById(R.id.checkBox98);
        CheckBox caja99 = (CheckBox) getView().findViewById(R.id.checkBox99);
        CheckBox caja100 = (CheckBox) getView().findViewById(R.id.checkBox100);
        CheckBox caja101 = (CheckBox) getView().findViewById(R.id.checkBox101);
        CheckBox caja102 = (CheckBox) getView().findViewById(R.id.checkBox102);
        CheckBox caja103 = (CheckBox) getView().findViewById(R.id.checkBox103);
        CheckBox caja104 = (CheckBox) getView().findViewById(R.id.checkBox104);
        CheckBox caja105 = (CheckBox) getView().findViewById(R.id.checkBox105);
        CheckBox caja106 = (CheckBox) getView().findViewById(R.id.checkBox106);
        CheckBox caja107 = (CheckBox) getView().findViewById(R.id.checkBox107);
        CheckBox caja108 = (CheckBox) getView().findViewById(R.id.checkBox108);
        CheckBox caja109 = (CheckBox) getView().findViewById(R.id.checkBox109);
        CheckBox caja110 = (CheckBox) getView().findViewById(R.id.checkBox110);
        CheckBox caja111 = (CheckBox) getView().findViewById(R.id.checkBox111);
        CheckBox caja112 = (CheckBox) getView().findViewById(R.id.checkBox112);
        CheckBox caja113 = (CheckBox) getView().findViewById(R.id.checkBox113);
        CheckBox caja114 = (CheckBox) getView().findViewById(R.id.checkBox114);
        CheckBox caja115 = (CheckBox) getView().findViewById(R.id.checkBox115);
        CheckBox caja116 = (CheckBox) getView().findViewById(R.id.checkBox116);
        CheckBox caja117 = (CheckBox) getView().findViewById(R.id.checkBox117);
        CheckBox caja118 = (CheckBox) getView().findViewById(R.id.checkBox118);
        CheckBox caja119 = (CheckBox) getView().findViewById(R.id.checkBox119);
        CheckBox caja120 = (CheckBox) getView().findViewById(R.id.checkBox120);
        CheckBox caja121 = (CheckBox) getView().findViewById(R.id.checkBox121);
        CheckBox caja122 = (CheckBox) getView().findViewById(R.id.checkBox122);
        CheckBox caja123 = (CheckBox) getView().findViewById(R.id.checkBox123);
        CheckBox caja124 = (CheckBox) getView().findViewById(R.id.checkBox124);
        CheckBox caja125 = (CheckBox) getView().findViewById(R.id.checkBox125);
        CheckBox caja126 = (CheckBox) getView().findViewById(R.id.checkBox126);
        CheckBox caja127 = (CheckBox) getView().findViewById(R.id.checkBox127);
        CheckBox caja128 = (CheckBox) getView().findViewById(R.id.checkBox128);
        CheckBox caja129 = (CheckBox) getView().findViewById(R.id.checkBox129);
        CheckBox caja130 = (CheckBox) getView().findViewById(R.id.checkBox130);
        CheckBox caja131 = (CheckBox) getView().findViewById(R.id.checkBox131);

        ArrayList<CheckBox> cajas = new ArrayList<>();
        cajas.add(caja1);
        cajas.add(caja2);
        cajas.add(caja3);
        cajas.add(caja4);
        cajas.add(caja5);
        cajas.add(caja6);
        cajas.add(caja7);
        cajas.add(caja8);
        cajas.add(caja9);
        cajas.add(caja10);
        cajas.add(caja11);
        cajas.add(caja12);
        cajas.add(caja13);
        cajas.add(caja14);
        cajas.add(caja15);
        cajas.add(caja16);
        cajas.add(caja17);
        cajas.add(caja18);
        cajas.add(caja19);
        cajas.add(caja20);
        cajas.add(caja21);
        cajas.add(caja22);
        cajas.add(caja23);
        cajas.add(caja24);
        cajas.add(caja25);
        cajas.add(caja26);
        cajas.add(caja27);
        cajas.add(caja28);
        cajas.add(caja29);
        cajas.add(caja30);
        cajas.add(caja31);
        cajas.add(caja32);
        cajas.add(caja33);
        cajas.add(caja34);
        cajas.add(caja35);
        cajas.add(caja36);
        cajas.add(caja37);
        cajas.add(caja38);
        cajas.add(caja39);
        cajas.add(caja40);
        cajas.add(caja41);
        cajas.add(caja42);
        cajas.add(caja43);
        cajas.add(caja44);
        cajas.add(caja45);
        cajas.add(caja46);
        cajas.add(caja47);
        cajas.add(caja48);
        cajas.add(caja49);
        cajas.add(caja50);
        cajas.add(caja51);
        cajas.add(caja52);
        cajas.add(caja53);
        cajas.add(caja54);
        cajas.add(caja55);
        cajas.add(caja56);
        cajas.add(caja57);
        cajas.add(caja58);
        cajas.add(caja59);
        cajas.add(caja60);
        cajas.add(caja61);
        cajas.add(caja62);
        cajas.add(caja63);
        cajas.add(caja64);
        cajas.add(caja65);
        cajas.add(caja66);
        cajas.add(caja67);
        cajas.add(caja68);
        cajas.add(caja69);
        cajas.add(caja70);
        cajas.add(caja71);
        cajas.add(caja72);
        cajas.add(caja73);
        cajas.add(caja74);
        cajas.add(caja75);
        cajas.add(caja76);
        cajas.add(caja77);
        cajas.add(caja78);
        cajas.add(caja79);
        cajas.add(caja80);
        cajas.add(caja81);
        cajas.add(caja82);
        cajas.add(caja83);
        cajas.add(caja84);
        cajas.add(caja85);
        cajas.add(caja86);
        cajas.add(caja87);
        cajas.add(caja88);
        cajas.add(caja89);
        cajas.add(caja90);
        cajas.add(caja91);
        cajas.add(caja92);
        cajas.add(caja93);
        cajas.add(caja94);
        cajas.add(caja95);
        cajas.add(caja96);
        cajas.add(caja97);
        cajas.add(caja98);
        cajas.add(caja99);
        cajas.add(caja100);
        cajas.add(caja101);
        cajas.add(caja102);
        cajas.add(caja103);
        cajas.add(caja104);
        cajas.add(caja105);
        cajas.add(caja106);
        cajas.add(caja107);
        cajas.add(caja108);
        cajas.add(caja109);
        cajas.add(caja110);
        cajas.add(caja111);
        cajas.add(caja112);
        cajas.add(caja113);
        cajas.add(caja114);
        cajas.add(caja115);
        cajas.add(caja116);
        cajas.add(caja117);
        cajas.add(caja118);
        cajas.add(caja119);
        cajas.add(caja120);
        cajas.add(caja121);
        cajas.add(caja122);
        cajas.add(caja123);
        cajas.add(caja124);
        cajas.add(caja125);
        cajas.add(caja126);
        cajas.add(caja127);
        cajas.add(caja128);
        cajas.add(caja129);
        cajas.add(caja130);
        cajas.add(caja131);
        ArrayList<Integer> cajasSeleccionadas = new ArrayList<>();
        for (CheckBox checkBox : cajas) {
            if (checkBox.isChecked()) {
                cajasSeleccionadas.add(cajas.indexOf(checkBox));
            }
        }
        return cajasSeleccionadas;
    }
}
