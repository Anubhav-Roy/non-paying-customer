package razzappz.non_paying_customer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MasterActivity extends AppCompatActivity {
    TextView clicked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_master);

        clicked=(TextView)findViewById(R.id.masterText);
        clicked.setText(getIntent().getStringExtra("Content"));
    }
}
