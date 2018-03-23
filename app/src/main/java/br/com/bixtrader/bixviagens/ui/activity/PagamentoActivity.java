package br.com.bixtrader.bixviagens.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.math.BigDecimal;

import br.com.bixtrader.bixviagens.R;
import br.com.bixtrader.bixviagens.model.Pacote;
import br.com.bixtrader.bixviagens.util.MoedaUtil;

public class PagamentoActivity extends AppCompatActivity {

    public static final String TITLE_APPBAR = "Pagamento";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagamento);

        setTitle(TITLE_APPBAR);

        Pacote pacoteSaoPaulo = new Pacote("Sao Paulo","sao_paulo_sp",
                2, new BigDecimal("243.99" ));

        mostraPreco(pacoteSaoPaulo);


    }

    private void mostraPreco(Pacote pacote) {
        TextView preco = findViewById(R.id.pagamento_preco_pacote);
        String moedaBrasileira = MoedaUtil.formataParaBrasileiro(pacote.getPreco());
        preco.setText(moedaBrasileira);
    }
}
