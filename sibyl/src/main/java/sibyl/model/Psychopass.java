package sibyl.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * Created by haljik on 14/12/27.
 */
public class Psychopass {
    @JsonProperty("counter.human.psychopass.crimecoefficient")
    private Integer crimecoefficient = 0;

    public Integer getCrimecoefficient() {
        return crimecoefficient;
    }

    public void setCrimecoefficient(Integer crimecoefficient) {
        this.crimecoefficient = crimecoefficient;
    }

    public ExecutionMode mode() {
        if (crimecoefficient < 100) return ExecutionMode.None;
        if (crimecoefficient <= 300) return ExecutionMode.Paralizer;
        return ExecutionMode.Eliminator;
    }

    public String color() {
        int b = 255 - crimecoefficient;
        int g = 255 + (b < 0 ? b : 0);
        int r = 255 + (g < 0 ? g : 0);
        if (b < 0 ) b = 0;
        if (g < 0 ) g = 0;
        if (r < 0 ) r = 0;
        return "#" + toHex(r) + toHex(g) + toHex(b);
    }

    public String toHex(int i) {
        String hex = Integer.toHexString(i);
        if (hex.length() < 2) {
            return "0" + hex;
        }
        return hex;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
