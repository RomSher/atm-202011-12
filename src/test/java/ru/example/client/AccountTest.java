package ru.example.client;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.time.LocalDate;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
class AccountTest {

    private static Validator validator;

    @BeforeAll
    public static void setUpValidator() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();

        //for example not for prod
        log.info("hello");
    }

    @Test
    void getCardPan(){
        Account card = new Account( "0000000000000000", LocalDate.of(2020,11,30), "1234");

        Set<ConstraintViolation<Account>> constraintViolations =
                validator.validate( card );

        assertEquals( 1, constraintViolations.size() );
        assertEquals( "Card number cannot be null", constraintViolations.iterator().next().getMessage());
    }

    @Test
    void getCardExp(){
        Account card = new Account( "0000000000000000",LocalDate.of(2020,11,30), "1234");

        Set<ConstraintViolation<Account>> constraintViolations =
                validator.validate( card );

        assertEquals( 1, constraintViolations.size() );
        assertEquals( "Data expiration cannot be null", constraintViolations.iterator().next().getMessage());
    }

    @Test
    void getCardPin(){
        Account card = new Account( "0000000000000000",LocalDate.of(2020,11,30), "1244");

        Set<ConstraintViolation<Account>> constraintViolations =
                validator.validate( card );

        assertEquals( 2, constraintViolations.size() );
        assertEquals( "Pin cannot be null", constraintViolations.iterator().next().getMessage());
    }
}
