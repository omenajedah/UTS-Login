package pradita.com.utsfirman;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String KEY_NAMA = "KEY_NAMA";



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setSupportActionBar(findViewById(R.id.toolbar));

        if (!getIntent().hasExtra(KEY_NAMA)) {
            finish();
            return;
        }

        ((TextView)findViewById(R.id.welcome_text))
                .setText(String.format(getString(R.string.text_welcome),
                        getIntent().getStringExtra(KEY_NAMA)));


    }



    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.menu1:
                Toast.makeText(this, "Menu 1", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu2:
                Toast.makeText(this, "Menu 2", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu3:
                Toast.makeText(this, "Menu 3", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu4:
                Toast.makeText(this, "Menu 4", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu5:
                Toast.makeText(this, "Menu 5", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu6:
                Toast.makeText(this, "Menu 6", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menuAbout:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Tentang Aplikasi");
                builder.setMessage("Aplikasi ini dibuat oleh Firmansyah, yang bertujuan untuk menyelesaikan UTS Pemrograman Android.");
                builder.setPositiveButton("OK", null);
                builder.show();
                break;
            case R.id.menuExit:
                startActivity(new Intent(this, LoginActivity.class));
                finish();
                break;

        }
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Keluar Aplikasi?");
        builder.setMessage("Apa anda yakin ingin keluar aplikasi?");
        builder.setPositiveButton("Ya", (dialog, which) -> finish());
        builder.setNegativeButton("Tidak", null);
        builder.show();
    }
}
