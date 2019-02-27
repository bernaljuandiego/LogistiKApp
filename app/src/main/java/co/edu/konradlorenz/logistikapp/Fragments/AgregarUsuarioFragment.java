package co.edu.konradlorenz.logistikapp.Fragments;

import android.os.Bundle;
import com.google.android.material.snackbar.Snackbar;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import android.widget.Button;
import android.text.Editable;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.EditText;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import androidx.fragment.app.Fragment;
import android.view.animation.Animation;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.annotation.Nullable;
import android.view.animation.AnimationUtils;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ChildEventListener;

import co.edu.konradlorenz.logistikapp.Entities.Estudiante;
import co.edu.konradlorenz.logistikapp.R;

public class AgregarUsuarioFragment extends Fragment {

    private TextView titulo;
    private Button botonRegistro;
    private EditText nombreRegistro;
    private EditText codigoRegistro;
    private EditText correoRegistro;
    private EditText contraseñaRegistro;
    private EditText contraseña2Registro;
    private String nombreRegistroAux;
    private String correoRegistroAux;
    private EditText apellidoRegistro;
    private String apellidoRegistroAux;
    private DatabaseReference baseDeDatos;
    private TextWatcher lisenerCodigo;
    private FirebaseAuth mAuth;

    public void registrarEstudiante() {
        try {
            int codigo = Integer.parseInt(codigoRegistro.getText().toString());
            String nombre = nombreRegistro.getText().toString();
            String apellido = apellidoRegistro.getText().toString();
            String correo = correoRegistro.getText().toString();
            String contraseña1 = contraseñaRegistro.getText().toString();
            String contraseña2 = contraseña2Registro.getText().toString();
            //registro Estudiante
            if (!TextUtils.isEmpty(nombre) && !TextUtils.isEmpty(apellido) && !TextUtils.isEmpty(correo)  && !TextUtils.isEmpty(contraseña1)  && !TextUtils.isEmpty(contraseña2)) {
                Log.e("contraseña", contraseña1 +" - "+contraseña2);
                if (contraseña1.equals(contraseña2)){
                    Estudiante nuevoRegistro = new Estudiante(codigo, nombre, apellido, correo);
                    registrarUsuarioFirebase(correo, contraseña1);
                    baseDeDatos.child("Estudiante").child(Integer.toString(codigo)).setValue(nuevoRegistro);
                    Toast.makeText(getContext(), "Registrado!", Toast.LENGTH_LONG).show();
                    vaciarCampos();
                } else {
                    contraseñaRegistro.setError("Las contraseñas deben coincidir");
                    contraseñaRegistro.setText("");
                    contraseña2Registro.setText("");
                }

            }
        } catch (NumberFormatException ex) {
            Toast.makeText(getContext(), "llenar los campos ", Toast.LENGTH_LONG).show();
        }
    }

    private void registrarUsuarioFirebase(String email, String password){
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Snackbar.make(getView(), "Usuario Agregado", Snackbar.LENGTH_LONG).show();
                        } else {
                            Snackbar.make(getView(), "No se pudo completar la acción", Snackbar.LENGTH_LONG).show();
                        }
                    }
                });
    }

    private void lisenerCodigo() {
        botonRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registrarEstudiante();
            }
        });

        lisenerCodigo = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                try {
                    int codigo = Integer.parseInt(codigoRegistro.getText().toString());
                    baseDeDatos.child("Estudiante").orderByChild("codigo")
                            .equalTo(codigo)
                            .limitToFirst(1)
                            .addChildEventListener(new ChildEventListener() {
                                @Override
                                public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                                    final Estudiante estudiante = dataSnapshot.getValue(Estudiante.class);
                                    actualizarCampos(estudiante);
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
                } catch (NumberFormatException ex) {
                    dejarComoEstabanCampos();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {}
        };

        codigoRegistro.addTextChangedListener(lisenerCodigo);
    }

    private void instanciasComponentes() {
        nombreRegistroAux = "";
        apellidoRegistroAux = "";
        correoRegistroAux = "";
    }

    private void obtenerComponentes() {
        titulo = (TextView) getView().findViewById(R.id.titulo);
        nombreRegistro = (EditText) getView().findViewById(R.id.nombreRegistro);
        apellidoRegistro = (EditText) getView().findViewById(R.id.apellidoRegistro);
        codigoRegistro = (EditText) getView().findViewById(R.id.codigoRegistro);
        correoRegistro = (EditText) getView().findViewById(R.id.correoRegistro);
        contraseñaRegistro = (EditText) getView().findViewById(R.id.contraseñaRegistro);
        contraseña2Registro = (EditText) getView().findViewById(R.id.contraseña2Registro);
        botonRegistro = (Button) getView().findViewById(R.id.botonRegistro);
    }

    private void actualizarCampos(Estudiante estudiante) {
        titulo.setText("Edición de estudiante");
        botonRegistro.setText("EDITAR!");
        botonRegistro.setVisibility(View.VISIBLE);

        nombreRegistroAux = nombreRegistro.getText().toString();
        apellidoRegistroAux = apellidoRegistro.getText().toString();
        correoRegistroAux = correoRegistro.getText().toString();

        nombreRegistro.setText(estudiante.getNombre());
        apellidoRegistro.setText(estudiante.getApellido());
        correoRegistro.setText(estudiante.getCorreo());
    }

    private void dejarComoEstabanCampos() {
        botonRegistro.setText("REGISTRAR!");
        titulo.setText("Registro de estudiante");
        botonRegistro.setVisibility(View.VISIBLE);
        nombreRegistro.setText(nombreRegistroAux);
        apellidoRegistro.setText(apellidoRegistroAux);
        correoRegistro.setText(correoRegistroAux);
    }

    private void vaciarCampos() {
        titulo.setText("Registro de estudiante");
        nombreRegistro.setText("");
        apellidoRegistro.setText("");
        codigoRegistro.setText("");
        correoRegistro.setText("");
    }

    private void StartAnimations() {
        Animation anim = AnimationUtils.loadAnimation(getContext(), R.anim.alpha);
        anim = AnimationUtils.loadAnimation(getContext(), R.anim.translate);
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

    @Override
    public void onResume() {
        StartAnimations();
        super.onResume();
        lisenerCodigo();
    }

    @Override
    public void onPause() {
        super.onPause();
        codigoRegistro.removeTextChangedListener(lisenerCodigo);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Agregar Estudiante");
        baseDeDatos = FirebaseDatabase.getInstance().getReference("BaseDatos");
        mAuth = FirebaseAuth.getInstance();
        obtenerComponentes();
        instanciasComponentes();
        lisenerCodigo();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_agregar_usuario, container, false);
    }

}
