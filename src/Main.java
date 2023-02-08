

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class Main {
    public static String imageURL = "https://firebasestorage.googleapis.com/v0/b/blog-app-892f0.appspot.com/o/images%2Ftemp%2Fbanner.png?alt=media&token=f074db12-aa0a-4919-9044-ebf06f457398";

    public static void main(String[] args) {
        JFrame frame = new JFrame("Global Hack Week 2023 (FEB)");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);

        // Set window bgColor to Black
        frame.setLayout(new BorderLayout());
        frame.getContentPane().setBackground(Color.BLACK);

        // Get image from network
        BufferedImage img = null;
        try {
            URL url = new URL(imageURL);
            img = ImageIO.read(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
        ImageIcon icon = new ImageIcon(img);

        Image image = icon.getImage();

        // Get Image height, width and aspect ratio
        int width = image.getWidth(null);
        int height = image.getHeight(null);
        double aspectRatio = (double) width / height;

        // Get Window height, width and aspect ratio
        int windowWidth = frame.getWidth();
        int windowHeight = frame.getHeight();
        double windowAspectRatio = (double) windowWidth / windowHeight;

        // Set aspect ratio such that the image is contained within the window
        if (windowAspectRatio > aspectRatio) {
            width = (int) (windowHeight * aspectRatio);
            height = windowHeight;
        } else {
            width = windowWidth;
            height = (int) (windowWidth / aspectRatio);
        }
        // Get the scaled version according to the contained height and with
        Image scaledImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);

        // Add the image to the frame
        JLabel label = new JLabel(scaledIcon);
        frame.add(label, BorderLayout.CENTER);

        // Display the window
        frame.setVisible(true);

    }
}