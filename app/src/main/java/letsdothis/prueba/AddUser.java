package letsdothis.prueba;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddUser extends AppCompatActivity {

    Button btnNext;
    EditText etUser1;
    Button btnOtherUser;

    public static Group activeGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);
        btnNext = (Button)findViewById(R.id.btnNext);
        etUser1 = (EditText)findViewById(R.id.etUser1);
        btnOtherUser = (Button)findViewById(R.id.btnOtherUser);

        activeGroup = CreateGroup.groupList.get(0);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                User user1 = new User(etUser1.getText().toString());
                activeGroup.addUser(user1);

                final Intent i = new Intent(AddUser.this, GroupOverview.class);
                startActivity(i);
            }
        });


        btnOtherUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                User user1 = new User(etUser1.getText().toString());
                activeGroup.addUser(user1);

                final Intent i = new Intent(AddUser.this, AddUser.class);
                startActivity(i);
            }
        });


    }
}
