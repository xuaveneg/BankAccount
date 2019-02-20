package fr.lacombe.bank.date;

public class DateGeneratorFake implements DateGenerator {
    private Date[] dates;
    private int dateIndex;

    public DateGeneratorFake(Date... dates) {

        this.dates = dates;
    }

    @Override
    public Date today() {
        return dates[dateIndex++ % dates.length];
    }
}
