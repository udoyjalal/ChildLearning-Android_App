package com.maria.user_pc.gridview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User-PC on 3/27/2018.
 */

public class ImageAdapterAnimal extends BaseAdapter {
    private Context aContext;

    public ImageAdapterAnimal(Context a) {
        aContext = a;
    }

    public ImageAdapterAnimal() {

    }
    @Override
    public int getCount() {
        return aThumbIds.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;

        if (convertView == null) {
            imageView = new ImageView(aContext);
            imageView.setLayoutParams(new GridView.LayoutParams(140, 210));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);
        } else {
            imageView = (ImageView) convertView;
        }
        imageView.setImageResource(aThumbIds[position]);
        return imageView;
    }

    public Integer[] aThumbIds = {
            R.drawable.bear, R.drawable.cat,
            R.drawable.hippopotamus, R.drawable.cow,
            R.drawable.frog, R.drawable.camel,
            R.drawable.rat, R.drawable.elephant,
            R.drawable.dog, R.drawable.horse,
            R.drawable.tiger, R.drawable.rhinoceroses,
            R.drawable.zebra, R.drawable.lion,
            R.drawable.monkey,
    };

    public List<String> AnimalList() {
        List<String> Animals = new ArrayList<>();
        Animals.add(" Name : Bear \n নাম : ভালুক");
        Animals.add(" Name : Cat \n নাম : বিড়াল");
        Animals.add(" Name : \n Hippopotamus \n নাম : জলহস্তী");
        Animals.add(" Name : Cow \n নাম : গাভী");
        Animals.add(" Name : Frog \n নাম : ব্যাঙ্");
        Animals.add(" Name : Camel \n নাম : উট");
        Animals.add(" Name : Rat \n নাম : ইঁদুর");
        Animals.add(" Name : Elephant \n নাম : হাতি");
        Animals.add(" Name : Dog \n নাম : কুকুর");
        Animals.add(" Name : Horse \n নাম : ঘোড়া");
        Animals.add(" Name : Tiger \n নাম : বাঘ");
        Animals.add(" Name : \n Rhinoceroses \n নাম : গন্ডার");
        Animals.add(" Name : Zebra \n নাম : জেব্রা");
        Animals.add(" Name : Lion \n নাম : সিংহ");
        Animals.add(" Name : Monkey \n নাম : বানর");

        return Animals;
    }

    public List<Integer> animalSoundList() {
        List<Integer> Animalsounds = new ArrayList<>();
        Animalsounds.add(R.raw.bear);
        Animalsounds.add(R.raw.cat);
        Animalsounds.add(R.raw.hippo);
        Animalsounds.add(R.raw.cow);
        Animalsounds.add(R.raw.frog);
        Animalsounds.add(R.raw.camel);
        Animalsounds.add(R.raw.rat);
        Animalsounds.add(R.raw.elephant);
        Animalsounds.add(R.raw.dog);
        Animalsounds.add(R.raw.horse);
        Animalsounds.add(R.raw.tiger);
        Animalsounds.add(R.raw.rhinocerose);
        Animalsounds.add(R.raw.zebra);
        Animalsounds.add(R.raw.lion);
        Animalsounds.add(R.raw.monkey);

        return Animalsounds;
    }

    public List<Integer> animalPronountiationList() {
        List<Integer> AnimalPronountiation = new ArrayList<>();
        AnimalPronountiation.add(R.raw.bearp);
        AnimalPronountiation.add(R.raw.catp);
        AnimalPronountiation.add(R.raw.hippopotamusp);
        AnimalPronountiation.add(R.raw.cowp);
        AnimalPronountiation.add(R.raw.frogp);
        AnimalPronountiation.add(R.raw.camelp);
        AnimalPronountiation.add(R.raw.ratp);
        AnimalPronountiation.add(R.raw.elephantp);
        AnimalPronountiation.add(R.raw.dogp);
        AnimalPronountiation.add(R.raw.horsep);
        AnimalPronountiation.add(R.raw.tigerp);
        AnimalPronountiation.add(R.raw.rhinocerosesp);
        AnimalPronountiation.add(R.raw.zebrap);
        AnimalPronountiation.add(R.raw.lionp);
        AnimalPronountiation.add(R.raw.monkeyp);

        return AnimalPronountiation;
    }
}
