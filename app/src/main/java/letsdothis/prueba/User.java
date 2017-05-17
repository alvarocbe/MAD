package letsdothis.prueba;

/**
 * Created by Alvaro on 7/4/17.
 */

import com.orm.SugarRecord;

/**
 * Created by Alvaro on 3/4/17.
 */

public class User{
    String name;
    double status;

    public User() {
    }

    public User(String name) {
        this.name = name;
        this.status = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getStatus() {
        return status;
    }

    public void setStatus(double status) {
        this.status = this.status+status;
    }
}
