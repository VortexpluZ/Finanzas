package tracker.money.finazas;

import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;



public class Calculo implements View.OnClickListener {
    Button uno, dos, tres, cuatro, cinco, seis, siete, ocho, nueve, cero, dobleCero, mas, menos;
    TextView conteo;
    Activity finanzas;

    public Calculo(Activity finanzas)

    {
        this.finanzas = finanzas;
        uno = (Button) finanzas.findViewById(R.id.uno);
        dos = (Button) finanzas.findViewById(R.id.dos);
        tres = (Button) finanzas.findViewById(R.id.tres);
        cuatro = (Button) finanzas.findViewById(R.id.cuatro);
        cinco = (Button) finanzas.findViewById(R.id.cinco);
        seis = (Button) finanzas.findViewById(R.id.seis);
        siete = (Button) finanzas.findViewById(R.id.siete);
        ocho = (Button) finanzas.findViewById(R.id.ocho);
        nueve = (Button) finanzas.findViewById(R.id.nueve);
        cero = (Button) finanzas.findViewById(R.id.cero);
        dobleCero = (Button) finanzas.findViewById(R.id.doble_cero);
        mas = (Button) finanzas.findViewById(R.id.mas);
        menos = (Button) finanzas.findViewById(R.id.menos);
        conteo =(TextView)finanzas.findViewById(R.id.conteo);

        try
        {
            uno.setOnClickListener(this);
            dos.setOnClickListener(this);
            tres.setOnClickListener(this);
            cuatro.setOnClickListener(this);
            cinco.setOnClickListener(this);
            seis.setOnClickListener(this);
            siete.setOnClickListener(this);
            ocho.setOnClickListener(this);
            nueve.setOnClickListener(this);
            cero.setOnClickListener(this);
            dobleCero.setOnClickListener(this);
            mas.setOnClickListener(this);
            menos.setOnClickListener(this);

        }
        catch (Exception e)
        {

        }

    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId()) {
            case  R.id.uno: {
                conteo.setText("");
                conteo.setText("1");
                break;
            }
            case R.id.dos: {
                conteo.setText("");
                conteo.setText("2");
                break;
            }
            case R.id.tres: {
                conteo.setText("");
                conteo.setText("3");
                break;
            }
            case R.id.cuatro: {
                conteo.setText("");
                conteo.setText("4");
                break;
            }
            case R.id.cinco: {
                conteo.setText("");
                conteo.setText("5");
                break;
            }
            case R.id.seis: {
                conteo.setText("");
                conteo.setText("6");
                break;
            }
            case R.id.siete: {
                conteo.setText("");
                conteo.setText("7");
                break;
            }
            case R.id.ocho: {
                conteo.setText("");
                conteo.setText("8");
                break;
            }
            case R.id.nueve: {
                conteo.setText("");
                conteo.setText("9");
                break;
            }
            case R.id.cero: {
                conteo.setText("");
                conteo.setText("0");
                break;
            }
            case R.id.doble_cero: {
                conteo.setText("");
                conteo.setText("00");
                break;
            }
            case R.id.mas: {
                conteo.setText("");
                conteo.setText("+");
                break;
            }
            case R.id.menos: {
                conteo.setText("");
                conteo.setText("-");
                break;
            }
        }
    }
}
