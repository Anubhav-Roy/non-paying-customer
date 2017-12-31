package razzappz.non_paying_customer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.google.firebase.iid.FirebaseInstanceId;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG="MainActivity";
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<Properties> propertiesList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
}
