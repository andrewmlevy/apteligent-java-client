package com.apteligent.display;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

/**
 * Created by levy on 7/19/16.
 */
public class StacktraceLine {
    @JsonProperty("line_number")
    private int lineNumber = 0;

    private int suspect;

    private String trace;

    public String getLine() {
        return this.trace;
    }

    // NOTE: This is NOT the line number of the code in the stacktrace
    // this is the literal numbering of the stracktrace when it gets printed out
    // so lineNumber 1 is the first line in the stracktrace, followed by lineNumber 2, etc.
    public int getLineNumber() {
        return this.lineNumber;
    }

    boolean isSuspectCrashLine() {
        return (suspect == 1);
    }

    public static String formatStacktraceString(ArrayList<StacktraceLine> lines) {
        return StacktraceLine.formatStacktraceString(lines, false);
    }
    public static String formatStacktraceString(ArrayList<StacktraceLine> lines, boolean includeLineNumbers) {
        String stacktrace = "";
        if(lines != null) {
            for (StacktraceLine line : lines) {
                if (!stacktrace.equals("")) {
                    stacktrace += "\n";
                }
                if(includeLineNumbers) {
                    stacktrace += line.getLineNumber() + ". ";
                }
                stacktrace += line.getLine();
            }
        }
        return stacktrace;
    }

    public static void printStacktrace(ArrayList<StacktraceLine> lines) {
        StacktraceLine.printStacktrace(lines, false);
    }

    public static void printStacktrace(ArrayList<StacktraceLine> lines, boolean includeLineNumbers) {
        System.out.println(StacktraceLine.formatStacktraceString(lines, includeLineNumbers));
    }
}