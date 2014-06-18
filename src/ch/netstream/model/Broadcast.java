package ch.netstream.model;

/**
 * Created by Nikolay.Nikiforchuk on 17.06.2014.
 */
public class Broadcast {
    private long startTime;
    private long duration;
    private long endTime;
    private long broadcastId;
    private String genre;
    private long channelId;
    private String title;
    private long expireAt;
    private String channelName;
    private String originalBroadcastId;
    private long fokusonChannelId;
    private String productionYear;
    private String ageRating;
    private String starRating;
    private String episodeTitle;
    private long episodeNumProgId;
    private String episodeNumOnScreen;
    private String subGenre;
    private String longText;
    private String uiGenre;
    private SeriesId seriesId;
    private boolean blackAndWhite;
    private boolean dolby;
    private boolean dolbyDigital;
    private boolean hd;
    private boolean dualTone;
    private boolean wideScreen;
    private boolean stereo;
    private int[] contributors;
    private String scheduled;
    private String scheduledPeriodical;
    private String documentType;
    private String language;
    private String id;
    private String country;

    public class SeriesId {
        private String netstreamId;
        private long defaultId;
        private long globalId;
    }

    public long getStartTime() {
        return startTime;
    }

    public long getDuration() {
        return duration;
    }

    public long getEndTime() {
        return endTime;
    }

    public long getBroadcastId() {
        return broadcastId;
    }

    public String getGenre() {
        return genre;
    }

    public long getChannelId() {
        return channelId;
    }

    public String getTitle() {
        return title;
    }

    public long getExpireAt() {
        return expireAt;
    }

    public String getChannelName() {
        return channelName;
    }

    public String getOriginalBroadcastId() {
        return originalBroadcastId;
    }

    public long getFokusonChannelId() {
        return fokusonChannelId;
    }

    public String getProductionYear() {
        return productionYear;
    }

    public String getAgeRating() {
        return ageRating;
    }

    public String getStarRating() {
        return starRating;
    }

    public String getEpisodeTitle() {
        return episodeTitle;
    }

    public long getEpisodeNumProgId() {
        return episodeNumProgId;
    }

    public String getEpisodeNumOnScreen() {
        return episodeNumOnScreen;
    }

    public String getSubGenre() {
        return subGenre;
    }

    public String getLongText() {
        return longText;
    }

    public String getUiGenre() {
        return uiGenre;
    }

    public SeriesId getSeriesId() {
        return seriesId;
    }

    public boolean isBlackAndWhite() {
        return blackAndWhite;
    }

    public boolean isDolby() {
        return dolby;
    }

    public boolean isDolbyDigital() {
        return dolbyDigital;
    }

    public boolean isHd() {
        return hd;
    }

    public boolean isDualTone() {
        return dualTone;
    }

    public boolean isWideScreen() {
        return wideScreen;
    }

    public boolean isStereo() {
        return stereo;
    }

    public int[] getContributors() {
        return contributors;
    }

    public String getScheduled() {
        return scheduled;
    }

    public String getScheduledPeriodical() {
        return scheduledPeriodical;
    }

    public String getDocumentType() {
        return documentType;
    }

    public String getLanguage() {
        return language;
    }

    public String getId() {
        return id;
    }

    public String getCountry() {
        return country;
    }
}