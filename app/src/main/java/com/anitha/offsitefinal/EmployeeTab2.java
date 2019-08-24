package com.anitha.offsitefinal;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.icu.text.DecimalFormat;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.squareup.timessquare.CalendarPickerView;

import java.util.ArrayList;

import me.anwarshahriar.calligrapher.Calligrapher;

/**
 * Created by Belal on 2/3/2016.
 */

//Our class extending fragment
public class EmployeeTab2 extends Fragment {

    Button btn_popup;
    Button btn_cal_from, btn_cal_to;
    TextView txt_cal_from, txt_cal_to;
    DatePickerDialog datePickerDialog;
    ImageView img_menu, img_profile;

    //  Context mContext
    ImageButton cal_range;

    int year;
    int month;
    int dayOfMonth;
    TextView txt_cal_view;
    ListView list;


    CalendarPickerView calendar;
    TextView selected_dates;
    Dialog myDialog;

    private String[] xValues1 = {"Visited", "Missed"};
    PieChart mChart_visits;
    private LinearLayout linearLayout;
    Context thiscontext;



    //Overriden method onCreateView
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //Returning the layout file after inflating
        //Change R.layout.tab1 in you classes
        View  v=inflater.inflate(R.layout.emp_tab2, container, false);



        Calligrapher calligrapher=new Calligrapher(getActivity());
        calligrapher.setFont(getActivity(),"arial.ttf",true);




        btn_popup = (Button) v.findViewById(R.id.menu_popup);


        btn_popup.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                /*//Creating the instance of PopupMenu
                PopupMenu popup = new PopupMenu(getActivity(), btn_popup);
                //Inflating the Popup using xml file
                popup.getMenuInflater().inflate(R.menu.poupup_menu1, popup.getMenu());

                //registering popup with OnMenuItemClickListener
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
                        Toast.makeText(getActivity(), "You Clicked : " + item.getTitle(), Toast.LENGTH_SHORT).show();
                        return true;
                    }
                });

                popup.show();//showing popup menu*/

                Intent i = new Intent(getContext(), Employee_Report.class);
                startActivity(i);
            }
        });//closing the setOnClickListener method






        mChart_visits = (PieChart) v.findViewById(R.id.piechart_visits);


        ArrayList<Entry> entries = new ArrayList<>();
        entries.add(new Entry(70, 0));
        entries.add(new Entry(30, 0));


        PieDataSet dataSet = new PieDataSet(entries, "");
        PieData data = new PieData(xValues1, dataSet);
        data.setValueFormatter(new DecimalRemover(new DecimalFormat("###,###,###")));


        dataSet.setColors(new int[]{Color.rgb(45,96,115), Color.rgb(70,147,177), Color.rgb(64,199,218), Color.rgb(168,199,219)});

        //dataSet.setColors(new int[]{Color.rgb(255,153,255), Color.rgb(46,134,95)});
        //  dataSet.setSliceSpace(2f);
        dataSet.setValueTextColor(Color.WHITE);
        dataSet.setValueTextSize(10f);


        //  dataSet.setDrawValues(true);

        mChart_visits.setUsePercentValues(true);
        mChart_visits.setDrawHoleEnabled(false);
        mChart_visits.setData(data);
        mChart_visits.invalidate();
        mChart_visits.setDescription("");
        mChart_visits.setDrawSliceText(false); // To remove slice text





        return v;

    }




}
