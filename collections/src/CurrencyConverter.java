public class CurrencyConverter {

    public double convert(Currency source, Currency target, double amount) {
        return (source.rupeeValue()/target.rupeeValue()) * amount;
    }

    public static void main(String[] args) {
        Currency INR = () -> 1.0;
        Currency USD = () -> 83.50;
        Currency GBP = () -> 115.75;
        Currency AED = () -> 23.85;

        CurrencyConverter cc = new CurrencyConverter();
        System.out.println(cc.convert(INR, USD, 100));
        System.out.println(cc.convert(USD, INR, 10));
        System.out.println(cc.convert(AED, INR, 10));
        System.out.println(cc.convert(GBP, INR, 10));
    }
}
