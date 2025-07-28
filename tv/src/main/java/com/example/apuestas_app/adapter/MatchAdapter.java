package com.example.apuestas_app.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apuestas_app.MatchDetailActivity;
import com.example.apuestas_app.R;
import com.example.apuestas_app.models.Match;

import java.util.List;
import java.util.Locale;

public class MatchAdapter extends RecyclerView.Adapter<MatchAdapter.MatchViewHolder> {

    private final List<Match> matchList;
    private final Context context;

    public MatchAdapter(Context context, List<Match> matchList) {
        this.context = context;
        this.matchList = matchList;
    }

    @NonNull
    @Override
    public MatchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_match, parent, false);
        return new MatchViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MatchViewHolder holder, int position) {
        Match currentMatch = matchList.get(position);

        // Asignamos datos a las vistas
        holder.teamALogo.setImageResource(currentMatch.getTeamALogoResId());
        holder.teamAName.setText(currentMatch.getTeamAName());
        holder.teamBLogo.setImageResource(currentMatch.getTeamBLogoResId());
        holder.teamBName.setText(currentMatch.getTeamBName());
        holder.betAmount.setText(String.format(Locale.getDefault(), "Monto de Apuestas: $%.0f", currentMatch.getBetAmount()));

        // Listener para abrir detalles
        View.OnClickListener openDetail = v -> {
            Intent intent = new Intent(context, MatchDetailActivity.class);
            intent.putExtra("match", currentMatch);
            context.startActivity(intent);
        };

        // Asignamos el mismo listener al botón y al card
        holder.btnBet.setOnClickListener(openDetail);
        holder.itemView.setOnClickListener(openDetail);
    }

    @Override
    public int getItemCount() {
        return matchList.size();
    }

    public static class MatchViewHolder extends RecyclerView.ViewHolder {
        ImageView teamALogo, teamBLogo;
        TextView teamAName, teamBName, betAmount;
        Button btnBet;

        public MatchViewHolder(@NonNull View itemView) {
            super(itemView);
            teamALogo = itemView.findViewById(R.id.team_a_logo);
            teamAName = itemView.findViewById(R.id.team_a_name);
            teamBLogo = itemView.findViewById(R.id.team_b_logo);
            teamBName = itemView.findViewById(R.id.team_b_name);
            betAmount = itemView.findViewById(R.id.bet_amount);
            btnBet = itemView.findViewById(R.id.btn_bet);
        }
    }
}
