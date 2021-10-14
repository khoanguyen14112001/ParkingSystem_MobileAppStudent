package nguyenhoanganhkhoa.com.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.chaos.view.PinView;

public class VerificationScreen extends AppCompatActivity {
    PinView pv;
    TextView txtErrorCode,txtResend;
    Button btnVerify, btnOK;
    ImageView imvComeback;

    private void linkView() {
        pv = findViewById(R.id.pvVerification);
        txtErrorCode = findViewById(R.id.txtErrorCode);
        btnVerify = findViewById(R.id.btnVerify);
        imvComeback = findViewById(R.id.imvComebackVerification);
        txtResend = findViewById(R.id.txtResend);

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verification_screen);

        linkView();
        addEvents();
    }


    private Boolean validateCode() {
        String s = pv.getText().toString();
        if(s.isEmpty() | s.length()<4)
        {
            txtErrorCode.setText(R.string.please_enter_four_numbers_of_code);
            txtErrorCode.setTextSize(15);
            return false;
        }

        return true;
    }



    private void addEvents() {

        txtResend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(VerificationScreen.this,"Code has been resent",Toast.LENGTH_SHORT);
            }
        });

        imvComeback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btnVerify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!validateCode())
                {
                    return;
                }

                else
                {
                    if (pv.getText().toString().equals("1234")) {
                        Intent intent = new Intent(VerificationScreen.this,CreateNewPasswordScreen.class);
                        startActivity(intent);
                    }
                    else
                    {
                        CustomDialog customDialog = new CustomDialog(VerificationScreen.this,R.layout.custom_dialog_verification);
                        customDialog.show();
                        txtErrorCode.setTextSize(0);
                    }
                }
            }
        });
    }


}