import java.awt.image.BufferedImage;

public class Steganography {

    public static void hideMessage(BufferedImage image, String message) {
        int msgIndex = 0;
        message += (char) 0; // null char as end marker

        for (int y = 0; y < image.getHeight(); y++) {
            for (int x = 0; x < image.getWidth(); x++) {
                if (msgIndex < message.length()) {
                    int rgb = image.getRGB(x, y);
                    int charValue = message.charAt(msgIndex);
                    int newRgb = (rgb & 0xFFFF00) | (charValue & 0xFF); // Store char in blue channel
                    image.setRGB(x, y, newRgb);
                    msgIndex++;
                } else {
                    return;
                }
            }
        }
    }

    public static String extractMessage(BufferedImage image) {
        StringBuilder message = new StringBuilder();
        for (int y = 0; y < image.getHeight(); y++) {
            for (int x = 0; x < image.getWidth(); x++) {
                int rgb = image.getRGB(x, y);
                int charValue = rgb & 0xFF; // Read blue channel
                if (charValue == 0) return message.toString(); // End of message
                message.append((char) charValue);
            }
        }
        return message.toString();
    }
}
