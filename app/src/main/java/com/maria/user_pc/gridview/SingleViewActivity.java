package com.maria.user_pc.gridview;

import android.app.Activity;
import android.app.Notification;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

import java.util.regex.MatchResult;

import static com.maria.user_pc.gridview.R.*;
import static com.maria.user_pc.gridview.R.id.btn;

public class SingleViewActivity extends Activity {
private MediaPlayer btnAudio,btnPronountiation;
    private Notification.Action.Builder i;
    private AdView mAdveiw;
    private InterstitialAd mInterstitialAd;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_single_view);

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

        // Get intent data
        Intent i = getIntent();

        // Selected image id
        final int position = i.getExtras().getInt("id");
        final ImageAdapter imageAdapter = new ImageAdapter(this);

        ImageView imageView = (ImageView) findViewById(id.SingleView);
        imageView.setImageResource(imageAdapter.mThumbIds[position]);

        TextView textView = (TextView) findViewById(id.TVSingleView);
        textView.setText(imageAdapter.birdsList().get(position));


        btnAudio = MediaPlayer.create(SingleViewActivity.this,imageAdapter.birdSoundList().get(position));

        btnPronountiation=MediaPlayer.create(SingleViewActivity.this,imageAdapter.birdPronountiationList().get(position));

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

    public void BirdSound(View view) {
        btnAudio.start();
    }

    public void BirdPronountiation(View view) {
        btnPronountiation.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        btnAudio.release();
        btnPronountiation.release();
    }

    public void backtoBirdGridV(View view) {
        Intent intent = (new Intent(SingleViewActivity.this,BirdActivity.class));
        startActivity(intent);
        finish();
    }
}
