package fr.lacombe.bank.date;

import junitparams.JUnitParamsRunner;
import org.junit.Before;
import org.junit.Rule;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.rule.PowerMockRule;

@RunWith(JUnitParamsRunner.class)
@PrepareForTest(Date.class)
public abstract class AbstractDateMockTest {
    @Rule
    public PowerMockRule rule = new PowerMockRule();

    protected void mockDateUtilToReturn(int year, int month, int day) {
        PowerMockito.when(Date.today()).thenReturn(new Date(year, month, day));
    }

    @Before
    public void mockDateUtilClass() {
        PowerMockito.mockStatic(Date.class);
    }
}
