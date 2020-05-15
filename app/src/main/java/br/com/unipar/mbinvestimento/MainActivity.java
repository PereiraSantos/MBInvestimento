package br.com.unipar.mbinvestimento;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    //Variaveis globais
    private EditText ativo,lucroLiquido, patrimônioLiquido, emitidasBolsa, precoAtual;
    private Double LPA, PL,ROE, VPA, PVP;
    private String Ativo, msg;
    private Long AcaoEmotidaBolsa;

    //Classe carrega xml
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //Classe validar entrada de dados
    public void validacao(View view){
        //Entrada dados tela
        ativo = findViewById(R.id.Ativo);
        lucroLiquido = findViewById(R.id.Lucro_Liquido);
        patrimônioLiquido = findViewById(R.id.Patrimônio_Liquido);
        emitidasBolsa = findViewById(R.id.Emitidas_bolsa);
        precoAtual = findViewById(R.id.Preco_Atual);

        //Verificar variaveis e seta mensagens
        if(ativo.getText().toString().equals("")){
            menssage("Campo Ativo Vazio!");
        }
        else if(lucroLiquido.getText().toString().equals("")){
            menssage("Campo Lucro Liquido esta Vazio!");
        }
        else if(patrimônioLiquido.getText().toString().equals("")) {
            menssage("Campo Patrimonio Liquido esta Vazio!");
        }
        else if(emitidasBolsa.getText().toString().equals("")){
            menssage("Campo Emitidas na Bolsa Esta Vazio!");
        }
        else if(precoAtual.getText().toString().equals("")){
            menssage("Campo Preco esta Vazio!");
        }
        else{
            calcular(view);

        }
    }

    //Classe calcular valores
    public void calcular(View view){
        //Recebee e converte dados
        Ativo = ativo.getText().toString();

        //Calcula os dados
        LPA = Double.parseDouble(String.valueOf(lucroLiquido.getText())) / Long.parseLong(String.valueOf(emitidasBolsa.getText()));
        PL = Double.parseDouble(String.valueOf(precoAtual.getText())) / LPA;
        ROE = (Double.parseDouble(String.valueOf(lucroLiquido.getText())) / Double.parseDouble(String.valueOf(patrimônioLiquido.getText()))) * 100;
        VPA =  Double.parseDouble(String.valueOf(patrimônioLiquido.getText())) / Long.parseLong(String.valueOf(emitidasBolsa.getText()));
        PVP =  Double.parseDouble(String.valueOf(precoAtual.getText())) / VPA;
        segundaTela(view);

    }

    //Classe prepara para ir para segunda tela
    public void segundaTela(View view){
        //Formata dados com 3 casas decimais
        NumberFormat format = NumberFormat.getInstance();
        format.setMaximumFractionDigits(3);

        //Prepara a trasferancia de dados
        Intent intent = new Intent(this,ResultadoInvestimento.class);
        Bundle b = new Bundle();
        b.putString("param", Ativo);
        b.putDouble("param1", Double.valueOf(format.format(LPA)));
        b.putDouble("param2", Double.valueOf(format.format(PL)));
        b.putDouble("param3", Double.valueOf(format.format(ROE)));
        b.putDouble("param4", Double.valueOf(format.format(VPA)));
        b.putDouble("param5", Double.valueOf(format.format(PVP)));
        intent.putExtras(b);
        startActivity(intent);

    }

    //Classe finaliza aplicaçao
    public void sair(View v){

        this.finish();
    }

    //Classe menssagens de alerta na tela
    public void menssage(String msg){

        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }
}
