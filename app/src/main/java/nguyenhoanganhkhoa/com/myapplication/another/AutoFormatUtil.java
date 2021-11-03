package nguyenhoanganhkhoa.com.myapplication.another;

import java.text.DecimalFormat;
import java.text.NumberFormat;


public class AutoFormatUtil {

    private static final String FORMAT_NO_DECIMAL = "###,###";


    private static final String FORMAT_WITH_DECIMAL = "###,###.###";

    public static int getCharOccurance(String input, char c) {
        int occurance = 0;
        char[] chars = input.toCharArray();
        for (char thisChar : chars) {
            if (thisChar == c) {
                occurance++;
            }
        }
        return occurance;
    }

    public static String extractDigits(String input) {
        return input.replaceAll("\\D+", "");
    }

    public static String formatToStringWithoutDecimal(int value) {
        String s = String.valueOf(value);
        StringBuilder sb = new StringBuilder(s);
        if(s.length()==4)
        {
            sb.insert(1,".");
        }
        else if(s.length()==5) {
            sb.insert(2, ".");
        }
        else if(s.length()==6) {
            sb.insert(3, ".");
        }
        return sb.toString();
    }

    public static String formatToStringWithoutDecimal(String value) {
        return formatToStringWithoutDecimal(Integer.parseInt(value));
    }

    public static String formatWithDecimal(String price) {
        return formatWithDecimal(Double.parseDouble(price));
    }

    public static String formatWithDecimal(double price) {
        NumberFormat formatter = new DecimalFormat(FORMAT_WITH_DECIMAL);
        return formatter.format(price);
    }
}
