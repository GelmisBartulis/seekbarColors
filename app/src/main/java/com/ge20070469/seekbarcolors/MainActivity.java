package com.ge20070469.seekbarcolors;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView one, two, three, main;
    private int seekR, seekG, seekB;
    private SeekBar redSeekBar, greenSeekBar, blueSeekBar;
    private LinearLayout mScreen;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mScreen = findViewById(R.id.myScreen);
        redSeekBar = findViewById(R.id.mySeekingBar_R);
        greenSeekBar = findViewById(R.id.mySeekingBar_G);
        blueSeekBar = findViewById(R.id.mySeekingBar_B);
        one = findViewById(R.id.one);
        two = findViewById(R.id.two);
        three = findViewById(R.id.three);
        main = findViewById(R.id.main);
        updateBackground();

        redSeekBar.setOnSeekBarChangeListener(seekBarChangeListener);
        greenSeekBar.setOnSeekBarChangeListener(seekBarChangeListener);
        blueSeekBar.setOnSeekBarChangeListener(seekBarChangeListener);
    }

    private SeekBar.OnSeekBarChangeListener seekBarChangeListener
            = new SeekBar.OnSeekBarChangeListener()
    {

        @Override
        public void onProgressChanged(SeekBar seekBar, int progress,
                                      boolean fromUser) {
            updateBackground();
        }
        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {
// TODO Auto-generated method stub
        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
// TODO Auto-generated method stub
        }
    };

    private void updateBackground() {
        seekR = redSeekBar.getProgress();
        one.setText(redSeekBar.getProgress() + " ");
        one.setTextColor(0xff000000
                + seekR * 0x10000);


        seekG = greenSeekBar.getProgress();
        two.setText(greenSeekBar.getProgress() + " ");
        two.setTextColor(0xff000000
                + seekG * 0x100);


        seekB = blueSeekBar.getProgress();
        three.setText(blueSeekBar.getProgress() + " " );
        three.setTextColor(0xff000000 + seekB);

        main.setBackgroundColor(
                0xff000000
                        + seekR * 0x10000
                        + seekG * 0x100
                        + seekB
        );


    }


}
