package ch.netstream;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.SeekBar;
import android.widget.VideoView;
import ch.netstream.ui.listeners.OnVisibilityChangeListener;
import ch.netstream.ui.views.CustomMediaController;
import ch.netstream.ui.views.CustomSeekBar;

/**
 * Created by Nikolay on 09.06.2014.
 */
public class StreamingActivity extends Activity implements OnVisibilityChangeListener{
    public final String TAG = getClass().getSimpleName();
    private final long UPDATE_INTERVAL = 1000;

    private VideoView video;
    private Fragment boottomBarFragment;
    private Fragment streamingFragment;
    private CustomMediaController mc;
    private CustomSeekBar seekBar;
    private boolean isUpdateSeekBar = false;
    private int initialPosition = 0;
    private Handler handler = new Handler();
    private Runnable seekBarUpdate = new Runnable() {
        @Override
        public void run() {
            handler.postDelayed(seekBarUpdate, UPDATE_INTERVAL);
            updateSeekBar();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_streaming);
        seekBar = (CustomSeekBar)findViewById(R.id.seekBar);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(fromUser){
                    video.seekTo(progress);
                    seekBar.setProgress(progress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        boottomBarFragment = getFragmentManager().findFragmentById(R.id.fragment_bottom_action_bar);
        streamingFragment = getFragmentManager().findFragmentById(R.id.fragment_bottom_action_bar);
        hideBottomBar();
        video = (VideoView) findViewById(R.id.video);
        video.setVideoURI(Uri.parse("http://devimages.apple.com/iphone/samples/bipbop/gear1/prog_index.m3u8"));
        video.requestFocus();
        video.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            public void onPrepared(MediaPlayer mp) {
                mp.start();
                mp.setAudioStreamType(AudioManager.STREAM_MUSIC);
                Log.d(TAG, "Position on start " + mp.getCurrentPosition());
                initialPosition = mp.getCurrentPosition();
                seekBar.setMax(mp.getDuration() + initialPosition);
                updateSeekBar();
                mc.showDelayed();
            }
        });


        video.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mp.seekTo(0);
                updateSeekBar();
                mp.start();
                mc.showDelayed();
            }
        });
        mc = new CustomMediaController(this);
        mc.setHovered(true);
        video.setMediaController(mc);
        video.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                doPausePlay();
                return false;
            }
        });

        View decorView = getWindow().getDecorView();
        decorView.setVisibility(View.INVISIBLE);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mc.setOnVisibilityChangeListener(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mc.setOnVisibilityChangeListener(null);
    }

    private void updateSeekBar(){
        seekBar.setProgress(video.getCurrentPosition());
        Log.d(TAG, "Seek bar updated with duration - " + video.getDuration() +
            " currentPosition " + video.getCurrentPosition());
    }

    private void doPausePlay() {
        if (video.isPlaying()) {
            video.pause();
            mc.showNow();
        } else {
            video.start();
            mc.onUserInteraction();
            mc.showDelayed();
        }
    }

    private void hideBottomBar(){
        onHide();
    }

    @Override
    public void onShow() {
        Log.d(TAG, "Show seek fragment");
        startSeekBarUpdate();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.show(boottomBarFragment);
        transaction.commit();
    }

    @Override
    public void onHide() {
        Log.d(TAG, "Hide seek fragment");
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.hide(boottomBarFragment);
        transaction.commit();
        stopSeekBarUpdate();
    }

    private void startSeekBarUpdate(){
        Log.d(TAG, "Start seekbar update");
        handler.postAtFrontOfQueue(seekBarUpdate);
    }

    private void stopSeekBarUpdate(){
        Log.d(TAG, "Stop seekbar update");
        handler.removeCallbacks(seekBarUpdate);
    }
}
