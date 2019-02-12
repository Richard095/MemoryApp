package com.example.memoryapp;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button restart;
    TextView txtcouples ;
    int clik=0;
    int BackPos,CurrentlyPos;
    ImageView[] imageView=new  ImageView[12];
    int[] Image = new int[12];
    int [] Temp =new int[12];
    int [] def_Img=new int[12];
    int couples=6;
    int findedCouples=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        restart = findViewById(R.id.btn_restart);
        txtcouples = findViewById(R.id.txtcouples);
        imageView[0] = findViewById(R.id.image_uno);imageView[0].setOnClickListener(this);
        imageView[1] = findViewById(R.id.image_dos);imageView[1].setOnClickListener(this);
        imageView[2] = findViewById(R.id.image_tres);imageView[2].setOnClickListener(this);
        imageView[3] = findViewById(R.id.image_cuatro);imageView[3].setOnClickListener(this);
        imageView[4] = findViewById(R.id.image_cinco);imageView[4].setOnClickListener(this);
        imageView[5] = findViewById(R.id.image_seis);imageView[5].setOnClickListener(this);
        imageView[6] = findViewById(R.id.image_siete);imageView[6].setOnClickListener(this);
        imageView[7] = findViewById(R.id.image_ocho);imageView[7].setOnClickListener(this);
        imageView[8] = findViewById(R.id.image_nueve);imageView[8].setOnClickListener(this);
        imageView[9] = findViewById(R.id.image_dies);imageView[9].setOnClickListener(this);
        imageView[10] = findViewById(R.id.image_once);imageView[10].setOnClickListener(this);
        imageView[11] = findViewById(R.id.image_doce);imageView[11].setOnClickListener(this);
        imageView[0].setTag("0");
        imageView[1].setTag("1");
        imageView[2].setTag("2");
        imageView[3].setTag("3");
        imageView[4].setTag("4");
        imageView[5].setTag("5");
        imageView[6].setTag("6");
        imageView[7].setTag("7");
        imageView[8].setTag("8");
        imageView[9].setTag("9");
        imageView[10].setTag("10");
        imageView[11].setTag("11");
        saveCards();
        addDefaultImage();

        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveCards();
                addDefaultImage();
                clik=0;
                enabledPLay();
                findedCouples=0;
                txtcouples.setText("0");
            }
        });
    }

    public int[] random(int[] array) {
        Random rnd = new Random();
        for (int i = 0; i < array.length; i++) {
            int randomPosition = rnd.nextInt(array.length);
            int temp = array[i];
            array[i] = array[randomPosition];
            array[randomPosition] = temp;
        }
        return array;
    }


    public void saveCards() {
        Image[0]=R.drawable.uno;
        Image[1] = (R.drawable.dos);
        Image[2] = (R.drawable.tres);
        Image[3] = (R.drawable.cuatro);
        Image[4] = (R.drawable.cinco);
        Image[5] = (R.drawable.seis);
        Image[6] = (R.drawable.uno);
        Image[7] = (R.drawable.dos);
        Image[8] = (R.drawable.tres);
        Image[9] = (R.drawable.cuatro);
        Image[10] = (R.drawable.cinco);
        Image[11] = (R.drawable.seis);

        random(Image);
        Temp = Image;
    }

    public void addDefaultImage() {
        int k = 0;
        while (k < def_Img.length) {
            def_Img[k] = R.drawable.dbs;
            k++;
        }
        imageView[0].setImageResource(def_Img[0]);
        imageView[1].setImageResource(def_Img[1]);
        imageView[2].setImageResource(def_Img[2]);
        imageView[3].setImageResource(def_Img[3]);
        imageView[4].setImageResource(def_Img[4]);
        imageView[5].setImageResource(def_Img[5]);
        imageView[6].setImageResource(def_Img[6]);
        imageView[7].setImageResource(def_Img[7]);
        imageView[8].setImageResource(def_Img[8]);
        imageView[9].setImageResource(def_Img[9]);
        imageView[10].setImageResource(def_Img[10]);
        imageView[11].setImageResource(def_Img[11]);

    }
    public void enabledPLay(){
        imageView[0].setEnabled(true);
        imageView[1].setEnabled(true);
        imageView[2].setEnabled(true);
        imageView[3].setEnabled(true);
        imageView[4].setEnabled(true);
        imageView[5].setEnabled(true);
        imageView[6].setEnabled(true);
        imageView[7].setEnabled(true);
        imageView[8].setEnabled(true);
        imageView[9].setEnabled(true);
        imageView[10].setEnabled(true);
        imageView[11].setEnabled(true);
    }
    public int get_random(int tagImage) {
        for (int k = 0; k < Temp.length; k++) {
            if (tagImage == k) {
                //String resourse_name = getResources().getResourceEntryName(image[tagImage]);
                //Toast.makeText(getApplicationContext(),"Punnchaste  en resourse_name : "
                // +resourse_name,Toast.LENGTH_SHORT).show();
                return k;
            }
        }
        return 0;
    }

    public String get_resourse_name(int tagImage) {
        for (int k = 0; k < Temp.length; k++) {
            if (tagImage == k) {
                String resourse_name = getResources().getResourceEntryName(Image[tagImage]);
                return resourse_name;
            }
        }
        return "";
    }

    public boolean verifyCouples(int firstCard,int secondCard){
        String card1 = get_resourse_name(firstCard);
        String card2 = get_resourse_name(secondCard);

        if(card1.equals(card2)){
            return true;
        }else{
            return false;
        }

    }

    @Override
    public void onClick(View view) {
        clik++;
        int id = view.getId();
        final int tag = Integer.parseInt((String) view.getTag());
        get_random(tag);
        /*Toast.makeText(getApplicationContext(),"ImageName --> "
                +get_resourse_name(tag),Toast.LENGTH_SHORT).show();*/
        final ImageView iv = (ImageView)view;
        iv.setImageResource(Temp[tag]);
        if (clik==1){
            BackPos=tag;
            imageView[tag].setEnabled(false);
        }
        if (clik==2){
            CurrentlyPos=tag;
            verifyCouples(BackPos,CurrentlyPos);
            boolean verify = verifyCouples(BackPos,CurrentlyPos);
            if (verify){
                imageView[BackPos].setImageResource(Temp[BackPos]);
                iv.setImageResource(Temp[tag]);
                imageView[BackPos].setEnabled(false);
                iv.setEnabled(false);
                findedCouples++;

                if (findedCouples==couples){
                    Intent detailActivity = new Intent(MainActivity.this,DetailActivity.class);
                    Bundle bundle = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this).toBundle();
                    startActivity(detailActivity,bundle);
                    Toast.makeText(getApplicationContext(),"Lo lograste eres chido!!"
                            ,Toast.LENGTH_LONG).show();
                }
                txtcouples.setText(""+findedCouples);
            }else{
                imageView[BackPos].setImageResource(R.drawable.dbs);
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        iv.setImageResource(R.drawable.dbs);
                    }
                },500);
                imageView[BackPos].setEnabled(true);
                BackPos=0;
                CurrentlyPos=0;
            }
            BackPos=0;
            CurrentlyPos=0;
            clik=0;

        }

    }

}
