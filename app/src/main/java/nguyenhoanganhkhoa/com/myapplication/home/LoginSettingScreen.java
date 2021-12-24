package nguyenhoanganhkhoa.com.myapplication.home;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import nguyenhoanganhkhoa.com.customdialog.CustomDialogTwoButton;
import nguyenhoanganhkhoa.com.myapplication.R;
import nguyenhoanganhkhoa.com.myapplication.login.LoginScreen;
import nguyenhoanganhkhoa.com.thirdlink.AppUtil;
import nguyenhoanganhkhoa.com.thirdlink.ReusedConstraint;

public class LoginSettingScreen extends AppCompatActivity {

    ImageView imvSettingBack, imvAvatar;
    Button btnSignOutAllDevices;
    ReusedConstraint reusedConstraint = new ReusedConstraint(getApplicationContext());

    TextView txtName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_setting_screen);
        linkView();
        addEvents();
        reusedConstraint.getDataFromFirebase(imvAvatar,txtName);
    }



    private void addEvents() {
        btnSignOutAllDevices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CustomDialogTwoButton customDialogTwoButton = new CustomDialogTwoButton(LoginSettingScreen.this,R.layout.custom_dialog_signout);
                customDialogTwoButton.btnOK.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(LoginSettingScreen.this, LoginScreen.class);
                        startActivity(intent);
                        customDialogTwoButton.dismiss();
                    }
                });
                customDialogTwoButton.btnCancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        customDialogTwoButton.dismiss();
                    }
                });
                customDialogTwoButton.show();
            }
        });
        imvSettingBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void linkView() {
        btnSignOutAllDevices=findViewById(R.id.btnSignOutAllDevices);
        imvSettingBack=findViewById(R.id.imvSettingBack);
        imvAvatar=findViewById(R.id.imvAvatar);
        txtName=findViewById(R.id.txtName);
    }


}