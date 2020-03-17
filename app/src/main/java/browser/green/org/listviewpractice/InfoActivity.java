package browser.green.org.listviewpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class InfoActivity extends AppCompatActivity {
    private TextView textView;
    private ImageView imageView;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        imageView=findViewById(R.id.iv_icon);
        textView=findViewById(R.id.tv_info);

        Bundle bundle=getIntent().getExtras();
        int id=bundle.getInt("studentNum");
        imageView.setImageResource(Constant.icons[id]);
        textView.setText("My CQU number is "+Constant.array[id]);
    }
}
