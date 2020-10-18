package at.codersbay.datastructures;

public class MathClass {
    public static Integer searchForGreatestCommonDivisor(Integer firstInteger, Integer secondInteger) {
        if (firstInteger < 0) {
            firstInteger = -1 * firstInteger;
        }
        if (secondInteger < 0) {
            secondInteger = -1 * secondInteger;
        }
        Integer thirdInteger;
        while (secondInteger != 0) {
            thirdInteger = secondInteger;
            secondInteger = firstInteger % secondInteger;
            firstInteger = thirdInteger;
        }
        return firstInteger;
    }
}
