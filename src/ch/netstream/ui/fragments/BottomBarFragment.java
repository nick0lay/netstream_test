package ch.netstream.ui.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import ch.netstream.Controller;
import ch.netstream.R;
import ch.netstream.model.Broadcast;
import ch.netstream.model.Channel;
import ch.netstream.ui.Utils;

import java.util.Formatter;

/**
 * Created by Nikolay.Nikiforchuk on 09.06.2014.
 */
public class BottomBarFragment extends Fragment{
    private TextView movieName;
    private TextView movieTime;
    private ImageView channelLogo;
    private TextView channelName;

    private Broadcast broadcast;
    private Channel channel;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bottom_action_bar, container);
        movieName = (TextView)view.findViewById(R.id.movie_name);
        movieTime = (TextView)view.findViewById(R.id.movie_time);
        channelLogo = (ImageView)view.findViewById(R.id.channel_logo);
        channelName = (TextView)view.findViewById(R.id.channel_name);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        broadcast = Controller.getInstance().getBroadCast();
        channel = Controller.getInstance().getChannel();
        setMovieDuration();
        setMovieName();
        setChannelName();
    }

    private void setMovieDuration(){
        long startTime = broadcast.getStartTime();
        long endTime = broadcast.getEndTime();
        String duration = String.format(getString(R.string.format_duration_time,
                Utils.formatTime(startTime), Utils.formatTime(endTime)));
        movieTime.setText(duration);
    }

    private void setMovieName(){
       String name = broadcast.getTitle();
        if(name != null) {
            movieName.setText(name);
        }
    }

    private void setChannelName(){
        String name = channel.getName();
        if(name != null){
            channelName.setText(name);
        }
    }
}
