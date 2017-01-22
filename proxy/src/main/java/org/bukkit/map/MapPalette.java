package org.bukkit.map;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

public final class MapPalette {

    private static final Color[] colors = new Color[] { new Color(0, 0, 0, 0), new Color(0, 0, 0, 0), new Color(0, 0, 0, 0), new Color(0, 0, 0, 0), c(89, 125, 39), c(109, 153, 48), c(127, 178, 56), c(67, 94, 29), c(174, 164, 115), c(213, 201, 140), c(247, 233, 163), c(130, 123, 86), c(117, 117, 117), c(144, 144, 144), c(167, 167, 167), c(88, 88, 88), c(180, 0, 0), c(220, 0, 0), c(255, 0, 0), c(135, 0, 0), c(112, 112, 180), c(138, 138, 220), c(160, 160, 255), c(84, 84, 135), c(117, 117, 117), c(144, 144, 144), c(167, 167, 167), c(88, 88, 88), c(0, 87, 0), c(0, 106, 0), c(0, 124, 0), c(0, 65, 0), c(180, 180, 180), c(220, 220, 220), c(255, 255, 255), c(135, 135, 135), c(115, 118, 129), c(141, 144, 158), c(164, 168, 184), c(86, 88, 97), c(129, 74, 33), c(157, 91, 40), c(183, 106, 47), c(96, 56, 24), c(79, 79, 79), c(96, 96, 96), c(112, 112, 112), c(59, 59, 59), c(45, 45, 180), c(55, 55, 220), c(64, 64, 255), c(33, 33, 135), c(73, 58, 35), c(89, 71, 43), c(104, 83, 50), c(55, 43, 26), c(180, 177, 172), c(220, 217, 211), c(255, 252, 245), c(135, 133, 129), c(152, 89, 36), c(186, 109, 44), c(216, 127, 51), c(114, 67, 27), c(125, 53, 152), c(153, 65, 186), c(178, 76, 216), c(94, 40, 114), c(72, 108, 152), c(88, 132, 186), c(102, 153, 216), c(54, 81, 114), c(161, 161, 36), c(197, 197, 44), c(229, 229, 51), c(121, 121, 27), c(89, 144, 17), c(109, 176, 21), c(127, 204, 25), c(67, 108, 13), c(170, 89, 116), c(208, 109, 142), c(242, 127, 165), c(128, 67, 87), c(53, 53, 53), c(65, 65, 65), c(76, 76, 76), c(40, 40, 40), c(108, 108, 108), c(132, 132, 132), c(153, 153, 153), c(81, 81, 81), c(53, 89, 108), c(65, 109, 132), c(76, 127, 153), c(40, 67, 81), c(89, 44, 125), c(109, 54, 153), c(127, 63, 178), c(67, 33, 94), c(36, 53, 125), c(44, 65, 153), c(51, 76, 178), c(27, 40, 94), c(72, 53, 36), c(88, 65, 44), c(102, 76, 51), c(54, 40, 27), c(72, 89, 36), c(88, 109, 44), c(102, 127, 51), c(54, 67, 27), c(108, 36, 36), c(132, 44, 44), c(153, 51, 51), c(81, 27, 27), c(17, 17, 17), c(21, 21, 21), c(25, 25, 25), c(13, 13, 13), c(176, 168, 54), c(215, 205, 66), c(250, 238, 77), c(132, 126, 40), c(64, 154, 150), c(79, 188, 183), c(92, 219, 213), c(48, 115, 112), c(52, 90, 180), c(63, 110, 220), c(74, 128, 255), c(39, 67, 135), c(0, 153, 40), c(0, 187, 50), c(0, 217, 58), c(0, 114, 30), c(14, 14, 21), c(18, 17, 26), c(21, 20, 31), c(11, 10, 16), c(79, 1, 0), c(96, 1, 0), c(112, 2, 0), c(59, 1, 0)};
    /** @deprecated */
    @Deprecated
    public static final byte TRANSPARENT = 0;
    /** @deprecated */
    @Deprecated
    public static final byte LIGHT_GREEN = 4;
    /** @deprecated */
    @Deprecated
    public static final byte LIGHT_BROWN = 8;
    /** @deprecated */
    @Deprecated
    public static final byte GRAY_1 = 12;
    /** @deprecated */
    @Deprecated
    public static final byte RED = 16;
    /** @deprecated */
    @Deprecated
    public static final byte PALE_BLUE = 20;
    /** @deprecated */
    @Deprecated
    public static final byte GRAY_2 = 24;
    /** @deprecated */
    @Deprecated
    public static final byte DARK_GREEN = 28;
    /** @deprecated */
    @Deprecated
    public static final byte WHITE = 32;
    /** @deprecated */
    @Deprecated
    public static final byte LIGHT_GRAY = 36;
    /** @deprecated */
    @Deprecated
    public static final byte BROWN = 40;
    /** @deprecated */
    @Deprecated
    public static final byte DARK_GRAY = 44;
    /** @deprecated */
    @Deprecated
    public static final byte BLUE = 48;
    /** @deprecated */
    @Deprecated
    public static final byte DARK_BROWN = 52;

    private static Color c(int r, int g, int b) {
        return new Color(r, g, b);
    }

    private static double getDistance(Color c1, Color c2) {
        double rmean = (double) (c1.getRed() + c2.getRed()) / 2.0D;
        double r = (double) (c1.getRed() - c2.getRed());
        double g = (double) (c1.getGreen() - c2.getGreen());
        int b = c1.getBlue() - c2.getBlue();
        double weightR = 2.0D + rmean / 256.0D;
        double weightG = 4.0D;
        double weightB = 2.0D + (255.0D - rmean) / 256.0D;

        return weightR * r * r + weightG * g * g + weightB * (double) b * (double) b;
    }

    public static BufferedImage resizeImage(Image image) {
        BufferedImage result = new BufferedImage(128, 128, 2);
        Graphics2D graphics = result.createGraphics();

        graphics.drawImage(image, 0, 0, 128, 128, (ImageObserver) null);
        graphics.dispose();
        return result;
    }

    /** @deprecated */
    @Deprecated
    public static byte[] imageToBytes(Image image) {
        BufferedImage temp = new BufferedImage(image.getWidth((ImageObserver) null), image.getHeight((ImageObserver) null), 2);
        Graphics2D graphics = temp.createGraphics();

        graphics.drawImage(image, 0, 0, (ImageObserver) null);
        graphics.dispose();
        int[] pixels = new int[temp.getWidth() * temp.getHeight()];

        temp.getRGB(0, 0, temp.getWidth(), temp.getHeight(), pixels, 0, temp.getWidth());
        byte[] result = new byte[temp.getWidth() * temp.getHeight()];

        for (int i = 0; i < pixels.length; ++i) {
            result[i] = matchColor(new Color(pixels[i], true));
        }

        return result;
    }

    /** @deprecated */
    @Deprecated
    public static byte matchColor(int r, int g, int b) {
        return matchColor(new Color(r, g, b));
    }

    /** @deprecated */
    @Deprecated
    public static byte matchColor(Color color) {
        if (color.getAlpha() < 128) {
            return (byte) 0;
        } else {
            int index = 0;
            double best = -1.0D;

            for (int i = 4; i < MapPalette.colors.length; ++i) {
                double distance = getDistance(color, MapPalette.colors[i]);

                if (distance < best || best == -1.0D) {
                    best = distance;
                    index = i;
                }
            }

            return (byte) (index < 128 ? index : -129 + (index - 127));
        }
    }

    /** @deprecated */
    @Deprecated
    public static Color getColor(byte index) {
        if ((index <= -113 || index >= 0) && index <= 127) {
            return MapPalette.colors[index >= 0 ? index : index + 256];
        } else {
            throw new IndexOutOfBoundsException();
        }
    }
}
