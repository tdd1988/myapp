package testTask;

import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * Created by tdd on 2019/2/25.
 */

public class Player {

    public int ID;
    public String name;
    public List<Poker> hascard;

    public Player(){

        while(!scanner());
        Scanner scanner = new Scanner(System.in);
        System.out.print("输入姓名:");
        this.name = scanner.next();

        this.hascard = new ArrayList<>();
    }

    public Boolean scanner(){

        Scanner scanner = new Scanner(System.in);
        System.out.print("输入ID:");
        try {
            this.ID = scanner.nextInt();
        }catch(InputMismatchException e){
            System.out.println("请输入整数类型的ID!");
            return scanner();
        }
        return true;
    }

    public static void takecard(Player player1,Player player2,List list){

        for(int i=0;i<3;i=i+2){
            System.out.println("玩家"+player1.name+"拿牌");
            player1.hascard.add((Poker)list.get(i));
            System.out.println("玩家"+player2.name+"拿牌");
            player2.hascard.add((Poker)list.get(i+1));
        }
    }

    public static void chooseWinner(Player player1,Player player2){

        Poker p1;
        Poker p2;
        if (player1.hascard.get(0).compareTo(player2.hascard.get(1))==1){
            p1 = player1.hascard.get(0);
        }else{p1 = player1.hascard.get(1);}

        if (player2.hascard.get(0).compareTo(player2.hascard.get(1))==1){
            p2 = player2.hascard.get(0);
        }else{p2 = player2.hascard.get(1);}

        System.out.println("玩家："+player1.name+"的最大手牌为 "+p1.name+p1.ID);
        System.out.println("玩家："+player2.name+"的最大手牌为 "+p2.name+p2.ID);

        if (p1.compareTo(p2)==1){
            System.out.println("玩家：" +player1.name+"获胜");
        }else {System.out.println("玩家：" +player2.name+"获胜");}

        System.out.println("玩家各自的手牌为：");
        System.out.print(player1.name+":");
        Poker.printPoker(player1.hascard);
        System.out.print(player2.name+":");
        Poker.printPoker(player2.hascard);
    }



}
