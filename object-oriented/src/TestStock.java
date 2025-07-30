import com.zs.bse.*;

public class TestStock {
    public static void main(String[] args) {
        Holder h = StockSingleton.getStock();
        h.view();

        Broker b = StockSingleton.getStock();
        b.get();
        b.view();

        Exchange x = StockSingleton.getStock();
        x.set();
        x.get();
        x.view();

        System.out.println(h == b);
        System.out.println(b == x);
    }
}
