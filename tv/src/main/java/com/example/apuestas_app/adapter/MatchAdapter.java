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

public class MatchAdapter extends RecyclerView.Adapter<MatchAdapter.MatchViewHolder> {

    private List<Match> matchList;
    private Context context;

    public MatchAdapter(Context context, List<Match> matchList){
        this.context = context;
        this.matchList = matchList;
    }

    @NonNull
    @Override
    public MatchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_match, parent, false);
        return new MatchViewHolder(view);
    }

    // Este método es llamado por el RecyclerView para mostrar los datos en una posición específica
    // Vincula los datos del objeto Match a las vistas del layout item_match.xml
    @Override
    public void onBindViewHolder(@NonNull MatchViewHolder holder, int position) {
        Match currentMatch = matchList.get(position);

        holder.teamALogo.setImageResource(currentMatch.getTeamALogoResId());
        holder.teamAName.setText(currentMatch.getTeamAName());
        holder.teamBLogo.setImageResource(currentMatch.getTeamBLogoResId());
        holder.teamBName.setText(currentMatch.getTeamBName());
        holder.betAmount.setText("Monto de Apuestas: $" + String.format("%.0f", currentMatch.getBetAmount())); // Formatea el double sin decimales

        // Manejar el clic en el botón "Apostar"
        holder.btnBet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lanzar la MatchDetailActivity y pasar el objeto Match
                Intent intent = new Intent(context, MatchDetailActivity.class);
                intent.putExtra("selected_match", currentMatch); // "selected_match" es la clave para recuperar el objeto
                context.startActivity(intent);
            }
        });

        // Opcional: Manejar el clic en toda la tarjeta (CardView) si quieres que también lleve a los detalles
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MatchDetailActivity.class);
                intent.putExtra("selected_match", currentMatch);
                context.startActivity(intent);
            }
        });
    }

    // Retorna el número total de ítems en la lista de datos
    @Override
    public int getItemCount() {
        return matchList.size();
    }

    public static class MatchViewHolder extends RecyclerView.ViewHolder{
        ImageView teamALogo;
        TextView teamAName;
        ImageView teamBLogo;
        TextView teamBName;
        TextView betAmount;
        Button btnBet;

        public MatchViewHolder(@NonNull View itemView){
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

