package com.iscb.slamsio2.app_antonin_android.vue;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.iscb.slamsio2.app_antonin_android.R;
import com.iscb.slamsio2.app_antonin_android.modele.class_utilisateur;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    //Propriétés
    private Button btn_deconnexion;
    private Button btn_moncompte;
    private Button btn_participer;
    private Button btn_concoursvenir;
    private ImageView img_avatar;
    private class_utilisateur utilisateur;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Methode de connexion logique / physique + Ecoute bouton
        init();
        //Recuperation du profil en extrat
        utilisateur = getIntent().getParcelableExtra("Utilisateur");
        //Affectation de l'avatar
        //img_avatar.setImageResource(utilisateur.getIdAvatar());
    }

    private void init(){
        //Connexion logique -> physique
        btn_deconnexion = (Button)findViewById(R.id.btn_gotodeconnexion);
        btn_moncompte = (Button)findViewById(R.id.btn_gotomoncompte);
        btn_participer = (Button)findViewById(R.id.btn_gotoquizz);
        btn_concoursvenir = (Button)findViewById(R.id.btn_concoursavenir);
        img_avatar = (ImageView)findViewById(R.id.img_avatar);
        //Ecoute bouton
        btn_deconnexion.setOnClickListener(this);
        btn_moncompte.setOnClickListener(this);
        btn_participer.setOnClickListener(this);
        btn_concoursvenir.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Button b = (Button)v;
        if (b.getText().equals(btn_deconnexion.getText())){
            finish();
        }
        if(b.getText().equals(btn_moncompte.getText())){

        }
        if (b.getText().equals(btn_participer.getText())){

        }
        if (b.getText().equals(btn_concoursvenir.getText())){

        }
    }
}
