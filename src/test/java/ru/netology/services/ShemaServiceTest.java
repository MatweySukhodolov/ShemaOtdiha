package ru.netology.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

public class ShemaServiceTest {

    @ParameterizedTest
    @CsvSource({
            "3,10000,3000,20000",
            "2,100000,60000,150000"
    })
    @CsvFileSource(files = "src/test/resources/ShemaOtdiha.csv")
    public void shouldCalculateMoneyMonths1(int income, int expenses, int threshold, int expected) {
        ShemaService service = new ShemaService();
        // int income = 10000; // месячный доход
        // int expenses = 3000; // ежемесячные обязательные траты
        // int threshold = 20000; // сумма, при которой можно отдохнуть
        // int expected = 3;

        int actual = service.calculate(income, expenses);

        Assertions.assertEquals(expected, actual, threshold);
    }

//    @Test
//    public void shouldCalculateMoneyMonths2() {
//        ShemaService service = new ShemaService();
//        int income = 100000; // месячный доход
//        int expenses = 60000; // ежемесячные обязательные траты
//        int threshold = 150000; // сумма, при которой можно отдохнуть
//        int expected = 2;
//
//        int actual = service.calculate(income, expenses);
//
//        Assertions.assertEquals(expected, actual, threshold);
//    }


}
