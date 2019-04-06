package kiky.beam.lilly.th.ac.rmutk.fruitqr;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.support.design.widget.NavigationView;

import org.json.JSONArray;
import org.json.JSONObject;

public class ServiceActivity extends AppCompatActivity
            implements NavigationView.OnNavigationItemSelectedListener {


    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle; //ทำการเชื่อม  toolbar กับ ActionBarDrawerToggle
    private String idString, nameUserString, typeUserString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);

        getUser();

    } //Main Method

    private void showList() {

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.contentServiceFragment, ShowListFragment.showListInstance(Integer.parseInt(typeUserString.trim()), idString))
                .commit();


    }

    private void createToobar() {
        Toolbar toolbar = findViewById(R.id.toobarService);
        setSupportActionBar(toolbar);
        getSupportActionBar().setSubtitle(nameUserString + " " + showType(typeUserString));
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationIcon(R.drawable.ic_action_hamberger); //ทำแถบเมณูเป็น Hamberger

//        Create Hamberger Icon
        drawerLayout = findViewById(R.id.layoutDrawerLayout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(ServiceActivity.this, drawerLayout, R.string.open,R.string.close); //ต้องใส่ค่า open และ close ใน string
    }

    private String showType(String typeUserString) {

        String[] strings = {"", "Admin", "Farmer", "Product", "Customer"};
        try {

            int index = Integer.parseInt(typeUserString.trim());
            return strings[index];

        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }


    }

    private void getUser() {
        idString = getIntent().getStringExtra("id");
        try {

            Myconstant myconstant = new Myconstant();
            GetDataWhereOneColumn getDataWhereOneColumn = new GetDataWhereOneColumn(ServiceActivity.this);
            getDataWhereOneColumn.execute("id", idString, myconstant.getUrlGetUserWhereId());
            String json = getDataWhereOneColumn.get();

            JSONArray jsonArray = new JSONArray(json);
            JSONObject jsonObject = jsonArray.getJSONObject(0);

            nameUserString = jsonObject.getString("Name");
            typeUserString = jsonObject.getString("TypeUser");

            createToobar();

            showList();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_service,menu);

        return super.onCreateOptionsMenu(menu);
    }

    //ทำแถบเมณูที่เปิดออกมาจากด้านซ้ายมือ
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.itemQR){
            Intent intent = new Intent(ServiceActivity.this, QRActivity.class);
            intent.putExtra("Login", false);
            startActivity(intent);

        }

        if(item.getItemId() == R.id.itemExit){
            Log.d("7janv1","you click");
            finish();
        }
        if(actionBarDrawerToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        actionBarDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        actionBarDrawerToggle.syncState();
    }    //ทำแถบเมณูถึงนี่



    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.action_main) { //หน้าหลัก
            Intent intent1 = new Intent(ServiceActivity.this, MainActivity.class);
            startActivity(intent1);

        } else if (id == R.id.action_scan) { //หน้าสแกน
            Intent intent2 = new Intent(ServiceActivity.this, QRActivity.class);
            startActivity(intent2);


        } else if (id == R.id.action_farmer) { //หน้าผลผลิต
            Intent intent3 = new Intent(ServiceActivity.this, DetailServiceActivity.class);
            startActivity(intent3);

        } else if (id == R.id.action_addframer) { //เพิ่มผลิตภัณฑ์
            Intent intent4 = new Intent(ServiceActivity.this, ProductFragment.class);
            startActivity(intent4);

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.layoutDrawerLayout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


} //Main Class
