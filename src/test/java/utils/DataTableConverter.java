package utils;

import io.cucumber.datatable.DataTable;

import java.util.List;
import java.util.Map;

public class DataTableConverter {

    public static List<Map<String, String>> getConvertedDataTable(DataTable dataTable) {
        return dataTable.asMaps(String.class, String.class);
    }
}
