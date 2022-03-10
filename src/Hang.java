
import acm.graphics.GCompound;
import acm.graphics.GOval;
import acm.graphics.GLine;

public class Hang extends GCompound{

    public GLine nusse,backstick,floorstick,topstick;

    public void hang(){
        GLine nusse = new GLine(199.5,50,199.5,40);
        add(nusse);
    }

}
