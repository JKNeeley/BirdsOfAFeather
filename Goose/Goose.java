package Goose;

import java.util.*;

class Goose
{
    private int age; // 1-15
    private int size; // 1-10 depending on age
    private int canhold; // 0-5 depending on size and age
    private int carryweight; // how much a goose carries

    private String name; // tell geese apart
    private Space location; // where a goose is
    private ArrayList<Thing> stuff; // what a goose has
    private ArrayList<String> past; // what a goose did
    
    Goose()
    {
        this.age = 1;
        this.size = 1;
        this.canhold = 0;
        this.carryweight = 0;
        
        this.name = "genericGoose";
        this.location = new Space();
        this.stuff = new ArrayList<Thing>();
        this.past = new ArrayList<String>();
    }
    
    Goose(int a, int s, int ch, int cw, String n)
    {
        this.age = a;
        this.size = s;
        this.canhold = ch;
        this.carryweight = cw;
        
        this.name = n;
        this.location = new Space();
        this.stuff = new ArrayList<Thing>();
        this.past = new ArrayList<String>();
    }

    Goose(String n)
    {
        this.age = 1;
        this.size = 1;
        this.canhold = 0;
        this.carryweight = 0;
        
        this.name = n;
        this.location = new Space();
        this.stuff = new ArrayList<Thing>();
        this.past = new ArrayList<String>();
    }

    public int getAge()
    {
        return this.age;
    }

    public int getSize()
    {
        return this.size;
    }

    public int getCanHold()
    {
        return this.canhold;
    }

    public int getCarryWeight()
    {
        return this.carryweight;
    }

    public String getName()
    {
        return this.name;
    }

    public ArrayList<Thing> getStuff()
    {
        return this.stuff;
    }

    public ArrayList<String> getPast()
    {
        return this.past;
    }

    public Space getLocation()
    {
        return this.location;
    }

    public void setAge(int a)
    {
        this.age = a;
    }

    public void setSize(int s)
    {
        this.size = s;
    }

    public void setCanHold(int ch)
    {
        this.canhold = ch;
    }

    public void setCarryWeight(int cw)
    {
        this.carryweight = cw;
    }

    public void setName(String n)
    {
        this.name = n;
    }

    public void setStuff(ArrayList<Thing> s)
    {
        this.stuff = s;
    }

    public void setPast(ArrayList<String> p)
    {
        this.past = p;
    }

    public void setLocation(Space l)
    {
        this.location = l;
    }

    public boolean isAlive()
    {
        if(this.getAge() > 0 && this.getAge() <= 5)
        {
            return true;
        }
        return false;
    }

    public void ageGoose()
    {
        this.setAge(this.getAge() + 1);
    }

    public void growGoose()
    {
        this.setSize(this.getSize() + 1);
    }

    public void getActionOptions()
    {
        System.out.println("| Your goose can:                                                   |");
        System.out.println("|       (1) make noise                                              |");
        System.out.println("|       (2) pick something up                                       |");
        System.out.println("|       (3) put something down                                      |");
        System.out.println("|       (4) consume something                                       |");
    }

    public int getAction(Scanner userInput) //throws Exception
    {
        try
        {
            return userInput.nextInt();
        } 
        catch(Exception e)
        {
            userInput.nextLine();
        }
        return -1;
    }

    public void doAction(int i)
    {
        String actionString;
        if(-1 == i)
        {
            System.out.println("| ----------------------- Frog:  bad action ----------------------- |");
            System.out.println("|                                                                   |");
            actionString = invalidAction();
        }
        else if(1 == i)
        {
            System.out.println("| You chose (1). Your goose will make a noise.                      |");
            System.out.println("|                                                                   |");
            actionString = makeNoise();
        }
        else if(2 == i)
        {
            System.out.println("| You chose (2). Your goose will pick something up.                 |");
            System.out.println("|                                                                   |");
            actionString = pickUp();
        }
        else if(3 == i)
        {
            System.out.println("| You chose (3). Your goose will put something down.                |");
            System.out.println("|                                                                   |");
            actionString = putDown();
        }
        else if(4 == i)
        {
            System.out.println("| You chose (4). Your goose will consume something.                 |");
            System.out.println("|                                                                   |");
            actionString = consume();
        }
        else
        {
            System.out.println("| You chose an invalid action. Your goose will not do anything.     |");
            System.out.println("|                                                                   |");
            actionString = invalidAction();
        }

        addToPast(actionString);
    }

    public String makeNoise()
    {
        System.out.println("|     HONK                                                          |");
        return "   HONKS   ";
    }

    public String pickUp()
    {
        Thing thisThing = chooseThing(this.getLocation().getStuff());
        if(thisThing == null)
        {
            return invalidAction();
        }
        this.getLocation().getStuff().remove(thisThing);
        this.stuff.add(thisThing);
        System.out.println("|     PICK UP " + thisThing + "                                                 |");
        return "  PICK UP  ";
    }

    public String putDown()
    {
        Thing thisThing = chooseThing(this.getStuff());
        if(thisThing == null)
        {
            return invalidAction();
        }
        this.stuff.remove(thisThing);
        this.getLocation().getStuff().add(thisThing);
        System.out.println("|     PUT  DOWN " + thisThing + "                                               |");
        return " PUT  DOWN ";
    }

    public String consume()
    {
        Thing thisThing = chooseThing(this.getStuff());
        this.stuff.remove(thisThing);
        this.growGoose();
        System.out.println("|     CONSUME " + thisThing + "                                                 |");
        return "  CONSUME  ";
    }

    public String invalidAction()
    {
        System.out.println("|     NOTHING                                                       |");
        return "  NOTHING  ";
    }

    public void addToPast(String a)
    {
        past.add(a);
    }
    public static Thing chooseThing(ArrayList<Thing> s)
    {
        if(s == null || s.isEmpty() ||(s.size() == 0))
        {
            return null;
        }
        return s.get(0);
    }

    public void showPast()
    {
        int year = 1;
        while(!past.isEmpty())
        {
            HonkUtil.pause();
            System.out.println("| Your goose did this in year (" + year + "):                                  |");
            System.out.print( "|        " + past.get(0) + " ");
            past.remove(0);
            System.out.print( past.get(0) + " ");
            past.remove(0);
            System.out.print( past.get(0) + "                        |\n");
            past.remove(0);
            System.out.println("|                                                                   |");
            year++;
        }
    }


    @Override
    public String toString() 
    {
        return this.name;
    }
}
