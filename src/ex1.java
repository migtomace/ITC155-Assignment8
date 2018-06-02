import java.util.Random;

public class ex1 {

    public static void main(String[] args){
        ArrayIntList list = new ArrayIntList();
        for(int i = 0; i < 30; i++){
            Random rn = new Random();
            list.add(rn.nextInt(4));
        }
        System.out.println(list);

        list.lastIndexOf(3);
        list.lastIndexOf(20);

        list.replaceAll(3,256);
        System.out.println(list);
    }


}
