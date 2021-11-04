package nguyenhoanganhkhoa.com.myapplication.signup;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import nguyenhoanganhkhoa.com.adapter.FacultyAdapter;
import nguyenhoanganhkhoa.com.adapter.FacultyAdapterError;
import nguyenhoanganhkhoa.com.adapter.MajorAdapter;
import nguyenhoanganhkhoa.com.customdialog.CustomDialog;
import nguyenhoanganhkhoa.com.customdialog.CustomDialogThreeButton;
import nguyenhoanganhkhoa.com.customdialog.CustomDialogTwoButton;
import nguyenhoanganhkhoa.com.models.Faculty;
import nguyenhoanganhkhoa.com.models.Major;
import nguyenhoanganhkhoa.com.myapplication.another.CustomSpinner;
import nguyenhoanganhkhoa.com.myapplication.R;
import nguyenhoanganhkhoa.com.myapplication.home.HomePageScreen;
import nguyenhoanganhkhoa.com.thirdlink.ReusedConstraint;

public class PersonalInformationSetScreen extends AppCompatActivity implements CustomSpinner.OnSpinnerEventsListener {

    Button btnSave;
    EditText edtIdStudent;
    CustomSpinner spnFaculty;
    RadioButton radFemale, radMale;
    CircleImageView imvAvatar;
    ImageView imvCamera, imvFaculty, imvDropdown, imvComebackUserinfo;
    TextView txtErrorIdStudent, txtErrorMarjor, txtErrorDateofBirth, txtErrorFaculty,edtDateofbirth;
    AutoCompleteTextView adtMajor;

    ReusedConstraint reusedConstraint = new ReusedConstraint(PersonalInformationSetScreen.this);

    private void linkView() {
        btnSave = findViewById(R.id.btnSave);
        edtIdStudent = findViewById(R.id.edtIDStudent);
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
        adtMajor = findViewById(R.id.adtMajors);
        imvComebackUserinfo=findViewById(R.id.imvComebackUserinfo);
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_information_set_screen);

        linkView();
        initAdapterFaculty();
        initAderterMarjor();
        addEvents();
    }

    //Các sự kiện validate
    private Boolean validateIDStudent(){
        String username = edtIdStudent.getText().toString();
        if (username.isEmpty()){
            txtErrorIdStudent.setText(R.string.field_cannot_be_empty);
            txtErrorIdStudent.setTextSize(15);
            edtIdStudent.setHintTextColor(getColor(R.color.red));
            reusedConstraint.setCustomColor(edtIdStudent,R.drawable.edt_custom_error,R.color.red,R.color.red);
            return false;
        }



        else {
            reusedConstraint.setCustomColor(edtIdStudent,R.drawable.custom_edt,R.color.blackUI,R.color.xamChu);
            edtIdStudent.setHintTextColor(getColor(R.color.xamChu));

            txtErrorIdStudent.setText(null);
            txtErrorIdStudent.setTextSize(0);
            return true;
        }

    }
    private Boolean validateMajor(){
        String username = adtMajor.getText().toString();
        if (username.isEmpty()){
            txtErrorMarjor.setText(R.string.field_cannot_be_empty);
            txtErrorMarjor.setTextSize(15);
            adtMajor.setHintTextColor(getColor(R.color.red));
            reusedConstraint.setCustomColor(adtMajor,R.drawable.edt_custom_error,R.color.red,R.color.red);
            return false;
        }


        else {
            reusedConstraint.setCustomColor(adtMajor,R.drawable.custom_edt,R.color.blackUI,R.color.xamChu);
            adtMajor.setHintTextColor(getColor(R.color.xamChu));

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
            setCustomColortxt(edtDateofbirth,R.drawable.edt_custom_error,R.color.red,R.color.red);
            return false;
        }
        else if(!edtDateofbirth.getText().toString().isEmpty())
        {
            String sub1last = edtDateofbirth.getText().toString().substring(9,10);
            if(!sub1last.equals("1")&&!sub1last.equals("2")&&!sub1last.equals("3")
                    &&!sub1last.equals("4")&&!sub1last.equals("5")&&
                    !sub1last.equals("6")&&!sub1last.equals("7")&&
                    !sub1last.equals("8")&&!sub1last.equals("9")&&!sub1last.equals("0"))
            {
                txtErrorDateofBirth.setText(R.string.please_enter_full_of_date);
                txtErrorDateofBirth.setTextSize(15);
                edtDateofbirth.setHintTextColor(getColor(R.color.red));
                setCustomColortxt(edtDateofbirth,R.drawable.edt_custom_error,R.color.red,R.color.red);
                return false;
            }
            else
            {
                setCustomColortxt(edtDateofbirth,R.drawable.custom_edt,R.color.blackUI,R.color.xamChu);
                edtDateofbirth.setHintTextColor(getColor(R.color.xamChu));
                txtErrorDateofBirth.setText(null);
                txtErrorDateofBirth.setTextSize(0);
                return true;
            }
        }
        return true;
    }
    private Boolean validateDateOfbirthTextChange(){
        String username = edtDateofbirth.getText().toString();
        if (username.isEmpty()){
            txtErrorDateofBirth.setText(R.string.field_cannot_be_empty);
            txtErrorDateofBirth.setTextSize(15);
            edtDateofbirth.setHintTextColor(getColor(R.color.red));
            setCustomColortxt(edtDateofbirth,R.drawable.edt_custom_error,R.color.red,R.color.red);
            return false;
        }


        else {
            setCustomColortxt(edtDateofbirth,R.drawable.custom_edt,R.color.blackUI,R.color.xamChu);
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
            txtErrorFaculty.setText(null);
            return true;
        }
    }

    //Pick Date
    Calendar calendar = Calendar.getInstance();
    final int year = calendar.get(Calendar.YEAR);
    final int month = calendar.get(Calendar.MONTH);
    final int day = calendar.get(Calendar.DAY_OF_MONTH);
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    DatePickerDialog.OnDateSetListener setListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int year, int month, int day) {
            calendar.set(Calendar.YEAR, year);
            calendar.set(Calendar.MONTH, month);
            calendar.set(Calendar.DAY_OF_MONTH, day);
            edtDateofbirth.setText(dateFormat.format(calendar.getTime()));
            String s = edtDateofbirth.getText().toString();
        }
    };

    //Nạp adapter và dữ liệu cho các List
    FacultyAdapter facultyAdapter;
    FacultyAdapterError facultyAdapterError;
    private void initAdapterFaculty() {
        facultyAdapter = new FacultyAdapter(this,R.layout.item_faculty_selected,getListFaculty());
        spnFaculty.setAdapter(facultyAdapter);

    }
    private List<Faculty> getListFaculty() {
        List<Faculty> list =new ArrayList<>();
        String[] facultyArray= getResources().getStringArray(R.array.faculty);

        for (int i = 0;i<facultyArray.length;i++)
            list.add(new Faculty(facultyArray[i]));

        return list;

    }
    public static int selectedFaculty = 0;

    MajorAdapter majorAdapter;
    private void initAderterMarjor() {
        majorAdapter = new MajorAdapter(this,R.layout.item_faculty_selected,getListMajor());
        adtMajor.setAdapter(majorAdapter);

    }
    private List<Major> getListMajor() {
        List<Major> list = new ArrayList<>();
        String[] majorArray= getResources().getStringArray(R.array.major);

        for (int i = 0;i<majorArray.length;i++)
            list.add(new Major(majorArray[i]));

        return list;
    }



    //Tạo sự kiện chụp ảnh
    private static final int REQUEST_TAKE_PICTURE = 1337;
    private static final int REQUEST_PICK_PICTURE = 1338;
    private void cameraPickImage() {
        CustomDialogThreeButton customDialogThreeButton = new CustomDialogThreeButton
                (PersonalInformationSetScreen.this,R.layout.custom_dialog_chooss_image);
        customDialogThreeButton.btnTakePhotos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, REQUEST_TAKE_PICTURE);
                customDialogThreeButton.dismiss();

            }
        });

        customDialogThreeButton.btnChooseFromGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cameraIntent = new Intent(Intent.ACTION_PICK,MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(cameraIntent, REQUEST_PICK_PICTURE);
                customDialogThreeButton.dismiss();
            }
        });
        customDialogThreeButton.btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                customDialogThreeButton.dismiss();
            }
        });

        customDialogThreeButton.show();


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

    // Tạo sự kiện thêm và đóng spinner
    @Override
    public void onPopupWindowOpened(Spinner spinner) {
        String thongdiep = getString(R.string.field_cannot_be_empty);

        if (txtErrorFaculty.getText().toString().equals(thongdiep))
        {
            imvDropdown.setImageResource(R.drawable.ic_arrrow_dropdown_up_errror);
        }
        else
            imvDropdown.setImageResource(R.drawable.ic_arrrow_dropdown_up);



    }
    @Override
    public void onPopupWindowClosed(Spinner spinner) {
        String thongdiep = getString(R.string.field_cannot_be_empty);

        if (txtErrorFaculty.getText().toString().equals(thongdiep))
        {
            imvDropdown.setImageResource(R.drawable.ic_arrow_down_spinner_error);
        }
        else
            imvDropdown.setImageResource(R.drawable.ic_arrow_down_spinner);

    }

    // AddEvents và một vài sự kiện khác
    private void addEvents() {

        imvComebackUserinfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CustomDialogTwoButton customDialogTwoButton =
                        new CustomDialogTwoButton(PersonalInformationSetScreen.this,R.layout.custom_dialog_unsaved_changes);
                customDialogTwoButton.btnOK.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(PersonalInformationSetScreen.this, EmailScreen.class);
                        startActivity(intent);
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
        adtMajor.addTextChangedListener(new TextWatcher() {
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
        edtDateofbirth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        PersonalInformationSetScreen.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        setListener,
                        year, month, day);
                datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                datePickerDialog.show();



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
        //new DateTimeFormat(edtDateofbirth);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!validateIDStudent()|!validateMajor()|!validateDateOfbirth()|!validateFaculty())
                {
                    clearAllForcus();
                }
                else {
                    clearAllForcus();
                    CustomDialog customDialog = new
                            CustomDialog(PersonalInformationSetScreen.this, R.layout.custom_dialog_create_account_successful);
                    customDialog.btnOK.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            customDialog.dismiss();
                            Intent intent = new Intent(PersonalInformationSetScreen.this, HomePageScreen.class);
                            startActivity(intent);
                        }
                    });
                    customDialog.show();
                }
            }
        });
        imvCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cameraPickImage();
            }
        });
    }
    private void clearAllForcus(){
        edtIdStudent.clearFocus();
        adtMajor.clearFocus();
        edtDateofbirth.clearFocus();
        spnFaculty.clearFocus();
    }
    private void setCustomColortxt(TextView txtCanSua, int edtColor, int iconColor, int textColor){
        // Chỉnh màu cho thanh eTit text khi gặp error, focus, ...

        txtCanSua.setBackground(ContextCompat.getDrawable(PersonalInformationSetScreen.this,edtColor));
        txtCanSua.setCompoundDrawableTintList(ContextCompat.getColorStateList(PersonalInformationSetScreen.this,iconColor));
        txtCanSua.setTextColor(ContextCompat.getColorStateList(PersonalInformationSetScreen.this,textColor));
    }

}