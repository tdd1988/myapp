package xmltest;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.UUID;

/**
 * Created by tdd on 2019/3/22.
 */

public class TestXml {

    public static void main(String[] args) {
       String uuid = UUID.randomUUID().toString();
        System.out.println(uuid);
        System.out.println(uuid.length());
        String uuid2=uuid.replaceAll("-","");
        System.out.println(uuid2.length());

    }




}
