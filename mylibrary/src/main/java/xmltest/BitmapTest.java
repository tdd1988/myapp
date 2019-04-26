package xmltest;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.robotium.solo.Solo;

/**
 * Created by tdd on 2019/4/1.
 */

public class BitmapTest {

    public static void main(String[] args) {
        Bitmap bs = BitmapFactory.decodeFile("/Users/tdd/Desktop/tdd.jpg");
        Bitmap bs2 = BitmapFactory.decodeFile("/Users/tdd/Desktop/tdd的副本.jpg");
        boolean isSame = Bitmap.createBitmap(bs, 0, 0, 10, 10).sameAs(Bitmap.createBitmap(bs2, 0, 0, 10, 10));

        System.out.println(isSame);
        Solo solo;

    }
}
