package com.example.apuestas_app;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apuestas_app.adapter.MatchAdapter;
import com.example.apuestas_app.models.Match;
import com.example.apuestas_app.models.User;
import com.example.apuestas_app.utils.UserManager;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView matchesRecyclerView;
    private MatchAdapter matchAdapter;
    private List<Match> matchList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Insertar el usuario
        Toolbar toolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);

        TextView saldoText = toolbar.findViewById(R.id.saldo_text);
        TextView usuarioName = toolbar.findViewById(R.id.name_user);

        User user = UserManager.getUser();
        saldoText.setText("Saldo: $" + user.getSaldo());
        usuarioName.setText(user.getNombre());

        // Inicializar RecyclerView
        matchesRecyclerView = findViewById(R.id.matches_recycler_view);
        matchesRecyclerView.setHasFixedSize(true); // Opcional: mejora el rendimiento si el tamaño de los ítems es fijo
        matchesRecyclerView.setLayoutManager(new LinearLayoutManager(this)); // Usa un LinearLayoutManager para una lista vertical

        // Preparar los datos (5 ítems estáticos)
        matchList = new ArrayList<>();

        matchList.add(new Match(
                "FC Águilas", R.drawable.team_a_logo, 5,
                "Tigres FC", R.drawable.team_b_logo, 0,
                2500.0, "Partido inaugural de la temporada. ¡Gran expectación!", new Date()
        ));

        matchList.add(new Match(
                "Leones CF", R.drawable.team_b_logo, 0,
                "Rayos FC", R.drawable.team_a_logo, 0,
                1800.0, "Clásico regional. ¡Rivalidad asegurada!", new Date()
        ));

        matchList.add(new Match(
                "Delfines Marinos", R.drawable.team_a_logo, 0,
                "Lobos Azules", R.drawable.team_b_logo, 0,
                3200.0, "Encuentro de titanes. Pronóstico reservado.", new Date()
        ));

        matchList.add(new Match(
                "Halcones Negros", R.drawable.team_b_logo, 0,
                "Pumas Rojos", R.drawable.team_a_logo, 0,
                1500.0, "Duelo de la parte baja de la tabla, buscando salir del fondo.", new Date()
        ));

        matchList.add(new Match(
                "Guerreros Blancos", R.drawable.team_a_logo, 0,
                "Serpientes Verdes", R.drawable.team_b_logo, 0,
                2800.0, "El líder contra el aspirante. Se define el primer puesto.", new Date()
        ));

        // Inicializar y configurar el Adaptador
        matchAdapter = new MatchAdapter(this, matchList);
        matchesRecyclerView.setAdapter(matchAdapter);

        // Si tienes la Toolbar configurada, puedes acceder a ella aquí si necesitas añadir listeners, etc.
        // androidx.appcompat.widget.Toolbar myToolbar = findViewById(R.id.my_toolbar);
        // setSupportActionBar(myToolbar); // Si estás usando la Toolbar como ActionBar

    }
}
