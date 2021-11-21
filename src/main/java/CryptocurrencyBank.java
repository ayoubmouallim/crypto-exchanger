import java.util.ArrayList;
import java.util.List;

public class CryptocurrencyBank {

    private List<String> supportedCrypto = new ArrayList<>();
    private List<Customer> sellers = new ArrayList<>();
    private Integer numberOfBuyers = 0;

    public List<String> getSupportedCrypto() {
        return supportedCrypto;
    }

    public void setSupportedCrypto(List<String> supportedCrypto) {
        this.supportedCrypto = supportedCrypto;
    }

    public void addSupportedCryptoCurrency(String bitcoin) {

            supportedCrypto.add(bitcoin);
    }

    public int settingPrice()
    {
        int price =1;
        if(numberOfBuyers>1)
            price = numberOfBuyers*numberOfBuyers-numberOfBuyers;

        return price;
    }


    public int requestTransaction(Customer buyerCustomer, int quantity, String crypto) {

        if(sellers.size()>0 && sellers.get(0).getWallet().getMaskWalet().containsKey(crypto) && sellers.get(0).getWallet().getMaskWalet().get(crypto) >= quantity )
        {
            numberOfBuyers++;
            int price = settingPrice();
            buyerCustomer.getWallet().getMaskWalet().put("$",buyerCustomer.getWallet().getMaskWalet().get("$")-price*quantity);
            buyerCustomer.withCryptocurrency(crypto,quantity);

            sellers.get(0).getWallet().getMaskWalet().put("$", sellers.get(0).getWallet().getMaskWalet().get("$")+price*quantity);
            sellers.get(0).getWallet().getMaskWalet().put(crypto,sellers.get(0).getWallet().getMaskWalet().get(crypto)-quantity);

           return quantity;
        }
        return 0;

    }

    public void addSeller(Customer sellerCustomer) {
        sellers.add(sellerCustomer);
    }
}
