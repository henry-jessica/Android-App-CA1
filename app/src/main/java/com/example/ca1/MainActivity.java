package com.example.ca1;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.SpinnerAdapter;
import android.widget.TextView;


import com.example.ca1.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding context;
    //list to hold colors for spinners
    List<String> colors1 = new ArrayList<>();
    List<String> colors2 = new ArrayList<>();
    List<String> colors3 = new ArrayList<>();
    List<String> colors4 = new ArrayList<>();

    //list to hold colors and do the logic of the calculate
    List<Integer> colors1Codes = new ArrayList<>();
    List<Integer> colors2Codes = new ArrayList<>();
    List<HashMap<String, Object>> colors3Codes = new ArrayList<>();
    List<HashMap<String, Object>> colors4Codes = new ArrayList<>();

    //hold calculation variables
    double calcule = 0;
    int currentband1 = 0;
    int currentband2 = 0;
    double currentband3 = 1;
    String tolerance = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        doSpinner();
    }

    private void doSpinner(){
        context = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(context.getRoot());
        colors1.add("Black");
        colors1Codes.add(Color.BLACK);
        colors1.add("Brown");
        colors1Codes.add(0xFF512627);
        colors1.add("Red");
        colors1Codes.add(Color.parseColor("#CC0000"));
        colors1.add("Orange");
        colors1Codes.add(Color.parseColor("#D87347"));
        colors1.add("Yellow");
        colors1Codes.add(Color.parseColor("#E6C951"));
        colors1.add("Green");
        colors1Codes.add(Color.parseColor("#528F65"));
        colors1.add("Blue");
        colors1Codes.add(Color.parseColor("#0F5190"));
        colors1.add("Violet");
        colors1Codes.add(Color.parseColor("#7B52AB"));
        colors1.add("Grey");
        colors1Codes.add(Color.parseColor("#7D7D7D"));
        colors1.add("White");
        colors1Codes.add(Color.WHITE);
        colors2.add("Black");
        colors2Codes.add(Color.BLACK);
        colors2.add("Brown");
        colors2Codes.add(0xFF512627);
        colors2.add("Red");
        colors2Codes.add(Color.parseColor("#CC0000"));
        colors2.add("Orange");
        colors2Codes.add(Color.parseColor("#D87347"));
        colors2.add("Yellow");
        colors2Codes.add(Color.parseColor("#E6C951"));
        colors2.add("Green");
        colors2Codes.add(Color.parseColor("#528F65"));
        colors2.add("Blue");
        colors2Codes.add(Color.parseColor("#0F5190"));
        colors2.add("Violet");
        colors2Codes.add(Color.parseColor("#7B52AB"));
        colors2.add("Grey");
        colors2Codes.add(Color.parseColor("#7D7D7D"));
        colors2.add("White");
        colors2Codes.add(Color.parseColor("#FFFFFF"));
        colors3.add("Black");
        putValue(colors3Codes, Color.BLACK, "×1 Ω");
        colors3.add("Brown");
        putValue(colors3Codes, Color.parseColor("#502627"), "×10 Ω");
        colors3.add("Red");
        putValue(colors3Codes, Color.parseColor("#CC0100"), "×100 Ω");
        colors3.add("Orange");
        putValue(colors3Codes, Color.parseColor("#FB6542"), "×1K Ω");
        colors3.add("Yellow");
        putValue(colors3Codes, Color.parseColor("#E6C951"), "×10K Ω");
        colors3.add("Green");
        putValue(colors3Codes, Color.parseColor("#528F65"), "×100K Ω");
        colors3.add("Blue");
        putValue(colors3Codes, Color.parseColor("#0F5190"), "×1M Ω");
        colors3.add("Violet");
        putValue(colors3Codes, Color.parseColor("#7B52AB"), "×10M Ω");
        colors3.add("Grey");
        putValue(colors3Codes, Color.parseColor("#7D7D7D"), "×100M Ω");
        colors3.add("White");
        putValue(colors3Codes, Color.parseColor("#FFFFFF"), "×1B Ω");
        colors3.add("Gold");
        putValue(colors3Codes,  Color.parseColor("#C08327"), "×0.1 Ω");
        colors3.add("Silver");
        putValue(colors3Codes, Color.parseColor("#BFBEBF"), "×0.01 Ω");
        colors4.add("Black");
        putValue(colors4Codes, Color.BLACK, "±20%");
        colors4.add("Brown");
        putValue(colors4Codes, Color.parseColor("#502627"), "±1%");
        colors4.add("Red");
        putValue(colors4Codes, Color.parseColor("#CC0100"), "±2%");
        colors4.add("Green");
        putValue(colors4Codes, Color.parseColor("#528F65"), "±0.5%");
        colors4.add("Blue");
        putValue(colors4Codes, Color.parseColor("#0F5190"), "±0.25%");
        colors4.add("Violet");
        putValue(colors4Codes, Color.parseColor("#7B52AB"), "±0.1%");
        colors4.add("Grey");
        putValue(colors4Codes, Color.parseColor("#7D7D7D"), "±0.05%");
        colors4.add("Gold");
        putValue(colors4Codes, Color.parseColor("#C08327"), "±5%");
        colors4.add("Silver");
        putValue(colors4Codes, Color.parseColor("#BFBEBF"), "±10%");
        context.spband1.setAdapter(getAdapter(colors1, colors1Codes));
        context.spband1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                context.spband1.setBackgroundColor(colors1Codes.get(i));

                if(colors1Codes.get(i) == Color.WHITE) {
                    ((TextView) adapterView.findViewById(R.id.text)).setTextColor(Color.BLACK);
                }

                View imageviewcolor = findViewById(R.id.first_color);
                imageviewcolor.setBackgroundColor(colors1Codes.get(i));

                currentband1 = (int)l;
                calculeResistor();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        context.spband2.setAdapter(getAdapter(colors2, colors2Codes));
        context.spband2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                context.spband2.setBackgroundColor(colors2Codes.get(i));

                if(colors1Codes.get(i) == Color.WHITE) {
                    ((TextView) adapterView.findViewById(R.id.text)).setTextColor(Color.BLACK);
                }
                View imageviewcolor = findViewById(R.id.second_color);
                imageviewcolor.setBackgroundColor(colors2Codes.get(i));
                currentband2 = (int)l;
                calculeResistor();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        context.spband3.setAdapter(getAdapterL(colors3, colors3Codes));
        context.spband3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                context.spband3.setBackgroundColor((Integer) colors3Codes.get(i).get("code"));
                View imageviewcolor = findViewById(R.id.third_color);
                imageviewcolor.setBackgroundColor((Integer) colors3Codes.get(i).get("code"));

                if((Integer) colors3Codes.get(i).get("code") == Color.WHITE) {
                    ((TextView) adapterView.findViewById(R.id.text)).setTextColor(Color.BLACK);
                }

                if((int)l==10){
                    currentband3 = 0.1;
                }
                else if((l)==11){
                    currentband3 = 0.01;
                }else{
                    currentband3 = (int)(Math.pow(10,(int)l));
                }
                calculeResistor();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        context.spband4.setAdapter(getAdapterL(colors4, colors4Codes));
        context.spband4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                context.spband4.setBackgroundColor((Integer) colors4Codes.get(i).get("code"));
                View imageviewcolor = findViewById(R.id.fourth_color);
                imageviewcolor.setBackgroundColor((Integer) colors4Codes.get(i).get("code"));

                tolerance  = ( " " + colors4Codes.get(context.spband4.getSelectedItemPosition()).get("value"));
                calculeResistor();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }


    private void calculeResistor() {
        TextView cal = findViewById(R.id.tvresult);
        // Calculate

            calcule = (currentband1*10 + currentband2)*currentband3;

       // Better way to display the calculate
        if(calcule>=1000 && calcule <1000000 && (currentband1!=0 || currentband2!=0) ){
            cal.setText(" "+ calcule/1000+ " K Ω" + tolerance);
        }
        else if(calcule>=1000000 && calcule < 1000000000){
            cal.setText(" "+ calcule/1000000+ " M Ω" + tolerance);
        }
        else if(calcule>=1000000000){
            cal.setText(" "+ calcule/1000000000+ " B Ω" + tolerance );
        }
        else if(calcule < 1){
            cal.setText(String.format("%.2f",(currentband1*10 + currentband2)*currentband3 ) + " " + tolerance );
        }
        else{
            cal.setText(" "+ calcule +"  Ω " + tolerance);
        }
    }

    private void putValue(List<HashMap<String, Object>> list, int code, String value) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("code", code);
        hashMap.put("value", value);
        list.add(hashMap);
    }

    private ArrayAdapter<String> getAdapterL(List<String> list, List<HashMap<String, Object>> codes) {
        return new ArrayAdapter<String>(this,
                R.layout.spinner_custom, R.id.text, list) {
            @Override
            public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                View v = null;
                v = super.getDropDownView(position, convertView, parent);
                CardView cardView = Objects.requireNonNull(v).findViewById(R.id.card);
                TextView text = Objects.requireNonNull(v).findViewById(R.id.text);

                text.setText(list.get(position) + "               " + codes.get(position).get("value"));
                cardView.setCardBackgroundColor((Integer) codes.get(position).get("code"));

                if( (Integer) codes.get(position).get("code") == Color.WHITE) {
                    TextView text1 = Objects.requireNonNull(v).findViewById(R.id.text);
                    text1.setTextColor(Color.BLACK);
                }
                return v;
            }
        };
    }
    private ArrayAdapter<String> getAdapter(List<String> list, List<Integer> codes) {
        return new ArrayAdapter<String>(this,
                R.layout.spinner_custom, R.id.text, list) {
            @Override
            public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

                View v = null;
                v = super.getDropDownView(position, convertView, parent);
                CardView cardView = Objects.requireNonNull(v).findViewById(R.id.card);
                TextView text = Objects.requireNonNull(v).findViewById(R.id.text);
                cardView.setCardBackgroundColor(codes.get(position));

                if(codes.get(position)== Color.WHITE) {
                    TextView text1 = Objects.requireNonNull(v).findViewById(R.id.text);
                    text1.setTextColor(Color.BLACK);
                }
                return v;
            }
        };
    }

    public void doreset(View view) {
        context.spband1.setAdapter(getAdapter(colors1, colors1Codes));
        context.spband2.setAdapter(getAdapter(colors2, colors2Codes));
        context.spband3.setAdapter(getAdapterL(colors3, colors3Codes));
        context.spband4.setAdapter(getAdapterL(colors4, colors4Codes));
        }
}

//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        Spinner spinner = (Spinner) findViewById(R.id.spinner);
//// Create an ArrayAdapter using the string array and a default spinner layout
//        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
//                R.array.planets_array, android.R.layout.simple_spinner_item);
//
//// Specify the layout to use when the list of choices appears
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//// Apply the adapter to the spinner
//        spinner.setAdapter(adapter);
//        spinner.setOnItemSelectedListener(this);
//        super.onCreate(savedInstanceState);
//        context = ActivityMainBinding.inflate(getLayoutInflater());
//        setContentView(context.getRoot());
//        setContentView(R.layout.activity_main);
//        spnColors=(Spinner)findViewById(spband1);
//        spnColors.setAdapter(new SpinnerAdapter(this));
//        context.colors1.setAdapter(getAdapter(colors1, colors1Codes));
//        context.colors1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//                context.colors1.setBackgroundColor(colors1Codes.get(i));
//            }
//            @Override
//            public void onNothingSelected(AdapterView<?> adapterView) {
//            }
//        });
//    }
// }
//    @Override
//    public void onItemSelected(AdapterView<?> parent, View view,
//                               int pos, long id) {
//        String text = parent.getItemAtPosition(pos).toString();
//        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
//    }
//
//    @Override
//    public void onNothingSelected(AdapterView<?> adapterView) {
//
//    }
//
//    @Override
//    public void onItemSelected(AdapterView<?> parent, View view,
//                               int pos, long id) {
//        String text = parent.getItemAtPosition(pos).toString();
//        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
//    }
//
//    @Override
//    public void onNothingSelected(AdapterView<?> adapterView) {
//
//    }
//public class MainActivity extends AppCompatActivity  implements AdapterView.OnItemSelectedListener {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        Spinner spinner = (Spinner) findViewById(R.id.spinner);
//// Create an ArrayAdapter using the string array and a default spinner layout
//        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
//                R.array.planets_array, android.R.layout.simple_spinner_item);
//
//// Specify the layout to use when the list of choices appears
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//// Apply the adapter to the spinner
//        spinner.setAdapter(adapter);
//        spinner.setOnItemSelectedListener(this);
//    }
//
//    @Override
//    public void onItemSelected(AdapterView<?> parent, View view,
//                               int pos, long id) {
//        String text = parent.getItemAtPosition(pos).toString();
//        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
//    }
//
//    @Override
//    public void onNothingSelected(AdapterView<?> adapterView) {
//
//    }
//