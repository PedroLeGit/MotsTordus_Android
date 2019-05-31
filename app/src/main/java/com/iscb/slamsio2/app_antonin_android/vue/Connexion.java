package com.iscb.slamsio2.app_antonin_android.vue;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.iscb.slamsio2.app_antonin_android.R;
import com.iscb.slamsio2.app_antonin_android.modele.AccesDistant;
import com.iscb.slamsio2.app_antonin_android.modele.AccesLocal;
import com.iscb.slamsio2.app_antonin_android.modele.class_utilisateur;
import com.iscb.slamsio2.app_antonin_android.Classes_crud.crud_utilisateur;

import static java.lang.Integer.parseInt;

public class Connexion extends AppCompatActivity implements View.OnClickListener {
    //Propriétés
    private Button LeBouton;
    private EditText pseudo;
    private EditText mdp;
    private Button mentionslegales;
    private AccesDistant accesDistant;
    private class_utilisateur utilisateur;
    private boolean NetworkSatut;
    //

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connexion);
        accesDistant = new AccesDistant();
        init();

        //Click
        LeBouton.setOnClickListener(this);
        mentionslegales.setOnClickListener(this);

    }
    private void init(){
        //Connexion Logique -> Physique
        LeBouton = (Button)this.findViewById(R.id.btn_seconnecter);
        pseudo = (EditText)this.findViewById(R.id.tbx_user);
        mdp = (EditText)this.findViewById(R.id.tbx_password);
        mentionslegales = (Button)this.findViewById(R.id.btn_mentionslegales);
        //Verifaction de la connexion
        NetworkSatut = isNetworkAvailable();
        if(!NetworkSatut){
            Toast.makeText(Connexion.this,"Impossible de récuperer les informations ! Mode dégradé", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this, erreurinternet.class);
            this.startActivity(intent);
        }

    }

    /**
     * Permet de gerer les evenements au clique bouton
     * @param v
     */
    @Override
    public void onClick(View v) {
        Button b=(Button)v;
        if (b.getText().equals(LeBouton.getText())){
            accesDistant.demande_verifConnexion(pseudo.getText().toString(), mdp.getText().toString());
            utilisateur = accesDistant.getUtilisateur_verifie();
            if (utilisateur==null){
                Toast.makeText(Connexion.this,"Identifiants incorrectes", Toast.LENGTH_LONG).show();
            }else{
                Intent PageMainActivity = new Intent(this,MainActivity.class);
                PageMainActivity.putExtra("Utilisateur",utilisateur);
                this.startActivity(PageMainActivity);
            }
        }
        if (b.getText().equals(mentionslegales.getText())){
            Intent PageMentionsLegales = new Intent(this, mentions_legales.class);
            this.startActivity(PageMentionsLegales);
        }
    }

    /**
     * Permet de connaitre si l'acces réseau est disponible
     * @return vrai si dispo ou faux si pas dispo
     */
    private boolean isNetworkAvailable(){
        ConnectivityManager connectivityManager = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
}
