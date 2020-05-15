package br.com.unipar.mbinvestimento;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ResultadoInvestimento extends AppCompatActivity {

    //Classe carrega xml
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activiy_resultado);

        setaValores();
    }

    //Classe seta valores textView
    public void setaValores(){

        //Recebe valor intent
        Bundle b = getIntent().getExtras();
        String valor = b.getString("param");
        Double valor1 = b.getDouble("param1");
        Double valor2 = b.getDouble("param2");
        Double valor3 = b.getDouble("param3");
        Double valor4 = b.getDouble("param4");
        Double valor5 = b.getDouble("param5");

        //seta valores xml
        TextView textElementAtivo = (TextView) findViewById(R.id.Ativo);
        textElementAtivo.setText("Ativo\n"+valor);

        TextView textElement = (TextView) findViewById(R.id.LPA);
        textElement.setText("Lucro por ação\n"+valor1.toString());

        TextView textElement1 = (TextView) findViewById(R.id.PL);
        textElement1.setText("Preço lucro\n"+valor2.toString());

        TextView textElement2 = (TextView) findViewById(R.id.ROE);
        textElement2.setText("Retorno sobre o Patrimônio Líquido\n"+valor3.toString());

        TextView textElement3 = (TextView) findViewById(R.id.VPA);
        textElement3.setText("Valor Patrimonial por ação\n"+valor4.toString());

        TextView textElement4 = (TextView) findViewById(R.id.PVP);
        textElement4.setText("Preço sobre o Valor Patrimonial\n"+valor5.toString());

    }
}
