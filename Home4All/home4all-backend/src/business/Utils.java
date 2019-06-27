package business;

import com.hierynomus.msdtyp.AccessMask;
import com.hierynomus.mssmb2.SMB2CreateDisposition;
import com.hierynomus.mssmb2.SMB2ShareAccess;
import com.hierynomus.smbj.SMBClient;
import com.hierynomus.smbj.auth.AuthenticationContext;
import com.hierynomus.smbj.connection.Connection;
import com.hierynomus.smbj.session.Session;
import com.hierynomus.smbj.share.DiskShare;
import com.hierynomus.smbj.share.File;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;

public class Utils {
    private static final String shared_host = "192.168.100.225";
    private static final String shared_path = "images";
    private static final String shared_username = "ProjetoEA";
    private static final char[] shared_password = "ProjetoEA".toCharArray();
    private static final AuthenticationContext ac = new AuthenticationContext(shared_username, shared_password, "");


    // Trocar '_' final nos métodos para funcionar remotamente
    public static List<String> getImages(List<String> filenames) throws IOException {
        List<String> images = new ArrayList<>();

        for (String filename: filenames) {
            java.io.File file = new java.io.File("images" + java.io.File.separator + filename);
            byte[] bytes = Files.readAllBytes(file.toPath());
            images.add(new String(bytes));
        }
        return images;
    }

    public static void deleteImages(List<String> filenames) {
        List<String> images = new ArrayList<>();

        for (String filename: filenames) {
            java.io.File file = new java.io.File("images" + java.io.File.separator + filename);
            file.delete();
        }
    }


    public static void saveImages(Map<String, String> filenames_images) throws IOException {

        for (Map.Entry<String, String> filename_image : filenames_images.entrySet()) {
            Path file = Paths.get("images" + java.io.File.separator + filename_image.getKey());
            Files.write(file, filename_image.getValue().getBytes());
        }
    }



    public static List<String> getImages_(List<String> filenames) {
        List<String> images = new ArrayList<>();
        SMBClient client = new SMBClient();

        try (Connection connection = client.connect(shared_host)) {
            Session session = connection.authenticate(ac);
            File file;
            InputStream is;
            BufferedReader bufferedReader;
            String row;
            StringBuilder image;

            // Connect to Share
            try (DiskShare share = (DiskShare) session.connectShare(shared_path)) {
                for (String filename : filenames) {
                    file = share.openFile(filename, EnumSet.of(AccessMask.GENERIC_READ), null,
                            SMB2ShareAccess.ALL, SMB2CreateDisposition.FILE_OPEN, null);
                    is = file.getInputStream();
                    bufferedReader = new BufferedReader(new InputStreamReader(is));
                    row = bufferedReader.readLine();
                    image = new StringBuilder(row);
                    while (row != null) {
                        row = bufferedReader.readLine();
                        if (row != null)
                            image.append(row);
                    }
                    images.add(image.toString());
                    file.close();
                }
            }
            session.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return images;
    }

    public static void deleteImages_(List<String> filenames) {
        SMBClient client = new SMBClient();

        try (Connection connection = client.connect(shared_host)) {
            Session session = connection.authenticate(ac);

            // Connect to Share
            try (DiskShare share = (DiskShare) session.connectShare(shared_path)) {
                for (String filename : filenames) {
                    share.rm(filename);
                }
            }
            session.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void saveImages_(Map<String, String> filenames_images) {
        SMBClient client = new SMBClient();

        try (Connection connection = client.connect(shared_host)) {
            Session session = connection.authenticate(ac);
            File file;

            // Connect to Share
            try (DiskShare share = (DiskShare) session.connectShare(shared_path)) {
                for (Map.Entry<String, String> filename_image : filenames_images.entrySet()) {
                    file = share.openFile(filename_image.getKey(), EnumSet.of(AccessMask.GENERIC_WRITE), null,
                            SMB2ShareAccess.ALL, SMB2CreateDisposition.FILE_OVERWRITE_IF, null);
                    OutputStream oStream = file.getOutputStream();
                    oStream.write(filename_image.getValue().getBytes());
                    oStream.flush();
                    oStream.close();
                }
            }
            session.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static String hash(String original) {
        String res = original;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(original.getBytes("UTF-8")); // Change this to "UTF-16" if needed
            byte[] digest = md.digest();
            res = String.format("%064x", new java.math.BigInteger(1, digest));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }
}
