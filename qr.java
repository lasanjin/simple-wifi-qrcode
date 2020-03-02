import static java.lang.String.format;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;

public class qr {

    public static void main(String[] args) {
        if (args.length == 2) {
            try {
                generateQRCode(args[0], args[1]);

            } catch (IOException e) {
                System.out.println("IOException: " + e.getMessage());

            } catch (WriterException e) {
                System.out.println("WriterException: " + e.getMessage());
            }
        }
    }

    /**
     * Generates png file of QRCode for Wi-Fi.
     * 
     * @param ssid  The name of the Wi-Fi
     * @param passw Password of the Wi-Fi.
     * @throws IOException
     * @throws WriterException
     */
    public static void generateQRCode(String ssid, String passw) throws IOException, WriterException {
        /** Format of what the barcode encodes */
        String encoding = "WIFI:S:%s;T:WPA;P:%s;;";
        /** Encode the passw string if it contains unusual characters */
        encoding = format(encoding, ssid, passw);

        MultiFormatWriter writer = new MultiFormatWriter();
        BitMatrix matrix = writer.encode(encoding, BarcodeFormat.QR_CODE, 1600, 1600);
        Path path = Paths.get("qrcode.png");

        MatrixToImageWriter.writeToPath(matrix, "png", path);
    }

}