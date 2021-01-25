package com.upfpo.app.util;

import java.io.IOException;
import java.util.Map;

public interface EmailService {
    void sendSimpleMessage(String to,
                           String subject,
                           String text);
   }