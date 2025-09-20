package com.softnexis.util;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class ValidationUtil {
    private static final Pattern EMAIL_RE = Pattern.compile(
        "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$"
    );
    private static final Pattern PHONE_RE = Pattern.compile("^\\d{10}$");

    public static Map<String, String> validateContact(String name, String email, String phone) {
        Map<String,String> errors = new HashMap<>();

        if (name == null || name.trim().isEmpty()) {
            errors.put("name", "Please enter valid name");
        } else {
            String trimmed = name.trim();
            if (trimmed.length() < 2 || trimmed.length() > 50) {
                errors.put("name", "Please enter valid name");
            }
        }

        if (email == null || email.trim().isEmpty()) {
            errors.put("email", "Invalid email address");
        } else if (!EMAIL_RE.matcher(email.trim()).matches()) {
            errors.put("email", "Invalid email address");
        }

        if (phone != null && !phone.trim().isEmpty()) {
            if (!PHONE_RE.matcher(phone.trim()).matches()) {
                errors.put("phone", "Use 10-digit format");
            }
        }

        return errors;
    }
}
