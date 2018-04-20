package app;

import java.util.regex.Pattern;

public interface BarCodeRadex {
    Pattern pattern = Pattern.compile("[A-Z]{2,3}[0-9]{2}\\.[0-9]{2,3}\\.[A-Z0-9]+");
}
