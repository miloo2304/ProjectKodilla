package com.kodilla.stream.TESTS.WholeWorld;

import com.kodilla.stream.Project_7_4.WholeWorld.Continent;
import com.kodilla.stream.Project_7_4.WholeWorld.Country;
import com.kodilla.stream.Project_7_4.WholeWorld.World;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

public class WholeWorldTestSuite {

    @Test //Without using Mockito's library
    public void testGetPeopleQuantity() {
        //Europe
        Country Poland = new Country("Poland", new BigDecimal("37636508"));
        Country Germany = new Country("Germany", new BigDecimal("84358845"));
        Country France = new Country("France", new BigDecimal("68373433"));
        Country England = new Country("England", new BigDecimal("56286961"));
        Country Italy = new Country("Italy", new BigDecimal("58850717"));
        //America North
        Country USA = new Country("USA", new BigDecimal("332403650"));
        Country Canada = new Country("Canada", new BigDecimal("38721000"));
        Country Mexico = new Country("Mexico", new BigDecimal("128600000"));
        Country Jamaica = new Country("Jamaica", new BigDecimal("2844000"));
        Country Guatemala = new Country("Guatemala", new BigDecimal("16919000"));
        //America South
        Country Peru = new Country("USA", new BigDecimal("33036196"));
        Country Argentina = new Country("Canada", new BigDecimal("45864941"));
        Country Brazil = new Country("Mexico", new BigDecimal("217240060"));
        Country Venezuela = new Country("Jamaica", new BigDecimal("30518260"));
        Country Chile = new Country("Guatemala", new BigDecimal("18549457"));
        //Africa
        Country Nigeria = new Country("Nigeria", new BigDecimal("219463862"));
        Country Kenya = new Country("Kenya", new BigDecimal("52444000"));
        Country Egypt = new Country("Egypt", new BigDecimal("106437241"));
        Country RSA = new Country("RSA", new BigDecimal("56978635"));
        Country Madagascar = new Country("Madagascar", new BigDecimal("25613000"));
        //Asia
        Country Japan = new Country("Japan", new BigDecimal("124090000"));
        Country China = new Country("China", new BigDecimal("1411778724"));
        Country KoreaNorth = new Country("KoreaNorth", new BigDecimal("26498823"));
        Country KoreaSouth = new Country("KoreaSouth", new BigDecimal("52646000"));
        Country Taiwan = new Country("Taiwan", new BigDecimal("23140000"));
        //Continents
        Continent Europe = new Continent("Europe", Arrays.asList(Poland, Germany, France, England, Italy));
        Continent AmericaNorth = new Continent("America North", Arrays.asList(USA, Canada, Mexico, Jamaica, Guatemala));
        Continent AmericaSouth = new Continent("America South", Arrays.asList(Peru, Argentina, Brazil, Venezuela, Chile));
        Continent Africa = new Continent("Africa", Arrays.asList(Nigeria, Kenya, Egypt, RSA, Madagascar));
        Continent Asia = new Continent("Asia", Arrays.asList(Japan, China, KoreaNorth, KoreaSouth, Taiwan));
        //World
        World world = new World(Arrays.asList(Europe,AmericaNorth,AmericaSouth, Africa, Asia));

        BigDecimal expectedPeopleQuantity = new BigDecimal("3269293313");
        assertEquals(expectedPeopleQuantity, world.getPeopleQuantity());
    }
}