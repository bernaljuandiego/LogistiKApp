package co.edu.konradlorenz.logistikapp.Activities;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import co.edu.konradlorenz.logistikapp.Activities.LoginActivity;
import co.edu.konradlorenz.logistikapp.Activities.PrincipalActivity;
import co.edu.konradlorenz.logistikapp.R;

public class LostConnectionActivity extends AppCompatActivity {

    private NetworkInfo net;
    private BroadcastReceiver networkStateReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            net = manager.getActiveNetworkInfo();
        }
    };

    private void verificar(NetworkInfo ni) {
        if (ni != null) {
            if (ni.getState() == NetworkInfo.State.CONNECTED) {
                Intent i = new Intent(getApplicationContext(), PrincipalActivity.class);
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(i);
            }
        } else {
            Toast.makeText(getApplicationContext(), "No hay acceso a internet!!!", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lost_connection);
    }

    @Override
    public void onResume() {
        super.onResume();
        registerReceiver(networkStateReceiver, new IntentFilter(android.net.ConnectivityManager.CONNECTIVITY_ACTION));
    }

    @Override
    public void onPause() {
        unregisterReceiver(networkStateReceiver);
        super.onPause();
    }

    public void reintentar(View vista){
        verificar(net);
    }
}
