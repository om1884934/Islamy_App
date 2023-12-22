package com.example.quran;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.quran.duaa_opener;

public class Duaa_Activity extends AppCompatActivity {
    ListView pdflistview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_duaa);



        pdflistview=(ListView)findViewById(R.id.duaa_names);


        String[] DUAA_NAMES={"الاستعاذة من الفتن","الجنة و النار","الدعاء للوالدين و الاهل و الذرية",
                "توسلات يبدي الداعي سؤاله","سؤال الله الحفظ و النصرة","سؤال الله العفو و العافية","سؤال الله المغفرة و الرحمة","سؤال الله الهداية و الرشد","سؤال الله خيري الدنيا و الاخرة","سؤال الله صلاح الدنيا و الحال","سؤال الله صلاح الدين و صلاح الاخرة"};
//Arrayadapter demand 3 things this,temp|ate,Array

        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,DUAA_NAMES){

//Alt + insert   use override method


            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)

            {
                View view=super.getView(position, convertView, parent);

                TextView myText=(TextView) view.findViewById(android.R.id.text1);

                return view;
            }
        };

        pdflistview.setAdapter(adapter);
        //Ready for just |ist showing
        //Ready



        pdflistview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                String item=pdflistview.getItemAtPosition(position).toString();

                Intent intent=new Intent(getApplicationContext(), duaa_opener.class);
                intent.putExtra("DUAA_NAMES",item);
                startActivity(intent);
            }
        });



    }
}