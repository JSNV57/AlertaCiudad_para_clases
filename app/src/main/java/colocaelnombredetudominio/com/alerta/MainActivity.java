package colocaelnombredetudominio.com.alerta;
import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
public class MainActivity extends AppCompatActivity {
    //primeros cambios
    private MainActivityFragment mainActivityFragment;
    final private int ASK_MULTIPLE_PERMISSION_REQUEST_CODE = 124;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        permisos();
        //setContentView(R.layout.activity_main);
        //PASAR EL CONTROL AL FRAGMENTO
        if (savedInstanceState==null)
        {
            mainActivityFragment=new MainActivityFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .add(android.R.id.content,mainActivityFragment)
                .commit();
        }
        else
            mainActivityFragment=(MainActivityFragment)
                    getSupportFragmentManager()
                    .findFragmentById(android.R.id.content);
    }


    protected void permisos() {

        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED &&
                ContextCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE) == PackageManager.PERMISSION_GRANTED &&
                ContextCompat.checkSelfPermission(this, Manifest.permission.INTERNET) == PackageManager.PERMISSION_GRANTED &&
                ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED  &&
                ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_NETWORK_STATE) == PackageManager.PERMISSION_GRANTED &&
                ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS) == PackageManager.PERMISSION_GRANTED) {

        } else {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(new String[]{
                                Manifest.permission.INTERNET,
                                Manifest.permission.ACCESS_FINE_LOCATION,
                                Manifest.permission.READ_PHONE_STATE,
                                Manifest.permission.ACCESS_COARSE_LOCATION,
                                Manifest.permission.ACCESS_NETWORK_STATE,
                                Manifest.permission.SEND_SMS},
                        ASK_MULTIPLE_PERMISSION_REQUEST_CODE);
            }
        }
    }

}
