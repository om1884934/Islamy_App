package com.example.quran;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;


public class duaa_opener extends AppCompatActivity {
    PDFView mypdfviewer;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_duaa_opener);
        mypdfviewer=(PDFView)findViewById(R.id.pdfviewer2);

        String getitem=getIntent().getStringExtra("DUAA_NAMES");
        if (getitem.equals("الاستعاذة من الفتن"))
        {
            mypdfviewer.fromAsset("الاستعاذة من الفتن.pdf").load();
        }
        if (getitem.equals("الجنة و النار"))
        {
            mypdfviewer.fromAsset("الجنة و النار.pdf").load();
        }
        if (getitem.equals("الدعاء للوالدين و الاهل و الذرية"))
        {
            mypdfviewer.fromAsset("الدعاء للوالدين و الاهل و الذرية.pdf").load();
        } if (getitem.equals("توسلات يبدي الداعي سؤاله"))
        {
            mypdfviewer.fromAsset("توسلات يبدي الداعي سؤاله.pdf").load();
        }
        if (getitem.equals("سؤال الله الحفظ و النصرة"))
        {
            mypdfviewer.fromAsset("سؤال الله الحفظ و النصرة.pdf").load();


        }
        if (getitem.equals("سؤال الله العفو و العافية"))
        {
            mypdfviewer.fromAsset("سؤال الله العفو و العافية.pdf").load();


        }
        if (getitem.equals("سؤال الله الهداية و الرشد"))
        {
            mypdfviewer.fromAsset("سؤال الله الهداية و الرشد.pdf").load();


        }
        if (getitem.equals("سؤال الله خيري الدنيا و الاخرة"))
        {
            mypdfviewer.fromAsset("سؤال الله خيري الدنيا و الاخرة.pdf").load();


        }
        if (getitem.equals("سؤال الله صلاح الدنيا و الحال"))
        {
            mypdfviewer.fromAsset("سؤال الله صلاح الدنيا و الحال.pdf").load();


        }
        if (getitem.equals("سؤال الله صلاح الدين و صلاح الاخرة"))
        {
            mypdfviewer.fromAsset("سؤال الله صلاح الدين و صلاح الاخرة.pdf").load();


        }

        if (getitem.equals("سؤال الله المغفرة و الرحمة"))
        {
            mypdfviewer.fromAsset("سؤال الله المغفرة و الرحمة.pdf").load();


        }

    }
}
