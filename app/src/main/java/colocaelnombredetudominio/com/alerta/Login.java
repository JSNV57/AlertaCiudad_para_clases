package colocaelnombredetudominio.com.alerta;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity implements View.OnClickListener {
private EditText edtUsuario , edtClave;
private Button btnIngresar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //enlazar variables con controles
        edtUsuario=(EditText) findViewById(R.id.edtUsuario);
        edtClave=(EditText) findViewById(R.id.edtClave);
        btnIngresar=(Button) findViewById(R.id.btnIngresar);
        //respuesta a eventos
        btnIngresar.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btnIngresar:
                if (edtUsuario.getText().toString().equals("JORGE") && edtClave.getText().toString().equals("12345"))
                {
                 Toast.makeText(this,"Usuario OK",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(Login.this,MainActivity.class);
                startActivity(intent);
                finish();
                }
                else
                    Toast.makeText(this,"Usuario ERRADO",Toast.LENGTH_LONG).show();
                break;
        }
    }
}
