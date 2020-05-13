package com.maria.user_pc.gridview;

import android.content.Context;
import android.support.annotation.RawRes;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User-PC on 3/24/2018.
 */

public class ImageAdapter extends BaseAdapter {
    private Context mContext;

    // Constructor
    public ImageAdapter(Context c) {
        mContext = c;
    }

    public ImageAdapter() {

    }

    public int getCount() {
        return mThumbIds.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;

        if (convertView == null) {
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(140, 210));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);
        } else {
            imageView = (ImageView) convertView;
        }
        imageView.setImageResource(mThumbIds[position]);
        return imageView;
    }

    // Keep all Images in array
    public Integer[] mThumbIds = {
            R.drawable.peacock, R.drawable.kingfisher,
            R.drawable.crow, R.drawable.eagle,
            R.drawable.penguin, R.drawable.macaw,
            R.drawable.woodpecker, R.drawable.turkey,
            R.drawable.cockatoo, R.drawable.parrot,
            R.drawable.heron, R.drawable.cock,
            R.drawable.pigeon, R.drawable.duck,
            R.drawable.owl,
    };

    public List<String> birdsList() {
        List<String> birds = new ArrayList<>();
        birds.add(" Name : Peacock \n নাম : ময়ুর");
        birds.add(" Name : Kingfisher \n নাম : মাছরাঙ্গা");
        birds.add(" Name : Crow \n নাম : কাক");
        birds.add(" Name : Eagle \n নাম : ঈগল");
        birds.add(" Name : Penguin \n নাম : পেংগুইন");
        birds.add(" Name : Macaw \n নাম : আমেরিকার \n কাকাতুয়া");
        birds.add(" Name : \n Woodpecker \n নাম : কাঠঠোকরা");
        birds.add(" Name : Turkey \n নাম : তুরস্কের \n  মোরগ");
        birds.add(" Name : Cockatoo \n নাম : কাকাতুয়া");
        birds.add(" Name : Parrot \n নাম : তোতাপাখি");
        birds.add(" Name : Heron \n নাম : বক");
        birds.add(" Name : Cock \n নাম : মোরগ");
        birds.add(" Name : Pigeon \n নাম : পায়রা");
        birds.add(" Name : Duck \n নাম : হাঁস");
        birds.add(" Name : Owl \n নাম : পেঁচা");

        return birds;
    }

    public List<Integer> birdSoundList() {
        List<Integer> sounds = new ArrayList<>();
        sounds.add(R.raw.moyur);
        sounds.add(R.raw.kingfisher);
        sounds.add(R.raw.crow);
        sounds.add(R.raw.eagle);
        sounds.add(R.raw.penguin);
        sounds.add(R.raw.macaw);
        sounds.add(R.raw.woodpeaker);
        sounds.add(R.raw.turkey);
        sounds.add(R.raw.cockatoo);
        sounds.add(R.raw.parrot);
        sounds.add(R.raw.heron);
        sounds.add(R.raw.cock);
        sounds.add(R.raw.pegion);
        sounds.add(R.raw.duck);
        sounds.add(R.raw.owl);

        return sounds;
    }

    public List<Integer> birdPronountiationList() {
        List<Integer> pronountiation = new ArrayList<>();
        pronountiation.add(R.raw.peacockp);
        pronountiation.add(R.raw.kingfisherp);
        pronountiation.add(R.raw.crowp);
        pronountiation.add(R.raw.eaglep);
        pronountiation.add(R.raw.penguinp);
        pronountiation.add(R.raw.macawp);
        pronountiation.add(R.raw.woodpeckerp);
        pronountiation.add(R.raw.turkeyp);
        pronountiation.add(R.raw.cockatoop);
        pronountiation.add(R.raw.parrotp);
        pronountiation.add(R.raw.heronp);
        pronountiation.add(R.raw.cockp);
        pronountiation.add(R.raw.pigeonp);
        pronountiation.add(R.raw.duckp);
        pronountiation.add(R.raw.owlp);

        return pronountiation;
    }
}

