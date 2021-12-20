package nguyenhoanganhkhoa.com.myapplication.home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import nguyenhoanganhkhoa.com.customdialog.CustomBottomSheetComponent;
import nguyenhoanganhkhoa.com.customdialog.CustomBottomSheetFilter;
import nguyenhoanganhkhoa.com.customdialog.CustomDialogTwoButton;
import nguyenhoanganhkhoa.com.myapplication.R;
import nguyenhoanganhkhoa.com.myapplication.login.LoginScreen;

public class SettingScreen extends AppCompatActivity {
    ImageView imvSettingBack ;
    LinearLayout lnSignOutSetting;
    TextView txtLoginSetting, txtSetTime, txtLanguage;
    CustomBottomSheetComponent bottomSheetDialogLanguage = null;
    CustomBottomSheetComponent bottomSheetDialogTime = null;
    private void linkView() {
        imvSettingBack = findViewById(R.id.imvSettingBack);
        lnSignOutSetting= findViewById(R.id.lnSignoutSetting);
        txtLoginSetting = findViewById(R.id.txtLoginSetting);
        txtLanguage=findViewById(R.id.txtLanguage);
        txtSetTime=findViewById(R.id.txtSetTime);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_screen);
        linkView();
        addEvents();
    }

    private void addEvents() {
        lnSignOutSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CustomDialogTwoButton customDialogTwoButton = new CustomDialogTwoButton(SettingScreen.this,R.layout.custom_dialog_signout);
                customDialogTwoButton.btnOK.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(SettingScreen.this, LoginScreen.class);
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

        txtLoginSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SettingScreen.this, LoginSettingScreen.class);
                startActivity(intent);
            }
        });
        txtLanguage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createBottomSheetLanguage();
            }
        });
        txtSetTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createBottomSheetTime();
            }
        });
    }

    private void createBottomSheetTime() {
        if(bottomSheetDialogTime ==null){
//            View view = LayoutInflater.from(this).inflate(R.layout.custom_bottomdialog_filter,null);
//            bottomSheetDialog = new BottomSheetDialog(this);
//            bottomSheetDialog.setContentView(view);

            bottomSheetDialogTime = new CustomBottomSheetComponent(SettingScreen.this,R.style.BottomSheetDialogTheme,R.layout.custom_bottomdialog_time);
//            bottomSheetDialog = new CustomBottomSheetFilter(this,R.layout.custom_bottomdialog_filter);
        }
        bottomSheetDialogTime.show();

    }

    private void createBottomSheetLanguage() {
        if(bottomSheetDialogLanguage ==null){
//            View view = LayoutInflater.from(this).inflate(R.layout.custom_bottomdialog_filter,null);
//            bottomSheetDialog = new BottomSheetDialog(this);
//            bottomSheetDialog.setContentView(view);

            bottomSheetDialogLanguage = new CustomBottomSheetComponent(SettingScreen.this,R.style.BottomSheetDialogTheme,R.layout.custom_bottomdialog_language);
//            bottomSheetDialog = new CustomBottomSheetFilter(this,R.layout.custom_bottomdialog_filter);
        }
        bottomSheetDialogLanguage.show();
    }
}