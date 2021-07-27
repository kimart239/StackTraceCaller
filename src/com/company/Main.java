package com.company;

public class Main {

    public static void main(String[] args) {
        System.out.println(getCallerClassAndMethodName());
        anotherMethod();
    }

    private static void anotherMethod() {
        System.out.println(getCallerClassAndMethodName());
    }

    public static String getCallerClassAndMethodName() {



        /*
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
         //st[0] это то, что был вызван сам getStackTrace,
         //st[1] то что был вызван currentThread(),
         //st[2] - тот метод выяснить у которого нам надо откуда вызван,
         //st[3]  то, что нам нужно
        String message = "";
        System.out.println(stackTraceElements.length);
        if(stackTraceElements.length >= 3) {
            StackTraceElement element = stackTraceElements[stackTraceElements.length-1];
            String className = element.getClassName();
            String methodName = element.getMethodName();
            message = className + "# " + methodName;
            return message;
        }
        else
            return null;

         */
        if (Thread.currentThread().getStackTrace().length > 3) {//условие, что вызвали из точки входа
            return Thread.currentThread().getStackTrace()[3].getClassName() + "#" + Thread.currentThread().getStackTrace()[3].getMethodName();
        }
        return null;
    }
}
