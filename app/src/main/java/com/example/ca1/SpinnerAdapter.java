//package com.example.ca1;
//import android.annotation.SuppressLint;
//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.AdapterView;
//import android.widget.BaseAdapter;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.ResourceBundle;

//class SpinnerAdapter extends BaseAdapter
//{
//    private int selIndex;
//    //list to hold colors for spinners
//    List<String> colors1 = new ArrayList<>();
//    List<String> colors2 = new ArrayList<>();
//    List<String> colors3 = new ArrayList<>();
//    List<String> colors4 = new ArrayList<>();
//
//    //list to hold colors and do the logic of the calculate
//    List<Integer> colors1Codes = new ArrayList<>();
//    List<HashMap<String, Object>> colors3Codes = new ArrayList<>();
//    List<HashMap<String, Object>> colors4Codes = new ArrayList<>();
//
//    ArrayList<Integer> colors;
//    Context context;
//
//    public SpinnerAdapter(Context context)
//    {
//        this.context=context;
//        colors=new ArrayList<Integer>();
//        int retrieve []=context.getResources().getIntArray(R.array.androidcolors);
//        int texts []=context.getResources().getIntArray(R.array.planets_array);
//
//        for(int re:retrieve)
//        {
//            colors.add(re);
//        }
//    }
//    @Override
//    public int getCount()
//    {
//        return colors.size();
//    }
//    @Override
//    public Object getItem(int arg0)
//    {
//        return colors.get(arg0);
//    }
//
//    @Override
//    public long getItemId(int arg0)
//    {
//        return arg0;
//    }
//    @SuppressLint("ViewHolder")
//    @Override
//    public View getView(int pos, View view, ViewGroup parent)
//    {
//        LayoutInflater inflater=LayoutInflater.from(context);
//        view=inflater.inflate(android.R.layout.simple_spinner_dropdown_item, null);
//        TextView txv=(TextView)view.findViewById(android.R.id.text1);
//
//        txv.setBackgroundColor(colors.get(pos));
//        txv.setTextSize(22f);
//        txv.setText("Text "+pos);
//
//
//        return view;
//    }
//
//    public void setSelectedIndex(int selIndex){
//        this.selIndex = selIndex;
//    }

//
//}
