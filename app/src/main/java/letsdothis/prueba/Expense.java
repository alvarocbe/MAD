package letsdothis.prueba;


import com.orm.SugarRecord;

import java.util.List;

/**
 * Created by Alvaro on 3/4/17.
 */

public class Expense {
    String title;
    double amount;
    User payer;
    List<User> payingMembers;

    public Expense() {
    }
    public Expense(String title, double amount) {
        this.title = title;
        this.amount = amount;
    }

    public Expense(String title, double amount, User payer, List<User> payingMembers) {
        this.title = title;
        this.amount = amount;
        this.payer = payer;
        this.payingMembers = payingMembers;
        double count = amount/payingMembers.size();
        payer.setStatus(amount-count);
        for(int i=0;i<payingMembers.size();i++){
            if (payingMembers.get(i) !=payer) {
                payingMembers.get(i).setStatus(0-count);
            }
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public User getPayer() {
        return payer;
    }

    public void setPayer(User payer) {
        this.payer = payer;
    }

    public List<User> getPayingMembers() {
        return payingMembers;
    }

    public void setPayingMembers(List<User> payingMembers) {
        this.payingMembers = payingMembers;
    }
}


