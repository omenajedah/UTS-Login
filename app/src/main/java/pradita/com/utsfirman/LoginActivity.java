package pradita.com.utsfirman;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static pradita.com.utsfirman.MainActivity.KEY_NAMA;

public class LoginActivity extends AppCompatActivity {

    private EditText usernameText, passwordText;
    private Button loginButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setSupportActionBar(findViewById(R.id.toolbar));
        usernameText = findViewById(R.id.et_username);
        passwordText = findViewById(R.id.et_password);
        loginButton = findViewById(R.id.btn_login);

        usernameText.setOnEditorActionListener((v, actionId, event) -> {
            passwordText.requestFocus();
            return true;
        });

        passwordText.setOnEditorActionListener((v, actionId, event) -> {
            loginButton.performClick();
            return true;
        });

        loginButton.setOnClickListener(v -> {
            String username = usernameText.getText().toString().trim();
            String password = passwordText.getText().toString().trim();

            if (TextUtils.isEmpty(username)) {
                usernameText.setError("Mohon isi username anda.");
                usernameText.requestFocus();
                return;
            }
            if (TextUtils.isEmpty(password)) {
                passwordText.setError("Mohon isi password anda.");
                passwordText.requestFocus();
                return;
            }
            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra(KEY_NAMA, username.toUpperCase());
            startActivity(intent);
            finish();
        });
    }


}
