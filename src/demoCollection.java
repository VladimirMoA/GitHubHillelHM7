public class demoCollection {

    public static String[] add(String stringAdd, int pos, String[] array) {
            if (pos > array.length+1) {
                System.out.println("Позиция, на которую  вы хотите поменять " +
                        "больше размера массива");
            }
            if (array.length+1 == pos) {
                String[] newArray = new String[array.length+1];
                System.arraycopy(array,0,newArray,0,array.length);
                newArray[pos-1] = stringAdd;
                array = new String[newArray.length];
                System.arraycopy(newArray,0,array,0,newArray.length);
            } else if (array[pos-1] == null) {
                array[pos-1] = stringAdd;
            } else {
                String[] newArray1 = new String[pos];
                System.arraycopy(array,0,newArray1,0,pos-1);
                newArray1[pos-1] = stringAdd;
                String[] newArray2 = new String[array.length+1];
                System.arraycopy(array,pos-1,newArray2,pos,array.length - pos+1);
                array = new String[array.length+1];
                System.arraycopy(newArray1,0,array,0,pos);
                System.arraycopy(newArray2,pos,array,pos,(array.length - (pos)));
            }
            return array;
    }

    public static String[] delete(int pos, String[] array) {
        if (pos > array.length+1) {
            System.out.println("Позиция, которую  вы хотите удалить " +
                    "больше размера массива");
        }
        if (pos == array.length) {
            String[] newArray = new String[array.length-1];
            System.arraycopy(array,0,newArray,0,array.length-1);
            array = new String[array.length-1];
            System.arraycopy(newArray,0,array,0,array.length);
        } else {
            String[] newArray1 = new String[pos-1];
            System.arraycopy(array,0,newArray1,0,pos-1);
            String[] newArray2 = new String[array.length-1];
            System.arraycopy(array,pos,newArray2,pos-1,array.length - pos);
            array = new String[array.length-1];
            System.arraycopy(newArray1,0,array,0,pos-1);
            System.arraycopy(newArray2,pos-1,array,pos-1,(array.length - (pos-1)));
        }
        return array;
    }

    public static void get(int index, String[] array) {
        System.out.println(array[index-1]);
    }

    public static boolean contains(String stringCont, String[] array) {
        boolean contains = false;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != stringCont) {
                continue;
            } else {
                contains = true;
            }
        }
        return contains;
    }

    public static void equals(String stringOne, String stringTwo) {
        if (stringOne == stringTwo) {
            System.out.println("Данные строки равны");
        } else System.out.println("Данные строки не равны");
    }

    public static String[] clear(String[] array) {
        array = new String[array.length];
        return array;
    }

    public static void indexOf(String indexOfString, String[] array) {
        int pos;
        if (contains(indexOfString,array) == true) {
            for (int i = 0; i < array.length; i++) {
                if (array[i] == indexOfString) {
                    pos = i;
                    System.out.println("Индекс данного элемента равен " + pos);
                }
            }
        } else System.out.println("Данного элемента в массиве нет");
    }

    public static void getSize(String[] array) {
        System.out.println(array.length);
    }

    public static void main(String[] args) {
        String[] array = new String[5];
        array[0] = "Один";
        array[1] = "Два";
        array[2] = "Три";
        array[3] = "Четыре";
        array[4] = "Пять";
        array = delete(2, array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
        }
        System.out.println();
        array = add("Два",2,array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
        }
        System.out.println();
        get(2,array);
        System.out.println(contains("Два",array));
        equals(array[1],array[1]);
        indexOf("Три",array);
        array = clear(array);
        getSize(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
        }
        System.out.println();
    }
}
