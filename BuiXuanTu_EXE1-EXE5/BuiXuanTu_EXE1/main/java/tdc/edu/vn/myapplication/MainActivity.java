package tdc.edu.vn.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import java.text.SimpleDateFormat;
import java.util.Date;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    TextView tv1;
    EditText ed1, ed2;
    Button bt1;
    String value, value1;
    RecyclerView rvChoiGame, rvDocSach, rvDaBong;

    RecyclerView.LayoutManager rvlm;
    Adapter ad;
    ArrayList<SoThich> data_choigame = new ArrayList<>();
    ArrayList<SoThich> data_docsach = new ArrayList<>();
    ArrayList<SoThich> data_dabong = new ArrayList<>();

    String h;
    RadioButton r1,r2,r3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setControl();


        setAdapter(rvDocSach, data_docsach);
        setAdapter(rvDaBong, data_dabong);
        setAdapter(rvChoiGame, data_choigame);
        setEvent();
    }

    private void setEvent() {
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (kiemTra()) return;
                int img;
                String txtNguoiViet, txtBanThan, txtNgay, txtSoThich;
                txtNguoiViet = ed1.getText().toString();
                txtBanThan = ed2.getText().toString();
                txtNgay = h.toString();
                SoThich st = null;

               if(r1.isChecked()){
                   img = R.drawable.game;
                   txtSoThich = "Choi game";
                   st = new SoThich(img, txtNguoiViet, txtBanThan, txtNgay, txtSoThich);
                   data_choigame.add(st);
                   setAdapter(rvChoiGame, data_choigame);

               }
               else if(r2.isChecked()){
                   img = R.drawable.read;
                   txtSoThich = "Doc sach";
                   st = new SoThich(img, txtNguoiViet, txtBanThan, txtNgay, txtSoThich);
                   data_docsach.add(st);
                   ad.notifyDataSetChanged();
                   setAdapter(rvDocSach, data_docsach);
               }
               else {
                   img = R.drawable.football;
                   txtSoThich = "Da bong";
                   st = new SoThich(img, txtNguoiViet, txtBanThan, txtNgay, txtSoThich);
                   data_dabong.add(st);
                   setAdapter(rvDaBong, data_dabong);
               }

                Toast.makeText(getApplicationContext(), "Dữ liệu đã được lưu!!!", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void setControl() {
        rvChoiGame = findViewById(R.id.rv_choigame);
        rvDocSach = findViewById(R.id.rv_docsach);
        rvDaBong = findViewById(R.id.rv_dabong);
        tv1 = findViewById(R.id.tv1);
        ed1 = findViewById(R.id.ed1);
        ed2 = findViewById(R.id.ed2);
        bt1 = findViewById(R.id.bt1);
        r1 = findViewById(R.id.rdgame);
        r2 = findViewById(R.id.rdread);
        r3 = findViewById(R.id.rdfootball);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        h = sdf.format(new Date());
        tv1.setText("Bây giờ là ngày:" + h);

    }

    public boolean kiemTra() {
        if (ed1.getText().toString().equals("")) {
            Toast.makeText(getApplicationContext(), "Không có tên hả bạn :)", Toast.LENGTH_LONG).show();
            ed1.requestFocus();
            return true;
        }
        if (ed2.getText().toString().equals("")) {
            Toast.makeText(getApplicationContext(), "Bản thân bạn không có gì miêu tả sao :?", Toast.LENGTH_LONG).show();
            ed2.requestFocus();
            return true;
        }

        return false;
    }

    public void setAdapter(RecyclerView recyclerView, ArrayList<SoThich> data){
        rvlm = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(rvlm);
        ad = new Adapter(this,data,R.layout.listviewitem);
        recyclerView.setAdapter(ad);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_action,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_Sang:
                //code
                setTheme(R.style.nono);
                setContentView(R.layout.activity_main);
                return true;

             case R.id.menu_Toi:
                 setTheme(R.style.sang);

                 setContentView(R.layout.activity_main);
                 return true;
                 default:
                    return super.onOptionsItemSelected(item);
        }

    }
}
