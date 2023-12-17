package Vistas;

import java.util.ArrayList;

public class CaretakerOR {
    public static Object addmementoOR;
    private static ArrayList<MementoOR> mementoOR = new ArrayList<>();
    public static void addmementoOR(MementoOR m){
        mementoOR.add(m);
    }
    public MementoOR getmementoOR(int index){
        return mementoOR.get(index);
    }
}
