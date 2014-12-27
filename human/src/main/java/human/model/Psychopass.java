package human.model;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class Psychopass {
    Integer crimecoefficient = 0 ;

    public Integer getCrimecoefficient() {
        return crimecoefficient;
    }
    
    public void increment(Integer value) {
		this.crimecoefficient += value;
	}
    
    public void decrement(Integer value) {
		this.crimecoefficient -= value;
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
