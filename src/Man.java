import acm.graphics.GCompound;
import acm.graphics.GOval;
import acm.graphics.GLine;

public class Man extends GCompound {

    public GLine legL,legR,body,armR,armL,topStick,floorStick,nusse,stickStick;
    public GOval head;

    //creates all of the body parts
    //create hang

    public void hanger(){
        floorStick = new GLine(450,350,600,350);
        stickStick = new GLine(floorStick.getX() + floorStick.getWidth()/2 ,350,floorStick.getX() + floorStick.getWidth()/2 ,150);
        topStick = new GLine(stickStick.getX(),stickStick.getY() - stickStick.getHeight(),floorStick.getX()*.95,stickStick.getY() - stickStick.getHeight());
        nusse = new GLine(topStick.getX() - topStick.getWidth(),topStick.getY(), topStick.getX() - topStick.getWidth(),stickStick.getHeight()*1.1);
        add(floorStick);
        add(stickStick);
        add(topStick);
        add(nusse);

    }
    public void manBody(){
        head = new GOval(35,35);
        add(head, 410,220);
        body = new GLine(head.getX() + head.getWidth()/2,300,head.getX() + head.getWidth()/2, 220+ 35);
        armL = new GLine(body.getX(),body.getY() - body.getHeight()/2,body.getX() - 25,body.getY() - 50);
        armR = new GLine(body.getX(),body.getY() - body.getHeight()/2,body.getX() + 25,body.getY() - 50);
        legL = new GLine(body.getX(),body.getY(),body.getX()-25,body.getY() + 25);
        legR = new GLine(body.getX(),body.getY(),body.getX()+25,body.getY() + 25);


        add(legL);
        add(legR);
        add(armR);
        add(armL);
        add(body);

    }
    public void manGone(){
        head.setVisible(false);
        body.setVisible(false);
        armL.setVisible(false);
        armR.setVisible(false);
        legR.setVisible(false);
        legL.setVisible(false);

    }



}



