package razzappz.non_paying_customer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MasterActivity extends AppCompatActivity {
    TextView clicked;
    private android.support.v7.widget.Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_master);

        initToolBar(); // initializing the toolbar

        clicked=(TextView)findViewById(R.id.masterText);
        clicked.setText(getIntent().getStringExtra("Content"));
    }


    // initializing the toolbar
    public void initToolBar() {
        toolbar = findViewById(R.id.master_toolbar);
        toolbar.setTitle("Master List");
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_action_back);
        toolbar.setNavigationOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i=new Intent(getApplicationContext(),MainActivity.class);
                        startActivity(i);
                    }
                }
        );

    }

}
