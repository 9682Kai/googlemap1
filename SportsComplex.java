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

public class SportsComplex extends AppCompatActivity implements OnMapReadyCallback , LocationListener , GoogleMap.OnMarkerClickListener , GoogleApiClient.ConnectionCallbacks , GoogleApiClient.OnConnectionFailedListener
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

    LatLng 大甲體育場 = new LatLng(24.3538904, 120.6126438);
    LatLng 太平區體育場 = new LatLng(24.130993, 120.721122);
    LatLng 極限運動場 = new LatLng(24.1834951, 120.68732890000001);
    LatLng 臺中市立豐原體育場 = new LatLng(24.260823, 120.717475);
    LatLng 霧峰區健體中心 = new LatLng(24.0596932, 120.6999108);
    LatLng 豐原國民運動中心 = new LatLng(24.2431451, 120.70330979999994);
    LatLng 北屯國民運動中心 = new LatLng(24.183289, 120.685694);
    LatLng 朝馬國民運動中心 = new LatLng(24.168205, 120.633409);
    LatLng 南屯國民運動中心 = new LatLng(24.1378484, 120.6364947);
    LatLng 太平國民運動中心 = new LatLng(24.148549, 120.73030960000006);
    LatLng 北區國民運動中心 = new LatLng(24.157101, 120.684126);
    LatLng 大里國民暨兒童運動中心 = new LatLng(24.1006035, 120.68312400000002);
    LatLng 潭子國民暨兒童運動中心 = new LatLng(24.210362, 120.701888);
    LatLng 長春國民暨兒童運動中心 = new LatLng(24.130812, 120.680224);
    LatLng 霧峰綜合運動場 = new LatLng(24.0750527, 120.71259680000003);
    LatLng 清水國民運動中心 = new LatLng(24.271902, 120.549810);
    LatLng 巨蛋體育館 = new LatLng(24.200190, 120.666510);
    LatLng 沙鹿簡易運動場 = new LatLng(24.2341229, 120.565073);
    LatLng 同安厝多功能草皮運動場 = new LatLng(24.341066, 120.62919999999997);
    LatLng 臺中客家樂活園區樂活運動館 = new LatLng(24.341066, 120.62919999999997);
    LatLng 臺中市烏日全民運動館 = new LatLng(24.341066, 120.62919999999997);


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


        arrayList.add(大甲體育場);//
        arrayList.add(太平區體育場);//
        arrayList.add(極限運動場);//
        arrayList.add(臺中市立豐原體育場);//
        arrayList.add(霧峰區健體中心);//
        arrayList.add(豐原國民運動中心);//
        arrayList.add(北屯國民運動中心);//
        arrayList.add(朝馬國民運動中心);//
        arrayList.add(南屯國民運動中心);//
        arrayList.add(太平國民運動中心);//
        arrayList.add(北區國民運動中心);//
        arrayList.add(大里國民暨兒童運動中心);//
        arrayList.add(潭子國民暨兒童運動中心);//
        arrayList.add(長春國民暨兒童運動中心);//
        arrayList.add(霧峰綜合運動場);//
        arrayList.add(清水國民運動中心);//
        arrayList.add(巨蛋體育館);//
        arrayList.add(沙鹿簡易運動場);//
        arrayList.add(同安厝多功能草皮運動場);//
        arrayList.add(臺中客家樂活園區樂活運動館);
        arrayList.add(臺中市烏日全民運動館);

        //add title for marker in title arraylist
        title.add("大甲體育場");//
        title.add("太平區體育場");//
        title.add("極限運動場");//
        title.add("臺中市立豐原體育場");//
        title.add("霧峰區健體中心");//
        title.add("豐原國民運動中心");//
        title.add("北屯國民運動中心");//
        title.add("朝馬國民運動中心");//
        title.add("南屯國民運動中心");//
        title.add("太平國民運動中心");//
        title.add("北區國民運動中心");//
        title.add("大里國民暨兒童運動中心");//
        title.add("潭子國民暨兒童運動中心");//
        title.add("長春國民暨兒童運動中心");//
        title.add("霧峰綜合運動場");//
        title.add("清水國民運動中心");//
        title.add("巨蛋體育館");//
        title.add("沙鹿簡易運動場");//
        title.add("同安厝多功能草皮運動場");//
        title.add("臺中客家樂活園區樂活運動館");//
        title.add("臺中市烏日全民運動館");//

        //add snippet for marker in snippet arraylist
        snippet.add("臺中市大甲區大安港路2號");//
        snippet.add("臺中市太平區中興東路99號");//
        snippet.add("臺中市北屯區崇德八路1段93號");//
        snippet.add("臺中市豐原區豐北街221號");//
        snippet.add("臺中市霧峰區成功路200號");//
        snippet.add("臺中市豐原區豐原大道一段");//
        snippet.add("臺中市北屯區文教7用地(北屯區公所對面)");//
        snippet.add("臺中市西屯區朝貴路199號");//
        snippet.add("臺中市南屯區黎明路一段998號");//
        snippet.add("臺中市太平區坪林森林公園");//
        snippet.add("臺中市北區崇德路一段55號");//
        snippet.add("臺中市大里區國光路與大里路交叉口");//
        snippet.add("臺中市潭子區興華段");//
        snippet.add("台中市南區合作街46號");//
        snippet.add("台中市霧峰區吉峰里民生路");//
        snippet.add("臺中市清水區體2用地");//
        snippet.add("臺中市北屯區文中小6用地");//
        snippet.add("臺中市沙鹿區鎮政路與中正街交叉口(沙鹿公園旁)");//
        snippet.add("烏日高鐵基地站與焚化爐中間");//
        snippet.add("臺中市東勢區圓樓街1號");
        snippet.add("臺中市烏日區新榮和段131 地號");



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

                Intent i=new Intent(SportsComplex.this,DetailsActivity.class);
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