package ch.netstream.model;

/**
 * Created by Nikolay.Nikiforchuk on 17.06.2014.
 */
public class Channel {
    private long channelId;
    private String language;
    private long foChannelId;
    private boolean isRecordable;
    private String replayActivation;
    private String quality;
    private String channelProvider;
    private boolean replayAvailable;
    private long bsChannelId;
    private boolean isAdultContent;
    private boolean hd;
    private String channelType;
    private String name;

    public long getChannelId() {
        return channelId;
    }

    public String getLanguage() {
        return language;
    }

    public long getFoChannelId() {
        return foChannelId;
    }

    public boolean isRecordable() {
        return isRecordable;
    }

    public String getReplayActivation() {
        return replayActivation;
    }

    public String getQuality() {
        return quality;
    }

    public String getChannelProvider() {
        return channelProvider;
    }

    public boolean isReplayAvailable() {
        return replayAvailable;
    }

    public long getBsChannelId() {
        return bsChannelId;
    }

    public boolean isAdultContent() {
        return isAdultContent;
    }

    public boolean isHd() {
        return hd;
    }

    public String getChannelType() {
        return channelType;
    }

    public String getName() {
        return name;
    }
}
