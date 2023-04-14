package com.cisco.execpt;
public class _Exception {

    public static void main(String[] args) {
        ApiInterface apiInterface = new ApiInterfaceImpl();
        try {
            apiInterface.getData();
        } catch (RuleException e) {
            e.printStackTrace();
        }

    }

}
