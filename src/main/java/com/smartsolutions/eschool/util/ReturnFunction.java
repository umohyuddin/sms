package com.smartsolutions.eschool.util;

public interface ReturnFunction<I, O> {
	O getObject(I input);
}
