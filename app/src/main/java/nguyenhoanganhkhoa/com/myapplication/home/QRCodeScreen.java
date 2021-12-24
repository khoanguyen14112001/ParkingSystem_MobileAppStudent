package nguyenhoanganhkhoa.com.myapplication.home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import nguyenhoanganhkhoa.com.myapplication.R;
import nguyenhoanganhkhoa.com.thirdlink.ReusedConstraint;

public class QRCodeScreen extends AppCompatActivity {

    ImageView imvQRCodeScan, imvAvatarQRCode;
    TextView txtSecondUpdateQRCode, txtName;
    View viewHoldImage;

    ReusedConstraint reusedConstraint = new ReusedConstraint(QRCodeScreen.this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrcode_screen);

        linkView();
        reusedConstraint.getDataFromFirebase(imvAvatarQRCode,txtName);
        addEvents();

    }

    private void addEvents() {
        reusedConstraint.addTimer(txtSecondUpdateQRCode,45000);
        viewHoldImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(QRCodeScreen.this,TopUpMainScreen.class);
                startActivity(intent);
            }
        });


        imvQRCodeScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void linkView() {
        imvQRCodeScan = findViewById(R.id.imvQRCodeScan);
        txtSecondUpdateQRCode= findViewById(R.id.txtSecondUpdateQRCode);
        viewHoldImage = findViewById(R.id.viewHoldImage);
        imvAvatarQRCode = findViewById(R.id.imvAvatarQRCode);
        txtName = findViewById(R.id.txtName);
    }
}