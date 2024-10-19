// Strategy Interface
interface PaymentStrategy {
    void pay(int amount);
}

// Concrete Strategies
class CreditCardStrategy implements PaymentStrategy {
    private String name;
    private String cardNumber;
    private String cvv;
    private String dateOfExpiry;

    public CreditCardStrategy(String nm, String ccNum, String cvv, String expiryDate) {
        this.name = nm;
        this.cardNumber = ccNum;
        this.cvv = cvv;
        this.dateOfExpiry = expiryDate;
    }

    @Override
    public void pay(int amount) {
        System.out.println(amount + " paid with credit/debit card");
    }
}

class PayPalStrategy implements PaymentStrategy {
    private String emailId;
    private String password;

    public PayPalStrategy(String email, String pwd) {
        this.emailId = email;
        this.password = pwd;
    }

    @Override
    public void pay(int amount) {
        System.out.println(amount + " paid using PayPal");
    }
}

// Context
class ShoppingCart {
    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy strategy) {
        this.paymentStrategy = strategy;
    }

    public void checkout(int amount) {
        paymentStrategy.pay(amount);
    }
}

// Client code
public class StrategyPatternDemo {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        cart.setPaymentStrategy(new CreditCardStrategy("John Doe", "1234567890123456", "786", "12/15"));
        cart.checkout(100);

        cart.setPaymentStrategy(new PayPalStrategy("johndoe@example.com", "mypwd"));
        cart.checkout(200);
    }
}
