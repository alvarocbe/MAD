package letsdothis.prueba;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class GroupOverview extends AppCompatActivity {

    public static Group activeGroup;
    ListView lvUsers;
    Button btnAddExp;
    Button btnExpList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_overview);

        lvUsers = (ListView) findViewById(R.id.lvUsers);
        btnAddExp = (Button)findViewById(R.id.btnNewExp);
        btnExpList = (Button)findViewById(R.id.btnExpList);

        activeGroup = CreateGroup.groupList.get(0);
        showUsersList();

        btnAddExp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Intent i = new Intent(GroupOverview.this, AddExpense.class);
                startActivity(i);
            }
        });
        btnExpList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Intent i = new Intent(GroupOverview.this, ListOfExpenses.class);
                startActivity(i);
            }
        });



    }

    public void showUsersList(){
        List<User> userList = activeGroup.getUsers();
        ArrayList<String> list1 = new ArrayList<String>();

        for(int i=0;i<userList.size();i++){

            User result = userList.get(i);
            list1.add(""+result.getName()+"  :  "+result.getStatus());
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, list1);
        lvUsers.setAdapter(adapter);

    }
}

