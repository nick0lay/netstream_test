package ch.netstream.ui.dialogs;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.*;
import android.widget.Button;
import ch.netstream.R;
import ch.netstream.StreamingActivity;

/**
 * Created by Nikolay on 09.06.2014.
 */
public class Dialog extends android.app.Dialog{
    private Button start;
    private Button cancel;
    private Activity activity;

    public Dialog(Activity activity) {
        super(activity);
        this.activity = activity;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_start);
        start = (Button)findViewById(R.id.btn_start);
        cancel = (Button)findViewById(R.id.btn_cancel);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), StreamingActivity.class);
                getContext().startActivity(intent);
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.finish();
                dismiss();
            }
        });
    }
}
