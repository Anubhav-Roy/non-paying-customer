package razzappz.non_paying_customer;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;



public class InstanceIdService extends FirebaseInstanceIdService {
    private static final String TAG="InstanceIdService";

    @Override
    public void onTokenRefresh() {
        String updatedToken= FirebaseInstanceId.getInstance().getToken();
        Log.e(TAG, "onTokenRefresh: "+updatedToken);

    }
}
