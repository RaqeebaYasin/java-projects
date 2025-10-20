import java.awt.image.BufferedImage;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Are you Sender (S) or Receiver (R)? ");
        String role = scanner.nextLine().trim().toUpperCase();

        try {
            if (role.equals("S")) {
                System.out.print("Enter path to input image (PNG): ");
                String inputPath = scanner.nextLine();

                System.out.print("Enter secret message: ");
                String message = scanner.nextLine();

                BufferedImage image = ImageHelper.loadImage(inputPath);
                Steganography.hideMessage(image, message);

                System.out.print("Enter path to save encoded image: ");
                String outputPath = scanner.nextLine();

                ImageHelper.saveImage(image, outputPath);
                System.out.println("Message hidden successfully!");

            } else if (role.equals("R")) {
                System.out.print("Enter path to image to extract message from: ");
                String inputPath = scanner.nextLine();

                BufferedImage image = ImageHelper.loadImage(inputPath);
                String message = Steganography.extractMessage(image);

                System.out.println("Hidden Message: " + message);

            } else {
                System.out.println("Invalid role. Use S or R.");
            }

        } catch (Exception e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }
    }
}
