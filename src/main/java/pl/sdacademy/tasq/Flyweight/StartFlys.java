package pl.sdacademy.tasq.Flyweight;

public class StartFlys {
    public static void main(String[] args)
    {
        FlyFactory ff = new FlyFactory();
        iFly f1 = ff.getFlys("One");
        iFly f2 = ff.getFlys("Two");
        iFly f3 = ff.getFlys("Tri");
        iFly f4 = ff.getFlys("One");
        iFly f5 = ff.getFlys("Two");
        iFly f6 = ff.getFlys("Two");
        f1.render();
        f2.render();
        f3.render();
        f4.render();
        f5.render();
        f6.render();
    }
}
