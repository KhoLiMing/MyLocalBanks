package sg.edu.rp.c346.mylocalbanks;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button DBS;
    Button OCBC;
    Button UOB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DBS=findViewById(R.id.buttonDBS);
        OCBC=findViewById(R.id.buttonOCBC);
        UOB=findViewById(R.id.buttonUOB);

        registerForContextMenu(DBS);
        registerForContextMenu(OCBC);
        registerForContextMenu(UOB);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.add(0,0,0,"Website");
        menu.add(0,1,1,"Contact the Bank");
    }




    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.EnglishSelection) {
            DBS.setText("DBS ");
            OCBC.setText("OCBC");
            UOB.setText("UOB");
            return true;

        }else if (id == R.id.ChineseSelection) {
            DBS.setText("星展银行 ");
            OCBC.setText("华侨银行");
            UOB.setText("大华银行");
            return true;
        }else  {
            DBS.setText("DBS ");
            OCBC.setText("OCBC");
            UOB.setText("UOB");
        }

        return super.onOptionsItemSelected(item);
    }

    public boolean onContextItemSelected(MenuItem item) {
        if(item.getItemId()==0) { //check whether the selected menu item ID is 0
            if(DBS.isLongClickable()){
                Intent intentView = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.dbs.com.sg"));
                startActivity(intentView);
                return true;
            }
            if(OCBC.isLongClickable()){
                Intent intentView = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ocbc.com"));
                startActivity(intentView);
                return true;
            }
            if(UOB.isLongClickable()){
                Intent intentView = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.uob.com.sg"));
                startActivity(intentView);
                return true;
            }


             //menu item successfully handled
        }
        else if(item.getItemId()==1) { //check if the selected menu item ID is 1
            //code for action
            if(DBS.isLongClickable()){
                Intent intentView = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:18001111111"));
                startActivity(intentView);
                return true;
            }
            if(OCBC.isLongClickable()){
                Intent intentView = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:18003633333"));
                startActivity(intentView);
                return true;
            }
            if(UOB.isLongClickable()){
                Intent intentView = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:18002222121"));
                startActivity(intentView);
                return true;
            }

        }

        return super.onContextItemSelected(item); //pass menu item to the superclass implementation
    }

}
