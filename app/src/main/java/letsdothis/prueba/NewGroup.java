package letsdothis.prueba;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NewGroup extends AppCompatActivity {

    EditText etName;
    Button btnNext;
    EditText etUser1;
    Button btnOtherUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_group);
        etName = (EditText)findViewById(R.id.etName);
        btnNext = (Button)findViewById(R.id.btnNext);
        etUser1 = (EditText)findViewById(R.id.etUser1);
        btnOtherUser = (Button)findViewById(R.id.btnOtherUser);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Group group = new Group(etName.getText().toString());

                etName.getText();
                User user1 = new User(etUser1.getText().toString());
                group.addUser(user1);

                CreateGroup.groupList.add(group);

                final Intent i = new Intent(NewGroup.this, GroupOverview.class);
                startActivity(i);
            }
        });


        btnOtherUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Group group = new Group(etName.getText().toString());

                etName.getText();
                User user1 = new User(etUser1.getText().toString());
                group.addUser(user1);

                CreateGroup.groupList.add(group);

                final Intent i = new Intent(NewGroup.this, AddUser.class);
                startActivity(i);
            }
        });

    }
}
