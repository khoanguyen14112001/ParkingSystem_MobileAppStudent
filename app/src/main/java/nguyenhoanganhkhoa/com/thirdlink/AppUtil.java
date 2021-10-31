package nguyenhoanganhkhoa.com.thirdlink;

import android.content.Context;
import android.text.Html;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

import nguyenhoanganhkhoa.com.myapplication.R;

public class AppUtil {
    public static String eMessage = "";
    public static String eMessageForSignUp = "";
    public static int mSelectedIndex = 0;

    public static void prepareDots(Context context, int lengthList, LinearLayout layout, TextView dots[],
                                   int size)
    {
        for(int i = 0; i<lengthList;i++)
        {
            dots[i] = new TextView(context);
            dots[i].setText(Html.fromHtml("&#9679;"));
            dots[i].setTextSize(size);

            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT);
            layoutParams.setMargins(6,0,6,0);
            layout.addView(dots[i],layoutParams);
        }
    }

}
