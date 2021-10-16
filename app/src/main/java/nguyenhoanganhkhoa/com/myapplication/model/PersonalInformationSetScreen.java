package nguyenhoanganhkhoa.com.myapplication.model;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import nguyenhoanganhkhoa.com.myapplication.R;
import nguyenhoanganhkhoa.com.myapplication.adapter.FacultyAdapter;
import nguyenhoanganhkhoa.com.myapplication.data.Faculty;

public class PersonalInformationSetScreen extends AppCompatActivity {

    Button btnSave;
    EditText edtIdStudent,edtMajor, edtDateofbirth;
    Spinner spnFaculty;
    RadioButton radFemale, radMale;
    CircleImageView imvAvatar;
    ImageView imvCamera;





    private void linkView() {
        btnSave = findViewById(R.id.btnSave);
        edtIdStudent = findViewById(R.id.edtIDStudent);
        edtMajor = findViewById(R.id.edtMajors);
        edtDateofbirth = findViewById(R.id.edtDateOfBirth);
        spnFaculty = findViewById(R.id.spnFaculty);
        radFemale = findViewById(R.id.radFemale);
        radMale = findViewById(R.id.radMale);
        imvAvatar = findViewById(R.id.imvAvatar);
        imvCamera = findViewById(R.id.imvCamera);


    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_information_set_screen);

        linkView();
        initAdapter();
        addEvents();

    }



    FacultyAdapter facultyAdapter;

    private void initAdapter() {
        facultyAdapter = new FacultyAdapter(this,R.layout.item_faculty_selected,getListFaculty());
        spnFaculty.setAdapter(facultyAdapter);

    }

    private List<Faculty> getListFaculty() {
        List<Faculty> list =new ArrayList<>();
        list.add(new Faculty("Faculty*"));
        list.add(new Faculty("Faculty of Economics"));
        list.add(new Faculty("Faculty of International Economic Relations"));
        list.add(new Faculty("Faculty of Finance - Banking"));
        list.add(new Faculty("Faculty of Accounting - Auditing"));
        list.add(new Faculty("Faculty of Information Systems"));
        list.add(new Faculty("Faculty of Business Administration "));
        list.add(new Faculty("Faculty of Economic Mathematics"));
        list.add(new Faculty("Faculty of Law"));
        list.add(new Faculty("Faculty of Economic Law"));
        list.add(new Faculty("Department of Foreign Languages"));
        return list;

    }


    private void addEvents() {

        new DateTimeFormat(edtDateofbirth);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        imvCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cameraPickImage();
            }
        });

    }




    private static final int REQUEST_TAKE_PICTURE = 1337;
    private static final int REQUEST_PICK_PICTURE = 1338;

    private void cameraPickImage() {
        CustomDialogTwoButton customDialogTwoButton = new CustomDialogTwoButton
                (PersonalInformationSetScreen.this,R.layout.custom_dialog_chooss_image);
        customDialogTwoButton.btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, REQUEST_TAKE_PICTURE);
                customDialogTwoButton.dismiss();

            }
        });

        customDialogTwoButton.btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cameraIntent = new Intent(Intent.ACTION_PICK,MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(cameraIntent, REQUEST_PICK_PICTURE);
                customDialogTwoButton.dismiss();
            }
        });
        customDialogTwoButton.show();


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode==REQUEST_TAKE_PICTURE && resultCode==RESULT_OK){
            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
            imvAvatar.setImageBitmap(bitmap);
        }
        else if(requestCode==REQUEST_PICK_PICTURE && resultCode==RESULT_OK)
        {
            imvAvatar.setImageURI(data.getData());

        }
        super.onActivityResult(requestCode, resultCode, data);
    }







}