package co.edu.konradlorenz.logistikapp.Fragments;

import android.Manifest;
import android.app.DownloadManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.LongDef;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import co.edu.konradlorenz.logistikapp.R;

import android.os.Environment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.io.File;


public class DescargarMarcadorFragment extends Fragment {

    private String DIR_NAME = "LogistiK";

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_descargar_marcador, container, false);
    }

    @Override
    public void onResume() {
        super.onResume();

        int permissionCheck = ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.WRITE_EXTERNAL_STORAGE);

        if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
            Log.d("entro","entro");
            ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.READ_PHONE_STATE}, permissionCheck);
        } else {
            Log.d("entro","no entro");
        }

        Button boton = getActivity().findViewById(R.id.button3);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String filename = "Marcador.jpg";
                String downloadUrlOfImage = "http://www.konradlorenz.edu.co/images/banco/konrad-logo-color.jpg";
                File direct =
                        new File(Environment
                                .getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES)
                                .getAbsolutePath() + "/" + DIR_NAME + "/");


                if (!direct.exists()) {
                    direct.mkdir();
                }

                DownloadManager dm = (DownloadManager) getContext().getSystemService(Context.DOWNLOAD_SERVICE);
                Uri downloadUri = Uri.parse(downloadUrlOfImage);
                DownloadManager.Request request = new DownloadManager.Request(downloadUri);
                request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI | DownloadManager.Request.NETWORK_MOBILE)
                        .setAllowedOverRoaming(false)
                        .setTitle(filename)
                        .setMimeType("image/jpeg")
                        .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
                        .setDestinationInExternalPublicDir(Environment.DIRECTORY_PICTURES,
                                File.separator + DIR_NAME + File.separator + filename);

                dm.enqueue(request);
            }
        });

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case Manifest:
                if ((grantResults.length > 0) && (grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                    //TODO
                }
                break;

            default:
                break;
        }
    }

}
