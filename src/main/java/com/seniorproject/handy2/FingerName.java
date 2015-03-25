package com.seniorproject.handy2;

/**
 *
 * @author casanovatoy
 */
public enum FingerName {

    LITTLE, RING, MIDDLE, INDEX, THUMB,
    UNKNOWN;

    public FingerName getNext() {
        int nextIdx = ordinal() + 1;
        if (nextIdx == (values().length)) {
            nextIdx = 0;
        }
        return values()[nextIdx];
    }

    public FingerName getPrev() {
        int prevIdx = ordinal() - 1;
        if (prevIdx < 0) {
            prevIdx = values().length - 1;
        }
        return values()[prevIdx];
    }

}
