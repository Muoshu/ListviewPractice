package browser.green.org.listviewpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView=findViewById(R.id.lv_main);
        MyAdapter adapter = new MyAdapter(this);
        List<Map<String, Object>> list = new ArrayList<>();
        for(int i=0;i<Constant.array.length;i++){
            Map<String, Object> map = new HashMap<>();
            map.put("avatar",Constant.images[i]);
            map.put("studentNum",Constant.array[i]);
            list.add(map);
        }
        adapter.setList(list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Bundle bundle=new Bundle();
                bundle.putInt("studentNum",i);
                Intent intent=new Intent();
                intent.putExtras(bundle);
                intent.setClass(MainActivity.this,InfoActivity.class);
                startActivity(intent);
            }
        });


    }
}
