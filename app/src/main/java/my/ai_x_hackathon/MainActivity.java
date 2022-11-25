package my.ai_x_hackathon;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    MapFragment mapFragment;
    InfoFragment infoFragment = new InfoFragment();
    StoreFragment storeFragment = new StoreFragment();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mapFragment= new MapFragment(this);
        BottomNavigationView bottomNavigationView = findViewById(R.id.navigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(new ItemSelectedListener());
        bottomNavigationView.setSelectedItemId(R.id.MapIcon);
    }


    class ItemSelectedListener implements BottomNavigationView.OnNavigationItemSelectedListener{
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
//            FragmentManager fragmentManager = getSupportFragmentManager();
//            FragmentTransaction transaction = fragmentManager.beginTransaction();

            switch(menuItem.getItemId())
            {
                case R.id.LocationIcon:
                    openFragment(storeFragment);
                    break;

                case R.id.RankIcon:
                    openFragment(infoFragment);
                    break;

                case R.id.MapIcon:
                    openFragment(mapFragment);
                    break;
            }
            return true;
        }
    }

    private void openFragment(final Fragment fragment)   {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.frameLayout_main, fragment);
        transaction.addToBackStack(null);
        transaction.commitAllowingStateLoss();
    }


    @Override
    public boolean onKeyDown(int keycode, KeyEvent event) {
        if(keycode == KeyEvent.KEYCODE_BACK) {
            //Toast.makeText(this, "뒤로가기버튼이 눌렸습니다",Toast.LENGTH_LONG).show();
            final AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("exit");
            builder.setMessage("종료 하시겠습니까?");
            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });
            builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    //Toast.makeText(getApplicationContext(),"취소",Toast.LENGTH_SHORT).show();
                }
            });
            builder.create().show();

            return true;
        }

        return false;
    }

}