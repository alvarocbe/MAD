package letsdothis.prueba;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class CreateGroup extends AppCompatActivity {

    public static ArrayList<Group> groupList = new ArrayList<Group>();

    Button btnNewGp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_group);

        btnNewGp = (Button)findViewById(R.id.btnNewGp);
        btnNewGp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Intent i = new Intent(CreateGroup.this, NewGroup.class);
                startActivity(i);
            }
        });


    }

}
