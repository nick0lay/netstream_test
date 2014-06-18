package ch.netstream;

import android.app.Activity;
import android.os.Bundle;
import ch.netstream.ui.dialogs.Dialog;

public class MainActivity extends Activity {
    private Dialog dialog;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        dialog = new Dialog(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        showDialog();
    }

    @Override
    protected void onPause() {
        super.onPause();
        hideDialog();
    }

    public void showDialog() {
        if(dialog != null) {
            dialog.show();
        }
    }

    public void hideDialog() {
        if(dialog != null){
            dialog.dismiss();
        }
    }
}
