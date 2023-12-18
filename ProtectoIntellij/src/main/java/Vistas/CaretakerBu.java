package Vistas;

import java.util.ArrayList;

public class CaretakerBu {
    public static Object addmementoBus;
    private static ArrayList<MementoBu> mementoBus = new ArrayList<>();
    public static void addmementoBus(MementoBu m){
        mementoBus.add(m);
    }
    public MementoBu getmementobu(int index){
        return mementoBus.get(index);
    }
}
