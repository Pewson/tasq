package pl.sdacademy.tasq.Flyweight;

public class FlyOne implements iFly {
    private String category;

    public FlyOne(String category)
    {
        this.category = category;
    }

    @Override
    public void render() {
        System.out.printf("This %s is category %s",this,category);
        System.out.println("");
    }
}
