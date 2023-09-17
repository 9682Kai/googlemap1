package tw.edu.pu.s1091802.googlemap;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

import tw.edu.pu.s1091802.googlemap.databinding.ActivityMapsBinding;

public class football extends AppCompatActivity implements OnMapReadyCallback , LocationListener , GoogleMap.OnMarkerClickListener , GoogleApiClient.ConnectionCallbacks , GoogleApiClient.OnConnectionFailedListener
{

    public static final int ROUND = 10;
    private GoogleMap mMap;
    public GoogleApiClient googleApiClient;
    Marker marker;
    Toolbar toolbar;
    public FusedLocationProviderClient fusedLocationProviderClient;
    private LocationManager locMgr;
    float zoom;
    String bestProv;
    ArrayList<LatLng>arrayList=new ArrayList<LatLng>();

    LatLng 足球運動休閒園區 = new LatLng(24.134196, 120.629180);
    LatLng 文小91足球場 = new LatLng(24.17411954930602, 120.62494399814615);
    LatLng 朝馬足球場 = new LatLng(24.169750, 120.633083);
    LatLng 太原足球場 = new LatLng(24.1612361, 120.7200986);
    LatLng 大里足球場 = new LatLng(24.341066, 120.62919999999997);


    // create another arraylist for name for markers
    ArrayList<String> title = new ArrayList<String>();
    ArrayList<String> snippet = new ArrayList<String>();



    @Override
    public void onLocationChanged(Location location)
    {
        //取得地圖座標值 : 緯度 , 經度
        String x = "緯=" + Double.toString(location.getLatitude());
        String y = "經=" + Double.toString(location.getLongitude());

        LatLng Point = new LatLng(location.getLatitude(), location.getLongitude());
        zoom = 17;
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(Point, zoom));

        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED)
        {
            mMap.setMyLocationEnabled(true);  //顯示定位圖示
        }

        //Toast.makeText(this, x + "\n" + y, Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        ActivityMapsBinding binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        // add items to arraylist.


        arrayList.add(足球運動休閒園區);
        arrayList.add(文小91足球場);
        arrayList.add(朝馬足球場);
        arrayList.add(太原足球場);
        arrayList.add(大里足球場);


        //add title for marker in title arraylist

        title.add("足球運動休閒園區");//
        title.add("文小91足球場");//
        title.add("朝馬足球場");//
        title.add("太原足球場");//
        title.add("大里足球場");

        //add snippet for marker in snippet arraylist


        snippet.add("臺中市南屯區龍富九路跟益豐路三段 南屯文中小用地");//
        snippet.add("臺中市西屯區虹揚橋邊");//
        snippet.add("臺中市西屯區朝馬路145號");//
        snippet.add("臺中市北屯區建軍一街6-8號");//
        snippet.add("臺中市大里區永隆六街壘球場旁邊活動中心後面");//



    }

    @Override
    protected void onResume()
    {
        super.onResume();

        locMgr = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        Criteria criteria = new Criteria();
        bestProv = locMgr.getBestProvider(criteria, true);  //取得最佳定位方式

        //如果GPS或網路定位開啟，更新位置
        if (locMgr.isProviderEnabled(LocationManager.GPS_PROVIDER) || locMgr.isProviderEnabled(LocationManager.NETWORK_PROVIDER))
        {
            //確認 ACCESS_FINE_LOCATION 權限是否授權
            if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED)
            {
                locMgr.requestLocationUpdates(bestProv, 1000, 1, this);
            }
        }
        else
        {
            Toast.makeText(this, "請開啟定位服務", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onPause()
    {
        super.onPause();

        //確認 ACCESS_FINE_LOCATION 權限是否授權
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED)
        {
            locMgr.removeUpdates(this);
        }
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras)
    {
        Criteria criteria = new Criteria();
        bestProv = locMgr.getBestProvider(criteria, true);
    }

    @Override
    public void onProviderEnabled(String provider)
    {

    }

    @Override
    public void onProviderDisabled(String provider)
    {

    }

    @Override
    public void onMapReady(GoogleMap googleMap)
    {
        mMap = googleMap;
        //googleMap.setOnMarkerClickListener(this);

        //add marker to locations
        for(int i = 0;i< arrayList.size();i++){

            mMap.addMarker(new MarkerOptions().position(arrayList.get(i)).title(title.get(i)).snippet(snippet.get(i)));

        }
        //add on click listener for marker on maps

        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(@NonNull Marker marker) {
                String markertitle=marker.getTitle();

                Intent i=new Intent(football.this,DetailsActivity.class);
                // passing title to new activity
                i.putExtra("title",markertitle);
                startActivity(i);

                return false;
            }
        });




        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);  //一般地圖

        requestPermission();  //檢查授權

        mMap.getUiSettings().setCompassEnabled(true);
        mMap.getUiSettings().setZoomControlsEnabled(true);
    }

    private void requestPermission()
    {
        if (Build.VERSION.SDK_INT >= 23)  //androis 6.0 以上
        {
            //判斷是否已取得授權
            int hasPermission = ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION);

            if (hasPermission != PackageManager.PERMISSION_GRANTED)  //未取得授權
            {
                ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION}, 1);
                return;
            }
        }
        setMyLocation();  //如果版本為 6.0 以下，或版本為 6.0 以上但使用者已授權，顯示定位圖層
    }

    //使用者完成授權的選擇以後，會呼叫 onRequestPermissionsResult 方法
    //第一個參數 : 請求授權代碼
    //第二個參數 : 請求的授權名稱
    //第三個參數 : 使用者選擇授權的結果
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults)
    {
        if (requestCode == 1)
        {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED)  //按允許鈕
            {
                setMyLocation();  //顯示定位圖層
            }
            else  //按拒絕鈕
            {
                Toast.makeText(this, "未取得授權!", Toast.LENGTH_SHORT).show();
                finish();  //結束應用程式
            }
        }
        else
        {
            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }

    private void setMyLocation() throws SecurityException
    {
        mMap.setMyLocationEnabled(true);  //顯示定位圖層
    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {

    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    @Override
    public boolean onMarkerClick(@NonNull Marker marker) {
        return false;
    }
}