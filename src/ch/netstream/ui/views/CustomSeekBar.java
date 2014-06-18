package ch.netstream.ui.views;

import android.content.Context;
import android.graphics.*;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.SeekBar;
import ch.netstream.R;
import ch.netstream.ui.Utils;

/**
 * Created by Nikolay on 10.06.2014.
 */
public class CustomSeekBar extends SeekBar {
    private float fontSize;

    protected String overlayText = "";
    protected Paint textPaint;

    public CustomSeekBar(Context context) {
        super(context);
        initTextPaint();
    }

    public CustomSeekBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        initTextPaint();
    }

    public CustomSeekBar(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initTextPaint();
    }

    private void initTextPaint() {
        textPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        textPaint.setTypeface(Typeface.DEFAULT_BOLD);
        textPaint.setTextAlign(Paint.Align.LEFT);
        textPaint.setColor(getResources().getColor(R.color.seek_bar_font));
        fontSize = getResources().getDimension(R.dimen.seek_bar_text);
        textPaint.setTextSize(fontSize);

    }

    public void setOverlayText(String text) {
        this.overlayText = text;
        invalidate();
    }

    @Override
    protected synchronized void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if(overlayText.length() == 0) {
            return;
        }
        canvas.save();
        Rect bound = getThumb().getBounds();
        Rect textBound = new Rect();
        textPaint.getTextBounds(overlayText, 0, overlayText.length(), textBound);
        int x = bound.left;
        int y = bound.bottom - bound.height()/2 + textBound.height()/2;
        canvas.drawText(overlayText, x, y, textPaint);
        canvas.restore();
    }

    @Override
    public void setThumb(Drawable thumb) {
        super.setThumb(thumb);
    }

    @Override
    public void setThumbOffset(int thumbOffset) {
        super.setThumbOffset(thumbOffset);
    }

    @Override
    public synchronized void setProgress(int progress) {
        super.setProgress(progress);
        updatedThumb(progress);
    }

    private void updatedThumb(int progress){
        setOverlayText(Utils.formatDuration(progress));
    }
}
