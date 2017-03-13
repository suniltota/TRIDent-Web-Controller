package com.actualize.mortgage.sercurity;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

@SuppressWarnings("unchecked")
public class StringUtil {
    
    public static String join(Collection values, String separator) {
        return join(values.toArray(), separator);
    }


    public static String join(Object[] values, String separator) {
        StringBuffer buffer = null;

        for (Object value : values) {
            if (buffer == null) {
                buffer = new StringBuffer(String.valueOf(value));
            } else {
                buffer.append(separator);
                buffer.append(value);
            }
        }

        return buffer == null ? "" : buffer.toString();
    }
    
    public static String stringJoin(Collection values, String seperator) {
        Collection newVals = new ArrayList();
        for(Object value : values) {
                newVals.add("'" + String.valueOf(value) + "'");
        }
        return join(newVals.toArray(), seperator);
    }

    public static String join(Object[][] values, int column, String separator) {
        StringBuffer buffer = null;

        for (Object[] value : values) {
            if (buffer == null) {
                buffer = new StringBuffer(String.valueOf(value[column]));
            } else {
                buffer.append(separator);
                buffer.append(value[column]);
            }
        }

        return buffer == null ? "" : buffer.toString();
    }

    public static String join(Collection values, String separator, String before, String after) {
        return join(values.toArray(), separator, before, after);
    }

    public static String join(Object[] values, String separator, String before, String after) {
        StringBuffer buffer = null;

        for (Object value : values) {
            if (buffer == null) {
                buffer = new StringBuffer(before);
                buffer.append(value);
                buffer.append(after);
            } else {
                buffer.append(separator);
                buffer.append(before);
                buffer.append(value);
                buffer.append(after);
            }
        }

        return buffer == null ? "" : buffer.toString();
    }

    public static String join(final Map values, final String entrySeparator, final String keyAndValueSeparator)
    {
        return join(values.entrySet(), entrySeparator, keyAndValueSeparator);
    }

    public static String join(final Iterable<Map.Entry> valueIterable, final String entrySeparator, final String keyAndValueSeparator)
    {
        final StringBuilder stringBuilder = new StringBuilder();

        final Iterator<Map.Entry> iter = valueIterable.iterator();

        while (iter.hasNext())
        {
            final Map.Entry entry = iter.next();
            if (entry.getKey()!=null)
                stringBuilder.append(entry.getKey());

            if (keyAndValueSeparator!=null)
            {
                stringBuilder.append(keyAndValueSeparator);
            }

            if (entry.getValue()!=null)
                stringBuilder.append(entry.getValue());

            if (iter.hasNext() && entrySeparator!=null)
                stringBuilder.append(entrySeparator);
        }

        return stringBuilder.toString();
    }

    /**
     * Removes all whitespace, as adjudicated by {@link java.lang.Character#isWhitespace(char)}
     * (i.e. spaces, non-breaking spaces, newlines, etc.)
     */
    public static String stripWhitespaceFrom(final CharSequence charSequence)
    {
        if (charSequence==null)
            return null;

        final StringBuffer stripped = new StringBuffer();

        for (int i=0; i<charSequence.length(); i++)
        {
            final char theChar = charSequence.charAt(i);
            if (!Character.isWhitespace(theChar))
                stripped.append(theChar);
        }

        return stripped.toString();
    }

    /**
     * <p>Replaces all contiguous whitespace characters with a single space.
     *
     * <pre>
     * StringUtil.normalizeWs(null)      = null
     * StringUtil.normalizeWs("")        = ""
     * StringUtil.normalizeWs(" ")       = " "
     * StringUtil.normalizeWs("     ")   = " "
     * StringUtil.normalizeWs(" \t \n ") = " "
     * </pre>
     */
    public static String normalizeWs(String input) {
        if(null == input) {
            return null;
        }

        String cleaned = input.replaceAll("\\s+", " ");
        return cleaned;
    }

    /**
     * Calls normalizeWs on the String returned by calling toString on the
     * Statement.
     * Purportedly, most SQL drivers implement toString on Statements to return
     * the SQL to be executed.
     */
    public static String normalizeWs(Statement stmt) {
        if (null == stmt) {
            return null;
        }
        String stmtStr = stmt.toString();
        String result = normalizeWs(stmtStr);
        return result;
    }
}
