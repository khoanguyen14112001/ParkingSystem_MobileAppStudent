package nguyenhoanganhkhoa.com.myapplication.home;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import nguyenhoanganhkhoa.com.customdialog.CustomDialogTwoButton;
import nguyenhoanganhkhoa.com.myapplication.R;
import nguyenhoanganhkhoa.com.myapplication.login.LoginScreen;
import nguyenhoanganhkhoa.com.thirdlink.AppUtil;
import nguyenhoanganhkhoa.com.thirdlink.ReusedConstraint;

public class LoginSettingScreen extends AppCompatActivity {

    ImageView imvSettingBack, imvAvatar;
    Button btnSignOutAllDevices;

    TextView txtName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_setting_screen);
        linkView();
        getDataFromFirebase();
        addEvents();

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

    public void getDataFromFirebase(){
        AppUtil.databaseReference.child(AppUtil.DATA_OBJECT).child(AppUtil.USERNAME_AFTER_LOGGIN)
                .addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        String fullname = snapshot.child(AppUtil.FB_FULLNAME).getValue(String.class);
                        String uri = snapshot.child(AppUtil.FB_IMAGES_BITMAP).getValue(String.class);
                        if(uri.isEmpty()|uri.equals("Null")){
                            long avatar = snapshot.child(AppUtil.FB_AVATAR).getValue(Long.class);
                            int idAva = Integer.parseInt(String.valueOf(avatar));
                            imvAvatar.setImageResource(idAva);
                        }
                        else{
                            if(getApplicationContext()!=null){
                                Glide.with(getApplicationContext()).load(uri).into(imvAvatar);
                            }
                        }
                        txtName.setText(fullname);

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Log.d("Error", "Fail to load info in: " + error.toString());
                    }
                });
    }


}