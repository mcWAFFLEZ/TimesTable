package com.example.timestable;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

import static java.util.Arrays.asList;

public class MainActivity extends AppCompatActivity {

    ListView numberListView;

    public void numberArrayListMaker(int progress){

        final ArrayList<Integer> numbersArray = new ArrayList<Integer>();

        for(int i = 1; i <= 100; i++ ){
            numbersArray.add(i * (progress + 1));
        }

        final ArrayAdapter<Integer> myArrayAdapter = new ArrayAdapter<Integer>(this , android.R.layout.simple_list_item_1, numbersArray);

        numberListView.setAdapter(myArrayAdapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SeekBar numberSeekBar = (SeekBar) findViewById(R.id.numberSeekBar);

        numberSeekBar.setMax(9);
        numberSeekBar.setProgress(0);

        numberListView = (ListView) findViewById(R.id.numberListView);

        numberArrayListMaker(numberSeekBar.getProgress());

        numberSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                numberArrayListMaker(progress);

                Log.i("numberSeekBarValue", Integer.toString(progress + 1));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
