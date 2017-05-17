package letsdothis.prueba;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class AddExpense extends AppCompatActivity {

    EditText etTitle,etAmount,etPayer;
    Button btnAdd;
    Expense expense;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_expense);


        etTitle = (EditText)findViewById(R.id.etTitle);
        etAmount = (EditText)findViewById(R.id.etAmount);
        etPayer = (EditText)findViewById(R.id.etPayer);
        btnAdd = (Button)findViewById(R.id.btnAdd);


        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double amount = Double.parseDouble(etAmount.getText().toString());
                ArrayList<User> users= GroupOverview.activeGroup.users;

                expense = new Expense(etTitle.getText().toString(),amount);
                GroupOverview.activeGroup.addExpense(expense);
                for(int i=0;i<users.size();i++){
                    if (etPayer.getText().toString().equals(users.get(i).getName())){
                        users.get(i).setStatus(amount -amount/users.size());
                        expense.setPayer(users.get(i));
                    }else{
                        users.get(i).setStatus(0-amount/users.size());
                    }
                }
                final Intent i = new Intent(AddExpense.this, GroupOverview.class);
                startActivity(i);
                finish();
            }
        });

    }
}