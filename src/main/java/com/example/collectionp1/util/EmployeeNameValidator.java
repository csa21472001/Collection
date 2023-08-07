package com.example.collectionp1.util;

import com.example.collectionp1.exceptions.IllegalNanmeException;
import org.apache.commons.lang3.StringUtils;

public class EmployeeNameValidator {
    public static void checkName(String... names) {
        for (String n: names) {
            if (!StringUtils.isAlpha(n)) {
                throw new IllegalNanmeException();
            }
        }
    }
}
