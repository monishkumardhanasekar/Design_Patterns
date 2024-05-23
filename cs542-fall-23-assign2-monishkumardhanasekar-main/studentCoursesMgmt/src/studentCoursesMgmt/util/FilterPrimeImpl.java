package studentCoursesMgmt.util;

public class FilterPrimeImpl implements  Filter{

    private PrimeUtil primeUtil;

    public FilterPrimeImpl() {
        this.primeUtil = new PrimeUtil();
    }

    @Override
    public boolean check(int value) {
        return primeUtil.isPrime(value);
    }
}
