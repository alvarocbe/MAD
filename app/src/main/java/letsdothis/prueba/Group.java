package letsdothis.prueba;

import com.orm.SugarRecord;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Alvaro on 7/4/17.
 */

public class Group{
    //User[] users;
    String name;
    ArrayList<Expense> expenses = new ArrayList<Expense>();
    ArrayList<User> users= new ArrayList<User>();

    public Group() {
    }

    public Group(String name) {
        this.name = name;
    }

    public List<Expense> getExpenses() {
        return expenses;
    }

    public void setExpenses(ArrayList<Expense> expenses) {
        this.expenses = expenses;
    }

    public List<User> getUsers() {

        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }
    public void addUser(User user){
            this.users.add(user);
    }
    public void addExpense(Expense expense){
        this.expenses.add(expense);
    }
}
