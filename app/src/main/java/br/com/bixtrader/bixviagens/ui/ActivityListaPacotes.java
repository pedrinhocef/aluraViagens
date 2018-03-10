package br.com.bixtrader.bixviagens.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.List;

import br.com.bixtrader.bixviagens.R;
import br.com.bixtrader.bixviagens.adapter.ListaPacoteAdapter;
import br.com.bixtrader.bixviagens.dao.PacoteDAO;
import br.com.bixtrader.bixviagens.model.Pacote;

public class ActivityListaPacotes extends AppCompatActivity {

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
        List<Pacote> pacotes = new PacoteDAO().lista();
        listaPacotes.setAdapter(new ListaPacoteAdapter(pacotes, this));
    }
}
