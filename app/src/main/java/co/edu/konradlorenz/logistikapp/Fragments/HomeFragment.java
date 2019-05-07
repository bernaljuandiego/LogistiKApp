package co.edu.konradlorenz.logistikapp.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.facebook.login.LoginManager;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserInfo;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;
import co.edu.konradlorenz.logistikapp.Activities.LoginActivity;
import co.edu.konradlorenz.logistikapp.R;
import de.hdodenhof.circleimageview.CircleImageView;

public class HomeFragment extends Fragment {

    private FirebaseAuth mAuth;
    private CircleImageView imagenCuenta;
    private TextView nombreCuenta;
    private TextView correoCuenta;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        traerComponentes();
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            for (UserInfo profile : user.getProviderData()) {
                nombreCuenta.setText(user.getDisplayName());
                correoCuenta.setText(profile.getEmail());
                Glide.with(this).load(profile.getPhotoUrl()).into(imagenCuenta);
            }
        } else {
            Intent intent = new Intent(getActivity(), LoginActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
        Fragment childFragment = new ListarResultadosFragment();
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        transaction.replace(R.id.contenido, childFragment).commit();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    private void traerComponentes() {
        imagenCuenta = getView().findViewById(R.id.imagenCuenta);
        nombreCuenta = getView().findViewById(R.id.nombreCuenta);
        correoCuenta = getView().findViewById(R.id.correoCuenta);
    }

}

