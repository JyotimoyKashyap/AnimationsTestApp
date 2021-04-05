package com.jyotimoykashyap.splashscreenanimation;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.BounceInterpolator;
import android.widget.TextView;

import com.google.android.material.card.MaterialCardView;

public class MainActivity extends AppCompatActivity {

    private MaterialCardView card1, card2, logoCard;
    private TextView titleTv, subtitleTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /** Defining the hooks */
        card1 = findViewById(R.id.card_1);
        card2 = findViewById(R.id.card_2);
        logoCard = findViewById(R.id.logo_card);
        titleTv = findViewById(R.id.title_tv);
        subtitleTv = findViewById(R.id.subtitle_tv);


        /** Property values animator for scale animation */
        PropertyValuesHolder scaleX = PropertyValuesHolder.ofFloat(View.SCALE_X, 2.5f);
        PropertyValuesHolder scaleY = PropertyValuesHolder.ofFloat(View.SCALE_Y, 2.5f);

        /** Object animator set up for the logo card animation */
        ObjectAnimator animator = ObjectAnimator.ofPropertyValuesHolder(logoCard, scaleX, scaleY);
        animator.setDuration(400);
        animator.setInterpolator(new AnticipateOvershootInterpolator());

        /** Object animator set up for the card1 animation */
        ObjectAnimator animator1 = ObjectAnimator.ofPropertyValuesHolder(card1, scaleX, scaleY);
        animator1.setDuration(500);
        animator1.setStartDelay(300);
        animator1.setInterpolator(new AnticipateOvershootInterpolator());


        /** Object animator set up for the card1 animation */
        ObjectAnimator animator2 = ObjectAnimator.ofPropertyValuesHolder(card2, scaleX, scaleY);
        animator2.setDuration(400);
        animator2.setRepeatCount(1);
        animator2.setRepeatMode(ObjectAnimator.REVERSE);
        animator2.setStartDelay(200);

        /** Object animator set up for the text view fading animation animation */
        ObjectAnimator animator3 = ObjectAnimator.ofFloat(titleTv, View.ALPHA, 1f);
        animator3.setDuration(500);
        animator3.setStartDelay(100);

        /** Object animator set up for the text view fading animation animation */
        ObjectAnimator animator4 = ObjectAnimator.ofFloat(subtitleTv, View.ALPHA, 1f);
        animator4.setDuration(500);
        animator4.setStartDelay(100);

        /** Object animator set up for the text view fading animation animation */
        ObjectAnimator animator5 = ObjectAnimator.ofFloat(subtitleTv, View.TRANSLATION_Y, 400f, 1f);
        animator4.setDuration(500);
        animator4.setStartDelay(100);



        /** Animator set to play them together or to play them sequentially */
        AnimatorSet set = new AnimatorSet();
        set.playTogether(animator, animator1, animator2, animator3, animator4, animator5);
        set.setDuration(1000);


        /** Just playing this after a time of 1 sec for testing purpose */
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                set.start();
            }
        }, 500);



    }
}