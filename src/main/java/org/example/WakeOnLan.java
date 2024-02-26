package org.example;

import java.net.InetAddress;

public class WakeOnLan {

    public static final int PORT = 9;
    public static void main(String[] args) {
        System.out.println("Hello world!");
        if (args.length != 2) {
            System.out.println("Start app with parameters: <broadcast_ip> <device_mac_address separate by '-' or ':'>");
            System.exit(1);
        }

        String ipAddress = args[0];
        String macAddress = args[1];

        try {
            byte[] macBytes = getMacBytes(macAddress);
            byte[] bytes = new byte[6 + 16 * macBytes.length];
            for (int i = 0; i < 6; i++) {
                bytes[i] = (byte) 0xff;
            }
            for (int i = 6; i < bytes.length; i += macBytes.length) {
                System.arraycopy(macBytes, 0, bytes, i, macBytes.length);
            }

            //TODO

        } catch (Exception e) {
            System.out.println("Magic packet faild: " + e.getMessage());
            System.exit(1);
        }
    }

    private static byte[] getMacBytes(String macAddress) {
        return new byte[0]; //TODO
    }
}