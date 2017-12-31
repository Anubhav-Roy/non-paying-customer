package razzappz.non_paying_customer;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.firebase.iid.FirebaseInstanceId;

import java.util.ArrayList;
import java.util.List;

import static razzappz.non_paying_customer.R.drawable.ic_add_contact;

public class MainActivity extends AppCompatActivity {
    private static final String TAG="MainActivity";
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<Properties> propertiesList=new ArrayList<>();
    private android.support.v7.widget.Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initToolBar();  // initializing the toolbar


        String token= FirebaseInstanceId.getInstance().getToken();
        Log.e(TAG, "onCreate: Token: "+token );

        recyclerView=(RecyclerView)findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        for (int i=0;i<10;i++) {
            Properties properties = new Properties("Name: "+i, "Listing Number: "+i, "Timestamp: "+i);
            propertiesList.add(properties);
        }
        adapter=new PropertiesAdapter(propertiesList,this);
        recyclerView.setAdapter(adapter);
    }


    // function for initializing toolbar

    public void initToolBar() {
        toolbar = findViewById(R.id.main_toolbar);
        toolbar.setTitle("Customer List");
        setSupportActionBar(toolbar);

    }
    // Menu icons are inflated just as they were with actionbar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
// Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_toolbar_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
// Handle item selection
        switch (item.getItemId()) {
            case R.id.addOrdinary:
                Intent i=new Intent(getApplicationContext(),OrdinaryForm.class);
                startActivity(i);
                //Toast.makeText(MainActivity.this, "clicking on Ordinary", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.addBrokerage:
                //Toast.makeText(MainActivity.this, "clicking on Brokerage", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
