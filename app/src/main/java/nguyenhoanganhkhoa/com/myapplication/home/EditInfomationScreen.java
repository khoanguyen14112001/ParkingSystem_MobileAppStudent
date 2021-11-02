package nguyenhoanganhkhoa.com.myapplication.home;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.function.IntUnaryOperator;

import de.hdodenhof.circleimageview.CircleImageView;
import nguyenhoanganhkhoa.com.adapter.FacultyAdapter;
import nguyenhoanganhkhoa.com.adapter.MajorAdapter;
import nguyenhoanganhkhoa.com.customdialog.CustomDialog;
import nguyenhoanganhkhoa.com.customdialog.CustomDialogThreeButton;
import nguyenhoanganhkhoa.com.customdialog.CustomDialogTwoButton;
import nguyenhoanganhkhoa.com.fragments.AccountFragment;
import nguyenhoanganhkhoa.com.models.Faculty;
import nguyenhoanganhkhoa.com.models.Major;
import nguyenhoanganhkhoa.com.myapplication.another.CustomSpinner;
import nguyenhoanganhkhoa.com.myapplication.R;
import nguyenhoanganhkhoa.com.thirdlink.AppUtil;
import nguyenhoanganhkhoa.com.thirdlink.ReusedConstraint;

public class EditInfomationScreen extends AppCompatActivity implements CustomSpinner.OnSpinnerEventsListener {
    Button btnSave;
    EditText edtIdStudent, edtPhone,edtNameEditInfo;
    CustomSpinner spnFaculty;
    RadioButton radFemale, radMale;
    CircleImageView imvAvatar;
    ImageView imvCamera, imvFaculty, imvDropdown, imvComebackEditInfo;
    TextView txtErrorIdStudent, txtErrorMarjor, txtErrorDateofBirth, txtErrorFaculty,edtDateofbirth,
    txtErrorPhone;
    AutoCompleteTextView adtMajor;


    ReusedConstraint reusedConstraint = new ReusedConstraint(EditInfomationScreen.this);


    private void linkView() {
        btnSave = findViewById(R.id.btnSaveEditInfo);
        edtIdStudent = findViewById(R.id.edtIDStudentEditInfo);
        edtDateofbirth = findViewById(R.id.edtDateOfBirthEditInfo);
        edtNameEditInfo = findViewById(R.id.edtNameEditInfo);


        spnFaculty = findViewById(R.id.spnFacultyEditInfo);
        radFemale = findViewById(R.id.radFemaleEditInfor);
        radMale = findViewById(R.id.radMaleEditInfor);

        imvAvatar = findViewById(R.id.imvAvatarEditInfo);
        imvCamera = findViewById(R.id.imvCameraEditInfo);
        imvFaculty = findViewById(R.id.imvFacultyEditInfo);
        imvDropdown = findViewById(R.id.imvDropdownEditInfo);

        txtErrorDateofBirth= findViewById(R.id.txtErrorDataofbirthEditInfo);
        txtErrorIdStudent= findViewById(R.id.txtErrorIDStudentEditInfo);
        txtErrorMarjor= findViewById(R.id.txtErrorMajorEditInfo);
        txtErrorFaculty= findViewById(R.id.txtErrorSpnFacultyEditInfo);
        txtErrorPhone = findViewById(R.id.txtErrorPhoneEditInfo);

        adtMajor = findViewById(R.id.adtMajorsEditInfo);
        edtPhone = findViewById(R.id.edtPhoneEditInfo);

        imvComebackEditInfo=findViewById(R.id.imvComebackEditInfo);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_infomation_screen);

        linkView();
        initAdapterFaculty();
        initAderterMarjor();
        getData();
        addEvents();


    }


    private void getData() {
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("my_bundle");
        edtNameEditInfo.setText(bundle.getString(AppUtil.NAME));
        edtDateofbirth.setText(bundle.getString(AppUtil.DATE_OF_BIRTH));
        edtIdStudent.setText(bundle.getString(AppUtil.ID));
        edtPhone.setText(bundle.getString(AppUtil.PHONE));
        adtMajor.setText(bundle.getString(AppUtil.MAJOR));

        if(bundle.getString(AppUtil.GENDER).equals("Female"))
        {
            radFemale.setChecked(true);
        }
        else if(bundle.getString(AppUtil.GENDER).equals("Male"))
        {
            radMale.setChecked(true);
        }
        for (int i = 0; i < getListFaculty().size(); i++) {
            if (getListFaculty().get(i).getNameFaculty().equals(bundle.getString(AppUtil.FACULTY))) {
                spnFaculty.setSelection(i);
                break;
            }
        }




    }
    private void pushData(Bundle bundle){
        bundle.putString(AppUtil.DATE_OF_BIRTH,edtDateofbirth.getText().toString());
        bundle.putString(AppUtil.FACULTY,spnFaculty.getSelectedItem().toString());
        bundle.putString(AppUtil.MAJOR,adtMajor.getText().toString());
        bundle.putString(AppUtil.PHONE,edtPhone.getText().toString());
        bundle.putString(AppUtil.NAME,edtNameEditInfo.getText().toString());

        if(radMale.isChecked())
        {
            bundle.putString(AppUtil.GENDER,"Male");
        }
        else if(radFemale.isChecked())
        {
            bundle.putString(AppUtil.GENDER,"Female");

        }
        bundle.putString(AppUtil.ID,edtIdStudent.getText().toString());

    }


    // Sự kiện addEvents() và các sự kiện khác
    private void addEvents() {
        imvComebackEditInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CustomDialogTwoButton customDialogTwoButton =
                        new CustomDialogTwoButton(EditInfomationScreen.this,R.layout.custom_dialog_unsaved_changes);
                customDialogTwoButton.btnOK.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        finish();
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
        spnFaculty.setSpinnerEventsListener(EditInfomationScreen.this);
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
        edtPhone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                validatePhoneNumber();
            }

            @Override
            public void afterTextChanged(Editable editable) {

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
                        EditInfomationScreen.this,
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
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!validateIDStudent()|!validateMajor()|!validateDateOfbirth()|!validatePhoneNumber())
                {
                    clearAllForcus();
                }
                else {
                    clearAllForcus();
                    CustomDialog customDialog = new
                            CustomDialog(EditInfomationScreen.this, R.layout.custom_dialog_save_editifor_change);
                    customDialog.btnOK.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            customDialog.dismiss();
                            finish();

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

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }

    private void clearAllForcus(){
        edtIdStudent.clearFocus();
        adtMajor.clearFocus();
        edtDateofbirth.clearFocus();
        spnFaculty.clearFocus();
    }
    private void setCustomColortxt(TextView txtCanSua, int edtColor, int iconColor, int textColor){
        // Chỉnh màu cho thanh eTit text khi gặp error, focus, ...

        txtCanSua.setBackground(ContextCompat.getDrawable(EditInfomationScreen.this,edtColor));
        txtCanSua.setCompoundDrawableTintList(ContextCompat.getColorStateList(EditInfomationScreen.this,iconColor));
        txtCanSua.setTextColor(ContextCompat.getColorStateList(EditInfomationScreen.this,textColor));
    }


    // Tạo sự kiện thêm và đóng spinner
    @Override
    public void onPopupWindowOpened(Spinner spinner) {
        imvDropdown.setImageResource(R.drawable.ic_arrrow_dropdown_up);



    }
    @Override
    public void onPopupWindowClosed(Spinner spinner) {
        imvDropdown.setImageResource(R.drawable.ic_arrow_down_spinner);
    }

    // Tạo sự kiện chụp ảnh
    private static final int REQUEST_TAKE_PICTURE = 1337;
    private static final int REQUEST_PICK_PICTURE = 1338;
    private void cameraPickImage() {
        CustomDialogThreeButton customDialogThreeButton = new CustomDialogThreeButton
                (EditInfomationScreen.this,R.layout.custom_dialog_chooss_image);
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

    //Tạo sự kiện pick datetime
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

    //Tạo sự kiện Validate
    private Boolean validateIDStudent(){
        String username = edtIdStudent.getText().toString();
        if (username.isEmpty()){
            txtErrorIdStudent.setText(R.string.field_cannot_be_empty);
            txtErrorIdStudent.setTextSize(15);
            edtIdStudent.setHintTextColor(getColor(R.color.red));
            reusedConstraint.setCustomColor(edtIdStudent,R.drawable.edt_custom_error,R.color.red,R.color.red);
            return false;
        }

//

        else {
            reusedConstraint.setCustomColor(edtIdStudent,R.drawable.custom_edt,R.color.blackUI,R.color.xamChu);
            edtIdStudent.setHintTextColor(getColor(R.color.xamChu));

            txtErrorIdStudent.setText(null);
            txtErrorIdStudent.setTextSize(0);
            return true;
        }

    }
    private Boolean validatePhoneNumber(){
        String username = edtPhone.getText().toString();
        if (username.isEmpty()){
            txtErrorPhone.setText(R.string.field_cannot_be_empty);
            txtErrorPhone.setTextSize(15);
            edtPhone.setHintTextColor(getColor(R.color.red));
            reusedConstraint.setCustomColor(edtPhone,R.drawable.edt_custom_error,R.color.red,R.color.red);
            return false;
        }

//

        else {
            reusedConstraint.setCustomColor(edtPhone,R.drawable.custom_edt,R.color.blackUI,R.color.xamChu);
            edtPhone.setHintTextColor(getColor(R.color.xamChu));
            txtErrorPhone.setText(null);
            txtErrorPhone.setTextSize(0);
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

    //Các sự kiện nạp adapter
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

    public static int selectedFaculty = 0;
    FacultyAdapter facultyAdapter;
    private void initAdapterFaculty() {
        facultyAdapter = new FacultyAdapter(this,R.layout.item_faculty_selected,getListFaculty());
        spnFaculty.setAdapter(facultyAdapter);



    }
    private List<Faculty> getListFaculty() {
        List<Faculty> list =new ArrayList<>();
        String[] facultyArray= getResources().getStringArray(R.array.facultyEditInfo);

        for (int i = 0;i<facultyArray.length;i++)
            list.add(new Faculty(facultyArray[i]));

        return list;

    }

}