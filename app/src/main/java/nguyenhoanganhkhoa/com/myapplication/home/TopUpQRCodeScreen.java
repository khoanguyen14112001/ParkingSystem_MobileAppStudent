package nguyenhoanganhkhoa.com.myapplication.home;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import nguyenhoanganhkhoa.com.myapplication.R;
import nguyenhoanganhkhoa.com.myapplication.signup.VerificationSignupScreen;
import nguyenhoanganhkhoa.com.thirdlink.ReusedConstraint;

public class TopUpQRCodeScreen extends AppCompatActivity {
    ImageView imvBackTopUp2;
    TextView txtTimeMomo;

    ReusedConstraint reusedConstraint = new ReusedConstraint(TopUpQRCodeScreen.this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_up_qrcode_screen);
        linkView();
        addEvents();
    }

    private void addEvents() {
        reusedConstraint.addTimer(txtTimeMomo,240000);

        imvBackTopUp2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

    private void linkView() {
        imvBackTopUp2 = findViewById(R.id.imvBackTopUp2);
        txtTimeMomo = findViewById(R.id.txtTimeMomo);
    }
}