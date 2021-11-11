package addressbooksystem;

import java.util.Comparator;

public enum SortOptions {
	    NAME(Comparator.comparing(PersonDetails::getFirstName)),
	    CITY(Comparator.comparing(PersonDetails::getCity)),
	    STATE(Comparator.comparing(PersonDetails::getState)),
	    ZIP(Comparator.comparing(PersonDetails::getZip));

	    public final Comparator<? super PersonDetails> comparator;

	    SortOptions(Comparator<? super PersonDetails> comparator) {
	        this.comparator = comparator;
	    }
}


