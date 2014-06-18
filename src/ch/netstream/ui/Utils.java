package ch.netstream.ui;

import android.content.Context;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Nikolay on 09.06.2014.
 */
public class Utils {

    public static String loadJSONFromAsset(Context context, String fileName) {
        String json = null;
        try {
            InputStream is = context.getAssets().open(fileName);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

    public static String formatTime(long millis){
        String timeFormat = "HH:mm";
        SimpleDateFormat formatter = new SimpleDateFormat(timeFormat, Locale.getDefault());
        return formatter.format(new Date(millis));
    }

    public static String formatDuration(long millis){
        String timeFormat = "mm:ss";
        SimpleDateFormat formatter = new SimpleDateFormat(timeFormat, Locale.getDefault());
        return formatter.format(new Date(millis));
    }
}
