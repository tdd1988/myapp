package testTask;

import java.util.Collections;
import java.util.List;

/**
 * Created by tdd on 2019/2/26.
 */

public class Playgames {
    public static void main(String[] args) {

        List list=Poker.testCreatCard();
        if(list.size()==52){
            //Poker.printPoker(list);
            Poker.printList(list);
            System.out.println("------创建扑克牌成功！------");
        }else {
            System.out.println("扑克牌创建失败！！！");
        }
        System.out.println("开始洗牌");
        Collections.shuffle(list);
        System.out.println("洗牌结束");

        System.out.println("创建玩家");
        System.out.println("请输入第一位玩家的ID和姓名：");
        Player player1= new Player();
        System.out.println("请输入第二位玩家的ID和姓名：");
        Player player2= new Player();
        System.out.println("----欢迎玩家"+player1.name);
        System.out.println("----欢迎玩家"+player2.name);
        System.out.println("----开始发牌----");
        Player.takecard(player1,player2,list);
        System.out.println("----发牌结束----");
        System.out.println("----开始游戏----");
        Player.chooseWinner(player1,player2);

    }

}
