package pl.sdacademy.tasq.Flyweight;


import java.util.HashMap;

public class FlyFactory {
    public HashMap<String, FlyOne> flyHM = new HashMap<String, FlyOne>();

    public iFly getFlys(String category) {
        FlyOne fo = flyHM.get(category);
        if(fo==null)
        {
            fo = new FlyOne(category);
            flyHM.put(category,fo);
        }
        return fo;
    }
}
