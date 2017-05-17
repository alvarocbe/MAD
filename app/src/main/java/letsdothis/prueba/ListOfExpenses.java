package letsdothis.prueba;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ListOfExpenses extends AppCompatActivity {

    ListView lvExp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_expenses);

        lvExp = (ListView)findViewById(R.id.lvExp);
        showExpenseList();

    }

    public void showExpenseList(){
        List<Expense> expList = GroupOverview.activeGroup.expenses;
        ArrayList<String> list1 = new ArrayList<String>();

        for(int i=0;i<expList.size();i++){

            Expense result = expList.get(i);
            list1.add(""+result.getTitle()+" : "+result.getAmount()+" : "+result.getPayer().getName());
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, list1);
        lvExp.setAdapter(adapter);

    }
}
