package com.application.app.Common;

public final class CommonConstants {
    public final class APIPathMapping {

		public static final String APIV1 = "/api";
        public static final String Books = "/api/books";
        public static final String Patrons = "/api/patrons";
        public static final String GetById = "/{id}";
        public static final String BorrowingRecord = "/api/borrow/{bookId}/patron/{patronId}";
        public static final String ReturningRecord = "/api/return/{bookId}/patron/{patronId}";
    }
    public final class BookStatus {

		public static final int borrowed = 1;
        public static final int returned = 2;
    }
}
