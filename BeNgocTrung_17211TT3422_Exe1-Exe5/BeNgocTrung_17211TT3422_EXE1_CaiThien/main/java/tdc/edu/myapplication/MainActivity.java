package tdc.edu.myapplication;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView,recyclerViewRock,recyclerViewBalad;
    RecyclerView.LayoutManager layoutManager,layoutManager2,layoutManager3;
    HobbieAdapter adapter;
    ArrayList<Hobbies> data = new ArrayList<>();
    ArrayList<Hobbies> dataRock = new ArrayList<>();
    ArrayList<Hobbies> dataBalad = new ArrayList<>();
    EditText txtCasy, txtSong;
    Button btnNhap;
    RadioButton rbnPop, rbnRock, rbBallad;
    int themeId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setAdapter();
        setEvent();
        adapter.setOnItemClickListener(new HobbieAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View itemView, int position) {
                Hobbies hb = data.get(position);
                Toast.makeText(MainActivity.this, hb.toString(), Toast.LENGTH_SHORT).show();
            }
        });
        adapter.setOnItemClickListener(new HobbieAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View itemView, int position) {
                Hobbies hb = dataRock.get(position);
                Toast.makeText(MainActivity.this, hb.toString(), Toast.LENGTH_SHORT).show();
            }
        });
        adapter.setOnItemClickListener(new HobbieAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View itemView, int position) {
                Hobbies hb = dataBalad.get(position);
                Toast.makeText(MainActivity.this, hb.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    void setAdapter() {
        txtCasy = (EditText) findViewById(R.id.txtSingerName);
        txtSong= (EditText) findViewById(R.id.txtBaiHat);
        rbnPop = (RadioButton) findViewById(R.id.rbnPop);
        rbBallad = (RadioButton) findViewById(R.id.rbnBallad);
        rbnRock = (RadioButton) findViewById(R.id.rbnRock);
        btnNhap = (Button) findViewById(R.id.btnNhap);
        recyclerView = findViewById(R.id.recycleView);
        //recyclerViewRock=findViewById(R.id.recycleViewRock);
        recyclerViewBalad =findViewById(R.id.recycleViewBalad);

        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        adapter = new HobbieAdapter(this, data, R.layout.listview_item_row);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

    /*    layoutManager2 = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        adapter = new HobbieAdapter(this, dataRock, R.layout.listview_item_row);
        recyclerViewRock.setLayoutManager(layoutManager2);
        recyclerViewRock.setAdapter(adapter);*/

        layoutManager3 = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        adapter = new HobbieAdapter(this, dataBalad, R.layout.listview_item_row);
        recyclerViewBalad.setLayoutManager(layoutManager3);
        recyclerViewBalad.setAdapter(adapter);

    }

    void setEvent() {
        btnNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (txtCasy.getText().toString().equals("") || txtSong.getText().toString().equals("")) {
                    Toast.makeText(MainActivity.this, "Phải nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                } else {
                    if (rbnPop.isChecked()) {
                        data.add(new Hobbies(R.drawable.pop, txtCasy.getText().toString(), txtSong.getText().toString(), "pop"));
                        Toast.makeText(MainActivity.this, "Đã lưu thành công", Toast.LENGTH_SHORT).show();
                    } else if (rbnRock.isChecked()) {
                        dataRock.add(new Hobbies(R.drawable.images, txtCasy.getText().toString(), txtSong.getText().toString(), "Rock & roll"));
                        Toast.makeText(MainActivity.this, "Đã lưu thành công", Toast.LENGTH_SHORT).show();
                    } else {
                        dataBalad.add(new Hobbies(R.drawable.ballad, txtCasy.getText().toString(), txtSong.getText().toString(), "ballad"));
                        Toast.makeText(MainActivity.this, "Đã lưu thành công", Toast.LENGTH_SHORT).show();
                    }
                    adapter.notifyDataSetChanged();
                    txtSong.setText("");
                    txtCasy.setText("");
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.thememenu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.Change:

                break;
        }
        return super.onOptionsItemSelected(item);
    }

}

