package Goose;

import java.util.*;

public class Space 
{
    private String name;
    private int size;
    private ArrayList<Thing> stuff;

    Space()
    {
        this.name = "genericSpace";
        this.size = 10;
        this.stuff = new ArrayList<Thing>();
    }

    Space(String n)
    {
        this.name = n;
        this.size = 10;
        this.stuff = new ArrayList<Thing>();
    }

    Space(String n, int s)
    {
        this.name = n;
        this.size = s;
        this.stuff = new ArrayList<Thing>();
    }

    public String getName()
    {
        return this.name;
    }

    public int getSize()
    {
        return this.size;
    }

    public ArrayList<Thing> getStuff()
    {
        return this.stuff;
    }

    public void setName(String n)
    {
        this.name = n;
    }

    public void setSize(int s)
    {
        this.size = s;
    }

    public void setStuff(ArrayList<Thing> s)
    {
        this.stuff = s;
    }

    public void generateStartStuff()
    {
        ArrayList<Thing> thingList = new ArrayList<>();
        for(int i=0; i<15; i++)
        {
            if(0 == i%2)
            {
                Thing bread = new Thing("BREAD", 1, 1, State.DROPPED);
                thingList.add(bread);
            }
            else
            {
                Thing stone = new Thing("STONE", 2, 1, State.DROPPED);
                thingList.add(stone);
            }
        }
        setStuff(thingList);
    }
}
