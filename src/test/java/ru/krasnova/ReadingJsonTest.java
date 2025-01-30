package ru.krasnova;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.krasnova.model.SaleBrands;

import java.io.File;

public class ReadingJsonTest {

    @Test
    void readingJsonTest() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        SaleBrands saleBrands = objectMapper.readValue(new File("/Users/ilvera/IdeaProjects/qa_guru_files/src/test/resources/salebrands.json"), SaleBrands.class);
        Assertions.assertEquals("Распродажа товаров для гигиены полости рта", saleBrands.getConditions());
        Assertions.assertEquals("2020-06-05", saleBrands.getDateStart());
        Assertions.assertEquals("2020-06-12", saleBrands.getDateEnd());
        Assertions.assertEquals(1234, saleBrands.getId());
        Assertions.assertTrue(saleBrands.isMain());
        Assertions.assertEquals(3, saleBrands.getBrands().size());
        Assertions.assertTrue(saleBrands.getBrands().contains("splat"));
        Assertions.assertTrue(saleBrands.getBrands().contains("curaprox"));
        Assertions.assertTrue(saleBrands.getBrands().contains("sensodyne"));

        }
}
