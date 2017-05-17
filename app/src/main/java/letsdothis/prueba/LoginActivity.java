package letsdothis.prueba;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.*;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    private Button buttonLogin;
    private EditText editTextEmail;
    private EditText editTextPassword;
    private Button buttonToSignup;

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        firebaseAuth = FirebaseAuth.getInstance();
        if(firebaseAuth.getCurrentUser()!=null){
            //That means the user is already logged in
        }
        editTextEmail = (EditText) findViewById(R.id.editTextMail2);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword2);
        buttonLogin = (Button) findViewById(R.id.buttonLogin);
        buttonToSignup = (Button) findViewById(R.id.buttonToRegister);

        buttonLogin.setOnClickListener(this);
        buttonToSignup.setOnClickListener(this);





    }
    private void userLogin(){
        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();

        if(TextUtils.isEmpty(email)){
            Toast.makeText(this, "Please enter an email",Toast.LENGTH_LONG).show();
            return;

        }
        if(TextUtils.isEmpty(password)){
            Toast.makeText(this, "Please enter a password",Toast.LENGTH_LONG).show();
            return;

        }
        firebaseAuth.signInWithEmailAndPassword(email,password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()) {
                            Toast.makeText(LoginActivity.this, "Logged in  Successfully",Toast.LENGTH_LONG).show();
                            finish();
                            //startActivity(new Intent(this, CreateGroup.class));
                            final Intent i = new Intent(LoginActivity.this, CreateGroup.class);
                            startActivity(i);
                        }
                        else{
                            Toast.makeText(LoginActivity.this, "Email or password are not correct",Toast.LENGTH_LONG).show();
                        }
                    }
                });

    }

    @Override
    public void onClick(View v) {
        if(v==buttonLogin)
            userLogin();

        if (v==buttonToSignup) {
            finish();
            startActivity(new Intent(this, MainActivity.class));
        }
    }
}
