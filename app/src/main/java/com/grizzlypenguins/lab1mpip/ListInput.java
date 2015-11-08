package com.grizzlypenguins.lab1mpip;

/**
 * Created by Darko on 08.11.2015.
 */
public class ListInput {

    String text;
    String time;
    public ListInput ( String t , String ti)
    {
        text= t;
        time = ti;
    }
    public String get_row()
    {
        return text+time;
    }

    @Override
    public String toString() {
        return text+"  "+ time;

    }
}
