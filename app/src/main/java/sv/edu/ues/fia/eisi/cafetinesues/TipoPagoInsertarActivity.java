package sv.edu.ues.fia.eisi.cafetinesues;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class TipoPagoInsertarActivity extends Activity {
    ControlDB helper;
    EditText id_tipoPago;
    EditText nombre_tipoPago;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tipo_pago_insertar);
        helper = new ControlDB(this);
        id_tipoPago = (EditText) findViewById(R.id.txtIdTipoPago);
        nombre_tipoPago = (EditText) findViewById(R.id.txtNombrePago);
    }
    public void insertarTipopago(View v){
        String id_tp = id_tipoPago.getText().toString();
        String n_tp = nombre_tipoPago.getText().toString();
        String regInsertados;

        TipoPago tipoPago = new TipoPago();
        tipoPago.setId_TipoPago(Integer.parseInt(id_tp));
        tipoPago.setNombre_TipoPago(n_tp);
        helper.abrir();
        regInsertados=helper.insertar(tipoPago);
        helper.cerrar();
        Toast.makeText(this, regInsertados, Toast.LENGTH_SHORT).show();
    }

    public void limpiarTexto(View v)
    {
        id_tipoPago.setText("");
        nombre_tipoPago.setText("");

    }
}