package util;

public class Sort extends List {

    public static <E extends Comparable<E>> void sort(List<E> list){
        for (int i = 0; i < list.size(); i++){
            for (int j = i; j > 0; j--){
                switch(list.get(j).compareTo(list.get(j-1))){
                    case(1):
                        E holdingVar = list.get(j);
                        list.set(j, list.get(j-1));
                        list.set(j-1, holdingVar);
                    default:
                        j = 0;
                }
            }
        }
    }


}
