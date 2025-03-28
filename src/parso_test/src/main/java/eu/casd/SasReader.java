package eu.casd;

import com.epam.parso.Column;
import com.epam.parso.SasFileReader;
import com.epam.parso.impl.SasFileReaderImpl;
import com.epam.parso.SasFileProperties;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

public class SasReader {
    private SasFileReader sasFileReader;  // Declare instance variable
    private SasFileProperties props;      // Declare variable to hold properties

    public SasReader(String filePath) {
        try (InputStream inputStream = new FileInputStream(filePath)) {
            this.sasFileReader = new SasFileReaderImpl(inputStream);
        } catch (Exception e) {
            System.out.println("Error initializing SAS file reader: " + e.getMessage());
        }
    }

    public void readSasFileProperties() {
        if (this.sasFileReader != null) {
            props = this.sasFileReader.getSasFileProperties();
            System.out.println("SAS File Properties: " + props);
        } else {
            System.out.println("SAS file reader is not initialized.");
        }
    }

    public void getSasFileColumns() {
        List<Column> columns = this.sasFileReader.getColumns();
        for (Column column : columns) {
            System.out.println("Column name: "+ column.getName());
            System.out.println("Column type: "+ column.getType());
            System.out.println("Column format: "+column.getFormat().toString());
        }
    }

    public static void main(String[] args) {
        String dateSampleFile = "/mnt/hgfs/ubuntu_share/data_set/sas_sample/dates_binary.sas7bdat";
        SasReader reader = new SasReader(dateSampleFile);
        reader.getSasFileColumns();  // Corrected method call
    }
}