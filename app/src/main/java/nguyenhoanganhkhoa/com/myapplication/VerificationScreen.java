package nguyenhoanganhkhoa.com.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.chaos.view.PinView;

public class VerificationScreen extends AppCompatActivity {
    PinView pv;
    TextView txtErrorCode;
    Button btnVerify, btnOK;

    private void linkView() {
        pv = findViewById(R.id.pvVerification);
        txtErrorCode = findViewById(R.id.txtErrorCode);
        btnVerify = findViewById(R.id.btnVerify);

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
            txtErrorCode.setText("Please enter 4 numbers of code");
            txtErrorCode.setTextSize(15);
            return false;
        }

        return true;
    }



    private void addEvents() {
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
                        //
                    }
                    else
                    {
                        createDialog(btnOK,R.layout.custom_dialog_verification);
                        txtErrorCode.setTextSize(0);
                    }
                }
            }
        });
    }

    private void createDialog(Button btnOK, int dialogScreen ) {
        Dialog dialog = new Dialog(VerificationScreen.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(dialogScreen);

        Window window = dialog.getWindow();
        if (window == null){
            return;
        }

        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.WRAP_CONTENT);

        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        WindowManager.LayoutParams windowAtributes = window.getAttributes();
        windowAtributes.gravity = Gravity.CENTER;
        window.setAttributes(windowAtributes);


        btnOK = dialog.findViewById(R.id.btnOK);
        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();
    }

}