package com.reactApp.step_definitions;

import org.monte.media.Format;
import org.monte.media.math.Rational;
import org.monte.screenrecorder.ScreenRecorder;

import java.awt.*;
import java.io.File;

import static org.monte.media.FormatKeys.*;
import static org.monte.media.VideoFormatKeys.*;

public class MyScreenRecorder {
    public static final String USER_DIR = "user.dir";
    public static final String DOWNLOADED_FILES_FOLDER = "ScreenRecorder";

    private static ScreenRecorder screenRecorder;
    public static void startRecording() throws Exception {
        File file = new File(System.getProperty(USER_DIR) + File.separator + DOWNLOADED_FILES_FOLDER);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = screenSize.width;
        int height = screenSize.height;

        Rectangle captureSize = new Rectangle(0, 0, width, height);

        GraphicsConfiguration gc = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration();

        //  public ScreenRecorder(GraphicsConfiguration cfg, Rectangle captureArea, Format fileFormat, Format screenFormat, Format mouseFormat, Format audioFormat, File movieFolder)

        screenRecorder=new ScreenRecorder(gc,captureSize, new Format(MediaTypeKey, MediaType.FILE, MimeTypeKey, MIME_QUICKTIME),
                new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, ENCODING_QUICKTIME_JPEG, CompressorNameKey,
                        ENCODING_QUICKTIME_JPEG, DepthKey, 24, FrameRateKey,Rational.valueOf(15), QualityKey, 1.0f, KeyFrameIntervalKey, 15 * 60),
                new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, "black", FrameRateKey, Rational.valueOf(30)), null,file);


      screenRecorder.start();

    }

    public static void stopRecording() throws Exception {
     screenRecorder.stop();
    }

}
