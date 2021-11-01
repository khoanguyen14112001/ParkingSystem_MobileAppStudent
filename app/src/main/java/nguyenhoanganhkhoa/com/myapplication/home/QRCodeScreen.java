package nguyenhoanganhkhoa.com.myapplication.home;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import nguyenhoanganhkhoa.com.myapplication.R;

public class QRCodeScreen extends AppCompatActivity {

    ImageView imvQRCodeScan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrcode_screen);

        linkView();
        addEvents();

    }

    private void addEvents() {
        imvQRCodeScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void linkView() {
        imvQRCodeScan = findViewById(R.id.imvQRCodeScan);
    }
}