package com.example.pdfviewer;

import android.content.res.AssetManager;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.util.FitPolicy;
import com.tom_roush.pdfbox.multipdf.PDFMergerUtility;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    PDFView pdfView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pdfView = findViewById(R.id.pdfView);

        File file = null;
        try {
            file = combinePdf();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (file != null) {
            pdfView.fromFile(file)
                .spacing(5)
                .load();
        }
    }

    //Метод соединяет 2 pdf файла в 1
    private File combinePdf() throws IOException {
        PDFMergerUtility utility = new PDFMergerUtility();

        AssetManager manager = this.getAssets();

        utility.addSource(manager.open("pdf5pages.pdf"));
        utility.addSource(manager.open("pdf2pages.pdf"));

        final File file = new File(getExternalCacheDir(), System.currentTimeMillis() + ".pdf");
        final FileOutputStream fileOutputStream = new FileOutputStream(file);

        utility.setDestinationStream(fileOutputStream);
        utility.mergeDocuments(true);

        fileOutputStream.close();

        return file;
    }
}
