@SuppressWarnings("all")

public class Currency {
    private String currencyName;
    private String plural;
    private String currencyType;
    
    public Currency(String currencyName) {
        this.currencyName = currencyName;

        this.currencyType = "¤";
        plural = "s";

        if(currencyName.charAt(currencyName.length() - 1) == 's') {
            currencyName = currencyName.substring(0, currencyName.length() - 1);
        }
    }

    public String getCurrencyType() {
        switch (currencyName.toLowerCase()) {
            case "dollar" : return "$";
            case "cent" : return "¢";
            case "euro" : return "€";
            case "pound" : return "£";
            case "yen" : return "¥";
            case "won" : return "₩";
            case "ruble" : return "₽";
            case "indrupee" : return "₹";
            case "peso" : return "₱";
            case "naira" : return "₦";
            case "tugrik" : return "₮";
            case "benrupee" : return "৲";
            case "mainrupee", "rupee" : return "Rs";
            case "tamrupee" : return "௹";
            case "baht" : return "฿";
            case "riel" : return "៛";
            case "shekel" : return "₪";
            case "dong" : return "₫";
            case "kip" : return "₭";
            case "guarani" : return "₲";
            case "hryvnia" : return "₴";
            case "cedi" : return "₵";
            case "rial" : return "﷼";
            case "balboa" : return "B/.";
        }
        return "¤";
    }

    public String getCurrencyName() {
        if(currencyName.equalsIgnoreCase("indrupee") || currencyName.equalsIgnoreCase("benrupee") || currencyName.equalsIgnoreCase("mainrupee") || currencyName.equalsIgnoreCase("tamrupee")) {
            currencyName = "rupee";
        }
        return currencyName;
    }

    public String getPlural() {
        switch (currencyName.toLowerCase()) {
            case "yen" : return "";
            case "naira" : return "";
            case "tugrik" : return "";
            case "baht" : return "";
            case "dong" : return "";
            case "guarani" : return "es";
        }
        return "s";
    }
}
