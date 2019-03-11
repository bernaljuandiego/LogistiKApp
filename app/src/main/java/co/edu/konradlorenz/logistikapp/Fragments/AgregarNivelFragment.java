package co.edu.konradlorenz.logistikapp.Fragments;


import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.snackbar.Snackbar;
import androidx.fragment.app.Fragment;
import androidx.cardview.widget.CardView;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

import co.edu.konradlorenz.logistikapp.Entities.Nivel;
import co.edu.konradlorenz.logistikapp.R;


public class AgregarNivelFragment extends Fragment {


    private DatabaseReference baseDeDatos;
    private ArrayList<CheckBox> todosCheckBox;
    private Button registrar;
    private Button mostrar;
    private Button eliminar;
    private HorizontalScrollView tablaCajas;
    private EditText descNivel;
    private EditText nombreNivel;
    private TextWatcher nombreNivelListener;
    private TextView titulo;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Agregar Nivel");
        baseDeDatos = FirebaseDatabase.getInstance().getReference("BaseDatos");
        obtenerComponentes();
    }

    private void obtenerComponentes() {
        titulo = (TextView) getView().findViewById(R.id.titulo);
        nombreNivel = (EditText) getView().findViewById(R.id.nombreNivel);
        descNivel = (EditText) getView().findViewById(R.id.descripcionNivel);
        tablaCajas = (HorizontalScrollView) getView().findViewById(R.id.tablaCajas);
        registrar = (Button) getView().findViewById(R.id.botonRegistro);
        mostrar = (Button) getView().findViewById(R.id.mostrar);
        eliminar = (Button) getView().findViewById(R.id.eliminar);
        todosCheckBox = new ArrayList<>();
        llenarArregloCheckBox();
    }

    private void llenarArregloCheckBox() {
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
        todosCheckBox.add(caja1);
        todosCheckBox.add(caja2);
        todosCheckBox.add(caja3);
        todosCheckBox.add(caja4);
        todosCheckBox.add(caja5);
        todosCheckBox.add(caja6);
        todosCheckBox.add(caja7);
        todosCheckBox.add(caja8);
        todosCheckBox.add(caja9);
        todosCheckBox.add(caja10);
        todosCheckBox.add(caja11);
        todosCheckBox.add(caja12);
        todosCheckBox.add(caja13);
        todosCheckBox.add(caja14);
        todosCheckBox.add(caja15);
        todosCheckBox.add(caja16);
        todosCheckBox.add(caja17);
        todosCheckBox.add(caja18);
        todosCheckBox.add(caja19);
        todosCheckBox.add(caja20);
        todosCheckBox.add(caja21);
        todosCheckBox.add(caja22);
        todosCheckBox.add(caja23);
        todosCheckBox.add(caja24);
        todosCheckBox.add(caja25);
        todosCheckBox.add(caja26);
        todosCheckBox.add(caja27);
        todosCheckBox.add(caja28);
        todosCheckBox.add(caja29);
        todosCheckBox.add(caja30);
        todosCheckBox.add(caja31);
        todosCheckBox.add(caja32);
        todosCheckBox.add(caja33);
        todosCheckBox.add(caja34);
        todosCheckBox.add(caja35);
        todosCheckBox.add(caja36);
        todosCheckBox.add(caja37);
        todosCheckBox.add(caja38);
        todosCheckBox.add(caja39);
        todosCheckBox.add(caja40);
        todosCheckBox.add(caja41);
        todosCheckBox.add(caja42);
        todosCheckBox.add(caja43);
        todosCheckBox.add(caja44);
        todosCheckBox.add(caja45);
        todosCheckBox.add(caja46);
        todosCheckBox.add(caja47);
        todosCheckBox.add(caja48);
        todosCheckBox.add(caja49);
        todosCheckBox.add(caja50);
        todosCheckBox.add(caja51);
        todosCheckBox.add(caja52);
        todosCheckBox.add(caja53);
        todosCheckBox.add(caja54);
        todosCheckBox.add(caja55);
        todosCheckBox.add(caja56);
        todosCheckBox.add(caja57);
        todosCheckBox.add(caja58);
        todosCheckBox.add(caja59);
        todosCheckBox.add(caja60);
        todosCheckBox.add(caja61);
        todosCheckBox.add(caja62);
        todosCheckBox.add(caja63);
        todosCheckBox.add(caja64);
        todosCheckBox.add(caja65);
        todosCheckBox.add(caja66);
        todosCheckBox.add(caja67);
        todosCheckBox.add(caja68);
        todosCheckBox.add(caja69);
        todosCheckBox.add(caja70);
        todosCheckBox.add(caja71);
        todosCheckBox.add(caja72);
        todosCheckBox.add(caja73);
        todosCheckBox.add(caja74);
        todosCheckBox.add(caja75);
        todosCheckBox.add(caja76);
        todosCheckBox.add(caja77);
        todosCheckBox.add(caja78);
        todosCheckBox.add(caja79);
        todosCheckBox.add(caja80);
        todosCheckBox.add(caja81);
        todosCheckBox.add(caja82);
        todosCheckBox.add(caja83);
        todosCheckBox.add(caja84);
        todosCheckBox.add(caja85);
        todosCheckBox.add(caja86);
        todosCheckBox.add(caja87);
        todosCheckBox.add(caja88);
        todosCheckBox.add(caja89);
        todosCheckBox.add(caja90);
        todosCheckBox.add(caja91);
        todosCheckBox.add(caja92);
        todosCheckBox.add(caja93);
        todosCheckBox.add(caja94);
        todosCheckBox.add(caja95);
        todosCheckBox.add(caja96);
        todosCheckBox.add(caja97);
        todosCheckBox.add(caja98);
        todosCheckBox.add(caja99);
        todosCheckBox.add(caja100);
        todosCheckBox.add(caja101);
        todosCheckBox.add(caja102);
        todosCheckBox.add(caja103);
        todosCheckBox.add(caja104);
        todosCheckBox.add(caja105);
        todosCheckBox.add(caja106);
        todosCheckBox.add(caja107);
        todosCheckBox.add(caja108);
        todosCheckBox.add(caja109);
        todosCheckBox.add(caja110);
        todosCheckBox.add(caja111);
        todosCheckBox.add(caja112);
        todosCheckBox.add(caja113);
        todosCheckBox.add(caja114);
        todosCheckBox.add(caja115);
        todosCheckBox.add(caja116);
        todosCheckBox.add(caja117);
        todosCheckBox.add(caja118);
        todosCheckBox.add(caja119);
        todosCheckBox.add(caja120);
        todosCheckBox.add(caja121);
        todosCheckBox.add(caja122);
        todosCheckBox.add(caja123);
        todosCheckBox.add(caja124);
        todosCheckBox.add(caja125);
        todosCheckBox.add(caja126);
        todosCheckBox.add(caja127);
        todosCheckBox.add(caja128);
        todosCheckBox.add(caja129);
        todosCheckBox.add(caja130);
        todosCheckBox.add(caja131);
    }

    private void agregarLiseners() {
        eliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                baseDeDatos.child("Niveles").child(nombreNivel.getText().toString()).removeValue().addOnCompleteListener(
                        new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                nombreNivel.setText("");
                                Snackbar.make(getView(), "Nivel Eliminado satisfactoriamente!", Snackbar.LENGTH_LONG).show();
                            }

                        }
                ).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Snackbar.make(getView(), "No se ha podido eliminar el nivel!", Snackbar.LENGTH_LONG).show();
                    }
                });
            }
        });


        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombreNivelString = nombreNivel.getText().toString();
                String descNivelString = descNivel.getText().toString();
                ArrayList<Integer> cajasSeleccionadas = obtenerCajasSeleccionadas();
                if (!TextUtils.isEmpty(nombreNivelString) && !TextUtils.isEmpty(descNivelString)) {
                    if (cajasSeleccionadas.isEmpty()) {
                        Snackbar.make(getView(), "Seleccione por lo menos una caja!", Snackbar.LENGTH_LONG).show();
                    } else {
                        Nivel nivelNuevo = new Nivel(nombreNivelString, cajasSeleccionadas, descNivelString);
                        baseDeDatos.child("Niveles").child(nombreNivelString).setValue(nivelNuevo).addOnCompleteListener(
                                new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        nombreNivel.setText("");
                                        Snackbar.make(getView(), "Nivel Agregado satisfactoriamente!", Snackbar.LENGTH_LONG).show();
                                    }

                                }
                        ).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Snackbar.make(getView(), "No se ha podido completar la acción!", Snackbar.LENGTH_LONG).show();
                            }
                        });
                    }
                } else {
                    descNivel.setError("Campo Requerido");
                }

            }
        });

        mostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tablaCajas.setVisibility(View.VISIBLE);
                registrar.setVisibility(View.VISIBLE);
                mostrar.setVisibility(View.GONE);
            }
        });

        nombreNivelListener = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                vaciarCampos();
                String nivel = nombreNivel.getText().toString();
                baseDeDatos.child("Niveles").orderByChild("nombre")
                        .equalTo(nivel)
                        .limitToFirst(1)
                        .addChildEventListener(new ChildEventListener() {
                            @Override
                            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                                final Nivel nivel = dataSnapshot.getValue(Nivel.class);
                                actualizarCampos(nivel);
                            }

                            @Override
                            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                            }

                            @Override
                            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

                            }

                            @Override
                            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError databaseError) {

                            }
                        });

            }
        };

        nombreNivel.addTextChangedListener(nombreNivelListener);
    }

    private void actualizarCampos(Nivel nivel) {
        titulo.setText("Edición de nivel");
        mostrar.setText("Editar Cajas");
        descNivel.setText(nivel.getDescripcion());
        for (CheckBox checkBox : todosCheckBox) {
            checkBox.setChecked(false);
        }
        for (Integer integer : nivel.getCajas()) {
            todosCheckBox.get(integer).setChecked(true);
        }
        registrar.setVisibility(View.VISIBLE);
        mostrar.setVisibility(View.VISIBLE);
        eliminar.setVisibility(View.VISIBLE);
    }

    private void vaciarCampos() {
        titulo.setText("Registro de niveles");
        mostrar.setText("Seleccionar Cajas");
        descNivel.setText("");
        for (CheckBox checkBox : todosCheckBox) {
            checkBox.setChecked(false);
        }
        tablaCajas.setVisibility(View.GONE);
        registrar.setVisibility(View.GONE);
        eliminar.setVisibility(View.GONE);
        mostrar.setVisibility(View.VISIBLE);
    }


    @Override
    public void onResume() {
        super.onResume();
        StartAnimations();
        agregarLiseners();
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
        ArrayList<Integer> cajas = new ArrayList<>();
        for (CheckBox checkBox : todosCheckBox) {
            if (checkBox.isChecked()) {
                cajas.add(todosCheckBox.indexOf(checkBox));
            }
        }
        return cajas;
    }
}
