package com.example.quran;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;


public class Swr_Opener extends AppCompatActivity {
    PDFView mypdfviewer2;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swr_opener);
        mypdfviewer2=(PDFView)findViewById(R.id.pdfviewer);

        String getitem=getIntent().getStringExtra("SWR_NAMES");
        if (getitem.equals("سورة الفاتحة"))
        {
            mypdfviewer2.fromAsset("سورة الفاتحة .pdf").load();
        }
        if (getitem.equals("سورة البقرة"))
        {
            mypdfviewer2.fromAsset("سورة البقرة.pdf").load();
        }
        if (getitem.equals("سورة آل عمران"))
        {
            mypdfviewer2.fromAsset("سورة آل عمران.pdf").load();
        } if (getitem.equals("سورة النساء"))
        {
            mypdfviewer2.fromAsset("سورة النساء.pdf").load();
        }
        if (getitem.equals("سورة المائدة"))
        {
            mypdfviewer2.fromAsset("سورة المائدة.pdf").load();


        }
        if (getitem.equals("سورة الانعام"))
        {
            mypdfviewer2.fromAsset("سورة الانعام.pdf").load();


        }
        if (getitem.equals("سورة الاعراف"))
        {
            mypdfviewer2.fromAsset("سورة الاعراف.pdf").load();


        }
        if (getitem.equals("سورة الانفال"))
        {
            mypdfviewer2.fromAsset("سورة الانفال.pdf").load();


        }
        if (getitem.equals("سورة التوبة"))
        {
            mypdfviewer2.fromAsset("سورة التوبة.pdf").load();


        }
        if (getitem.equals("سورة يونس"))
        {
            mypdfviewer2.fromAsset("سورة يونس.pdf").load();


        }
        if (getitem.equals("سورة هود"))
        {
            mypdfviewer2.fromAsset("سورة هود.pdf").load();


        }
        if (getitem.equals("سورة يوسف"))
        {
            mypdfviewer2.fromAsset("سورة يوسف.pdf").load();


        }
        if (getitem.equals("سورة الرعد"))
        {
            mypdfviewer2.fromAsset("سورة الرعد.pdf").load();


        }
        if (getitem.equals("سورة ابراهيم"))
        {
            mypdfviewer2.fromAsset("سورة ابراهيم.pdf").load();


        }

        if (getitem.equals("سورة الاسراء"))
        {
            mypdfviewer2.fromAsset("سورة الاسراء .pdf").load();


        }

        if (getitem.equals("سورة النحل"))
        {
            mypdfviewer2.fromAsset("سورة النحل.pdf").load();


        }

        if (getitem.equals("سورة الكهف"))
        {
            mypdfviewer2.fromAsset("سورة الكهف.pdf").load();


        }

        if (getitem.equals("سورة مريم"))
        {
            mypdfviewer2.fromAsset("سورة مريم.pdf").load();


        }

        if (getitem.equals("سورة طه"))
        {
            mypdfviewer2.fromAsset("سورة طه.pdf").load();


        }

        if (getitem.equals("سورة الحجر"))
        {
            mypdfviewer2.fromAsset("سورة الحجر.pdf").load();


        }





    }
}