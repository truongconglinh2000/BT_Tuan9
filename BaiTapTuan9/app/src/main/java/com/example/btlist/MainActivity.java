package com.example.btlist;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{

    ListView lvSinger;
    ArrayList<Singer> arraySinger;
    ArrayList<Singer> UserSelection;
    SingerAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXa();
        adapter = new SingerAdapter(this,R.layout.line_singer,arraySinger);
        lvSinger.setAdapter(adapter);
        lvSinger.setChoiceMode(AbsListView.CHOICE_MODE_MULTIPLE_MODAL);
        lvSinger.setMultiChoiceModeListener(modeListener);


    }
    private void AnhXa(){
        lvSinger =(ListView) findViewById(R.id.listview);
        UserSelection = new ArrayList<>();
        arraySinger = new ArrayList<>();
        arraySinger.add(new Singer("V","BTS",R.drawable.v02));
        arraySinger.add(new Singer("Kim Jiso","BlackPink",R.drawable.jiso));
        arraySinger.add(new Singer("Kim Jenie","BlackPink",R.drawable.jennie));
        arraySinger.add(new Singer("B.I","Ikon",R.drawable.bi));
        arraySinger.add(new Singer("Kim Yohan","X1",R.drawable.yohan));

    }


    AbsListView.MultiChoiceModeListener modeListener= new AbsListView.MultiChoiceModeListener() {
        @Override
        public void onItemCheckedStateChanged(ActionMode actionMode, int i, long l, boolean b) {
            if(UserSelection.contains(arraySinger.get(i)))
            {

                UserSelection.remove(arraySinger.get(i));
            }
            else
            {
                UserSelection.add(arraySinger.get(i));
            }
            actionMode.setTitle(UserSelection.size()+" items");
        }

        @Override
        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            MenuInflater menuInflater = actionMode.getMenuInflater();
            menuInflater.inflate(R.menu.menu_main,menu);
            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            return false;
        }

        @Override
        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.delete:
                    adapter.removeItems(UserSelection);
                    actionMode.finish();
                    return true;
                default:
                    return false;
            }
        }

        @Override
        public void onDestroyActionMode(ActionMode actionMode) {
            UserSelection.clear();
        }
    };


}