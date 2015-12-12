package drucc.sittichok.myrestaurant;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by mosza_000 on 12/12/2558.
 */
public class ManageTABLE {

    //Explicit
    private MyOpenHelper objMyOpenHelper;
    private SQLiteDatabase WriteSqLiteDatabase,reidSqLiteDatabase;


    public ManageTABLE(Context context) {

        // Connected Database
        objMyOpenHelper = new MyOpenHelper(context);
        WriteSqLiteDatabase = objMyOpenHelper.getWritableDatabase();
        reidSqLiteDatabase = objMyOpenHelper.getReadableDatabase();

    }   // Constructor


}   // Main Class
