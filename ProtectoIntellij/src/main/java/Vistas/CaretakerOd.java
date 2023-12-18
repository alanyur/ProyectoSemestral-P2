package Vistas;

import java.util.ArrayList;

public class CaretakerOd {
    public static Object addmementoOd;
    private static ArrayList<MementoOd> mementoOd = new ArrayList<>();
    public static void addmementoOd(MementoOd m){
        mementoOd.add(m);
    }
    public MementoOd getmementoOd(int index){
        return mementoOd.get(index);
    }
}
