public class Customer {

    private Wallet wallet;

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }

    public Customer() {
        this.wallet = new Wallet();
    }

    public Customer withCryptocurrency(String crypto, int quantity) {

        wallet.getMaskWalet().put(crypto,quantity);

        return this;
    }

    public Customer withBalance(int quantity) {

        return withCryptocurrency("$",quantity);
    }

    @Override
    public String toString() {
        return wallet.toString();
    }
}
