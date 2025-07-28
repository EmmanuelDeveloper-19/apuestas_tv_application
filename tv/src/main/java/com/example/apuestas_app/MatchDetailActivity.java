package com.example.apuestas_app;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.apuestas_app.models.Match;
import com.example.apuestas_app.models.User;
import com.example.apuestas_app.utils.UserManager;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import org.w3c.dom.Text;

public class MatchDetailActivity extends AppCompatActivity {
    private Match match; // variable global

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.match_detail_activity);

        match = (Match) getIntent().getSerializableExtra("match");
        Button btnApuestaTeamA = findViewById(R.id.btn_team_a_apuesta);
        Button btnApuestaTeamB = findViewById(R.id.btn_team_b_apuesta);

        // Insertar información del usuario
        Toolbar toolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);

        // Boton de apuesta
        btnApuestaTeamA.setOnClickListener(v -> {
            if (match != null) {
                mostrarDialogoApuesta(match, match.getTeamAName(), 200);
            }
        });

        btnApuestaTeamB.setOnClickListener(v -> {
            if (match != null) {
                mostrarDialogoApuesta(match, match.getTeamBName(), 200);
            }
        });


        TextView textSaldo = toolbar.findViewById(R.id.saldo_text);
        TextView textName = toolbar.findViewById(R.id.name_user);

        User user = UserManager.getUser();
        textSaldo.setText("Saldo: $ "+ user.getSaldo());
        textName.setText(user.getNombre());

        // 1. Recibir datos del Partido
        Match match = (Match) getIntent().getSerializableExtra("match");

        // 2. Referencias de vistas
        TextView teamAName = findViewById(R.id.team_a_name);
        TextView teamBName = findViewById(R.id.team_b_name);
        ImageView teamALogo = findViewById(R.id.team_a_logo);
        ImageView teamBLogo = findViewById(R.id.team_b_logo);

        // 3. Asignar datos al layout
        if (match != null) {
            teamAName.setText(match.getTeamAName());
            teamBName.setText(match.getTeamBName());
            teamALogo.setImageResource(match.getTeamALogoResId());
            teamBLogo.setImageResource(match.getTeamBLogoResId());
        }

        // 4. Configuración del Video
        VideoView videoView = findViewById(R.id.richardVideo);
        Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.richard_sanchez);
        videoView.setVideoURI(uri);

        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);
        videoView.start();
    }

    private void mostrarDialogoApuesta(Match match, String equipo, double montoInicial) {
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.bottom_sheet_apuesta);
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setCancelable(true);

        TextView equipoNombre = dialog.findViewById(R.id.equipo_nombre);
        TextView montoText = dialog.findViewById(R.id.monto_text);
        Button btnMenos = dialog.findViewById(R.id.btn_menos);
        Button btnMas = dialog.findViewById(R.id.btn_mas);
        Button btnConfirmar = dialog.findViewById(R.id.btn_confirmar_apuesta);

        equipoNombre.setText("Equipo: " + equipo);
        montoText.setText("Monto: $" + montoInicial);

        final double[] montoActual = {montoInicial};

        btnMenos.setOnClickListener(v -> {
            if (montoActual[0] > 50) {
                montoActual[0] -= 50;
                montoText.setText("Monto: $" + montoActual[0]);
            }
        });

        btnMas.setOnClickListener(v -> {
            montoActual[0] += 50;
            montoText.setText("Monto: $" + montoActual[0]);
        });

        btnConfirmar.setOnClickListener(v -> {
            User user = UserManager.getUser();
            if (user.getSaldo() < montoActual[0]) {
                Toast.makeText(this, "Saldo insuficiente", Toast.LENGTH_SHORT).show();
            } else {
                // ✅ Validamos si el equipo apostado ganó según los goles
                boolean gano = false;
                if (equipo.equals(match.getTeamAName()) && match.getTeamAGoals() > match.getTeamBGoals()) {
                    gano = true;
                } else if (equipo.equals(match.getTeamBName()) && match.getTeamBGoals() > match.getTeamAGoals()) {
                    gano = true;
                }

                double gananciaExtra = montoActual[0] * 0.5;
                user.apostar(montoActual[0], gano, gananciaExtra);

                actualizarSaldoUI();

                if (gano) {
                    Toast.makeText(this, "¡Ganaste! +" + gananciaExtra, Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(this, "Perdiste la apuesta", Toast.LENGTH_LONG).show();
                }
            }
            dialog.dismiss();
        });

        dialog.show();
    }

    private void actualizarSaldoUI() {
        Toolbar toolbar = findViewById(R.id.my_toolbar);
        TextView textSaldo = toolbar.findViewById(R.id.saldo_text);
        User user = UserManager.getUser();
        textSaldo.setText("Saldo: $ " + user.getSaldo());
    }


}

