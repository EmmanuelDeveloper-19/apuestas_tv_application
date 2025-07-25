package com.example.apuestas_app;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apuestas_app.adapter.MatchAdapter;
import com.example.apuestas_app.models.Match;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{

    private RecyclerView matchesRecyclerView;
    private MatchAdapter matchAdapter;
    private List<Match> matchList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicializar RecyclerView
        matchesRecyclerView = findViewById(R.id.matches_recycler_view);
        matchesRecyclerView.setHasFixedSize(true); // Opcional: mejora el rendimiento si el tamaño de los ítems es fijo
        matchesRecyclerView.setLayoutManager(new LinearLayoutManager(this)); // Usa un LinearLayoutManager para una lista vertical

        // Preparar los datos (tus 5 ítems estáticos)
        matchList = new ArrayList<>();
        // Asegúrate de que los IDs de los drawables existan en res/drawable
        // Crea tus drawables team_a_logo, team_b_logo, ic_calendar, icon_person, ic_settings
        matchList.add(new Match("FC Águilas", R.drawable.team_a_logo, "Tigres FC", R.drawable.team_b_logo, 2500.0, "Partido inaugural de la temporada. ¡Gran expectación!"));
        matchList.add(new Match("Leones CF", R.drawable.team_b_logo, "Rayos FC", R.drawable.team_a_logo, 1800.0, "Clásico regional. ¡Rivalidad asegurada!"));
        matchList.add(new Match("Delfines Marinos", R.drawable.team_a_logo, "Lobos Azules", R.drawable.team_b_logo, 3200.0, "Encuentro de titanes. Pronóstico reservado."));
        matchList.add(new Match("Halcones Negros", R.drawable.team_b_logo, "Pumas Rojos", R.drawable.team_a_logo, 1500.0, "Duelo de la parte baja de la tabla, buscando salir del fondo."));
        matchList.add(new Match("Guerreros Blancos", R.drawable.team_a_logo, "Serpientes Verdes", R.drawable.team_b_logo, 2800.0, "El líder contra el aspirante. Se define el primer puesto."));

        // Inicializar y configurar el Adaptador
        matchAdapter = new MatchAdapter(this, matchList);
        matchesRecyclerView.setAdapter(matchAdapter);

        // Si tienes la Toolbar configurada, puedes acceder a ella aquí si necesitas añadir listeners, etc.
        // androidx.appcompat.widget.Toolbar myToolbar = findViewById(R.id.my_toolbar);
        // setSupportActionBar(myToolbar); // Si estás usando la Toolbar como ActionBar

    }
}
