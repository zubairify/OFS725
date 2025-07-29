import com.zs.emp.Clerk;
import com.zs.emp.Employee;
import com.zs.emp.Manager;

public class TestEmployee {

    public static void main(String[] args) {
        Clerk clk = new Clerk(1900, 300);

        Manager mgr = new Manager(2600, 700);

        showSalary(clk);
        showSalary(mgr);
    }

    private static void showSalary(Employee emp) {
        if(emp instanceof Manager)
            System.out.println("com.zs.emp.Manager Salary: " + emp.getSalary());
        else
            System.out.println("com.zs.emp.Clerk Salary: " + emp.getSalary());
    }
}
