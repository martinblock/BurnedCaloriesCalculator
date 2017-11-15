package com.example.martin.burnedcaloriescalculator;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.view.View.OnClickListener;
import android.content.SharedPreferences.Editor;
import android.widget.Toast;
import android.widget.RadioGroup.OnCheckedChangeListener;
import java.text.NumberFormat;
import android.widget.SeekBar.OnSeekBarChangeListener;


public class MainActivity extends AppCompatActivity implements OnEditorActionListener, OnKeyListener, OnSeekBarChangeListener{

    // define member variables for widgets
    private EditText weight;
    private TextView milesTV;
    private TextView caloriesBurned;
    private EditText bmi;
    private SeekBar milesSeekbar;
    private Spinner feetSpinner;
    private Spinner inchesSpinner;
    private String personWeight;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //get reference to the widgets
        weight = (EditText) findViewById(R.id.weightET);
        caloriesBurned = (TextView) findViewById(R.id.caloriesBurned);
        bmi = (EditText) findViewById(R.id.bmiET);
        milesSeekbar = (SeekBar) findViewById(R.id.milesSB);
        feetSpinner = (Spinner) findViewById(R.id.feetSpinner);
        inchesSpinner = (Spinner) findViewById(R.id.inchesSpinner);
        milesTV = (TextView) findViewById(R.id.milesTV);

        //set the seekbar to onProgressChange
        milesSeekbar.setOnSeekBarChangeListener(this);

        // sett array adapter  for spinner
       Integer[] feetItems = new Integer[]{4,5,6,7};
        ArrayAdapter<Integer> adapter = new ArrayAdapter<Integer>(this,android.R.layout.simple_spinner_item,feetItems);
        feetSpinner.setAdapter(adapter);

        Integer[] inchesItems = new Integer[]{1,2,3,4,5,6,7,8,9,10,11};
        ArrayAdapter<Integer> adapter2 = new ArrayAdapter<Integer>(this,android.R.layout.simple_spinner_item,inchesItems);
        inchesSpinner.setAdapter(adapter2);



    }

    @Override
    public boolean onKey(View v, int keyCode, KeyEvent event) {
        return false;
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        milesTV.setText(progress + (" Ran"));

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        int progress = milesSeekbar.getProgress();
         int miles = progress ;


    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        int progress = seekBar.getProgress();
        int milesRan = progress;

    }

    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        return false;
    }
    private void calculateAndDisplay(){
        String totalMiles = milesTV.getText().toString();
        double finalMiles = Double.parseDouble(totalMiles);




        personWeight = weight.getText().toString();
        double w = Double.parseDouble(personWeight);

        double totalCaloriesBurned = w*.75*finalMiles;


        caloriesBurned.setText((int) totalCaloriesBurned);

    }
}
