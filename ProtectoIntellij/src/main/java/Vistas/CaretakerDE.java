package Vistas;

import java.util.ArrayList;

public class CaretakerDE {
    public static Object addmementoDE;
    private static ArrayList<MementoDE> mementoDE = new ArrayList<>();
    public static void addmementoDE(MementoDE m){
        mementoDE.add(m);
    }
    public MementoDE getmementoDE(int index){
        return mementoDE.get(index);
    }
}
