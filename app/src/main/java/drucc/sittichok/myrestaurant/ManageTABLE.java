package drucc.sittichok.myrestaurant;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by mosza_000 on 12/12/2558.
 */
public class ManageTABLE {

    //Explicit
    private MyOpenHelper objMyOpenHelper;
    private SQLiteDatabase WriteSqLiteDatabase, reidSqLiteDatabase;

    public static final String TABLE_USER = "userTABLE";
    public static final String COLUMN_id_ = "_id";
    public static final String COLUMN_User = "User";
    public static final String COLUMN_Password = "Password";
    public static final String COLUMN_Name = "Name";

    public static final String TABLE_FOOD = "foodTABLE";
    public static final String COLUMN_Food_ = "Food";
    public static final String COLUMN_Source = "Source";
    public static final String COLUMN_Price = "Price";


    public ManageTABLE(Context context) {

        // Connected Database
        objMyOpenHelper = new MyOpenHelper(context);
        WriteSqLiteDatabase = objMyOpenHelper.getWritableDatabase();
        reidSqLiteDatabase = objMyOpenHelper.getReadableDatabase();

    }   // Constructor

    public String[] searchUser(String strUser) {

        try {

            String[] strResult = null;
            Cursor objCursor = reidSqLiteDatabase.query(TABLE_USER,
                    new String[]{COLUMN_id_,COLUMN_User,COLUMN_Password,COLUMN_Name},
                    COLUMN_User + "=?",
                    new String[]{String.valueOf(strUser)},
                    null,null,null,null);

            if (objCursor != null) {

                if (objCursor.moveToFirst()) {

                    strResult = new String[4];
                    for (int i=0;i<4;i++) {
                        strResult[i] = objCursor.getString(i);
                    }

                }   // if2

            }   // if1
            objCursor.close();
            return strResult;

        } catch (Exception e) {
            return null;
        }

        //return new String[0];
    }


    public long addValueToUser(String strUser, String strPassword, String strName) {

        ContentValues objContentValues = new ContentValues();
        objContentValues.put(COLUMN_User,strUser);
        objContentValues.put(COLUMN_Password,strPassword);
        objContentValues.put(COLUMN_Name,strName);

        return WriteSqLiteDatabase.insert(TABLE_USER,null,objContentValues);
    }

    public long addValueToFood(String strFood,String strSource,String strPrice) {

        ContentValues objContentValues = new ContentValues();
        objContentValues.put(COLUMN_Food_,strFood);
        objContentValues.put(COLUMN_Source,strSource);
        objContentValues.put(COLUMN_Price,strPrice);


        return WriteSqLiteDatabase.insert(TABLE_FOOD,null,objContentValues);

    }

}   // Main Class
