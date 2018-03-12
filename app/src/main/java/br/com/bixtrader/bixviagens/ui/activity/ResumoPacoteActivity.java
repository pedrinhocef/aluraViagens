package br.com.bixtrader.bixviagens.ui.activity;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.math.BigDecimal;

import br.com.bixtrader.bixviagens.R;
import br.com.bixtrader.bixviagens.model.Pacote;
import br.com.bixtrader.bixviagens.util.DiasUtil;
import br.com.bixtrader.bixviagens.util.MoedaUtil;
import br.com.bixtrader.bixviagens.util.ResourceUtil;

public class ResumoPacoteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo_pacote);

        Pacote pacoteSaoPaulo = new Pacote("Sao Paulo", "sao_paulo_sp",
                2, new BigDecimal("243.99"));

        TextView local = findViewById(R.id.resumo_pacote_local);
        local.setText(pacoteSaoPaulo.getLocal());

        ImageView imagem = findViewById(R.id.resumo_pacote_imagem);
        Drawable drawableDoPacote = ResourceUtil
                .devolveDrawable(this, pacoteSaoPaulo.getImagem());
        imagem.setImageDrawable(drawableDoPacote);
        
        TextView dias = findViewById(R.id.resumo_pacote_dias);
        String diasEmTexto = DiasUtil.formataEmTexto(pacoteSaoPaulo.getDias());
        dias.setText(diasEmTexto);

        TextView preco = findViewById(R.id.resumo_pacote_preco);
        String moedaBrasileira = MoedaUtil
                .formataParaBrasileiro(pacoteSaoPaulo.getPreco());
        preco.setText(moedaBrasileira);
    }
}
