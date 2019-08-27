package com.aeorsh.dicoding.mysubmission;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;


public class DetailActivity extends AppCompatActivity {
    public static final String EXTRA_NAME = "extra_name";
    public static final String EXTRA_PIC = "extra_name";
    public static final String EXTRA_KONTEN = "extra_name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Bundle b = getIntent().getExtras();
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        setActionBarTitle((String) b.get("nama"));
        ImageView tvPicReceived = findViewById(R.id.detail_pic);
        TextView tvNameReceived = findViewById(R.id.detail_name);
        TextView tvKontenReceived = findViewById(R.id.detail_konten);

        tvNameReceived.setText(b.getCharSequence("nama"));
        tvKontenReceived.setText(b.getCharSequence("konten"));

        ImageView imageView = (ImageView) findViewById(R.id.detail_pic);
        String picurl = b.getString("pic");
        Glide.with(this)
                .load(picurl)
                .into(imageView);



    }

    private void setActionBarTitle(String title) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
        }
    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item){

        switch (item.getItemId()) {
            case android.R.id.home:
                //Write your logic here
                this.finish();
                return true;
            case R.id.profile:
                startActivity(new Intent(this, ProfileActivity.class));
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
