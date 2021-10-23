package nguyenhoanganhkhoa.com.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.chaos.view.PinView;

import nguyenhoanganhkhoa.com.thirdlink.AppUtil;

public class VerificationScreen extends AppCompatActivity {
    PinView pv;
    TextView txtErrorCode,txtResend,txtVerificationText;
    Button btnVerify, btnOK;
    ImageView imvComeback;

    private void linkView() {
        pv = findViewById(R.id.pvVerification);
        txtErrorCode = findViewById(R.id.txtErrorCode);
        btnVerify = findViewById(R.id.btnVerify);
        imvComeback = findViewById(R.id.imvComebackVerification);
        txtResend = findViewById(R.id.txtResend);
        txtVerificationText= findViewById(R.id.txtVerificationCode);


    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verification_screen);

        linkView();
        addTimer();
        addEvents();
    }
    int time = 30000;

    private void addTimer() {


        new CountDownTimer(time, 10) { //Set Timer for 5 seconds
            public void onTick(long millisUntilFinished) {

                long remainedSecs = millisUntilFinished / 1000;
                long secondLeft = remainedSecs % 60;
                txtVerificationText.setText(getString(R.string.we_sent_your_code_to_your_phone) +
                        getString(R.string.this_code_will_be_expired_in)+
                        (remainedSecs % 60) +
                        getString(R.string.seconds));

                // Set color seconds

                String textVerifcation = txtVerificationText.getText().toString();
                SpannableString ss = new SpannableString(textVerifcation) ;

                ForegroundColorSpan fcsYellow = new ForegroundColorSpan(getColor(R.color.primary_yellow));

                ss.setSpan(fcsYellow,62,64, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                txtVerificationText.setText(ss);

                txtResend.setEnabled(false);
            }


            @Override
            public void onFinish() {
                txtVerificationText.setText(getString(R.string.we_have_not_received_your_code_yet) +
                        getString(R.string.to_do_it_again_click_resend_below));
                txtResend.setEnabled(true);

            }
        }.start();
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


    int attempt = 0;

    private void addEvents() {

        txtResend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addTimer();
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
                        Intent intent = new Intent(VerificationScreen.this, CreateNewPasswordScreen.class);
                        startActivity(intent);
                    }
                    else if(attempt==5)
                    {
                        String keyValue = "key";
                        AppUtil.eMessage=keyValue;
                        CustomDialog customDialog = new CustomDialog(VerificationScreen.this,R.layout.custom_dialog_verification_2);
                        customDialog.btnOK.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Intent intent = new Intent(VerificationScreen.this, ResetPasswordScreen.class);
                                startActivity(intent);
                            }
                        });
                        customDialog.show();



                    }
                    else
                    {
                        CustomDialog customDialog = new CustomDialog(VerificationScreen.this,R.layout.custom_dialog_verification);
                        customDialog.btnOK.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                customDialog.dismiss();
                            }
                        });
                        customDialog.show();
                        txtErrorCode.setTextSize(0);
                        attempt++;
                    }
                }
            }
        });
    }


}