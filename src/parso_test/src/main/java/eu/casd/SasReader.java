package org.example;

import com.epam.parso.SasFileReader;
import com.epam.parso.impl.SasFileReaderImpl;

import java.io.FileInputStream;
import java.io.InputStream;

public class SasReader {
    public void readSasFile(String filePath) throws Exception {
        try (InputStream inputStream = new FileInputStream(filePath)) {
            SasFileReader sasFileReader = new SasFileReaderImpl(inputStream);
            Object[] row;
            while ((row = sasFileReader.readNext()) != null) {
                // Process the row data
            }
        }
    }

    public static void main(String [] args){
        String date_sample_file = "/mnt/hgfs/ubuntu_share/data_set/sas_sample/dates_binary.sas7bdat";
        SasReader reader = new SasReader();
        try {
            reader.readSasFile(date_sample_file);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}


