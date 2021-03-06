package sipay.paymethod;

import org.json.JSONObject;

import java.util.regex.Pattern;

public class FastPay implements PayMethod {
    String token;

    public FastPay(String token) {
        setToken(token);
    }

    public JSONObject update(JSONObject payload) {
        JSONObject fastPay = new JSONObject();
        fastPay.put("request_id", this.token);

        payload.put("fastpay", fastPay);

        return payload;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        if (!Pattern.compile("^[a-fA-F0-9]{32}$").matcher(token).find()) {
            throw new RuntimeException("Token must have 32 hexadecimal characters.");
        }

        this.token = token;
    }
}
