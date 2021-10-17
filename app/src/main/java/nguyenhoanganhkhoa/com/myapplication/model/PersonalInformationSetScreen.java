package nguyenhoanganhkhoa.com.myapplication.model;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import nguyenhoanganhkhoa.com.myapplication.R;
import nguyenhoanganhkhoa.com.myapplication.adapter.FacultyAdapter;
import nguyenhoanganhkhoa.com.myapplication.adapter.FacultyAdapterError;
import nguyenhoanganhkhoa.com.myapplication.data.Faculty;
import nguyenhoanganhkhoa.com.myapplication.thirdlink.AppUtil;

public class PersonalInformationSetScreen extends AppCompatActivity implements CustomSpinner.OnSpinnerEventsListener {

    Button btnSave;
    EditText edtIdStudent,edtMajor, edtDateofbirth;
    CustomSpinner spnFaculty;
    RadioButton radFemale, radMale;
    CircleImageView imvAvatar;
    ImageView imvCamera, imvFaculty, imvDropdown;
    TextView txtErrorIdStudent, txtErrorMarjor, txtErrorDateofBirth, txtErrorFaculty;


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
        imvFaculty = findViewById(R.id.imvFaculty);
        imvDropdown = findViewById(R.id.imvDropdown);

        txtErrorDateofBirth= findViewById(R.id.txtErrorDataofbirth);
        txtErrorIdStudent= findViewById(R.id.txtErrorIDStudent);
        txtErrorMarjor= findViewById(R.id.txtErrorMajor);
        txtErrorFaculty= findViewById(R.id.txtErrorSpnFaculty);

    }

    private void setCustomColor(EditText edtCanSua, int edtColor, int iconColor, int textColor)
    {
        // Chỉnh màu cho thanh edit text khi gặp error, focus, ...

        edtCanSua.setBackground(ContextCompat.getDrawable(PersonalInformationSetScreen.this,edtColor));
        edtCanSua.setCompoundDrawableTintList(ContextCompat.getColorStateList(PersonalInformationSetScreen.this,iconColor));
        edtCanSua.setTextColor(ContextCompat.getColorStateList(PersonalInformationSetScreen.this,textColor));
    }

    private Boolean validateIDStudent(){
        String username = edtIdStudent.getText().toString();
        if (username.isEmpty()){
            txtErrorIdStudent.setText(R.string.field_cannot_be_empty);
            txtErrorIdStudent.setTextSize(15);
            edtIdStudent.setHintTextColor(getColor(R.color.red));
            setCustomColor(edtIdStudent,R.drawable.edt_custom_error,R.color.red,R.color.red);
            return false;
        }

//

        else {
            setCustomColor(edtIdStudent,R.drawable.custom_edt,R.color.blackUI,R.color.xamChu);
            edtIdStudent.setHintTextColor(getColor(R.color.xamChu));

            txtErrorIdStudent.setText(null);
            txtErrorIdStudent.setTextSize(0);
            return true;
        }

    }
    private Boolean validateMajor(){
        String username = edtMajor.getText().toString();
        if (username.isEmpty()){
            txtErrorMarjor.setText(R.string.field_cannot_be_empty);
            txtErrorMarjor.setTextSize(15);
            edtMajor.setHintTextColor(getColor(R.color.red));
            setCustomColor(edtMajor,R.drawable.edt_custom_error,R.color.red,R.color.red);
            return false;
        }

//

        else {
            setCustomColor(edtMajor,R.drawable.custom_edt,R.color.blackUI,R.color.xamChu);
            edtMajor.setHintTextColor(getColor(R.color.xamChu));

            txtErrorMarjor.setText(null);
            txtErrorMarjor.setTextSize(0);
            return true;
        }

    }
    private Boolean validateDateOfbirth(){
        String dateofbirth = edtDateofbirth.getText().toString();
        if (dateofbirth.isEmpty()){
            txtErrorDateofBirth.setText(R.string.field_cannot_be_empty);
            txtErrorDateofBirth.setTextSize(15);
            edtDateofbirth.setHintTextColor(getColor(R.color.red));
            setCustomColor(edtDateofbirth,R.drawable.edt_custom_error,R.color.red,R.color.red);
            return false;
        }
        else if(!dateofbirth.isEmpty() && dateofbirth.length()<8)
        {
            txtErrorDateofBirth.setText(R.string.field_cannot_be_empty);
            txtErrorDateofBirth.setTextSize(15);
            edtDateofbirth.setHintTextColor(getColor(R.color.red));
            setCustomColor(edtDateofbirth,R.drawable.edt_custom_error,R.color.red,R.color.red);
            return false;
        }

        else {
            setCustomColor(edtDateofbirth,R.drawable.custom_edt,R.color.blackUI,R.color.xamChu);
            edtDateofbirth.setHintTextColor(getColor(R.color.xamChu));

            txtErrorDateofBirth.setText(null);
            txtErrorDateofBirth.setTextSize(0);
            return true;
        }

    }
    private Boolean validateDateOfbirthTextChange(){
        String username = edtDateofbirth.getText().toString();
        if (username.isEmpty()){
            txtErrorDateofBirth.setText(R.string.field_cannot_be_empty);
            txtErrorDateofBirth.setTextSize(15);
            edtDateofbirth.setHintTextColor(getColor(R.color.red));
            setCustomColor(edtDateofbirth,R.drawable.edt_custom_error,R.color.red,R.color.red);
            return false;
        }


        else {
            setCustomColor(edtDateofbirth,R.drawable.custom_edt,R.color.blackUI,R.color.xamChu);
            edtDateofbirth.setHintTextColor(getColor(R.color.xamChu));

            txtErrorDateofBirth.setText(null);
            txtErrorDateofBirth.setTextSize(0);
            return true;
        }

    }
    private Boolean validateFaculty(){
        String selectedItem = facultyAdapter.getItem(spnFaculty.getSelectedItemPosition()).getNameFaculty();

        if (selectedItem.equals("Faculty*")){
            facultyAdapterError = new FacultyAdapterError(this,R.layout.item_faculty_selected,getListFaculty());
            spnFaculty.setAdapter(facultyAdapterError);

            txtErrorFaculty.setText(R.string.field_cannot_be_empty);
            spnFaculty.setBackgroundResource(R.drawable.edt_custom_error);
            txtErrorFaculty.setTextSize(15);


            imvFaculty.setImageDrawable(getResources().getDrawable(R.drawable.ic_faculty_error));
            imvDropdown.setImageDrawable(getResources().getDrawable(R.drawable.ic_arrow_down_spinner_error));


            return false;




        }
        else {
            return true;
        }
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
    FacultyAdapterError facultyAdapterError;

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

    public static int selectedFaculty = 0;
    private void addEvents() {
        spnFaculty.setSpinnerEventsListener(PersonalInformationSetScreen.this);


        spnFaculty.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(i!=0)
                {
                    txtErrorFaculty.setText(null);
                    spnFaculty.setBackgroundResource(R.drawable.custom_edt);
                    imvFaculty.setImageDrawable(getResources().getDrawable(R.drawable.ic_faculty));
                    imvDropdown.setImageDrawable(getResources().getDrawable(R.drawable.ic_arrow_down_spinner));
                    txtErrorFaculty.setTextSize(0);

                    selectedFaculty = i;


                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        edtIdStudent.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                validateIDStudent();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        edtMajor.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                validateMajor();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        edtDateofbirth.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                validateDateOfbirthTextChange();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        new DateTimeFormat(edtDateofbirth);


        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!validateIDStudent()|!validateMajor()|!validateDateOfbirth()|!validateFaculty())
                {
                    clearAllForcus();
                }
                else
                    Toast.makeText(PersonalInformationSetScreen.this,"Loginzo",Toast.LENGTH_SHORT).show();

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
    private void clearAllForcus()
    {
        edtIdStudent.clearFocus();
        edtMajor.clearFocus();
        edtDateofbirth.clearFocus();
        spnFaculty.clearFocus();
    }


    // Tạo sự kiện thêm và đóng spinner
    @Override
    public void onPopupWindowOpened(Spinner spinner) {
        //int color = txtErrorFaculty
        //if(drawableRecent==drawableDefault)
           // imvDropdown.setImageResource(R.drawable.ic_arrrow_dropdown_up_errror);
       // if(drawableRecent==drawableError)
          //  imvDropdown.setImageResource(R.drawable.ic_arrrow_dropdown_up);


    }

    @Override
    public void onPopupWindowClosed(Spinner spinner) {
//        Drawable drawableDropdown = imvDropdown.getDrawable();
//        Drawable drawableNotError = getResources().getDrawable(R.drawable.ic_arrrow_dropdown_up);
//        if(drawableDropdown==drawableNotError)
//            imvDropdown.setImageResource(R.drawable.ic_arrow_down_spinner_error);
//        else
//            imvDropdown.setImageResource(R.drawable.ic_arrow_down_spinner);

    }
}