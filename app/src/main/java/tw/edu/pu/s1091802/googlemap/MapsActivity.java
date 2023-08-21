package tw.edu.pu.s1091802.googlemap;

import static android.app.PendingIntent.getActivity;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
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

public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback , LocationListener , GoogleMap.OnMarkerClickListener , GoogleApiClient.ConnectionCallbacks , GoogleApiClient.OnConnectionFailedListener, View.OnClickListener
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
    LatLng 大甲區網球場 = new LatLng(24.341066, 120.62919999999997);
    LatLng 大肚運一運動公園 = new LatLng(24.341066, 120.62919999999997);
    LatLng 大里游泳池 = new LatLng(24.1089129, 120.6874219);
    LatLng 公五網球場 = new LatLng(24.1159089, 120.67965800000002);
    LatLng 大里運動公園 = new LatLng(24.0983586, 120.68334870000001);
    LatLng 大雅區六寶槌球場 = new LatLng(24.2540339, 120.6001738);
    LatLng 太平區體育場 = new LatLng(24.130993, 120.721122);
    LatLng 太平游泳池 = new LatLng(24.1200121, 120.71822139999995);
    LatLng 祥順運動公園 = new LatLng(24.1375515, 120.7125969);
    LatLng 中興籃槌球場 = new LatLng(24.1769394, 120.67688640000006);
    LatLng 中興網球場 = new LatLng(24.281667, 120.675361);
    LatLng 中興游泳池 = new LatLng(24.175349, 120.676288);
    LatLng 太原棒球場 = new LatLng(24.1610308, 120.72048340000003);
    LatLng 極限運動場 = new LatLng(24.1834951, 120.68732890000001);
    LatLng 洲際棒球場 = new LatLng(24.199694, 120.684013);
    LatLng 兒童公園網球場 = new LatLng(24.167944, 120.694502);
    LatLng 土牛運動公園 = new LatLng(24.266841, 120.79647999999997);
    LatLng 臺中市立慢速壘球場 = new LatLng(24.2879619, 120.7289015);
    LatLng 三信游泳池 = new LatLng(24.1669745, 120.66287920000002);
    LatLng 健康公園溜冰場 = new LatLng(24.119528, 120.668083);
    LatLng 萬壽棒球場 = new LatLng(24.146603, 120.650608);
    LatLng 沙鹿運十八運動場 = new LatLng(24.2169352, 120.571552);
    LatLng 沙鹿運十九慢壘場 = new LatLng(24.2090988, 120.5639013);
    LatLng 沙鹿游泳池 = new LatLng(24.233504, 120.564402);
    LatLng 東峰游泳池 = new LatLng(24.1234034, 120.68508810000003);
    LatLng 東勢網球場 = new LatLng(24.2602429, 120.82420200000001);
    LatLng 東勢游泳池 = new LatLng(24.2602429, 120.82420200000001);
    LatLng 烏日區籃球場 = new LatLng(24.1072684, 120.62582500000008);
    LatLng 烏日區網球場 = new LatLng(24.1075951, 120.62522799999999);
    LatLng 烏日溫水游泳池 = new LatLng(24.0616078, 120.63872859999992);
    LatLng 烏日區游泳池 = new LatLng(24.1033055, 120.61686770000006);
    LatLng 梧棲運七簡易棒壘球場 = new LatLng(24.258556, 120.543972);
    LatLng 梧棲運八射箭場 = new LatLng(24.254722, 120.548972);
    LatLng 梧棲運十二田徑場 = new LatLng(24.250778, 120.543556);
    LatLng 梧棲運十五運動公園 = new LatLng(24.247278, 120.529194);
    LatLng 梧棲運九棒球場 = new LatLng(24.255139, 120.555639);
    LatLng 梧棲運十三網球場 = new LatLng(24.246583, 120.551556);
    LatLng 梧棲運十三曲棍球場 = new LatLng(24.246611, 120.551444);
    LatLng 清水運一運動公園 = new LatLng(24.2787125, 120.55731309999999);
    LatLng 清水運五簡易壘球場 = new LatLng(24.2629562, 120.56414659999996);
    LatLng 梧棲區游泳池 = new LatLng(24.255639, 120.533556);
    LatLng 清水運三槺榔運動公園 = new LatLng(24.2637276, 120.54595100000006);
    LatLng 清水運四牛埔仔運動公園 = new LatLng(24.2657825, 120.55462869999996);
    LatLng 臺中市立自由車場 = new LatLng(24.272458, 120.582665);
    LatLng 新社游泳池 = new LatLng(24.238473, 120.80673790000003);
    LatLng 潭子沙攤排球場 = new LatLng(24.209111, 120.703667);
    LatLng 潭子區勝利運動公園 = new LatLng(24.209556, 120.701306);
    LatLng 龍井三德游泳池 = new LatLng(24.203083, 120.524833);
    LatLng 臺中市立豐原體育場 = new LatLng(24.260823, 120.717475);
    LatLng 坑口運動公園 = new LatLng(24.0146808, 120.69598310000003);//50
    LatLng 霧峰區健體中心 = new LatLng(24.0596932, 120.6999108);
    LatLng 金龍棒球場 = new LatLng(24.138806, 120.709500);
    LatLng 公六慢速壘球場 = new LatLng(24.1127726, 120.67354640000008);
    LatLng 豐原國民運動中心 = new LatLng(24.2431451, 120.70330979999994);
    LatLng 北屯國民運動中心 = new LatLng(24.183289, 120.685694);
    LatLng 朝馬國民運動中心 = new LatLng(24.168205, 120.633409);
    LatLng 南屯國民運動中心 = new LatLng(24.1378484, 120.6364947);
    LatLng 太平國民運動中心 = new LatLng(24.148549, 120.73030960000006);
    LatLng 北區國民運動中心 = new LatLng(24.157101, 120.684126);
    LatLng 大里國民暨兒童運動中心 = new LatLng(24.1006035, 120.68312400000002);
    LatLng 潭子國民暨兒童運動中心 = new LatLng(24.210362, 120.701888);
    LatLng 長春國民暨兒童運動中心 = new LatLng(24.130812, 120.680224);
    LatLng 沙鹿網球場 = new LatLng(24.2333641, 120.5662175);
    LatLng 霧峰綜合運動場 = new LatLng(24.0750527, 120.71259680000003);
    LatLng 吉峰搥球場 = new LatLng(24.0728002, 120.71487669999999);
    LatLng 吉峰里簡易籃球場 = new LatLng(24.079805, 120.712401);
    LatLng 本堂里簡易籃球場 = new LatLng(24.057777459724885, 120.69804810000005);
    LatLng 丁台里簡易籃球場 = new LatLng(24.0471094, 120.67443700000001);
    LatLng 舊正里簡易籃球場 = new LatLng(24.0190731, 120.69188029999998);
    LatLng 臺中市網球中心 = new LatLng(24.164678, 120.729830);
    LatLng 甲寅里厝後廣場籃球場 = new LatLng(24.0683421, 120.70079450000003);
    LatLng 甲寅里屠宰場籃球場 = new LatLng(24.0693968, 120.69808439999997);
    LatLng 四德里簡易籃球場 = new LatLng(24.0615254, 120.6696306);
    LatLng 坑口里簡易球場 = new LatLng(24.1120554, 120.65136050000001);
    LatLng 外埔籃球場 = new LatLng(24.3374715, 120.64579939999999);
    LatLng 清水國民運動中心 = new LatLng(24.271902, 120.549810);
    LatLng 足球運動休閒園區 = new LatLng(24.134196, 120.629180);
    LatLng 大甲運動公園 = new LatLng(24.339703, 120.629948);
    LatLng 港區運動公園 = new LatLng(24.204125, 120.564220);
    LatLng 文高8 = new LatLng(24.249111, 120.529861);//80
    LatLng 南埔簡易棒球場 = new LatLng(24.340361, 120.560639);
    LatLng 烏溪簡易籃球場 = new LatLng(24.190472, 120.515333);
    LatLng 河濱壘球場 = new LatLng(24.189694, 120.515556);
    LatLng 龍井分駐所旁籃球場 = new LatLng(24.191833, 120.545361);
    LatLng 竹坑活動中心旁籃球場 = new LatLng(24.179806, 120.546889);
    LatLng 麗水籃球場 = new LatLng(24.200194, 120.498333);
    LatLng 福田西濱橋下籃球場 = new LatLng(24.196639, 120.511583);
    LatLng 南寮里中沙路南寮巷籃球場 = new LatLng(24.174583, 120.567722);
    LatLng 新庄里向上路六段槌球場 = new LatLng(24.183750, 120.574583);
    LatLng 中彰橋下槌球場 = new LatLng(24.194028, 120.511278);
    LatLng 龍井龍田陸橋曲棍球場及溜冰場 = new LatLng(24.191028, 120.542667);
    LatLng 中興橋下綜合球場籃球場滑輪直排輪場 = new LatLng(24.218028, 120.543944);
    LatLng 山腳里龍山國小西面籃球場 = new LatLng(24.214167, 120.549306);
    LatLng 國際壘球運動園區 = new LatLng(24.3463290, 120.6435762);
    LatLng 霧峰舊正棒球園區 = new LatLng(24.015288, 120.695923);
    LatLng 二信游泳池 = new LatLng(24.131147, 120.659387);
    LatLng 水源館 = new LatLng(24.148806, 120.689988);
    LatLng 文小91足球場 = new LatLng(24.17411954930602, 120.62494399814615);
    LatLng 朝馬足球場 = new LatLng(24.169750, 120.633083);
    LatLng 巨蛋體育館 = new LatLng(24.200190, 120.666510);
    LatLng 大里區大突寮溜冰場 = new LatLng(24.0995448, 120.6951862);
    LatLng 霧峰區萬豐里簡易籃球場 = new LatLng(24.023218, 120.6979037);
    LatLng 東湖壘球場 = new LatLng(24.0869578, 120.6934591);
    LatLng 長榮里溜冰場 = new LatLng(24.1089129, 120.6874219);
    LatLng 健民槌球場 = new LatLng(24.088364, 120.7306661);
    LatLng 高灘地的棒球場 = new LatLng(24.084087, 120.7087236);
    LatLng 大里區桌球場 = new LatLng(24.1081743, 120.6859986);
    LatLng 瑞城公園溜冰場 = new LatLng(24.0823144, 120.7043826);
    LatLng 沙鹿簡易運動場 = new LatLng(24.2341229, 120.565073);
    LatLng 沙鹿運十一 = new LatLng(24.2347107, 120.5668801);
    LatLng 沙鹿運十四 = new LatLng(24.2490922, 120.5550213);
    LatLng 沙鹿運六 = new LatLng(24.255608, 120.570016);
    LatLng 大肚游泳池 = new LatLng(24.162799, 120.543284);
    LatLng 幸福里籃球場 = new LatLng(24.396441, 120.660536);
    LatLng 太平槌球場 = new LatLng(24.1249665, 120.7333769);
    LatLng 太平河堤慢壘球場 = new LatLng(24.1178228, 120.7249846);
    LatLng 太平區網球場 = new LatLng(24.1178228, 120.7249846);
    LatLng 臺中公園網球場北二面南二面 = new LatLng(24.1448185, 120.6844762);
    LatLng 太原足球場 = new LatLng(24.1612361, 120.7200986);
    LatLng 文中10棒球場 = new LatLng(24.1996448, 120.6840252);
    LatLng 大雅游泳池 = new LatLng(24.2358911, 120.6529319);
    LatLng 永和路公有網球場 = new LatLng(24.2126871, 120.6311099);
    LatLng 第七公墓簡易棒球場預定地 = new LatLng(24.2298702, 120.6713114);
    LatLng 大雅體育園區棒球場 = new LatLng(24.2404326, 120.6741789);
    LatLng 石岡游泳池 = new LatLng(24.341066, 120.62919999999997);
    LatLng 神岡體育園區壘球場 = new LatLng(24.341066, 120.62919999999997);
    LatLng 神岡體育園區棒球場 = new LatLng(24.341066, 120.62919999999997);
    LatLng 東勢體1 = new LatLng(24.341066, 120.62919999999997);
    LatLng 大里足球場 = new LatLng(24.341066, 120.62919999999997);
    LatLng 大雅體育園區二期 = new LatLng(24.341066, 120.62919999999997);
    LatLng 同安厝多功能草皮運動場 = new LatLng(24.341066, 120.62919999999997);
    LatLng 社南里籃球場 = new LatLng(24.341066, 120.62919999999997);
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

        ImageButton imagebutton1 = findViewById(R.id.imagebutton1);
        ImageButton imagebutton2 = findViewById(R.id.imagebutton2);
        ImageButton imagebutton3 = findViewById(R.id.imagebutton3);
        ImageButton imagebutton4 = findViewById(R.id.imagebutton4);

        imagebutton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MapsActivity.this, AccountPageActivity.class);
                startActivity(intent);
            }
        });
        imagebutton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MapsActivity.this, SettingActivity.class);
                startActivity(intent);
            }
        });
        imagebutton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MapsActivity.this, PedometerActivity.class);
                startActivity(intent);
            }
        });
        imagebutton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MapsActivity.this, CreatePairActivity.class);
                startActivity(intent);
            }
        });

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        //Button nextPageBtn = (Button)findViewById(R.id.button);  //跳轉頁面
        // add items to arraylist.
        arrayList.add(大甲體育場);
        arrayList.add(大甲區網球場);
        arrayList.add(大肚運一運動公園);
        arrayList.add(大里游泳池);
        arrayList.add(公五網球場);
        arrayList.add(大里運動公園);
        arrayList.add(大雅區六寶槌球場);
        arrayList.add(太平區體育場);
        arrayList.add(太平游泳池);
        arrayList.add(祥順運動公園);
        arrayList.add(中興籃槌球場);
        arrayList.add(中興網球場);
        arrayList.add(中興游泳池);
        arrayList.add(太原棒球場);
        arrayList.add(極限運動場);
        arrayList.add(洲際棒球場);
        arrayList.add(兒童公園網球場);
        arrayList.add(土牛運動公園);
        arrayList.add(臺中市立慢速壘球場);
        arrayList.add(三信游泳池);
        arrayList.add(健康公園溜冰場);
        arrayList.add(萬壽棒球場);
        arrayList.add(沙鹿運十八運動場);
        arrayList.add(沙鹿運十九慢壘場);
        arrayList.add(沙鹿游泳池);
        arrayList.add(東峰游泳池);
        arrayList.add(東勢網球場);
        arrayList.add(東勢游泳池);
        arrayList.add(烏日區籃球場);
        arrayList.add(烏日區網球場);
        arrayList.add(烏日溫水游泳池);
        arrayList.add(烏日區游泳池);
        arrayList.add(梧棲運七簡易棒壘球場);
        arrayList.add(梧棲運八射箭場);
        arrayList.add(梧棲運十二田徑場);
        arrayList.add(梧棲運十五運動公園);
        arrayList.add(梧棲運九棒球場);
        arrayList.add(梧棲運十三網球場);
        arrayList.add(梧棲運十三曲棍球場);
        arrayList.add(清水運一運動公園);
        arrayList.add(清水運五簡易壘球場);
        arrayList.add(梧棲區游泳池);
        arrayList.add(清水運三槺榔運動公園);
        arrayList.add(清水運四牛埔仔運動公園);
        arrayList.add(臺中市立自由車場);
        arrayList.add(新社游泳池);
        arrayList.add(潭子沙攤排球場);
        arrayList.add(潭子區勝利運動公園);
        arrayList.add(龍井三德游泳池);
        arrayList.add(臺中市立豐原體育場);
        arrayList.add(坑口運動公園);
        arrayList.add(霧峰區健體中心);
        arrayList.add(金龍棒球場);
        arrayList.add(公六慢速壘球場);
        arrayList.add(豐原國民運動中心);
        arrayList.add(北屯國民運動中心);
        arrayList.add(朝馬國民運動中心);
        arrayList.add(南屯國民運動中心);
        arrayList.add(太平國民運動中心);
        arrayList.add(北區國民運動中心);
        arrayList.add(大里國民暨兒童運動中心);
        arrayList.add(潭子國民暨兒童運動中心);
        arrayList.add(長春國民暨兒童運動中心);
        arrayList.add(沙鹿網球場);
        arrayList.add(霧峰綜合運動場);
        arrayList.add(吉峰搥球場);
        arrayList.add(吉峰里簡易籃球場);
        arrayList.add(本堂里簡易籃球場);
        arrayList.add(丁台里簡易籃球場);
        arrayList.add(舊正里簡易籃球場);
        arrayList.add(臺中市網球中心);
        arrayList.add(甲寅里厝後廣場籃球場);
        arrayList.add(甲寅里屠宰場籃球場);
        arrayList.add(四德里簡易籃球場);
        arrayList.add(坑口里簡易球場);
        arrayList.add(外埔籃球場);
        arrayList.add(清水國民運動中心);
        arrayList.add(足球運動休閒園區);
        arrayList.add(大甲運動公園);
        arrayList.add(港區運動公園);
        arrayList.add(文高8);
        arrayList.add(南埔簡易棒球場);
        arrayList.add(烏溪簡易籃球場);
        arrayList.add(河濱壘球場);
        arrayList.add(龍井分駐所旁籃球場);
        arrayList.add(竹坑活動中心旁籃球場);
        arrayList.add(麗水籃球場);
        arrayList.add(福田西濱橋下籃球場);
        arrayList.add(南寮里中沙路南寮巷籃球場);
        arrayList.add(新庄里向上路六段槌球場);
        arrayList.add(中彰橋下槌球場);
        arrayList.add(龍井龍田陸橋曲棍球場及溜冰場);
        arrayList.add(中興橋下綜合球場籃球場滑輪直排輪場);
        arrayList.add(山腳里龍山國小西面籃球場);
        arrayList.add(國際壘球運動園區);
        arrayList.add(霧峰舊正棒球園區);
        arrayList.add(二信游泳池);
        arrayList.add(水源館);
        arrayList.add(文小91足球場);
        arrayList.add(朝馬足球場);
        arrayList.add(巨蛋體育館);
        arrayList.add(大里區大突寮溜冰場);
        arrayList.add(霧峰區萬豐里簡易籃球場);
        arrayList.add(東湖壘球場);
        arrayList.add(長榮里溜冰場);
        arrayList.add(健民槌球場);
        arrayList.add(高灘地的棒球場);
        arrayList.add(大里區桌球場);
        arrayList.add(瑞城公園溜冰場);
        arrayList.add(沙鹿簡易運動場);
        arrayList.add(沙鹿運十一);
        arrayList.add(沙鹿運十四);
        arrayList.add(沙鹿運六);
        arrayList.add(大肚游泳池);
        arrayList.add(幸福里籃球場);
        arrayList.add(太平槌球場);
        arrayList.add(太平河堤慢壘球場);
        arrayList.add(太平區網球場);
        arrayList.add(臺中公園網球場北二面南二面);
        arrayList.add(太原足球場);
        arrayList.add(文中10棒球場);
        arrayList.add(大雅游泳池);
        arrayList.add(永和路公有網球場);
        arrayList.add(第七公墓簡易棒球場預定地);
        arrayList.add(大雅體育園區棒球場);
        arrayList.add(石岡游泳池);
        arrayList.add(神岡體育園區壘球場);
        arrayList.add(神岡體育園區棒球場);
        arrayList.add(東勢體1);
        arrayList.add(大里足球場);
        arrayList.add(大雅體育園區二期);
        arrayList.add(同安厝多功能草皮運動場);
        arrayList.add(社南里籃球場);
        arrayList.add(臺中客家樂活園區樂活運動館);
        arrayList.add(臺中市烏日全民運動館);

        //add title for marker in title arraylist
        title.add("大甲體育場");
        title.add("大甲區網球場");
        title.add("大肚運一運動公園");
        title.add("大里游泳池");
        title.add("公五網球場");
        title.add("大里運動公園");
        title.add("大雅區六寶槌球場");
        title.add("太平區體育場");
        title.add("太平游泳池");
        title.add("祥順運動公園");
        title.add("中興籃槌球場");
        title.add("中興網球場");
        title.add("中興游泳池");
        title.add("太原棒球場");
        title.add("極限運動場");
        title.add("洲際棒球場");
        title.add("兒童公園網球場");
        title.add("土牛運動公園");
        title.add("臺中市立慢速壘球場");
        title.add("三信游泳池");
        title.add("健康公園溜冰場");
        title.add("萬壽棒球場");
        title.add("沙鹿運十八運動場");
        title.add("沙鹿運十九慢壘場");
        title.add("沙鹿游泳池");
        title.add("東峰游泳池");
        title.add("東勢網球場");
        title.add("東勢游泳池");
        title.add("烏日區籃球場");
        title.add("烏日區網球場");
        title.add("烏日溫水游泳池");
        title.add("烏日區游泳池");
        title.add("梧棲運七簡易棒壘球場");
        title.add("梧棲運八射箭場");
        title.add("梧棲運十二田徑場");
        title.add("梧棲運十五運動公園");
        title.add("梧棲運九棒球場");
        title.add("梧棲運十三網球場");
        title.add("梧棲運十三曲棍球場");
        title.add("清水運一運動公園");
        title.add("清水運五簡易壘球場");
        title.add("梧棲區游泳池");
        title.add("清水運三槺榔運動公園");
        title.add("清水運四牛埔仔運動公園");
        title.add("臺中市立自由車場");
        title.add("新社游泳池");
        title.add("潭子沙攤排球場");
        title.add("潭子區勝利運動公園");
        title.add("龍井三德游泳池");
        title.add("臺中市立豐原體育場");
        title.add("坑口運動公園");
        title.add("霧峰區健體中心");
        title.add("金龍棒球場");
        title.add("公六慢速壘球場");
        title.add("豐原國民運動中心");
        title.add("北屯國民運動中心");
        title.add("朝馬國民運動中心");
        title.add("南屯國民運動中心");
        title.add("太平國民運動中心");
        title.add("北區國民運動中心");
        title.add("大里國民暨兒童運動中心");
        title.add("潭子國民暨兒童運動中心");
        title.add("長春國民暨兒童運動中心");
        title.add("沙鹿網球場");
        title.add("霧峰綜合運動場");
        title.add("吉峰搥球場");
        title.add("吉峰里簡易籃球場");
        title.add("本堂里簡易籃球場");
        title.add("丁台里簡易籃球場");
        title.add("舊正里簡易籃球場");
        title.add("臺中市網球中心");
        title.add("甲寅里厝後廣場籃球場");
        title.add("甲寅里屠宰場籃球場");
        title.add("四德里簡易籃球場");
        title.add("坑口里簡易球場");
        title.add("外埔籃球場");
        title.add("清水國民運動中心");
        title.add("足球運動休閒園區");
        title.add("大甲運動公園");
        title.add("港區運動公園");
        title.add("文高8");
        title.add("南埔簡易棒球場");
        title.add("烏溪簡易籃球場");
        title.add("河濱壘球場");
        title.add("龍井分駐所旁籃球場");
        title.add("竹坑活動中心旁籃球場");
        title.add("麗水籃球場");
        title.add("福田西濱橋下籃球場");
        title.add("南寮里中沙路南寮巷籃球場");
        title.add("新庄里向上路六段槌球場");
        title.add("中彰橋下槌球場");
        title.add("龍井龍田陸橋曲棍球場及溜冰場");
        title.add("中興橋下綜合球場籃球場滑輪直排輪場");
        title.add("山腳里龍山國小西面籃球場");
        title.add("國際壘球運動園區");
        title.add("霧峰舊正棒球園區");
        title.add("二信游泳池");
        title.add("水源館");
        title.add("文小91足球場");
        title.add("朝馬足球場");
        title.add("巨蛋體育館");
        title.add("大里區大突寮溜冰場");
        title.add("霧峰區萬豐里簡易籃球場");
        title.add("東湖壘球場");
        title.add("長榮里溜冰場");
        title.add("健民槌球場");
        title.add("高灘地的棒球場");
        title.add("大里區桌球場");
        title.add("瑞城公園溜冰場");
        title.add("沙鹿簡易運動場");
        title.add("沙鹿運十一");
        title.add("沙鹿運十四");
        title.add("沙鹿運六");
        title.add("大肚游泳池");
        title.add("幸福里籃球場");
        title.add("太平槌球場");
        title.add("太平河堤慢壘球場");
        title.add("太平區網球場");
        title.add("臺中公園網球場北二面南二面");
        title.add("太原足球場");
        title.add("文中10棒球場");
        title.add("大雅游泳池");
        title.add("永和路公有網球場");
        title.add("第七公墓簡易棒球場預定地");
        title.add("大雅體育園區棒球場");
        title.add("石岡游泳池");
        title.add("神岡體育園區壘球場");
        title.add("神岡體育園區棒球場");
        title.add("東勢體1");
        title.add("大里足球場");
        title.add("大雅體育園區二期");
        title.add("同安厝多功能草皮運動場");
        title.add("社南里籃球場");
        title.add("臺中客家樂活園區樂活運動館");
        title.add("臺中市烏日全民運動館");

        //add snippet for marker in snippet arraylist
        snippet.add("臺中市大甲區大安港路2號");
        snippet.add("臺中市大甲區東陽新村71-15號");
        snippet.add("臺中市大肚區沙田路三段247號");
        snippet.add("臺中市大里區東榮路55巷3號");
        snippet.add("臺中市大里區國光路大買家2點鐘方向");
        snippet.add("臺中市大里區國光路與大里路口");
        snippet.add("清泉崗空軍基地大門口斜對面");
        snippet.add("臺中市太平區中興東路99號");
        snippet.add("臺中市太平區永成北路306號");
        snippet.add("臺中市太平區宜昌路87巷(74號快速道路旁)");
        snippet.add("臺中市北屯區大連路、山西路口");
        snippet.add("臺中市北屯區山西路二段231號");
        snippet.add("臺中市北屯區山西路二段233號");
        snippet.add("臺中市北屯區建和路一段和建軍一街交叉");
        snippet.add("臺中市北屯區崇德八路1段93號");
        snippet.add("臺中市北屯區崇德路三段835號");
        snippet.add("台中市北屯區文昌東十一街");
        snippet.add("臺中市石岡區豐勢路轉國孝巷直行700M");
        snippet.add("臺中市后里區星科路底");
        snippet.add("臺中市西屯區寧夏東七街2號");
        snippet.add("臺中市南區五權南路與忠明南路口");
        snippet.add("臺中市西區向上路與大墩路交叉口");
        snippet.add("臺中市沙鹿區南陽路376號");
        snippet.add("臺中市沙鹿區保順一街134號1.2樓");
        snippet.add("臺中市沙鹿區鎮南路二段486號");
        snippet.add("臺中市東區七中路37號");
        snippet.add("臺中市東勢區公園路136號");
        snippet.add("臺中市東勢區公園路136號");
        snippet.add("臺中市烏日區光日路228號旁");
        snippet.add("臺中市烏日區光日路228號旁");
        snippet.add("臺中市烏日區慶光路798號");
        snippet.add("臺中市烏日區環河路三段736巷10號");
        snippet.add("臺中市梧棲區大仁路一段465巷");
        snippet.add("臺中市梧棲區大智路一段646號");
        snippet.add("臺中市梧棲區中正路303巷301號");
        snippet.add("臺中市梧棲區文昌路與文化路");
        snippet.add("臺中市梧棲區博愛北路259號附近");
        snippet.add("臺中市梧棲區博愛路215號");
        snippet.add("臺中市梧棲區博愛路215號");
        snippet.add("臺中市清水區五權二街與五權路(大秀國小旁)");
        snippet.add("臺中市清水區南社路");
        snippet.add("臺中市梧棲區中興路219號");
        snippet.add("臺中市清水區槺榔一街9號");
        snippet.add("臺中市清水區鰲峰路、民族路口");
        snippet.add("臺中市清水區鰲海路70號");
        snippet.add("臺中市新社區興安路1之1號");
        snippet.add("臺中市潭子區中山路二段237巷2號");
        snippet.add("臺中市潭子區甘蔗里勝利路100號");
        snippet.add("臺中市龍井區三德里中央路2段2巷45號");
        snippet.add("臺中市豐原區豐北街221號");
        snippet.add("臺中市霧峰區坑口里中正路46號(921地震教育園區旁)");
        snippet.add("臺中市霧峰區成功路200號");
        snippet.add("台中市東區東英六街及德興一街");
        snippet.add("臺中市大里區永隆六街");
        snippet.add("臺中市豐原區豐原大道一段");
        snippet.add("臺中市北屯區文教7用地(北屯區公所對面)");
        snippet.add("臺中市西屯區朝貴路199號");
        snippet.add("臺中市南屯區黎明路一段998號");
        snippet.add("臺中市太平區坪林森林公園");
        snippet.add("臺中市北區崇德路一段55號");
        snippet.add("臺中市大里區國光路與大里路交叉口");
        snippet.add("臺中市潭子區興華段");
        snippet.add("台中市南區合作街46號");
        snippet.add("台中市沙鹿區鎮政路8號");
        snippet.add("台中市霧峰區吉峰里民生路");
        snippet.add("臺中市霧峰區吉峰里峰堤路69號");
        snippet.add("臺中市霧峰區大愛路198號");
        snippet.add("臺中市霧峰區中正路-臺電後方");
        snippet.add("臺中市霧峰區丁台里丁台路444");
        snippet.add("臺中市霧峰區舊正里光明路116巷54號");
        snippet.add("臺中市北屯區祥順二路224號");
        snippet.add("臺中市霧峰區甲寅里德泰街68號");
        snippet.add("臺中市霧峰區甲寅里中正路1105巷15號");
        snippet.add("臺中市霧峰區四德里四德路");
        snippet.add("臺中市霧峰區復興路1段42號");
        snippet.add("外埔國小操場旁");
        snippet.add("臺中市清水區體2用地");
        snippet.add("臺中市南屯區龍富九路跟益豐路三段 南屯文中小用地");
        snippet.add("臺中市大甲區體2用地");
        snippet.add("臺中市沙鹿區三鹿里10鄰自強路301號");
        snippet.add("臺中市梧棲區文昌路與文化路交叉口");
        snippet.add("臺中市大安區南埔里南安路480號(大安南埔清潔隊旁)");
        snippet.add("臺中市龍井區福田村護岸路西側河堤");
        snippet.add("臺中市龍井區護岸路與中央南路西側堤岸");
        snippet.add("臺中市龍井區沙田路四段245號後方");
        snippet.add("臺中市龍井區竹坑里竹師路一段164巷2號旁(竹坑活動中心)");
        snippet.add("台中市龍井區麗水里5鄰三港路水裡港巷26號(龍井福順宮旁)");
        snippet.add("臺中市龍井區西濱橋下(福田宮旁)");
        snippet.add("臺中市龍井區南寮里中沙路南寮巷22號旁");
        snippet.add("臺中市龍井區向上路六段(兒童公園旁)");
        snippet.add("臺中市龍井區沙田路四段247號(中彰橋下)");
        snippet.add("臺中市龍井區龍田陸橋下");
        snippet.add("臺中市龍井區中興橋下");
        snippet.add("臺中市龍井區竹師路二段112巷46號旁(龍山國小西面)");
        snippet.add("臺中市外埔區長生路(大甲高工斜對面約300公尺處)");
        snippet.add("臺中市霧峰區中正路、光明路交叉口");
        snippet.add("臺中市南區柳川西路一段45號");
        snippet.add("臺中市北區水源路25-1號");
        snippet.add("臺中市西屯區虹揚橋邊");
        snippet.add("臺中市西屯區朝馬路145號");
        snippet.add("臺中市北屯區文中小6用地");
        snippet.add("臺中市大里十九甲消防隊前面河堤");
        snippet.add("臺中市霧峰區萬豐里中正路146巷59弄右轉到底");
        snippet.add("臺中市大里區中湖路100號");
        snippet.add("臺中市大里區德芳路一段160號對面(大里游泳池旁)");
        snippet.add("臺中市大里區健民里健東路上竹子坑集貨場附近");
        snippet.add("臺中市大里區美群路155巷與塗城路121巷之間(美群國小旁)");
        snippet.add("臺中市大里區德芳路一段229號3樓");
        snippet.add("臺中市大里區中興路一段2巷159弄16號");
        snippet.add("臺中市沙鹿區鎮政路與中正街交叉口(沙鹿公園旁)");
        snippet.add("臺中市沙鹿區中山路625號旁巷道右轉錦華街(沙鹿稽徵所後方)");
        snippet.add("臺中市沙鹿區光明街260號對面(中華路與中棲路口)");
        snippet.add("臺中市沙鹿區星河路209號(鹿峰國小裡)");
        snippet.add("臺中市大肚區頂街里華山路152號");
        snippet.add("臺中市大甲區黎明路與中山路交叉口(橋興生鮮超市後方)");
        snippet.add("臺中市太平區光興路1463巷33弄67號對面");
        snippet.add("臺中市太平區太堤西路跟太平路交接(河堤公園旁)");
        snippet.add("臺中市太平區太堤西路跟太平路交接(河堤公園旁)");
        snippet.add("台中市北區雙十路一段65號");
        snippet.add("臺中市北屯區建軍一街6-8號");
        snippet.add("臺中市北屯區崇德路三段835號");
        snippet.add("臺中市大雅區神林路一段171巷80號");
        snippet.add("大雅區永和路第四公墓納骨塔旁");
        snippet.add("台中市大雅區三和段67地號");
        snippet.add("臺中市大雅區民生路四段376巷3號");
        snippet.add("臺中市石岡區明德路173號");
        snippet.add("臺中市神岡區堤南路300號");
        snippet.add("臺中市神岡區堤南路300號");
        snippet.add("臺中市東勢區東和街與福成街交叉口");
        snippet.add("臺中市大里區永隆六街壘球場旁邊活動中心後面");
        snippet.add("臺中市大雅區民生路四段376巷3號");
        snippet.add("烏日高鐵基地站與焚化爐中間");
        snippet.add("臺中市神岡區社南里");
        snippet.add("臺中市東勢區圓樓街1號");
        snippet.add("臺中市烏日區新榮和段131 地號");



        /*nextPageBtn.setOnClickListener(new View.OnClickListener()

                                       {
                                           @Override
                                           public void onClick(View v)
                                           {
                                               Intent intent = new Intent();
                                               intent.setClass(MapsActivity.this, search.class);  //從主畫面跳到搜尋畫面
                                               startActivity(intent);
                                           }
                                       }
        );*/
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

                Intent i=new Intent(MapsActivity.this,DetailsActivity.class);
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
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.sportscomplex:
                Intent sportscomplexIntent = new Intent(this,SportsComplex.class);
                startActivity(sportscomplexIntent);
                break;
            case R.id.baseketball:
                Intent baseketballIntent = new Intent(this,baseketball.class);
                startActivity(baseketballIntent);
                break;
            case R.id.football:
                Intent footballIntent = new Intent(this,football.class);
                startActivity(footballIntent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = new MenuInflater(this);
        menuInflater.inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
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

    @Override
    public void onClick(View v) {

    }
}