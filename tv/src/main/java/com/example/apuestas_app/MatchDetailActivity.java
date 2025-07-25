package com.example.apuestas_app;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.apuestas_app.models.Match;

public class MatchDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.match_detail_activity);

        TextView detailMatchName = findViewById(R.id.detail_match_name);
        TextView detailBetAmount = findViewById(R.id.detail_bet_amount);
        TextView detailDescription = findViewById(R.id.detail_description);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            Match selectedMatch = (Match) extras.getSerializable("selected_match"); // Castea a Match

            if (selectedMatch != null) {
                detailMatchName.setText(selectedMatch.getTeamAName() + " vs " + selectedMatch.getTeamBName());
                detailBetAmount.setText("Monto de Apuestas: $" + String.format("%.0f", selectedMatch.getBetAmount()));
                detailDescription.setText(selectedMatch.getMatchDescription());
            }
        }
    }
}
