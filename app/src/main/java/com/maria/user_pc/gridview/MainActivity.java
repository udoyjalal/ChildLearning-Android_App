package com.maria.user_pc.gridview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;

public class MainActivity extends AppCompatActivity implements RewardedVideoAdListener {

    AdView madView;
    private InterstitialAd interstitialAd;
    RewardedVideoAd rewardedVideoAd;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        rewardedVideoAd = MobileAds.getRewardedVideoAdInstance(this);
        rewardedVideoAd.setRewardedVideoAdListener(this);
        rewardedVideoAd.loadAd("ca-app-pub-8360713139937961/2800378450", new AdRequest.Builder().build());

        MobileAds.initialize(this, "ca-app-pub-8360713139937961~4122975081 ");
        madView = (AdView)findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        madView.loadAd(adRequest);

        interstitialAd = new InterstitialAd(this);
        interstitialAd.setAdUnitId("ca-app-pub-8360713139937961/9905784804");
        interstitialAd.loadAd(new AdRequest.Builder().build());

        interstitialAd.setAdListener(new AdListener(){

            @Override
            public void onAdClosed() {
                Intent intent = new Intent(MainActivity.this, BirdActivity.class);
                startActivity(intent);

                interstitialAd.loadAd(new AdRequest.Builder().build());
            }
        });


        getSupportActionBar().hide();

    }


    public void goBird(View view) {

        if(interstitialAd.isLoaded()){
            interstitialAd.show();
        } else {
            Intent intent = new Intent(this, BirdActivity.class);
            startActivity(intent);
        }

    }

    public void goAnimal(View view) {
        if(rewardedVideoAd.isLoaded()){
            rewardedVideoAd.show();
        }else {
            Intent intent = (new Intent(this, AnimalActivity.class));
            startActivity(intent);
        }
    }


    @Override
    public void onRewardedVideoAdLoaded() {

    }

    @Override
    public void onRewardedVideoAdOpened() {

    }

    @Override
    public void onRewardedVideoStarted() {

    }

    @Override
    public void onRewardedVideoAdClosed() {

    }

    @Override
    public void onRewarded(RewardItem rewardItem) {

    }

    @Override
    public void onRewardedVideoAdLeftApplication() {

    }

    @Override
    public void onRewardedVideoAdFailedToLoad(int i) {

    }

    public void privacyPolicy(View view) {
        Intent intent = new Intent(MainActivity.this, Privacypolicy.class);
        startActivity(intent);
    }
}
