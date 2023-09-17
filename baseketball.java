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

public class baseketball extends AppCompatActivity implements OnMapReadyCallback , LocationListener , GoogleMap.OnMarkerClickListener , GoogleApiClient.ConnectionCallbacks , GoogleApiClient.OnConnectionFailedListener
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
    LatLng 烏日區籃球場 = new LatLng(24.1072684, 120.62582500000008);//
    LatLng 吉峰里簡易籃球場 = new LatLng(24.079805, 120.712401);//
    LatLng 本堂里簡易籃球場 = new LatLng(24.057777459724885, 120.69804810000005);//
    LatLng 丁台里簡易籃球場 = new LatLng(24.0471094, 120.67443700000001);//
    LatLng 舊正里簡易籃球場 = new LatLng(24.0190731, 120.69188029999998);//
    LatLng 甲寅里厝後廣場籃球場 = new LatLng(24.0683421, 120.70079450000003);//
    LatLng 甲寅里屠宰場籃球場 = new LatLng(24.0693968, 120.69808439999997);//
    LatLng 四德里簡易籃球場 = new LatLng(24.0615254, 120.6696306);//
    LatLng 外埔籃球場 = new LatLng(24.3374715, 120.64579939999999);//
    LatLng 烏溪簡易籃球場 = new LatLng(24.190472, 120.515333);//
    LatLng 龍井分駐所旁籃球場 = new LatLng(24.191833, 120.545361);//
    LatLng 竹坑活動中心旁籃球場 = new LatLng(24.179806, 120.546889);//
    LatLng 麗水籃球場 = new LatLng(24.200194, 120.498333);//
    LatLng 福田西濱橋下籃球場 = new LatLng(24.196639, 120.511583);//
    LatLng 南寮里中沙路南寮巷籃球場 = new LatLng(24.174583, 120.567722);//
    LatLng 中興橋下綜合球場籃球場滑輪直排輪場 = new LatLng(24.218028, 120.543944);//
    LatLng 山腳里龍山國小西面籃球場 = new LatLng(24.214167, 120.549306);//
    LatLng 霧峰區萬豐里簡易籃球場 = new LatLng(24.023218, 120.6979037);//
    LatLng 幸福里籃球場 = new LatLng(24.396441, 120.660536);//
    LatLng 社南里籃球場 = new LatLng(24.341066, 120.62919999999997);

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

        arrayList.add(烏日區籃球場);//
        arrayList.add(吉峰里簡易籃球場);//
        arrayList.add(本堂里簡易籃球場);//
        arrayList.add(丁台里簡易籃球場);
        arrayList.add(舊正里簡易籃球場);
        arrayList.add(甲寅里厝後廣場籃球場);
        arrayList.add(甲寅里屠宰場籃球場);
        arrayList.add(四德里簡易籃球場);
        arrayList.add(外埔籃球場);
        arrayList.add(烏溪簡易籃球場);
        arrayList.add(龍井分駐所旁籃球場);
        arrayList.add(竹坑活動中心旁籃球場);
        arrayList.add(麗水籃球場);
        arrayList.add(福田西濱橋下籃球場);
        arrayList.add(南寮里中沙路南寮巷籃球場);
        arrayList.add(中興橋下綜合球場籃球場滑輪直排輪場);
        arrayList.add(山腳里龍山國小西面籃球場);
        arrayList.add(霧峰區萬豐里簡易籃球場);
        arrayList.add(幸福里籃球場);
        arrayList.add(社南里籃球場);

        //add title for marker in title arraylist
        title.add("烏日區籃球場");
        title.add("吉峰里簡易籃球場");
        title.add("本堂里簡易籃球場");
        title.add("丁台里簡易籃球場");
        title.add("舊正里簡易籃球場");
        title.add("甲寅里厝後廣場籃球場");
        title.add("甲寅里屠宰場籃球場");
        title.add("四德里簡易籃球場");
        title.add("外埔籃球場");
        title.add("烏溪簡易籃球場");
        title.add("龍井分駐所旁籃球場");
        title.add("竹坑活動中心旁籃球場");
        title.add("麗水籃球場");
        title.add("福田西濱橋下籃球場");
        title.add("南寮里中沙路南寮巷籃球場");
        title.add("中興橋下綜合球場籃球場滑輪直排輪場");
        title.add("山腳里龍山國小西面籃球場");
        title.add("霧峰區萬豐里簡易籃球場");
        title.add("幸福里籃球場");
        title.add("社南里籃球場");

        //add snippet for marker in snippet arraylist
        snippet.add("臺中市烏日區光日路228號旁");//
        snippet.add("臺中市霧峰區大愛路198號");//
        snippet.add("臺中市霧峰區中正路-臺電後方");//
        snippet.add("臺中市霧峰區丁台里丁台路444");//
        snippet.add("臺中市霧峰區舊正里光明路116巷54號");//
        snippet.add("臺中市霧峰區甲寅里德泰街68號");//
        snippet.add("臺中市霧峰區甲寅里中正路1105巷15號");//
        snippet.add("臺中市霧峰區四德里四德路");//
        snippet.add("外埔國小操場旁");//
        snippet.add("臺中市龍井區福田村護岸路西側河堤");//
        snippet.add("臺中市龍井區沙田路四段245號後方");//
        snippet.add("臺中市龍井區竹坑里竹師路一段164巷2號旁(竹坑活動中心)");//
        snippet.add("台中市龍井區麗水里5鄰三港路水裡港巷26號(龍井福順宮旁)");//
        snippet.add("臺中市龍井區西濱橋下(福田宮旁)");//
        snippet.add("臺中市龍井區南寮里中沙路南寮巷22號旁");//
        snippet.add("臺中市龍井區中興橋下");//
        snippet.add("臺中市龍井區竹師路二段112巷46號旁(龍山國小西面)");//
        snippet.add("臺中市霧峰區萬豐里中正路146巷59弄右轉到底");//
        snippet.add("臺中市大甲區黎明路與中山路交叉口(橋興生鮮超市後方)");//
        snippet.add("臺中市神岡區社南里");//



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

                Intent i=new Intent(baseketball.this,DetailsActivity.class);
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