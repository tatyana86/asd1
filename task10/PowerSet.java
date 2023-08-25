import java.util.ArrayList;

public class PowerSet
{
    public ArrayList<String> list;

    public PowerSet()
    {
        list = new ArrayList<String>();
    }

    public int size()
    {
        return list.size();
    }


    public void put(String value)
    {
        if(!list.contains(value)) {
            list.add(value);
        }
    }

    public boolean get(String value)
    {
        return list.contains(value);
    }

    public boolean remove(String value)
    {
        return list.remove(value);
    }

    public PowerSet intersection(PowerSet set2)
    {
        PowerSet intersect= new PowerSet();
        for(int i = 0; i < list.size(); i ++) {
            if(set2.get(list.get(i))) {
                intersect.put(list.get(i));
            }
        }
        return intersect;
    }

    public PowerSet union(PowerSet set2)
    {
        PowerSet un = new PowerSet();
        for(int i = 0; i < list.size(); i ++) {
            un.put(list.get(i));
        }
        for(String s : set2.list) {
            un.put(s);
        }
        return un;
    }

    public PowerSet difference(PowerSet set2)
    {
        PowerSet differ= new PowerSet();
        for(int i = 0; i < list.size(); i ++) {
            if(!set2.get(list.get(i))) {
                differ.put(list.get(i));
            }
        }
        return differ;
    }

    public boolean isSubset(PowerSet set2)
    {
        for(String s : set2.list) {
            if(!get(s)) {
                return false;
            }
        }
        return true;
    }
}