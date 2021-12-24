package nguyenhoanganhkhoa.com.myapplication.home;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import nguyenhoanganhkhoa.com.myapplication.R;
import nguyenhoanganhkhoa.com.thirdlink.AppUtil;
import nguyenhoanganhkhoa.com.thirdlink.ReusedConstraint;

public class QRCodeScreen extends AppCompatActivity {

    ImageView imvQRCodeScan, imvAvatarQRCode;
    TextView txtSecondUpdateQRCode, txtName, txtMoneyDisplay;
    View viewHoldImage;

    ReusedConstraint reusedConstraint = new ReusedConstraint(getApplicationContext());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrcode_screen);

        linkView();
        reusedConstraint.getDataFromFirebase(imvAvatarQRCode,txtName);
        displayBalanceFromFirebase();
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
        txtMoneyDisplay = findViewById(R.id.txtMoneyDisplay);
    }

    private void displayBalanceFromFirebase(){
        AppUtil.databaseReference.child(AppUtil.DATA_OBJECT).child(AppUtil.USERNAME_AFTER_LOGGIN)
                .addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        long balance = snapshot.child(AppUtil.FB_BALANCE).getValue(Long.class);
                        double balanceDisplay = Double.parseDouble(String.valueOf(balance));
                        txtMoneyDisplay.setText(reusedConstraint.formatCurrency(balanceDisplay));
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Log.d("Error", "Fail to load info in QRCode Screen" + error.toString());
                    }
                });
    }
}