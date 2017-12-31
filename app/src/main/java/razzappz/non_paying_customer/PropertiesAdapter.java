package razzappz.non_paying_customer;

import android.app.LauncherActivity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;


public class PropertiesAdapter extends RecyclerView.Adapter<PropertiesAdapter.ViewHolder> {

    private List<Properties> propertiesList;
    private Context context;

    public PropertiesAdapter(List<Properties> propertiesList, Context context) {
        this.propertiesList = propertiesList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.single_item,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        final Properties properties=propertiesList.get(position);
        holder.tvName.setText(properties.getName());
        holder.tvNumber.setText(properties.getNumber());
        holder.tvTime.setText(properties.getTime());
        holder.itemLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(context,MasterActivity.class);
                i.putExtra("Content",properties.getName());
                context.startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return propertiesList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView tvName,tvNumber,tvTime;
        public LinearLayout itemLayout;

        public ViewHolder(View itemView) {
            super(itemView);

            tvName=(TextView)itemView.findViewById(R.id.tvName);
            tvNumber=(TextView)itemView.findViewById(R.id.tvNumber);
            tvTime=(TextView)itemView.findViewById(R.id.tvTime);
            itemLayout=(LinearLayout)itemView.findViewById(R.id.itemLayout);


        }
    }
}
