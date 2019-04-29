package testTask;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by tdd on 2019/2/25.
 */

public class Poker implements Comparable<Poker> {

    public String name;
    public String ID;

    public Poker(String name, String id) {
        this.name = name;
        this.ID = id;
    }

    public static List testCreatCard() {

        System.out.println("--------开始创建扑克牌--------");

        List list = new ArrayList<Poker>();

        String[] name = {"方块","梅花","红桃","黑桃"};
        for (String names : name
                ) {
            for (int i = 2; i < 15; i++) {
                if (i == 11) {
                    Poker poker = new Poker(names, "J");
                    list.add(poker);
                } else if (i == 12) {
                    Poker poker = new Poker(names, "Q");
                    list.add(poker);
                } else if (i == 13) {
                    Poker poker = new Poker(names, "K");
                    list.add(poker);
                } else if (i == 14) {
                    Poker poker = new Poker(names, "A");
                    list.add(poker);
                } else {
                    Poker poker = new Poker(names, i + "");
                    list.add(poker);
                }
            }

        }
        return list;
    }

    public static void printPoker(List<Poker> list){
        List<String> list2=new ArrayList<>();
        for (Poker poker:list
             ) {
            list2.add(poker.name+poker.ID);
        }
        System.out.println(list2);
    }

    @Override
    public String toString() {
        return name+ID;
    }

    public static void printList(List<Poker> list){
        String[] ss =new String[52];
        for (int i=0;i<52;i++){
            ss[i]=list.get(i).toString();
        }
        System.out.println(Arrays.toString(ss) );
    }

    @Override
    public int compareTo(@NonNull Poker another) {
        if (this.ID == another.ID){
            return this.ID.compareTo(another.ID);
        }else{
            if(this.name=="黑桃"){
                return 1;
            }else if(this.name=="红桃" && another.name!="黑桃"){
                return -1;
            }else if (this.name=="梅花" && another.name!="方块"){
                return -1;
            }else if (this.name=="梅花" && another.name == "方块"){
                return 1;
            }else {
                return -1;
            }
        }

    }

}
