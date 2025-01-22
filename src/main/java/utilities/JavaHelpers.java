package utilities;

import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class JavaHelpers {

    private static final Logger log = LoggerFactory.getLogger(JavaHelpers.class);
    private static HashMap<String, Object> dataMap = new HashMap<>();

    /**
     * Set value on local storage
     * @param key as a param
     * @param value
     * @return String timestamp
     *
     */
    public static void saveValue(String key, Object value) {
        dataMap.put(key, value);
    }

    /**
     * Set value from local storage
     * @param key to get the value
     *
     */
    public static Object getValue(String key) {
        return dataMap.get(key);
    }


    //Time-stamps
    /**
     * Get current time-stamp in given format
     * @param String format e.g. "yyyy MMM dd", 'yyyyMMdd_HHmmss' etc.
     * @return String timestamp
     *
     */
    public String getTimeStamp(String format)
    {
        /*
         * Example format are :
         *
         * "yyyy MMM dd" for "2013 Nov 28"
         *
         * "yyyyMMdd_HHmmss" for "20130131000000"
         *
         * "yyyy MMM dd HH:mm:ss" for "2013 Jan 31 00:00:00"
         *
         * "dd MMM yyyy" for "28 Nov 2017"
         */
        DateFormat dateFormat = new SimpleDateFormat(format);
        Date date = new Date();
        return dateFormat.format(date);
    }

    /**
     *
     * @param number as string
     * handle empty string will be return 0, string number will be parse to double number, other texts will throw exception
     * @return Double type data
     */
    public Double convertToDouble(String number) {
        String price = number.replaceAll("\\$", "");
        try {
            if (Objects.equals(price, "")) {
                return 0.0;
            }
            return Double.parseDouble(price);
        } catch (Exception e) {
            log.error("Error when convert value {} to Double, e: {} ", number, e.getMessage());
            throw e;
        }
    }

    /**
     * Convert List of String to List of Double
     * @param elementList as list of string
     * @return List of Double
     */
    public List<Double> convertListToDouble(List<WebElement> elementList) {
        return elementList.stream().map(price -> convertToDouble(price.getText())).toList();
    }

    /**
     *
     * @param data consist of double value
     * @param sortBy "highest" or "cheapest"
     * @return boolean : if data successfully sorted by param highest/cheapest then would be return true, else return false
     */
    public Boolean isDataSorted(List<Double> data, String sortBy) {
        Double prevData = data.get(0);
        for (int i = 1; i < data.size() ; i++) {
            if (!compareDoubleValue(sortBy, prevData, data.get(i))) {
                return false;
            }
        }
        return true;
    }

    private boolean compareDoubleValue(String sortBy, Double prevData, Double currentData) {
        if (sortBy.equals("highest")) {
            return prevData > currentData;
        }
        return prevData < currentData;
    }

    /**
     *
     * @param data
     * @param sortBy "ascending" or "descending"
     * @return boolean : if data successfully sorted by param asc/desc then would be return true, else return false
     */
    public Boolean isSort(List<String> data, String sortBy) {
        String prevData = data.get(0);
        for (int i = 1; i < data.size() ; i++) {
            if (checkSortingOrder(sortBy, prevData, data.get(i))) {
                return false;
            }
        }
        return true;
    }

    private boolean checkSortingOrder(String sortBy, String prevData, String currentData) {
        if (sortBy.equals("ascending")) {
            return prevData.compareTo(currentData) > 0;
        }
        return prevData.compareTo(currentData) < 0;
    }

}
