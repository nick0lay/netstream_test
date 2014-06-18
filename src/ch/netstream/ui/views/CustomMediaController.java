package ch.netstream.ui.views;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.widget.MediaController;
import ch.netstream.ui.listeners.OnVisibilityChangeListener;

/**
 * Created by Nikolay on 10.06.2014.
 */
public class CustomMediaController extends MediaController{
    private OnVisibilityChangeListener visibilityChangeListener;
    final Handler h = new Handler();
    private int timeout = 5000;
    private Runnable hidePanelRunable = new Runnable() {
        @Override
        public void run() {
            if(visibilityChangeListener != null) {
                visibilityChangeListener.onHide();
            }
            hide();
        }
    };

    public CustomMediaController(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomMediaController(Context context, boolean useFastForward) {
        super(context, useFastForward);
    }

    public CustomMediaController(Context context) {
        super(context);
    }

    public void setOnVisibilityChangeListener(OnVisibilityChangeListener listener){
        visibilityChangeListener = listener;
    }

    public void showDelayed() {
        if(visibilityChangeListener != null) {
            visibilityChangeListener.onShow();
        }
        h.postDelayed(hidePanelRunable, timeout);
    }

    public void showNow() {
        if(visibilityChangeListener != null) {
            visibilityChangeListener.onShow();
        }
        h.removeCallbacks(hidePanelRunable);
    }

    @Override
    public void show() {
    }

    @Override
    public void show(int timeout) {
    }

    @Override
    public void hide() {
        if(visibilityChangeListener != null) {
            visibilityChangeListener.onHide();
        }
    }

    public void onUserInteraction(){
        h.removeCallbacks(hidePanelRunable);
        showDelayed();
    }
}
