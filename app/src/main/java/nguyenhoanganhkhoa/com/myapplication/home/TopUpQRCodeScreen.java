package nguyenhoanganhkhoa.com.myapplication.home;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import nguyenhoanganhkhoa.com.myapplication.R;

public class TopUpQRCodeScreen extends AppCompatActivity {
    ImageView imvBackTopUp2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_up_qrcode_screen);
        linkView();
        addEvents();
    }

    private void addEvents() {
        imvBackTopUp2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void linkView() {
        imvBackTopUp2 = findViewById(R.id.imvBackTopUp2);
    }
}