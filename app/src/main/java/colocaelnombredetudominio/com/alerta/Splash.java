package colocaelnombredetudominio.com.alerta;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

/*
EL SPLASH ES UNA CLASE QUE LANZARA UNA PANTALLA UNOS SEGUNDO LUEGO
MOSTRARA LA PANTALLA PRINCIPAL
 */
public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //OCULTAMOS EL TITULO
        getSupportActionBar().hide();
        setContentView(R.layout.activity_splash);
    }
    //implementamos el metodo que se ejecutara luego del constructor

    @Override
    protected void onStart() {
        super.onStart();
        //un reloj
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                //llamar a otra actividad que mostrara su interfaz(llamar a MainActivity)
                Intent intent=new Intent(Splash.this,Login.class);
                startActivity(intent);
                //cerrar Splash y su interfaz
                finish();
            }
        },6000); //6 segundos de espera hasta la segunda pantalla de MainActivity
    }


}
