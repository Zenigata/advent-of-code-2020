package com.zeni;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class DayTest {
    @Test
    public void should_not_find_any_solution() {
        List<Integer> expenses = new ArrayList<>();
        expenses.add(500);
        expenses.add(1000);

        int result = Day.multiply(2000, expenses);
        assertEquals(0, result);
    }

    @Test
    public void should_find_a_basic_solution() {
        List<Integer> expenses = new ArrayList<>();
        expenses.add(520);
        expenses.add(1500);

        int result = Day.multiply(2020, expenses);
        assertEquals(780000, result);
    }

    @Test
    public void should_find_a_not_so_basic_solution() {
        List<Integer> expenses = new ArrayList<>();
        expenses.add(1721);
        expenses.add(979);
        expenses.add(366);
        expenses.add(299);
        expenses.add(675);
        expenses.add(1456);

        int result = Day.multiply(2020, expenses);
        assertEquals(514579, result);
    }

    @Test
    public void should_find_a_complex_solution() {
        List<Integer> expenses = new ArrayList<>();
        expenses.add(1945);
        expenses.add(2004);
        expenses.add(1520);
        expenses.add(1753);
        expenses.add(1463);
        expenses.add(1976);
        expenses.add(1994);
        expenses.add(1830);
        expenses.add(1942);
        expenses.add(1784);
        expenses.add(1858);
        expenses.add(1841);
        expenses.add(1721);
        expenses.add(1480);
        expenses.add(1821);
        expenses.add(1584);
        expenses.add(978);
        expenses.add(1530);
        expenses.add(1278);
        expenses.add(1827);
        expenses.add(889);
        expenses.add(1922);
        expenses.add(1996);
        expenses.add(1992);
        expenses.add(1819);
        expenses.add(1847);
        expenses.add(2010);
        expenses.add(2002);
        expenses.add(210);
        expenses.add(1924);
        expenses.add(1482);
        expenses.add(1451);
        expenses.add(1867);
        expenses.add(1364);
        expenses.add(1578);
        expenses.add(1623);
        expenses.add(1117);
        expenses.add(1594);
        expenses.add(1476);
        expenses.add(1879);
        expenses.add(1797);
        expenses.add(1952);
        expenses.add(2005);
        expenses.add(1734);
        expenses.add(1898);
        expenses.add(1880);
        expenses.add(1330);
        expenses.add(1854);
        expenses.add(1813);
        expenses.add(1926);
        expenses.add(1686);
        expenses.add(1286);
        expenses.add(1808);
        expenses.add(1876);
        expenses.add(1366);
        expenses.add(1995);
        expenses.add(1632);
        expenses.add(1699);
        expenses.add(2001);
        expenses.add(1365);
        expenses.add(1343);
        expenses.add(1979);
        expenses.add(1868);
        expenses.add(1815);
        expenses.add(820);
        expenses.add(1966);
        expenses.add(1888);
        expenses.add(1916);
        expenses.add(1852);
        expenses.add(1932);
        expenses.add(1368);
        expenses.add(1606);
        expenses.add(1825);
        expenses.add(1731);
        expenses.add(1980);
        expenses.add(1990);
        expenses.add(1818);
        expenses.add(1702);
        expenses.add(1419);
        expenses.add(1897);
        expenses.add(1970);
        expenses.add(1276);
        expenses.add(1914);
        expenses.add(1889);
        expenses.add(1953);
        expenses.add(1588);
        expenses.add(1958);
        expenses.add(1310);
        expenses.add(1391);
        expenses.add(1326);
        expenses.add(1131);
        expenses.add(1959);
        expenses.add(1844);
        expenses.add(1307);
        expenses.add(1998);
        expenses.add(1961);
        expenses.add(1708);
        expenses.add(1977);
        expenses.add(1886);
        expenses.add(1946);
        expenses.add(1516);
        expenses.add(1999);
        expenses.add(1859);
        expenses.add(1931);
        expenses.add(1853);
        expenses.add(1265);
        expenses.add(1869);
        expenses.add(1642);
        expenses.add(1740);
        expenses.add(1467);
        expenses.add(1944);
        expenses.add(1956);
        expenses.add(1263);
        expenses.add(1940);
        expenses.add(1912);
        expenses.add(1832);
        expenses.add(1872);
        expenses.add(1678);
        expenses.add(1319);
        expenses.add(1839);
        expenses.add(1689);
        expenses.add(1765);
        expenses.add(1894);
        expenses.add(1242);
        expenses.add(1983);
        expenses.add(1410);
        expenses.add(1985);
        expenses.add(1387);
        expenses.add(1022);
        expenses.add(1358);
        expenses.add(860);
        expenses.add(112);
        expenses.add(1964);
        expenses.add(1836);
        expenses.add(1838);
        expenses.add(1285);
        expenses.add(1943);
        expenses.add(1718);
        expenses.add(1351);
        expenses.add(760);
        expenses.add(1925);
        expenses.add(1842);
        expenses.add(1921);
        expenses.add(1967);
        expenses.add(1822);
        expenses.add(1978);
        expenses.add(1837);
        expenses.add(1378);
        expenses.add(1618);
        expenses.add(1266);
        expenses.add(2003);
        expenses.add(1972);
        expenses.add(666);
        expenses.add(1321);
        expenses.add(1938);
        expenses.add(1616);
        expenses.add(1892);
        expenses.add(831);
        expenses.add(1865);
        expenses.add(1314);
        expenses.add(1571);
        expenses.add(1806);
        expenses.add(1225);
        expenses.add(1882);
        expenses.add(1454);
        expenses.add(1257);
        expenses.add(1381);
        expenses.add(1284);
        expenses.add(1907);
        expenses.add(1950);
        expenses.add(1887);
        expenses.add(1492);
        expenses.add(1934);
        expenses.add(1709);
        expenses.add(1315);
        expenses.add(1574);
        expenses.add(1794);
        expenses.add(1576);
        expenses.add(1883);
        expenses.add(1864);
        expenses.add(1981);
        expenses.add(1317);
        expenses.add(1397);
        expenses.add(1325);
        expenses.add(1620);
        expenses.add(1895);
        expenses.add(1485);
        expenses.add(1828);
        expenses.add(1803);
        expenses.add(1715);
        expenses.add(1374);
        expenses.add(1251);
        expenses.add(1460);
        expenses.add(1863);
        expenses.add(1581);
        expenses.add(1499);
        expenses.add(1933);
        expenses.add(1982);
        expenses.add(1809);
        expenses.add(1812);

        int result = Day.multiply(2020, expenses);
        assertEquals(1005459, result);
    }

    @Test
    public void should_find_a_not_so_basic_solution_for_three() {
        List<Integer> expenses = new ArrayList<>();
        expenses.add(1721);
        expenses.add(979);
        expenses.add(366);
        expenses.add(299);
        expenses.add(675);
        expenses.add(1456);

        int result = Day.multiplyThree(2020, expenses);
        assertEquals(241861950, result);
    }

    @Test
    public void should_find_a_complex_solution_for_three() throws URISyntaxException, IOException {

        URL url = Thread.currentThread().getContextClassLoader().getResource("day01/input.txt");
        Path path = Paths.get(url.toURI());
        List<String> lines = Files.readAllLines(path);

        List<Integer> expenses = new ArrayList<>();
        for (String s : lines)
            expenses.add(Integer.valueOf(s));

        int result = Day.multiplyThree(2020, expenses);
        assertEquals(92643264, result);
    }
}
