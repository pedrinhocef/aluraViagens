package br.com.bixtrader.bixviagens.ui.activity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import br.com.bixtrader.bixviagens.R;
import br.com.bixtrader.bixviagens.model.Pacote;
import br.com.bixtrader.bixviagens.util.DataUtil;
import br.com.bixtrader.bixviagens.util.MoedaUtil;
import br.com.bixtrader.bixviagens.util.ResourceUtil;

public class ResumoCompraActivity extends AppCompatActivity {

    public static final String RESUMO_DA_COMPRA = "Resumo da compra";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo_compra);
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        setTitle(RESUMO_DA_COMPRA);
        pacoteRecebido();
    }

    private void pacoteRecebido() {
        Intent intent = getIntent();
        if (intent.hasExtra("pacote")){
            Pacote pacote = (Pacote) intent.getSerializableExtra("pacote");
            inicializaCampos(pacote);
        }
    }

    private void inicializaCampos(Pacote pacote) {
        mostraLocal(pacote);
        mostraImagem(pacote);
        mostraData(pacote);
        mostraPreco(pacote);
    }

    private void mostraPreco(Pacote pacote) {
        TextView preco = findViewById(R.id.resumo_compra_preco);
        String moedaBrasileira = MoedaUtil.formataParaBrasileiro(pacote.getPreco());
        preco.setText(moedaBrasileira);
    }

    private void mostraData(Pacote pacote) {
        TextView data = findViewById(R.id.resumo_compra_data);
        String periodoEmTexto = DataUtil.periodoEmTexto(pacote.getDias());
        data.setText(periodoEmTexto);
    }

    private void mostraImagem(Pacote pacote) {
        ImageView imageView = findViewById(R.id.resumo_compra_imagem_local);
        Drawable drawableDoPacote = ResourceUtil
                .devolveDrawable(this, pacote.getImagem());
        imageView.setImageDrawable(drawableDoPacote);
    }

    private void mostraLocal(Pacote pacote) {
        TextView local = findViewById(R.id.resumo_compra_local);
        local.setText(pacote.getLocal());
    }
}
