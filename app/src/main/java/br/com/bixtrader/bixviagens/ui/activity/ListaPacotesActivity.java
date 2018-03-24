package br.com.bixtrader.bixviagens.ui.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

import br.com.bixtrader.bixviagens.R;
import br.com.bixtrader.bixviagens.adapter.ListaPacoteAdapter;
import br.com.bixtrader.bixviagens.dao.PacoteDAO;
import br.com.bixtrader.bixviagens.model.Pacote;

import static br.com.bixtrader.bixviagens.ui.activity.PacoteActivityConstantes.CHAVE_PACOTE;

public class ListaPacotesActivity extends AppCompatActivity {

    public static final String TITLE_APPBAR = "Pacotes";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_pacotes);
        setTitle(TITLE_APPBAR);
        configuraLista();
    }

    private void configuraLista() {
        ListView listaPacotes = findViewById(R.id.lista_pacote_lv);
        final List<Pacote> pacotes = new PacoteDAO().lista();
        listaPacotes.setAdapter(new ListaPacoteAdapter(pacotes, this));
        listaPacotes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                vaiParaResumoPacote(position, pacotes);
            }
        });
    }

    private void vaiParaResumoPacote(int position, List<Pacote> pacotes) {
        Pacote pacoteClicado = pacotes.get(position);
        Intent intent = new Intent(ListaPacotesActivity.this, ResumoPacoteActivity.class);
        intent.putExtra(CHAVE_PACOTE, pacoteClicado);
        startActivity(intent);
    }
}
