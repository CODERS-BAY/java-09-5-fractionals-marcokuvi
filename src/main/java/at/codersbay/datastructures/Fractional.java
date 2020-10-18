package at.codersbay.datastructures;

/**
 * A Fractional is a class that consists of a numerator and a denominator
 * e.g.: 1/2, 1/3, 24/37, ..
 */
public class Fractional {

    private Integer numerator;
    private Integer denominator;

    public Fractional(Integer numerator, Integer denominator) {
        if (numerator == null || denominator == null) {
            throw new IllegalArgumentException("You shall not pass null!");
        } else if (denominator == 0) {
            throw new IllegalArgumentException("You shall not divide through zero!");
        } else {
            this.numerator = numerator;
            this.denominator = denominator;
        }

    }

    public Integer getNumerator() {
        return numerator;
    }

    public Integer getDenominator() {
        return denominator;
    }

    public Float asFloat() {

        Float newNumerator = numerator.floatValue();
        Float newDenominator = denominator.floatValue();
        Float resultOfFraction = newNumerator / newDenominator;

        return resultOfFraction;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Fractional)) {
            return false;
        }
        Fractional fraction = ((Fractional) obj);
        Integer greatestCommonDivisor = MathClass.searchForGreatestCommonDivisor(numerator, denominator);
        fraction.reduce();
        if (this.numerator / greatestCommonDivisor == fraction.numerator && this.denominator / greatestCommonDivisor == fraction.denominator) {
            return true;
        } else {
            return false;
        }
    }

    public Fractional reduce() {
        Integer greatestCommonDivisor = MathClass.searchForGreatestCommonDivisor(numerator, denominator);
        numerator = numerator / greatestCommonDivisor;
        denominator = denominator / greatestCommonDivisor;
        return this;
    }

    public Fractional multiply(Fractional other) {
        return new Fractional(this.numerator * other.numerator, this.denominator * other.denominator);
    }

    public Fractional multiply(Integer other) {
        if (other == 0) {
            return new Fractional(0, this.denominator);
        } else if (other == 1) {
            return new Fractional(this.numerator * other, this.denominator * other);
        }
        return new Fractional((this.numerator * other / MathClass.searchForGreatestCommonDivisor(numerator, other)), (this.denominator * other / MathClass.searchForGreatestCommonDivisor(denominator, other)));
    }

    public Fractional divide(Fractional other) {
        return new Fractional(this.numerator * other.denominator, this.denominator * other.numerator);
    }

    public Fractional divide(Integer other) {
        if (other == 0) {
            throw new IllegalArgumentException("You cannot divide through zero!");
        } else if (other == 1) {
            return new Fractional(1, this.denominator * other);
        } else {
            return new Fractional(this.numerator, this.denominator * other);
        }
    }

    public Fractional add(Fractional other) {
        return new Fractional((this.numerator * other.denominator) + (this.denominator * other.numerator), this.denominator * other.denominator);
    }

    public Fractional add(Integer other) {
        return new Fractional((this.numerator) + (this.denominator * other), denominator);
    }

    public Fractional subtract(Fractional other) {
        return new Fractional((this.numerator * other.denominator) - (this.denominator * other.numerator), this.denominator * other.denominator);
    }

    public Fractional subtract(Integer other) {
        return new Fractional((this.numerator) - (this.denominator * other), denominator);
    }

}