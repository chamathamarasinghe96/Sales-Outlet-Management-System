/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.salesoutlet.view.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class Validator {

    public static boolean isValidChequeNo(String chequeNo) {
        if (chequeNo.matches("\\d{6}")) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isValidBankBranch(String code) {
        if (code.matches("\\d{7}")) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isValidName(String name) {
        if (name.matches("[A-Za-z. ]+")) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isValidAddress(String address) {
        if (address.matches("[A-Za-z0-9.,\n ]+")) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isValidPrice(String price) {
        if (price.matches("[1-9][0-9]+[.]\\d{2}|[1-9][0-9]+")) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isValidTelNo(String telNo) {
        if (telNo.matches("\\d{10}")) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isValidUnitQty(String unitQty) {
        if (unitQty.matches("[A-Za-z0-9. ]+")) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isValidQty(String qty) {
        if (qty.matches("[0-9]+[.]\\d{3}|[1-9][0-9]+")) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isValidDate(String date) {
        if (!date.matches("\\d{4}-\\d{2}-\\d{2}")) {
            return false;
        } else {
            SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
            sdf.setLenient(false);
            
            try {
                Date parsedDate = sdf.parse(date);
                if (parsedDate.compareTo(new Date() ) < 1) {
                    return true;
                }else{
                    return false;
                }
            } catch (ParseException ex) {
                return false;
            }
        }
    }
}
