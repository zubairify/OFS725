import com.zs.bank.Current;
import com.zs.bank.Savings;

public class TestAccounts {
    public static void main(String[] args) {
        Savings s1 = new Savings("Frank");
        s1.summary();
        s1.deposit(3000);
        s1.withdraw(2000);
        s1.withdraw(5000);
        s1.statement();

        Current c1 = new Current("Sam");
        c1.summary();

        c1.withdraw(3000);
        c1.withdraw(7000);
        c1.summary();

        c1.deposit(2000);
        c1.deposit(5000);
        c1.summary();
        c1.statement();

    }
}
