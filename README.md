## Simple Wi-Fi QR code generator
Outputs an png file with QR code for connecting to Wi-Fi (WPA) using [ZXing](https://github.com/zxing/zxing) with pre-built jar files downloaded from [Maven release repository](https://repo1.maven.org/maven2/com/google/zxing/).

### How to run
1. Execute [`run`](run)
   - Note: encode the passw string if it contains unusual characters.
```
$ chmod +x run && ./run <wifi-name> <wifi-password>
```
