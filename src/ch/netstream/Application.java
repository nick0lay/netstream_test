package ch.netstream;

/**
 * Created by Nikolay on 18.06.2014.
 */
public class Application extends android.app.Application{
    @Override
    public void onCreate() {
        super.onCreate();
        Controller.getInstance().init(this);
    }
}
