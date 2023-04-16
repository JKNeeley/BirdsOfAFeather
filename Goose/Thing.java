package Goose;

enum State {HELD, DROPPED}

public class Thing 
{
    private String name;
    private int weight;
    private int size;
    private State state;

    Thing()
    {
        this.name = "genericThing";
        this.weight = 1;
        this.size = 1;
        this.state = State.DROPPED;
    }

    Thing(String n, int w, int s, State st)
    {
        this.name = n;
        this.weight = w;
        this.size = s;
        this.state = st;
    }

    Thing(String n)
    {
        this.name = n;
        this.weight = 1;
        this.size = 1;
        this.state = State.DROPPED;
    }

    public String getName()
    {
        return this.name;
    }

    public int getWeight()
    {
        return this.weight;
    }

    public int getSize()
    {
        return this.size;
    }

    public State getState()
    {
        return this.state;
    }

    public void setName(String n)
    {
        this.name = n;
    }

    public void setWeight(int w)
    {
        this.weight = w;
    }

    public void setSize(int s)
    {
        this.size = s;
    }

    public void setState(State s)
    {
        this.state = s;
    }

    @Override
    public String toString() 
    {
        return this.name;
    }
}
