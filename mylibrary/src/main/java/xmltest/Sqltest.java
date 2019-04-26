package xmltest;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tdd on 2019/3/27.
 */

public class Sqltest {
    static String dbFile = "/mnt/sdcard/Android/data/com.shishike.calm/calm/databases/calm.db";
    /**
     * 获取占用的桌台名
     * @return 桌台名
     */
    public static List<String> getUsedTableName(){
        String sql = "select table_name from tables where table_status != '0'";
        List<String> list = new ArrayList<String>();
        SQLiteDatabase db = SQLiteDatabase.openDatabase(dbFile, null, SQLiteDatabase.OPEN_READWRITE);
        Cursor cursor = db.rawQuery(sql, null);
        while (cursor.moveToNext()) {
            String tableName = cursor.getString(cursor.getColumnIndex("table_name"));
            list.add(tableName);
        }
        cursor.close();
        db.close();
        return list;
    }

    public static void main(String[] args) {
        String sql="select * from student where name='张三'";
        SQLiteDatabase sq= SQLiteDatabase.openDatabase(dbFile,null,SQLiteDatabase.OPEN_READONLY);

        Cursor cursor =sq.rawQuery(sql,null);
    }
}
