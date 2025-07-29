import com.zs.bse.Broker;
import com.zs.bse.Exchange;
import com.zs.bse.Holder;
import com.zs.bse.Stock;

public class TestStock {
    public static void main(String[] args) {
        Stock tisco = new Stock();

        Holder h = tisco;
        h.view();

        Broker b = tisco;
        b.get();
        b.view();

        Exchange x = tisco;
        x.set();
        x.get();
        x.view();
    }
}
