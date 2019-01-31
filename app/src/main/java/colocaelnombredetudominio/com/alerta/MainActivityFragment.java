package colocaelnombredetudominio.com.alerta;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TabHost;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainActivityFragment extends Fragment {
private TabHost tabHost;
private ImageButton sosmensaje;

    public MainActivityFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view =inflater.inflate(R.layout.fragment_main_activity, container, false);
        //CONFIGURAR Tabhost
        tabHost=(TabHost) view.findViewById(R.id.tabHost);
        tabHost.setup();
        //PRIMERA PESTAÑA
        TabHost.TabSpec spec = tabHost.newTabSpec("tab1");
        spec.setContent(R.id.tab1);
        spec.setIndicator("Alerta Voz");
        tabHost.addTab(spec);
        //SEGUNDA PESTAÑA
        TabHost.TabSpec spec1 = tabHost.newTabSpec("tab2");
        spec1.setContent(R.id.tab2);
        spec1.setIndicator("Alerta MSM");
        tabHost.addTab(spec1);
        //TERCERA PESTAÑA
        TabHost.TabSpec spec2 = tabHost.newTabSpec("tab3");
        spec2.setContent(R.id.tab3);
        spec2.setIndicator("Alerta FOTOGRAFIA");
        tabHost.addTab(spec2);
        //CUARTA PESTAÑA
        TabHost.TabSpec spec3 = tabHost.newTabSpec("tab4");
        spec3.setContent(R.id.tab4);
        spec3.setIndicator("CONFIGURACION");
        tabHost.addTab(spec3);

        sosmensaje = (ImageButton) view.findViewById(R.id.sosMensaje);
        sosmensaje.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SmsManager sms = SmsManager.getDefault();
                //sms.sendTextMessage(contacto, null, mensaje, null, null);
                sms.sendTextMessage("999956103", null,"HOLA", null, null);
            }
        });

        return view;
    }

}
