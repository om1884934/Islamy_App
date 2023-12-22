package com.example.quran;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class Swr_Activity extends AppCompatActivity {


    ListView pdflistview2;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swr);
            pdflistview2=(ListView)findViewById(R.id.surah_names);


        String[] SWR_NAMES={"سورة الفاتحة","سورة البقرة","سورة آل عمران",
                "سورة النساء","سورة المائدة","سورة الانعام","سورة الاعراف","سورة الانفال","سورة التوبة","سورة يونس","سورة هود", "سورة يوسف","سورة الرعد","سورة ابراهيم","سورة الحجر","سورة النحل","سورة الاسراء","سورة الكهف","سورة مريم","سورة طه"};
//Arrayadapter demand 3 things this,temp|ate,Array

        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,SWR_NAMES){

//Alt + insert   use override method


            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)

            {
                View view=super.getView(position, convertView, parent);

                TextView myText=(TextView) view.findViewById(android.R.id.text2);

                return view;
            }
        };

        pdflistview2.setAdapter(adapter);
        //Ready for just |ist showing
        //Ready



        pdflistview2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                String item=pdflistview2.getItemAtPosition(position).toString();

                Intent intent=new Intent(getApplicationContext(),Swr_Opener.class);
                intent.putExtra("SWR_NAMES",item);
                startActivity(intent);
            }
        });



    }

}

