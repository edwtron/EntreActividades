/*
Programa ejemplo de el paso de datos entre actividades usando los "intents

*/
package co.ielectron.entreactividades;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Principal extends Activity implements View.OnClickListener{

    EditText txtDato;
    Button btnEnviar;
    String dato;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        txtDato = (EditText) findViewById(R.id.txtDato);
        btnEnviar = (Button) findViewById(R.id.btnEnviar);

        btnEnviar.setOnClickListener(this);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.btnEnviar:
                dato = txtDato.getText().toString();
                if(dato != null){
                    Toast.makeText(getBaseContext(), "dato OK", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(getBaseContext(), Secundaria.class);
                    intent.putExtra("dato", dato);
                    startActivity(intent);

                }


                break;
            default:

                break;
        }

    }
}
