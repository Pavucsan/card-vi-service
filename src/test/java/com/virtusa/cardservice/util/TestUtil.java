package com.virtusa.cardservice.util;

public class TestUtil {
    public static String createURLWithPort(String uri, int port) {
        return "http://localhost:" + port + uri;
    }
}
