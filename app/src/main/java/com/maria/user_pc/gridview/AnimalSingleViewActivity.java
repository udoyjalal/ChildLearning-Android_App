package com.maria.user_pc.gridview;

import android.app.Activity;
import android.app.Notification;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

public class AnimalSingleViewActivity extends Activity {
    private MediaPlayer btnAudio,btnAnimalPro;
    private Notification.Action.Builder i;
    private AdView mAdveiw;
    private InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_single_view);

        MobileAds.initialize(this, "ca-app-pub-7036610474547852~5186964456");

        mAdveiw = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdveiw.loadAd(adRequest);

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-7036610474547852/5458427194");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());
        mInterstitialAd.setAdListener(new AdListener(){
            @Override
            public void onAdClosed() {
                super.onAdClosed();
                finish();
            }
        });

        Intent i = getIntent();

        // Selected image id
        final int position = i.getExtras().getInt("animalid");
        final ImageAdapterAnimal imageAdapterAnimal = new ImageAdapterAnimal(this);

        ImageView imageView = (ImageView) findViewById(R.id.AnimalSingleView);
        imageView.setImageResource(imageAdapterAnimal.aThumbIds[position]);

        TextView textView = (TextView) findViewById(R.id.AnimalTVSingleView);
        textView.setText(imageAdapterAnimal.AnimalList().get(position));


        btnAudio = MediaPlayer.create(AnimalSingleViewActivity.this,imageAdapterAnimal.animalSoundList().get(position));

        btnAnimalPro = MediaPlayer.create(AnimalSingleViewActivity.this,imageAdapterAnimal.animalPronountiationList().get(position));
    }

    public void AnimalSound(View view) {
        btnAudio.start();
    }

    public void AnimalPronountiation(View view) {
        btnAnimalPro.start();
    }

    public void showInterstitilar(){
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        } else {
            finish();
        }
    }

    @Override
    public void onBackPressed() {
        showInterstitilar();
    }

    @Override
    protected void onPause() {
        super.onPause();
        btnAudio.release();
        btnAnimalPro.release();
    }

    public void backtoAnimalGridV(View view) {
        Intent intent = (new Intent(AnimalSingleViewActivity.this, AnimalActivity.class));
        startActivity(intent);
        finish();
    }

}
