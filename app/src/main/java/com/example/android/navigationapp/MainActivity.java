package com.example.android.navigationapp;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;


public class MainActivity extends Activity {
    private static final String TAG="MainActivity";
    private static final int ERROR_DIALOG_REQUEST=9001;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        Mapbox.getInstance(this,getString(R.string.access_token));
        setContentView(R.layout.activity_main);
    if(isServiceOK()){
        init();
    }
    }
        public void init(){
            Button btnMap =(Button)findViewById(R.id.btnmap);
           btnMap.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   Intent intent=new Intent(MainActivity.this,mapActivity.class);
                   startActivity(intent);

               }
           });


        }
public boolean isServiceOK(){
        Log.d(TAG,"isServiceOK: checking google services version");
        int availale= GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(MainActivity.this);
        if(availale==ConnectionResult.SUCCESS){
            //everyrhing is OK
            Log.d(TAG,"isServiceOK: checking google services is working..");
            return true;

        }
        else if(GoogleApiAvailability.getInstance().isUserResolvableError(availale)){
            Log.d(TAG,"isServiceOK: an Error Occur but it is resolvable");

            Dialog dialog=GoogleApiAvailability.getInstance().getErrorDialog(MainActivity.this,availale,ERROR_DIALOG_REQUEST);
        dialog.show();
        }
        else{

            Toast.makeText(this,"we cant make request",Toast.LENGTH_SHORT);

        }

return false;
}
        }
//        mapView=findViewById(R.id.mapView);
//        mapView.onCreate(savedInstanceState);
//        mapView.getMapAsync(new OnMapReadyCallback() {
//            @Override
//            public void onMapReady(MapboxMap mapboxMap) {
//// One way to add a marker view
//                mapboxMap.addMarker(new MarkerOptions()
//                        .position(new LatLng(41.885,-87.679))
//                        .title("Chicago")
//                        .snippet("Illinois")
//                );
//            }
//        });
//    }
//    @Override
//    public void onStart() {
//        super.onStart();
//        mapView.onStart();
//    }
//
//    @Override
//    public void onResume() {
//        super.onResume();
//        mapView.onResume();
//    }
//
//    @Override
//    public void onPause() {
//        super.onPause();
//        mapView.onPause();
//    }
//
//    @Override
//    public void onStop() {
//        super.onStop();
//        mapView.onStop();
//    }
//
//    @Override
//    public void onLowMemory() {
//        super.onLowMemory();
//        mapView.onLowMemory();
//    }
//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        mapView.onDestroy();
//    }
//
//    @Override
//    protected void onSaveInstanceState(Bundle outState) {
//        super.onSaveInstanceState(outState);
//        mapView.onSaveInstanceState(outState);
//    }
//}


