package Codigo;

public interface Bus_Iterator <T>{
    boolean hasNext();

    int getNext();
    static void Llenar(int[][] matriz){
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = 0;
            }
        }
    }


}
