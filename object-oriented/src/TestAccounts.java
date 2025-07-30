import com.zs.bank.*;

public class TestAccounts {
    public static void main(String[] args) {
//        AccountsFactory factory = new AccountsFactory();
        Bank s1 = AccountsFactory.openSavings("John");
        s1.summary();

        try {
            s1.withdraw(1);
        } catch (BalanceException e) {
         //  e.printStackTrace(); - Developers: Troubleshooting
         // System.out.println(e.toString()); - Logging: Audit behavior
            System.out.println(e.getMessage());  // End users
        }
    }
}
