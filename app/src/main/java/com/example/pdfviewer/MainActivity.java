package com.example.pdfviewer;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.util.FitPolicy;

public class MainActivity extends AppCompatActivity {
    PDFView pdfView;
    PDFView pdfView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pdfView = findViewById(R.id.pdfView);
        pdfView2 = findViewById(R.id.pdfView2);

        pdfView.fromAsset("pdf5pages.pdf")
            .pages(0)
            .pageFitPolicy(FitPolicy.HEIGHT)
            .load();

        pdfView2.fromAsset("pdf2pages.pdf").pages(0)
            .pageFitPolicy(FitPolicy.HEIGHT)
            .load();

//        File file = null;
//        try {
//            file = combinePdf();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        if (file != null){
//            pdfView.fromFile(file).load();
//        }

    }

//    private File combinePdf() throws IOException {
//        PDFMergerUtility utility = new PDFMergerUtility();
//
//        AssetManager manager = this.getAssets();
//
//        utility.addSource(manager.open("pdf5pages.pdf"));
//        utility.addSource(manager.open("pdf2pages.pdf"));
//
//        final File file = new File(getExternalCacheDir(), System.currentTimeMillis() + ".pdf");
//        final FileOutputStream fileOutputStream = new FileOutputStream(file);
//
//        try {
//            utility.setDestinationStream(fileOutputStream);
//            utility.mergeDocuments(MemoryUsageSetting.setupTempFileOnly());
//        } finally {
//            fileOutputStream.close();
//        }
//
//        return file;
//    }
}
