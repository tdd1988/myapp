package dsass;

import com.google.gson.Gson;

import java.util.List;


import org.json.JSONArray;
import org.json.JSONObject;



/**
 * Created by tdd on 2019/5/20.
 */

public class jsonTest {
    private String name;
    private String age;
    private List<String> scr;

    public String getName(){
        return name;
    }

    public String getAge(){
        return age;
    }

    public List<String> getScr(){
        return scr;
    }

    @Override
    public String toString() {
        return "jsonTest[name="+name+" "+"age="+age+" "+"scr="+scr+"]";
    }

    public static void main(String[] args) {
        Gson gson=new Gson();
        String json1="{'name':'zhangsan','age':23,'scr':[{'牛1':'嘻嘻'},{'牛二':'哈哈'}]}";
        //jsonTest js=gson.fromJson(json1,jsonTest.class);
        //System.out.println(js.toString());
        try
           {
               JSONObject js1=new JSONObject(json1);
               JSONArray js2=js1.getJSONArray("scr");
        }
        catch (Exception E){

        };


    }
}
