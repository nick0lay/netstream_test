package ch.netstream;

import android.content.Context;
import ch.netstream.model.Broadcast;
import ch.netstream.model.Channel;
import ch.netstream.ui.Utils;
import com.google.gson.Gson;

/**
 * Created by Nikolay.Nikiforchuk on 17.06.2014.
 */
public class Controller {
    private static final String ASSETS_BROADCAST_NAME = "broadcast.json";
    private static final String ASSETS_CHANNEL_NAME = "channel.json";

    private static Controller instance;
    private Context context;

    private Controller(){

    }

    public void init(Context context){
        this.context = context;
    }

    public static Controller getInstance(){
        if(instance == null){
            instance = new Controller();
        }
        return instance;
    }

    public Broadcast getBroadCast() {
        String broadcast = Utils.loadJSONFromAsset(context, ASSETS_BROADCAST_NAME);
        if(broadcast == null){
            return null;
        }
        return (new Gson()).fromJson(broadcast, Broadcast.class);
    }

    public Channel getChannel() {
        String channel = Utils.loadJSONFromAsset(context, ASSETS_CHANNEL_NAME);
        if(channel == null){
            return null;
        }
        return (new Gson()).fromJson(channel, Channel.class);
    }
}
