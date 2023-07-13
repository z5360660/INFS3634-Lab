package au.edu.unsw.infs3634_lab.api;

import java.io.Serializable;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import au.edu.unsw.infs3634_lab.api.Crypto;

@Generated("jsonschema2pojo")
public class Response implements Serializable
{

    @SerializedName("data")
    @Expose
    private List<Datum> data;
    @SerializedName("info")
    @Expose
    private Info info;
    private final static long serialVersionUID = -7356476235905957808L;

    public List<Datum> getData() {
        return data;
    }

    public void setData(List<Datum> data) {
        this.data = data;
    }

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

    public static final String JsonString = "{\n" +
            "  \"data\": [\n" +
            "    {\n" +
            "      \"id\": \"90\",\n" +
            "      \"symbol\": \"BTC\",\n" +
            "      \"name\": \"Bitcoin\",\n" +
            "      \"nameid\": \"bitcoin\",\n" +
            "      \"rank\": 1,\n" +
            "      \"price_usd\": \"30320.88\",\n" +
            "      \"percent_change_24h\": \"-0.87\",\n" +
            "      \"percent_change_1h\": \"-0.12\",\n" +
            "      \"percent_change_7d\": \"-0.12\",\n" +
            "      \"price_btc\": \"1.00\",\n" +
            "      \"market_cap_usd\": \"588452003160.44\",\n" +
            "      \"volume24\": 11717729392.461353,\n" +
            "      \"volume24a\": 9534922959.704233,\n" +
            "      \"csupply\": \"19407484.00\",\n" +
            "      \"tsupply\": \"19407484\",\n" +
            "      \"msupply\": \"21000000\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"id\": \"80\",\n" +
            "      \"symbol\": \"ETH\",\n" +
            "      \"name\": \"Ethereum\",\n" +
            "      \"nameid\": \"ethereum\",\n" +
            "      \"rank\": 2,\n" +
            "      \"price_usd\": \"1869.12\",\n" +
            "      \"percent_change_24h\": \"-0.63\",\n" +
            "      \"percent_change_1h\": \"-0.12\",\n" +
            "      \"percent_change_7d\": \"-1.98\",\n" +
            "      \"price_btc\": \"0.062074\",\n" +
            "      \"market_cap_usd\": \"228734583381.62\",\n" +
            "      \"volume24\": 30697800570.27799,\n" +
            "      \"volume24a\": 11648288404.067818,\n" +
            "      \"csupply\": \"122375302.00\",\n" +
            "      \"tsupply\": \"122375302\",\n" +
            "      \"msupply\": \"\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"id\": \"518\",\n" +
            "      \"symbol\": \"USDT\",\n" +
            "      \"name\": \"Tether\",\n" +
            "      \"nameid\": \"tether\",\n" +
            "      \"rank\": 3,\n" +
            "      \"price_usd\": \"1.00\",\n" +
            "      \"percent_change_24h\": \"0.05\",\n" +
            "      \"percent_change_1h\": \"-0.16\",\n" +
            "      \"percent_change_7d\": \"0.05\",\n" +
            "      \"price_btc\": \"0.000033\",\n" +
            "      \"market_cap_usd\": \"68352184768.33\",\n" +
            "      \"volume24\": 21541101599.62945,\n" +
            "      \"volume24a\": 18910156936.44604,\n" +
            "      \"csupply\": \"68319442037.00\",\n" +
            "      \"tsupply\": \"73141766321.234\",\n" +
            "      \"msupply\": \"\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"id\": \"33285\",\n" +
            "      \"symbol\": \"USDC\",\n" +
            "      \"name\": \"USD Coin\",\n" +
            "      \"nameid\": \"usd-coin\",\n" +
            "      \"rank\": 4,\n" +
            "      \"price_usd\": \"1.00\",\n" +
            "      \"percent_change_24h\": \"0.01\",\n" +
            "      \"percent_change_1h\": \"0.00\",\n" +
            "      \"percent_change_7d\": \"0.04\",\n" +
            "      \"price_btc\": \"0.000033\",\n" +
            "      \"market_cap_usd\": \"41301737388.74\",\n" +
            "      \"volume24\": 26997396956.314014,\n" +
            "      \"volume24a\": 8763166450.308714,\n" +
            "      \"csupply\": \"41300868946.00\",\n" +
            "      \"tsupply\": \"41300868946.621\",\n" +
            "      \"msupply\": \"\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"id\": \"2710\",\n" +
            "      \"symbol\": \"BNB\",\n" +
            "      \"name\": \"Binance Coin\",\n" +
            "      \"nameid\": \"binance-coin\",\n" +
            "      \"rank\": 5,\n" +
            "      \"price_usd\": \"243.42\",\n" +
            "      \"percent_change_24h\": \"-2.54\",\n" +
            "      \"percent_change_1h\": \"-0.12\",\n" +
            "      \"percent_change_7d\": \"2.27\",\n" +
            "      \"price_btc\": \"0.008084\",\n" +
            "      \"market_cap_usd\": \"40602772403.62\",\n" +
            "      \"volume24\": 341202763.9551611,\n" +
            "      \"volume24a\": 367195057.971848,\n" +
            "      \"csupply\": \"166801148.00\",\n" +
            "      \"tsupply\": \"192443301\",\n" +
            "      \"msupply\": \"200000000\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"id\": \"58\",\n" +
            "      \"symbol\": \"XRP\",\n" +
            "      \"name\": \"XRP\",\n" +
            "      \"nameid\": \"ripple\",\n" +
            "      \"rank\": 6,\n" +
            "      \"price_usd\": \"0.471538\",\n" +
            "      \"percent_change_24h\": \"-0.59\",\n" +
            "      \"percent_change_1h\": \"0.02\",\n" +
            "      \"percent_change_7d\": \"-0.43\",\n" +
            "      \"price_btc\": \"0.000016\",\n" +
            "      \"market_cap_usd\": \"20233480657.91\",\n" +
            "      \"volume24\": 579458804.6716502,\n" +
            "      \"volume24a\": 513125257.3449201,\n" +
            "      \"csupply\": \"42909539227.00\",\n" +
            "      \"tsupply\": \"99991841593\",\n" +
            "      \"msupply\": \"100000000000\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"id\": \"48591\",\n" +
            "      \"symbol\": \"BUSD\",\n" +
            "      \"name\": \"Binance USD\",\n" +
            "      \"nameid\": \"binance-usd\",\n" +
            "      \"rank\": 7,\n" +
            "      \"price_usd\": \"0.999804\",\n" +
            "      \"percent_change_24h\": \"0.00\",\n" +
            "      \"percent_change_1h\": \"0.00\",\n" +
            "      \"percent_change_7d\": \"-0.07\",\n" +
            "      \"price_btc\": \"0.000033\",\n" +
            "      \"market_cap_usd\": \"16145756817.04\",\n" +
            "      \"volume24\": 1123106111.6727993,\n" +
            "      \"volume24a\": 1007341133.0546206,\n" +
            "      \"csupply\": \"16148914845.00\",\n" +
            "      \"tsupply\": \"16148914845.973\",\n" +
            "      \"msupply\": \"\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"id\": \"257\",\n" +
            "      \"symbol\": \"ADA\",\n" +
            "      \"name\": \"Cardano\",\n" +
            "      \"nameid\": \"cardano\",\n" +
            "      \"rank\": 8,\n" +
            "      \"price_usd\": \"0.286726\",\n" +
            "      \"percent_change_24h\": \"-2.07\",\n" +
            "      \"percent_change_1h\": \"-0.26\",\n" +
            "      \"percent_change_7d\": \"1.05\",\n" +
            "      \"price_btc\": \"0.000010\",\n" +
            "      \"market_cap_usd\": \"9927075085.35\",\n" +
            "      \"volume24\": 114352692.56622015,\n" +
            "      \"volume24a\": 132867782.20745972,\n" +
            "      \"csupply\": \"34622161734.00\",\n" +
            "      \"tsupply\": \"35467426506.415\",\n" +
            "      \"msupply\": \"45000000000\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"id\": \"2\",\n" +
            "      \"symbol\": \"DOGE\",\n" +
            "      \"name\": \"Dogecoin\",\n" +
            "      \"nameid\": \"dogecoin\",\n" +
            "      \"rank\": 9,\n" +
            "      \"price_usd\": \"0.064846\",\n" +
            "      \"percent_change_24h\": \"-0.69\",\n" +
            "      \"percent_change_1h\": \"-0.11\",\n" +
            "      \"percent_change_7d\": \"-2.58\",\n" +
            "      \"price_btc\": \"0.000002\",\n" +
            "      \"market_cap_usd\": \"9068527031.81\",\n" +
            "      \"volume24\": 135317278.0722366,\n" +
            "      \"volume24a\": 116915248.17899893,\n" +
            "      \"csupply\": \"139847056384.00\",\n" +
            "      \"tsupply\": \"139847056384\",\n" +
            "      \"msupply\": \"\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"id\": \"48543\",\n" +
            "      \"symbol\": \"SOL\",\n" +
            "      \"name\": \"Solana\",\n" +
            "      \"nameid\": \"solana\",\n" +
            "      \"rank\": 10,\n" +
            "      \"price_usd\": \"21.73\",\n" +
            "      \"percent_change_24h\": \"-1.02\",\n" +
            "      \"percent_change_1h\": \"-0.24\",\n" +
            "      \"percent_change_7d\": \"15.70\",\n" +
            "      \"price_btc\": \"0.000722\",\n" +
            "      \"market_cap_usd\": \"8155730237.08\",\n" +
            "      \"volume24\": 500998688.95456517,\n" +
            "      \"volume24a\": 393880423.990105,\n" +
            "      \"csupply\": \"375273818.00\",\n" +
            "      \"tsupply\": \"491561409.22682\",\n" +
            "      \"msupply\": \"\"\n" +
            "    }\n" +
            "  ],\n" +
            "  \"info\": {\n" +
            "    \"coins_num\": 11047,\n" +
            "    \"time\": 1689218282\n" +
            "  }\n" +
            "}";


}
